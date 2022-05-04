package org.kosta.ekoprojecct.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.ekoprojecct.model.MemberDAO;
import org.kosta.ekoprojecct.model.MemberVO;

public class DeleteMemberController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		MemberVO mvo= (MemberVO) session.getAttribute("mvo");
		String id=mvo.getId();
		MemberDAO.getInstance().deleteMember(id);
		session.invalidate();
		return "redirect:delete-result.jsp";
	}
}
