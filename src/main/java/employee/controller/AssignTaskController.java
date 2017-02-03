package employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import employee.info.Employee;
import employee.info.EmployeeProjectRole;
import employee.info.EmployeeTask;
import employee.info.Project;
import employee.info.Task;
import employee.service.EmployeeProjectRoleService;
import employee.service.EmployeeService;
import employee.service.EmployeeTaskService;
import employee.service.ProjectService;
import employee.service.TaskService;

// TODO: Auto-generated Javadoc
/**
 * The Class AssignTaskController.
 */
@Controller
public class AssignTaskController {
	
	/** The employee service. */
	@Autowired
	private EmployeeService employeeService;
	
	/** The project service. */
	@Autowired
	private ProjectService projectService;
	
	/** The employee project role service. */
	@Autowired
	EmployeeProjectRoleService employeeProjectRoleService;
	
	/** The task service. */
	@Autowired
	private TaskService taskService;
	
	/** The emp task service. */
	@Autowired
	EmployeeTaskService empTaskService;

	/**
	 * Assign task to emp.
	 *
	 * @param eid the eid
	 * @param pid the pid
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "assigntasktoemp", method = RequestMethod.GET)
	public String assignTaskToEmp(@RequestParam("eid") int eid,@RequestParam(value="pid", required=false) String pid, ModelMap model) {
		Employee employee = employeeService.getEmployeeById(eid);
		if(pid.isEmpty()) {
			List<EmployeeProjectRole> ePR = employeeProjectRoleService.getAllEmpProjects(eid);
			model.addAttribute("ePR", ePR);
		} else {
			int p_id = Integer.parseInt(pid);
			Project project= projectService.getProjectById(p_id);
			List<Task> tasks=taskService.getAllTaskByProjectId(p_id);
		
			model.addAttribute("tasks", tasks);
			model.addAttribute("project", project);
		}
		
		model.addAttribute("employee", employee);
		
		return "assigntasktoemp";
	}
	
	/**
	 * Gets the task of project.
	 *
	 * @param pid the pid
	 * @param model the model
	 * @return the task of project
	 */
	@RequestMapping(value = "gettasksofproject", method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody List<Task> getTaskOfProject(@RequestParam(value="pid",required=false) int pid, ModelMap model){
		
		List<Task> tasks=taskService.getAllTaskByProjectId(pid);		
		
		for (Task task : tasks) {
			task.setSubTask(null);
			task.setProject(null);
			task.setEmployeeTask(null);
		}
		
		return tasks;
	}
	
	/**
	 * Save employee task.
	 *
	 * @param eid the eid
	 * @param pid the pid
	 * @param tid the tid
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "saveemptask", method = RequestMethod.POST)
	public String saveEmployeeTask(@RequestParam("eid") int eid,
			@RequestParam("pid") int pid,
			@RequestParam("tid") int tid,
			ModelMap model) {
			Employee employee = employeeService.getEmployeeById(eid);
			Task task= taskService.getTaskById(tid);
			EmployeeTask empTask= new EmployeeTask();
			empTask.setEmployee(employee);
			empTask.setTask(task);
			
			empTaskService.updateEmpTask(empTask);
	
		return "redirect: viewemptaskonproject?eid="+eid+"&pid="+pid;
	}
}
