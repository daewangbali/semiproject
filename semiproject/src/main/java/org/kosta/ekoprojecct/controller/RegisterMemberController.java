package org.kosta.ekoprojecct.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.ekoprojecct.model.MemberDAO;

public class RegisterMemberController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String kostaNO = request.getParameter("kostaNO");
		String password = request.getParameter("password"); 
		
		MemberDAO.getInstance().registerMember(id, name, tel, kostaNO, password);
		
		request.setAttribute("url", "register-success.jsp");
		return "layout.jsp";
	}

}
