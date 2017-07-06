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
		<h1>상세 내용</h1>
		<table border=1 class="table">
			<tr>
				<td>이름 :</td>
				<td>${emp.firstName}${emp.lastName}</td>
			</tr>
			<tr>
				<td>직무:</td>
				<td>${emp.jobId}</td>
			</tr>
			<tr>
				<td>급여:</td>
				<td>${emp.salary}</td>
			</tr>
			<tr>
				<td>매니저아이디:</td>
				<td>${emp.managerId}</td>
			</tr>
			<tr>
				<td>부서번호:</td>
				<td>${emp.departmentId}</td>
			</tr>
			<tr>
				<td>사원번호:</td>
				<td>${emp.employeeId}</td>
			</tr>
			<tr>
				<td>보너스:</td>
				<td>${emp.commissionPct}</td>
			</tr>
			<tr>
				<td>전화번호:</td>
				<td>${emp.phoneNumber}</td>
			</tr>
			<tr>
				<td>이메일:</td>
				<td>${emp.email}</td>
			</tr>
			<tr>
				<td>입사일자:</td>
				<td>${emp.hireDate}</td>
			</tr>
			<tr>
				<td>같은 부서사람들 수:</td>
				<td>${result2}</td>
			</tr>
			<tr>
			<td></td>
			<td>
			<a href="update/${emp.employeeId}">수정      </a> <a
			href="delete/${emp.employeeId}">삭제        </a> 
			<a href ="javascript:history.go(-1)"><input type="button" value="뒤로"></a>
			</td>
			</tr>
		</table>
	
	</div>
</body>
</html>