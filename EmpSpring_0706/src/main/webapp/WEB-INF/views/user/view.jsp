<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

아이디:${user.userId}<br>
이름:${user.userName}<br>
비밀번호:${user.userPassword}<br>
권한:${user.userRole}<br>
<a href="updateUser">수정</a>

</body>
</html>