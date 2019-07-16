<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div id="header">
<a>${sessionId }</a>
<a href="index.jsp">Home</a>

<c:choose>
	<c:when test="${sessionId eq null}"> <!-- empty sessionId -->
		<a href="join.jsp">회원가입</a>
		<a href="login.jsp">로그인</a>
		<a href="#">게시글보기</a>
	</c:when>
		<c:otherwise>
			<a href="delete.jsp">회원탈퇴</a>
			<a href="memberchange.jsp">회원수정</a>
			<a href="#" onclick="ajaxLogOut(event)">로그아웃</a>
		</c:otherwise>
</c:choose>
<script src="js/ajaxLogOut.js"></script>
<script>


</script>



</div>

</body>
</html>