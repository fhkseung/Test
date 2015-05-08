package kr.or.kosta.community.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *  /hello.mall에 대한 세부컨트롤러 : 어노테이션을 이용한 컨트롤러중에서도 최신버젼임. 
 * @author SD
 *
 */

@Controller
public class HelloController {
	
	@RequestMapping("/hello.mall")
	//springMVC는 어댑터 패턴이 적용되어 있기 때문에 개발자가 필요한 것을 선언만해주면 사용할 수 있다.
	public String hello(Model model, HttpServletRequest request){
		String message = "어노테이션 기반 컨트롤러";
		model.addAttribute("message", message);
		return "hello";	//return해준값이 setview에 저장되는 주소값이 되는 것이다.
	}
	
	
	//아래와 같이 작업하면 자동포워드 되는 역할을 하게 된다.
	@RequestMapping("/form.mall")
	public String helloForm(){
		return "helloform";
	}
}
