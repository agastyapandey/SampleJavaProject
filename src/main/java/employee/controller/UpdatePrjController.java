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

import employee.info.Project;
import employee.service.ProjectService;

// TODO: Auto-generated Javadoc
/**
 * The Class UpdatePrjController.
 */
@Controller
public class UpdatePrjController {
	
	/** The project service. */
	@Autowired
	private ProjectService projectService;
	
	/**
	 * Adds the edit project.
	 *
	 * @param pid the pid
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "insertproject", method = RequestMethod.GET)
	public String addEditProject(@RequestParam(value = "pid", required = false) String pid,ModelMap model) {
		Project project = null;
		if (pid != null){
			int id=Integer.parseInt(pid);
			project = projectService.getProjectById(id);
		}
		model.addAttribute("project", project);
		return "saveproject";
		}

	/**
	 * Save project.
	 *
	 * @param project the project
	 * @param result the result
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "saveproject", method = RequestMethod.POST)
	public String saveProject(@Valid @ModelAttribute("project1")Project project, BindingResult result, ModelMap model){
		if(result.hasErrors()){
			return "saveproject";
		}else{
		projectService.updateProject(project);
		return "redirect:listproject";
		}
	}

}

