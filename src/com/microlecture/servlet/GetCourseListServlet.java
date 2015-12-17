package com.microlecture.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.microlecture.bean.CourseBean;
import com.microlecture.manager.JSONUtil;
import com.microlecture.manager.SQLReader;


/**
 * Servlet implementation class GetCourseListServlet
 */
@WebServlet("/GetCourseListServlet")
public class GetCourseListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SQLReader reader;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCourseListServlet() {
        super();
        reader = new SQLReader();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ArrayList<CourseBean> list =reader.getCourseList();
		PrintWriter out = response.getWriter();
		out.write(JSONUtil.beanToJSON(list));
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
