package org.kosta.ekoprojecct.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.ekoprojecct.model.MemberDAO;
import org.kosta.ekoprojecct.model.MemberVO;

public class UpdateMemberController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		if(request.getMethod().equals("POST")==false)
			throw new ServletException("회원정보수정은 POST방식 요청만 지원합니다");
	
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String tel=request.getParameter("tel");
		String kostaNO=request.getParameter("kostaNO");
		String password=request.getParameter("password");
		MemberVO vo=new MemberVO(id,name,tel,kostaNO,password);
		MemberDAO.getInstance().updateMember(vo);
		HttpSession session=request.getSession(false);
		session.setAttribute("mvo", vo);
		request.setAttribute("url", "mypage/update-result.jsp");
		return "layout.jsp";
	}
}
