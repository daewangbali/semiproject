package org.kosta.ekoprojecct.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getMethod().equals("POST")==false)
			throw new ServletException("로그아웃 서비스는 POST방식만 가능합니다");
		HttpSession session=request.getSession(false);
		if(session!=null)
			session.invalidate();
		return "redirect:HomeController.do";
	}
}
