package employee.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import employee.info.Employee;
import employee.service.EmployeeService;

// TODO: Auto-generated Javadoc
/**
 * The Class ListEmpController.
 */
@Controller
public class ListEmpController {
	
	/** The employee service. */
	private EmployeeService employeeService;
	
	/**
	 * Sets the employee service.
	 *
	 * @param employeeService the new employee service
	 */
	@Autowired
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	/**
	 * List employees.
	 *
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "listemployee", method = RequestMethod.GET)
	public String listEmployees(ModelMap model) {
		ArrayList<Employee> list = (ArrayList<Employee>) employeeService.getAllEmployees();
		model.addAttribute("employees", list);
		return "listemployees";
	}
	
}
