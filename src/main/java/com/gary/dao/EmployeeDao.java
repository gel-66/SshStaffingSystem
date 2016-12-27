package com.gary.dao;

import com.gary.entity.Employee;

public interface EmployeeDao {

	Employee findByUsernameAndPassword(Employee employee);
}
