package org.web.membercommend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.memberdao.MemberDao;
import org.web.memberdto.MemberDto;

public class memberView implements MemberCommend{

	@Override
	public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId=request.getParameter("userId");
		
		
		PrintWriter out=response.getWriter();
		out.write(getString(userId));
		out.flush();
			
		
	}
	
	public String getString(String userId) {
		
		MemberDao dao=MemberDao.getInstance();
		MemberDto dto=dao.memberView(userId);
	//셀렉트로 리스트 다 뽑아서 id pw name addr 뽑고 
	//foreach로 객체이름을 id로 해서 id pw name addr멤버로 선언
		
		String str="{\"userId\":\""+dto.getUserId()+"\","+
				"\"userPw\":\""+dto.getUserPw()+"\","+
				"\"userName\":\""+dto.getUserName()+"\","+
				"\"userAddr\":\""+dto.getUserAddr()+"\"}";
		
		return str;
	}

	
}
