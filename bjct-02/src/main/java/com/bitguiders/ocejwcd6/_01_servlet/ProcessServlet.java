package com.bitguiders.ocejwcd6._01_servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BitguidersServlet
 */
@WebServlet(
		name = "processServlet",
		urlPatterns = { "/process" }, 
		initParams = { 
				@WebInitParam(name = "Param1", value = "Value1", description = "Desc1")
		}
		)
public class ProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Process.doGet: Param1 = "+getInitParameter("Param1"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		context.log("--------------------------------------");
		String servlet = "Process.";
		
		//getting value from current servlet
		context.log(servlet+"doPost :: Param1 = "+getInitParameter("Param1"));
		
		//getting value from context
		context.log(servlet+"doPost :: context Param2 = "+ context.getInitParameter("contextParam1"));
		
		StringBuilder cookies = new StringBuilder();
		for(Cookie cookie:request.getCookies()){
			cookies.append(cookie.getName()).append(" <> ").append(cookie.getValue());
		}
		StringBuilder params = new StringBuilder();
		
		Enumeration<String> paramNames =request.getParameterNames(); 
		while(paramNames.hasMoreElements()){
			params.append(paramNames.nextElement()).append("<>").append(request.getParameter(paramNames.nextElement())); 
		}
		context.log(servlet+"id = "+request.getParameter("id"));
		context.log(servlet+"Cookies received :"+cookies.toString());
		context.log(servlet+"Params  received :"+params.toString());
		
		//set attribute
		request.setAttribute("InputServletAttr2", request.getAttribute("InputServletAttr1"));
		context.setAttribute("contextAttribute1", "valueUpdated");
		
		//set header
		response.setHeader("Header1", "HeaderValue1");
        
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/output");
		dispatcher.forward(request, response);
	}
	
}
