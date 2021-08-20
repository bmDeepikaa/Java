

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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TransferServ
 */
@WebServlet("/TransferServ")
public class TransferServ extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//declare the variable from form  and credentials

	String fromEmail=credintials.email; //sender's mail id.
	String Credpwd=credintials.pwd;		//sender's mail pwd.
	String pwd=req.getParameter("pwd");
	String raccno=req.getParameter("raccno"); //acc i am sending money to
	String transamount=req.getParameter("transamount"); // the amount i am sending
	
	String subject="DONT REPLY:SUCCESSFUL TRANSACTION"; // mail subject line
	String msg="As you requested we have transferred $"+transamount+" from your account to Account number "+raccno ; //mail body
	
	
	Model m = new Model();// instance of model class

	HttpSession session=req.getSession();
	int accno = (int) session.getAttribute("accno");
	String name=(String) session.getAttribute("name");
	String email=(String) session.getAttribute("email");
	Double curbalance=(Double) session.getAttribute("balance");
    Double transamount1 = (Double.parseDouble(transamount));
	Double balance=curbalance-transamount1;

	session.setAttribute("raccno", accno);
	session.setAttribute("transamount", transamount);
	session.setAttribute("balance", balance);


	//set the methods for model class to retrieve from
	m.setPwd(pwd);
	m.setAccno(accno);
	m.setName(name);
	m.setRaccno(Integer.parseInt(raccno));
	m.setTransamount(Double.parseDouble(transamount));
	
	int x=m.Transfer();
	if(x==0) {
		System.out.println("DID NOT SEND MONEY/NOT ENOUGH BALANCE IN YOUR ACCOUNT");
		resp.sendRedirect("/BankProj/FailedTransfer.jsp");

	}
	else
	{
		resp.sendRedirect("/BankProj/SuccessTransfer.jsp");

		System.out.println("SUCCESS TRANSFER OF MONEY");
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

	}

	
	

}
}
