package com.tcs.org.controller;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tcs.org.model.Category;
import com.tcs.org.model.DigitalProfile;
import com.tcs.org.model.Location;
import com.tcs.org.model.ProjectDetails;
import com.tcs.org.model.Requirement;
import com.tcs.org.service.RequrimentService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class RequirementController {
	
	@Autowired
	private RequrimentService requrimentService; 
	
	@PostMapping("/requirement/add")
	public Requirement addRequirement(@RequestBody  Requirement requirement) {
		
		requrimentService.addRequirement(requirement);
		
		return  requirement;
		}

	@GetMapping("/requirement")
	public List<Requirement> getAllRequirements() {
		return requrimentService.getAllRequirements();
	}
	/*
	@GetMapping("/requirement/{project_id}")
	public Optional<Requirement> getProjectDetails(int  id) {
		return requrimentService.getProjectDetails(id);
	}
	*/
	
	
	
	
	
	
	
	@RequestMapping(method=RequestMethod.PUT, value="/requirement/{id}")
	public Requirement updateTopic(@RequestBody Requirement requirement, @PathVariable int id) {
		 requrimentService.updateRequirement(id, requirement);
		 return requirement;
	}
	
	@DeleteMapping("/requirement/{id}")
	public void deleteRequirement(@PathVariable int id) {
		requrimentService.deleteRequirement(id);

	}
	
	@GetMapping("/requirement/opportunity/{opportunityId}")
	public List<Requirement> getRequirementByOpportunity(@PathVariable int opportunityId) {
		return requrimentService.getRequirementByOpportunity(opportunityId);
	}
	
	@GetMapping("/requirement/status/{status}")
	public List<Requirement> getRequirementByStatus(@PathVariable int status) {
		return requrimentService.getRequirementByStatus(status);
	}
	
	 @RequestMapping(value = "/requirement/status/{status}/project/{projectDetailsId}", method = RequestMethod.GET)
		public List<Requirement> getRequirementByStatusandProjectId(@PathVariable int status, @PathVariable int projectDetailsId) {
			return requrimentService.getRequirementByStatusandProjectId(status , projectDetailsId);
		}
	 @SuppressWarnings("deprecation")
		@PostMapping(value="/requirement/upload/{id}")
			public  void uploadUser( @RequestParam("file") MultipartFile file, @PathVariable int id) {

				try(InputStream inputStream =  new BufferedInputStream(file.getInputStream());
						 Workbook workbook = new HSSFWorkbook(inputStream);	) {

					 System.out.println("id"+id);
					List<Integer> requirement = new ArrayList<Integer>();
					requirement.add(id);
					System.out.println(requirement);
				      // InputStream inputStream =  new BufferedInputStream(file.getInputStream());
		            //FileInputStream excelFile = inputStream;
		           // Workbook workbook = new XSSFWorkbook(inputStream);
		            Sheet datatypeSheet = workbook.getSheetAt(0);


		           // Row currentRow = datatypeSheet.getRow(0);

		           // int col_num = -1;

		            for (int j = 1 ;j<datatypeSheet.getPhysicalNumberOfRows();j++){  
		                Row row=datatypeSheet.getRow(j);
		                Requirement req=new Requirement();
		               // System.out.println("Application Name"+row.getCell(0).getStringCellValue());
		                req.setId((int)row.getCell(0).getNumericCellValue());
		                req.setAssociateCount((int)row.getCell(1).getNumericCellValue());
		                req.setAssociateExp((int)row.getCell(2).getNumericCellValue());
		                req.setAssociateReqCountry((int)row.getCell(3).getNumericCellValue());
		                req.setBillLoss(row.getCell(4).getStringCellValue());
		                req.setBillRate(row.getCell(5).getStringCellValue());
		                req.setBranchId((int)row.getCell(6).getNumericCellValue());
		                req.setBrmId((int)row.getCell(7).getNumericCellValue());
		                req.setClientInterviewFlag(row.getCell(8).getBooleanCellValue());
		                req.setClientManager((int)row.getCell(9).getNumericCellValue());
		                req.setCustomerGroup(row.getCell(10).getStringCellValue());
		                Date date = (row.getCell(11).getDateCellValue());
		                
		                		 LocalDateTime convertedDate = date.toInstant()
		                			      .atZone(ZoneId.systemDefault())
		                			      .toLocalDateTime();
		               req.setEndDate(convertedDate);
		                req.setEngagementType((int)row.getCell(12).getNumericCellValue());
		                req.setEvaluatorId((int)row.getCell(13).getNumericCellValue());
		                req.setExpcetedcostMax((int)row.getCell(14).getNumericCellValue());
		                req.setExpcetedcostMin((int)row.getCell(15).getNumericCellValue());
		                req.setExpectedCostCurrency((int)row.getCell(16).getNumericCellValue());
		                
		                req.setJobDesc(row.getCell(17).getStringCellValue());

		                
		                req.setLocationOffshore((int)row.getCell(18,Row.CREATE_NULL_AS_BLANK).getNumericCellValue());
		                req.setOffshoreDmId((int)row.getCell(19).getNumericCellValue());
		                req.setOnsitedmId((int)row.getCell(20).getNumericCellValue());
		                req.setProgramName(row.getCell(21).getStringCellValue());

		                
		                
		                req.setRealizationAmt((int)row.getCell(22).getNumericCellValue());
		                req.setRealizationCurrency((int)row.getCell(23).getNumericCellValue());
		                req.setReplacementEmpCode((int)row.getCell(24).getNumericCellValue());
		                Date date2=(row.getCell(25).getDateCellValue());
		                LocalDateTime convertedDate2 = date2.toInstant()
		           			      .atZone(ZoneId.systemDefault())
		           			      .toLocalDateTime();
		                req.setReqCreatedDate(convertedDate2);
		             //   req.setReqCreatedDate((row.getCell(25).getDateCellValue()));
		                req.setReqKeywords(row.getCell(26).getStringCellValue());
		                req.setReqResponsibilities(row.getCell(27).getStringCellValue());
		                req.setReqRole(row.getCell(28).getStringCellValue());
		                req.setReqType((int)row.getCell(29).getNumericCellValue());
		                req.setReqWonId((int)row.getCell(30).getNumericCellValue());
		                req.setServicePractice(row.getCell(31).getStringCellValue());
		                req.setSkillsGood(row.getCell(32).getStringCellValue());
		                req.setSkillsMust(row.getCell(33).getStringCellValue());
		                req.setStaffingSource((int)row.getCell(34).getNumericCellValue());
		                Date date1=(row.getCell(35).getDateCellValue());
		                LocalDateTime convertedDate1 = date1.toInstant()
           			      .atZone(ZoneId.systemDefault())
           			      .toLocalDateTime();
		                req.setStartDate(convertedDate1);

		                req.setStatus((int)row.getCell(36).getNumericCellValue());
		                req.setSttafingReason((int)row.getCell(37).getNumericCellValue());
		                req.setTrackName(row.getCell(38).getStringCellValue());
		              Location location = new Location();
		              location.setLocationId((int)row.getCell(39).getNumericCellValue());
						//location
		                req.setLocation(location);
		                /*req.getLocation().setBranchName(row.getCell(19,Row.CREATE_NULL_AS_BLANK).getStringCellValue());
		                req.getLocation().setCityId(Integer.parseInt(row.getCell(20,Row.CREATE_NULL_AS_BLANK).getStringCellValue()));
		                req.getLocation().setCityName(row.getCell(21,Row.CREATE_NULL_AS_BLANK).getStringCellValue());
		                req.getLocation().setCountryId(Integer.parseInt(row.getCell(22,Row.CREATE_NULL_AS_BLANK).getStringCellValue()));
		                req.getLocation().setCountryName(row.getCell(23,Row.CREATE_NULL_AS_BLANK).getStringCellValue());
		                req.getLocation().setBranchId(Integer.parseInt(row.getCell(24,Row.CREATE_NULL_AS_BLANK).getStringCellValue()));
		                req.getLocation().setLocationName(row.getCell(25,Row.CREATE_NULL_AS_BLANK).getStringCellValue());
		               */
		                
		              //projectDetails	
		                ProjectDetails projectDetails=new ProjectDetails();
		                projectDetails.setProjectDetailsId((int)row.getCell(40).getNumericCellValue());
		                projectDetails.setId((int)row.getCell(40).getNumericCellValue());
		               /* req.getProjectDetails().setIOU(row.getCell(31,Row.CREATE_NULL_AS_BLANK).getStringCellValue());
		                req.getProjectDetails().setProjectDetailsId(Integer.parseInt(row.getCell(32,Row.CREATE_NULL_AS_BLANK).getStringCellValue()));
		                req.getProjectDetails().setProjectName(row.getCell(33,Row.CREATE_NULL_AS_BLANK).getStringCellValue());
		                req.getProjectDetails().setProjectType(row.getCell(34,Row.CREATE_NULL_AS_BLANK).getStringCellValue());
		                req.getProjectDetails().setSpName(row.getCell(35,Row.CREATE_NULL_AS_BLANK).getStringCellValue());
                     */
		                req.setTaggedSkill(row.getCell(41).getStringCellValue());
		                req.setProjectDetails(projectDetails);
		                req.setOpportunityId((int)row.getCell(42).getNumericCellValue());
		                requrimentService.findAll();
		               requrimentService.addRequirement1(req);

		               


		                //sucessmsg=sucessmsg+"\n"+user.getUsername();
		            }


		        } catch (FileNotFoundException e) {
		        	//sucessmsg="File Not Found";
		            e.printStackTrace();
		        } catch (IOException e) {
		        	//sucessmsg=e.getLocalizedMessage();
		            e.printStackTrace();
		        }

			}
	
	/* @SuppressWarnings("deprecation")
		@PostMapping(value="/requirement/upload/{id}")
			public  void uploadUser( @RequestParam("file") MultipartFile file, @PathVariable int id) {

				try(InputStream inputStream =  new BufferedInputStream(file.getInputStream());
						 Workbook workbook = new HSSFWorkbook(inputStream);	) {

					 System.out.println("id"+id);
					List<Integer> requirement = new ArrayList<Integer>();
					requirement.add(id);
					System.out.println(requirement);
				      // InputStream inputStream =  new BufferedInputStream(file.getInputStream());
		            //FileInputStream excelFile = inputStream;
		           // Workbook workbook = new XSSFWorkbook(inputStream);
		            Sheet datatypeSheet = workbook.getSheetAt(0);


		           // Row currentRow = datatypeSheet.getRow(0);

		           // int col_num = -1;

		            for (int j = 1 ;j<datatypeSheet.getPhysicalNumberOfRows();j++){  
		                Row row=datatypeSheet.getRow(j);
		                Requirement req=new Requirement();
		               // System.out.println("Application Name"+row.getCell(0).getStringCellValue());
		                req.setId((int)row.getCell(0).getNumericCellValue());
		                req.setAssociateCount((int)row.getCell(1).getNumericCellValue());
		                req.setAssociateExp((int)row.getCell(2).getNumericCellValue());
		                req.setAssociateReqCountry((int)row.getCell(3).getNumericCellValue());
		                req.setBillLoss(row.getCell(4).getStringCellValue());
		                req.setBillRate(row.getCell(5).getStringCellValue());
		                req.setBranchId((int)row.getCell(6).getNumericCellValue());
		                req.setBrmId((int)row.getCell(7).getNumericCellValue());
		                req.setClientInterviewFlag(row.getCell(8).getBooleanCellValue());
		                req.setClientManager((int)row.getCell(9).getNumericCellValue());
		                req.setCustomerGroup(row.getCell(10).getStringCellValue());
		                
		                
		               req.setEndDate((row.getCell(11).getDateCellValue()));
		                req.setEngagementType((int)row.getCell(12).getNumericCellValue());
		                req.setEvaluatorId((int)row.getCell(13).getNumericCellValue());
		                req.setExpcetedcostMax((int)row.getCell(14).getNumericCellValue());
		                req.setExpcetedcostMin((int)row.getCell(15).getNumericCellValue());
		                req.setExpectedCostCurrency((int)row.getCell(16).getNumericCellValue());
		                
		                req.setJobDesc(row.getCell(17).getStringCellValue());

		                
		                req.setLocationOffshore((int)row.getCell(18,Row.CREATE_NULL_AS_BLANK).getNumericCellValue());
		                req.setOffshoreDmId((int)row.getCell(19).getNumericCellValue());
		                req.setOnsitedmId((int)row.getCell(20).getNumericCellValue());
		                req.setProgramName(row.getCell(21).getStringCellValue());

		                
		                
		                req.setRealizationAmt((int)row.getCell(22).getNumericCellValue());
		                req.setRealizationCurrency((int)row.getCell(23).getNumericCellValue());
		                req.setReplacementEmpCode((int)row.getCell(24).getNumericCellValue());
		                req.setReqCreatedDate((row.getCell(25).getDateCellValue()));
		                req.setReqKeywords(row.getCell(26).getStringCellValue());
		                req.setReqResponsibilities(row.getCell(27).getStringCellValue());
		                req.setReqRole(row.getCell(28).getStringCellValue());
		                req.setReqType((int)row.getCell(29).getNumericCellValue());
		                req.setReqWonId((int)row.getCell(30).getNumericCellValue());
		                req.setServicePractice(row.getCell(31).getStringCellValue());
		                req.setSkillsGood(row.getCell(32).getStringCellValue());
		                req.setSkillsMust(row.getCell(33).getStringCellValue());
		                req.setStaffingSource((int)row.getCell(34).getNumericCellValue());
		                req.((row.getCell(35).getDateCellValue()));

		                req.setStatus((int)row.getCell(36).getNumericCellValue());
		                req.setSttafingReason((int)row.getCell(37).getNumericCellValue());
		                req.setTrackName(row.getCell(38).getStringCellValue());
		              Location location = new Location();
		              location.setLocationId((int)row.getCell(39).getNumericCellValue());
						//location
		                req.setLocation(location);
		                req.getLocation().setBranchName(row.getCell(19,Row.CREATE_NULL_AS_BLANK).getStringCellValue());
		                req.getLocation().setCityId(Integer.parseInt(row.getCell(20,Row.CREATE_NULL_AS_BLANK).getStringCellValue()));
		                req.getLocation().setCityName(row.getCell(21,Row.CREATE_NULL_AS_BLANK).getStringCellValue());
		                req.getLocation().setCountryId(Integer.parseInt(row.getCell(22,Row.CREATE_NULL_AS_BLANK).getStringCellValue()));
		                req.getLocation().setCountryName(row.getCell(23,Row.CREATE_NULL_AS_BLANK).getStringCellValue());
		                req.getLocation().setBranchId(Integer.parseInt(row.getCell(24,Row.CREATE_NULL_AS_BLANK).getStringCellValue()));
		                req.getLocation().setLocationName(row.getCell(25,Row.CREATE_NULL_AS_BLANK).getStringCellValue());
		               
		                
		              //projectDetails	
		                ProjectDetails projectDetails=new ProjectDetails();
		                projectDetails.setId((int)row.getCell(40).getNumericCellValue());
		                req.getProjectDetails().setIOU(row.getCell(31,Row.CREATE_NULL_AS_BLANK).getStringCellValue());
		                req.getProjectDetails().setProjectDetailsId(Integer.parseInt(row.getCell(32,Row.CREATE_NULL_AS_BLANK).getStringCellValue()));
		                req.getProjectDetails().setProjectName(row.getCell(33,Row.CREATE_NULL_AS_BLANK).getStringCellValue());
		                req.getProjectDetails().setProjectType(row.getCell(34,Row.CREATE_NULL_AS_BLANK).getStringCellValue());
		                req.getProjectDetails().setSpName(row.getCell(35,Row.CREATE_NULL_AS_BLANK).getStringCellValue());
                     
		                req.setTaggedSkill(row.getCell(41).getStringCellValue());
		                req.setOpportunityId((int)row.getCell(42).getNumericCellValue());
		                requrimentService.findAll();
		               requrimentService.addRequirement1(req);

		               


		                //sucessmsg=sucessmsg+"\n"+user.getUsername();
		            }


		        } catch (FileNotFoundException e) {
		        	//sucessmsg="File Not Found";
		            e.printStackTrace();
		        } catch (IOException e) {
		        	//sucessmsg=e.getLocalizedMessage();
		            e.printStackTrace();
		        }

			}
*/
	

}
