package com.rsjava.crudmongoDB.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
@EnableAspectJAutoProxy
public class LoggingAspect {

    @Pointcut("execution(* com.rsjava..*(..))")
    private void anyPublicMethod() {
    }

    //uruchomi sie przed wywołaniem każdej publicznej metody w pakiecie com.rsjava
    @Before("anyPublicMethod()")
    public void beforeAnyPublicMethod(JoinPoint joinPoint) {
        log.info(" :: before :: class: {}, method: {}", joinPoint.getSignature().getDeclaringType().getName(), joinPoint.getSignature().getName());
    }

    //uruchomi sie po wywołaniu każdej publicznej metody w pakiecie com.rsjava
    @After("anyPublicMethod()")
    public void afterAnyPublicMethod(JoinPoint joinPoint) {
        log.info(" :: after :: class: {}, method: {}", joinPoint.getSignature().getDeclaringType().getName(), joinPoint.getSignature().getName());
    }

    //    //alternatywnie
//    @Before("execution(* com.rsjava..*(..))")
//    public void beforeAnyPublicMethod(JoinPoint joinPoint) {
//        log.info(" :: before :: class: {}, method: {}", joinPoint.getSignature().getDeclaringType().getName(), joinPoint.getSignature().getName());
//    }

    //wszystkie metody w kontrolerze PersonController ze wszystkimi parametrami
    @Around("execution(* com.rsjava.crudmongoDB.person.PersonController.*(..))")
    public Object aroundControllerMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();

        log.info(" :: Time :: " + (System.nanoTime() - start + " ns"));

        return joinPoint.proceed();
    }
}

