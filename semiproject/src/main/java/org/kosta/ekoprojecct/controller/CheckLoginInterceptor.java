package org.kosta.ekoprojecct.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/*
   로그인 여부를 체크하는 역할을 하는 객체
   인증이 필요없는 컨트롤러를 저장하고
   인증이 필요없는 컨트롤러 외의 컨트롤러 , 즉 인증이 필요한 컨트롤러에 대해서는
   세션 존재, 세션 내의 인증 정보(회원객체) 존재 유무를 판단해
   로그인 되어 있는 상태이면 true, 로그인 되어 있지 않은 상태이면 false를 반환
 */
public class CheckLoginInterceptor {
	private static CheckLoginInterceptor instance = new CheckLoginInterceptor();
	//인증이 필요없는 컨트롤러 리스트
	private ArrayList<String> permitAllList = new ArrayList<String>();
	private CheckLoginInterceptor() {
		//인터셉터가 생성되는 시점에 인증이 필요없는 컨트롤러명을 저장한다
		permitAllList.add("CheckIdController");
		permitAllList.add("HomeController");
		permitAllList.add("ListController");
		permitAllList.add("LoginController");
		permitAllList.add("CheckKostaNoController");
		permitAllList.add("RegisterMemberFormController");
	}
	public static CheckLoginInterceptor getInstance() {
		return instance;
	}
	/*
	  로그인이 필요한 컨트롤러임에도 비로그인 상태이면 false를 반환
	  컨트롤러가 실행되어도 문제 없는 상태이면 true를 반환
	  
	 */
	public boolean checkLogin(HttpServletRequest request , String controllerName) {
		boolean result = true;
		if(permitAllList.contains(controllerName)==false) {//비로그인 상태에서 실행될 수 있는 컨트롤러가 아니면
			HttpSession session = request.getSession(false);
			if(session==null || session.getAttribute("mvo")==null) {
				System.out.println("**"+controllerName+" 인증이 필요한 서비스이므로 로그인 해야함");
				result = false;
			}
		}
		return result;
	}

}
















