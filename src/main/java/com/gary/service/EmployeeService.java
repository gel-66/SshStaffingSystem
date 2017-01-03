package com.gary.service;

import com.gary.entity.Employee;
import com.gary.entity.PageBean;

/**
 * 员工管理的业务层的接口
 * @author genle
 *
 */
public interface EmployeeService {

	Employee login(Employee employee);

	PageBean<Employee> findByPage(Integer currPage);

	void save(Employee employee);

	Employee findById(Integer eid);

	void update(Employee employee);

	void delete(Employee employee);
}
