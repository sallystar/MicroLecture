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
import com.google.gson.reflect.TypeToken;
import com.microlecture.bean.AccuracyBean;
import com.microlecture.bean.VideoRevelance;
import com.microlecture.bean.VideoTestBean;
import com.microlecture.manager.SQLReader;
import com.microlecture.statictool.JSONUtil;

/**
 * Servlet implementation class VideoTestServlet
 */
@WebServlet("/VideoTestServlet")
public class VideoTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SQLReader reader;
    private int vId;   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VideoTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		vId = Integer.parseInt(request.getParameter("videoId"));
		Gson gson = new Gson();
		ArrayList<VideoTestBean> list = new ArrayList<VideoTestBean>();
		reader = new SQLReader();
		list = reader.getVideoTest(vId);
		String str = new String();
		str = gson.toJson(list, list.getClass());
		PrintWriter out = response.getWriter();
		out.write(str);
		out.flush();
		str = null;
		out = null;
		list = null;
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
