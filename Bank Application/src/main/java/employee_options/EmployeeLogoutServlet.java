package employee_options;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/EmployeeLogoutServlet")
public class EmployeeLogoutServlet extends HttpServlet
{
  protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
  {
	  HttpSession hs=req.getSession(false);
	  if(hs==null)
	  {
		  RequestDispatcher rd=req.getRequestDispatcher("SessionTimeOut.jsp");
		  rd.forward(req,res);		  
	  }
	  else
	  {
		  hs.invalidate();
		  PrintWriter pw=res.getWriter();
		  res.setContentType("text/html");
		  pw.println("<h1><strong style='color:#ff0f0f;'>Logout Successfull</strong></h1>");
		  RequestDispatcher rd=req.getRequestDispatcher("BankWelcomePage.html");
		  rd.include(req,res);
	  }	  
  }
}