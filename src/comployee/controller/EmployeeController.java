package comployee.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employee.bo.Employee_bo;
import employee.dao.Emp_dao;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		    response.setContentType("text/html");
		    PrintWriter pw=response.getWriter();
		   
		     String name=request.getParameter("name");
		     String email=request.getParameter("email");
		     String phone=request.getParameter("phone");
		     String doj=request.getParameter("doj");
		     String dob=request.getParameter("dob");
		     String adhar=request.getParameter("adhar");
		     
		    // pw.print(name+" "+email+" "+phone+" "+doj+" "+dob+" "+adhar);
		     
		     Employee_bo eb=new Employee_bo(name, email, phone, doj, dob, adhar);
		     
		    int status= Emp_dao.addEmployee(eb);
		    
		    if(status>0) {
		    	
		    	 RequestDispatcher rd=request.getRequestDispatcher("AllEmployeeController");
		    	 rd.forward(request, response);
		    	
		    }else {
		    	pw.print("Something went wrong!!!");
		    	RequestDispatcher rd=request.getRequestDispatcher("addemployee.html");
		    	 rd.include(request, response);
		    }
		     
	}

}
