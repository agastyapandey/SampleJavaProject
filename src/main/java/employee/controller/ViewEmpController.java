package employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import employee.info.Employee;
import employee.info.EmployeeProjectRole;
import employee.service.EmployeeProjectRoleService;
import employee.service.EmployeeService;

// TODO: Auto-generated Javadoc
/**
 * The Class ViewEmpController.
 */
@Controller
public class ViewEmpController {
	
	/** The employee service. */
	@Autowired
	private EmployeeService employeeService;
	
	/** The employee project role service. */
	@Autowired
	EmployeeProjectRoleService employeeProjectRoleService;

	/**
	 * View employee.
	 *
	 * @param eid the emp_id
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "view", method = RequestMethod.GET)
	public String viewEmployee(@RequestParam("eid") int eid, ModelMap model) {
		Employee emp = new Employee();
		emp = employeeService.getEmployeeById(eid);
		model.addAttribute("emp", emp);
		
		List<EmployeeProjectRole> ePR = employeeProjectRoleService.getAllEmpProjects(eid);
		model.addAttribute("ePR", ePR);
		return "viewemployee";
	}
}
