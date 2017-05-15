package com.bitguiders.ocejwcd6.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * Application Lifecycle Listener implementation class HttpSesionBindingListener
 *
 */
@WebListener
public class HttpSesionBindingListener implements HttpSessionBindingListener {

    /**
     * Default constructor. 
     */
    public HttpSesionBindingListener() {
    	System.out.println("Listener: HttpSesionBindingListener()");
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionBindingListener#valueUnbound(HttpSessionBindingEvent)
     */
    public void valueUnbound(HttpSessionBindingEvent event) {
    	ServletContext context=event.getSession().getServletContext();
    	context.log("Listener: http session binding listener unbound ");
        // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionBindingListener#valueBound(HttpSessionBindingEvent)
     */
    public void valueBound(HttpSessionBindingEvent event) {
    	ServletContext context=event.getSession().getServletContext();
    	context.log("Listener: http session binding listener bound ");
        // TODO Auto-generated method stub
    }
	
}
