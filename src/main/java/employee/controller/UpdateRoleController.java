package employee.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import employee.info.Role;
import employee.service.RoleService;

/**
 * The Class UpdateRoleController.
 */
@Controller
public class UpdateRoleController {
	
	/** The role service. */
	@Autowired
	private RoleService roleService;
	/**
	 * Adds the edit role.
	 *
	 * @param rid the rid
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "insertrole", method = RequestMethod.GET)
	public String addEditRole(@RequestParam(value = "rid", required = false) String rid,ModelMap model) {
		Role role = null;
		if (rid != null){
			int roleId=Integer.parseInt(rid);
			role = roleService.getRoleById(roleId);
		}
		model.addAttribute("role", role);
		return "saverole";
		}

	/**
	 * Save role.
	 *
	 * @param role the role
	 * @param result the result
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "saverole", method = RequestMethod.POST)
	public String saveRole(@Valid @ModelAttribute("role1") Role role, BindingResult result, ModelMap model){
		if(result.hasErrors()){
			return "saverole";
		}else{
		roleService.updateRole(role);
		return "redirect:listrole";
		}
	}
	
}
