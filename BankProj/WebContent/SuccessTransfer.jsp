<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Successful Transfer</title>
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
<div class="successAttempt">
<h4>SUCCESSFUL TRANSFER</h4>

<p>
 <% out.println(session.getAttribute("name")); %>SENT $ <% out.println(session.getAttribute("transamount")); %>
</p>

</div>
      
</body>
</html>