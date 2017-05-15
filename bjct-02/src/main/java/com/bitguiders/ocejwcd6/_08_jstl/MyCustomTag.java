package com.bitguiders.ocejwcd6._08_jstl;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyCustomTag extends SimpleTagSupport {

	String value;
	
	StringWriter sw = new StringWriter();
	public void doTag()throws JspException,IOException {
		JspWriter out = getJspContext().getOut();
		getJspBody().invoke(sw);
			out.print("This text is from MY Custom Tag class <br>tag body="+sw.toString()+" <br>attribute values ="+value);
	}
	
	public void setValue(String value){
		this.value = value;
	}
}
