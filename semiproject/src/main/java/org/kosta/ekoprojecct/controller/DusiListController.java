package org.kosta.ekoprojecct.controller;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.ekoprojecct.controller.Controller;
import org.kosta.ekoprojecct.controller.DusiWritePostController;
import org.kosta.ekoprojecct.model.BoardDAO;
import org.kosta.ekoprojecct.model.BoardVO;
import org.kosta.ekoprojecct.model.Pagination;

public class DusiListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//request.setAttribute("dusiList", DusiWritePostController.dusiList);
		String pageNo=request.getParameter("pageNo");
		Pagination pagination=null;
		if(pageNo==null) //클라이언트가 pageNo를 전달하지 않는 경우에는 첫 페이지를 보여준다
			pagination=new Pagination(BoardDAO.getInstance().getTotalPostCountByCategory("두시"));
		else
			pagination=new Pagination(BoardDAO.getInstance().getTotalPostCountByCategory("두시"), Integer.parseInt(pageNo));
		
		ArrayList<BoardVO> list =  new ArrayList<BoardVO>();
		list = BoardDAO.getInstance().findPostList("두시",pagination);
		
		for(int i=0;i<list.size();i++) {
			list.get(i).setYoutubeLink(list.get(i).getYoutubeLink().substring(17));
		}
		request.setAttribute("list", list);
		request.setAttribute("url", "board/dusi-list.jsp");
		return "layout.jsp";
	}


}
