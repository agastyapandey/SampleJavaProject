package employee.info;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

// TODO: Auto-generated Javadoc
/**
 * The Class Employee.
 */
@Entity
public class Employee {
	
	/** The Emp_id. */
	@Id
	@GeneratedValue
	@Column(name = "Emp_id")
	int Emp_id;
	
	/** The Emp_lname. */
	String Emp_lname;
	
	/** The Emp_fname. */
	@Size(min=4,max=15,message="First name should be 4 to 16 characters.")
	String Emp_fname;
	
	/** The Emp_doj. */
	@Size(min=10,max=10,message="Please enter correct date.")
	String Emp_doj;
	
	/** The Emp_status. */
	@Size(min=1,max=16,message="Please select status.")
	String Emp_status;
	
	/** The Emp_acn. */
	@Size(min=16,max=16,message="Please enter a 16 digit access card no.")
	String Emp_acn;
	
	/** The employee project role. */
	@OneToMany(mappedBy="employee", cascade=CascadeType.ALL)
	Set<EmployeeProjectRole> employeeProjectRole;
	
	/** The employee task. */
	@OneToMany(mappedBy="employee", cascade=CascadeType.ALL)
	Set<EmployeeTask> employeeTask;
	
	/**
	 * Gets the emp_id.
	 *
	 * @return the emp_id
	 */
	public int getEmp_id() {
		return Emp_id;
	}

	/**
	 * Sets the emp_id.
	 *
	 * @param emp_id the new emp_id
	 */
	public void setEmp_id(int emp_id) {
		Emp_id = emp_id;
	}

	/**
	 * Gets the emp_lname.
	 *
	 * @return the emp_lname
	 */
	public String getEmp_lname() {
		return Emp_lname;
	}

	/**
	 * Sets the emp_lname.
	 *
	 * @param emp_lname the new emp_lname
	 */
	public void setEmp_lname(String emp_lname) {
		Emp_lname = emp_lname;
	}

	/**
	 * Gets the emp_fname.
	 *
	 * @return the emp_fname
	 */
	public String getEmp_fname() {
		return Emp_fname;
	}

	/**
	 * Sets the emp_fname.
	 *
	 * @param emp_fname the new emp_fname
	 */
	public void setEmp_fname(String emp_fname) {
		Emp_fname = emp_fname;
	}

	/**
	 * Gets the emp_doj.
	 *
	 * @return the emp_doj
	 */
	public String getEmp_doj() {
		return Emp_doj;
	}

	/**
	 * Sets the emp_doj.
	 *
	 * @param emp_doj the new emp_doj
	 */
	public void setEmp_doj(String emp_doj) {
		Emp_doj = emp_doj;
	}

	/**
	 * Gets the emp_status.
	 *
	 * @return the emp_status
	 */
	public String getEmp_status() {
		return Emp_status;
	}

	/**
	 * Sets the emp_status.
	 *
	 * @param emp_status the new emp_status
	 */
	public void setEmp_status(String emp_status) {
		Emp_status = emp_status;
	}

	/**
	 * Gets the emp_acn.
	 *
	 * @return the emp_acn
	 */
	public String getEmp_acn() {
		return Emp_acn;
	}

	/**
	 * Sets the emp_acn.
	 *
	 * @param emp_acn the new emp_acn
	 */
	public void setEmp_acn(String emp_acn) {
		Emp_acn = emp_acn;
	}

	/**
	 * Gets the employee project role.
	 *
	 * @return the employee project role
	 */
	public Set<EmployeeProjectRole> getEmployeeProjectRole() {
		return employeeProjectRole;
	}

	/**
	 * Sets the employee project role.
	 *
	 * @param employeeProjectRole the new employee project role
	 */
	public void setEmployeeProjectRole(Set<EmployeeProjectRole> employeeProjectRole) {
		this.employeeProjectRole = employeeProjectRole;
	}

	/**
	 * Gets the employee task.
	 *
	 * @return the employee task
	 */
	public Set<EmployeeTask> getEmployeeTask() {
		return employeeTask;
	}

	/**
	 * Sets the employee task.
	 *
	 * @param employeeTask the new employee task
	 */
	public void setEmployeeTask(Set<EmployeeTask> employeeTask) {
		this.employeeTask = employeeTask;
	}
	
}