package employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import employee.info.ProjectRole;

// TODO: Auto-generated Javadoc
/**
 * The Class ProjectRoleService.
 */
public class ProjectRoleService {

	/** The template. */
	@Autowired
	private HibernateTemplate template;
	
	/**
	 * Update project role.
	 *
	 * @param projectRole the project role
	 * @return the project role
	 */
	@Transactional(readOnly = false)
	public ProjectRole updateProjectRole(ProjectRole projectRole) {
		template.saveOrUpdate(projectRole);
		return projectRole;
	}


}
