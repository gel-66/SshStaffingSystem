package com.gary.action;

import java.util.List;

import com.gary.entity.Department;
import com.gary.entity.Employee;
import com.gary.entity.PageBean;
import com.gary.service.DepartmentService;
import com.gary.service.EmployeeService;
import com.gary.service.impl.EmployeeServiceImpl;
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
	private DepartmentService departmentService;
	
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
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
	
	private Integer currPage = 1;
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	
	//查询方法
	public String findAll(){
		PageBean<Employee> pageBean = employeeService.findByPage(currPage);
		//将pageBean存入到值栈中
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	//跳转到编辑添加编辑页面
	public String saveUI(){
		//查询所有部门
		List<Department> list = departmentService.findAll();
		//保存到值栈中
		ActionContext.getContext().getValueStack().set("list", list);
		return "saveUI";
	}
	
	//保存添加
	public String save(){
		employeeService.save(employee);
		return "save";
	}
	
	//编辑员工的执行的方法
	public String edit(){
		//根据员工id查询员工
		employee = employeeService.findById(employee.getEid());
		//查询所有的部门
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "editSuccess";
	}
	
	//编辑员工更新员工信息
	public String update(){
		employeeService.update(employee);
		return "updateSuccess";
	}
	
	//删除员工的方法
	public String delete(){
		//根据员工id查询员工
		employee = employeeService.findById(employee.getEid());
		employeeService.delete(employee);
		return "deleteSuccess";
	}
}
