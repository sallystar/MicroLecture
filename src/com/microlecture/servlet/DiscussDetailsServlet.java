package com.microlecture.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.microlecture.bean.MentoringBean;
import com.microlecture.bean.PostBean;
import com.microlecture.bean.ReplyBean;
import com.microlecture.manager.JSONUtil;
import com.microlecture.manager.SQLReader;

/**
 * Servlet implementation class DiscussDetailsServlet
 */
@WebServlet("/DiscussDetailsServlet")
public class DiscussDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int id = 0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiscussDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		id = Integer.parseInt(request.getParameter("postId"));
		SQLReader reader = new SQLReader();
		PrintWriter out = response.getWriter();
		ArrayList<ReplyBean> list = new ArrayList<ReplyBean>();
		list = reader.getReply(id);
		String json =new Gson().toJson(list, list.getClass());
		System.out.println(json);
		out.write(json);
		out.flush();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		System.gc();
	}
	

}
