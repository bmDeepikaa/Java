<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
    <link type="text/css" href="./css/style.css" rel="stylesheet">

</head>
<body>
<div class="topnav">	
  <h1 class="Appname">DeeBank</h1>
   <a href="/BankProj/home.jsp">Home</a>
  <a href="/BankProj/AddMoney.jsp">Deposit</a>
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
<div class="container1">
<h3>Welcome <% out.println(session.getAttribute("username")); %>!!!!
</h3>

<h5>NAME :  </h5>
<p><%out.println(session.getAttribute("name"));%></p>
<br>
<h5>EMAIL: </h5><p><%out.println(session.getAttribute("email"));%></p>
<br>
<h5>ACCOUNT NUMBER: </h5>
<p><%out.println(session.getAttribute("accno"));%></p>
<br>
<h5>BALANCE: </h5>
<p>$<%out.println(session.getAttribute("balance"));%></p>
</div>

</body>
</html>