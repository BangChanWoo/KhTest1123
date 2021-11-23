package com.myconpany.myapp09.member.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myconpany.myapp09.member.model.vo.Member;

@Repository("memberDao")
public class MemberDao {
	@Autowired
	private SqlSession sqlSession;
	
	public int insertMember(Member member) {
		return sqlSession.insert("Member.signUp",member);
	}
}
