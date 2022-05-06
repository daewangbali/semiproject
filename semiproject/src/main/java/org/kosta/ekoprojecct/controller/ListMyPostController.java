package org.kosta.ekoprojecct.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.ekoprojecct.model.BoardDAO;
import org.kosta.ekoprojecct.model.BoardVO;
import org.kosta.ekoprojecct.model.Pagination;

public class ListMyPostController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//클라이언트로부터 페이지 번호를 전달받는다
		String pageNo=request.getParameter("pageNo");
		Pagination pagination=null;
		if(pageNo==null) //클라이언트가 pageNo를 전달하지 않는 경우에는 첫 페이지를 보여준다
			pagination=new Pagination(BoardDAO.getInstance().getTotalPostCount());
		else
			pagination=new Pagination(BoardDAO.getInstance().getTotalPostCount(), Integer.parseInt(pageNo));
		
		//페이징 처리를 하기 위해 Pagination 객체를 공유한다
		request.setAttribute("pagination", pagination);
		
		String id = request.getParameter("id");
		ArrayList<BoardVO> bvo= BoardDAO.getInstance().findPostByMyId(id, pagination); //이부분 수정하기!!!!
		System.out.println(bvo);
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		
		
		list = BoardDAO.getInstance().findPostByMyId(id, pagination); //이부분 수정하기!!!!
		
		request.setAttribute("list", list);
		request.setAttribute("url", "findpostbymyid.jsp");
		return "layout.jsp";
	}

}
