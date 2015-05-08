package kr.or.kosta.community.employee.controller;

import kr.or.kosta.community.employee.domain.Employee;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Employee.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Employee employee = (Employee) target;
		if(StringUtils.isEmpty(employee.getEmployeeId())){
			errors.reject("id", "사원번호를 입력하세요..");
		}
		
		/*
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeeId", "사원번호를 입력하세요..");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "포스트이름을 입력하세요..");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "라스트이름 입력하세요..");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "salary", "연봉을 입력하세요..");
		*/
	}

}







