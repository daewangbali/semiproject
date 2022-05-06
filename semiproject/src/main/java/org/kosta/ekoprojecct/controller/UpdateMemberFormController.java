package org.kosta.ekoprojecct.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.ekoprojecct.model.MemberVO;

public class UpdateMemberFormController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("mvo")==null)
			return "redirect:myPage.jsp";	
		request.setAttribute("url", "mypage/update-form.jsp");
		return "layout.jsp";
	}
}
