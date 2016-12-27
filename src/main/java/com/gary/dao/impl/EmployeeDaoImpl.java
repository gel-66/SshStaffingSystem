package com.gary.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.gary.dao.EmployeeDao;
import com.gary.entity.Employee;
/*
 * 员工管理的Dao的实现类
 */
public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {

	/**
	 * Dao中根据用户和密码查询用户的方法
	 */
	@Override
	public Employee findByUsernameAndPassword(Employee employee) {
		String hql = "from Employee where username = ? and password = ?";
		List<Employee> list = (List<Employee>) this.getHibernateTemplate().find(hql, employee.getUsername(), employee.getPassword());
		if(list.size() > 0){
			return list.get(0);
		}
		return null;
	}
	
}
