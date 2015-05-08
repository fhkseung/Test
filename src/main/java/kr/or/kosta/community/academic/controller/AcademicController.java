package kr.or.kosta.community.academic.controller;

import java.util.List;

import kr.or.kosta.HomeController;
import kr.or.kosta.community.academic.domain.Student;
import kr.or.kosta.community.academic.service.AcademicService;
import kr.or.kosta.community.academic.service.AcademicServiceImpl;
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
 * 학생관련 요청 처리 세부 컨트롤러
 * @author 김기정
 *
 */
@Controller
@RequestMapping("/academic")
public class AcademicController {
	
	
	//어노테이션 방법을 이용한 의존관계설정을 위하여 인스턴스 변수로 선언하고 Autowired를 선언함. 
	//추가적으로 setter메소드를 만들어줘야만 의존관계 설정이 완료된다.
	@Autowired
	private AcademicService academicService;

	
	public void setAcademicService(AcademicService academicService) {
		this.academicService = academicService;
	}

	/**
	 * 학생 목록 요청(/list)
	 */
	@RequestMapping("/list")
	public String list(Model model){
		List<Student> list = academicService.list();
		System.out.println(list.size());
		model.addAttribute("list", list);		
		return "/academic/list";		
	}
	
	
	/**
	 * 학생 등록(/regist)
	 */
	@RequestMapping("/regist")
	public String regist(Student student){
		academicService.regist(student);
		return "/academic/list";
	}
	
	/**
	 *  학번으로 학생찾기(/findbyssn)
	 */
	@RequestMapping("/findbyssn")
	public String findbySsn(String ssn, Model model){
		Student result = academicService.findbySsn(ssn);
		model.addAttribute("list", result);
		return "/academic/search";
	}
}









