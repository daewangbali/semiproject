package org.kosta.ekoprojecct.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.ekoprojecct.model.BoardDAO;
import org.kosta.ekoprojecct.model.MemberVO;

public class LikeController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		boolean flag = Boolean.parseBoolean(request.getParameter("flag"));
		//int flag = Integer.parseInt(request.getParameter("flag"));
		int no = Integer.parseInt(request.getParameter("no"));
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("mvo");
		String checkResult=null;
		
		if(flag==false) {
			BoardDAO.getInstance().like(mvo, no);
			flag = true;
			checkResult = "ok";
			
		}else {
			BoardDAO.getInstance().cancelLike(mvo, no);
			flag = false;
			checkResult = "fail";//좋아요 취소 fail을 할당
			
		}
		
		BoardDAO.getInstance().likeNumber(no);
		request.setAttribute("flag", flag);
		request.setAttribute("responsebody", checkResult);
		
		return "AjaxView";
	}

}
