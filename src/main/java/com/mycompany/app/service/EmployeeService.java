package com.mycompany.app.service;

import java.util.List;

import com.mycompany.app.entity.Employee;

public interface EmployeeService {

	void saveEmployee(Employee employee);

	List<Employee> getAllEmployees();

}
