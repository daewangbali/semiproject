package org.kosta.ekoprojecct.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.ekoprojecct.model.BoardDAO;
import org.kosta.ekoprojecct.model.BoardVO;

public class SearchListByFilterAndWord implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		String filter = request.getParameter("filter");
		String word = request.getParameter("word"); 
		
		list = BoardDAO.getInstance().findPostByFilterAndWord(filter, word);
		
		request.setAttribute("list", list);
		request.setAttribute("url", "board/list.jsp");
		return "layout.jsp";
	}

}
