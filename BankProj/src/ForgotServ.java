
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ForgotServ
 */
@WebServlet("/ForgotServ")
public class ForgotServ extends HttpServlet {
	// random number generator for otp
	Random rand= new Random();
	int otp=rand.nextInt(900000)+100000;
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// declare variable from form or credential
	String fromEmail=credintials.email; //sender's mail id.
	String pwd=credintials.pwd;		//sender's mail pwd.
	String email=req.getParameter("email");  //reciever's mail id.
	//email msg and subject
	String subject="DONT REPLY FOGOT PASSWORD"; // mail subject line
	String msg="hi user  this is the reset link : http://localhost:8089/BankProj/resetpwd.html ,also enter "  + otp; //mail body
	
	//setting the session for the first time so use true
	HttpSession session=req.getSession(true);
	session.setAttribute("email",email);
	session.setAttribute("otp",otp);	// the new session																	

	
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
			return new PasswordAuthentication(fromEmail, pwd);
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
	 resp.sendRedirect("/BankProj/resetpwd.html");

	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
}

