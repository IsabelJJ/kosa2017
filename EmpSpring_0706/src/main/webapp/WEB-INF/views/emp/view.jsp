<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>Insert title here</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
	<div class="container">
		<h1>�� ����</h1>
		<table border=1 class="table">
			<tr>
				<td>�̸� :</td>
				<td>${emp.firstName}${emp.lastName}</td>
			</tr>
			<tr>
				<td>����:</td>
				<td>${emp.jobId}</td>
			</tr>
			<tr>
				<td>�޿�:</td>
				<td>${emp.salary}</td>
			</tr>
			<tr>
				<td>�Ŵ������̵�:</td>
				<td>${emp.managerId}</td>
			</tr>
			<tr>
				<td>�μ���ȣ:</td>
				<td>${emp.departmentId}</td>
			</tr>
			<tr>
				<td>�����ȣ:</td>
				<td>${emp.employeeId}</td>
			</tr>
			<tr>
				<td>���ʽ�:</td>
				<td>${emp.commissionPct}</td>
			</tr>
			<tr>
				<td>��ȭ��ȣ:</td>
				<td>${emp.phoneNumber}</td>
			</tr>
			<tr>
				<td>�̸���:</td>
				<td>${emp.email}</td>
			</tr>
			<tr>
				<td>�Ի�����:</td>
				<td>${emp.hireDate}</td>
			</tr>
			<tr>
				<td>���� �μ������ ��:</td>
				<td>${result2}</td>
			</tr>
			<tr>
			<td></td>
			<td>
			<a href="update/${emp.employeeId}">����      </a> <a
			href="delete/${emp.employeeId}">����        </a> 
			<a href ="javascript:history.go(-1)"><input type="button" value="�ڷ�"></a>
			</td>
			</tr>
		</table>
	
	</div>
</body>
</html>