		
		var checked=document.getElementsByName("checked")[0];
		var userId=document.getElementsByName("userId")[0];
		var userPw=document.getElementsByName("userPw")[0];
		var userName=document.getElementsByName("userName")[0];
		var userAddr=document.getElementsByName("userAddr")[0];
		
	function idCheck(){
		if(checked.value=="unChecked"){
			alert("아이디 체크를 먼저 실행하세요.");
			userId.focus();
			return;
			
		}
		
	}
		
		var s1=document.getElementById("s1");
		var xhr=new XMLHttpRequest();
	function ajaxIdChecked(){
		var data="userId="+userId.value;
		var url="ajaxIdChecked.mo";
		xhr.open("POST",url,true);
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4 && xhr.status==200){
				
				var result=xhr.responseText;
				//var result=JSON.pares(xhr.responseText);
				//var result=eval('('+xhr.responseText+')'); json화
				if(result==1){
					s1.style.color="#f00";
					s1.innerHTML="중복아이디 입니다.";
					userId.focus();
					return;
				}else{
					s1.style.color="#f00";
					s1.innerHTML="사용 가능 아이디 입니다.";
					checked.value="Onchecked";
					return;
				}
				
				
				
				
			}
			
			
		};
		xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded;charset=utf8');
		xhr.send(data);
		
		
		
		
	}
	function joinOk(){
		var data="userId="+userId.value+"&userPw="+userPw.value+"&userName="+userName.value+"&userAddr="+userAddr.value;
		var url="join.mo";
		xhr.open("POST",url,true);
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4 && xhr.status==200){
				
				var result=xhr.responseText;
				//var result=JSON.pares(xhr.responseText);
				//var result=eval('('+xhr.responseText+')'); json화
				if(result==1){
					alert("회원가입 성공");
					location.href="login.jsp";
					return;
				}else{
					alert("회원가입 실패");
					return;
					
				}
				
				
				
				
			}
			
			
		};
		xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded;charset=utf8');
		xhr.send(data);
		
		
		
		
	}
	
	function ajaxjoin(){
	idChecked();
	if(userPw.value==null || userPw.value==""){
		
		
	}
if(userName.value==null || userName.value==""){
		
		
	}
if(userAddr.value==null || userAddr.value==""){
	
	
}
	
}