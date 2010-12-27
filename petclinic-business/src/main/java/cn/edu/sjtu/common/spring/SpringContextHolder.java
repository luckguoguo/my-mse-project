package cn.edu.sjtu.common.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContextHolder implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext applicationContext) {
		SpringContextHolder.applicationContext = applicationContext;
	}

	public static ApplicationContext getApplicationContext() {
		checkApplicationContext();
		return applicationContext;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
		checkApplicationContext();
		return (T) applicationContext.getBean(name);
	}

	@SuppressWarnings("unchecked")
	public static <T> T getBean(Class<T> clazz) {
		checkApplicationContext();
		return (T) applicationContext.getBeansOfType(clazz);
	}

	private static void checkApplicationContext() {
		if (applicationContext == null)
			throw new IllegalStateException("Please add SpringContextUtil bean to applicationContext.xml");
	}
}
