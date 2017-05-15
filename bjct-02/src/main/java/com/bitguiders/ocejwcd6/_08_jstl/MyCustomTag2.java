package com.bitguiders.ocejwcd6._08_jstl;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;


public class MyCustomTag2 extends TagSupport  {

	String value;
	
	
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		
			try {
				out.print("This text is from MY Custom Tag2 class <br>tag body="+""+" <br>attribute values ="+value);
			} catch (IOException e) {
				e.printStackTrace();
			}

		return  EVAL_BODY_INCLUDE; 
	}
	public void setValue(String value){
		this.value = value;
	}

}
