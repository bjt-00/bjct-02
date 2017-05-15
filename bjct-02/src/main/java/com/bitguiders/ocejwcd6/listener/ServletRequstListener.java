package com.bitguiders.ocejwcd6.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ServletRequstListener
 *
 */
@WebListener
public class ServletRequstListener implements ServletRequestListener {

    /**
     * Default constructor. 
     */
    public ServletRequstListener() {
    	System.out.println("Listener: ServletRequstListener()");
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent event) {
    	ServletContext context=event.getServletContext();
    	context.log("Listener: servlet request listener destroyed ");
        // TODO Auto-generated method stub
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent event) {
    	ServletContext context=event.getServletContext();
    	context.log("Listener: servlet request listener initialized ");
    	context.log("Context Params "+context.getInitParameter("contextParam1"));
        // TODO Auto-generated method stub
    }
	
}
