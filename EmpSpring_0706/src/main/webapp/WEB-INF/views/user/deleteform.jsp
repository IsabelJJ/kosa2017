<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>��й�ȣ�� �Է��� �ּ��� ${message}</h1>
<form action="deleteUser" method="post">
���̵�:<input type="text" name ="userId" value="${user.userId}"><br>
��й�ȣ:<input type="text" name ="userPassword">
<input type="submit" value="Ȯ ��">
<input type="reset" value="�� ��"><br>
</form>
</body>
</html>