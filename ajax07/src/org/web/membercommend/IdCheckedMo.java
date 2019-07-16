package org.web.membercommend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.memberdao.MemberDao;

public class IdCheckedMo implements MemberCommend{

	@Override
	public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("아이디체크 ");
		
		String userId=request.getParameter("userId");
		MemberDao dao=MemberDao.getInstance();
		int result=dao.idChecked(userId);
		
		System.out.println(result);
		PrintWriter out=response.getWriter();
		out.write(result+"");
		out.flush();
		
		
	}
	

}
