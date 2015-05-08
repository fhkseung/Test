package kr.or.kosta.community.academic.service;

import java.util.List;

import kr.or.kosta.community.academic.dao.StudentDao;
import kr.or.kosta.community.academic.domain.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** 
 * 학사 관련 비즈니스 메소드 구현 Business Object
 * @author 김기정
 */
@Service("academicService")
public class AcademicServiceImpl implements AcademicService{
	
	
	//컨트롤러에서와 마찬가지로 의존관계 설정을 위해서 아래와 같이 Autowired를 찍어주고 setter메소드를 작성해 준다.
	@Autowired
	private StudentDao studentDao;
	
	public AcademicServiceImpl(){}
	
	
	
	public StudentDao getStudentDao() {
		return studentDao;
	}
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	
	
	/** 학사 비즈니스 메소드 구현 */
	
	
	/** 학생 등록 */
	public void regist(Student student) throws RuntimeException{
		studentDao.add(student);
		System.out.println("[Debug] : 학생등록 완료");
	}
	
	
	/** 학생 목록 반환 */
	public List<Student> list() throws RuntimeException {
		System.out.println("[Debug] : 학생 전체 목록 반환");
		return studentDao.getAll();
	}
	
	/** 학번으로 학생찾기 */
	public Student findbySsn(String ssn) throws RuntimeException {
		System.out.println("[Debug] : 학번으로 학생 찾기");
		
		return studentDao.findBySsn(ssn);
	}
}
