package employee.info;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

// TODO: Auto-generated Javadoc
/**
 * The Class ProjectRole.
 */
@Entity
public class ProjectRole {
	
	/** The project role id. */
	@Id
	@GeneratedValue
	int projectRoleId;
	
	/** The project. */
	@ManyToOne
	@JoinColumn(name="project_id")
	Project project;
	
	/** The role. */
	@ManyToOne
	@JoinColumn(name="role_id")
	Role role;

	/** The employee project role. */
	@OneToMany(mappedBy="projectRole", cascade=CascadeType.ALL)
	Set<EmployeeProjectRole> employeeProjectRole;
	
	/**
	 * Gets the project role id.
	 *
	 * @return the project role id
	 */
	public int getProjectRoleId() {
		return projectRoleId;
	}

	/**
	 * Sets the project role id.
	 *
	 * @param projectRoleId the new project role id
	 */
	public void setProjectRoleId(int projectRoleId) {
		this.projectRoleId = projectRoleId;
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
	 * Gets the role.
	 *
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * Sets the role.
	 *
	 * @param role the new role
	 */
	public void setRole(Role role) {
		this.role = role;
	}
	
	
}
