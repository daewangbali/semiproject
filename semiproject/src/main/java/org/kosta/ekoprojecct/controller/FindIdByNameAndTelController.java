package org.kosta.ekoprojecct.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.kosta.ekoprojecct.model.MemberDAO;
import org.kosta.ekoprojecct.model.MemberVO;

public class FindIdByNameAndTelController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name=request.getParameter("name");
		String tel=request.getParameter("tel");
		MemberVO vo=MemberDAO.getInstance().findIdByNameAndTel(name,tel);
		if(vo==null) {
			JSONObject json=new JSONObject();
			json.put("fail", "true");
			json.put("message", "회원정보가 없습니다");
			request.setAttribute("responsebody", json);
		}else {
			JSONObject json=new JSONObject(vo);
			request.setAttribute("responsebody", json);
		}
		return "AjaxView";
	}

}
