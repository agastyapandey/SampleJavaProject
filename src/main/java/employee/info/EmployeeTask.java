package employee.info;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

// TODO: Auto-generated Javadoc
/**
 * The Class EmployeeTask.
 */
@Entity
public class EmployeeTask {
	
	/** The employee task id. */
	@Id
	@GeneratedValue
	int employeeTaskId;
	
	/** The employee. */
	@ManyToOne
	@JoinColumn(name="Emp_id")
	Employee employee;
	
	/** The task. */
	@ManyToOne
	@JoinColumn(name="taskId")
	Task task;

	/**
	 * Gets the employee task id.
	 *
	 * @return the employee task id
	 */
	public int getEmployeeTaskId() {
		return employeeTaskId;
	}

	/**
	 * Sets the employee task id.
	 *
	 * @param employeeTaskId the new employee task id
	 */
	public void setEmployeeTaskId(int employeeTaskId) {
		this.employeeTaskId = employeeTaskId;
	}

	/**
	 * Gets the employee.
	 *
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * Sets the employee.
	 *
	 * @param employee the new employee
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
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
