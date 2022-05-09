package org.kosta.ekoprojecct.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.ekoprojecct.model.BoardDAO;
import org.kosta.ekoprojecct.model.BoardVO;

public class UpdatePostController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//request method 확인
		if(request.getMethod().equals("POST")==false)//POST 요청방식이 아니면
			throw new ServletException(getClass().getName()+"POST 방식만 서비스 가능합니다");
	
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int no = Integer.parseInt(request.getParameter("no"));
		BoardVO bvo = new BoardVO(no,title,content);
		BoardDAO.getInstance().updatePost(bvo);
		request.setAttribute("no", no);
		return "PostDetailController.do";
	}

}
