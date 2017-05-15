package com.bitguiders.ocejwcd6.listener;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class AppContextListener
 *
 */
@WebListener
public class ServletContxtListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ServletContxtListener() {
    	System.out.println("Listener: ServletContxtListener() ");
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event) {
    	ServletContext context=event.getServletContext();
    	context.log("Listener: servlet context initialized ");
    	
    	context.setAttribute("contextAttribute1", "contextAttributeValue1");
    	
        // create the thread pool
        ThreadPoolExecutor executor = new ThreadPoolExecutor(100, 200, 50000L,TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(100));
        event.getServletContext().setAttribute("executor",executor);

        // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent event) {
    	ServletContext context=event.getServletContext();
    	context.log("Listener: servlet context destroyed ");

    	ThreadPoolExecutor executor = (ThreadPoolExecutor) event.getServletContext().getAttribute("executor");
        executor.shutdown();
        // TODO Auto-generated method stub
    }
	
}
