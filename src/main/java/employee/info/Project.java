package employee.info;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

// TODO: Auto-generated Javadoc
/**
 * The Class Project.
 */
@Entity
public class Project {

	/** The project_id. */
	@Id
	@GeneratedValue
	int project_id;
	
	/** The project_name. */
	@Size(min=1,max=15,message="Please enter project name.")
	String project_name;
	
	/** The start_date. */
	//@DateTimeFormat(pattern="MM/dd/yyyy")
	Date start_date;
	
	/** The end_date. */
	//@DateTimeFormat(pattern="MM/dd/yyyy")
	Date end_date;
	
	/** The project role. */
	@OneToMany(mappedBy="project", cascade=CascadeType.ALL)
	Set<ProjectRole> projectRole;
	
	/** The task. */
	@OneToMany(mappedBy="project",cascade=CascadeType.ALL)
	Set<Task> task;

	/**
	 * Gets the project_id.
	 *
	 * @return the project_id
	 */
	public int getProject_id() {
		return project_id;
	}

	/**
	 * Sets the project_id.
	 *
	 * @param project_id the new project_id
	 */
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

	/**
	 * Gets the project_name.
	 *
	 * @return the project_name
	 */
	public String getProject_name() {
		return project_name;
	}

	/**
	 * Sets the project_name.
	 *
	 * @param project_name the new project_name
	 */
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	/**
	 * Gets the start_date.
	 *
	 * @return the start_date
	 */
	public Date getStart_date() {
		return start_date;
	}

	/**
	 * Sets the start_date.
	 *
	 * @param start_date the new start_date
	 */
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	/**
	 * Gets the end_date.
	 *
	 * @return the end_date
	 */
	public Date getEnd_date() {
		return end_date;
	}

	/**
	 * Sets the end_date.
	 *
	 * @param end_date the new end_date
	 */
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	/**
	 * Gets the project role.
	 *
	 * @return the project role
	 */
	public Set<ProjectRole> getProjectRole() {
		return projectRole;
	}

	/**
	 * Sets the project role.
	 *
	 * @param projectRole the new project role
	 */
	public void setProjectRole(Set<ProjectRole> projectRole) {
		this.projectRole = projectRole;
	}

	/**
	 * Gets the task.
	 *
	 * @return the task
	 */
	public Set<Task> getTask() {
		return task;
	}

	/**
	 * Sets the task.
	 *
	 * @param task the new task
	 */
	public void setTask(Set<Task> task) {
		this.task = task;
	}
	
}