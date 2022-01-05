package com.zeus;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.querydsl.core.BooleanBuilder;
import com.zeus.constant.Gender;
import com.zeus.domain.Member;
import com.zeus.domain.QMember;
import com.zeus.repository.MemberRepository;

@SpringBootTest
public class MemberTests {
	@Autowired
	MemberRepository memberRepository;
	/*
	// 등록 테스트
	@Test
	public void testRegister() {
		Member member1 = new Member();
		member1.setUserId("jupiter");
		member1.setUserPw("1234");
		member1.setUserName("Alex");
		member1.setGender(Gender.MALE);
		member1.setJoinDate(new Date());
		
		System.out.println("###_1 save before");
		memberRepository.save(member1);
		System.out.println("###_1 save after");
	
		Member member2 = new Member();
		member2.setUserId("venus");
		member2.setUserPw("4567");
		member2.setUserName("Olivia");
		member2.setGender(Gender.FEMALE);
		member2.setJoinDate(new Date());
		
		System.out.println("###_2 save before");
		memberRepository.save(member2);
		System.out.println("###_2 save after");
		
		Member member3 = new Member();
		member1.setUserId("mercury");
		member1.setUserPw("9876");
		member1.setUserName("Tyler");
		member1.setGender(Gender.FEMALE);
		member1.setJoinDate(new Date());
		
		System.out.println("###_3 save before");
		memberRepository.save(member3);
		System.out.println("###_3 save after");
	}
	
	// 목록 조회 태스트
	@Test
	public void testList() {
		System.out.println("###_1 findAll before");
		Iterable<Member> memberList = memberRepository.findAll();
		System.out.println("###_1 findAll after");
	
		System.out.println("###_2 print before");
		for(Member member : memberList) {
			System.out.println(member);
		}
		System.out.println("###_2 print after");
	}
	
	// 상세 조회 테스트
	@Test
	public void testRead() {
		System.out.println("###_1 findById before");
		Optional<Member> memberOptional = memberRepository.findById(1L);
		System.out.println("###_1 findById after");
		
		System.out.println("###_2 print before");
		if(memberOptional.isPresent()) {
			Member member = memberOptional.get();
			
			System.out.println(member);
		}
		System.out.println("###_2 print after");
	}
	
	// 수정 테스트
	@Test
	public void testModify() {
		System.out.println("###_1 findById before");
		Optional<Member> memberOptional = memberRepository.findById(1L);
		System.out.println("###_1 findById after");

		if(memberOptional.isPresent()) {
			Member member = memberOptional.get();
			member.setUserName("Alexander");
		
			System.out.println("###_2 save before");
			memberRepository.save(member);
			System.out.println("###_2 save after");
		}
	}
	
	// 삭제 테스트
	@Test
	public void testRemove() {
		System.out.println("###_1 deleteById before");
		memberRepository.deleteById(1L);
		System.out.println("###_1 deleteById after");
	}*/
	/*
	// 등록 테스트 -1
	@Test
	public void testRegister01() {
		Member member1 = new Member();
		member1.setUserId("jupiter");
		member1.setUserPw("1234");
		member1.setUserName("홍길동");
	
		memberRepository.save(member1);
		
		Member member2 = new Member();
		member2.setUserId("venus");
		member2.setUserPw("4567");
		member2.setUserName("김유신");
		
		memberRepository.save(member2);
		
		Member member3 = new Member();
		member3.setUserId("mercury");
		member3.setUserPw("9876");
		member3.setUserName("강감찬");
	
		memberRepository.save(member3);
	}
	
	// 등록 테스트 -2
	@Test
	public void testRegister02() {
		List<Member> memberList = new ArrayList<Member>();
		
		Member member1 = new Member();
		member1.setUserId("jupiter1");
		member1.setUserPw("1234");
		member1.setUserName("홍길동1");
		memberList.add(member1);
		
		Member member2 = new Member();
		member2.setUserId("venus1");
		member2.setUserPw("4567");
		member2.setUserName("김유신1");
		memberList.add(member2);
		
		Member member3 = new Member();
		member3.setUserId("mercury1");
		member3.setUserPw("9876");
		member3.setUserName("강감찬1");
		memberList.add(member3);
		
		memberRepository.saveAll(memberList);
	}	
	
	// 목록 조회 테스트 -1
	@Test
	public void testList01() {
		Iterable<Member> memberList = memberRepository.findAll();
		
		for(Member member : memberList) {
			System.out.println(member);
		}
	}
	
	// 목록 조회 테스트-2
	@Test
	public void testList02() {
		List<Long> idList = new ArrayList<Long>();
	
		Long id1 = 1L;
		Long id2 = 2L;
		
		idList.add(id1);
		idList.add(id2);
		
		Iterable<Member> memberList = memberRepository.findAllById(idList);
	
		for(Member member : memberList) {
			System.out.println(member);
		}
	}
	
	// 상세 조회 테스트
	@Test
	public void testRead() {
		Optional<Member> memberOptional = memberRepository.findById(1L);
		
		if(memberOptional.isPresent()) {
			Member member = memberOptional.get();
			System.out.println(member);
		}
	}
	
	// 수정 테스트
	@Test
	public void testModify() {
		Optional<Member> memberOptional = memberRepository.findById(1L);
		
		if(memberOptional.isPresent()) {
			Member member = memberOptional.get();
			member.setUserName("이순신");
			
			memberRepository.save(member);
		}
	}
	
	// 삭제 테스트 -1
	@Test
	public void testRemove01() {
		memberRepository.deleteById(2L);
	}
	
	// 삭제 테스트-2
	@Test
	public void testRemove02() {
		Optional<Member> memberOptional = memberRepository.findById(1L);
		
		if(memberOptional.isPresent()) {
			Member member = memberOptional.get();
			
			memberRepository.delete(member);
		}
	}
	
	// 삭제 테스트 -3
	@Test
	public void testRemove03() {
		memberRepository.deleteAll();
	}
	
	@Test
	public void testRegister() {
		for(int i=0; i<10; i++) {
			long userNo = i+1;
			Member member = new Member();
			member.setUserId("user"+ userNo);
			member.setUserPw("password" + userNo);
			member.setUserName("홍길동" + userNo);
		
			memberRepository.save(member);
		}
	}
	
	// 목록 조회 테스트-1
	@Test
	public void testListAll() {
		Iterable<Member> memberList = memberRepository.findAll();
		
		for(Member member : memberList) {
			System.out.println(member);
		}
	}
	
	// 목록 조회 테스트 -2
	@Test
	public void testList01() {
		List<Member> memberList = memberRepository.findByUserId("user7");
		
		for(Member member : memberList) {
			System.out.println(member);
		}
	}
	
	//목록 조회 테스트 -3
	@Test
	public void testList02() {
		List<Member> memberList = memberRepository.findByUserPw("password8");
		
		for(Member member : memberList) {
			System.out.println(member);
		}
	}
	
	// 목록 조회 테스트 -4
	@Test
	public void testList03() {
		List<Member> memberList = memberRepository.findByUserIdAndUserPw("user3", "password3");
		
		for(Member member : memberList) {
			System.out.println(member);
		}
	}
	
	// 목록 조회 테스트 -5
	@Test
	public void testList04() {
		List<Member> memberList = memberRepository.findByUserNameContaining("홍길동6");
		
		for(Member member : memberList) {
			System.out.println(member);
		}
	}
	
	// 목록 조회 테스트 -6
	@Test
	public void testList05() {
		Collection<Member> memberList = memberRepository.findByUserNoGreaterThan(8L);
		
		for(Member member : memberList) {
			System.out.println(member);
		}
	}
	
	// 목록 조회 테스트 -7
	@Test
	public void testList06() {
		//PageRequest.of(int page, int size, Direction direction, String... properties)
		Pageable pageRequest = PageRequest.of(0, 10,Sort.Direction.DESC, "userNo");
		
		Page<Member> page = memberRepository.findByUserNoGreaterThan(0L, pageRequest);
		
		int totalPages = page.getTotalPages();
		
		System.out.println(page);
		System.out.println("totalPages: " + totalPages);

		Pageable pageable = page.getPageable();
		
		int pageNumber = pageable.getPageNumber();
		int pageSize = pageable.getPageSize();
		
		System.out.println(pageable);
		System.out.println("pageNumber: " + pageNumber);
		System.out.println("pageSize: " + pageSize);
		
		List<Member> memberList = page.getContent();
		
		for(Member member : memberList) {
			System.out.println(member);
		}
	}
	
	// 목록 조회 테스트 -8
	@Test
	public void testList07() {
		Collection<Member> memberList = memberRepository.findByUserNoGreaterThanOrderByUserNoDesc(0L);
		
		for(Member member : memberList) {
			System.out.println(member);
		}
	}
	
	// 목록 조회 테스트 -9
	@Test
	public void testList08() {
		Pageable pageRequest = PageRequest.of(0, 10);
		List<Member> memberList = memberRepository.findByUserNoGreaterThanOrderByUserNoDesc(0L, pageRequest);
			
		for(Member member : memberList) {
			System.out.println(member);
		}
	}
	
	// 목록 조회 테스트 -10
	@Test
	public void testFindMemberByUserId() {
		List<Member> memberList = memberRepository.findMemberByUserId("user7");
		
		for(Member member : memberList) {
			System.out.println(member);
		}
	}
	
	// 상세 조회 테스트
	@Test
	public void testRead() {
		Optional<Member> memberOptional = memberRepository.findById(1L);
		
		if(memberOptional.isPresent()) {
			Member member = memberOptional.get();
			System.out.println(member);
		}
	}
	
	// 수정테스트
	@Test
	public void testModify() {
		Optional<Member> memberOptional = memberRepository.findById(1L);
		
		if(memberOptional.isPresent()) {
			Member member = memberOptional.get();
			member.setUserName("갑돌이");
			
			memberRepository.save(member);
		}
	}
	
	// 삭제 테스트
	@Test
	public void testRemove() {
		memberRepository.deleteById(1L);
	}
	
	// 등록 테스트
	@Test
	public void testRegister() {
		for(int i=0; i<10; i++) {
			long userNo = i + 1;
			Member member = new Member();
			member.setUserId("user" + userNo);
			member.setUserPw("password" + userNo);
			member.setUserName("이순신" + userNo);
	
			memberRepository.save(member);
		}
	}
	
	// 목록 조회 테스트 -1
	@Test
	public void testListAll() {
		Iterable<Member> memberList = memberRepository.findAll();
	
		for(Member member : memberList) {
			System.out.println(member);
		}
	}
	
	// 목록 조회 테스트 -2
	@Test
	public void testList01() {
		List<Member> memberList = memberRepository.getList01("user7");
		
		for(Member member : memberList) {
			System.out.println(member);
		}
	}
	
	// 목록 조회 테스트 -3
	@Test
	public void testList02() {
		List<Member> memberList = memberRepository.getList02("password8");
	
		for(Member member : memberList) {
			System.out.println(member);
		}
	}
	
	// 목록 조회 테스트 -4
	@Test
	public void testList03() {
		List<Member> memberList = memberRepository.getList03("user7", "password7");
		
		for(Member member : memberList) {
			System.out.println(member);
		}
	}
	
	// 목록 조회 테스트 -5
	@Test
	public void testList04() {
		List<Member> memberList = memberRepository.getList04("순신");
		
		for(Member member : memberList) {
			System.out.println(member);
		}
	}
	
	// 목록 조회 테스트 -6
	@Test
	public void testList05() {
		Collection<Member> memberList = memberRepository.getList05();
		
		for(Member member : memberList) {
			System.out.println(member);
		}
	}
	
	// 목록 조회 테스트 -7
	@Test
	public void testList06() {
		Pageable pageRequest = PageRequest.of(0, 10, Sort.Direction.DESC, "userNo");
		
		Page<Member> page = memberRepository.getList06(pageRequest);
		
		int totalPages = page.getTotalPages();
		System.out.println(page);
		System.out.println("totalPages: " + totalPages);
	
		Pageable pageable = page.getPageable();
		
		int pageNumber = pageable.getPageNumber();
		int pageSize = pageable.getPageSize();
		
		System.out.println(pageable);
		System.out.println("pageNumber: " + pageNumber);
		System.out.println("pageSize: " + pageSize);
		
		List<Member> memberList = page.getContent();
		
		for(Member member : memberList) {
			System.out.println(member);
		}
	}
	
	// 목록 조회 테스트 -8
	@Test
	public void testList07() {
		Collection<Member> memberList = memberRepository.getList07();
		
		for(Member member : memberList) {
			System.out.println(member);
		}
	}
	
	// 목록 조회 테스트 -9
	@Test
	public void testList08() {
		Pageable pageRequest = PageRequest.of(0, 10, Sort.Direction.DESC, "userNo");
		
		List<Member> memberList = memberRepository.getList08(pageRequest);
		for(Member member : memberList) {
			System.out.println(member);
		}
	}
	
	// 상세 조회 테스트
	@Test
	public void testRead() {
		Optional<Member> memberOptional = memberRepository.findById(1L);
		if(memberOptional.isPresent()) {
			Member member = memberOptional.get();
		
			System.out.println(member);
		}
	}
	
	// 수정 테스트 -1
	@Test
	public void testModify01() {
		Optional<Member> memberOptional = memberRepository.findById(1L);
		if(memberOptional.isPresent()) {
			Member member = memberOptional.get();
			member.setUserName("강감찬");
			
			memberRepository.save(member);
		}
	}
	
	// 수정 테스트 -2
	@Transactional
	@Test
	public void testModify02() {
		String userId = "user1";
		String newUserName = "강감찬";
		int count = memberRepository.updateMemberNameById(userId, newUserName);
		
		System.out.println("count= " + count);
	}
	
	// 삭제 테스트 -1
	@Test
	public void testRemove01() {
		memberRepository.deleteById(1L);
	}
	
	// 등록 테스트
	@Test
	public void testRegister() {
		for(int i=0; i<10; i++) {
			long userNo = i+1;
			Member member = new Member();
			member.setUserId("user" + userNo);
			member.setUserPw("password" + userNo);
			member.setUserName("제우스" + userNo);
			memberRepository.save(member);
		}
	}
	
	// 목록 조회 테스트 -1
	@Test
	public void testListAll() {
		Iterable<Member> memberList = memberRepository.findAll();
		
		for(Member member : memberList) {
			System.out.println(member);
		}
	}
	
	// 목록 조회 테스트 -2
	@Test
	public void testList01() {
		BooleanBuilder builder = new BooleanBuilder();
		QMember member = QMember.member;
		
		builder.and(member.userId.eq("user7"));

		Iterable<Member> memberList = memberRepository.findAll(builder);
		
		for(Member m : memberList) {
			System.out.println(m);
		}
	}
	
	// 목록 조회 테스트 -3
	@Test
	public void testList02() {
		BooleanBuilder builder = new BooleanBuilder();
		QMember member = QMember.member;
		
		builder.and(member.userPw.eq("password8"));
		
		Iterable<Member> memberList = memberRepository.findAll(builder);
		for(Member m : memberList) {
			System.out.println(m);
		}
	}
	
	// 목록 조회 테스트 -4
	@Test
	public void testList03() {
		BooleanBuilder builder = new BooleanBuilder();
		QMember member = QMember.member;
		
		builder.and(member.userId.eq("user5"));
		builder.and(member.userPw.eq("password5"));
		
		Iterable<Member> memberList = memberRepository.findAll(builder);
		for(Member m : memberList) {
			System.out.println(m);
		}
	}
	
	// 목록 조회 테스트 -5
	@Test
	public void testList04() {
		BooleanBuilder builder = new BooleanBuilder();
		QMember member = QMember.member;
		
		builder.and(member.userName.like("%우스9%"));
		
		Iterable<Member> memberList = memberRepository.findAll(builder);
		for(Member m : memberList) {
			System.out.println(m);
		}
	}

	// 목록 조회 테스트 -6
	@Test
	public void testList05() {
		BooleanBuilder builder = new BooleanBuilder();
		QMember member = QMember.member;
		
		builder.and(member.userNo.gt(5));
		
		Iterable<Member> memberList = memberRepository.findAll(builder);
		
		for(Member m : memberList) {
			System.out.println(m);
		}
	}
	
	// 목록 조회 테스트 -7
	@Test
	public void testList06() {
		BooleanBuilder builder = new BooleanBuilder();
		QMember member = QMember.member;
		builder.and(member.userNo.gt(0));
		
		Pageable pageable = PageRequest.of(0, 10);
		Page<Member> result = memberRepository.findAll(builder, pageable);
		
		System.out.println("PAGE_SIZE: " + result.getSize());
		System.out.println("TOTAL PAGES: " + result.getTotalPages());
		System.out.println("TOTAL COUNT: " + result.getTotalElements());
		System.out.println("NEXT: " + result.nextPageable());
		
		List<Member> memberList = result.getContent();
		for(Member m : memberList) {
			System.out.println(m);
		}
	}
	
	// 목록 조회 테스트 -8
	@Test	
	public void testList07() {
		BooleanBuilder builder = new BooleanBuilder();
		QMember member = QMember.member;
		builder.and(member.userNo.gt(0));
		
		Iterable<Member> memberList = memberRepository.findAll(builder, Sort.by(Direction.DESC, "userNo"));
		
		for(Member m : memberList) {
			System.out.println(m);
		}
	}	
	
	// 목록 조회 테스트 -9
	@Test
	public void testList08() {
		BooleanBuilder builder = new BooleanBuilder();
		QMember member = QMember.member;
		builder.and(member.userNo.gt(0));
		
		Pageable pageable = PageRequest.of(0, 10, Direction.DESC, "userNo");
		Page<Member> result = memberRepository.findAll(builder, pageable);
		
		System.out.println("PAGE SIZE: " + result.getSize());
		System.out.println("TOTAL PAGES: " + result.getTotalPages());
		System.out.println("TOTAL COUNT: " + result.getTotalElements());
		System.out.println("NEXT: " + result.nextPageable());
		
		List<Member> memberList = result.getContent();
		for(Member m : memberList) {
			System.out.println(m);
		}
	}
	
	// 상세 조회 테스트
	@Test
	public void testRead() {
		Optional<Member> memberOptional = memberRepository.findById(3L);
		if(memberOptional.isPresent()) {
			Member member = memberOptional.get();
			System.out.println(member);
		}
	}
	
	// 수정 테스트
	@Test
	public void testModify() {
		Optional<Member> memberOptional = memberRepository.findById(2L);
		if(memberOptional.isPresent()) {
			Member member = memberOptional.get();
			member.setUserName("포세이돈");
			memberRepository.save(member);
		}
	}
	
	// 삭제 테스트
	@Test
	public void testRemove() {
		memberRepository.deleteById(2L);
	}
	
	// 등록 테스트
	@Test
	public void testRegister() {
		for(int i=0; i<10; i++) {
			long userNo = i+1;
			Member member = new Member();
			member.setUserId("user" + userNo);
			member.setUserPw("password" + userNo);
			member.setUserName("스프링" + userNo);
		
			memberRepository.save(member);
		}
	}*/
	
	// 사용자 정의 인터페이스 메소드 테스트
	@Test
	public void testGetSearchPage() {
		BooleanBuilder builder = new BooleanBuilder();
		
		QMember board = QMember.member;
		
		builder.and(board.userNo.gt(0));
		
		Pageable pageable = PageRequest.of(0, 10, Direction.DESC, "userNo");
		
		Page<Object[]> result = memberRepository.getSearchPage("name", "스프링", pageable);
	
		System.out.println("PAGE SIZE: " + result.getSize());
		System.out.println("TOTAL PAGES: " + result.getTotalPages());
		System.out.println("TOTAL COUNT: " + result.getTotalElements());
		System.out.println("NEXT: " + result.nextPageable());

		List<Object[]> list = result.getContent();
		
		for(Object[] b : list) {
			System.out.println(b[0]);
			System.out.println(b[1]);
			System.out.println(b[2]);
			System.out.println(b[3]);
			System.out.println(b[4]);
		}
	}
}