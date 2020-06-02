package com.tcs.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.org.model.Requirement;
import com.tcs.org.model.Workflow;
import com.tcs.org.service.WorkflowService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class WorkflowController {
	@Autowired
	private  WorkflowService  workflowService;
	
	@GetMapping("/workflow")
	public List<Workflow> getAllWorkflow() {
		return workflowService.getAllWorkflow();
	}
	
	@PostMapping("/workflow/add")
	public Workflow addworkflow(@RequestBody  Workflow workflow) {
		
		workflowService.addWorkflow(workflow);
		
		return  workflow;
		}
	
	@GetMapping("/workflow/requirement/{reqId}")
	public List<Workflow> getWorkflowByRequirement(@PathVariable int reqId) {
		return workflowService.getWorkflowByRequirement(reqId);
	}
		
	/*@GetMapping("/skill/{compId}")
	public Skill getSkill(@PathVariable int compId) {
		return skillService.getSkill(compId);
 
}*/

}
