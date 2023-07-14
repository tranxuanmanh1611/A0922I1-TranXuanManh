package com.my_project.customer_manager.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class Logger {
    @AfterThrowing(value = "execution(public * com.my_project.customer_manager.service.customer.Impl.CustomerServiceImpl.*(..))",throwing = "e")
    public void error(JoinPoint joinPoint, Exception e){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.printf("There is error: %s.%s(%s): %s%n",className,method,args,e.getMessage());
    }

   @After("execution(public * com.my_project.customer_manager.service.customer.Impl.CustomerServiceImpl.save(..))")
    public void afterEditCustomer(){
       System.out.println("Đã thay đổi/thêm mới thông tin một khách hàng");
   }

}
