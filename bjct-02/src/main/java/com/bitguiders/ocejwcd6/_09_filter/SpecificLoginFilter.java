package com.bitguiders.ocejwcd6._09_filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class BitguidersFilter
 */
@WebFilter(
		filterName  = "specificLoginFilter",
		description = "Filter Description", 
		urlPatterns = { "/BitguidersServlet.servlet" }, 
		initParams = { 
				@WebInitParam(name = "Param1", value = "Value1", description = "Desc1")
		})
public class SpecificLoginFilter implements Filter {

	private ServletContext context;
    /**
     * Default constructor. 
     */
    public SpecificLoginFilter() {
        // TODO Auto-generated constructor stub
    	System.out.println("SpecificLoginFilter()");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		this.context.log("SpecificLoginFilter.destroy");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		this.context.log("SpecificLoginFilter.doFilter");
		
		HttpServletRequest  req = (HttpServletRequest)  request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		if(request.getParameter("id")==null || request.getParameter("id").trim().length()==0){
			this.context.log("User ID is missing");
			res.sendRedirect("index.jsp");
			
		}else{
			this.context.log("Welcome "+req.getParameter("id"));
			Cookie cookie = new Cookie("Cookie1", "CookieVal1");
			res.addCookie(cookie);
		}
		
		// pass the request along the filter chain
		chain.doFilter(req, res);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.context = fConfig.getServletContext();
		this.context.log("SpecificLoginFilter.init");
	}

}
