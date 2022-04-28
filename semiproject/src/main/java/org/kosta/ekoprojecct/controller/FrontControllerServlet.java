package org.kosta.ekoprojecct.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * .do 스타일의 요청을 FrontControllerServlet이 처리하도록 설정
 */
@WebServlet("*.do")
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//dispatch : 담당 컨트롤러에 작업을 배당
	protected void doDispatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//client의 요청을 분석 -> 처리할 실제 컨트롤러명을 uri에서 추출
			String uri = request.getRequestURI();
			String controllerName = uri.substring(request.getContextPath().length()+1,uri.length()-3);
			
			//인증체크 공통정책
			/*
			boolean result = CheckLoginInterceptor.getInstance().checkLogin(request, controllerName);
			if(result==false) {
				response.sendRedirect("index.jsp");//로그인 필요함에도 비로그인 상태이므로 로그인 폼이 있는 index.jsp로 응답한다
				return;//메서드 실행을 종료
			}
			*/
			
			//추출한 컨트롤러명으로 HandlerMapping에 의뢰하여 개별 컨트롤러 객체를 상위 인터페이스 Controller 타입으로 반환
			Controller controller = HandlerMapping.getInstance().create(controllerName);
			String viewName = controller.execute(request, response);//상위 인터페이스에 의해 표준화된 abstract method로 다양한 컨트롤러 객체를 실행할 수 있다
			if(viewName.startsWith("redirect:")) {
				response.sendRedirect(viewName.substring(9));//substring은 redirect: 를 제외하기 위해
			}else {
				request.getRequestDispatcher(viewName).forward(request, response);
			}
		}catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doDispatch(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//post 방식 한글처리 (request body 인코딩 설정)
		doDispatch(request, response);
	}

}









