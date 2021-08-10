<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transfer Failed</title>
<link type="text/css" href="./css/style.css" rel="stylesheet">

</head>
<body>
<div class="topnav">	
  <h1 class="Appname">DeeBank</h1>
   <a href="/BankProj/home.jsp">Home</a>
  <a href="/BankProj/AddMoney.jsp">Deposit </a>
    <a href="Transfer.jsp">Transfer</a>
    <a href="UpdateProfile.jsp">Edit profile</a>  
    <form action="LogoutServ">
  <a href="/BankProj/index.html">Logout</a>
  </form>
</div>
<br>
<br>
<br>
<br>
<br>
<div class="failedAttempt">
<h4>TRANSFER FAILED</h4>

<p>
YOU DO NOT HAVE ENOUGH BALANCE IN YOUR ACCOUNT <% out.println(session.getAttribute("name")); %> OR THE ACCOUNT YOU SENT MONEY TO DOES NOT EXIST. 
</p>
<p>
YOU HAVE $<%out.println(session.getAttribute("balance"));%> IN YOUR ACCOUNT
</p>
<P><a href="AddMoney.jsp">TOP UP</a> OR<a href="Transfer.jsp"> SEND LESSER AMOUNT</a>OR PLEASE CHECK ACCOUNT NUMBER BEFORE SENDING</P>

</div>
      
</body>
</html>