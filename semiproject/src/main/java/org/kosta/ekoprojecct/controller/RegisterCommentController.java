package org.kosta.ekoprojecct.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.ekoprojecct.model.CommentDAO;

public class RegisterCommentController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int postNo=Integer.parseInt(request.getParameter("no"));
		String commentContent=request.getParameter("commentContent");
		String writerId = request.getParameter("writerId");
		System.out.println(postNo);
		System.out.println(commentContent);
		
		CommentDAO.getInstance().register(postNo, commentContent, writerId);
		
		request.setAttribute("number", postNo);
		return "board/registercomment-success.jsp";
	}

}
