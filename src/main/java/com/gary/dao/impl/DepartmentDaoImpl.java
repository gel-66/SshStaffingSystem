package com.gary.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.gary.dao.DepartmentDao;
import com.gary.entity.Department;
/**
 * 部门管理的DAO层的实现类
 * @author genle
 *
 */
public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {

	/**
	 * 统计个数
	 */
	@Override
	public int findCount() {
		String hql = "select count(*) from Department";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
		if(list.size() > 0){
			return list.get(0).intValue();
		}
		return 0;
	}
	
	/**
	 * 分页查询
	 */
	@Override
	public List<Department> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Department.class);
		List<Department> list = (List<Department>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	//Dao中的保存方法
	@Override
	public void save(Department department) {
		this.getHibernateTemplate().save(department);
	}
	
	//Dao根据部门的id查询部门
	@Override
	public Department findById(Integer did) {
		return this.getHibernateTemplate().get(Department.class, did);
	}

	//DAO中修改部门的方法
	@Override
	public void update(Department department) {
		this.getHibernateTemplate().update(department);
	}

	//DAO中删除部门的方法
	@Override
	public void delete(Department department) {
		this.getHibernateTemplate().delete(department);
	}
	
	
}
