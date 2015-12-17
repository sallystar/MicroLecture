package com.microlecture.servlet;

import java.io.IOException;
import java.io.Reader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.microlecture.bean.PostBean;
import com.microlecture.manager.SQLReader;

/**
 * Servlet implementation class PublishPostServlet
 */
@WebServlet("/PublishPostServlet")
public class PublishPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String json;
    private SQLReader reader;   
    private boolean FLAG;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublishPostServlet() {
        super();
        // TODO Auto-generated constructor stub
        reader = new SQLReader();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Reader r = request.getReader();
		char []buff = new char[1024];
		r.read(buff);
		String json = new String(buff);
		PostBean bean = new PostBean();
	/*	bean.parseJSON(json);
		FLAG = reader.publishPostSave(bean);*/
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("flag", FLAG);
	}

}
