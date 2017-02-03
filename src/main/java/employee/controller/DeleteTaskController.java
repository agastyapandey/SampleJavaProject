package employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import employee.info.EmployeeTask;
import employee.service.EmployeeTaskService;
import employee.service.TaskService;

// TODO: Auto-generated Javadoc
/**
 * The Class DeleteTaskController.
 */
@Controller
public class DeleteTaskController {

	/** The employee task service. */
	@Autowired
	EmployeeTaskService employeeTaskService;
	
	/** The task service. */
	@Autowired
	TaskService taskService;
	
	/**
	 * Un assign task.
	 *
	 * @param eTId the e t id
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "unassigntask", method = RequestMethod.GET)
	public String unAssignTask(@RequestParam(value = "eTId") int eTId,
			ModelMap model) {
		EmployeeTask employeeTask=employeeTaskService.getEmployeeTaskById(eTId);
		employeeTaskService.deleteEmployeeTask(eTId);
		return "redirect: viewemptaskonproject?eid="+employeeTask.getEmployee().getEmp_id()+"&pid="+employeeTask.getTask().getProject().getProject_id();
			
	}
	
	/**
	 * Delete sub task.
	 *
	 * @param task_id the task_id
	 * @param subTaskId the sub task id
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "deletesubtask", method = RequestMethod.GET)
	public String deleteSubTask(@RequestParam(value = "task_id") int task_id,
			@RequestParam(value = "subTaskId") int subTaskId,
			ModelMap model) {
		
		taskService.deleteSubTask(subTaskId);
		
		return "redirect: taskdetail?task_id="+task_id;
			
	}
	
}
