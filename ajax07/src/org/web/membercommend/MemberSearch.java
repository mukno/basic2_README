package org.web.membercommend;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.memberdao.MemberDao;
import org.web.memberdto.MemberDto;

public class MemberSearch implements MemberCommend{

	@Override
	public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String searchcode=request.getParameter("searchcode");
		System.out.println(searchcode);
		PrintWriter out=response.getWriter();
		out.write(getString(searchcode));
		out.flush();
			
	}
	public String getString(String searchcode) {
		
		String str="{\"resultrs\":["; 
		StringBuffer st=new StringBuffer(str);
		MemberDao dao=MemberDao.getInstance();
		ArrayList<MemberDto> lists=dao.memberLists(searchcode);  
		for(MemberDto dt:lists) {
//		    {\"     \"}
			st.append("{\"userId\":\""+dt.getUserId()+"\",");
			st.append("\"userPw\":\""+dt.getUserPw()+"\",");
			st.append("\"userName\":\""+dt.getUserName()+"\",");
			st.append("\"userAddr\":\""+dt.getUserAddr()+"\"},");
		}
		str=st.toString();
		str=str.substring(0,str.length()-1);
		
		str+="]}";
		
		System.out.println(str);
		return str;
	}
	
	

}
