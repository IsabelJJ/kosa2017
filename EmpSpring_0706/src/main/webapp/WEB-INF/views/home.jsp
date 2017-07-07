<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<head>
	<title>Home</title>
</head>
<style type="text/css">
html {
  text-align: center;
}

</style>
<body>

<h1>
	Employee Management
</h1>

<nav class="navbar navbar-default" >
  <div class="container-fluid" >
    <div class="navbar-header">
      </div>
    <ul class="nav navbar-nav" id="a">
    <li><a href="login">LOGIN</a></li>
    <li><a href="insertUser">CREATE</a></li>
    <li><a href="deleteUser">DELETE</a></li>
    <li><a href="updateUser">UPDATE</a></li>	
      <li><a href="insert">EMP INSERT</a></li>
		<li><a href="list">EMP LIST</a></li>
		<li><a href="logout">LOGOUT</a></li>	
    </ul>
  </div>

</nav>
<img src="images/c.gif" style="width:1000px;height:500px;float:center;"/>
</body>
</html>
