package com.bitguiders.ocejwcd6.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class HttpSesionAttributeListener
 *
 */
@WebListener
public class HttpSesionAttributeListener implements HttpSessionAttributeListener {

    /**
     * Default constructor. 
     */
    public HttpSesionAttributeListener() {
    	System.out.println("Listener: HttpSesionAttributeListener()");
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent event) {
    	ServletContext context=event.getSession().getServletContext();
    	context.log("Listener: http session attribute listener removed ");

        // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent event) {
    	ServletContext context=event.getSession().getServletContext();
    	context.log("Listener: http session attribute listener added ");

        // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent event) {
    	ServletContext context=event.getSession().getServletContext();
    	context.log("Listener: http session attribute listener replaced ");

        // TODO Auto-generated method stub
    }
	
}
