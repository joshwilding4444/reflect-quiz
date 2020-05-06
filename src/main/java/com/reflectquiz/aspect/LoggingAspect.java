package com.reflectquiz.aspect;

//import org.apache.logging.log4j.Logger;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//import org.apache.logging.log4j.LogManager;

//@Aspect
//@Component
//public class LoggingAspect {
//	public Logger aspectLogger = LogManager.getLogger(LoggingAspect.class);
//	
//	@Pointcut("execution(public * *(..))")
//	public void allPublicLog() {
//		
//	}
//	
////	@Pointcut("within(com.reflectquiz.repository..*)")
////	public void allDAOLog() {}
//	
//	@Before("allPublicLog()")
//	public void beforeAllPublicLog(JoinPoint jp) {
//		aspectLogger.debug("Signature: " + jp.getSignature().getName() + "\n");
//	}
//}
