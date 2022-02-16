<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<style><%@include file="/WEB-INF/css/finalStyle.css"%></style>
	<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
</head>
<body>

	<div
		style="padding-top: 15px; padding-bottom: 0; height: 160px; background: chocolate;">
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

		<div
			style="float: right; padding-right: 50px; border-bottom: skyblue; margin-right: 16px; font-size: 18px;">

			<h3>Go to Login/Registration:</h3>
			<table align="right">
				<thead>
				<tr>
					<th></th>
					<span><a href="/registration"></a></span>
					<th></th>
					<span><a href="/login"></a></span>
			</table>

		</div>
	</div>

	<br />


	<div class="search">
		<form action="/searchProduct" method="post">
			<input type="text" id="description"  placeholder="Keywords..."
				   name="description" /> <input class="button" type="submit" value="Search" />
		</form>
	</div>

<div>
	<div style="float: right; padding-right: 50px; border-bottom: skyblue; margin-right: 16px; font-size: 18px;">
		<h3 align="center">Filter News by:</h3>
		<form action="/filtered/name" method="post">
			<label>Title:</label><br /> <input type="text"
											  name="name" /><br /> <br /> <input class="button" type="submit" value="Filter" />
		</form>
		<br />
		<form action="/filtered/important" method="post">
			<label>Importance:</label><br /> <input type="text"
													name="important" /><br /> <br /> <input class="button" type="submit" value="Filter" />
		</form>
		<br />
		<form action="/filtered/author" method="post">
			<label>Author:</label><br /> <input type="text"
												name="author" /><br /> <br /> <input class="button" type="submit" value="Filter" />
		</form>
		<br />
		<form action="/filtered/country" method="post">
			<label>Country:</label><br /> <input type="text"
												 name="country" /><br /> <br /> <input class="button" type="submit" value="Filter" />
		</form>

		<table align="center">
			<c:forEach items="${filteredNews}" var="news">
				<tr>
					<td><img src="${news.imageurl}" width="180" height="160"
							 style="margin-left: 30px" /></td>
					<td>${news.name}</td>
					<td>${news.important}</td>
					<td>${news.author}</td>
					<td>${news.country}</td>
					<td><a href="/details/${news.id}">Details</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<br />
	
	<form action="/FilterCategories" method="post">

		<select id="categories" name="categories">
			<option value="NONE" label="Choose categories:" />
			<c:forEach items="${categories}" var="categories">
				<option value="${categories.catid}">${categories.title}</option>
			</c:forEach>
		</select> 
		
		<input class="button" type="submit" value="Show news from category"/>
	</form>
	
	<br />
	
	<%--<form action="/deleteFromPlan" method="post">

		<select id="category" name="categories">
			<option value="NONE" label="Choose categories:" />
			<c:forEach items="${categories}" var="categories">
				<option value="${categories.catid}">${categories.title}</option>
			</c:forEach>
		</select> <select id="news" name="news">
			<option value="NONE" label="Choose news:" />
			<c:forEach items="${news}" var="news">
				<option value="${news.id}">${news.name}</option>
			</c:forEach>
		</select> <input class="button" type="submit" value="Unpin news from this category"/>
	</form>
--%>

<h3 align="left">News available for this categories:</h3>
	<table align="left">

		<c:forEach items="${newsPlan}" var="newsPlan">
			<tr>
			<td><img src="${newsPlan.imageurl}" width="180" height="160"
					style="margin-left: 40px" /></td>
				<td>${newsPlan.name}</td>
				<td>${newsPlan.important}</td>
				<td>${newsPlan.author}</td>
				<td>${newsPlan.country}</td>
			</tr>
		</c:forEach>
	</table>
<div>

<br />
	<br />

<div
			style="padding-right: 100px; border-bottom: #0390fc; margin-right: 16px; font-size: 24px;">
	<h3 align="center">Latest News:</h3>
	
	<table align="center">
		<thead>
			<tr>
				<th></th>
				<th>Title</th>
				<th>Importance</th>
				<th>Author</th>
				<th>Country</th>
			</tr>
		</thead>
		<c:forEach items="${news}" var="news">
			<tr>
				<td><img src="${news.imageurl}" width="200" height="180"
					style="margin-left: 30px" /></td>
				<td>${news.name}</td>
				<td>${news.important}</td>
				<td>${news.author}</td>
				<td>${news.country}</td>
				<td><a href="/details/${news.id}">Details</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<br />

	</div>

	<br />

</div>
</div>
<div class="footer">
	<h3 align="center">Share your news with us via e-mail: latestnews@ln.com</h3>
</div>
</body>
</html>