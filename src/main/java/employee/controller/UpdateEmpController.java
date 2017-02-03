package employee.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import employee.info.Employee;
import employee.service.EmployeeService;

// TODO: Auto-generated Javadoc
/**
 * The Class UpdateEmpController.
 */
@Controller
public class UpdateEmpController {
	
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
	 * Adds the edit employee.
	 *
	 * @param id the id
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "insert_or_update", method = RequestMethod.GET)
	public String addEditEmployee(@RequestParam(value = "id", required = false) String id, ModelMap model) {
		Employee emp = null;
		if (id != null){
			int eid=Integer.parseInt(id);
			emp = employeeService.getEmployeeById(eid);
		}
		model.addAttribute("emp", emp);
		return "saveemployee";
	}
	
	/**
	 * Save employee.
	 *
	 * @param employee the employee
	 * @param result the result
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "save_or_update", method = RequestMethod.POST)
	public String saveEmployee(@Valid @ModelAttribute("employee1") Employee employee, BindingResult result, ModelMap model){
		if(result.hasErrors()){
			return "saveemployee";
		}else{
		employeeService.updateEmployee(employee);
		return "redirect:listemployee";
		}
	}

}
