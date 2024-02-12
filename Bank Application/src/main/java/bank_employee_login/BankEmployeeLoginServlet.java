package bank_employee_login;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/BankEmployeeLoginServlet")
public class BankEmployeeLoginServlet extends HttpServlet
{
@SuppressWarnings("unused")
protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
  {
	   if(new BankEmployeeLoginDAO().employeeLogin(req,res)>0)
	   {
		    HttpSession hs=req.getSession();
		    RequestDispatcher rd=req.getRequestDispatcher("EmployeeOptionPage.html");
			rd.forward(req,res);
	   }
	   else
	   {
		    PrintWriter pw=res.getWriter();
			res.setContentType("text/html");
	        pw.println("<h1><strong style='color:#ff0f0f;'>Invalid UserName Or Password</strong></h1>");
			RequestDispatcher rd=req.getRequestDispatcher("AuthorizedPersonLoginPage.html");
			rd.include(req,res);
	   }
  }
}