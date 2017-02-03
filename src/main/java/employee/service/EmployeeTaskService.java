package employee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import employee.info.EmployeeTask;

// TODO: Auto-generated Javadoc
/**
 * The Class EmployeeTaskService.
 */
public class EmployeeTaskService {

	/** The template. */
	@Autowired
	private HibernateTemplate template;
	
	/**
	 * Update emp task.
	 *
	 * @param empTask the emp task
	 */
	@Transactional(readOnly = false)
	public void updateEmpTask(EmployeeTask empTask) {
		template.saveOrUpdate(empTask);
	}
	
	/**
	 * Gets the all emp task on project.
	 *
	 * @param eid the eid
	 * @param pid the pid
	 * @return the all emp task on project
	 */
	public List<EmployeeTask> getAllEmpTaskOnProject(int eid,int pid){
		@SuppressWarnings("unchecked")
		List<EmployeeTask> list=(ArrayList<EmployeeTask>)template.find("from EmployeeTask eT where eT.task.project.project_id="+pid+"and eT.employee.Emp_id="+eid);
		return list;
	}
	
	/**
	 * Delete employee task.
	 *
	 * @param id the id
	 */
	@Transactional(readOnly = false)
	public void deleteEmployeeTask(int id){
		EmployeeTask employeeTask;
		employeeTask=template.load(EmployeeTask.class,id);
		template.delete(employeeTask);
	}
	
	/**
	 * Gets the employee task by id.
	 *
	 * @param id the id
	 * @return the employee task by id
	 */
	public EmployeeTask getEmployeeTaskById(int id) {
		EmployeeTask employeeTask;
		employeeTask = template.get(EmployeeTask.class, id);
		return employeeTask;
	}
}
