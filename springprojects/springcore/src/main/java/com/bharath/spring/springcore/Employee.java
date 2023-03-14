package com.bharath.spring.springcore;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("emp")
@Scope("prototype")
public class Employee {

	private int id;
	private String name;

	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", name='" + name + '\'' +
				", wsserver='" + wsserver + '\'' +
				", wsport='" + wsport + '\'' +
				", wsuser='" + wsuser + '\'' +
				'}';
	}


	private String wsserver;

	private String wsport;

	private String wsuser;

	@PostConstruct
	public void init()
	{
		System.out.println("In init method using " + wsserver +wsport + wsuser);
	}


	@PreDestroy
	public void destroy()
	{
		System.out.println("In destroy method");
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
