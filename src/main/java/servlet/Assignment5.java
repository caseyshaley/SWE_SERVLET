/**********************************************************************
Buttons.java   servlet example

        @author Jeff Offutt
********************************************************************* */

// Import Java Libraries
import java.io.*;
import java.util.*;

//Import Servlet Libraries
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

// twoButtons class
// CONSTRUCTOR: no constructor specified (default)
//
// ***************  PUBLIC OPERATIONS  **********************************
// public void doPost ()  --> prints a blank HTML page
// public void doGet ()  --> prints a blank HTML page
// private void PrintHead (PrintWriter out) --> Prints the HTML head section
// private void PrintBody (PrintWriter out) --> Prints the HTML body with
//              the form. Fields are blank.
// private void PrintBody (PrintWriter out, String lhs, String rhs, String rslt)
//              Prints the HTML body with the form.
//              Fields are filled from the parameters.
// private void PrintTail (PrintWriter out) --> Prints the HTML bottom
//***********************************************************************

@WebServlet(
	name = "MyServlet",
	urlPatterns = {"assignment5"}
    )

public class Assignment5 extends HttpServlet
{

// Location of servlet.
static String Domain  = "caseys-servlet.herokuapp.com";
static String Path    = "/";
static String Servlet = "assignment5";

// Other strings.
static String Style ="https://www.cs.gmu.edu/~offutt/classes/432/432-style.css";

/** *****************************************************
 *  Overrides HttpServlet's doPost().
 *  Converts the values in the form, performs the operation
 *  indicated by the submit button, and sends the results
 *  back to the client.
********************************************************* */
public void doPost (HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException
{
   String operation = request.getParameter("Operation");
   String logValue = "hi";
   String varValue = "hey";

   /*if (operation.equals(OperationAdd))
   {
      rslt = new Float(lhsVal.floatValue() + rhsVal.floatValue());
   }
   else if (operation.equals(OperationSub))
   {
      rslt = new Float(lhsVal.floatValue() - rhsVal.floatValue());
   }*/

   response.setContentType("text/html");
   PrintWriter out = response.getWriter();
   PrintHead(out);
   PrintBody(out, logValue, varValue);
   PrintTail(out);
}  // End doPost

/** *****************************************************
 *  Overrides HttpServlet's doGet().
 *  Prints an HTML page with a blank form.
********************************************************* */
public void doGet (HttpServletRequest request, HttpServletResponse response)
       throws ServletException, IOException
{
   response.setContentType("text/html");
   PrintWriter out = response.getWriter();
   PrintHead(out);
   PrintBody(out);
   PrintTail(out);
} // End doGet

/** *****************************************************
 *  Prints the <head> of the HTML page, no <body>.
********************************************************* */
private void PrintHead (PrintWriter out)
{
   out.println("<html>");
   out.println("");

   out.println("<head>");
   out.println("<title>Assignment 5</title>");
   out.println(" <link rel=\"stylesheet\" type=\"text/css\" href=\"" + Style + "\">");
   out.println("</head>");
   out.println("");
} // End PrintHead

/** *****************************************************
 *  Prints the <BODY> of the HTML page with the form data
 *  values from the parameters.
********************************************************* */
private void PrintBody (PrintWriter out, String logExpression, String varValues)
{
   out.println("<body>");
   out.println("<p><a href=\"https://\" + Domain + Path>Return to Home</a></p>");
   out.println("<h3>Logic Calculator</h3>");
   out.println("<h4>SWE 432</h4>");
   out.println("<h4>Collaborators: Fahad Ibrahim, Casey Haley</h4>");
   out.println("    <div class=\"container\">");
   out.println("        <div class=\"inner\" style=\"width: 50%\">");
   out.print  ("            <form method=\"post\"");
   out.println(" action=\"https://\" + Domain + Path + Servlet + \"\">");
   out.println("");
   out.println("                <div>Instructions: </div>");
   out.println("                <ul>");
   out.println("                    <li>Valid Variable values: 0,1</li>");
   out.println("                    <li>Valid Logic Syntax values: OR, AND, NOT</li>");
   out.println("                    <li>Variables must appear in both inputs bellow</li>");
   out.println("                </ul");
   out.println("                <label for=\"var\">Enter Variable Values</label><br>");
   out.println("                <textarea id=\"var\" name=\"subject\" value=\" + varValues + \"");
   out.println("                    placeholder=\"Example: A = 1, B = 0,....\" style=\"height: 50px\"></textarea><br>");
   out.println("                <label for=\"expression\">Enter Logic Expression</label><br>");
   out.println("                <textarea id=\"expression\" name=\"subject\" value=\" + logValues + \"");
   out.println("                    placeholder=\"Example: A AND B OR C ....\" style=\"height: 50px\"></textarea>");
   out.println("                <input type=\"submit\" value=\"Submit\">");
   out.println("");
   out.println("            </form><br>");
   out.println("            <div class=\"dom\">");
   out.println("                <button onclick=\"clearTextArea()\">Clear All Fields</button>");
   out.println("                <button onclick=\"resetBoxSize()\">Reset Textbox Size</button>");
   out.println("            </div>");
   out.println("        </div>");
   out.println("    </div>");
   out.println("    <h5>Collaboration Summary:</h5>");
   out.print  ("    <p>Fahad created the style of the entire page and the styling for the buttons, textboxs, </p>");
   out.println("etc. He also handled the sending of the information using the form given to us. Casey tested out ");
   out.println("the final product to see if anything could go wrong with it, and wrote up the collaboration ");
   out.println("paragraph. He also gave some feedback if more work is going to be done with this.</p>");
   out.println("</body>");
} // End PrintBody

/** *****************************************************
 *  Overloads PrintBody (out,lhs,rhs,rslt) to print a page
 *  with blanks in the form fields.
********************************************************* */
private void PrintBody (PrintWriter out)
{
   PrintBody(out, "", "");
}

/** *****************************************************
 *  Prints the bottom of the HTML page.
********************************************************* */
private void PrintTail (PrintWriter out)
{
   out.println("");
   out.println("</html>");
} // End PrintTail

}  // End twoButtons
