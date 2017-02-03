package employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import employee.info.Employee;
import employee.service.EmployeeService;

// TODO: Auto-generated Javadoc
/**
 * The Class DeleteEmpController.
 */
@Controller
public class DeleteEmpController {
	
	/** The employee service. */
	@Autowired
	private EmployeeService employeeService;
	
	/**
	 * Delete employee.
	 *
	 * @param id the id
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteEmployee(@RequestParam("id") int id, ModelMap model) {
		Employee emp = new Employee();
		emp = employeeService.getEmployeeById(id);
		model.addAttribute("emp", emp);
		return "deleteemployee";
	}

	/**
	 * Delete confirm.
	 *
	 * @param id the id
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "deleteconfirm", method = RequestMethod.GET)
	public String deleteConfirm(
			@RequestParam(value = "id", required = false) int id, ModelMap model) {		
		employeeService.deleteEmployee(id);		
		return "redirect:listemployee";
	}

}
