package View;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ImprimeDados", value = "/ImprimeDados")
public class ImprimeDados extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>ImprimeDados</title>");
        out.println("<meta charset=\"utf-8\"");
        out.println("</html>");
        out.println("<body>");
        out.println("<div>");
        out.println("<h3>Success, User created.</h3>");
        out.println("<table>");
        out.println("<tr><td>" + name + "</td></td>");
        out.println("<tr><td>" + email + "</td></td>");
        out.println("</table>");
        out.println("</div>");
        out.println("</body");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { }
}
