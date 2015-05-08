package kr.or.kosta.community.academic.service;

import java.util.List;

import kr.or.kosta.community.academic.dao.StudentDao;
import kr.or.kosta.community.academic.domain.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** 
 * �л� ���� ����Ͻ� �޼ҵ� ���� Business Object
 * @author �����
 */
@Service("academicService")
public class AcademicServiceImpl implements AcademicService{
	
	
	//��Ʈ�ѷ������� ���������� �������� ������ ���ؼ� �Ʒ��� ���� Autowired�� ����ְ� setter�޼ҵ带 �ۼ��� �ش�.
	@Autowired
	private StudentDao studentDao;
	
	public AcademicServiceImpl(){}
	
	
	
	public StudentDao getStudentDao() {
		return studentDao;
	}
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	
	
	/** �л� ����Ͻ� �޼ҵ� ���� */
	
	
	/** �л� ��� */
	public void regist(Student student) throws RuntimeException{
		studentDao.add(student);
		System.out.println("[Debug] : �л���� �Ϸ�");
	}
	
	
	/** �л� ��� ��ȯ */
	public List<Student> list() throws RuntimeException {
		System.out.println("[Debug] : �л� ��ü ��� ��ȯ");
		return studentDao.getAll();
	}
	
	/** �й����� �л�ã�� */
	public Student findbySsn(String ssn) throws RuntimeException {
		System.out.println("[Debug] : �й����� �л� ã��");
		
		return studentDao.findBySsn(ssn);
	}
}
