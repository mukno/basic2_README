<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

<form>
	ID: <input type="text" name="userId" onkeyup="ajaxIdChecked()">
	<input type="button" name="idChecked" value="아이디체크" onclick="ajaxIdChecked()">
	<input type="hidden" name="checked" value="unChecked">
	<span id="s1">상태</span><br>
	
	Pw: <input type="password" name="userPw" onfocus="idCheck()"><br>
	Name: <input type="text" name="userName" onfocus="idCheck()"><br>
	Addr: <input type="text" name="userAddr" onfocus="idCheck()"><br>
	<input type="button" onclick="joinOk()" value="회원가입"><br>
 
</form>


<script src="js/ajaxidCheck.js"></script>

</body>
</html>