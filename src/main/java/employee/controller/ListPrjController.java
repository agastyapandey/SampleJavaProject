package employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import employee.info.Project;
import employee.service.ProjectService;

// TODO: Auto-generated Javadoc
/**
 * The Class ListPrjController.
 */
@Controller
public class ListPrjController {

	/** The project service. */
	@Autowired
	private ProjectService projectService;
	
	/**
	 * List project.
	 *
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/listproject", method = RequestMethod.GET)
	public String listProject(ModelMap model) {
		List<Project> list =projectService.getAllProjects();
		model.addAttribute("projects", list);
		return "listproject";
	}
}
