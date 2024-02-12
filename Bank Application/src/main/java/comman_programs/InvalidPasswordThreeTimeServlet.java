package comman_programs;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/InvalidPasswordThreeTimeServlet")
public class InvalidPasswordThreeTimeServlet extends HttpServlet
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
		       int k=new InvalidPasswordThreeTimeDAO().invalidPasswordThreeTime(req,res);
		       if(k>0)
		       {			        
			        RequestDispatcher rd=req.getRequestDispatcher("InvalidPasswordThreeTime.jsp");
		            rd.forward(req,res);
		       }
	     }	  
  }
}