<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login</title>
	</head>
	<body>
		<h1>Login</h1>
	   	<h3>Enter user name and password:</h3>  
	     
	   	<form name='f' action="login" method='POST' >
	      <table>
	         <tr>
	            <td>User:</td>
	            <td><input type='text' name='username' value=''></td>
	         </tr>
	         <tr>
	            <td>Password:</td>
	            <td><input type='password' name='password' /></td>
	         </tr>
	         <tr>
	            <td><input name="submit" type="submit" value="submit" /></td>
	         </tr>
	      </table>
	  	</form>
	</body>
</html>