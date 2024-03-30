package com.springbootrestapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springbootrestapi.model.Employee;
import com.springbootrestapi.repository.EmployeeRepository;

@SpringBootApplication
public class SpringBootRestApi1Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApi1Application.class, args);
	}
	@Autowired
	private EmployeeRepository emprepo;

	@Override
	public void run(String... args) throws Exception {
//		Employee e1=new Employee();
//		e1.setFirstname("Katherine");
//		e1.setLastname("Langford");
//		e1.setEmailId("katherine@gmailcom");
//		emprepo.save(e1);
//		
//		Employee e2=new Employee();
//		e2.setFirstname("Margott");
//		e2.setLastname("Robiee");
//		e2.setEmailId("margott@gmailcom");
//		emprepo.save(e2);
	}

}
