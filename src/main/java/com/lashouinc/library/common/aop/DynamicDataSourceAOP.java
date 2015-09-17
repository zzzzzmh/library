package com.lashouinc.library.common.aop;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@Component

//@Aspect
public class DynamicDataSourceAOP {
	
	private Logger logger = LoggerFactory.getLogger(DynamicDataSourceAOP.class);

	//@Pointcut("execution(* com.lashouinc.library.service.mappers.*Mapper.*(..))")
	public void inMapper() {
	}
	
	/*
	@Pointcut("execution(* com.lashou.oa.cms.service..*.*(..))")
	public void inService() {
	}
	*/

	/**
	 * 切换数据源,目标对象的方法执行前执行
	 * 
	 * @param jp
	 */
	//@Before("inMapper()")
	public void beforeInvoke(JoinPoint jp) {
		String beanName = jp.getTarget().getClass().getName();
		String methodName = jp.getSignature().getName();
		if (StringUtils.isNotBlank(methodName)) {
			String n = methodName.toLowerCase();
			if (n.startsWith("save") || n.startsWith("update")
					|| n.startsWith("insert") || n.startsWith("del")
					|| n.startsWith("remove")
					|| n.startsWith("selectbyprimarykey")) {
				JdbcContextHolder.setCustomerType(JdbcContextHolder.master);
			} else if ((n.startsWith("find") && !n.startsWith("findbyid"))
					|| n.startsWith("count")
					|| (n.startsWith("select") && !n
							.startsWith("selectbyprimarykey"))) {
				JdbcContextHolder.setCustomerType(JdbcContextHolder.slave);
			} else {
				JdbcContextHolder.clearCustomerType();
			}
		}
		logger.debug("datasource aop 拦截 ，前置通知:class={},method={},ds={} ",beanName, methodName);
	}

	//@After("inMapper()")
	public void afterReturnInvoke() {
		JdbcContextHolder.clearCustomerType();
	}
}
