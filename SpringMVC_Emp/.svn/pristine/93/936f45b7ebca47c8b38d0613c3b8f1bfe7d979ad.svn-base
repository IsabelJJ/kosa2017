<%@ page contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CoderBy</title>
<style type="text/css">
.error{
	color:red
}
table,th,td{
	border-color : green;
	border-style : solid;
	border-width:2px;
	border-collapse: collapse
}
</style>
<script type="text/javascript">
function check() {
	if (confirm("수정 하시겠습니까?") == true){    //확인
	  document.form.submit();
	return true;
	}else{   //취소
	  return false;
	}
}
</script>

</head>
<body>
<h1>사원정보 수정</h1>
<form:form action="${actionURL}" modelAttribute="emp">
<table border="1">
<tr>
	<th>EMPLOYEE_ID</th>
	<td><form:input path="employeeId"/>
	<form:errors path="employeeId" cssClass="error"/>
	</td>
</tr>
<tr>
	<th>FIRST_NAME</th>
	<td><form:input path="firstName"/>
	<form:errors path="firstName" cssClass="error"/></td>
</tr>
<tr>
	<th>LAST_NAME</th>
	<td><form:input path="lastName" required="required"/>
	<form:errors path="lastName" cssClass="error"/></td>
</tr>
<tr>
	<th>EMAIL</th>
	<td><form:input path="email" required="required"/>
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
			<c:if test="${emp.jobId == job.jobId}">
				<option value="${job.jobId}" selected>${job.title}</option>
			</c:if>
			<c:if test="${emp.jobId != job.jobId}">
				<option value="${job.jobId}">${job.title}</option>
			</c:if>
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
	<td><form:input path="commissionPct" type="number" step="0.1" min="0" max="0.99"/>
	<form:errors path="commissionPct" cssClass="error"/></td>
</tr>
<tr>
	<th>MANAGER_ID</th>
	<td>
		<select name="managerId">
		<c:forEach var="manager" items="${managers}">
			<c:if test="${emp.managerId == manager.managerId}">
				<option value="${manager.managerId}" selected>${manager.firstName}</option>
			</c:if>
			<c:if test="${emp.managerId != manager.key}">
				<option value="${manager.managerId}">${manager.firstName}</option>
			</c:if>
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
				<c:if test="${emp.departmentId == dept.key}">
					<option value="${dept.key}" selected>${dept.value}</option>
				</c:if>
				<c:if test="${emp.departmentId != job.key}">
					<option value="${dept.key}">${dept.value}</option>
				</c:if>
			</c:forEach>
		</c:forEach>
		</select>
	</td></tr>
<tr>
	<th>&nbsp;</th>
	<td>
		<input type="submit" value="수정"> 
		<input type="reset" value="취소">
	</td>
</tr>
</table>

</form:form>
</body>
</html>