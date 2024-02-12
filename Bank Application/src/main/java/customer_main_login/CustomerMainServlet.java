package customer_main_login;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/CustomerMainServlet")
public class CustomerMainServlet extends HttpServlet
{
@SuppressWarnings("unused")
protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
  {
	   HttpSession hs=req.getSession();
	   String temp=(String)req.getParameter("goto");
	   if(temp.equals("Apply To ATM"))
	   {
		   RequestDispatcher rd=req.getRequestDispatcher("ApplyATM.html");
		   rd.forward(req,res);
	   }
	   else if(temp.equals("Withdraw"))
	   {
		   RequestDispatcher rd=req.getRequestDispatcher("AmountWithdraw.html");
		   rd.forward(req,res);
	   }
	   else if(temp.equals("View Passbook"))
	   {
		   RequestDispatcher rd=req.getRequestDispatcher("ViewPassbook.html");
		   rd.forward(req,res);
	   }
	   else if(temp.equals("Open New Account"))
	   {
		   RequestDispatcher rd=req.getRequestDispatcher("AccountOpeningForm.html");
		   rd.forward(req,res);
	   }
	   else if(temp.equals("Deposit"))
	   {
		   RequestDispatcher rd=req.getRequestDispatcher("AmountDeposit.html");
		   rd.forward(req,res);
	   }
	   else if(temp.equals("Balance Inquiry"))
	   {
		   RequestDispatcher rd=req.getRequestDispatcher("BalanceInquiry.html");
		   rd.forward(req,res);
	   }
	   else
	   {
		   RequestDispatcher rd=req.getRequestDispatcher("ViewATMCardDetails.html");
		   rd.forward(req,res);
	   }
  }
}