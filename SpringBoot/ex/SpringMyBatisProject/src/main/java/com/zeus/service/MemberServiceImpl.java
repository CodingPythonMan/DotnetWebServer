package com.zeus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zeus.dao.MemberMapper;
import com.zeus.domain.Member;
import com.zeus.domain.MemberAuth;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper memberDao;
	
	@Override
	public void register(Member member) throws Exception {
		memberDao.create(member);
		
		MemberAuth memberAuth = new MemberAuth();
		
		memberAuth.setUserNo(member.getUserNo());
		memberAuth.setAuth("ROLE_USER");
		
		memberDao.createAuth(memberAuth);
	}
}