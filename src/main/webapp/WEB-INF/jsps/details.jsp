<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>${news.name}</title>
	<style><%@include file="/WEB-INF/css/finalStyle.css"%></style>
	<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
</head>
<body>
<div style="padding-top: 15px; padding-bottom: 0; height: 160px; background: chocolate;">
	<img src="/images/logo.png" width="120" height="140"
		 style="margin-left: 30px" />
	<div class ="frame" style="float: right; padding-right: 0px; border-bottom: skyblue; margin-right: 20px">
		<a href="https://www.facebook.com/" class="btn">
			<i class="fab fa-facebook-f" style="color: #3b5998;"></i>
		</a>
		<a href="https://www.twitter.com/" class="btn">
			<i class="fab fa-twitter" style="color: #00acee;"></i>
		</a>
		<a href="https://www.dribble.com/" class="btn">
			<i class="fab fa-dribbble" style="color: #ea4c89;"></i>
		</a>
		<a href="https://www.linkedin.com/" class="btn">
			<i class="fab fa-linkedin-in" style="color:#0e76a8;"></i>
		</a>
		<a href="https://www.getpocket.com/" class="btn">
			<i class="fab fa-get-pocket" style="color:#ee4056;"></i>
		</a>
		<a href="https://www.gmail.com/" class="btn">
			<i class="far fa-envelope"></i>
		</a>
	</div>
</div>
<div align="center">
<td><img src="${news.imageurl}" width="800" height="600"
					style="margin-left: 30px" /></td>

	<h2>${news.name} is ${news.important}/10 of importance</h2>

	<h3>${news.description}.</h3>
	<br/>
	<br/>
	<p>This news was created by ${news.author}.</p>
</div>
<div class="footer">
	<h3 align="center">Share your news with us via e-mail: latestnews@ln.com</h3>
</div>
</body>
</html>