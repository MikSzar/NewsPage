<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<style><%@include file="/WEB-INF/css/finalStyle.css"%></style>
</head>
<body>

	<div
		style="padding-top: 0px; padding-bottom: 0; height: 160px; background: chocolate;">
		<img src="/images/logo.png" width="120" height="140"
			style="margin-left: 30px" />
		<div
			style="float: right; padding: 0px; border-bottom: indigo; margin-right: 30px; font-size: 20px;">
			<h3 align="right">Hi ${loguser.username}, see what's going on in the world</h3>
			<div align="right" style="padding-top: -10px;">
					<a href="/" class="myButton">Logout</a>
			</div>
			<br />
		</div>
	</div>

	<br />
<div>
	<div style="float: right; padding-right: 50px; border-bottom: skyblue; margin-right: 16px; font-size: 18px;">
	<h3 align="center">Filter News by:</h3>
	<div align="center">
		<form action="/listNews/filtered/name" method="post">
			<label>Name:</label><br /> <input type="text"
											  name="name" /><br /> <br /> <input class="button" type="submit" value="Filter" />
		</form>
		<br />
		<form action="/listNews/filtered/important" method="post">
			<label>Importance:</label><br /> <input type="text"
													name="important" /><br /> <br /> <input class="button" type="submit" value="Filter" />
		</form>
		<br />
		<form action="/listNews/filtered/author" method="post">
			<label>Author:</label><br /> <input type="text"
												name="author" /><br /> <br /> <input class="button" type="submit" value="Filter" />
		</form>
		<br />
		<form action="/listNews/filtered/country" method="post">
			<label>Country:</label><br /> <input type="text"
												 name="country" /><br /> <br /> <input class="button" type="submit" value="Filter" />
		</form>
	</div>
	<br />
	<br />
	<table align="center">
		<thead>
		<tr>
			<th>Title</th>
			<th>Importance</th>
			<th>Author</th>
			<th>Country</th>
		</tr>
		</thead>
		<c:forEach items="${filteredNews}" var="news">
			<tr>
				<td>${news.name}</td>
				<td>${news.important}</td>
				<td>${news.author}</td>
				<td>${news.country}</td>
				<td><a href="/details/${news.id}">Details</a></td>
			</tr>
		</c:forEach>
	</table>
	</div>
	<form action="/addToPlan" method="post">
		<!-- <label>Choose a categories</label> -->
		<select id="categories" name="categories">
			<option value="NONE" label="Choose categories:" />
			<c:forEach items="${categories}" var="categories">
				<option value="${categories.catid}">${categories.title}</option>
			</c:forEach>
		</select> <select id="news" name="news">
			<option value="NONE" label="Choose news:" />
			<c:forEach items="${news}" var="news">
				<option value="${news.id}">${news.name}</option>
			</c:forEach>
		</select> <input class="button" type="submit" value="Add this news to the category"/>
	</form>

	<br/>


	<form action="/deleteFromPlan" method="post">

		<select id="category" name="categories">
			<option value="NONE" label="Choose categories:" />
			<c:forEach items="${categories}" var="categories">
				<option value="${categories.catid}">${categories.title}</option>
			</c:forEach>
		</select> <select id="newsunpin" name="news">
		<option value="NONE" label="Choose news:" />
		<c:forEach items="${news}" var="news">
			<option value="${news.id}">${news.name}</option>
		</c:forEach>
	</select> <input class="button" type="submit" value="Unpin news from this category"/>
	</form>

</div>
	<br />

	<h3 style="font-size: 30px" align="center">Create new news:</h3>

	<div align="center">
		<form action="/listNews" method="post">
			<label>Image:</label><br /> <input type="text" name="imageurl" /><br />
			<label>Title:</label><br /> <input type="text" name="name" /><br />
			<label>Importance:</label><br /> <input type="text" name="important" /><br />
			<label>Author:</label><br /> <input type="text" name="author" /><br />
			<label>Country:</label><br /> <input type="text" name="country" /><br />
			<label>Description:</label><br /> <input type="text" name="description" /><br />
			<br /> <input class="button" type="submit" value="Add new news" /><br />
		</form>
	</div>
	<br />
	<br />

<h3 align="center">Show news from database:</h3>
	<table align="center">
		<thead>
			<tr>
				<th>Title</th>
				<th>Importance</th>
				<th>Author</th>
				<th>Country</th>
			</tr>
		</thead>
		<c:forEach items="${news}" var="news">
			<tr>
				<td>${news.name}</td>
				<td>${news.important}</td>
				<td>${news.author}</td>
				<td>${news.country}</td>
				<td><a href="/details/${news.id}">Details</a></td>
				<td>
					<form action="/deleteNews" method="post">
						<input type="hidden" value="${news.id}" name="id" /> <input
							class="button" type="submit" value="Delete from database" />
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<br />
	<br />
	<div class="footer">
		<h3 align="center">Share your news with us via e-mail: latestnews@ln.com</h3>
	</div>
</body>
</html>