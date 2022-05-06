package org.kosta.ekoprojecct.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.ekoprojecct.model.MemberDAO;

public class CheckKostaNoController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String kostaNo = request.getParameter("kostaNo");
		String checkResult = "ok";
		
		if(kostaNo.matches(".*[a-zA-Zㄱ-힣]+.*")) //정규표현식
			checkResult = "fail";
		
		request.setAttribute("responsebody", checkResult);
		return "AjaxView";
	}

}
