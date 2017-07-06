package kr.or.kosa.hello.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
	@Pointcut(value="execution(* kr.or..*.sayHello(..))")
	public void helloPointcut(){}
	
	@AfterReturning(returning="message",pointcut="helloPointcut()")
	
	public Object debug(JoinPoint joinPoint, String message){
		System.out.println("[Log:DEBUG] 메소드 이름: "+ joinPoint.getSignature().getName());
		System.out.println("[Log:DEBUG] 메소드 리턴 값 : "+message);
		return message;
		
	}
	
	@Around(value="execution(* kr.or..*.sayHello(..))")
	public Object timeCheck(ProceedingJoinPoint joinPoint){
		Object o = null;
		try{ String methodName=joinPoint.getSignature().getName();
			long start=System.nanoTime();
			o=joinPoint.proceed();
			long end=System.nanoTime();
			System.out.println("[Log: TIMECHECK] 리턴 값 "+o.toString());
			System.out.println("[Log: TIMECHECK] "+methodName+"메소드 실행시간 : "+(end-start));
			
		}catch(Throwable e){
			System.out.println("[Log:TIMECHECK] 예외: "+e.getMessage());
		}return o;
		
		
	}
}
