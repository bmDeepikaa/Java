

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class RegisterServ
 */
@WebServlet("/RegisterServ")
public class RegisterServ extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//declare the variable from form and variables from credential 

		String fromEmail=credintials.email; //sender's mail id.
		String Credpwd=credintials.pwd;		//sender's mail pwd.

		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String username=req.getParameter("username");
		String pwd=req.getParameter("pwd");
		String cpwd=req.getParameter("cpwd");
		String accno=req.getParameter("accno");
		String balance=req.getParameter("balance");

		//email subject nad msg
		String subject="DONT REPLY: WELCOME!"; // mail subject line
		String msg="WELCOME "+name+" Click here to continue: http://localhost:8089/BankProj/Login.html"
				+ "this is ur current balance: "  + balance +" this will be your account number : "+accno; //mail body


		if(pwd.equals(cpwd)) {
			Model m = new Model(); // instance of model
			//set methods for m class to use in sql database checking
			m.setName(name);
			m.setEmail(email);
			m.setUsername(username);
			m.setPwd(pwd);
			m.setAccno(Integer.parseInt(accno));
			m.setBalance(Double.parseDouble(balance));
			
			int x= m.Register();
			if(x==0) {
				resp.sendRedirect("/BankProj/DidNotReg.html");
				System.out.println("DID NOT REGISTER");
			}else {
				//Creating Session Object
				Properties prop = new Properties();
				prop.put("mail.smtp.host", "smtp.gmail.com");
				prop.put("mail.smtp.port", 587);
				prop.put("mail.smtp.auth", "true");
				prop.put("mail.smtp.starttls.enable", "true");
				
				Session session1 = Session.getDefaultInstance(prop, new javax.mail.Authenticator()
				{
					protected PasswordAuthentication getPasswordAuthentication()
					{
						//sender's mail id and pwd is encapsulated inside "SendersCredentials.java"
						return new PasswordAuthentication(fromEmail, Credpwd);
					}
				});
				try {
					//Composing the Mail
					MimeMessage mesg = new MimeMessage(session1);
					mesg.setFrom(new InternetAddress(fromEmail));
					mesg.addRecipient(Message.RecipientType.TO,new InternetAddress(email));
					mesg.setSubject(subject);  
					mesg.setText(msg);  
					
					//Sending the Mail
					Transport.send(mesg);
					System.out.println("Mail Sent!!");
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				
				resp.sendRedirect("/BankProj/Login.html");
				System.out.println("SUCCESSFULLY REGISTERED");
			}
		
	}
		else {
			resp.sendRedirect("/BankProj/WentWrong.html");
			System.out.println("REGISTRATION WENT WRONG -PASSWORDS DONT MATCH");

			}


	}
}
