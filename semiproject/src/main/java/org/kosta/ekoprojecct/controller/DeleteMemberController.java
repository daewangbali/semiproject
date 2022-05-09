package org.kosta.ekoprojecct.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.ekoprojecct.model.MemberDAO;
import org.kosta.ekoprojecct.model.MemberVO;

public class DeleteMemberController implements Controller{

	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		MemberVO vo=new MemberVO();
		MemberDAO.getInstance().deleteMember(id,password);
		HttpSession session=request.getSession(false);
		session.setAttribute("mvo", vo);
		request.setAttribute("url", "delete-success.jsp");
		
		
		
		return "delete-success.jsp";
		}
}
