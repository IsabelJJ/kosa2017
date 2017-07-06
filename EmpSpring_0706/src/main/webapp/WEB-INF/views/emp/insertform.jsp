<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>Insert title here</title>
</head>
<script type="text/javascript">
function check() {
	if (confirm("저장 하시겠습니까?") == true){    //확인
	  document.form.submit();
	return true;
	}else{   //취소
	  return false;
	}
}
</script>
<style type="text/css">
img {
  text-align: center;
}
.error{
   color:red
}
</style>
<body>
<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
<form:form action="insert" modelAttribute="emp" onsubmit="return check();">
<div class="container">
<h1>사원정보 추가 </h1>${message}
<table border =1 class="table">
<tr>
  <th>EMPLOYEE_ID</th>
  <td><form:input path="employeeId"/>
   <form:errors path="employeeId" cssClass="error"/></td>
</tr>
<tr>
  <th>FIRST_NAME</th>
  <td><form:input path="firstName"/>
   <form:errors path="firstName" cssClass="error"/></td>
</tr>
<tr>
  <th>LAST_NAME</th>
  <td><form:input path="lastName"/>
   <form:errors path="lastName" cssClass="error"/></td>
</tr>
<tr>
   <th>EMAIL</th>
   <td><form:input path="email"/>
   <form:errors path="email" cssClass="error"/></td>
</tr>
<tr>
  <th>PHONE_NUMBER</th>
   <td><form:input path="phoneNumber"/>
   <form:errors path="phoneNumber" cssClass="error"/></td>
</tr>
<tr>
	<th>HIRE_DATE</th>
   <td><form:input path="hireDate" type="date" required="required"/>
   <form:errors path="hireDate" cssClass="error"/></td>
</tr>
<tr>
  <th>JOB_ID</th>
  <td>
    <select name="jobId">
    <c:forEach var="job" items="${jobs}">
        <option value="${job.jobId}">${job.title}</option>
    </c:forEach>
    </select>
  </td>
</tr>
<tr>
 <th>SALARY</th>
   <td><form:input path="salary" type="number"/>
   <form:errors path="salary" cssClass="error"/></td>
</tr>
<tr>
   <th>COMMISSION_PCT</th>
   <td><form:input path="commissionPct" type="number" step="0.1" min="0.0" max="0.99"/>
   <form:errors path="commissionPct" cssClass="error"/></td>
</tr>
<tr>
  <th>MANAGER_ID</th>
  <td>
    <select name="managerId">
    <c:forEach var="manager" items="${managers}">
        <option value="${manager.managerId}">${manager.firstName}</option>
    </c:forEach>
    </select>
  </td>
</tr>
<tr>
  <th>DEPARTMENT_ID</th>
  <td>
    <select name="departmentId">
    <c:forEach var="map" items="${depts}">
      <c:forEach var="dept" items="${map}">
          <option value="${dept.key}">${dept.value}</option>
      </c:forEach>
    </c:forEach>
    </select>
  </td></tr>
<tr>
  <th> </th>
  <td>
    <input type="submit" value="저장"> 
    <input type="reset" value="취소">
      <a href ="javascript:history.go(-1)"><input type="button" value="Home"></a>
  </td>
</tr>
</table>
</div>
</form:form>


</body>
</html>