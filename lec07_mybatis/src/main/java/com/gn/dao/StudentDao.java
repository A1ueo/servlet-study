package com.gn.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.gn.common.SessionTemplate;
import com.gn.dto.Student;

public class StudentDao {

	public List<Student> selectAll() {
		// 데이터베이스 접근(MyBatis)
		SqlSession session = SessionTemplate.getSqlSession(true);
//		session.selectList("매퍼의 위치.메소드명", "전달하는 파라미터");
		List<Student> list = session.selectList("com.gn.mapper.StudentMapper.selectAll");
		session.close();
		
		return list;
	}
	
	public Student selectOne(int studentNo) {
		Student student = null;
		
		try (SqlSession session = SessionTemplate.getSqlSession(true)) {
			student = session.selectOne("com.gn.mapper.StudentMapper.selectOne", studentNo);
		} catch (Exception e) {
		}
		
		return student;
	}

	public Student selectByName(String studentName) {
		SqlSession session = SessionTemplate.getSqlSession(true);
		Student student = session.selectOne("com.gn.mapper.StudentMapper.selectByName", studentName);
		
		return student;
	}
	
	public int insert(Student param) {
		SqlSession session = SessionTemplate.getSqlSession(true);
		int result = session.insert("com.gn.mapper.StudentMapper.insert", param);
		session.close();
		
		return result;
	}
	
	public int update(Student student) {
		SqlSession session = SessionTemplate.getSqlSession(true);
		int result = session.update("com.gn.mapper.StudentMapper.updateStudent", student);
		session.close();
		
		return result;
	}
	
	public int delete(int no) {
		SqlSession session = SessionTemplate.getSqlSession(true);
		int result = session.delete("com.gn.mapper.StudentMapper.deleteStudent", no);
		session.close();
		
		return result;
	}
}
