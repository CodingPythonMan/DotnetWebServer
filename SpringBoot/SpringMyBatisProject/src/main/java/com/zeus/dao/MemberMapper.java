package com.zeus.dao;

import com.zeus.domain.Member;
import com.zeus.domain.MemberAuth;

public interface MemberMapper {
	public void create(Member member) throws Exception;
	public void createAuth(MemberAuth memberAuth) throws Exception;
}
