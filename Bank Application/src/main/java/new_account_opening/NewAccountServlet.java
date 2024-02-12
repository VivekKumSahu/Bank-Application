package new_account_opening;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import comman_programs.BeanClass;
import javax.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/NewAccountServlet")
public class NewAccountServlet extends HttpServlet
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
		   BeanClass bc=new BeanClass();
		   long accountNo=Long.parseLong(new GenerateAccountNo().gernrateAccountNo());
		   bc.setAccountNo(accountNo);
		   bc.setName(req.getParameter("name"));
		   bc.setPassword(req.getParameter("password"));
		   bc.setFatherName(req.getParameter("father"));
		   bc.setAadhaarNo(Long.parseLong(req.getParameter("aadhar")));
		   bc.setDateOfBirth(req.getParameter("dob"));
		   bc.setContactNo(Long.parseLong(req.getParameter("contect")));
		   bc.setEmailId(req.getParameter("email"));
		   bc.setGender(req.getParameter("gender"));
		   bc.setOccupation(req.getParameter("occupation"));
		   bc.setAccountType(req.getParameter("accounttype"));
		   bc.setNominee(req.getParameter("nominee"));
		   bc.setAddress(req.getParameter("address"));
		   bc.setPhoto(new FileInputStream("C://Users//2608V//OneDrive//Pictures//Camera Roll//"+req.getParameter("photo")));
		   int k=new NewAccountDAO().newAccount(bc);
		   if(k>0)
		   {
			    String message="Account Created Successfull Your Account No Is This <strong>"+accountNo+"</strong> Please Note It Down It Will Be Required For Operating The Account.";
			    req.setAttribute("Message",message);		    
				RequestDispatcher rd=req.getRequestDispatcher("AccountCreatedSuccessfull.jsp");
				rd.forward(req,res);
		   }
		   else
		   {
			    req.setAttribute("Message","Account Creation Faild");
				RequestDispatcher rd=req.getRequestDispatcher("AccountCreationFailed.jsp");
				rd.forward(req,res);
		   }		   
	  }
  }
}