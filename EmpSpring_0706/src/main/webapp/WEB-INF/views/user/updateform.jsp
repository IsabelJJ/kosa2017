<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>����� ���� ����</h1>
<form action="updateUser" method="post">
���̵� :<input type="text" name="userId" value="${user.userId}" readonly><br>
�̸� :<input type="text" name ="userName" value="${user.userName}"><br>
��й�ȣ :<input type="password" name ="userPassword"><br>
����: :<select name = "userRole">
<c:forEach var="role" items="${role}">
	<option value = "${role.key}">${role.value}
</c:forEach></select><br><br>
<input type="submit" value="Ȯ ��">
<input type="reset" value="�� ��"><br>
</form>
</body>
</html>