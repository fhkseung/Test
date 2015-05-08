package kr.or.kosta.community.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


/**
 * sample요청에 대한 세부 컨트롤러 : 어노테이션을 이용한 방식중에 구버젼임.
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
		
		//메세지가 왔다고 가정
		String message = "안녕 Spring MVC모듈..";
		
		mav.addObject("message", message);
		mav.setViewName("sample");
		
		return mav;
	}

}
