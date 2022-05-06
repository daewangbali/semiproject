package org.kosta.ekoprojecct.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterMemberFormController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//request.setAttribute("url", "register-form.jsp");
		return "registermember/register-form.jsp";
	}

}
