package employee_options;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import comman_programs.BeanClass;

@SuppressWarnings("serial")
@WebServlet("/ViewAllCustomerServlet")
public class ViewAllCustomerServlet extends HttpServlet
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
		  ArrayList<BeanClass> al=new ViewAllCustomerDAO().viewAll(req,res);
		  req.setAttribute("ArrayList",al);
		  RequestDispatcher rd=req.getRequestDispatcher("ViewAllCustomer.jsp");
		  rd.forward(req,res);
	  }	  
  }
}