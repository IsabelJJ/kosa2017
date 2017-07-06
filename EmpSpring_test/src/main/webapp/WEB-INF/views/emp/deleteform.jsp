<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript">
function check() {
	if (confirm("삭제 하시겠습니까?") == true){    //확인
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

<title>Insert title here</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
	<form action="delete" method="post"  name="fr"  onsubmit="return check();">
		<div class="container">		
		<h1>이메일을 입력해 주세요 ${message}</h1>
		${emp.employeeId}사원 ${emp.firstName} ${emp.lastName}의 정보를 삭제합니다.<p>
		삭제후 데이터는 복구될 수 없습니다.<p>
		${emp.employeeId}사원의 이메일을 입력하세요.	<p>
		
		사원번호:<br>
		<input type="text" name="employeeId" value="${emp.employeeId}"><br>
		이  메  일:<br>
		<input type="text" name="email"> 
		<input type="submit"value="확 인"> <input type="reset" value="취 소">  
		</div>
	</form>
</body>
</html>