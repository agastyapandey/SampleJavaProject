package employee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import employee.info.EmployeeProjectRole;

// TODO: Auto-generated Javadoc
/**
 * The Class EmployeeProjectRoleService.
 */
public class EmployeeProjectRoleService {
	
	/** The template. */
	@Autowired
	private HibernateTemplate template;
	
	/**
	 * Update employee project role.
	 *
	 * @param employeeProjectRole the employee project role
	 */
	@Transactional(readOnly = false)
	public void updateEmployeeProjectRole(EmployeeProjectRole employeeProjectRole) {
		template.saveOrUpdate(employeeProjectRole);
	}
	
	/**
	 * Gets the all emp projects.
	 *
	 * @param eid the eid
	 * @return the all emp projects
	 */
	public List<EmployeeProjectRole> getAllEmpProjects(int eid){
		@SuppressWarnings("unchecked")
		List<EmployeeProjectRole> list=(ArrayList<EmployeeProjectRole>)template.find("from EmployeeProjectRole ePR where ePR.employee.Emp_id="+eid);
		return list;
	}
	
	/**
	 * Gets the all projects employee.
	 *
	 * @param pid the pid
	 * @return the all projects employee
	 */
	public List<EmployeeProjectRole> getAllProjectsEmployee(int pid){
		@SuppressWarnings("unchecked")
		List<EmployeeProjectRole> list=(ArrayList<EmployeeProjectRole>)template.find("from EmployeeProjectRole ePR where ePR.projectRole.project.project_id="+pid);
		return list;
	}
	
	/**
	 * Gets the employee poject role by id.
	 *
	 * @param ePRID the e prid
	 * @return the employee poject role by id
	 */
	public EmployeeProjectRole getEmployeePojectRoleById(int ePRID){
		EmployeeProjectRole ePR=template.get(EmployeeProjectRole.class,ePRID);
		return ePR;
	}
	
	/**
	 * Delete emp project role by id.
	 *
	 * @param ePRID the e prid
	 */
	@Transactional(readOnly = false)
	public void deleteEmpProjectRoleById(int ePRID){
		EmployeeProjectRole ePR;
		ePR=template.get(EmployeeProjectRole.class,ePRID);
		template.delete(ePR);
	}

}
