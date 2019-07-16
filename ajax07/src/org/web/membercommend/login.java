package org.web.membercommend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.web.memberdao.MemberDao;

public class login implements MemberCommend{

	@Override
	public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userId=request.getParameter("userId");
		String userPw=request.getParameter("userPw");
		
		MemberDao dao=MemberDao.getInstance();
		int rs=dao.login(userId, userPw);
		
		HttpSession session=request.getSession();
		
		if(rs==1) {
			session.setAttribute("sessionId", userId);
			session.setMaxInactiveInterval(60*5);
			
		}

		PrintWriter out=response.getWriter();
		out.write(rs+"");
		out.flush();
		
		
		
		
		
		
		
	}
	

}
