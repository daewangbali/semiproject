package org.kosta.ekoprojecct.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.ekoprojecct.model.BoardDAO;
import org.kosta.ekoprojecct.model.BoardVO;

public class DusiDetailController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int no = Integer.parseInt(request.getParameter("no"));
		HttpSession session=request.getSession(false);
		@SuppressWarnings("unchecked")
		ArrayList<String> myboardNoList=(ArrayList<String>) session.getAttribute("myboardNoList");
		if(myboardNoList.contains(Integer.toString(no))==false) {
			//조회수 증가
			BoardDAO.getInstance().updateHits(no);
			myboardNoList.add(Integer.toString(no));
		}
		
		BoardVO bvo = new BoardVO(); 
		bvo = BoardDAO.getInstance().postDetail(no);
		bvo.setYoutubeLink(bvo.getYoutubeLink().substring(17));
		request.setAttribute("bvo", bvo);
		request.setAttribute("url", "board/dusi-detail.jsp");
		return "layout.jsp";
	}

}
