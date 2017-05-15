/*package com.bitguiders.ocejwcd6.jaxrs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.annotation.Servlet;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.Encoded;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;




@Path("/jaxrs")
public class RestFulService {

	@GET
	@Path("/text/{param}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getTextResponse(@DefaultValue("bitguiders") @PathParam("param") String param, @QueryParam("user") String user ){
		return "This is sample text resposne from java restful job. @PathParam ="+param+" @QueryParam ="+user;
	}

	@GET
	@Path("/xml/{param}")
	@Produces(MediaType.TEXT_XML)
	public String getXMLResponse(@DefaultValue("bitguiders") @PathParam("param") String param, @QueryParam("user") String user ){
		return "<root><text>This is sample text resposne from java restful job.</text><path-param> @PathParam ="+param+"</path-param><query-param> @QueryParam ="+user+"</query-param></root>";
	}
	@GET
	@Path("/html/{param}")
	@Produces(MediaType.TEXT_HTML)
	public String getHTMLResponse(@DefaultValue("bitguiders") @PathParam("param") String param, @QueryParam("user") String user ){
		return "<div><br><H1>This is sample text resposne from java restful job.</H1><br><b> @PathParam ="+param+"</b><br><b> @QueryParam ="+user+"</b></div>";
	}

	@GET
	@Path("/number/{param : \\d+}")//it will accept numbers only
	public Response getNumberOnly(@PathParam("param") int number){
		return Response.status(200).entity("Number = "+number).build();
	}
	@GET
	@Path("/varchar/{param : [a-zA-Z][a-zA-Z_0-9]}")//it will accept varchar mixed case only
	public Response getVarcharOnly(@PathParam("param") String varchar){
		return Response.status(200).entity("Varchar = "+varchar).build();
	}

	@MatrixParam("mparam1") //this param will auto bind with given variable
    @Encoded
    @DefaultValue("default")
    private String matrixParam;

	@GET
	@Path("/matrix/{param}") // rest/jaxrs/matrix/param;mparam1=val1;mparam2=val2
	@Produces(MediaType.TEXT_HTML)
	public String getHTMLResponse(@DefaultValue("bitguiders") @PathParam("param") String param, @QueryParam("user") String user,@MatrixParam("mparam1") String matrixParamValue  ){
		return "<div><br><H1>This is sample text resposne from java restful job.</H1><br><b> @PathParam ="+param+"</b><br><b> @QueryParam ="+user+"</b> <br><b> @MatrixParam ="+matrixParam+"</b></div>";
	}
	@POST
	@Path("/form")
	@Produces(MediaType.TEXT_HTML)
	public String getFormResponse(@FormParam("name") String name, @FormParam("phone") int phone ){
		return "<div><br><H1>This is sample text resposne from java restful job.</H1><br><b> @FormParam Name ="+name+"</b><br><b> @FormParam Phone ="+phone+"</b></div>";
	}

	@GET
	@Path("/context")
	@Produces(MediaType.TEXT_HTML)
	public String getHeaders(@Context HttpHeaders headers){
		StringBuilder headerBuilder = new StringBuilder();
		headerBuilder.append("<div><br><H1>JAX-RS @Context Example</H1></b></div>");
		for(String header: headers.getRequestHeaders().keySet()){
			headerBuilder.append("<br><b>").append(header).append("</b>");
		}
		headerBuilder.append("</div>");
		return headerBuilder.toString();
	}
	@GET
	@Path("/text-file")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getTextFile(){
		
		File file = new File("E:\\input\\jaxrs.txt");
		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition","attachment; filename= \"jaxrs-text-file.txt\"");
		return response.build();
		
	}
	@GET
	@Path("/image-file")
	@Produces("image/png")
	public Response getImageFile(){
		
		File file = new File("E:\\input\\jaxrs.png");
		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition","attachment; filename= \"jaxrs-image-file.png\"");
		return response.build();
	}
	@GET
	@Path("/pdf-file")
	@Produces("application/pdf")
	public Response getPDFFile(){
		
		File file = new File("E:\\input\\jaxrs.pdf");
		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition","attachment; filename= \"jaxrs-pdf-file.pdf\"");
		return response.build();
	}
	@GET
	@Path("/excel-file")
	@Produces("application/vnd.ms-excel")
	public Response getXLSFile(){
		
		File file = new File("E:\\input\\jaxrs.xlsx");
		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition","attachment; filename= \"jaxrs-excel-file.xlsx\"");
		return response.build();
	}

	@POST
	@Path("/upload")
	@Consumes("multipart/form-data")
	public Response uploadFile(MultipartFormDataInput input) {
 
		String fileName = "";
 
		Map<String, List<InputPart>> uploadForm = input.getFormDataMap();
		List<InputPart> inputParts = uploadForm.get("file");
 
		for (InputPart inputPart : inputParts) {
 
		 try {
 
			MultivaluedMap<String, String> header = inputPart.getHeaders();
			fileName = getFileName(header);
 
			//convert the uploaded file to inputstream
			InputStream inputStream = inputPart.getBody(InputStream.class,null);
 
			byte [] bytes = IOUtils.toByteArray(inputStream);
 
			//constructs upload file path
			fileName = "e:\\upload\\" + fileName;
 
			writeFile(bytes,fileName);
 
			System.out.println("Done");
 
		  } catch (IOException e) {
			e.printStackTrace();
		  }
 
		}
 
		return Response.status(200)
		    .entity("uploadFile is called, Uploaded file name : " + fileName).build();
 
	}
 
	*//**
	 * header sample
	 * {
	 * 	Content-Type=[image/png], 
	 * 	Content-Disposition=[form-data; name="file"; filename="filename.extension"]
	 * }
	 **//*
	//get uploaded filename, is there a easy way in RESTEasy?
	private String getFileName(MultivaluedMap<String, String> header) {
 
		String[] contentDisposition = header.getFirst("Content-Disposition").split(";");
 
		for (String filename : contentDisposition) {
			if ((filename.trim().startsWith("filename"))) {
 
				String[] name = filename.split("=");
 
				String finalFileName = name[1].trim().replaceAll("\"", "");
				return finalFileName;
			}
		}
		return "unknown";
	}
	//save to somewhere
		private void writeFile(byte[] content, String filename) throws IOException {
	 
			File file = new File(filename);
	 
			if (!file.exists()) {
				file.createNewFile();
			}
	 
			FileOutputStream fop = new FileOutputStream(file);
	 
			fop.write(content);
			fop.flush();
			fop.close();
	 
		}
		@GET
		@Path("/jaxb")
		@Produces("application/xml")
		public UserORM getUserInXML() {
	 
			UserORM user = new UserORM();
			user.setName("abdul kareem");
			user.setPhone(1234);
			user.setId(123456);
	 
			return user; 
	 
		}
	    public void setRequest(Request request) {
	        // injection into a setter method
	        System.out.println(("@Context = "+request != null?request.getMethod():""));
	    }

}
*/