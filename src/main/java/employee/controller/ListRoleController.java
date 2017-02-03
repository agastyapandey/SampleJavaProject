package employee.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import employee.info.Role;
import employee.service.RoleService;

// TODO: Auto-generated Javadoc
/**
 * The Class ListRoleController.
 */
@Controller
public class ListRoleController {

	/** The role service. */
	@Autowired
	private RoleService roleService;
	
	/**
	 * List role.
	 *
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/listrole", method = RequestMethod.GET)
	public String listRole(ModelMap model) {
		List<Role> list = (ArrayList<Role>) roleService.getAllRoles();
		model.addAttribute("roles", list);
		return "listrole";
	}
	
}
