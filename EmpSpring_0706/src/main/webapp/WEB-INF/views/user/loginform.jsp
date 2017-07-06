<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>로그인 ${message}</h1>
<form action="login" method="post">
아이디 : <input type="text" name="userId">
비밀번호 : <input type="password" name="userPassword">
<input type="submit" value="로그인">
<input type="reset" value="취소">
</form>
</body>
</html>