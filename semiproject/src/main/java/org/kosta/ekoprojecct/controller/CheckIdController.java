package org.kosta.ekoprojecct.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.ekoprojecct.model.MemberDAO;

public class CheckIdController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id=request.getParameter("id");
		boolean result=MemberDAO.getInstance().idcheck(id);
		String checkResult=null;
		if(result)
			checkResult="fail";
		else
			checkResult="ok";
		request.setAttribute("responsebody", checkResult);
		return "AjaxView";
	}

}
