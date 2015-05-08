package kr.or.kosta.community.academic.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import kr.or.kosta.community.academic.domain.Student;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
/**
 * 
 * �������� �����ϴ� ������ �׼��� ��� �� �ϳ���
 * Spring JDBC(JdbcTemplate) API�� �̿��� �����ͺ��̽� ���Ӽ� ó��
 * JdbcTemplate�� �ϰ��� DB CRUD ó���� ���� �پ��� �޼ҵ� ����
 * 
 * ��������(applicationContext.xml)�� JdbcTemplate ��� �� DataSource ���� �ʿ�
 * @author �����
 */


//@Repository("studentDao") : ���̹�Ƽ���� ����ϱ� ���ؼ� ������̼��� �׿����.
public class SpringJdbcStudentDao implements StudentDao {
	
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void add(Student student) throws RuntimeException {
		String sql = " INSERT INTO student(ssn, name, score)" +
		             " VALUES(?, ?, ?)";
		// update() : insert, update, delete ó���޼ҵ�
		// update(sql, new Object[]{student.getSsn(), student.getName(), student.getScore()});
		jdbcTemplate.update(sql, student.getSsn(), student.getName(), student.getScore());
		
		System.out.println("[Debug]: �л� ��� �Ϸ�!");
	}

	@Override
	public List<Student> getAll() throws RuntimeException {
		List<Student> list = null;
		
		String sql = " SELECT ssn, name, score" +
		             " FROM student";
		
		list = jdbcTemplate.query(sql, new RowMapper<Student>() {
			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student = new Student();
				student.setSsn(rs.getString("ssn"));
				student.setName(rs.getString("name"));
				student.setScore(rs.getInt("score"));
				return student;
			}
		});
		return list;
	}
	
	@Override
	public Student findBySsn(String ssn) throws RuntimeException{
		Student student = null;
		String sql = " SELECT ssn, name, score FROM student" +
	                 " WHERE ssn = ?";
		student = (Student)jdbcTemplate.queryForObject(sql, new Object[]{ssn}, new RowMapper<Student>(){
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException{
				Student student = new Student();
				student.setSsn(rs.getString("ssn"));
				student.setName(rs.getString("name"));
				student.setScore(rs.getInt("score"));
				return student;				
			}					
		});
		return student;
	}
	
	@Override
	public List<Student> findByScore(int min, int max) throws RuntimeException{
		List<Student> list = null;
		String sql  = " SELECT ssn, name, score" +
	                  " FROM student"+
				      " WHERE score BETWEEN ? AND ?";
		list = jdbcTemplate.query(sql, new Object[]{new Integer(min), new Integer(max)}, new RowMapper<Student>(){
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException{
				Student student = new Student();
				student.setSsn(rs.getString("ssn"));
				student.setName(rs.getString("name"));
				student.setScore(rs.getInt("score"));
				return student;				
			}
		}); 
		return list;
	}

}

/**
org.springframework.jdbc.core.JdbcTeamplate �ֿ� �޼ҵ� 
query(String sql, RowMapper rowMapper) : List
query(String sql, Object[] args, RowMapper rowMapper) : List
queryForObject(String sql, RowMapper rowMapper) : Object
queryForObject(String sql, Object[] args, RowMapper rowMapper) : Object
queryForInt(String sql) : int
queryForInt(String sql, Object[] args) : int
update(String sql, Object ...) : int
update(String sql, Object[] args) : int
*/
