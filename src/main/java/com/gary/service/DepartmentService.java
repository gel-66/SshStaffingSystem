package com.gary.service;

import java.util.List;

import com.gary.entity.Department;
import com.gary.entity.PageBean;

/**
 * 部门管理的接口
 * @author genle
 *
 */
public interface DepartmentService {

	PageBean<Department> findByPage(Integer currPage);

	void save(Department department);

	Department findById(Integer did);

	void update(Department department);

	void delete(Department department);

	List<Department> findAll();

}
