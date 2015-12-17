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
import com.microlecture.bean.VideoDiscussBean;
import com.microlecture.bean.VideoInfoBean;
import com.microlecture.manager.SQLReader;

/**
 * Servlet implementation class VideoInfoServlet
 */
@WebServlet("/VideoInfoServlet")
public class VideoInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SQLReader reader;
	private int videoId;
    private VideoInfoBean infoBean;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VideoInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
        reader = new SQLReader();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		videoId = Integer.parseInt(request.getParameter("videoId"));
		
		if(infoBean == null){
			infoBean = new VideoInfoBean();
		}
		infoBean = reader.getVideoInfo(videoId);
		Gson gson = new Gson();
		String str = new String();
		str = gson.toJson(infoBean, infoBean.getClass());
		PrintWriter out = response.getWriter();
		out.write(str);
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//request.getRequestDispatcher("/WEB-INF/page/HomePageList.jsp").forward(
		//		request, response);
		doGet(request, response);
	}

}
