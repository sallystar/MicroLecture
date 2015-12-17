package com.microlecture.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.microlecture.bean.ChapterBean;
import com.microlecture.manager.JSONUtil;
import com.microlecture.manager.SQLReader;

/**
 * Servlet implementation class GetChapterServlet
 */
@WebServlet("/GetChapterServlet")
public class GetChapterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SQLReader reader; 
	private int courseId;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetChapterServlet() {
        super();
        // TODO Auto-generated constructor stub
        reader = new SQLReader();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		courseId = Integer.parseInt(request.getParameter("courseId"));
		ArrayList<ChapterBean> list = reader.getChapters(courseId);
		String json = JSONUtil.beanToJSON(list);
		PrintWriter out = response.getWriter();
		out.print(json);
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
