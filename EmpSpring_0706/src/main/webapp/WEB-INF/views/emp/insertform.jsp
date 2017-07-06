<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>

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
</style>
<body>
<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
<form action="insert" method="post" name="fr"  onsubmit="return check();">
<div class="container">
<h1>사원정보 추가 </h1>${message}
<table border =1 class="table">
<tr>
  <th>EMPLOYEE_ID</th>
  <td><input type="number" name="employeeId"></td>
</tr>
<tr>
  <th>FIRST_NAME</th>
  <td><input type="text" name="firstName" ></td>
</tr>
<tr>
  <th>LAST_NAME</th>
  <td><input type="text" name="lastName" ></td>
</tr>
<tr>
  <th>EMAIL</th>
  <td><input type="text" name="email" ></td>
</tr>
<tr>
  <th>PHONE_NUMBER</th>
  <td><input type="text" name="phoneNumber" ></td>
</tr>
<tr>
  <th>HIRE_DATE</th>
  <td><input type="date" name="hireDate" ></td>
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
  <td><input type="number" name="salary"></td>
</tr>
<tr>
  <th>COMMISSION_PCT</th>
  <td><input type="number" name="commissionPct" ></td>
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
</form>


</body>
</html>