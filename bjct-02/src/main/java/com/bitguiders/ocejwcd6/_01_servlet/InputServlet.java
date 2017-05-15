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
		name = "inputServlet",
		urlPatterns = { "/input.servlet" }, 
		initParams = { 
				@WebInitParam(name = "Param1", value = "Value1", description = "Desc1")
		},
		loadOnStartup = 1 //The number inside the <load-on-startup>1</load-on-startup> element tells the servlet container in what sequence the servlets should be loaded. The lower numbers are loaded first. If the value is negative, or unspecified, the servlet container can load the servlet at any time.
		)
public class InputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InputServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet: Param1 = "+getInitParameter("Param1"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		context.log("--------------------------------------");
		String servlet = "Input.";
		context.log(servlet+"doPost :: Param1 = "+getInitParameter("Param1"));
		
		StringBuilder cookies = new StringBuilder();
		for(Cookie cookie:request.getCookies()){
			cookies.append(cookie.getName()).append(" <> ").append(cookie.getValue());
		}
		StringBuilder params = new StringBuilder();
		request.setAttribute("InputServletAttr1", cookies.toString());
		Enumeration<String> paramNames =request.getParameterNames(); 
		while(paramNames.hasMoreElements()){
			params.append(paramNames.nextElement()).append("<>").append(request.getParameter(paramNames.nextElement())); 
		}
		context.log(servlet+"id = "+request.getParameter("id"));
		context.log(servlet+"Cookies received :"+cookies.toString());
		context.log(servlet+"Params  received :"+params.toString());
		
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = context.getRequestDispatcher("/process");
		dispatcher.forward(request, response);
		
	}

}
