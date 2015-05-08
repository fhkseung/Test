package kr.or.kosta.community.academic.service;


import java.util.List;

import kr.or.kosta.community.academic.domain.Student;

/** 
 * �л� ���� ����Ͻ� �Ծ�(�߻�޼ҵ�) ����
 * @author �����
 */
public interface AcademicService {
	
	/** �л� ��� */
	public void regist(Student student) throws RuntimeException;
	
	/** �л� ��ü ��� ��ȯ */
	public List<Student> list() throws RuntimeException;
	
	/** ��Ÿ ����Ͻ� �޼ҵ� ���� */
	public Student findbySsn(String ssn) throws RuntimeException;
}
