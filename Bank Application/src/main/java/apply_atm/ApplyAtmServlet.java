package apply_atm;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import comman_programs.BeanClass;
import comman_programs.InsertIntoBankCountInvalidDAO;
import comman_programs.InvalidPasswordCheckingDAO;
import javax.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/ApplyAtmServlet")
public class ApplyAtmServlet extends HttpServlet
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
			  PrintWriter pw=res.getWriter();
			  res.setContentType("text/html");
			  if(new ChakingCardDAO().chakingCard(req,res))
			  {
				   BeanClass bc=new ApplyAtmDAO().applyAtm(req,res);
				   if(bc==null)
				   {	
					   new InsertIntoBankCountInvalidDAO().insertIntoBankCountInvalid(req,res);
					   pw.println("<h1><strong style='color:#ff0f0f;'>Invalid Login Process</strong></h1>");
	                   RequestDispatcher rd=req.getRequestDispatcher("ApplyATM.html");
	                   rd.include(req,res);
				   }
				   else
				   {
					   ipc.deletecCount(req,res);
					   req.setAttribute("BeanClass",bc);
					   req.setAttribute("Message","<h1><strong style='color:#ff0f0f;'>ATM Card Generated Successfull Your Details Are</strong></h1>");
					   RequestDispatcher rd=req.getRequestDispatcher("ApplyAtm.jsp");
					   rd.include(req,res);					   
				   }
			  }
			  else
			  {			  
				   pw.println("<h1><strong style='color:#ff0f0f;'>You Have One Active Card</strong></h1>");
				   RequestDispatcher rd=req.getRequestDispatcher("Main.html");
				   rd.include(req,res);				   
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