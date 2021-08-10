<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add money</title>
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



<h5>NAME :  </h5>
<p>
<%
out.println(session.getAttribute("username"));
%>
</p>
<form action="AddMoneyServ">
  <div class="container">
    <h1>Add Balance</h1>
    <p>How much would you like to add to your bank account
    <%
    out.println(session.getAttribute("accno"));
    %></p>
    <hr>
    <h5>NAME :  
<%
out.println(session.getAttribute("name"));
%>
</h5>

    
     <label ><b>AMOUNT:</b></label>
    <input type="number" placeholder="Enter balance" name="amount" id="amount" required>
 
    <button type="submit" class="loginbtn">ADD</button>
  </div>

  
</form>

</body>
</html>