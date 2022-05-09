package org.kosta.ekoprojecct.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.ekoprojecct.model.MemberDAO;

public class CheckTelController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String tel=request.getParameter("tel");
		boolean result=MemberDAO.getInstance().telcheck(tel);
		String checkTel = null;
		if(result)
			checkTel="fail";
		else
			checkTel="ok";
		request.setAttribute("responsebody", checkTel);
		return "AjaxView";
	}

}
