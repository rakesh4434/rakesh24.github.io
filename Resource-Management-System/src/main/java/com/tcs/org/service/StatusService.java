package com.tcs.org.service;

/*import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.tcs.org.model.ProjectDetails;
//import com.tcs.org.model.Requirement;
//import com.tcs.org.model.Company;
import com.tcs.org.model.Status;
//import com.tcs.org.repository.ProjectDetailsRepository;
//import com.tcs.org.repository.CompanyRepository;
import com.tcs.org.repository.StatusRepository;
@Service
public class StatusService {

	@Autowired
	private StatusRepository statusRepository;
	
	public Status getStatus(int statusId) {
		return statusRepository.getOne(statusId);
	}

	
	
}
