package com.microlecture.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.microlecture.bean.PersonBean;
import com.microlecture.manager.JSONUtil;
import com.microlecture.manager.SQLReader;


/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * register profile use the JSON string with key profileJSON;
     * return   meaning      value
     *      	USER_EXIST     2;
	 *          SUCCESS        1;
	 *          FAILED         0;
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String profileJSON = request.getParameter("profileJSON");
		System.out.println("request.getParameter profileJSON="+profileJSON);
		PersonBean bean = (PersonBean)JSONUtil.JSONToBean(profileJSON, PersonBean.class);
		int result = new SQLReader().register(bean);
		PrintWriter out = response.getWriter();
		out.print(result);
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
