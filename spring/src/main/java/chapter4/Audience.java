package chapter4;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class Audience {

    @Pointcut("execution(* chapter4.Performence.performance(..))")
    public void performance(){
    }

    @Around("performance()")
    public void watch(ProceedingJoinPoint jp){
        try{
            System.out.println("silence");
            jp.proceed();
            System.out.println("clap");
        }
        catch (Throwable e){
            e.printStackTrace();
        }

    }



//    @Before("performance()")
//    public void silence(){
//        System.out.println("silence");
//    }
//
//    @After("performance()")
//    public void clap(){
//        System.out.println("clap");
//    }
//    @AfterReturning("performance()")
//    public void end(){
//        System.out.println("ending");
//    }
}
