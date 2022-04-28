package org.kosta.ekoprojecct.controller;
/**
 * HandlerMapping : 개별 컨트롤러 객체 생성을 전담하는 Factory 객체
 * 
 * 시스템에서 하나의 객체만 생성되어 운용되도록 Singleton Design Pattern을 적용
 * @author KOSTA
 *
 */
public class HandlerMapping {
	private static HandlerMapping instance = new HandlerMapping();
	private HandlerMapping() {}
	public static HandlerMapping getInstance() {
		return instance;
	}
	/**
	 * Reflection : 런타임시에 객체를 제어하기 위한 기술, 이를 이용해 클래스 정보로 객체를 생성
	 * @param controllerName
	 * @return controller 실제 요청을 처리할 컨트롤러 객체
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public Controller create(String controllerName) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Controller controller = null;
		//현재 컨트롤러 패키지명을 동적으로 얻어온다
		String packageInfo = this.getClass().getPackage().getName();
		//패키지명.클래스명
		String classInfo = new StringBuilder(packageInfo).append(".").append(controllerName).toString();
		controller = (Controller) Class.forName(classInfo).newInstance();
		return controller;
	}
}












