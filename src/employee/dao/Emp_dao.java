package employee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import employee.bo.Employee_bo;
import employee.bo.emp_bo;

public class Emp_dao {
    
	   public static Connection getConnection() {
		   
		     Connection con=null;
		   
		     try {
				
		    	 String url="jdbc:mysql://localhost:3306/employeemanagement?useSSL=false&allowPublicKeyRetrieval=true";
		    	 String username="root";
		    	 String password="root";
		    	 Class.forName("com.mysql.cj.jdbc.Driver");
		    	 con=DriverManager.getConnection(url,username,password);
		    	 
			} catch (Exception e) {
				System.out.println(e);
			}
		     
		   return con;
	   }
	
	   
	   public static int signup(emp_bo em) {
		   
		     int status=0;
		   
		   try {
		
			  Connection con=Emp_dao.getConnection();
			  String sql="insert into signup(name,email,phone,password) values(?,?,?,?)";
			  PreparedStatement ps=con.prepareStatement(sql); 
			  ps.setString(1, em.getName());
			  ps.setString(2, em.getEmail());
			  ps.setString(3, em.getPhone());
			  ps.setString(4, em.getPassword());
			  
			  status=ps.executeUpdate();
			   
			   
		} catch (Exception e) {
			
		   System.out.println(e);
		}
		     
		     
		     
		     return status;
	   }
	   
	   
	   
	   public static boolean userLogin(String email, String pass) {
		   
		     boolean status=false;
		   
		     try {
				
		    	Connection con=Emp_dao.getConnection();
		    	String sql="select *from signup where email=? And password=?"; 
		    	PreparedStatement ps=con.prepareStatement(sql);
		    	ps.setString(1, email);
		    	ps.setString(2, pass);
		    	
		    	ResultSet rs=ps.executeQuery();
		    	status=rs.next();
		    	 
			} catch (Exception e) {
				
				System.out.println(e);
				
			}
		     
		     
		     
		     
		     return status;
	   }
	   
	   
	   public static int addEmployee(Employee_bo eb) {
		   
		      int status=0;
		   
		      try {
				
		    	  Connection con=Emp_dao.getConnection();
		    	  String query="insert into addemployee(name,email,phone,doj,dob,adhar) values(?,?,?,?,?,?)";
		    	  PreparedStatement ps=con.prepareStatement(query);
		    	  ps.setString(1, eb.getName());
		    	  ps.setString(2, eb.getEmail());
		    	  ps.setString(3, eb.getPhone());
		    	  ps.setString(4, eb.getDoj());
		    	  ps.setString(5, eb.getDob());
		    	  ps.setString(6, eb.getAdhar());
		    	  
		    	  status=ps.executeUpdate();
		    	  
		    	  
		    	  
			} catch (Exception e) {
				// TODO: handle exception
			}
		      
		      
		      
		      
		      
		   return status;
	   }
	   
	   
	   
	   public static List getAllEmployee( ) {
		   
		        List<Employee_bo> list= new ArrayList<Employee_bo>();
		  try {
			    Connection con=Emp_dao.getConnection();
		        PreparedStatement ps=con.prepareStatement("select *from addemployee");
		        ResultSet rs=ps.executeQuery();
		        
		        while(rs.next()) {
		        	Employee_bo eb=new Employee_bo();
		        	eb.setId(rs.getInt(1));
		        	eb.setName(rs.getString(2));
		        	eb.setEmail(rs.getString(3));
		        	eb.setPhone(rs.getString(4));
		        	eb.setDoj(rs.getString(5));
		        	eb.setDob(rs.getString(6));
		        	eb.setAdhar(rs.getString(7));
                    list.add(eb);
		        	
		        }
			  
		} catch (Exception e) {
			System.out.println(e);
		}
		   
		   return list;
		   
	   }
	   
	   
	 public static Employee_bo getEmployeeById(int id) {
		 
		 Employee_bo eb= new Employee_bo();
		 
		   try {
		   	
			   Connection con=Emp_dao.getConnection();
			   String query="select *from addemployee where id=?";
			   
			   PreparedStatement ps=con.prepareStatement(query);
			   ps.setInt(1, id);

			   ResultSet rs=ps.executeQuery();
			   
			   if(rs.next()) {
				   
				   eb.setId(rs.getInt(1));
				   eb.setName(rs.getString(2));
				   eb.setEmail(rs.getString(3));
				   eb.setPhone(rs.getString(4));
				   eb.setDoj(rs.getString(5));
				   eb.setDob(rs.getString(6));
				   eb.setAdhar(rs.getString(7));
				   
			   }
			   
			   
			   
		} catch (Exception e) {
		
			System.out.println(e);
			
		}
		  
		  
		  return eb;
	 }
	   
	
	 public static int Update(Employee_bo eb) {
		 int status=0;
		 
		 try {
			
			 Connection con=Emp_dao.getConnection();
			 
			 String query="update addemployee set name=?,Email=?,Phone=?, doj=?,dob=?,adhar=? where id=?";
			 PreparedStatement ps=con.prepareStatement(query);
			 ps.setString(1, eb.getName());
			 ps.setString(2, eb.getEmail());
	         ps.setString(3, eb.getPhone());
	         ps.setString(4, eb.getDoj());
	         ps.setString(5, eb.getDob());
	         ps.setString(6, eb.getAdhar());
	         ps.setInt(7, eb.getId());
			 
	         status=ps.executeUpdate();
	         
	         
	         
		} catch (Exception e) {
			
			System.out.println(e);
			
		}
		 
		 
		 return status;
	 }
	 
	public static int delete(int id) {
		
		int status=0;
		  try {
		
			  Connection con=Emp_dao.getConnection();
			  String query="Delete from addemployee where id=?";
			  PreparedStatement ps=con.prepareStatement(query);
			  ps.setInt(1, id);
			  status=ps.executeUpdate();
			  
		} catch (Exception e) {
		
			   System.out.println(e);
		}
		
		return status;
		
	}
	 
	 
}
