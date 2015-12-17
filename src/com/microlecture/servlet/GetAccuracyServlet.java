package com.microlecture.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.microlecture.bean.AccuracyBean;
import com.microlecture.manager.JSONUtil;
import com.microlecture.manager.SQLReader;

/**
 * Servlet implementation class ErrorRateServlet
 */
@WebServlet("/GetAccuracyServlet")
public class GetAccuracyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SQLReader reader;
       
	private int id;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAccuracyServlet() {
        super();
        // TODO Auto-generated constructor stub
        reader = new SQLReader();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		id = Integer.parseInt(request.getParameter("videoId"));
		
		ArrayList<AccuracyBean> list = new ArrayList<AccuracyBean>();
		String json  = "";
		list = reader.getAccuracy(id);
		if(list.size() !=0){
		json = JSONUtil.beanToJSON(list);
		}else {
			json = "null";
		}
		System.out.println(json);
		PrintWriter out = response.getWriter();
		out.write(json);
		out.flush();
		//out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
