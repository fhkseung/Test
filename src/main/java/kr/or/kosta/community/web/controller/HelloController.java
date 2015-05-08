package kr.or.kosta.community.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *  /hello.mall�� ���� ������Ʈ�ѷ� : ������̼��� �̿��� ��Ʈ�ѷ��߿����� �ֽŹ�����. 
 * @author SD
 *
 */

@Controller
public class HelloController {
	
	@RequestMapping("/hello.mall")
	//springMVC�� ����� ������ ����Ǿ� �ֱ� ������ �����ڰ� �ʿ��� ���� �������ָ� ����� �� �ִ�.
	public String hello(Model model, HttpServletRequest request){
		String message = "������̼� ��� ��Ʈ�ѷ�";
		model.addAttribute("message", message);
		return "hello";	//return���ذ��� setview�� ����Ǵ� �ּҰ��� �Ǵ� ���̴�.
	}
	
	
	//�Ʒ��� ���� �۾��ϸ� �ڵ������� �Ǵ� ������ �ϰ� �ȴ�.
	@RequestMapping("/form.mall")
	public String helloForm(){
		return "helloform";
	}
}
