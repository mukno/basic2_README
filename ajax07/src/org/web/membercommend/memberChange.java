package org.web.membercommend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.memberdao.MemberDao;
import org.web.memberdto.MemberDto;

public class memberChange implements MemberCommend{

	@Override
	public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId=request.getParameter("userId");
		String userPw=request.getParameter("userPw");
		String userName=request.getParameter("userName");
		String userAddr=request.getParameter("userAddr");
		
		
		PrintWriter out=response.getWriter();
		out.write(getint(userId,userPw,userName,userAddr)+"");
		out.flush();
			
		
	}
	
	public int getint(String userId,String userPw,String userName,String userAddr) {
		
		MemberDao dao=MemberDao.getInstance();
		int rs=dao.memberChange(userId,userPw,userName,userAddr);
	System.out.println(rs);
		
		return rs;
	}

	
}
