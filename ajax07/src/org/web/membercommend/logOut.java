package org.web.membercommend;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class logOut implements MemberCommend{

	@Override
	public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		
		
		int rs=0;
		
		if(session!=null) {
			session.invalidate();
			rs=1;
		}else {
			rs=0;
		}
		
		PrintWriter out=response.getWriter();
		out.write(rs+"");
		out.flush();
	
		
		
	}
	

}
