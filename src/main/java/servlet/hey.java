package servlet;

import javax.servlet.*; // servlet library
import javax.servlet.http.*; // servlet library
import java.io.*; 
import javax.servlet.annotation.WebServlet;

@WebServlet(
        name = "MyServlet",
        urlPatterns = {"/hey"}
    )


public class hey extends HttpServlet // Inheriting from HttpServlet makes this a servlet
{
public void doGet (HttpServletRequest request, HttpServletResponse response)
                   throws ServletException, IOException
{
   response.setContentType("text/html"); // Tells the web container what we're sending back
   PrintWriter out = response.getWriter(); // Make it appear as if we're "writing" to the browser window

   out.println("<html>");
   out.println("<head>");
   out.println("<title>Casey Haley's Servlet example</title>");
   out.println("</head>");
   out.println("<body>");
   out.println("<p>Hello from the other side of the Web!</p>");
   out.println("</body>");
   out.println("</html>");
   out.close();
}  // end doGet()
}  // end Hello
