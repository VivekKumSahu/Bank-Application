package view_atm_card_details;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import apply_atm.ChakingCardDAO;
import comman_programs.BeanClass;
import comman_programs.InsertIntoBankCountInvalidDAO;
import comman_programs.InvalidPasswordCheckingDAO;
import javax.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/ViewATMCardDetailsServlet")
public class ViewATMCardDetailsServlet extends HttpServlet
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
			  if(!(new ChakingCardDAO().chakingCard(req,res)))
			  {
				   BeanClass bc=new ViewATMCardDetailsDAO().viewATMCardDetails(req,res);
				   if(bc==null)
				   {	
					   new InsertIntoBankCountInvalidDAO().insertIntoBankCountInvalid(req,res);
					   pw.println("<h1><strong style='color:#ff0f0f;'>Invalid Login Process</strong></h1>");
	                   RequestDispatcher rd=req.getRequestDispatcher("ViewATMCardDetails.html");
	                   rd.include(req,res);
				   }
				   else
				   {
					   ipc.deletecCount(req,res);
					   req.setAttribute("BeanClass",bc);
					   RequestDispatcher rd=req.getRequestDispatcher("ApplyAtm.jsp");
					   rd.include(req,res);					   
				   }
			  }
			  else
			  {			  
				   pw.println("<h1><strong style='color:#ff0f0f;'>Card Not Generated Frist Apply To ATM Card</strong></h1>");
				   RequestDispatcher rd=req.getRequestDispatcher("ApplyATM.html");
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