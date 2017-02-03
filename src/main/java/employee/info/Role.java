package employee.info;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

// TODO: Auto-generated Javadoc
/**
 * The Class Role.
 */
@Entity
public class Role {

	/** The role_id. */
	@Id
	@GeneratedValue
	int role_id;
	
	/** The role_name. */
	@Size(min=1,max=16,message="Please Enter Role name.")
	String role_name;
	
	/** The project role. */
	@OneToMany(mappedBy="role",cascade=CascadeType.ALL)
	Set<ProjectRole> projectRole;

	/**
	 * Gets the role_id.
	 *
	 * @return the role_id
	 */
	public int getRole_id() {
		return role_id;
	}

	/**
	 * Sets the role_id.
	 *
	 * @param role_id the new role_id
	 */
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	/**
	 * Gets the role_name.
	 *
	 * @return the role_name
	 */
	public String getRole_name() {
		return role_name;
	}

	/**
	 * Sets the role_name.
	 *
	 * @param role_name the new role_name
	 */
	public void setRole_name(String role_name) {
		this.role_name = role_name;
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
	
	

}