package org.kosta.ekoprojecct.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.ekoprojecct.model.BoardDAO;
import org.kosta.ekoprojecct.model.BoardVO;

public class UpdatePostFormController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int no = Integer.parseInt(request.getParameter("no"));
		BoardVO bvo =  BoardDAO.getInstance().postDetail(no);
		String postCategory = request.getParameter("postCategory");
		
		if(postCategory.equals("두시")) {
			request.setAttribute("url", "board/dusi-update.jsp");
		
		}else {
			request.setAttribute("url", "board/update.jsp");
			
		}
		request.setAttribute("bvo", bvo);
		
		return "layout.jsp";
	}

}
