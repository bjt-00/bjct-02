package com.bitguiders.ocejwcd6.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ServletRequstAttributeListener
 *
 */
@WebListener
public class ServletRequstAttributeListener implements ServletRequestAttributeListener {

    /**
     * Default constructor. 
     */
    public ServletRequstAttributeListener() {
    	System.out.println("Listener: ServletRequstAttributeListener()");
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletRequestAttributeListener#attributeAdded(ServletRequestAttributeEvent)
     */
    public void attributeAdded(ServletRequestAttributeEvent event) {
    	ServletContext context=event.getServletContext();
    	context.log("Listener: servlet request attribute listener added ");
       // TODO Auto-generated method stub
    }

	/**
     * @see ServletRequestAttributeListener#attributeRemoved(ServletRequestAttributeEvent)
     */
    public void attributeRemoved(ServletRequestAttributeEvent event) {
    	ServletContext context=event.getServletContext();
    	context.log("Listener: servlet request attribute listener removed ");
        // TODO Auto-generated method stub
    }

	/**
     * @see ServletRequestAttributeListener#attributeReplaced(ServletRequestAttributeEvent)
     */
    public void attributeReplaced(ServletRequestAttributeEvent event) {
    	ServletContext context=event.getServletContext();
    	context.log("Listener: servlet request attribute listener replaced ");
        // TODO Auto-generated method stub
    }
	
}
