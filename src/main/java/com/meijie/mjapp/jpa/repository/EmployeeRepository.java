package com.meijie.mjapp.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.meijie.mjapp.jpa.entity.Employee;

//public interface EmployeeRepository extends CrudRepository<Employee, Long> {
//
//}

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

}
