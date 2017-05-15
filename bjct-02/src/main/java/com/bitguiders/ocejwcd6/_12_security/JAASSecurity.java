package com.bitguiders.ocejwcd6._12_security;

import java.io.IOException;

import javax.annotation.security.DeclareRoles;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.ServletSecurity.EmptyRoleSemantic;
import javax.servlet.annotation.ServletSecurity.TransportGuarantee;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;

/**
 * Servlet implementation class JAASSecurity
 */
@DeclareRoles({"admin","user"})
@HttpConstraint(value=EmptyRoleSemantic.PERMIT, rolesAllowed="user" , transportGuarantee=TransportGuarantee.NONE)
@HttpMethodConstraint(value="GET" , rolesAllowed="user", transportGuarantee=TransportGuarantee.NONE )
@WebServlet("/jaasSecurityServlet")
@ServletSecurity(value=@HttpConstraint(value=EmptyRoleSemantic.PERMIT))
//@ServletSecurity(value = @HttpConstraint(EmptyRoleSemantic.DENY),httpMethodConstraints = {@HttpMethodConstraint(methodName = "GET",  emptyRoleSemantic = EmptyRoleSemantic.ALLOW)})

public class JAASSecurity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JAASSecurity() {
        super();
        // TODO Auto-generated constructor stub
    }

    @GET
	protected void getMethod(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("roleAttribute","getMethod@"+request.getParameter("role"));
		RequestDispatcher rd = request.getRequestDispatcher("/view/jaasSecurity.jsp");
		rd.forward(request, response);

	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("roleAttribute","@"+request.getParameter("role"));
		RequestDispatcher rd = request.getRequestDispatcher("/view/jaasSecurity.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
