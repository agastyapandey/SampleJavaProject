package employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import employee.service.RoleService;

// TODO: Auto-generated Javadoc
/**
 * The Class DeleteRoleController.
 */
@Controller
public class DeleteRoleController {
	
	/** The role service. */
	@Autowired
	private RoleService roleService;
	
	/**
	 * Delete role.
	 *
	 * @param rid the rid
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "deleterole", method = RequestMethod.GET)
	public String deleteRole(@RequestParam(value = "rid", required = false) int rid, ModelMap model) {
		roleService.deleteRole(rid);
		return "redirect:listrole";
	}

}
