<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	div {margin: 30px auto; width:400px; padding: 40px;}
</style>
</head>
<body>
	<form action="address_add.do" method="post">
		<div>
		<table>
			<tr>
				<td>Name </td>
				<td>: <input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Tel </td>
				<td>: <input type="text" name="phone"></td>
			</tr>
			<tr>
				<td>Address </td>
				<td>: <input type="text" name="address"></td>
			</tr>
		</table>
		<p><input type="submit" value="입력">&nbsp&nbsp&nbsp<input type="reset" value="재입력"></p>
		</div>
	</form>
</body>
</html>