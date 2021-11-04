package com.spring.product;

public class BeanFactory {
	public Object getBean(String beanName) {
		if(beanName.equals("samsung")) {
			return new SamsungUTV();
		}else if(beanName.equals("lg")) {
			return new LgUTV();
		}
		return null;
	}
}
