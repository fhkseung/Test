package kr.or.kosta.community.academic.dao;


import java.util.List;

import kr.or.kosta.community.academic.domain.Student;

/** 
 * �л� ���� ���Ӽ� ó�� �Ծ� ����
 * @author �����
 */
public interface StudentDao {
	/** �л� ��� */
	public void add(Student student) throws RuntimeException;
	/** ��ü �л� �˻� */
	public List<Student> getAll() throws RuntimeException;
	/** �й����� �л� �˻� */
	public Student findBySsn(String ssn) throws RuntimeException;
	/** ���� ������ �л� ��� �˻� */
	public List<Student> findByScore(int min, int max) throws RuntimeException;
}
