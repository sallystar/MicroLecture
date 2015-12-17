package com.microlecture.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.reflect.TypeToken;
import com.microlecture.bean.HomePageBean;
import com.microlecture.bean.SubmitTestBean;
import com.microlecture.bean.VideoTestBean;
import com.microlecture.manager.JSONUtil;
import com.microlecture.manager.SQLReader;

/**
 * Servlet implementation class SubmitTestServlet
 */
@WebServlet("/SubmitTestServlet")
public class SubmitTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SQLReader reader; 
    private int  FLAG;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String json = request.getParameter("submit");
		reader= new SQLReader();
		if(json!= null && !json.equals("")){
			System.out.println(json);
			ArrayList<SubmitTestBean> list = new ArrayList<SubmitTestBean>();
			list = (ArrayList<SubmitTestBean>) JSONUtil.JSONToList(json, new TypeToken<ArrayList<SubmitTestBean>>() {
							}.getType());
			if(list.size()!=0){
				
				FLAG = reader.submitTest(list);
			}else{
				FLAG = -1;
			}
		}
		PrintWriter out = response.getWriter();
		out.write(FLAG);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
