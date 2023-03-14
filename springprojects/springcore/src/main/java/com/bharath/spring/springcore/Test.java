package com.bharath.spring.springcore;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

public class Test {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		Employee emp = (Employee) ctx.getBean("emp");
		System.out.println("Employee ID: " + emp.hashCode());
		System.out.println("Employee Name: " + emp.getName());
		ctx.registerShutdownHook();
		System.out.println("Employee  " + emp);

		ctx.registerShutdownHook();
/*		JdbcTemplate template =(JdbcTemplate) ctx.getBean("jdbcTemplate");
		String sql = "select * from JIQUERY";
		List<QueryObject> objectList=template.query(sql, new QueryRowMapper());
		System.out.println("List"+objectList.size());*/

		HibernateTemplate template=(HibernateTemplate) ctx.getBean("hibernateTemplate");
		QueryObject obje=template.get(QueryObject.class,1449);
		System.out.println(obje);




	}

}
