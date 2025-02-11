package com.pilllaw.pilllaw.repository.orderEtc;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pilllaw.pilllaw.entity.orderEtc.Refund;

import java.util.List;

public interface RefundRepository extends JpaRepository<Refund, Long> {
  // List<Refund> findByOrderOno(Long ono); 
  // List<Refund> findByMemberMno(Long mno); 
}