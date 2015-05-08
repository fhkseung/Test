/*
 * �α׸� ����ϴ� ���ͼ���
 * @author �����
 */
package kr.or.kosta.community.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoggerInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Logger logger = LoggerFactory.getLogger(LoggerInterceptor.class);
		logger.debug(handler.toString() + "����...");		
		return true;
	}
}
