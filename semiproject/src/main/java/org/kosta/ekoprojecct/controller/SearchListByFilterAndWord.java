package org.kosta.ekoprojecct.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.ekoprojecct.model.BoardDAO;
import org.kosta.ekoprojecct.model.BoardVO;
import org.kosta.ekoprojecct.model.Pagination;

public class SearchListByFilterAndWord implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//클라이언트로부터 페이지 번호를 전달받는다
		String pageNo=request.getParameter("pageNo");
		String filter = request.getParameter("filter");
		String word = request.getParameter("word"); 
		Pagination pagination=null;
		if(pageNo==null) //클라이언트가 pageNo를 전달하지 않는 경우에는 첫 페이지를 보여준다
			pagination=new Pagination(BoardDAO.getInstance().getTotalPostCountByFilter(filter, word));
		else
			pagination=new Pagination(BoardDAO.getInstance().getTotalPostCountByFilter(filter, word), Integer.parseInt(pageNo));
				
		//페이징 처리를 하기 위해 Pagination 객체를 공유한다
		request.setAttribute("pagination", pagination);
		
		
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		
		
		list = BoardDAO.getInstance().findPostByFilterAndWord(filter, word,pagination); //이부분수정함!!
		
		request.setAttribute("list", list);
		//request.setAttribute("url", "board/list.jsp"); //list.jsp의 pagination은 Category가 적용되어있기 때문에 search-list~.jsp 새로 만듦
		request.setAttribute("url", "board/search-listbyfilterandword.jsp"); //이부분 수정함
		return "layout.jsp";
	}

}
