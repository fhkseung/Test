/*
 * request�� JSP���� �ʿ�� �ϴ� ���� �Ӽ��� �߰��ϴ� ���ͼ���
 * @author �����
 */
package kr.or.kosta.community.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class RequestSetupInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// ContextPath : ������Ʈ�� Ŀ���� �����ȿ��� �������� ���ø����̼�(���ؽ�Ʈ)�� ��������� �ǰ�, ������ ���ø����̼� �̸���
		//���� �޶�����. �׶� ���� ��û�� ���ø����̼��� �̸��� �˱� ���ؼ� �Ʒ��� ���� ���ͼ��͸� �̿��ؼ� contextpath�̸��� �߰��� ���� ���̴�.
		//�Ʒ��� ���� ������ ������ � ������������ EL�� ����ؼ� �� �� �ִ�.
		request.setAttribute("ctx", request.getContextPath());
		
		// ��û�� ���� URL
		//��ü URL�� �˱� ���ؼ� ����ϴ� ��û�� �Ӽ����� ��ü�������� �־���´�.
		request.setAttribute("requestURL", request.getRequestURL());
			
		// ��û �������� ȣ���� ������ URL
		//������� ���� ����ǰ� �ִ� �������� ���� ��θ� �˰� ������ ����� �� �ִ� ��Ұ� �ִ�. 
		//�װ��� referer��� ������� ����� ���ε�, �װͿ��� �̸� ��û�������� �־���´�.
		request.setAttribute("referer", request.getHeader("referer"));
		
		return true;
	}
}
