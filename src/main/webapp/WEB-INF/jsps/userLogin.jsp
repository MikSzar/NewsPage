<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>User login</title>
	<style><%@include file="/WEB-INF/css/finalStyle.css"%></style>
</head>
<body>
<div style="padding-top: 15px; padding-bottom: 0; height: 160px; background: chocolate;">
	<img src="/images/logo.png" width="120" height="140"
		 style="margin-left: 30px" />
</div>
<div align="center">
	<h4>You can login now</h4>
	
	<form action="/login" method="post">
		<label>Username:</label><br /> <input type="text" name="username" /><br />
		<label>Password:</label><br /> <input type="password" name="password" /><br />
		<br /> <input class="button" type="submit" value="Login" /><br />
	</form>
</div>

</body>
</html>