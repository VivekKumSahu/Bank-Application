package forgot_password;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/PasswordChangeServlet")
public class PasswordChangeServlet extends HttpServlet
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
		 ServletContext sc=req.getServletContext();
		 PrintWriter pw=res.getWriter();
		 res.setContentType("text/html");
		 if(req.getParameter("otp").equals(sc.getAttribute("otp"))&&
				         req.getParameter("newpassword").equals(req.getParameter("confirmpassword")))
		 {
			 hs.invalidate();
			 new PasswordChangeDAO().passwordChange(req,res);
			 pw.println("<h1><strong style='color:#ff0f0f;'>Password Change Process Successfull</strong></h1>");
			 RequestDispatcher rd=req.getRequestDispatcher("Main.html");
			 rd.include(req,res);
		 }
		 else 
		 {
			 pw.println("<h1><strong>Invalid OTP Or New Password And Confirm Password Not Matched</strong></h1>");
			 RequestDispatcher rd=req.getRequestDispatcher("ForgotPassword.html");
			 rd.include(req,res);
		 }		 
	 }	  
  }
}