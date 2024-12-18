import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UpdateServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter print = response.getWriter();

        print.println("<html>");
        print.println("<head>");
        print.println("<meta charset='UTF-8'>");
        print.println("<style>");
        print.println("body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0; display: flex; justify-content: center; align-items: center; height: 100vh; background-image: url('https://plus.unsplash.com/premium_photo-1681248156475-f95f078846d5?q=80&w=1742&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D'); background-size: cover; background-position: center;}");
        print.println(".container { background-color: rgba(255, 255, 255, 0.9); padding: 20px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); width: 400px;}");
        print.println("h1 { text-align: center; color: #333; font-size: 24px; margin-bottom: 20px;}");
        print.println("table { width: 100%; border-spacing: 0; margin-bottom: 20px;}");
        print.println("td { padding: 10px; font-size: 14px; color: #555;}");
        print.println("input[type='text'], input[type='email'], input[type='password'] { width: 100%; padding: 8px; border: 1px solid #ccc; border-radius: 4px; font-size: 14px; margin: 5px 0;}");
        print.println("input[name='id'] { background-color: #f2f2f2; cursor: not-allowed; }");
        print.println("input[type='submit'] { background-color: #4CAF50; color: white; border: none; padding: 10px 20px; font-size: 16px; border-radius: 4px; cursor: pointer; width: 100%;}");
        print.println("input[type='submit']:hover { background-color: #45a049;}");
        print.println("</style>");
        print.println("</head>");
        print.println("<body>");
        
        print.println("<div class='container'>");
        print.println("<h1>Update Student Info</h1>");
        
        String stid = request.getParameter("id");
        int id = Integer.parseInt(stid);

        student s = studentsql.getid(id);
        
        print.println("<form action='UpdateServlet2' method='post'>");
        print.println("<table>");
        print.println("<tr><td>ID:</td><td><input name='id' value='" + s.getId() + "' readonly/></td></tr>");
        print.println("<tr><td>Name:</td><td><input type='text' name='name' value='" + s.getName() + "'/></td></tr>");
        print.println("<tr><td>Password:</td><td><input type='password' name='password' value='" + s.getPassword() + "'/></td></tr>");
        print.println("<tr><td>Email:</td><td><input type='email' name='email' value='" + s.getEmail() + "'/></td></tr>");
        print.println("<tr><td>Country:</td><td><input type='text' name='country' value='" + s.getCountry() + "'/></td></tr>");
        print.println("<tr><td colspan='2'><input type='submit' value='Submit'/></td></tr>");
        print.println("</table>");
        print.println("</form>");
        print.println("</div>");
        
        print.println("</body>");
        print.println("</html>");

        print.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Empty for now
    }
}
