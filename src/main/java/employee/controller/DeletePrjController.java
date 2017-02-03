package employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import employee.service.ProjectService;

// TODO: Auto-generated Javadoc
/**
 * The Class DeletePrjController.
 */
@Controller
public class DeletePrjController {
	
	/** The project service. */
	@Autowired
	private ProjectService projectService;
	
	/**
	 * Delete project.
	 *
	 * @param pid the pid
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "deleteproject", method = RequestMethod.GET)
	public String deleteProject(@RequestParam(value = "pid", required = false) int pid, ModelMap model) {
		projectService.deleteProject(pid);
		return "redirect:listproject";
	}
}
