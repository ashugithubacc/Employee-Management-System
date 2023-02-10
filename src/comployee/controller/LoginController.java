package comployee.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employee.bo.emp_bo;
import employee.dao.Emp_dao;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	        response.setContentType("text/html");
	        PrintWriter pw=response.getWriter();
	        
	        String email= request.getParameter("username");
	        String pass= request.getParameter("password"); 
	
	        
	     if(Emp_dao.userLogin(email, pass)) {

	          RequestDispatcher rd=request.getRequestDispatcher("home.html");
	          rd.forward(request, response);
	     
	     }else {
	    	 pw.print("Username or password wrong!!!");
	    	 RequestDispatcher rd=request.getRequestDispatcher("login.html");
	          rd.include(request, response);
	     }
	        
	        
	}

}
