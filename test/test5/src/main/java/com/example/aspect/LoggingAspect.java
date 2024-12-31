package com.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class LoggingAspect {

    @Before("execution(* com.example.service.OrderService.placeOrder(..))")
    public void beforeAdvice() {
        System.out.println("Before method execution.");
    }

    @AfterReturning(pointcut = "execution(* com.example.service.OrderService.placeOrder(..))", returning = "retVal")
    public void afterReturningAdvice(Object retVal) {
        System.out.println("After returning: " + retVal);
    }

    @AfterThrowing(pointcut = "execution(* com.example.service.OrderService.placeOrder(..))", throwing = "ex")
    public void afterThrowingAdvice(Exception ex) {
        System.out.println("After throwing: " + ex);
    }

    @After("execution(* com.example.service.OrderService.placeOrder(..))")
    public void afterAdvice() {
        System.out.println("After method execution.");
    }

    @Around("execution(* com.example.service.OrderService.placeOrder(..))")
    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Around before");
        Object retVal = pjp.proceed();
        System.out.println("Around after");
        return retVal;
    }
}

