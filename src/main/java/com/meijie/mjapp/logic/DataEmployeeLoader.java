package com.meijie.mjapp.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.meijie.mjapp.jpa.entity.Employee;
import com.meijie.mjapp.jpa.repository.EmployeeRepository;

@Component
public class DataEmployeeLoader implements CommandLineRunner {
	private final EmployeeRepository reposity;
	
	@Autowired
	public DataEmployeeLoader(EmployeeRepository repository) {
		this.reposity = repository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		this.reposity.deleteAll();
		this.reposity.save(new Employee("Frodo", "Baggins", "ring bearer"));
	}
}
