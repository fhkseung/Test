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
			errors.reject("id", "�����ȣ�� �Է��ϼ���..");
		}
		
		/*
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeeId", "�����ȣ�� �Է��ϼ���..");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "����Ʈ�̸��� �Է��ϼ���..");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "��Ʈ�̸� �Է��ϼ���..");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "salary", "������ �Է��ϼ���..");
		*/
	}

}







