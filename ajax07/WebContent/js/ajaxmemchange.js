window.onload=function(){
	
		memberview();
		
	}
		var xhr=new XMLHttpRequest();
		var userIdn=document.getElementsByName("userIdn")[0];		
		var userPwn=document.getElementsByName("userPwn")[0];		
		var userNamen=document.getElementsByName("userNamen")[0];		
		var userAddrn=document.getElementsByName("userAddrn")[0];
		
	function memberview(){
		var data="userId="+userIdn.value;
		var url="memberView.mo";
		xhr.open("POST",url,true);
		xhr.onreadystatechange=function(){
			console.log("2");
			if(xhr.readyState==4 && xhr.status==200){
				console.log("3");
				console.log(xhr.responseText);
				var result=JSON.parse(xhr.responseText);
				//var result=eval('('+xhr.responseText+')'); json화
				
					userIdn.value=result.userId;
					userPwn.value=result.userPw;
					userNamen.value=result.userName;
					userAddrn.value=result.userAddr;
					
				
				
				
				
			}
			
			
		};
		xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded;charset=utf8');
		xhr.send(data);
	}
	
	
	function memberChange(){
		var data="userId="+userIdn.value+"&userPw="+userPwn.value+"&userName="+userNamen.value+"&userAddr="+userAddrn.value;
		var url="memberChange.mo";
		xhr.open("POST",url,true);
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4 && xhr.status==200){
				var rs=xhr.responseText;
				//var result=eval('('+xhr.responseText+')'); json화
				if(rs==1){
					alert("회원 변경 완료.");
					return;
				}else{
					alert("회원 변경 실패.");
					return;
				}
					
				
				
				
				
			}
			
			
		};
		xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded;charset=utf8');
		xhr.send(data);
		
	}
		
		 
	