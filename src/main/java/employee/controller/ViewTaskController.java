package employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import employee.info.Employee;
import employee.info.EmployeeTask;
import employee.info.Project;
import employee.info.SubTask;
import employee.info.Task;
import employee.service.EmployeeService;
import employee.service.EmployeeTaskService;
import employee.service.ProjectService;
import employee.service.TaskService;

// TODO: Auto-generated Javadoc
/**
 * The Class ViewTaskController.
 */
@Controller
public class ViewTaskController {
	
	/** The employee service. */
	@Autowired
	EmployeeService employeeService;
	
	/** The project service. */
	@Autowired
	ProjectService projectService;
	
	/** The task service. */
	@Autowired
	TaskService taskService;
	
	/** The employee task service. */
	@Autowired
	EmployeeTaskService employeeTaskService;

	/**
	 * View project task.
	 *
	 * @param pid the pid
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "viewprojecttask", method = RequestMethod.GET)
	public String viewProjectTask(@RequestParam("pid") int pid, ModelMap model) {
		Project project=projectService.getProjectById(pid);
		List<Task> tasks=taskService.getAllTaskByProjectId(pid);
		model.addAttribute("project", project);
		model.addAttribute("tasks", tasks);
		
		return "viewprojecttask";
	}
	
	/**
	 * View task detail.
	 *
	 * @param task_id the task_id
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "taskdetail", method = RequestMethod.GET)
	public String viewTaskDetail(@RequestParam("task_id") int task_id, ModelMap model) {
		Task task=taskService.getTaskById(task_id);
		List<SubTask> subTasks=taskService.getAllSubTaskByTaskId(task_id);
		model.addAttribute("subTasks", subTasks);
		model.addAttribute("task", task);
		return "taskdetail";
	}
	
	/**
	 * View sub task detail.
	 *
	 * @param subTaskId the sub task id
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "subtaskdetail", method = RequestMethod.GET)
	public String viewSubTaskDetail(@RequestParam("subTaskId") int subTaskId, ModelMap model) {
		SubTask subTask=taskService.getSubTaskById(subTaskId);
		model.addAttribute("subTask", subTask);
		return "subtaskdetail";
	}
	
	/**
	 * View emp task on project.
	 *
	 * @param pid the pid
	 * @param eid the eid
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "viewemptaskonproject", method = RequestMethod.GET)
	public String viewEmpTaskOnProject(@RequestParam("pid") int pid,
			@RequestParam("eid") int eid,
			ModelMap model) {
		Employee employee=employeeService.getEmployeeById(eid);
		Project project=projectService.getProjectById(pid);
		
		List<EmployeeTask> empTask=employeeTaskService.getAllEmpTaskOnProject(eid,pid);

		model.addAttribute("employee",employee);
		model.addAttribute("project",project);
		model.addAttribute("empTask",empTask);
		return "viewemptaskonproject";
	}
}
