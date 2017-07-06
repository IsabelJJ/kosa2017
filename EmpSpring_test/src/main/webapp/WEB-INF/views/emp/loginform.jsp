<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<script type="text/javascript">
function check() {
	if (confirm("로그인 하시겠습니까?") == true){    //확인
	  document.form.submit();
	return true;
	}else{   //취소
	  return false;
	}
}
</script>
<style type="text/css">
div {
    margin: 0px auto;
    width:400px;
}
</style>
<body>
<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
<form action="login" method="post" onsubmit="return check();">
<div>
<h1>로그인 ${message}</h1>
사원번호 : <br>
<input type="text" name="employeeId"><br>
이메일 : <br>
<input type="text" name="email">
<input type="submit" value="로그인">
<input type="reset" value="취소">
</div>
</form>
</body>
</html>