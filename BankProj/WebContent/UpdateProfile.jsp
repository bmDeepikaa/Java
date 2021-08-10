<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update profile</title>
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



<form action="UpdateProfileServ">
  <div class="container">
  <br>
  <br>
  <br>
  <br>
    <h1>Update profile</h1>
    <p>Please fill in this form to update your particulars</p>
    <hr>
   <h5>USER NAME:
    <%
    out.println(session.getAttribute("username"));
    %></h5>
    <h5>EMAIL:
    <%
    out.println(session.getAttribute("email"));
    %></h5>
    <h5>ACCOUNT NUMBER:
    <%
    out.println(session.getAttribute("accno"));
    %></h5>
 
    <br>
    
    <label><b>Old Password</b></label>
    <input type="password" placeholder="Enter old Password" name="pwd" id="pwd" >
    
 	<label><b>New Password</b></label>
    <input type="password" placeholder="Enter new Password" name="newpwd" id="newpwd" >

    <label><b>Repeat Password</b></label>
    <input type="password" placeholder="Repeat new Password" name="newcpwd" id="newcpwd" >

<hr>
<hr>
 
    <button type="submit" class="registerbtn">Submit changes</button>
    </div>
    </form> 
   
    
  
    
</body>
</html>