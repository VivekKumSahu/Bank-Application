package balance_inquiry;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
import comman_programs.BeanClass;
import comman_programs.InsertIntoBankCountInvalidDAO;
import comman_programs.InvalidPasswordCheckingDAO;
import javax.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/BalanceInquiryServlet")
public class BalanceInquiryServlet extends HttpServlet
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
		  InvalidPasswordCheckingDAO ipc=new InvalidPasswordCheckingDAO();
		  if(ipc.invalidPasswordChecking(req,res))
	      {
			  ArrayList<BeanClass> al=new BalanceInquiryDAO().balanceInquiry(req,res);
			  if(al==null) 
			  {
				  new InsertIntoBankCountInvalidDAO().insertIntoBankCountInvalid(req,res);
				  PrintWriter pw=res.getWriter();
				  res.setContentType("text/html");
				  pw.println("<h1><strong style='color:#ff0f0f;'>Invalid Login Process</strong></h1>");
				  RequestDispatcher rd=req.getRequestDispatcher("BalanceInquiry.html");
				  rd.include(req,res);
			  }
			  else
			  {
				  ipc.deletecCount(req,res);
				  req.setAttribute("ArrayList",al);
				  req.setAttribute("BeanClass",new BalanceInquiryDAO().getCustomerDetails(req,res));
				  RequestDispatcher rd=req.getRequestDispatcher("BalanceInquiry.jsp");
				  rd.forward(req,res);
			  }
	      }
		  else
	      {
	    	  RequestDispatcher rd=req.getRequestDispatcher("InvalidPasswordThreeTimeServlet");
		      rd.forward(req,res);
	      }		  
	  }	  
  }
}