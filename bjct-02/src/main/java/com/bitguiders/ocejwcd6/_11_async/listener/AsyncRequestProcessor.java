package com.bitguiders.ocejwcd6._11_async.listener;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletContext;

public class AsyncRequestProcessor implements Runnable {

	private AsyncContext asyncContext;
    private int secs;
    
	public AsyncRequestProcessor(AsyncContext asyncCtx, int secs) {
        this.asyncContext = asyncCtx;
        this.secs = secs;
    }
 
    @Override
    public void run() {
    	ServletContext context = this.asyncContext.getRequest().getServletContext();
        context.log("Async Supported? "+ asyncContext.getRequest().isAsyncSupported());
        longProcessing(secs);
        		context.log("Processing done for " + secs + " milliseconds!!");
         try {
			PrintWriter out = this.asyncContext.getResponse().getWriter();
			out.write("Processing done for " + secs + " milliseconds!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //complete the processing
        asyncContext.complete();
    }
 
    private void longProcessing(int secs) {
        // wait for given time before finishing
        try {
            Thread.sleep(secs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
