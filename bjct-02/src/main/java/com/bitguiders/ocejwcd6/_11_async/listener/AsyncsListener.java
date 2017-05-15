package com.bitguiders.ocejwcd6._11_async.listener;

import java.io.IOException;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletContext;

public class AsyncsListener implements AsyncListener {

	public void AsyncListener(){
    	System.out.println("Listener: AsyncListener()");
	}
	@Override
	public void onComplete(AsyncEvent event) throws IOException {
    	ServletContext context=event.getAsyncContext().getRequest().getServletContext();
    	context.log("Listener: http async listener onComplete ");
		// TODO Auto-generated method stub
	}

	@Override
	public void onError(AsyncEvent event) throws IOException {
    	ServletContext context=event.getAsyncContext().getRequest().getServletContext();
    	context.log("Listener: http async listener onError ");
		// TODO Auto-generated method stub
	}

	@Override
	public void onStartAsync(AsyncEvent event) throws IOException {
    	ServletContext context=event.getAsyncContext().getRequest().getServletContext();
    	context.log("Listener: http async listener onStartAsync ");
		// TODO Auto-generated method stub
	}

	@Override
	public void onTimeout(AsyncEvent event) throws IOException {
    	ServletContext context=event.getAsyncContext().getRequest().getServletContext();
    	context.log("Listener: http async listener onTimeout ");
		// TODO Auto-generated method stub
	}
	
}
