package com.microlecture.manager;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter {

	  private String encoding;  
	   
	    public static String key = "com.microlecture.manager.parameters";  
	  
	    @Override  
	    public void destroy() {  
	    }  
	  
	    @Override  
	    public void doFilter(ServletRequest request, ServletResponse response,  
	            FilterChain chain) throws IOException, ServletException {  
	        Map<String, String> parameters = new HashMap<String, String>();  
	        Enumeration<String> names = request.getParameterNames();  
//	        for(; names.hasMoreElements(); ) {  
//	            String name = names.nextElement();  
//	            parameters.put(name, new String(request.getParameter(name).getBytes(encoding), newEncoding));  
//	        }  
	       // request.setAttribute(CharacterEncodingFilter.key, parameters);  
	        response.setCharacterEncoding("UTF-8");
	        chain.doFilter(request, response);  
	    }  
	  
	    @Override  
	    public void init(FilterConfig config) throws ServletException {  
	    	encoding = config.getInitParameter("encoding");
	    	System.out.println(encoding);
	    }  
}