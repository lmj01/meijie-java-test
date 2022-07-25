package com.meijie.mjapp.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.meijie.mjapp.jpa.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
