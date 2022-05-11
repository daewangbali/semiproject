package org.kosta.ekoprojecct.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DusiWritePostFormController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("postCategory", "두시");
		request.setAttribute("url", "board/dusi-write.jsp");
		return "layout.jsp";
	}

}
