package employee.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import employee.info.Project;
import employee.info.SubTask;
import employee.info.Task;
import employee.service.EmployeeService;
import employee.service.ProjectService;
import employee.service.TaskService;
import employee.service.ValidationService;

// TODO: Auto-generated Javadoc
/**
 * The Class TaskController.
 */
@Controller
public class TaskController {
	
	/** The employee service. */
	@Autowired
	EmployeeService employeeService;
	
	/** The project service. */
	@Autowired
	ProjectService projectService;
	
	/** The task service. */
	@Autowired
	TaskService taskService;
	
	@Autowired
	ValidationService validationService;
	
	/**
	 * Addtask.
	 *
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "addtask", method = RequestMethod.GET)
	public String addTask(@RequestParam(value = "errorMsg", required = false) String errorMsg,
			ModelMap model) {
		
		model.addAttribute("errorMsg", errorMsg);
		
		List<Project> projects= projectService.getAllProjects();
		model.addAttribute("projects", projects);
		return "addtask";
		}
	
	/**
	 * Adds the task to project.
	 *
	 * @param pid the pid
	 * @param task_id the task_id
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "addtasktoproject", method = RequestMethod.GET)
	public String addTaskToProject(@RequestParam(value="pid",required= false) int pid,
			@RequestParam(value="task_id",required= false) String task_id,
			@RequestParam(value = "errorMsg", required = false) String errorMsg,
			ModelMap model) {
		
		model.addAttribute("errorMsg", errorMsg);
		
		if(task_id!=null){
			int taskId=Integer.parseInt(task_id);
			Task task=taskService.getTaskById(taskId);
			model.addAttribute("task", task);
		}
		Project project= projectService.getProjectById(pid);
		model.addAttribute("project", project);
		return "addtasktoproject";
		}
	
	/**
	 * Save task.
	 *
	 * @param task the task
	 * @param result the result
	 * @param pid the pid
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "savetask", method = RequestMethod.POST)
	public String saveTask(@Valid @ModelAttribute("task1") Task task,
			@RequestParam(value="pagename",required= false) String pagename,
			BindingResult result,
			@RequestParam(value="pid") int pid, ModelMap model) {
		
		if(validationService.checkDuplicateTaskAddition(pid, task.getTaskName())){
			
			String errorMsg="Task already exist.";
			model.addAttribute("errorMsg", errorMsg);
			
			if (pagename.equals("addtask")) {
				
				return "redirect:addtask";
				
			} else {
				
				return "redirect:addtasktoproject?pid="+pid;
				
			}
			
		}
		
		Project project= projectService.getProjectById(pid);
		task.setProject(project);
		taskService.updateTask(task);
		return "redirect: viewprojecttask?pid="+pid;
		}
	
	/**
	 * Adds the sub task.
	 *
	 * @param task_id the task Id
	 * @param subTaskId the sub task Id
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "addsubtask", method = RequestMethod.GET)
	public String addSubTask(@RequestParam(value="task_id") int task_id,@RequestParam(value="subTaskId",required=false) String subTaskId, ModelMap model) {
		if(subTaskId!=null){
			int id=Integer.parseInt(subTaskId);
			SubTask subTask=taskService.getSubTaskById(id);
			model.addAttribute("subTask",subTask);
		}
		
		Task task=taskService.getTaskById(task_id);
		model.addAttribute("task",task);
		return "addsubtask";
		}
	
	/**
	 * Save sub task.
	 *
	 * @param subTask the sub task Id
	 * @param task_id the taskId
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "savesubtask", method = RequestMethod.POST)
	public String saveSubTask(SubTask subTask,@RequestParam(value="task_id") int task_id, ModelMap model) {
		Task task=taskService.getTaskById(task_id);
		subTask.setTask(task);
		taskService.updateSubTask(subTask);
		return "redirect: taskdetail?task_id="+task_id;
		}
	
}
