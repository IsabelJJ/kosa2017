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
	if (confirm("���� �Ͻðڽ��ϱ�?") == true){    //Ȯ��
	  document.form.submit();
	return true;
	}else{   //���
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
		<h1>�̸����� �Է��� �ּ��� ${message}</h1>
		${emp.employeeId}��� ${emp.firstName} ${emp.lastName}�� ������ �����մϴ�.<p>
		������ �����ʹ� ������ �� �����ϴ�.<p>
		${emp.employeeId}����� �̸����� �Է��ϼ���.	<p>
		
		�����ȣ:<br>
		<input type="text" name="employeeId" value="${emp.employeeId}"><br>
		��  ��  ��:<br>
		<input type="text" name="email"> 
		<input type="submit"value="Ȯ ��"> <input type="reset" value="�� ��">  
		</div>
	</form>
</body>
</html>