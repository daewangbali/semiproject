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
	
		String id=request.getParameter("id");
		MemberDAO.getInstance().deleteMember(id);
		HttpSession session=request.getSession(false);
		session.invalidate();
		return "redirect:delete-result.jsp";
	}
}
