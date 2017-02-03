package employee.info;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

// TODO: Auto-generated Javadoc
/**
 * The Class SubTask.
 */
@Entity
public class SubTask {
	
	/** The sub task id. */
	@Id
	@GeneratedValue
	int subTaskId;

	/** The task name. */
	String taskName;

	/** The task description. */
	String taskDescription;

	/** The task complexity. */
	int taskComplexity;
	
	/** The task priority. */
	int taskPriority;
	
	/** The task status. */
	String taskStatus;

	/** The task. */
	@ManyToOne
	@JoinColumn(name = "taskId")
	Task task;

	/**
	 * Gets the sub task id.
	 *
	 * @return the sub task id
	 */
	public int getSubTaskId() {
		return subTaskId;
	}

	/**
	 * Sets the sub task id.
	 *
	 * @param subTaskId the new sub task id
	 */
	public void setSubTaskId(int subTaskId) {
		this.subTaskId = subTaskId;
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
	 * Gets the task.
	 *
	 * @return the task
	 */
	public Task getTask() {
		return task;
	}

	/**
	 * Sets the task.
	 *
	 * @param task the new task
	 */
	public void setTask(Task task) {
		this.task = task;
	}

}
