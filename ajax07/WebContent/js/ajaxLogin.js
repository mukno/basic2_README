
var userId=document.getElementsByName("userId")[0];
var userPw=document.getElementsByName("userPw")[0];

var xhr=new XMLHttpRequest();
	function loginOk(){
	var data="userId="+userId.value+"&userPw="+userPw.value;
	var url="login.mo";
	xhr.open("POST",url,true);
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4 && xhr.status==200){
			
			var result=xhr.responseText;
			//var result=JSON.pares(xhr.responseText);
			//var result=eval('('+xhr.responseText+')'); json화
			if(result==1){
				alert("로그인 성공");
				location.href="index.jsp";
				return;
			}else{
				alert("로그인 실패");
				return;
				
			}
			
			
			
			
		}
		
		
	};
	xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded;charset=utf8');
	xhr.send(data);
	
	
	
	
}
