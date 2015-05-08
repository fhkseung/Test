package kr.or.kosta.community.employee.controller;

import kr.or.kosta.community.employee.domain.Employee;
import kr.or.kosta.community.web.exception.CommunityException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
@RequestMapping("/employee")
public class EmployeeController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeValidator employeeValidator;
	
	
	public void setEmployeeValidator(EmployeeValidator employeeValidator) {
		this.employeeValidator = employeeValidator;
	}

	/**
	 * ��� ��� ȭ�� ��û(/employee/join)
	 */
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String joinForm(Model model){
//		logger.debug("/employee/join GET ��û..");
		// employeeService.biz();
		return "employee/join";		
	}
	
	/**
	 * ��� ��� ��û(/employee/join)
	 */
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(Employee employee, BindingResult bindingResult, Model model){
//		logger.debug("/employee/join POST ��û..");
		logger.debug(employee.toString());
		
		// ��ȿ�� ������ ĸ��ȭ
//		new EmployeeValidator().validate(employee, bindingResult);
		employeeValidator.validate(employee, bindingResult);
		
		if(bindingResult.hasErrors()){
			model.addAttribute("errors", bindingResult);
			return "employee/join";
		}
		
		// employeeService.biz();
		
		return "employee/result";	
	}
	
	
	/**
	 * ��� ��� ��û(/employee/list)
	 */
	@RequestMapping("/list")
	public String list(Model model){
//		logger.debug("/employee/list ��û..");
		// employeeService.biz();
		return "employee/list";		
	}
	
	/**
	 * ��� �˻� ��û(/employee/search?searchType=name&searchValue=james)
	 */
	@RequestMapping("/search")
	public String search(@RequestParam(value="searchType", required=false, defaultValue="") String searchType, @RequestParam(value="searchValue", required=false, defaultValue="") String searchValue){
//		logger.debug("/employee/search ��û..");
//		logger.debug("��ġŸ�� : " + searchType);
//		logger.debug("��ġ��� : " + searchValue);
		
		// employeeService.biz();
		return "employee/list";		
	}
	
	/**
	 * ��� ��ȸ(/employee/get/100)
	 */
	@RequestMapping("/get/{employeeId}")
	public String get(@PathVariable("employeeId") String employeeId){
//		logger.debug("/employee/get/������̵� ��û..");
//		logger.debug("��� ���̵� : " + employeeId);
		
		// employeeService.biz();
		return "employee/list";		
	}
	
	/**
	 * ��û ��� �б� /employee/header)
	 */
	@RequestMapping("/header")
	public String header(@RequestHeader("user-agent") String userAgent){
//		logger.debug("/employee/header ��û..");
//		logger.debug("user-agent : " + userAgent);
		
		
		if (true) {
			throw new RuntimeException("�׽�Ʈ���ܹ߻�");
		}
		
	/*	
		try{
			xxx.serviceviz();
		}catch(Exception e){
			throw new CommunityException(e);
		}
	*/	
		
		// employeeService.biz();
		return "redirect:/employee/list";	
	}
}









