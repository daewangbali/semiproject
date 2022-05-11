package org.kosta.ekoprojecct.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.ekoprojecct.model.BoardDAO;
import org.kosta.ekoprojecct.model.BoardVO;
import org.kosta.ekoprojecct.model.MemberVO;

public class ListLikeController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("mvo");
		
		ArrayList<BoardVO> bvo = BoardDAO.getInstance().findLikePostList(mvo);
		System.out.println("ddsfafs"+bvo);
		request.setAttribute("list", bvo);
		request.setAttribute("url", "mypage/likePost.jsp");
		
		return "layout.jsp";
	}

}
