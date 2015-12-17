package com.microlecture.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.microlecture.bean.NotificationBean;
import com.microlecture.manager.JSONUtil;
import com.microlecture.manager.SQLReader;


/**
 * Servlet implementation class NotificationServlet
 */
@WebServlet("/GetNotificationServlet")
public class GetNotificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SQLReader reader;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetNotificationServlet() {
        super();
        // TODO Auto-generated constructor stub
        reader = new SQLReader();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<NotificationBean> list = reader.getNotification();
		PrintWriter out = response.getWriter();
		out.print(JSONUtil.beanToJSON(list));
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
