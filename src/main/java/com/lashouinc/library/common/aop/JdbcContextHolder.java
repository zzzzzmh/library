package com.lashouinc.library.common.aop;

import org.springframework.util.Assert;
public class JdbcContextHolder {
	/** 全局数据源 */
	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

	public static final String master = "master";
	public static final String slave = "slave";

	public static void setCustomerType(String customerType) {
		Assert.notNull(customerType, "customer's datasource Type cannot be null");
		contextHolder.set(customerType);
	}

	public static String getCustomerType() {
		return (String) contextHolder.get();
	}

	public static void clearCustomerType() {
		contextHolder.remove();
	}
}

