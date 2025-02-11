package com.pilllaw.pilllaw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pilllaw.pilllaw.entity.member.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
