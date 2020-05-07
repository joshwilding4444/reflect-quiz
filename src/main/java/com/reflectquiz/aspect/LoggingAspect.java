package com.reflectquiz.aspect;

import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.apache.logging.log4j.LogManager;

@Component(value = "loggingAspect")
@EnableAspectJAutoProxy
@Aspect
public class LoggingAspect {
	public static final Logger LOG = LogManager.getLogger(LoggingAspect.class);
	
	@Pointcut("within(com.reflectquiz.repository.*)")
	public void allRepositoryPointcut() {}
	@Pointcut("within(com.reflectquiz.service.*)")
	public void allServicesPointcut() {}
	
	/*@Before("allRepositoryPointcut()")
	public void logBeforeRepository(JoinPoint jp) {
		LOG.info("The " + jp.getSignature().getName() + " method is going to be invoked!");
	}*/
	@Before("allServicesPointcut()")
	public void logBeforeServices(JoinPoint jp) {
		LOG.info("The " + jp.getSignature().getName() + " method is going to be invoked!");
	}
}
