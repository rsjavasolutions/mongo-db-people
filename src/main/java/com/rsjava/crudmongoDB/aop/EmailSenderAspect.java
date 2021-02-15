package com.rsjava.crudmongoDB.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class EmailSenderAspect {

    @After("@annotation(sender)")
    public void after(JoinPoint joinPoint, EmailSender sender){
        log.info("Send email form class: {}, method: {}", joinPoint.getSignature().getDeclaringType().getName(), joinPoint.getSignature().getName());
    }
}
