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

	

	<c:import url="header.jsp"/>
	
	ID:<input type="text" name="userId"><br>
	Pw:<input type="password" name="userPw"><br>
	<input type="button" onclick="deleteok()" value="회원 탈퇴">
	
	<script>
	var xhr=new XMLHttpRequest();
	var userId=document.getElementsByName("userId")[0];
	var userPw=document.getElementsByName("userPw")[0];
	
	function ajaxDelete(){
		var data="userId="+userId.value+"&userPw="+userPw.value;
		var url="Delete.mo";
		
		xhr.open("POST",url,true);
		xhr.onreadystatechange=function(){
			if(xhr.status==200 && xhr.readyState==4){
				var result=JSON.parse(xhr.responseText);
				
				var rs=result.res[0].deleters;
				
					console.log(result);
					console.log(rs);
				if(rs==1){
					alert("탈퇴 완료");
				
				}else{
					alert("탈퇴 실패");
					
					
				}
				
				
			}
			
		};
		xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded;charset=utf8');
		xhr.send(data);
		
	}

	function deleteok(){
	if(confirm("탈퇴 하시겠습니까 ?")==true){
		ajaxDelete();

	}else{
		
		alert("탈퇴 실패");
	}
		
		
	}
	
	</script>
	
	<script>
	window.onload.fuunction(){
		ajaxList();
	}
	
	
	
	</script>
	

</body>
</html>