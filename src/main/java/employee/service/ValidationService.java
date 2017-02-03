package employee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import employee.info.EmployeeProjectRole;
import employee.info.Task;

// TODO: Auto-generated Javadoc
/**
 * The Class ValidationService.
 */
public class ValidationService {
	
	/** The template. */
	@Autowired
	private HibernateTemplate template;
	
	/**
	 * Check duplicate project assignment.
	 *
	 * @param eid the eid
	 * @param pid the pid
	 * @param rid the rid
	 * @return true, if successful
	 */
	public boolean checkDuplicateProjectAssignment(int eid,int pid,int rid){
		@SuppressWarnings("unchecked")
		List<EmployeeProjectRole> list=(ArrayList<EmployeeProjectRole>)template.find("from EmployeeProjectRole ePR where ePR.employee.Emp_id="+eid+"and ePR.projectRole.project.project_id="+pid+"and ePR.projectRole.role.role_id="+rid);
		if(list.isEmpty()){
		
			return false;
		
		} else {
			
		return true;
		
		}
	}
	
	/**
	 * Check duplicate task addition.
	 *
	 * @param pid the pid
	 * @param taskName the task name
	 * @return true, if successful
	 */
	public boolean checkDuplicateTaskAddition(int pid,String taskName){
		@SuppressWarnings("unchecked")
		List<Task> list=(ArrayList<Task>)template.find("from Task t where t.taskName='"+taskName+"' and t.project.project_id="+pid);
		if(list.isEmpty()){
		
			return false;
		
		} else {
			
		return true;
		
		}
	}

}
