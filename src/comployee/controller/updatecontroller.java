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
 * Servlet implementation class updatecontroller
 */
@WebServlet("/updatecontroller")
public class updatecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatecontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	            response.setContentType("text/html");
	            PrintWriter pw=response.getWriter();
	            
	           
	           int id=Integer.parseInt(request.getParameter("id")); 
	            
	           String name= request.getParameter("name");
	           String email= request.getParameter("email");
	           String phone= request.getParameter("phone");
	           String doj= request.getParameter("doj");
	           String dob= request.getParameter("dob");
	           String adhar= request.getParameter("adhar");
	           
	           
	           Employee_bo eb=new Employee_bo();
	           eb.setId(id);
	           eb.setName(name);
	           eb.setEmail(email);
	           eb.setPhone(phone);
	           eb.setDoj(doj);
	           eb.setDob(dob);
	           eb.setAdhar(adhar);
	           
	          int status= Emp_dao.Update(eb);
	          
	          if(status>0) {
	        	   
	        	  RequestDispatcher rd=request.getRequestDispatcher("AllEmployeeController");
	        	    rd.forward(request, response);
	        	    
	          }
	
	         
	}

}
