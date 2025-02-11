package com.pilllaw.pilllaw.repository.orderEtc;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pilllaw.pilllaw.entity.orderEtc.Point;

import java.util.List;

public interface PointRepository extends JpaRepository<Point, Long> {
  List<Point> findByMemberMno(Long mno);
}