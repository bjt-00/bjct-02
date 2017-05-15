package com.bitguiders.ocejwcd6._01_servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatchServlet
 */
@WebServlet(name="info" , urlPatterns={"/info"})
public class OtherFeaturesServlet extends HttpServlet {
	private int counter=0;
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		
		String action = request.getParameter("action");
		
		context.log(" For "+(counter++)+" Times this Servlet is called ");
		context.log("Context Path = "+request.getContextPath());
		context.log("Servlet Path ="+request.getServletPath());
		context.log("Server Name  ="+request.getServerName());
		context.log("Request URI  ="+request.getRequestURI());
		context.log("Request URL  ="+request.getRequestURL());
		context.log("Query String  ="+request.getQueryString());
		context.log("Path Info     ="+request.getPathInfo());
		context.log("Path Translated ="+request.getPathTranslated());
		
		if(action!=null && action.equals("redirect")){
		context.log("------------REDIRECT------------------");
		//There is a top-level folder help in the war file with index.htmlinside. What is the output of this code? (1 correct answer) 
//		response.sendRedirect("http://www.bitguiders.com");//
		response.sendRedirect("html/index.html");//
		}

		if(action!=null && action.equals("forward")){
			context.log("------------FORWARD------------------");
		//"   There is a top-level folder help in the war file with index.htmlinside. What is the output of this code? (1 correct answer) 
//		request.getRequestDispatcher("http://www.bitguiders.com").forward(request, response); //will throw error at runtiem
		request.getRequestDispatcher("html/index.html").forward(request, response); //ans says will display page
		
		}
		//		response.getWriter().println(getInitParameter("paramName"));
		
//		response.getWriter().println(request.getAttribute("javax.servlet.forward.query_string"));
//		response.getWriter().println(request.getAttribute("javax.servlet.forward.servlet_path"));
		
		
		
//		response.sendRedirect("target");
//		response.getWriter().println(request.getServletPath());
	}
/*	public void doGet(HttpServletRequest request, HttpServletResponse response)  throws Exception {
response.setContentType("text/html; charset=UTF-8");
response.getWriter().println("Hello!!").close();
}
*/}
