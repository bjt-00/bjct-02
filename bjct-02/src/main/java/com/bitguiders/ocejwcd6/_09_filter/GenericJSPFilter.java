package com.bitguiders.ocejwcd6._09_filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Servlet Filter implementation class BitguidersFilter
 */
@WebFilter(
		filterName  = "genericJSPFilter",
		description = "Filter Description", 
		urlPatterns = { "*.jsp" }, 
		initParams = { 
				@WebInitParam(name = "Param1", value = "Value1", description = "Desc1")
		})
public class GenericJSPFilter implements Filter {

    /**
     * Default constructor. 
     */
    public GenericJSPFilter() {
        // TODO Auto-generated constructor stub
    	System.out.println("JSPFilter()");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("JSPFilter.destroy");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		System.out.println("JSPFilter.doFilter");
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("JSPFilter.init");
	}

}
