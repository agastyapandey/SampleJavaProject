package employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import employee.info.SubTask;
import employee.info.Task;

// TODO: Auto-generated Javadoc
/**
 * The Class TaskService.
 */
public class TaskService {
	
	/** The template. */
	@Autowired
	private HibernateTemplate template;
	
	/**
	 * Update task.
	 *
	 * @param task the task
	 */
	@Transactional(readOnly = false)
	public void updateTask(Task task) {
		template.saveOrUpdate(task);
	}
	
	/**
	 * Update sub task.
	 *
	 * @param subTask the sub task
	 */
	@Transactional(readOnly = false)
	public void updateSubTask(SubTask subTask) {
		template.saveOrUpdate(subTask);
	}
	
	/**
	 * Gets the all task by project id.
	 *
	 * @param pid the pid
	 * @return the all task by project id
	 */
	@Transactional(readOnly = false)
	public List<Task> getAllTaskByProjectId(int pid){
		@SuppressWarnings("unchecked")
		List<Task> list = (List<Task>) template.find("from Task t where t.project.project_id="+pid);
		return list;
	}
	
	
	/**
	 * Gets the all sub task by task id.
	 *
	 * @param taskId the task id
	 * @return the all sub task by task id
	 */
	public List<SubTask> getAllSubTaskByTaskId(int taskId){
		@SuppressWarnings("unchecked")
		List<SubTask> list = (List<SubTask>) template.find("from SubTask st where st.task.taskId="+taskId);
		return list;
	}
	
	/**
	 * Gets the task by id.
	 *
	 * @param taskId the task id
	 * @return the task by id
	 */
	public Task getTaskById(int taskId) {
		Task task=template.get(Task.class, taskId);
		return task;
	}

	/**
	 * Gets the sub task by id.
	 *
	 * @param taskId the task id
	 * @return the sub task by id
	 */
	public SubTask getSubTaskById(int taskId) {
		SubTask subTask=template.get(SubTask.class, taskId);
		return subTask;
	}
	
	/**
	 * Delete sub task.
	 *
	 * @param subTaskId the sub task id
	 */
	@Transactional(readOnly = false)
	public void deleteSubTask(int subTaskId) {
		SubTask subTask=template.get(SubTask.class, subTaskId);
		template.delete(subTask);
	}
	
}
