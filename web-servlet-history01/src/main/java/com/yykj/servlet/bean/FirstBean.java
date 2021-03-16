package com.yykj.servlet.bean;

import java.util.HashMap;

import org.apache.commons.beanutils.BeanUtils;

public class FirstBean {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		createBean2();
	}
	
	
	public static void createBean() throws Exception {
		Class clazz = Class.forName("com.yykj.web.bean.Person");
		Object bean = clazz.getDeclaredConstructor().newInstance();
		
		BeanUtils.setProperty(bean, "name", "kelvin");
		BeanUtils.setProperty(bean, "age", 20);
		BeanUtils.setProperty(bean, "gender", "男");
		
		System.out.println(bean);
	}
	
	public static void createBean2() throws Exception {
		HashMap<String, Object> map = new HashMap<>();
		map.put("name", "kelvin");
		map.put("age", 30);
		map.put("gender", "男" );
		
		Person person = new Person();
		BeanUtils.populate(person,map);
		
		System.out.println(person);
	}
}
