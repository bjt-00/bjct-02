package com.bitguiders.ocejwcd6.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class HttpSesionListener
 *
 */
@WebListener
public class HttpSesionListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public HttpSesionListener() {
    	System.out.println("Listener: HttpSesionListener()");
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent event) {
    	ServletContext context=event.getSession().getServletContext();
    	context.log("Listener: http session listener created");

        // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent event) {
    	ServletContext context=event.getSession().getServletContext();
    	context.log("Listener: http session listener destroyed ");

        // TODO Auto-generated method stub
    }
	
}
