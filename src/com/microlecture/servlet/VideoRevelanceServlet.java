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
import com.microlecture.bean.VideoInfoBean;
import com.microlecture.bean.VideoRevelance;
import com.microlecture.manager.SQLReader;

/**
 * Servlet implementation class VideoRevelanceServlet
 */
@WebServlet("/VideoRevelanceServlet")
public class VideoRevelanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SQLReader reader;
	private int vId;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VideoRevelanceServlet() {
        super();
        // TODO Auto-generated constructor stub
        reader = new SQLReader();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		vId = Integer.parseInt(request.getParameter("videoId"));
		ArrayList<VideoRevelance> list = new ArrayList<VideoRevelance>();
		String str = new String();
		list = reader.getVideoRevelance(vId); 
		Gson gson = new Gson();
		str = gson.toJson(list, list.getClass());
		System.out.println(str);
		PrintWriter out = response.getWriter();
		out.write(str);
		out.flush();
		str = null;
		out = null;
		list = null;
		gson = null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//SubmitTestBean bean = new SubmitTestBean();
		//bean.parseJSON(getJSON().toString());
		//request.getRequestDispatcher("/WEB-INF/page/HomePageList.jsp").forward(
		//		request, response);
		doGet(request, response);
	}


}
