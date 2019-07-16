var xhr=new XMLHttpRequest();
	function ajaxLogOut(event){
		event.preventDefault();//원래이벤트를 중지.
		var url="logoutok.mo";
		xhr.open("GET",url,true);
		xhr.onreadystatechange=function(){
			if(xhr.status==200 && xhr.readyState==4){
			var result=xhr.responseText;
			if(result==1){
				alert("로그아웃 성공");
				location.href="index.jsp";
			}else{
				alert("로그아웃 실패");
				
			}
			}
		};
		xhr.send();
	}
	