package org.kosta.ekoprojecct.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.ekoprojecct.model.BoardDAO;

public class DeletePostController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getMethod().equals("POST")==false)//POST 요청방식이 아니면
			throw new ServletException(getClass().getName()+"POST 방식만 서비스 가능합니다");
		String viewName = null;
		int no = Integer.parseInt(request.getParameter("no"));
		String postCategory=(String)request.getParameter("postCategory");
		
		//두시게시판과 소통&자유게시판 return 다르게
		if(postCategory.equals("소통") || postCategory.equals("자유")) {
			viewName = "ListController.do?postCategori="+postCategory;
		}else {
			viewName = "DusiListController.do";
		}

		BoardDAO.getInstance().deletePost(no);
		return viewName;
	}

}
