package org.kosta.ekoprojecct.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.ekoprojecct.model.BoardDAO;
import org.kosta.ekoprojecct.model.BoardVO;
import org.kosta.ekoprojecct.model.CommentDAO;
import org.kosta.ekoprojecct.model.CommentVO;

public class UpdateCommentFormController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int commentNo = Integer.parseInt(request.getParameter("commentNo"));
		int postNo = Integer.parseInt(request.getParameter("postNo"));
		
		CommentVO cvo =  CommentDAO.getInstance().commentDetail(commentNo);
		request.setAttribute("cvo", cvo);
		request.setAttribute("postNo", postNo);
		
		return "board/updatecomment.jsp";
	}

}
