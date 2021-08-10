

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateProfileServ
 */
@WebServlet("/UpdateProfileServ")
public class UpdateProfileServ extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//declare the variable from form 

	String pwd=req.getParameter("pwd");
	String newpwd=req.getParameter("newpwd");
	String newcpwd=req.getParameter("newcpwd");
	
	
	if(newpwd.equals(newcpwd)) { //if the passwords match

	Model m = new Model();// new instance
	
	HttpSession session =req.getSession();
	//get from session and declare so as to use
	String username=(String) session.getAttribute("username");
	String name= (String) session.getAttribute("name");
	//set methods for model class to use
	m.setNewpwd(newpwd);
	m.setName(name);
	m.setPwd(pwd);
	m.setUsername(username);


	
	int x=m.UpdateProfile();
	if(x==0) {
		System.out.println("DATA DID NOT CHANGE");
		resp.sendRedirect("/BankProj/NoData.html");

	}
	else
	{
		System.out.println("DATA CHANGED");
		resp.sendRedirect("/BankProj/NewData.html");

	}
	}
	else
	{
		System.out.println("NVR READ THE DATA");
		resp.sendRedirect("/BankProj/NoData.html");

	}



	
	
}

}
