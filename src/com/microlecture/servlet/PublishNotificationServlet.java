package com.microlecture.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.microlecture.bean.NotificationBean;
import com.microlecture.manager.JSONUtil;
import com.microlecture.manager.SQLReader;


/**
 * Servlet implementation class PublishNotificationServlet
 */
@WebServlet("/PublishNotificationServlet")
public class PublishNotificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SQLReader reader;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublishNotificationServlet() {
        super();
        // TODO Auto-generated constructor stub
        reader = new SQLReader();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String json = new String(request.getParameter("notification").getBytes("iso-8859-1"),"UTF-8");
		System.out.println(json);
		NotificationBean bean = (NotificationBean) JSONUtil.JSONToBean(json, NotificationBean.class);
		int result = reader.publishNotification(bean);
		PrintWriter out = response.getWriter();
		out.write(result);
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
