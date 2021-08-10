

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServ
 */
@WebServlet("/LogoutServ")
public class LogoutServ extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session=req.getSession();
	session.invalidate(); // get rid off all the session data
	resp.sendRedirect("/BankProj/index.html");
	}
	

}
