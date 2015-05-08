package kr.or.kosta.community.academic.dao;

import java.util.List;

import kr.or.kosta.community.academic.domain.Student;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("studentDao")
public class MybatisStudentDao implements StudentDao {
	
	@Autowired
	//rootContext.xml에 등록된 마이바티스 설정 코너에서 sqlsessionFactory라는 id와 타입이 동일해야 Autowiredehlsek.
	private SqlSessionFactory sqlSessionFactory;
	

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	
	
	@Override
	public void add(Student student) throws RuntimeException {
		SqlSession session = null;
		try{
			session = sqlSessionFactory.openSession();
			StudentDao dao = session.getMapper(StudentDao.class);
			dao.add(student);
		}finally{
			session.close();
		}
	}

	
	
	@Override
	public List<Student> getAll() throws RuntimeException {
		List<Student> list = null;
		SqlSession session = null;
		try{
			session = sqlSessionFactory.openSession();
			StudentDao dao = session.getMapper(StudentDao.class);
			list = dao.getAll();
		}finally{
			session.close();
		}
		return list;
	}

	
	
	@Override
	public Student findBySsn(String ssn) throws RuntimeException {
		Student student = null;
		SqlSession session = null;
		try{
			System.out.println(ssn);
			session = sqlSessionFactory.openSession();
			StudentDao dao = session.getMapper(StudentDao.class);
			student = dao.findBySsn(ssn);
		}finally{
			session.close();
		}
		return student;
	}

	
	
	
	@Override
	public List<Student> findByScore(int min, int max) throws RuntimeException {
		return null;
	}

}
