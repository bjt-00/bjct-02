package com.bitguiders.ocejwcd6.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * Application Lifecycle Listener implementation class HttpSesionActivationListener
 *
 */
@WebListener
public class HttpSesionActivationListener implements HttpSessionActivationListener {

    /**
     * Default constructor. 
     */
    public HttpSesionActivationListener() {
    	System.out.println("Listener: HttpSesionActivationListener()");
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionActivationListener#sessionDidActivate(HttpSessionEvent)
     */
    public void sessionDidActivate(HttpSessionEvent event) {
        // TODO Auto-generated method stub
    	ServletContext context=event.getSession().getServletContext();
    	context.log("Listener: http session activation listener activated ");
    }

	/**
     * @see HttpSessionActivationListener#sessionWillPassivate(HttpSessionEvent)
     */
    public void sessionWillPassivate(HttpSessionEvent event) {
    	ServletContext context=event.getSession().getServletContext();
    	context.log("Listener: http session activation listener passivated ");
        // TODO Auto-generated method stub
    }
	
}
