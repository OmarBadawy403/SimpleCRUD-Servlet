import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeleteServlet() {
        super();
    }

    protected void doPOST(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String getid = request.getParameter("id");
        if (getid != null) {
            int id = Integer.parseInt(getid);
            studentsql.delete(id);
        }
        response.sendRedirect("ViewServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String getid = request.getParameter("id");
        if (getid != null) {
            int id = Integer.parseInt(getid);
            studentsql.delete(id);
        }
        response.sendRedirect("ViewServlet");
    }
}
