package snippet;

public class Snippet {
	<?xml version="1.0" encoding="UTF-8"?>
	<beans xmlns="http://www.springframework.org/schema/beans"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xmlns:context="http://www.springframework.org/schema/context"
		xmlns:mvc="http://www.springframework.org/schema/mvc"
		xsi:schemaLocation="http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc.xsd http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">
		
		<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
			<property name="prefix" value="/view/"/>
			<property name="suffix" value=".jsp"/>
		</bean>
		
		<bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
			<property name="defaultEncoding" value="utf-8"/>
			<property name="maxUploadSize" value="1000000"/>
		</bean>
		
		<bean id="messageSource"  
	       class="org.springframework.context.support.ReloadableResourceBundleMessageSource">  
		    <property name="basename" value="classpath:messages"/>  
		    <property name="fileEncodings" value="utf-8"/>  
		    <property name="cacheSeconds" value="120"/>  
		</bean>
		
		
		<!-- 
		<bean name="/cms/test" class="com.lashou.oa.cms.web.TestController"></bean>
		<bean name="/cms/databind" class="com.lashou.oa.cms.web.TestPropertyEditorController"/>
		 -->
		
		<bean id="validator" class="org.springframework.validation.beanvalidation.LocalValidatorFactoryBean">  
	        <property name="providerClass" value="org.hibernate.validator.HibernateValidator"/>
			<property name="validationMessageSource" ref="messageSource"/>  
		</bean>   	
		
		<context:component-scan base-
}

