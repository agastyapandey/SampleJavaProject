package employee.info;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

// TODO: Auto-generated Javadoc
/**
 * The Class EmployeeProjectRole.
 */
@Entity
public class EmployeeProjectRole {

	/** The employee project role id. */
	@Id
	@GeneratedValue
	int employeeProjectRoleId;
	
	/** The employee. */
	@ManyToOne
	@JoinColumn(name="Emp_id")
	Employee employee;
	
	/** The project role. */
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="projectRoleId")
	ProjectRole projectRole;

	/** The assign date. */
	Date assignDate;
	
	/** The release date. */
	Date releaseDate;

	/**
	 * Gets the employee project role id.
	 *
	 * @return the employee project role id
	 */
	public int getEmployeeProjectRoleId() {
		return employeeProjectRoleId;
	}

	/**
	 * Sets the employee project role id.
	 *
	 * @param employeeProjectRoleId the new employee project role id
	 */
	public void setEmployeeProjectRoleId(int employeeProjectRoleId) {
		this.employeeProjectRoleId = employeeProjectRoleId;
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
	 * Gets the project role.
	 *
	 * @return the project role
	 */
	public ProjectRole getProjectRole() {
		return projectRole;
	}

	/**
	 * Sets the project role.
	 *
	 * @param projectRole the new project role
	 */
	public void setProjectRole(ProjectRole projectRole) {
		this.projectRole = projectRole;
	}

	/**
	 * Gets the assign date.
	 *
	 * @return the assign date
	 */
	public Date getAssignDate() {
		return assignDate;
	}

	/**
	 * Sets the assign date.
	 *
	 * @param assignDate the new assign date
	 */
	public void setAssignDate(Date assignDate) {
		this.assignDate = assignDate;
	}

	/**
	 * Gets the release date.
	 *
	 * @return the release date
	 */
	public Date getReleaseDate() {
		return releaseDate;
	}

	/**
	 * Sets the release date.
	 *
	 * @param releaseDate the new release date
	 */
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	
	
}
