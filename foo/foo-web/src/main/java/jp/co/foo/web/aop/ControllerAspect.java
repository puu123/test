package jp.co.foo.web.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerAspect {
	
	/* logger */
	private static final Logger log = LoggerFactory.getLogger(ControllerAspect.class);
		
//	@Around("execution(public * *.home(..))")
//	public Object invoke(ProceedingJoinPoint pjp) throws Throwable {
//		System.out.println("********************** ああああああああああああああああああ");
//		return pjp.proceed();
//	}
//	
//	@Around("execution(public * jp.co.foo.datamapper.Zip2Mapper.*(..))")
//	public Object invoke2(ProceedingJoinPoint pjp) throws Throwable {
//		System.out.println("********************** いいいいいいいいいいいいいいいいいい");
//		return pjp.proceed();
//	}
}
