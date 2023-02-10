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
 * Servlet implementation class SignupController
 */
@WebServlet("/SignupController")
public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SignupController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		     response.setContentType("text/html");
		     PrintWriter pw=response.getWriter();
		     
		    String name= request.getParameter("name");
		    String email= request.getParameter("email");
		    String phone= request.getParameter("phone");
		    String pwd= request.getParameter("pass");
		  //  pw.print(name+" "+email+" "+phone+" "+pwd);
		    
		    emp_bo em=new emp_bo();
		    
		    em.setName(name);
		    em.setEmail(email);
		    em.setPhone(phone);
		    em.setPassword(pwd);
		    
		    int status =Emp_dao.signup(em);
		    
		    if(status>0) {

		       RequestDispatcher rd=request.getRequestDispatcher("login.html");
		       rd.forward(request, response);
		    }else {
		    	pw.print("Something went wrong!!");
		    	RequestDispatcher rd=request.getRequestDispatcher("signup.html");
			    rd.include(request, response);
		    }
		    
		    
		
	}

}
