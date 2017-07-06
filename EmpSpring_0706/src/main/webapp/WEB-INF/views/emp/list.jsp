<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
input { float: right; clear: both;}
</style>
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
<div class="container">
<h1>직원 리스트 : ${result}</h1> 

<table border =1 class="table">
<tr>
	<th>이름 </th>
	<th>직무</th>
	<th>급여</th>
	<th>매니저 아이디</th>
	<th>부서번호</th>
	<th>사원번호</th>
	<th>보너스</th>
	<th>전화번호</th>
	<th>이메일</th>
	<th>입사일자</th>
</tr>
<c:forEach var ="emp" items="${empList}">
<tr>
	<td><a href= "<c:url value='/${emp.employeeId}'/>">${emp.firstName} ${emp.lastName}</a></td>
	<td>${emp.jobId}</td>
	<td>${emp.salary}</td>
	<td>${emp.managerId}</td>
	<td>${emp.departmentId}</td>
	<td>${emp.employeeId}</a></td>
	<td>${emp.commissionPct}</td>
	<td>${emp.phoneNumber}</td>
	<td>${emp.email}</td>
	<td>${emp.hireDate}</td>
</tr>
</c:forEach>

</table>
</div>
</body>
</html>