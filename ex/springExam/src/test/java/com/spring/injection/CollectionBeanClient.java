package com.spring.injection;

import java.util.Properties;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {
	@Test
	public void testEx() {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		CollectionBean bean = (CollectionBean) factory.getBean("collectionBean");
		//List<String> addressList = bean.getAddressList();
		//Set<String> addressList = bean.getAddressList();
		//Map<String , String> addressList = bean.getAddressList();
		Properties addressList = bean.getAddressList();
		addressList = bean.getAddressList();
		System.out.println(addressList.getProperty("홍길동"));
		System.out.println(addressList.getProperty("김철수"));
		factory.close();
	}	
}
