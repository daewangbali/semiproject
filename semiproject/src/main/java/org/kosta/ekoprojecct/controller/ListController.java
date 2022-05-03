package org.kosta.ekoprojecct.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.ekoprojecct.model.BoardDAO;
import org.kosta.ekoprojecct.model.BoardVO;

public class ListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String postCategory=(String)request.getParameter("postCategory");
		System.out.println(postCategory);
		ArrayList<BoardVO> bvo = BoardDAO.getInstance().findPostList(postCategory);
		System.out.println(bvo);
		request.setAttribute("list", BoardDAO.getInstance().findPostList(postCategory));
		request.setAttribute("url", "board/list.jsp");
		return "layout.jsp";
	}

}
