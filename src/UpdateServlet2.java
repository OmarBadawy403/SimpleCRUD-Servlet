

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UpdateServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public UpdateServlet2() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		response.setContentType("text/html");
		   
		   PrintWriter print = response.getWriter();
	
	
		   String stid = request.getParameter("id");
			
			 int id = Integer.parseInt(stid);
		   
		   String name = request.getParameter("name");
		   String password = request.getParameter("password");
		   String email = request.getParameter("email");
		   String country = request.getParameter("country");
	
			 student st = new student();
              
			 st.setId(id);
			 st.setName(name);
		     st.setPassword(password);
	         st.setEmail(email);
	         st.setCountry(country);
	         
	
	
	      int num = studentsql.update(st);
	
	      if (num >0){
	    	 
	    	  response.sendRedirect("ViewServlet");
	    	  
	      
	      }else{
	    	  
	    	  print.println("<h2> Sorry Not Updated </h2>");
	      }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
