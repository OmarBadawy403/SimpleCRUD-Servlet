import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public SaveServlet() {
        super();}
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	   response.setContentType("text/html");
	   
	   PrintWriter print = response.getWriter();
	   
	   String name = request.getParameter("name");
	   String password = request.getParameter("password");
	   String email = request.getParameter("email");
	   String country = request.getParameter("country");

	   student st = new student();
	
	   st.setName(name);
	   st.setPassword(password);
	   st.setEmail(email);
	   st.setCountry(country);
	   
	
	  int num = studentsql.save(st);
	
	if (num >0){
		print.println("<h2> Save Succesfully ! <h2>");
		request.getRequestDispatcher("formSt.html").include(request, response);
	}else{
		print.println("<h2> Sorry Not Saveed ! <h2>");

		
	}
		
	}
	
	
	
	
	
	
	}