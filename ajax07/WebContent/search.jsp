<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="css/Listdetail.css">
</head>
<body>

<input type="text" name="searchcode" onkeyup="searchOk()">

<table border=1>
	<thead>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>주소</th>
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



<script>

	var xhr=new XMLHttpRequest();
	function searchOk(){
		var searchcode=document.getElementsByName("searchcode")[0];
		var data="searchcode="+searchcode.value;
		var url="search.mo";
		xhr.open("POST",url,true);
		xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded;charset=utf8');
		xhr.send(data);
		xhr.onreadystatechange=function(){
			if(xhr.status==200 && xhr.readyState==4){
				var result=JSON.parse(xhr.responseText);
				if(result.resultrs=="null"){
					var rs="<tr>";
					rs+="<td>해당 유저 없음</td>";
					rs+="</tr>";
					
					tbd.innerHTML=rs;
					
				}else{
				var tbd=document.getElementById("tbd");
				var rs="";
				var resultlen=Object.keys(result.resultrs).length;
				for(var i=0;i<resultlen;i++){
				rs+="<tr>";
					rs+="<td>"+result.resultrs[i].userId+"</td>";
					rs+="<td>"+result.resultrs[i].userPw+"</td>";
					rs+="<td>"+result.resultrs[i].userName+"</td>";
					rs+="<td>"+result.resultrs[i].userAddr+"</td>";
					rs+="<td><a href='#' onclick='memberView(\""+result.resultrs[i].userId+"\")'>보기</a></td>";
				rs+="</tr>";
				}
				
				tbd.innerHTML=rs;
				
			}
			}
		};
	
		
		
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