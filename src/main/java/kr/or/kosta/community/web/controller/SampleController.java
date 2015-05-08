package kr.or.kosta.community.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


/**
 * sample��û�� ���� ���� ��Ʈ�ѷ� : ������̼��� �̿��� ����߿� ��������.
 * @author SD 
 *
 */

@org.springframework.stereotype.Controller
public class SampleController implements Controller {

	@Override
	@RequestMapping("/sample.do")
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {

		ModelAndView mav = new ModelAndView();
		
		//�޼����� �Դٰ� ����
		String message = "�ȳ� Spring MVC���..";
		
		mav.addObject("message", message);
		mav.setViewName("sample");
		
		return mav;
	}

}
