package com.tcs.org.service;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.tcs.org.model.Workflow;
//import com.tcs.org.repository.EmployeeEntity;
//import com.tcs.org.repository.Sort;
import com.tcs.org.repository.WorkflowRepository;

//import com.tcs.org.model.ProjectDetails;
//import com.tcs.org.repository.ProjectDetailsRepository;

@Service
public class WorkflowService {

@Autowired
private WorkflowRepository workflowRepository;
private Workflow workflow;

public List<Workflow> getAllWorkflow() {
    List<Workflow> workflow = new ArrayList<>();
    workflowRepository.findAll()
    .forEach(workflow::add);
    return workflow;
}


public Workflow addWorkflow(@RequestBody Workflow workflow) {
	
    return workflowRepository.save(workflow);
}


public List<Workflow> getWorkflowByRequirement(int reqId) {
	
	
	// TODO Auto-generated method stub
	List<Workflow> list1 = new ArrayList<Workflow>();
	List<Workflow> list2 = new ArrayList<Workflow>();
	HashMap<Integer,Boolean> hm = new HashMap<Integer,Boolean>();
	list1= workflowRepository.findByReqId(reqId);
	//List<Date> createdDate1;
	
	List<Workflow> sortedUsers = list1.stream()
			  .sorted(Comparator.comparing(Workflow:: getActionDoneOn).reversed()).collect(Collectors.toList());
	
	  for(int i = 0; i<sortedUsers.size();i++)
	  {
		  if(hm.containsKey(sortedUsers.get(i).getEmpId()))
				  {
			  		if(hm.get(sortedUsers.get(i).getEmpId()))
			  			list2.add(sortedUsers.get(i));
			  			 hm.put(sortedUsers.get(i).getEmpId(),false);
				  }
		  else {
			  if(sortedUsers.get(i).getActionTaken().equalsIgnoreCase("shortlisted"))
				  hm.put(sortedUsers.get(i).getEmpId(),false);
			  else {
				  hm.put(sortedUsers.get(i).getEmpId(),true);
			  	}
			  list2.add(sortedUsers.get(i));
		  	}
	  }
	return list2;
}


/*public Skill  getSkill(int compId) {
    return skillRepository.getOne(compId);
}*/
}