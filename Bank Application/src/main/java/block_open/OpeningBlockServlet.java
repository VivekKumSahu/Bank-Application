package block_open;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/OpeningBlockServlet")
public class OpeningBlockServlet extends HttpServlet
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
		 if(req.getParameter("otp").equals(sc.getAttribute("otp")))
		 {			 
			 new OpeningBlockDAO().openingBlock(req,res);
			 hs.invalidate();
			 pw.println("<h1><strong style='color:#ff0f0f;'>Block Open Successfull</strong></h1>");
			 RequestDispatcher rd=req.getRequestDispatcher("Main.html");
			 rd.include(req,res);
		 }
		 else 
		 {
			 pw.println("<h1><strong>Invalid OTP Try Again</strong></h1>");
			 RequestDispatcher rd=req.getRequestDispatcher("BlockOpen.html");
			 rd.include(req,res);
		 }		 
	 }	  
  }
}