package employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import employee.info.EmployeeProjectRole;
import employee.service.EmployeeProjectRoleService;

// TODO: Auto-generated Javadoc
/**
 * The Class RemoveProjectController.
 */
@Controller
public class RemoveProjectController {
	
	/** The employee project role service. */
	@Autowired
	EmployeeProjectRoleService employeeProjectRoleService;
	
	/**
	 * Un assign project.
	 *
	 * @param ePRID the emplyeeProjectRoleId
	 * @param pagename the pagename
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "unassignproject", method = RequestMethod.GET)
	public String unAssignProject(@RequestParam(value = "ePRID", required = false) int ePRID,
			@RequestParam(value = "pagename", required = false) String pagename,
			ModelMap model) {
		
			EmployeeProjectRole ePR = employeeProjectRoleService.getEmployeePojectRoleById(ePRID);
			employeeProjectRoleService.deleteEmpProjectRoleById(ePRID);
			
			if(pagename.equals("view")){
				return "redirect:viewempofproject?pid="+ePR.getProjectRole().getProject().getProject_id();
			}else{
				return "redirect:view?eid="+ePR.getEmployee().getEmp_id();
			}
	}
}
