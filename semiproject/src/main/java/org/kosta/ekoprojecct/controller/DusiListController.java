package org.kosta.ekoprojecct.controller;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.ekoprojecct.model.BoardDAO;
import org.kosta.ekoprojecct.model.BoardVO;

public class DusiListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//request.setAttribute("dusiList", DusiWritePostController.dusiList);
		
		ArrayList<BoardVO> list =  new ArrayList<BoardVO>();
		list = BoardDAO.getInstance().findDusiPostList();
		
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getYoutubeLink()!=null)
				list.get(i).setYoutubeLink(list.get(i).getYoutubeLink().substring(17));
			else
				break;
		}
		request.setAttribute("list", list);
		request.setAttribute("url", "board/dusi-list.jsp");
		return "layout.jsp";
	}


}
