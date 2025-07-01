package com.gn.service;

import java.util.List;

import com.gn.dao.StudentDao;
import com.gn.dto.Student;

public class StudentService {
	// DAO한테 부탁해서 데이터베이스에서 정보 조회, 등록, 수정, 삭제
	private StudentDao dao = new StudentDao();
	
	public List<Student> getStudentList() {
		List<Student> list = dao.selectAll();
		
		return list;
	}
	
	public Student getStudentDetail(int studentNo) {
		Student student = dao.selectOne(studentNo);
		
		return student;
	}
	
	public Student getStudentByName(String studentName) {
		Student student = dao.selectByName(studentName);
		
		return student;
	}
	
	public int insertStudent(String name, int age) {
		// 1. Map: DTO에 없는 필드가 있을 경우, 3개 이하
		// 2. DTO(Student)
		Student param = new Student();
		param.setStudentName(name);
		param.setStudentAge(age);
		
		
		return dao.insert(param);
	}

	public int updateStudent(int no, String name, int age) {
		Student student = new Student(no, name, age);
		
		return dao.update(student);
	}
	
	public int deleteStudent(int no) {
		return dao.delete(no);
	}
}
