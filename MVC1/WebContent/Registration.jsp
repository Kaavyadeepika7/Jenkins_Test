<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration</title>
</head>
<%
	String message = "";
	if (request.getAttribute("message") != null) {
		message = request.getAttribute("message").toString();
	}
%>
<body style="text-align: center;">
	<h1 style="text-align: center; color: navy;">Registration Form</h1>
	<span style="color: red;"><%=message%></span>
	<form method="post" action="RegistrationController">
		<table align="center">
			<tr>
				<td>User Name</td>
				<td><input type="text" name="fname" id="fname" />
				</td>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lname" id="lname" />
				</td>
			<tr>
				<td>Password</td>
				<td><input type="password" name="pwd" id="pwd" />
				</td>
			<tr>
				<td>Address</td>
				<td><textarea rows="4" cols="15" name="address"></textarea>
				</td>
			</tr>
			<tr>
				<td>Age</td>
				<td><input type="text" name="age" />
				</td>
			</tr>
			<tr>
				<td>Country</td>
				<td><select name="country" id="country">
						<option selected="selected" value="select">
						<option value="India">India</option>
						<option value="Australia">Australia</option>
						<option value="England">England</option>
				</select>
				</td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><input type="radio" name="gender" value="Male" /> Male <input
					type="radio" name="gender" value="Female" /> Female</td>
			</tr>
			<tr>
				<td><input type="submit" name="Register" value="Register" />
				</td>
				<td><input type="reset" name="reset" value="Reset"></td>
			</tr>
		</table>
	</form>
</body>
</html>