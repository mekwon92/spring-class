package com.me92100984.member_post.filter;

import java.io.IOException;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.log4j.Log4j2;

@WebFilter({"/*"})
@Component
@Order(1)
@Log4j2
public class CharsetFilter implements Filter{

	//서비스 하기 전 한번 수행(없어도됨?)
	// @Override
	// public void init(FilterConfig filterConfig) throws ServletException {
	// 	Filter.super.init(filterConfig);
	// }
	
	//서비스 http보다 조상....? 전처리로 동작
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		// 실제 처리
		//log.info("filter적용됨");
		chain.doFilter(request, response);
	}
}
