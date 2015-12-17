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
import com.microlecture.bean.CourseSourseBean;
import com.microlecture.manager.JSONUtil;
import com.microlecture.manager.SQLReader;

/**
 * Servlet implementation class CourseSourseServlet
 */
@WebServlet("/CourseSourseServlet")
public class CourseSourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SQLReader reader;
    private int courseId;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseSourseServlet() {
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
		ArrayList<CourseSourseBean> list = new ArrayList<CourseSourseBean>();
		list = reader.getResource(courseId);
		String str = new String();
		str = JSONUtil.beanToJSON(list);
		PrintWriter out = response.getWriter();
		out.write(str);
		out.flush();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//request.getRequestDispatcher("/WEB-INF/page/HomePageList.jsp").forward(
		//		request, response);
		doGet(request, response);
	}
}
