<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://code.highcharts.com/highcharts.js" defer></script>
<script src="https://code.highcharts.com/modules/exporting.js" defer></script>
<script type="text/javascript">
$(function(){
	Highcharts.chart('container',{
		title:{
			text: 'Combination chart'
		},
		xAxis:{
			categories:["setosa", "versicolor", "virginica"]
		},
		labels:{
			items:[{
				html:'Iris data analytics',
				style:{
					left:'50px',
					top:'18px',
					color : (Highcharts.theme && Highcharts.theme.textColor)||'black'
				}
			}]
		},
		series:<%= request.getAttribute("irisData")%>
	})
})
</script>
</head>
<body>
<h1>챠트</h1>
<div id="container" style="min-width:310px; height:400px; margin:0auto"></div>
</body>
</html>