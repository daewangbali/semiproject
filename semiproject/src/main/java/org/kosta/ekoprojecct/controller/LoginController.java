package org.kosta.ekoprojecct.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.ekoprojecct.model.MemberDAO;
import org.kosta.ekoprojecct.model.MemberVO;

public class LoginController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getMethod().equals("POST")==false)
			throw new ServletException("로그인 서비스는 POST 방식 요청만 가능합니다");
		
		String id=request.getParameter("id");
		String password=request.getParameter("password");

		MemberVO vo=MemberDAO.getInstance().login(id,password);
		System.out.println(vo);
		String viewName="login-fail.jsp";
		
		if(vo!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("mvo", vo);
			viewName="redirect:HomeController.do";
		}
		
		return viewName;
	}
	
}
