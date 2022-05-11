package org.kosta.ekoprojecct.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.ekoprojecct.model.BoardDAO;
import org.kosta.ekoprojecct.model.BoardVO;
import org.kosta.ekoprojecct.model.CommentDAO;
import org.kosta.ekoprojecct.model.CommentVO;
import org.kosta.ekoprojecct.model.MemberVO;

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
		
		//좋아요
		MemberVO mvo = (MemberVO) session.getAttribute("mvo");
		boolean flag = BoardDAO.getInstance().checkLike(mvo.getId(),no);
		request.setAttribute("flag", flag);
		
		//좋아요수
		int likeNumber = BoardDAO.getInstance().likeNumber(no);
		request.setAttribute("likeNumber", likeNumber);
		
		String src = null;
		if(flag==true) {
			src = "images/fullheart.png";
		}else {
			src = "images/emptyheart.png";
		}
		request.setAttribute("src", src);
		
		//조회수 증가
		//BoardDAO.getInstance().updateHits(no);
		BoardVO bvo=  BoardDAO.getInstance().postDetail(no);
		
		//댓글데이터 불러오기
		ArrayList<CommentVO> list=CommentDAO.getInstance().ListCommentByPostNo(no);
		request.setAttribute("commentList", list);
		request.setAttribute("bvo", bvo);
		request.setAttribute("url", "board/post-detail.jsp");
		return "layout.jsp";
	}

}
