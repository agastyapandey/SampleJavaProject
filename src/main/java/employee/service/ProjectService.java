package employee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import employee.info.Project;

// TODO: Auto-generated Javadoc
/**
 * The Class ProjectService.
 */
public class ProjectService {

	/** The template. */
	@Autowired
	private HibernateTemplate template;
	
	/**
	 * Update project.
	 *
	 * @param project the project
	 */
	@Transactional(readOnly = false)
	public void updateProject(Project project) {
		template.saveOrUpdate(project);

	}
	
	/**
	 * Gets the all projects.
	 *
	 * @return the all projects
	 */
	public List<Project> getAllProjects() {
		List<Project> list = new ArrayList<Project>();
		list = template.loadAll(Project.class);
		return list;
	}
	
	/**
	 * Delete project.
	 *
	 * @param id the id
	 */
	@Transactional(readOnly = false)
	public void deleteProject(int id){
		Project project;
		project=template.load(Project.class,id);
		template.delete(project);
	}
	
	/**
	 * Gets the project by id.
	 *
	 * @param id the id
	 * @return the project by id
	 */
	public Project getProjectById(int id) {
		Project project;
		project = template.get(Project.class, id);
		return project;
	}

}
