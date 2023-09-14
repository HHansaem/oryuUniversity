package kr.or.ddit.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Advice4XML {
	private static final Logger LOGGER = LoggerFactory.getLogger(Advice4XML.class);
	
	//타겟 메서드 실행전 수행
	public void beforeMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		String className = joinPoint.getTarget().getClass().getName();
		
		LOGGER.info("beforMethod 실행 "+className + "."+methodName);
	}
	
	//정상적으로 동작이 된 경우 실행됨
	public void afterReturningMethod(JoinPoint joinPoint, Object retVal){
		String methodName = joinPoint.getSignature().getName();
		String className = joinPoint.getTarget().getClass().getName();
		Object[] args= joinPoint.getArgs();
		for(Object arg:args){
			LOGGER.info("arg: "+arg);
		}
		LOGGER.info("afterReturningMethod 실행 "+className + "."+methodName
				+", return value="+retVal);
	}
	
	//실행전 처리, 타겟 메서드 직접호출, 예외처리 가능
	public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable{
		String methodName = joinPoint.getSignature().getName();
		String className = joinPoint.getTarget().getClass().getName();
		
		LOGGER.info(className + "."+methodName+"  start !!");
		Object[] args= joinPoint.getArgs();
		for(Object arg:args){
			LOGGER.info("arg: "+arg);
		}
		
		long startTime = System.currentTimeMillis();
		//이부분이 핵심로직이 실행되는 것을 대체 하는 라인
		Object retVal = joinPoint.proceed();
		long endTime = System.currentTimeMillis();
		
		LOGGER.info(className + "."+methodName+"  end !!"
				+", return value="+retVal + " ,lead time = "+(endTime-startTime) +"ms");
		
		return retVal;
	}
	
	
	//예외가 발생하고, 종료하는 경우 수행됨
	public void afterThrowingMethod(JoinPoint joinPoint, Exception ex) throws Throwable{
		String methodName = joinPoint.getSignature().getName();
		String className = joinPoint.getTarget().getClass().getName();
		
		System.err.println(className + "."+methodName+"  exception: "+ex.getMessage());
	}
}










