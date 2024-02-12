package employee_options;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import comman_programs.BeanClass;
import javax.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/ViewCustomerFullDetailsServlet")
public class ViewCustomerFullDetailsServlet extends HttpServlet
{
  protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
  { 
	  HttpSession hs=req.getSession(false);
	  if(hs==null)
	  {
		  RequestDispatcher rd=req.getRequestDispatcher("SessionTimeOut.jsp");
		  rd.forward(req,res);		  
	  }
	  else
	  {
		  BeanClass bc=new ViewCustomerFullDetailsDAO().viewCustomerFullDetails(req,res);
		  if(bc==null) 
		  {
			  PrintWriter pw=res.getWriter();
			  res.setContentType("text/html");
			  pw.println("<h1><strong style='color:#ff0f0f;'>Invalid Account No</strong></h1>");
			  RequestDispatcher rd=req.getRequestDispatcher("EmployeeCheckingFullDetailsOfCustomer.html");
			  rd.include(req,res);
		  }
		  else
		  {
			  req.setAttribute("BeanClass",bc);
			  RequestDispatcher rd=req.getRequestDispatcher("ViewCustomerFullDetails.jsp");
			  rd.forward(req,res);
		  }
	  }	  
  }
}