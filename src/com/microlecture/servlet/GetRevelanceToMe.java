package com.microlecture.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.microlecture.bean.ReplyBean;
import com.microlecture.manager.JSONUtil;
import com.microlecture.manager.SQLReader;


/**
 * Servlet implementation class GetRevelanceToMe
 */
@WebServlet("/GetRevelanceToMe")
public class GetRevelanceToMe extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SQLReader reader;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetRevelanceToMe() {
        super();
        // TODO Auto-generated constructor stub
        reader = new SQLReader();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String  account = request.getParameter("account");
		
		String status =request.getParameter("status");
		ArrayList<ReplyBean> list = new ArrayList<ReplyBean>();
		list = reader.getRevelanceList(account,status);
		String json = JSONUtil.beanToJSON(list);
		PrintWriter out = response.getWriter();
		out.write(json);
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
