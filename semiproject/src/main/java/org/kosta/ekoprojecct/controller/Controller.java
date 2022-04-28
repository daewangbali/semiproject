package org.kosta.ekoprojecct.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 컨트롤러 객체의 계층구조 형성을 위한 인터페이스
 * 계층구조 형성을 통해 다형성 지원이 목적
 * 캡슐화를 위해 인터페이스를 정의
 * 개별 컨트롤러를 사용하는 FrontControllerServlet 과 HandlerMapping 은 개별 컨트롤러 객체를 보지않고
 * 인터페이스 Controller 타입으로 처리하면 되므로 생산성과 유지보수성이 향상
 */
public interface Controller {
	/**
	 * 컨트롤러 객체의 실행 방식을 표준화하는 abstract 메서드 (ex - Player 들의 재생버튼 (play())
	 * @param request
	 * @param response
	 * @return viewPath - client에게 응답할 view 정보를 리턴, redirect 시에는 redirect: 을 서두에 명시
	 * @throws Exception
	 */
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception ;
}









