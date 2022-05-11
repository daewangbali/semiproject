package org.kosta.ekoprojecct.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.ekoprojecct.model.CommentDAO;
import org.kosta.ekoprojecct.model.CommentVO;
import org.kosta.ekoprojecct.model.MemberDAO;
import org.kosta.ekoprojecct.model.MemberVO;

public class UpdateCommentController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getMethod().equals("POST")==false)
			throw new ServletException("댓글수정은 POST방식 요청만 지원합니다");
	
		String commentContent=request.getParameter("commentContent");
		int commentNo=Integer.parseInt(request.getParameter("commentNo"));
		int postNo=Integer.parseInt(request.getParameter("postNo"));

		CommentDAO.getInstance().updateComment(commentContent, commentNo);

		request.setAttribute("commentNo", commentNo);
		request.setAttribute("postNo", postNo);
		return "board/updatecomment-success.jsp";

	}

}
