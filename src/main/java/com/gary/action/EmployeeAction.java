package com.gary.action;

import com.gary.entity.Employee;
import com.gary.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 员工管理的Action类
 * @author genle
 *
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{
	//模型驱动使用的对象
	private Employee employee = new Employee();

	/**
	 * 用于接收传递的参数
	 */
	@Override
	public Employee getModel() {
		return employee;
	}
	
	//注入业务层的类
	private EmployeeService employeeService;
	
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}


	/**
	 * 登录执行的方法
	 * @return
	 */
	public String login(){
		//调用业务层的类：
		Employee existEmployee = employeeService.login(employee);
		if(existEmployee == null){
			//登录失败
			this.addActionError("用户名或密码错误！");
			return INPUT;
		}else{
			//登录成功
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			return SUCCESS;
		}
	}
}
