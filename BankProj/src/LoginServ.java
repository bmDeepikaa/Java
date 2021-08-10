

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServ
 */
@WebServlet("/LoginServ")
public class LoginServ extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//declare the variable from form 
 String username = req.getParameter("username");
 String password = req.getParameter("pwd");
 
 
 Model m= new Model(); // call model and create instance
 m.setUsername(username); //setting the variables for model method to use(sqL)
 m.setPwd(password);
 int user=m.Login();
 if (user==1) {
	 //if user true decalre all the variables so can st in session to use later
	 String name=m.getName();
	 String email=m.getEmail();
	 int accno=m.getAccno();
	 Double balance=m.getBalance();
	 String pwd=m.getPwd(); 
	 String newpwd=m.getNewpwd();
	 HttpSession session=req.getSession(true);
	 session.setAttribute("username", username);
	 session.setAttribute("name", name);
	 session.setAttribute("email", email);
	 session.setAttribute("accno", accno);
	 session.setAttribute("balance", balance);
	 session.setAttribute("pwd",pwd);
	 session.setAttribute("newpwd", newpwd);
	 
	 
	 resp.sendRedirect("/BankProj/home.jsp");
 }
 else
 {
	 System.out.println("LOGIN FAILED");
	 resp.sendRedirect("/BankProj/LoginFailed.jsp");


 }
 

 
}
}
