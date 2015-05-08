package kr.or.kosta.community.user.controller;

import kr.or.kosta.HomeController;
import kr.or.kosta.community.employee.domain.Employee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ��� ���� ��û(���, ��ȸ, �˻�, ��� ��) ó�� ���� ��Ʈ�ѷ�
 * @author �����
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	

	/**
	 * �α��� ȭ�� ��û(/user/login)
	 */
	@RequestMapping(value="/author/login", method=RequestMethod.GET)
	public String loginForm(Model model){
		// employeeService.biz();
		return "/user/login";		
	}
	
	
}









