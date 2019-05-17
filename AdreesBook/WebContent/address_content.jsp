<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.content {border: 1px solid black;  padding: 10px;}
	.wrapper {margin: 20px auto;  width: 400px;}
	  a {text-decoration: none; color:black;}
  a:hover {color:blue;}
</style>
</head>
<body>
	<div class="wrapper">
	<div class="content">
		<span><strong>이름</strong> : ${address.name}</span><br>
		<span><strong>전화번호</strong> : ${address.phone}</span><br>
		<span><strong>주소</strong> : ${address.address}</span>		
	</div>
		<a href="address_book.do"><i class="fa fa-chevron-left" aria-hidden="true"></i>리스트</a>&nbsp&nbsp&nbsp<a href="address_modify_view.do"><i class="fa fa-chevron-left" aria-hidden="true"></i>수정</a>&nbsp&nbsp&nbsp<a href="address_delete.do?del_id=${address.aID}"><i class="fa fa-chevron-left" aria-hidden="true"></i>삭제</a>		
	</div>
</body>
</html>