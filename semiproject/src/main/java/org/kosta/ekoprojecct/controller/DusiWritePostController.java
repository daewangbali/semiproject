package org.kosta.ekoprojecct.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.ekoprojecct.model.BoardDAO;
import org.kosta.ekoprojecct.model.BoardVO;
import org.kosta.ekoprojecct.model.MemberVO;
import org.kosta.ekoprojecct.model.Pagination;

public class DusiWritePostController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getMethod().equals("POST")==false)//POST 요청방식이 아니면
			throw new ServletException(getClass().getName()+"POST 방식만 서비스 가능합니다");
		
		String youtube = request.getParameter("youtubeLink");
		
		HttpSession session = request.getSession(false);
		MemberVO mvo =  (MemberVO)session.getAttribute("mvo");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String postCategory = "두시";
		String youtubeLink = "https://youtu.be/"+youtube;
		request.setAttribute("postCategory", postCategory);
		BoardVO bvo = new BoardVO(title,content,postCategory,mvo,youtubeLink);
		BoardDAO.getInstance().posting(bvo);//글쓰기
		
		String pageNo=request.getParameter("pageNo");
		Pagination pagination=null;
		if(pageNo==null) //클라이언트가 pageNo를 전달하지 않는 경우에는 첫 페이지를 보여준다
			pagination=new Pagination(BoardDAO.getInstance().getTotalPostCountByCategory(postCategory));
		else
			pagination=new Pagination(BoardDAO.getInstance().getTotalPostCountByCategory(postCategory), Integer.parseInt(pageNo));
		
		return "DusiListController.do";
	}

}
