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
	//����Ʈ�� ����Ʈ �� �̾Ƽ� id pw name addr �̰� 
	//foreach�� ��ü�̸��� id�� �ؼ� id pw name addr����� ����
		
		String str="{\"userId\":\""+dto.getUserId()+"\","+
				"\"userPw\":\""+dto.getUserPw()+"\","+
				"\"userName\":\""+dto.getUserName()+"\","+
				"\"userAddr\":\""+dto.getUserAddr()+"\"}";
		
		return str;
	}

	
}
