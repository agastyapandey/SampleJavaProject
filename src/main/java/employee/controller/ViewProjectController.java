package employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import employee.info.EmployeeProjectRole;
import employee.info.Project;
import employee.service.EmployeeProjectRoleService;
import employee.service.ProjectService;

// TODO: Auto-generated Javadoc
/**
 * The Class ViewProjectController.
 */
@Controller
public class ViewProjectController {
	
	/** The project service. */
	@Autowired
	private ProjectService projectService;
	
	/** The employee project role service. */
	@Autowired
	EmployeeProjectRoleService employeeProjectRoleService;

	/**
	 * View emp of project.
	 *
	 * @param pid the pid
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "viewempofproject", method = RequestMethod.GET)
	public String viewEmpOfProject(@RequestParam("pid") int pid, ModelMap model) {
		Project project= projectService.getProjectById(pid);
		model.addAttribute("project", project);
		
		List<EmployeeProjectRole> ePR = employeeProjectRoleService.getAllProjectsEmployee(pid);
		model.addAttribute("ePR", ePR);
		return "viewempofproject";
	}
}
