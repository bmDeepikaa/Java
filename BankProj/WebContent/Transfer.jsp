<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transfer</title>
    <link type="text/css" href="./css/style.css" rel="stylesheet">

</head>
<body>
<div class="topnav">	
  <h1 class="Appname">DeeBank</h1>
  
      <a href="/BankProj/home.jsp">Home</a>
   
  <a href="AddMoney.jsp">Deposit </a>
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

<div class="container">
<h1>Transfer</h1>

<h5><%
out.println(session.getAttribute("username"));
%> Are you ready to send money??
</h5>
<hr>
<h5>The balance in your account:  </h5>
<p>
$<%
out.println(session.getAttribute("balance"));
%>
</p>
<br>
<h5>Your Account Number: </h5>
<p>
<%
out.println(session.getAttribute("accno"));
%>
</p>
<br>
    <form action="TransferServ">

    <label><b>Account number you would like to transfer to:</b></label>
    <input type="number" placeholder="Account number" name="raccno" id="raccno" >
    
      <label><b>How much you would like to transfer to:</b></label>
    <input type="number" placeholder="Money " name="transamount" id="transamount" >
    
     <label><b>Enter your password to confirm transfer:</b></label>
    <input type="password" placeholder="pwd" name="pwd" id="pwd" >
    
        <button type="submit" class="registerbtn">Transfer</button>
    </form>
</div>



</body>
</html>