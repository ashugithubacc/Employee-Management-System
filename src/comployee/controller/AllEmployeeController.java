package comployee.controller;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employee.bo.Employee_bo;
import employee.dao.Emp_dao;

/**
 * Servlet implementation class AllEmployeeController
 */
@WebServlet("/AllEmployeeController")
public class AllEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllEmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		   response.setContentType("text/html");
		   PrintWriter pw=response.getWriter();
		   
		   
		   pw.print("<a href='home.html'>Back</a>");
		   
		   pw.print("<table border='1px' width='100%'> ");
		    
		    pw.print("<tr> <th> Id </th> <th> Name </th> <th> Email </th> <th> Phone </th> <th> Date Of Joining</th> <th> Date Of Birth</th> <th> Adhar Details</th> <th> Actions</th></tr>");
		   
		   
		   
		  List<Employee_bo> list= Emp_dao.getAllEmployee();
		   
		  for(Employee_bo eb:list) {
			  
			   pw.print("<tr><td>"+eb.getId()+"</td><td>"+eb.getName()+"</td><td>"+eb.getEmail()+"</td><td>"+eb.getPhone()+"</td><td>"+eb.getDoj()+"</td><td>"+eb.getDob()+"</td><td>"+eb.getAdhar()+"</td><td>"+"<a href='EditServlet2?id="+eb.getId()+"'> edit </a> </td> <td><a href='DeleteServlet?id="+eb.getId()+"'>delete </a></td></tr>"); 
			  
		  }
		   
		  pw.print("</table>");
	}

}
