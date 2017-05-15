package com.bitguiders.ocejwcd6._01_servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
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
		name = "outputServlet",
		urlPatterns = { "/output" }, 
		initParams = { 
				@WebInitParam(name = "Param1", value = "Value1", description = "Desc1")
		})
public class OutputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OutputServlet() {
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
		String servlet = "Output.";
		//getting value from current servlet
		context.log(servlet+"doPost :: Param1 = "+getInitParameter("Param1"));
		
		//getting value from context
		context.log(servlet+"doPost :: context Param2 = "+ context.getInitParameter("contextParam1"));
		
		StringBuilder cookies = new StringBuilder();
		for(Cookie cookie:request.getCookies()){
			cookies.append(cookie.getName()).append(" <> ").append(cookie.getValue());
		}
		StringBuilder params = new StringBuilder();
		request.setAttribute("InputServletAttr1", cookies.toString());
		
		//get params from enumeration
		Enumeration<String> paramNames =request.getParameterNames(); 
		while(paramNames.hasMoreElements()){
			params.append(paramNames.nextElement()).append("<>").append(request.getParameter(paramNames.nextElement())); 
		}

		//get params from map
		Map<String,String[]> paramMaps = request.getParameterMap();
		for(String key:paramMaps.keySet()){
			for(String map:paramMaps.get(key)){
				context.log(key+" <map> "+map);
			}
		}
		
		//get header values
		request.getHeader("Header1");
		
		context.log(servlet+"id = "+request.getParameter("id"));
		context.log(servlet+"Cookies received :"+cookies.toString());
		context.log(servlet+"Params  received :"+params.toString());
		context.log(servlet+"InputServletAttr1 received:"+request.getAttribute("InputServletAttr1"));
		context.log(servlet+"InputServletAttr2 received:"+request.getAttribute("InputServletAttr2"));
		// TODO Auto-generated method stub
//		response.sendRedirect(context.getContextPath()+"/input.servlet");
//	    RequestDispatcher dispatcher = context.getRequestDispatcher("index.jsp");
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
	    dispatcher.forward(request, response);
	}

}
