package com.me92100984.aop.ex02.adv;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.lang.Nullable;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Seasoning implements MethodBeforeAdvice { // Before - 메서드가 호출되기 전에 실행(메서드 실행 자체를 막을 수는 없음)

    @Override
    public void before(Method method, Object[] args, @Nullable Object target) throws Throwable {
        log.info("염지를 한다.");      
    }
    
}
