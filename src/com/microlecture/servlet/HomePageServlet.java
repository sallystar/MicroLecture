package com.microlecture.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.microlecture.bean.HomePageBean;
import com.microlecture.bean.PostBean;
import com.microlecture.manager.SQLReader;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet(urlPatterns = { "/TestServlet" })
public class HomePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SQLReader reader;

	/**
	 * Default constructor.
	 */
	public HomePageServlet() {
		// TODO Auto-generated constructor stub
		reader = new SQLReader();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.print(Integer.parseInt(request.getParameter("id")));
		PrintWriter writer = response.getWriter();
		//insertIntoSQL(request, response);
		String str = new String();
		ArrayList< HomePageBean > list = new ArrayList<HomePageBean>();
		list = reader.getCourse();
		Gson gson = new Gson();
		str = gson.toJson(list, list.getClass());
		writer.write(str.toString());
		writer.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	request.getRequestDispatcher("/WEB-INF/page/HomePageList.jsp").forward(
		//		request, response);
		
		doGet(request, response);
		
	}
	/**
	 * 获取所有的json
	 * **/
/*	public void insertIntoSQL(HttpServletRequest request,
			HttpServletResponse response){
		String path = request.getServletContext().getRealPath("/");
		System.out.println(path);
		File file = new File(path);
		if(file.isDirectory()){
			for(File f: file.listFiles()){
				if(f.isDirectory()){
					for(int i = 0 ; i <f.list().length;i++)
						getFile(f.listFiles()[i]);
				}
				else getFile(f);
			}
		}
	}
	public String getFile(File file){
		
		if(file.isFile()){
			System.out.println(file.getName());
			return file.getName();
		}
		return null;
	}*/

}
