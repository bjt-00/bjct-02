package com.bitguiders.ocejwcd6.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ServletContxtAttributeListener
 *
 */
@WebListener
public class ServletContxtAttributeListener implements ServletContextAttributeListener {

    /**
     * Default constructor. 
     */
    public ServletContxtAttributeListener() {
    	System.out.println("Listener: ServletContxtAttributeListener()");
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
     */
    public void attributeAdded(ServletContextAttributeEvent event) {
    	ServletContext context=event.getServletContext();
    	context.log("Listener: servlet context attribute listener added ");
        // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    public void attributeReplaced(ServletContextAttributeEvent event) {
    	ServletContext context=event.getServletContext();
    	context.log("Listener: servlet context attribute listener replaced ");

        // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
     */
    public void attributeRemoved(ServletContextAttributeEvent event) {
    	ServletContext context=event.getServletContext();
    	context.log("Listener: servlet context attribute listener removed ");
        // TODO Auto-generated method stub
    }
	
}
