package org.kosta.ekoprojecct.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.ekoprojecct.model.BoardDAO;
import org.kosta.ekoprojecct.model.BoardVO;
import org.kosta.ekoprojecct.model.Pagination;

public class ListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//클라이언트로부터 페이지번호를 전달받는다
		/*
		String pageNo=request.getParameter("pageNo");
		Pagination pagination=null;
		if(pageNo==null) //클라이언트가 pageNo를 전달하지 않는 경우에는 첫 페이지를 보여준다
			pagination=new Pagination(BoardDAO.getInstance().getTotalPostCount());
		else
			pagination=new Pagination(BoardDAO.getInstance().getTotalPostCount(), Integer.parseInt(pageNo));
		*/
		
		String pageNo=request.getParameter("pageNo");
		String postCategory=(String)request.getParameter("postCategory");
		Pagination pagination=null;
		if(pageNo==null) //클라이언트가 pageNo를 전달하지 않는 경우에는 첫 페이지를 보여준다
			pagination=new Pagination(BoardDAO.getInstance().getTotalPostCountByCategory(postCategory));
		else
			pagination=new Pagination(BoardDAO.getInstance().getTotalPostCountByCategory(postCategory), Integer.parseInt(pageNo));
		
		
		
		
		//list.jsp에서 페이징처리를 하기 위해 Pagination 객체를 공유한다
		request.setAttribute("pagination", pagination);
		
		//String postCategory=(String)request.getParameter("postCategory");
		//System.out.println("postCategory는 "+postCategory);
		ArrayList<BoardVO> bvo = BoardDAO.getInstance().findPostList(postCategory,pagination);
		System.out.println(bvo);
		request.setAttribute("list", BoardDAO.getInstance().findPostList(postCategory,pagination));
		request.setAttribute("postCategory", postCategory);
		request.setAttribute("url", "board/list.jsp");
		return "layout.jsp";
	}

}
