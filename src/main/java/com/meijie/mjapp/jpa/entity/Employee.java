package com.meijie.mjapp.jpa.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity // @Entity is a JPA annotation that denotes the whole class for storage in a relational table.
public class Employee {
	private @Id @GeneratedValue Long id; // @Id and @GeneratedValue are JPA annotations to note the primary key and that is generated automatically when needed
	private String firstName;
	private String lastName;
	private String description;
	
	@SuppressWarnings("unused")
	private Employee() {}
	
	public Employee(String firstName, String lastName, String description) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.description = description;
	}
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null  || getClass() != o.getClass()) return false;
		Employee oEmployee = (Employee)o;
		return Objects.equals(id, oEmployee.id) &&
				Objects.equals(firstName, oEmployee.firstName) &&
				Objects.equals(lastName, oEmployee.lastName) &&
				Objects.equals(description, oEmployee.description);
	}
	public int hasCode() {
		return Objects.hash(id, firstName, lastName, description);
	}
	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id + 
				", firstName='" + firstName + '\'' + 
				", lastName='" + lastName + '\'' + 
				", description='" + description + '\'' +
				'}';
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
