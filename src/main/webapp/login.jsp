<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="loginRegister" method="post">
<table style="background-color: skyblue; margin-left: 20px; margin-top: 20px; ">
<tr><td colspan="2">Login Page</td></tr>
<tr><td colspan="2">${message}</td></tr>
<tr><td colspan="2">${successMessage}</td></tr>
<tr><td>User Name:</td><td><input type="text" name ="username"></td> </tr>
<tr><td>Password:</td><td><input type="password" name ="password"></td> </tr>
<tr><td><input type="submit" name="sumbit" value="login"></td><td><a href="registration.jsp">registratiron</a></td> </tr>

</table>
</form>


</body>
</html>