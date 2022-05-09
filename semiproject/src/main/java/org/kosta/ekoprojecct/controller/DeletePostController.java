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
		
		int no = Integer.parseInt(request.getParameter("no"));
		String postCategory=(String)request.getParameter("postCategory");
		System.out.println(postCategory);
		BoardDAO.getInstance().deletePost(no);
		return "ListController.do?postCategori="+postCategory;
	}

}
