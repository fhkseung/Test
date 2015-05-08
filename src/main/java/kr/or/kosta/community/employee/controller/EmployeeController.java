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
 * 사원 관련 요청(목록, 조회, 검색, 등록 등) 처리 세부 컨트롤러
 * @author 김기정
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
	 * 사원 등록 화면 요청(/employee/join)
	 */
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String joinForm(Model model){
//		logger.debug("/employee/join GET 요청..");
		// employeeService.biz();
		return "employee/join";		
	}
	
	/**
	 * 사원 등록 요청(/employee/join)
	 */
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(Employee employee, BindingResult bindingResult, Model model){
//		logger.debug("/employee/join POST 요청..");
		logger.debug(employee.toString());
		
		// 유효성 검증을 캡슐화
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
	 * 사원 목록 요청(/employee/list)
	 */
	@RequestMapping("/list")
	public String list(Model model){
//		logger.debug("/employee/list 요청..");
		// employeeService.biz();
		return "employee/list";		
	}
	
	/**
	 * 사원 검색 요청(/employee/search?searchType=name&searchValue=james)
	 */
	@RequestMapping("/search")
	public String search(@RequestParam(value="searchType", required=false, defaultValue="") String searchType, @RequestParam(value="searchValue", required=false, defaultValue="") String searchValue){
//		logger.debug("/employee/search 요청..");
//		logger.debug("서치타입 : " + searchType);
//		logger.debug("서치밸류 : " + searchValue);
		
		// employeeService.biz();
		return "employee/list";		
	}
	
	/**
	 * 사원 조회(/employee/get/100)
	 */
	@RequestMapping("/get/{employeeId}")
	public String get(@PathVariable("employeeId") String employeeId){
//		logger.debug("/employee/get/사원아이디 요청..");
//		logger.debug("사원 아이디 : " + employeeId);
		
		// employeeService.biz();
		return "employee/list";		
	}
	
	/**
	 * 요청 헤더 읽기 /employee/header)
	 */
	@RequestMapping("/header")
	public String header(@RequestHeader("user-agent") String userAgent){
//		logger.debug("/employee/header 요청..");
//		logger.debug("user-agent : " + userAgent);
		
		
		if (true) {
			throw new RuntimeException("테스트예외발생");
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









