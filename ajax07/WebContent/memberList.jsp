<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

 <link rel="stylesheet" href="css/Listdetail.css">

</head>

<body>

<table border=1>
	<thead>
	<tr>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>이름</th>
		<th>주소</th>
		<th>보기</th>
	</tr>
	</thead>
	<tbody id="tbd">
	
	</tbody>
	


</table>

<div id="memberViewa">
	<div id="contentView">
	
		<ul>
			 <li>아이디           <span id="userId"></span></li>
			<li>비밀번호     <span id="userPw"></span></li>
			<li>이름    <span id="userName"></span></li>
			 <li>주소  <span id="userAddr"></span><a id="abcd" onclick="viewClose()">x</a></li>
			 
		</ul>
	
	
	</div>
</div>





<input type="button" value="버튼" onclick="memberListOK()">
<script>


	var xhr=new XMLHttpRequest();
	function memberListOK(){
		var url="memberList.mo";
		xhr.open("GET",url);
		xhr.onreadystatechange=function(){
			if(xhr.status==200 && xhr.readyState==4){
				var result=JSON.parse(xhr.responseText);
				var resultlen=Object.keys(result.resultrs).length;
				/* console.log(result.resultrs);
				console.log(result.resultrs[0][1]);
				console.log("111");
				
				console.log(result.resultrs[1]);
				console.log(result.resultrs[2].userId);
				console.log(result.resultrs[3].userPw);
				console.log(result[0]); */
				var tbd=document.getElementById("tbd");
				/* console.log(Object.keys(result).length);
				console.log(Object.keys(result.resultrs[0]).length);
				console.log(Object.keys(result.resultrs).length);
				console.log(result.resultrs); */
			var ttag="";
				
				for(var i=0;i<resultlen;i++ ){
				
				ttag+="<tr>";
					ttag+="<td>"+result.resultrs[i].userId+"</td>";
					ttag+="<td>"+result.resultrs[i].userPw+"</td>";
					ttag+="<td>"+result.resultrs[i].userName+"</td>";
					ttag+="<td>"+result.resultrs[i].userAddr+"</td>";
					ttag+="<td><a href='#' onclick='memberView(\""+result.resultrs[i].userId+"\")'>보기</a></td>";
				ttag+="</tr>";
				
				}
				tbd.innerHTML=ttag;
				
				
			}
			
		};
		xhr.send();
		
		
		
	}
	
	function memberView(userId){
		event.stopPropagation();
		
		var url="memberView.mo";
		var data="userId="+userId;
		xhr.open("POST",url,true);
		xhr.onreadystatechange=function(){
			if(xhr.status==200 && xhr.readyState==4){
				var rs=JSON.parse(xhr.responseText);
				
				document.getElementById("userId").textContent=rs.userId;
				document.getElementById("userPw").textContent=rs.userPw;
				document.getElementById("userName").textContent=rs.userName;
				document.getElementById("userAddr").textContent=rs.userAddr;
				
			}
		
	}
			
			
			xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded;charset=utf8');
			xhr.send(data);
			var memberViewa=document.getElementById("memberViewa");
			memberViewa.style.display="block";
			
			
			
		}
	
	
	function viewClose(){
		var memberViewa=document.getElementById("memberViewa");
		memberViewa.style.display="none";
	}

</script>


</body>
</html>