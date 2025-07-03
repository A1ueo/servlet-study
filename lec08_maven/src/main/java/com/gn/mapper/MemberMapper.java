package com.gn.mapper;

import java.util.List;
import java.util.Map;

import com.gn.dto.Member;

public interface MemberMapper {
	int insertMember(Member member);
	Member selectMember(Member param);
	List<Member> selectMemberList();
	Map<Object, Object> selectMemberMap();
}
