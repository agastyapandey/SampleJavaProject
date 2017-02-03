/*
 * 
 */
package employee.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import employee.info.Employee;
import employee.info.EmployeeProjectRole;
import employee.info.Project;
import employee.info.ProjectRole;
import employee.info.Role;
import employee.service.EmployeeProjectRoleService;
import employee.service.EmployeeService;
import employee.service.ProjectRoleService;
import employee.service.ProjectService;
import employee.service.RoleService;
import employee.service.ValidationService;

@Controller
public class AssignProjectcontroller {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private ProjectService projectService;

	@Autowired
	ProjectRoleService projectRoleService;

	@Autowired
	EmployeeProjectRoleService employeeProjectRoleService;
	
	@Autowired
	ValidationService validationService;
	
    /**
     * This is controller method for assigning project to employee.
     *
     * @param eid the eid
     * @param ePRID the e prid
     * @param errorMsg the error msg
     * @param model the model
     * @return String view
     */
	@RequestMapping(value = "assignprojecttoemp", method = RequestMethod.GET)
	public String assignProjectToEmp(@RequestParam(value = "eid") int eid,
			@RequestParam(value = "ePRID", required = false) String ePRID,
			@RequestParam(value = "errorMsg", required = false) String errorMsg,
			ModelMap model) {
		
		model.addAttribute("errorMsg", errorMsg);
		
		if (ePRID != null) {
			int id = Integer.parseInt(ePRID);
			EmployeeProjectRole ePR = employeeProjectRoleService
					.getEmployeePojectRoleById(id);
			model.addAttribute("ePR", ePR);
		}

		Employee employee = employeeService.getEmployeeById(eid);
		List<Role> roleList = null;
		List<Project> projectList = null;
		roleList = (ArrayList<Role>) roleService.getAllRoles();
		projectList = (ArrayList<Project>) projectService.getAllProjects();

		model.addAttribute("employee", employee);
		model.addAttribute("roles", roleList);
		model.addAttribute("projects", projectList);

		return "assignprojecttoemp";
	}

	/**
	 * Adds the emp to project.
	 *
	 * @param pid the pid
	 * @param ePRID the e prid
	 * @param errorMsg the error msg
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "addemptoproject", method = RequestMethod.GET)
	public String addEmpToProject(@RequestParam("pid") int pid,
			@RequestParam(value = "ePRID", required = false) String ePRID,
			@RequestParam(value = "errorMsg", required = false) String errorMsg,
			ModelMap model) {
		
		model.addAttribute("errorMsg", errorMsg);

		if (ePRID != null) {
			int id = Integer.parseInt(ePRID);
			EmployeeProjectRole ePR = employeeProjectRoleService
					.getEmployeePojectRoleById(id);
			model.addAttribute("ePR", ePR);
		}

		Project project = projectService.getProjectById(pid);
		List<Role> roleList = null;
		List<Employee> employeeList = null;
		roleList = (ArrayList<Role>) roleService.getAllRoles();
		employeeList = (ArrayList<Employee>) employeeService.getAllEmployees();

		model.addAttribute("project", project);
		model.addAttribute("roles", roleList);
		model.addAttribute("employees", employeeList);

		return "addemptoproject";
	}

	/**
	 * This is Controller method to save assign project.
	 *
	 * @param eid the eid
	 * @param rid the rid
	 * @param pid the pid
	 * @param assignDate the assign date
	 * @param releaseDate the release date
	 * @param pagename the pagename
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "confirmassignproject", method = RequestMethod.POST)
	public String saveAssignProject(
			@RequestParam(value = "eid", required = false) int eid,
			@RequestParam(value = "rid", required = false) int rid,
			@RequestParam(value = "pid", required = false) int pid,
			@RequestParam(value = "assignDate", required = false) Date assignDate,
			@RequestParam(value = "releaseDate", required = false) Date releaseDate,
			@RequestParam(value = "pagename", required = false) String pagename,
			ModelMap model) {
		
		if(validationService.checkDuplicateProjectAssignment(eid, pid, rid)){
			
			String errorMsg="Assignment already exist.";
			model.addAttribute("errorMsg", errorMsg);
			
			if (pagename.equals("assignprojecttoemp")) {
				
				return "redirect:assignprojecttoemp?eid="+eid;
				
			} else {
				
				return "redirect:addemptoproject?pid="+pid;
				
			}
		}

		Employee employee = employeeService.getEmployeeById(eid);
		Role role = roleService.getRoleById(rid);
		Project project = projectService.getProjectById(pid);

		ProjectRole projectRole = new ProjectRole();
		EmployeeProjectRole employeeProjectRole = new EmployeeProjectRole();

		projectRole.setProject(project);
		projectRole.setRole(role);

		ProjectRole projectRole1 = projectRoleService
				.updateProjectRole(projectRole);

		employeeProjectRole.setProjectRole(projectRole1);
		employeeProjectRole.setEmployee(employee);

		employeeProjectRole.setAssignDate(assignDate);
		employeeProjectRole.setReleaseDate(releaseDate);
		employeeProjectRoleService
				.updateEmployeeProjectRole(employeeProjectRole);

		if (pagename.equals("assignprojecttoemp")) {
			return "redirect:view?eid=" + eid;
		} else {
			return "redirect:viewempofproject?pid=" + pid;
		}
	}

}
