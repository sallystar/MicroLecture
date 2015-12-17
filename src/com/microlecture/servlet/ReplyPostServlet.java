package com.microlecture.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.microlecture.bean.PostBean;
import com.microlecture.bean.ReplyBean;
import com.microlecture.bean.VideoDiscussBean;
import com.microlecture.manager.JSONUtil;
import com.microlecture.manager.SQLReader;

/**
 * Servlet implementation class ReplyPostServlet
 */
@WebServlet("/ReplyPostServlet")
public class ReplyPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SQLReader reader;
	private boolean REPLY_FLAG = false;
	private boolean POST_FLAG = false;

	/**
	 * 
	 * @see HttpServlet#HttpServlet()
	 */
	public ReplyPostServlet() {
		super();
		// TODO Auto-generated constructor stub
		reader = new SQLReader();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// String json = request.get
		String replyJSON = request.getParameter("reply");
		String postJSON = request.getParameter("post");
		// ReplyBean bean = (ReplyBean) JSONUtil.JSONToBean(replyJSON,
		// ReplyBean.class);
		PrintWriter out = response.getWriter();
		if (replyJSON != null && !replyJSON.equals("")) {
			replyJSON = new String(replyJSON.getBytes("iso-8859-1"), "UTF-8");
			REPLY_FLAG = reader.replyInsert((ReplyBean) JSONUtil.JSONToBean(
					replyJSON, ReplyBean.class));
		}
		if (REPLY_FLAG)
			out.write("_seccess");
		else
			out.write("_fail");
		if (postJSON != null && !postJSON.equals("")) {
			postJSON = new String(postJSON.getBytes("iso-8859-1"), "UTF-8");
			POST_FLAG = reader.postInsert((VideoDiscussBean) JSONUtil
					.JSONToBean(postJSON, VideoDiscussBean.class));
		}
		if (POST_FLAG)
			out.write("_seccess");
		else
			out.write("_fail");

		out.flush();
		out.close();
		System.gc();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
