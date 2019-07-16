<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>

 window.onload=function(){
	 
	 
	console.log("1");
	console.log(">>" +document.getElementById("s1"));
	 
 }

</script>
</head>
<body>

<div id="s1">s1</div>

<script>
console.log("2");
	console.log(">>" +document.getElementById("s1"));

</script>
<script>

 window.onload=function(){	 
	 
	console.log("3");
	console.log(">>" +document.getElementById("s1"));
	 
 }

</script>
</body>
</html>