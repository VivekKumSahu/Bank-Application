package deposit;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import comman_programs.InsertIntoBankCountInvalidDAO;
import comman_programs.InvalidPasswordCheckingDAO;
import javax.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/AmountDepositServlet")
public class AmountDepositServlet extends HttpServlet
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
		      double currentBalance=new AmountDepositDAO().amountDeposit(req,res);
		      PrintWriter pw=res.getWriter();
		      res.setContentType("text/html");
		      if(currentBalance==0) 
		      {
		    	   new InsertIntoBankCountInvalidDAO().insertIntoBankCountInvalid(req,res);
			       pw.println("<h1><strong style='color:#ff0f0f;'>Invalid AccountNo Or Password</strong></h1>");
			       RequestDispatcher rd=req.getRequestDispatcher("AmountDeposit.html");
			       rd.include(req,res);
		      }
		      else 
		      {
		    	   ipc.deletecCount(req,res);
		    	   hs.invalidate();
			       pw.println("<h1><strong>Amount Created Successfull...</strong></h1>");
			       pw.println("<h1><strong style='color:#ff0f0f;'>Account Balance="+currentBalance+"</strong></h1>");
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