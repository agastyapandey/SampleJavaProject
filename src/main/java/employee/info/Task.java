package employee.info;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

// TODO: Auto-generated Javadoc
/**
 * The Class Task.
 */
@Entity
public class Task {
	
	/** The task id. */
	@Id
	@GeneratedValue
	int taskId;
	
	/** The task name. */
	@Size(min=4,max=45,message="Task name should be min 4 chars.")
	String taskName;
	
	/** The task description. */
	String taskDescription;
	
	/** The task complexity. */
	int taskComplexity;
	
	/** The task priority. */
	int taskPriority;
	
	/** The task status. */
	String taskStatus;
	
	/** The sub task. */
	@OneToMany(mappedBy="task",cascade=CascadeType.ALL)
	Set<SubTask> subTask;
	
	/** The project. */
	@ManyToOne
	@JoinColumn(name="project_id")
	Project project;
	
	/** The employee task. */
	@OneToMany(mappedBy="task", cascade=CascadeType.ALL)
	Set<EmployeeTask> employeeTask;

	/**
	 * Gets the task id.
	 *
	 * @return the task id
	 */
	public int getTaskId() {
		return taskId;
	}

	/**
	 * Sets the task id.
	 *
	 * @param taskId the new task id
	 */
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	/**
	 * Gets the task name.
	 *
	 * @return the task name
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * Sets the task name.
	 *
	 * @param taskName the new task name
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * Gets the task description.
	 *
	 * @return the task description
	 */
	public String getTaskDescription() {
		return taskDescription;
	}

	/**
	 * Sets the task description.
	 *
	 * @param taskDescription the new task description
	 */
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	/**
	 * Gets the task complexity.
	 *
	 * @return the task complexity
	 */
	public int getTaskComplexity() {
		return taskComplexity;
	}

	/**
	 * Sets the task complexity.
	 *
	 * @param taskComplexity the new task complexity
	 */
	public void setTaskComplexity(int taskComplexity) {
		this.taskComplexity = taskComplexity;
	}

	/**
	 * Gets the task priority.
	 *
	 * @return the task priority
	 */
	public int getTaskPriority() {
		return taskPriority;
	}

	/**
	 * Sets the task priority.
	 *
	 * @param taskPriority the new task priority
	 */
	public void setTaskPriority(int taskPriority) {
		this.taskPriority = taskPriority;
	}

	/**
	 * Gets the task status.
	 *
	 * @return the task status
	 */
	public String getTaskStatus() {
		return taskStatus;
	}

	/**
	 * Sets the task status.
	 *
	 * @param taskStatus the new task status
	 */
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	/**
	 * Gets the sub task.
	 *
	 * @return the sub task
	 */
	public Set<SubTask> getSubTask() {
		return subTask;
	}

	/**
	 * Sets the sub task.
	 *
	 * @param subTask the new sub task
	 */
	public void setSubTask(Set<SubTask> subTask) {
		this.subTask = subTask;
	}

	/**
	 * Gets the project.
	 *
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * Sets the project.
	 *
	 * @param project the new project
	 */
	public void setProject(Project project) {
		this.project = project;
	}

	/**
	 * Gets the employee task.
	 *
	 * @return the employee task
	 */
	public Set<EmployeeTask> getEmployeeTask() {
		return employeeTask;
	}

	/**
	 * Sets the employee task.
	 *
	 * @param employeeTask the new employee task
	 */
	public void setEmployeeTask(Set<EmployeeTask> employeeTask) {
		this.employeeTask = employeeTask;
	}

}
