<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>비밀번호를 입력해 주세요 ${message}</h1>
<form action="deleteUser" method="post">
아이디:<input type="text" name ="userId" value="${user.userId}"><br>
비밀번호:<input type="text" name ="userPassword">
<input type="submit" value="확 인">
<input type="reset" value="취 소"><br>
</form>
</body>
</html>