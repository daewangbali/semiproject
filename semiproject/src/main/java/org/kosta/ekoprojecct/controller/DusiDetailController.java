package org.kosta.ekoprojecct.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.ekoprojecct.model.BoardDAO;
import org.kosta.ekoprojecct.model.BoardVO;

public class DusiDetailController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int no = Integer.parseInt(request.getParameter("no"));
		BoardVO bvo = new BoardVO(); 
		bvo = BoardDAO.getInstance().postDetail(no);
		bvo.setYoutubeLink(bvo.getYoutubeLink().substring(17));
		request.setAttribute("bvo", bvo);
		request.setAttribute("url", "board/dusi-detail.jsp");
		return "layout.jsp";
	}

}
