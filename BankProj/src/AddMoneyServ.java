

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
 * Servlet implementation class AddMoneyServ
 */
@WebServlet("/AddMoneyServ")
public class AddMoneyServ extends HttpServlet {
	

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//new variables from form or credntial
		String amount=req.getParameter("amount");
		String fromEmail=credintials.email; //sender's mail id.
		String Credpwd=credintials.pwd;		//sender's mail pwd.

		
		Model m=new Model();// call model
		
		HttpSession session=req.getSession(); //set or get from session
		
		Double newbalance=(Double) session.getAttribute("balance");
	    Double amount1 = (Double.parseDouble(amount));
		Double balance=newbalance+amount1;

		String name= (String) session.getAttribute("name");
		int accno= (int) session.getAttribute("accno");
		String pwd= (String) session.getAttribute("pwd");
		String email=(String) session.getAttribute("email");
		
		//set for the model to use in query
		m.setName(name);
		m.setPwd(pwd);
		m.setBalance(balance);       
		m.setAccno(accno);
		m.setEmail(email);

		//Email subject and message
		String subject="DONT REPLY:SUCCESSFUL DEPOSIT"; // mail subject line
		String msg= name +", You have successfully deposited: $"+amount+" into your account today"; //mail body
		//call method from model
		int x= m.AddMoney();
		if(x==0)
		{
			resp.sendRedirect("/BankProj/NoMoney.html");

		}
		else
		{
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

		
//success
			resp.sendRedirect("/BankProj/Money.html");
			

		}
	}
	

