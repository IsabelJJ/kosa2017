<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table border =1>
<tr>
	<th>아이디 </th>
	<th>이름</th>
	<th>패스워드</th>	
	<th>권한</th>
</tr>
<c:forEach var ="user" items="${users}">
<tr>
	<td>${user.userId}</a></td>
	<td>${user.userName}</td>
	<td>${user.userPassword}</td>	
	<td>${user.userRole}</td>

</tr>
</c:forEach>

</table>
</body>
</html>