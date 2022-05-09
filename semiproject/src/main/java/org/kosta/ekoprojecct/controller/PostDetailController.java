package org.kosta.ekoprojecct.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.ekoprojecct.model.BoardDAO;
import org.kosta.ekoprojecct.model.BoardVO;

public class PostDetailController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int no = Integer.parseInt(request.getParameter("no"));
		//로그인 유지기간동안 읽은 글에 대한 조회수 재증가 방지를 위한 코드
		
		HttpSession session=request.getSession(false);
		@SuppressWarnings("unchecked")
		ArrayList<String> myboardNoList=(ArrayList<String>) session.getAttribute("myboardNoList");
		if(myboardNoList.contains(Integer.toString(no))==false) {
			//조회수 증가
			BoardDAO.getInstance().updateHits(no);
			myboardNoList.add(Integer.toString(no));
		}
		
		//조회수 증가
		//BoardDAO.getInstance().updateHits(no);
		BoardVO bvo=  BoardDAO.getInstance().postDetail(no);
		request.setAttribute("bvo", bvo);
		request.setAttribute("url", "board/post-detail.jsp");
		return "layout.jsp";
	}

}
