

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class resetpwdServ
 */
@WebServlet("/resetpwdServ")
public class resetpwdServ extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//declare the variable from form and credentials variables 

		int userotp=Integer.parseInt(req.getParameter("otp"));  //reciever's mail id.
		String newpwd=req.getParameter("newpwd");  //reciever's mail id.
		String confirmnewpwd=req.getParameter("confirmnewpwd");  //reciever's mail id.
		
		//get or set in session so can use in the later
		HttpSession session=req.getSession();
		String email=(String) session.getAttribute("email");
		int otp=(int) session.getAttribute("otp");
				
		if(userotp== otp) { //if user entered otp is the same as otp in email
		 if(newpwd.equals(confirmnewpwd)) {// if the password entered matches
			Model m=new Model();
			m.setEmail(email);
			m.setNewpwd(newpwd); // set methods for model

			
			int x = m.resetpwd();
			
			if(x==1) {
				System.out.println("Password has been reset");
				 resp.sendRedirect("/BankProj/Login.html");

			}
			else {
				System.out.println("Password was not reset");
				 resp.sendRedirect("/BankProj/FailedReset.html");

			}
		 }
	

		}else
		{
			System.out.println("OTP does not match");
			 resp.sendRedirect("/BankProj/WrongOTP.html");

		}
	}


}
