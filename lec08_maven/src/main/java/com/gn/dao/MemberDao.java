package com.gn.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.gn.common.sql.SqlSessionTemplate;
import com.gn.dto.Member;

public class MemberDao {

	public int insert(Member member) {
		SqlSession session = SqlSessionTemplate.getSqlSession(true);
		int result = session.insert("com.gn.mapper.MemberMapper.insertMember", member);
		session.close();
		
		return result;
	}

	public Member selectMember(Member param) {
		SqlSession session = SqlSessionTemplate.getSqlSession(true);
		Member result = session.selectOne("com.gn.mapper.MemberMapper.selectMember", param);
		session.close();
		return result;
	}

	public List<Member> selectMemberList() {
		SqlSession session = SqlSessionTemplate.getSqlSession(true);
		List<Member> list = session.selectList("com.gn.mapper.MemberMapper.selectMemberList");
		session.close();
		
		return list;
	}
	
	public Map<Integer, Member> selectMemberMap(){
		SqlSession session = SqlSessionTemplate.getSqlSession(true);
		Map<Integer, Member> map = session.selectMap("com.gn.mapper.MemberMapper.selectMemberMap", "memberNo");
		session.close();
		
		return map;
//		return null;
	}
	
}
