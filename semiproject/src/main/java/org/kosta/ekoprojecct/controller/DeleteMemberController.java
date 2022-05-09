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
		if(request.getMethod().equals("POST")==false)//POST 요청방식이 아니면
			throw new ServletException(getClass().getName()+"POST 방식만 서비스 가능합니다");
		
		HttpSession session = request.getSession(false);
		MemberVO mvo = (MemberVO) session.getAttribute("mvo");
		String id = mvo.getId();
		
		MemberDAO.getInstance().deleteMember(id);
		session.invalidate();
		
		return "mypage/delete-success.jsp";
		}
}
