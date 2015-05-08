/*
 * 세션 로그인 체크 인터셉터
 * @author 김기정
 */
package kr.or.kosta.community.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthCheckInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession(false);	//true해주면 세션이 없으면 생성함
		if(session != null){
			//String loginId = (String)session.getAttribute("loginId");
			return true;
		}
		
		response.sendRedirect(request.getContextPath() + "/user/login");
		return false;
	}
}
