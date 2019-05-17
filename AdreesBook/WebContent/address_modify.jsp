<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	div {margin: 30px auto; width:400px; padding: 40px;}
	  a {text-decoration: none; color:black;}
  a:hover {color:blue;}
</style>
</head>
<body>
	<form action="address_modify.do?aID=${address.aID}" method="post">
		<div>
		<input type="hidden" name="aID" value="${address.aID}">
		<table>
			<tr>
				<td>Name </td>
				<td>: <input type="text" name="name" value="${address.name}"></td>
			</tr>
			<tr>
				<td>Tel </td>
				<td>: <input type="text" name="phone" value="${address.phone}"></td>
			</tr>
			<tr>
				<td>Address </td>
				<td>: <input type="text" name="address" value="${address.address}"></td>
			</tr>
		</table>
		<p><i class="fa fa-chevron-left" aria-hidden="true"></i><input type="submit" value="수정">&nbsp&nbsp&nbsp<i class="fa fa-chevron-left" aria-hidden="true"></i><button type="button" onclick="location.href='address_content.jsp'">취소</button></p>
		</div>
	</form>
</body>
</html>