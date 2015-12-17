package com.microlecture.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.microlecture.bean.HomePageBean;
import com.microlecture.manager.SQLReader;

/**
 * Servlet implementation class CourseRevelanceServlet
 */
@WebServlet("/CourseRevelanceServlet")
public class CourseRevelanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SQLReader reader;
    private int id;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseRevelanceServlet() {
        super();
        // TODO Auto-generated constructor stub
        reader = new SQLReader();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/page/HomePageList.jsp").forward(
				request, response);
		doGet(request, response);
	}
	/*private StringBuilder getJSON(int id) {
		StringBuilder json = new StringBuilder();
		ArrayList<CourseLecutureBean> list = reader.getCourseLecture(id);
		json.append('[');
		for (int i = 0; i < list.size(); i++) {
			json.append(list.get(i).getJSON());
		}
		json.deleteCharAt(json.length() - 1);
		json.append(']');
		
		return json;
	}*/
}
