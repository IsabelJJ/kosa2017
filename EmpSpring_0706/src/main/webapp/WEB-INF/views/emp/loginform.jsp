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
	if (confirm("�α��� �Ͻðڽ��ϱ�?") == true){    //Ȯ��
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
<body>
<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
<form action="login" method="post" onsubmit="return check();">
<div>
<h1>�α��� ${message}</h1>
�����ȣ : <br>
<input type="text" name="employeeId"><br>
�̸��� : <br>
<input type="text" name="email">
<input type="submit" value="�α���">
<input type="reset" value="���">
</div>
</form>
</body>
</html>