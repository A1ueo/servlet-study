package com.gn.service;

import java.util.List;
import java.util.Map;

import com.gn.dao.MemberDao;
import com.gn.dto.Member;

public class MemberService {
	MemberDao dao = new MemberDao();
	
	public int insertMember(String id, String pw) {
		Member member = new Member();
		member.setMemberId(id);
		member.setMemberPw(pw);
		int result = dao.insert(member);
		
		return result;
	}

	public Member selectMember(String id, String pw) {
		Member param = new Member();
		param.setMemberId(id);
		param.setMemberPw(pw);
		
		Member result = dao.selectMember(param);
		
		return result;
	}

	public List<Member> selectMemberList() {
		List<Member> list = dao.selectMemberList();
		
		return list;
	}
	
	public Map<Integer, Member> selectMemberMap() {
		Map<Integer, Member> map = dao.selectMemberMap();
		
		return map;
	}

}
