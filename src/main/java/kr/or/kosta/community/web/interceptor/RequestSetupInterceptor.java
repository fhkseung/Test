/*
 * request에 JSP에서 필요로 하는 공통 속성을 추가하는 인터셉터
 * @author 김기정
 */
package kr.or.kosta.community.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class RequestSetupInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// ContextPath : 프로젝트가 커지면 서버안에서 여러개의 어플리케이션(컨텍스트)가 만들어지게 되고, 각각의 어플리케이션 이름은
		//각기 달라진다. 그때 현재 요청된 어플리케이션의 이름을 알기 위해서 아래와 같이 인터셉터를 이용해서 contextpath이름을 추가해 놓는 것이다.
		//아래와 같이 설정해 놓으면 어떤 페이지에서도 EL을 사용해서 쓸 수 있다.
		request.setAttribute("ctx", request.getContextPath());
		
		// 요청된 실제 URL
		//전체 URL을 알기 위해서 사용하는 요청에 속성으로 전체페이지를 넣어놓는다.
		request.setAttribute("requestURL", request.getRequestURL());
			
		// 요청 페이지를 호출한 페이지 URL
		//헤더에는 현재 실행되고 있는 페이지의 이전 경로를 알고 싶을때 사용할 수 있는 요소가 있다. 
		//그것이 referer라는 헤더내에 저장된 값인데, 그것역시 미리 요청페이지에 넣어놓는다.
		request.setAttribute("referer", request.getHeader("referer"));
		
		return true;
	}
}
