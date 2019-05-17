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
  .wrapper { margin: 30px auto; width: 600px;}
	table {border-collapse: collapse;}
	td, tr {border-left: 1px solid white;}
	td {padding: 3px 10px;}
	tr:nth-of-type(1) {text-align: center;}
	tr:nth-of-type(2n+1) {background-color: rgba(167, 167, 167, 0.3);}
  a {text-decoration: none; color:black;}
  a:hover {color:blue;}
</style>
</head>
<body>
	<div class="wrapper">
  	<form action="address_main_delete.do" method="post">
	<table>
		<tr>
			<td><!--체크박스--></td>
			<td>이름</td>
			<td>주소</td>
			<td>전화번호</td>
		</tr>
		<c:forEach var="address" items="${aList}">
			<tr>
				<td><input type="checkbox" name="del_id" value="${address.aID}"></td>
				<td><a href="address_content.do?aID=${address.aID}">${address.name}</a></td>
				<td>${address.address}</td>
				<td>${address.phone}</td>
			</tr>
		</c:forEach>
	</table>
	<p><a href="address_add_view.do"><i class="fa fa-chevron-left" aria-hidden="true"></i>추가하기</a> <i class="fa fa-chevron-left" aria-hidden="true"></i><input type="submit" value="삭제하기"></p>
	</form>
	</div>
</body>
</html>
