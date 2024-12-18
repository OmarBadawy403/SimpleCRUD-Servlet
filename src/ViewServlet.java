import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ViewServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter print = response.getWriter();

        print.print("<!DOCTYPE html>");
        print.print("<html>");
        print.print("<head>");
        print.print("<meta charset='UTF-8'>");
        print.print("<link href='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css' rel='stylesheet'>");
        print.print("<style>");
        print.print("body { font-family: Arial, sans-serif; background-color: #eaf4fc; background-image: url('https://images.unsplash.com/photo-1523050854058-8df90110c9f1?q=80&w=1740&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D'); background-size: cover; }");
        print.print("h1 { text-align: center; color: #2d4059; margin: 20px 0; }");
        print.print(".table-container { width: 85%; margin: 20px auto; background-color: #ffffffcc; padding: 15px; border-radius: 10px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); }");
        print.print(".table th, .table td { text-align: center; vertical-align: middle; }");
        print.print(".btn-add { display: block; width: 150px; margin: 20px auto; background-color: #2d4059; color: #fff; font-weight: bold; }");
        print.print(".btn-add:hover { background-color: #1b2838; color: #f5f5f5; }");
        print.print(".btn-edit, .btn-delete { color: #fff; font-weight: bold; }");
        print.print(".btn-edit { background-color: #4CAF50; }");
        print.print(".btn-edit:hover { background-color: #45a049; }");
        print.print(".btn-delete { background-color: #ff3333; }");
        print.print(".btn-delete:hover { background-color: #e60000; }");
        print.print("</style>");
        print.print("</head>");
        print.print("<body>");

        print.println("<div class='container'>");
        print.println("<h1 class='text-center'>Student Table</h1>");
        print.println("<a href='formSt.html' class='btn btn-add'>Add Student</a>");
        print.println("<div class='table-container'>");

        List<student> list = studentsql.getstudent();

        print.print("<table class='table table-hover table-bordered'>");
        print.print("<thead class='thead-light'>");
        print.print("<tr><th>ID</th><th>Name</th><th>Password</th><th>Email</th><th>Country</th><th>Update</th><th>Delete</th></tr>");
        print.print("</thead><tbody>");

        for (student st : list) {
            print.print("<tr>");
            print.print("<td>" + st.getId() + "</td>");
            print.print("<td>" + st.getName() + "</td>");
            print.print("<td>" + st.getPassword() + "</td>");
            print.print("<td>" + st.getEmail() + "</td>");
            print.print("<td>" + st.getCountry() + "</td>");
            print.print("<td><a href='UpdateServlet?id=" + st.getId() + "' class='btn btn-edit btn-sm'>Edit</a></td>");
            print.print("<td><a href='DeleteServlet?id=" + st.getId() + "' class='btn btn-delete btn-sm'>Delete</a></td>");
            print.print("</tr>");
        }

        print.print("</tbody></table>");
        print.print("</div>");  // end of table-container
        print.print("</div>");  // end of container
        print.print("</body>");
        print.print("</html>");

        print.close();
    }
}
