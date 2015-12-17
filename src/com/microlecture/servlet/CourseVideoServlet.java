package com.microlecture.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.microlecture.bean.CourseVideoBean;
import com.microlecture.bean.HomePageBean;
import com.microlecture.manager.SQLReader;

/**
 * Servlet implementation class CourseLectureServlet
 */
@WebServlet("/CourseLectureServlet")
public class CourseVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SQLReader reader;
    private int id;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseVideoServlet() {
        super();
        
        // TODO Auto-generated constructor stub
        reader = new SQLReader();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		id = Integer.parseInt(request.getParameter("id"));
		String type = request.getParameter("type");
		PrintWriter out = response.getWriter();
		String str = new String();
		Gson gson = new Gson();
		ArrayList<CourseVideoBean> list = new ArrayList<CourseVideoBean>();
		if(type!= null && type.equals("!swf"))
		list = reader.getCourseVideo(id);
		else if(type!= null && type.equals("swf")){
			list = reader.getCourseSWF(id);
		}
		str = gson.toJson(list,list.getClass());
		out.write(str);
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

}
