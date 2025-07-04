package com.gn.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;

import com.gn.dto.Board;
import com.gn.dto.Member;

public interface MemberMapper {
	int insertMember(Member member);
	Member selectMember(Member param);
	List<Member> selectMemberList();
	@MapKey("memberNo")
	Map<Integer, Member> selectMemberMap(Board param);
}
