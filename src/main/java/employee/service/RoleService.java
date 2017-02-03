package employee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import employee.info.Role;

// TODO: Auto-generated Javadoc
/**
 * The Class RoleService.
 */
public class RoleService {
	
	/** The template. */
	@Autowired
	private HibernateTemplate template;
	
	/**
	 * Update role.
	 *
	 * @param role the role
	 */
	@Transactional(readOnly = false)
	public void updateRole(Role role) {
		template.saveOrUpdate(role);
	}
	
	/**
	 * Gets the all roles.
	 *
	 * @return the all roles
	 */
	public List<Role> getAllRoles() {
		List<Role> list = new ArrayList<Role>();
		list = template.loadAll(Role.class);
		return list;
	}
	
	/**
	 * Delete role.
	 *
	 * @param id the id
	 */
	@Transactional(readOnly = false)
	public void deleteRole(int id){
		Role role;
		role=template.get(Role.class,id);
		template.delete(role);
	}
	
	/**
	 * Gets the role by id.
	 *
	 * @param id the id
	 * @return the role by id
	 */
	public Role getRoleById(int id) {
		Role role;
		role = template.get(Role.class, id);
		return role;
	}
	
}
