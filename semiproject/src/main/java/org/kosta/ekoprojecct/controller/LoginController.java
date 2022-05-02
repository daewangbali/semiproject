package org.kosta.ekoprojecct.controller;

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
		System.out.println(id);
		MemberVO vo=MemberDAO.getInstance().login(id,password);
		String viewName=null;
		if(vo==null) {
			viewName="login-fail.jsp";
		}else {
			HttpSession session=request.getSession();
			session.setAttribute("mvo", vo);
			viewName="redirect:ListController.do";
		}
		
		return viewName;
	}
	
}
