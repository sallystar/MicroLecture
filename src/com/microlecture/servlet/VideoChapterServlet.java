package com.microlecture.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.microlecture.bean.ExamNotifyBean;
import com.microlecture.bean.VideoChapterBean;
import com.microlecture.manager.SQLReader;

/**
 * Servlet implementation class VideoChapterServlet
 */
@WebServlet("/VideoChapterServlet")
public class VideoChapterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SQLReader reader;
    private int courseId;   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VideoChapterServlet() {
        super();
        // TODO Auto-generated constructor stub
        reader = new SQLReader();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		courseId = Integer.parseInt( request.getParameter("courseId"));
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//SubmitTestBean bean = new SubmitTestBean();
		//bean.parseJSON(getJSON().toString());
		request.getRequestDispatcher("/WEB-INF/page/VideoChapter.jsp").forward(
				request, response);
	}

	
}
