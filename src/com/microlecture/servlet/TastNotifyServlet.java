package com.microlecture.servlet;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.microlecture.bean.ExamNotifyBean;
import com.microlecture.bean.HomePageBean;
import com.microlecture.bean.SubmitTestBean;
import com.microlecture.bean.TaskNotifyBean;
import com.microlecture.manager.SQLReader;

/**
 * Servlet implementation class TastNotifyServlet
 */
@WebServlet("/TastNotifyServlet")
public class TastNotifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SQLReader reader;
    private int id =0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TastNotifyServlet() {
        super();
        // TODO Auto-generated constructor stub
        reader = new SQLReader();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		id = Integer.parseInt(request.getParameter("courseId"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("json", getJSON().toString());
		//SubmitTestBean bean = new SubmitTestBean();
		//bean.parseJSON(getJSON().toString());
		request.getRequestDispatcher("/WEB-INF/page/HomePageList.jsp").forward(
				request, response);
	}

	private StringBuilder getJSON() {
		StringBuilder json = new StringBuilder();
		ArrayList<TaskNotifyBean> list = reader.getTaskNotify();
		json.append('{');
		json.append("\"length\":[{\"length\":"+list.size()+"}],");
		for (int i = 0; i < list.size(); i++) {
			json.append("\"TaskNotify"+i+"\":");
			json.append(list.get(i).getJson());
		}
		json.deleteCharAt(json.length() - 1);
		json.append('}');
		
		
		return json;
	}

}
