package org.web.membercontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.membercommend.IdCheckedMo;
import org.web.membercommend.MemberCommend;
import org.web.membercommend.MemberSearch;
import org.web.membercommend.joinOk;
import org.web.membercommend.logOut;
import org.web.membercommend.login;
import org.web.membercommend.memberChange;
import org.web.membercommend.memberList;
import org.web.membercommend.memberView;
import org.web.membercommend.memberdelete;

@WebServlet("*.mo")
public class MemberController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	
	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String uri = request.getRequestURI(); 
		String path = request.getContextPath();
		String basicURL = uri.substring(path.length());
		
		String url="";
		MemberCommend action=null;
		
	
		if(basicURL.equals("/ajaxIdChecked.mo")) {
			action=new IdCheckedMo();
			action.excuteQueryCommend(request, response);
			return ;
		}
		if(basicURL.equals("/join.mo")) {
			action=new joinOk();
			action.excuteQueryCommend(request, response);
			return ;
		}
		if(basicURL.equals("/login.mo")) {
			action=new login();
			action.excuteQueryCommend(request, response);
			return ;
		}
		if(basicURL.equals("/logoutok.mo")) {
			action=new logOut();
			action.excuteQueryCommend(request, response);
			return ;
		}
		if(basicURL.equals("/memberView.mo")) {
			action=new memberView();
			action.excuteQueryCommend(request, response);
			return ;
		}
		if(basicURL.equals("/memberChange.mo")) {
			action=new memberChange();
			action.excuteQueryCommend(request, response);
			return ;
		}
		if(basicURL.equals("/Delete.mo")) {
			action=new memberdelete();
			action.excuteQueryCommend(request, response);
			return ;
		}
		if(basicURL.equals("/memberList.mo")) {
			action=new memberList();
			action.excuteQueryCommend(request, response);
			return ;
		}
		if(basicURL.equals("/search.mo")) {
			action=new MemberSearch();
			action.excuteQueryCommend(request, response);
			return ;
		}
		
	}
	

}
