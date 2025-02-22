package com.me92100984.member_post.service;

import java.util.List;

import com.me92100984.member_post.vo.Member;
	//CRUD(단일조회, 목록조회는 필수)

public interface MemberService {
	// 회원 가입
	int register(Member member);
	
	// 단일 조회
	Member findBy(String id);
	
	// 로그인
	boolean login(String id, String pw);
	
	// 회원 목록
	List<Member> list();
	
	// 회원 탈퇴
	boolean remove(String id);

	// 회원 정보 수정
	boolean modify(Member member);
	
}
