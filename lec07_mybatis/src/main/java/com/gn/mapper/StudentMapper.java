package com.gn.mapper;

import java.util.List;

import com.gn.dto.Student;

public interface StudentMapper {
	List<Student> selectAll();
	Student selectOne(int studentNo);
	Student selectByName(String studentName);
	int insert(Student param);
	int updateStudent(Student student);
	int deleteStudent(int no);
}
