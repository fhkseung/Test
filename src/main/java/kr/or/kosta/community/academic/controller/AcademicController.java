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
 * �л����� ��û ó�� ���� ��Ʈ�ѷ�
 * @author �����
 *
 */
@Controller
@RequestMapping("/academic")
public class AcademicController {
	
	
	//������̼� ����� �̿��� �������輳���� ���Ͽ� �ν��Ͻ� ������ �����ϰ� Autowired�� ������. 
	//�߰������� setter�޼ҵ带 �������߸� �������� ������ �Ϸ�ȴ�.
	@Autowired
	private AcademicService academicService;

	
	public void setAcademicService(AcademicService academicService) {
		this.academicService = academicService;
	}

	/**
	 * �л� ��� ��û(/list)
	 */
	@RequestMapping("/list")
	public String list(Model model){
		List<Student> list = academicService.list();
		System.out.println(list.size());
		model.addAttribute("list", list);		
		return "/academic/list";		
	}
	
	
	/**
	 * �л� ���(/regist)
	 */
	@RequestMapping("/regist")
	public String regist(Student student){
		academicService.regist(student);
		return "/academic/list";
	}
	
	/**
	 *  �й����� �л�ã��(/findbyssn)
	 */
	@RequestMapping("/findbyssn")
	public String findbySsn(String ssn, Model model){
		Student result = academicService.findbySsn(ssn);
		model.addAttribute("list", result);
		return "/academic/search";
	}
}









