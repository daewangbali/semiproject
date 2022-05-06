package org.kosta.ekoprojecct.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.ekoprojecct.model.MemberDAO;
import org.kosta.ekoprojecct.model.MemberVO;

public class CheckPasswordController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		MemberVO mvo=(MemberVO)session.getAttribute("mvo");
		String password=request.getParameter("password");
		String id=mvo.getId();
		boolean result=MemberDAO.getInstance().passwordcheck(id,password);
		String checkResult=null;
		if(result)
			checkResult="ok";
		else
			checkResult="fail";
		request.setAttribute("responsebody", checkResult);
		return "AjaxView";
	}
}
