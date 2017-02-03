package employee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import employee.info.Employee;

// TODO: Auto-generated Javadoc
/**
 * The Class EmployeeService.
 */
public class EmployeeService {
	
	/** The template. */
	@Autowired
	private HibernateTemplate template;

	/**
	 * Gets the all employees.
	 *
	 * @return the all employees
	 */
	public List<Employee> getAllEmployees() {
		List<Employee> list = new ArrayList<Employee>();
		list = template.loadAll(Employee.class);
		return list;
	}

	/**
	 * Gets the employee by id.
	 *
	 * @param id the id
	 * @return the employee by id
	 */
	public Employee getEmployeeById(int id) {
		Employee employee;
		employee = template.get(Employee.class, id);
		return employee;
	}
	
	/**
	 * Delete employee.
	 *
	 * @param id the id
	 */
	@Transactional(readOnly = false)
	public void deleteEmployee(int id){
		Employee employee;
		employee=template.get(Employee.class,id);
		template.delete(employee);
	}
	
	/**
	 * Update employee.
	 *
	 * @param employee the employee
	 */
	@Transactional(readOnly = false)
	public void updateEmployee(Employee employee) {
		template.saveOrUpdate(employee);

	}
	
}
