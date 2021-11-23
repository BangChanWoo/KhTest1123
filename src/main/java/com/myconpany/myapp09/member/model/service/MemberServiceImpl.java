package com.myconpany.myapp09.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myconpany.myapp09.member.model.dao.MemberDao;
import com.myconpany.myapp09.member.model.vo.Member;



@Service("memberService")
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public int insertMember(Member member) {
		int result=0;
		try {
			result = memberDao.insertMember(member);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}
}
