package com.tikora.webSocket.aspect;

import com.tikora.webSocket.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class GlobalAspect {
//    @Pointcut("execution(* com.tikora.webSocket.controller.AuthController.login(..))")
//    public void loggingPointCut(){
//    }
//
//    @Before("loggingPointCut()")
//    public void before(JoinPoint joinPoint){
//       log.info(joinPoint.toString());
//
//    }
//
//
//
//    @After("loggingPointCut()")
//    public void after(JoinPoint joinPoint){
//        log.info(joinPoint.toString());
//    }

    @AfterReturning(value = "execution(* com.tikora.webSocket.controller.AuthController.signup(..))",
    returning = "user")
    public void afterReturned(JoinPoint joinPoint, UserDTO user){
        log.info(user.getEmail());
    }

}
