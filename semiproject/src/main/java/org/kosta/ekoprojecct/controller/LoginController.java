package org.kosta.ekoprojecct.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.ekoprojecct.model.MemberDAO;
import org.kosta.ekoprojecct.model.MemberVO;

public class LoginController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id=request.getParameter("id");
		String password=request.getParameter("password");

		MemberVO vo=MemberDAO.getInstance().login(id,password);
		System.out.println(vo);
		String viewName="login-fail.jsp";
		
		if(vo!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("mvo", vo);
			//로그인 유지 기간동안 조회수 재증가 방지를 위해 myboardList를 세션에 저장한다
			session.setAttribute("myboardNoList", new ArrayList<String>());
			
			viewName="redirect:HomeController.do";
		}
		
		return viewName;
	}
	
}
