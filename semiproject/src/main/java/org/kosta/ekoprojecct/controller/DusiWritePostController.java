package org.kosta.ekoprojecct.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.ekoprojecct.model.BoardDAO;
import org.kosta.ekoprojecct.model.BoardVO;
import org.kosta.ekoprojecct.model.MemberVO;

public class DusiWritePostController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getMethod().equals("POST")==false)//POST 요청방식이 아니면
			throw new ServletException(getClass().getName()+"POST 방식만 서비스 가능합니다");
		
		HttpSession session = request.getSession(false);
		MemberVO mvo =  (MemberVO)session.getAttribute("mvo");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String postCategory = request.getParameter("postCategory");
		String youtubeLink = "https://youtu.be/"+request.getParameter("youtubeLink");
		request.setAttribute("postCategory", postCategory);
		BoardVO bvo = new BoardVO(title,content,postCategory,mvo,youtubeLink);
		BoardDAO.getInstance().posting(bvo);
		return "ListController.do?postCategory="+postCategory;
	}

}
