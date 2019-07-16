package org.web.membercommend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.web.memberdao.MemberDao;

public class memberdelete implements MemberCommend{

	@Override
	public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		HttpSession session=request.getSession();
		
		MemberDao dao=MemberDao.getInstance();
		int rs=dao.memberdelete(userId, userPw);
		
		if(session!=null) {
			session.invalidate();
			
		}
		
		String result="{\"res\":[{\"deleters\":\""+rs+"\"}]}";
		System.out.println(result);
		PrintWriter out=response.getWriter();
		out.write(result);
		out.flush();
	}
	

}
