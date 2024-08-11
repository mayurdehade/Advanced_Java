<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login here</title>
</head>
<body>
	<form action="login" style="text-align:center;">
		Username: <input type="text" name="user"> <br><br> 
		Password: <input type="text" name="pass"> <br><br>
		
		<%
		String msg = (String) request.getAttribute("msg");
		
		if(msg != null) {
			
		}
		%>
		
		
		<span style="color:red;">${msg}</span><br><br> 
		<input type="submit" value="Login">
		
	</form>
</body>
</html>