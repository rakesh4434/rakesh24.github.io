package com.tcs.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.org.service.UserService;
import java.util.*;

import javax.validation.Valid;

//import com.tcs.org.model.FAQModel;
import com.tcs.org.model.JwtResponse;
//import com.tcs.org.model.ModuleProgress;
import com.tcs.org.model.User;
//import com.tcs.org.security.JwtProvider;
import com.tcs.org.security.JwtTokenProvider;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/*@Autowired
	private DealService dealService;*/
	/*@Autowired
	private QuestionService questionService;*/

	 @Autowired
	    AuthenticationManager authenticationManager;
	 
	 @Autowired
	    JwtTokenProvider jwtProvider;
	
	 
	
	 
	 @PostMapping("/users/authenticate")
	 public ResponseEntity<?> authenticateUser(@Valid @RequestBody User user) {
		 Authentication authentication = authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(
	                		user.getUsername(),
	                		user.getPassword()
	                )
	        );
	 
	        SecurityContextHolder.getContext().setAuthentication(authentication);
	 
	        String jwt = jwtProvider.generateToken(authentication);
	        return ResponseEntity.ok(new JwtResponse(jwt,userService.getUser(user.getUsername())));
	 }
	
	

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	/*@GetMapping("/users/getUsersByDealId/{dealId}")
	public List<User> getUsersByDealId(@PathVariable int dealId) {
		return userService.getUserByDealId(dealId);
	}*/
	@GetMapping("/users/{username}")
	public User getUser(@PathVariable String username) {
		return userService.getUser(username);
	}
	@GetMapping("/users/getByUserId/{userId}")
	public Optional<User> getUserById(@PathVariable int userId) {
		return userService.getUserById(userId);
	}
	@PostMapping(value="/users/create")
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/user/{userId}")
	public User updateTopic(@RequestBody User user, @PathVariable int userId) {
		userService.updateUser(userId, user);
		 return user;
	}
	/*@PostMapping(value="/all/upload/{dealid}")
	public List<User> uploadUser(@PathVariable int dealid, @RequestParam("file") MultipartFile file) {
		List<Integer> users= new ArrayList<>();
		List<User> usersobj= new ArrayList<>();
		try {
			System.out.println("##########upload########"+ dealid);

			int id_num;
       	      int password_num=0;
		       int status_num=0;
		       int username_num=0;
		       int email_num=0;
		       int user_num = 0;
		       InputStream inputStream =  new BufferedInputStream(file.getInputStream());
            //FileInputStream excelFile = inputStream;
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet datatypeSheet = workbook.getSheetAt(0);

            User user=new User();
            Row currentRow = datatypeSheet.getRow(0);

            int col_num = -1;

            for(int i=0; i < currentRow.getLastCellNum(); i++) {

				if(currentRow.getCell(i).getStringCellValue().trim().equals("user_id"))
                       user_num = i;

				if(currentRow.getCell(i).getStringCellValue().trim().equals("password"))
                    password_num = i;
				if(currentRow.getCell(i).getStringCellValue().trim().equals("status"))
                    status_num = i;
				if(currentRow.getCell(i).getStringCellValue().trim().equals("username"))
                    username_num = i;
				if(currentRow.getCell(i).getStringCellValue().trim().equals("email"))
                    email_num = i;
            }
            for (int j = 1 ;j<=datatypeSheet.getLastRowNum();j++){  
                Row row=datatypeSheet.getRow(j);
                user.setUserId((int) row.getCell(user_num).getNumericCellValue());
                user.setEmail(row.getCell(email_num).getStringCellValue());
                user.setPassword( row.getCell(password_num).getStringCellValue());
                user.setStatus( row.getCell(status_num).getStringCellValue());
                user.setUsername( row.getCell(username_num).getStringCellValue());
                userService.addUser(user);
                users.add(user.getUserId());
                usersobj.add(user);
                //sucessmsg=sucessmsg+"\n"+user.getUsername();
            }

            dealService.saveUserWithDeal(dealid, users);
        } catch (FileNotFoundException e) {
        	//sucessmsg="File Not Found";
            e.printStackTrace();
        } catch (IOException e) {
        	//sucessmsg=e.getLocalizedMessage();
            e.printStackTrace();
        }
		return usersobj;
	}*/
	/*@PostMapping(value="/questions/upload")
	public String uploadUser( @RequestParam("file") MultipartFile file) {

		try {

		    int questionIdnum=0;
		    int questionnum=0;
		    int responseTypenum=0;		   
		    int modulenum=0;
		    int impactnum=0;

		    int implicationOnArchitecturenum=0;
		    int implicationOnExecutionnum=0;
		    int implicationOnBusinessnum=0;

		    int industryRelevancenum=0;
		    int relevanceTonum = 0;
		    int radioCheckOptionsnum=0;
		    int isDealSpecificQtnum=0;

		       InputStream inputStream =  new BufferedInputStream(file.getInputStream());
            //FileInputStream excelFile = inputStream;
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet datatypeSheet = workbook.getSheetAt(0);

            Question questionObj=new Question();
            Row currentRow = datatypeSheet.getRow(0);

            int col_num = -1;

            for(int i=0; i < currentRow.getLastCellNum(); i++) {

				if(currentRow.getCell(i).getStringCellValue().trim().equals("questionId"))
					questionIdnum = i;

				if(currentRow.getCell(i).getStringCellValue().trim().equals("question"))
					questionnum = i;
				if(currentRow.getCell(i).getStringCellValue().trim().equals("responseType"))
					responseTypenum = i;
				if(currentRow.getCell(i).getStringCellValue().trim().equals("module"))
					modulenum = i;
				if(currentRow.getCell(i).getStringCellValue().trim().equals("impact"))
					impactnum = i;
				if(currentRow.getCell(i).getStringCellValue().trim().equals("implicationOnArchitecture"))
					implicationOnArchitecturenum = i;
				if(currentRow.getCell(i).getStringCellValue().trim().equals("implicationOnExecution"))
					implicationOnExecutionnum = i;
				if(currentRow.getCell(i).getStringCellValue().trim().equals("implicationOnBusiness"))
					implicationOnBusinessnum = i;

				if(currentRow.getCell(i).getStringCellValue().trim().equals("industryRelevance"))
					industryRelevancenum = i;
				if(currentRow.getCell(i).getStringCellValue().trim().equals("relevanceTo"))
					relevanceTonum = i;
				if(currentRow.getCell(i).getStringCellValue().trim().equals("radioCheckOptions"))
					radioCheckOptionsnum = i;
				if(currentRow.getCell(i).getStringCellValue().trim().equals("isDealSpecificQtn"))
					isDealSpecificQtnum = i;
            }
            for (int j = 1 ;j<=datatypeSheet.getLastRowNum();j++){  
                Row row=datatypeSheet.getRow(j);
              //  questionObj.setQuestionId((int) row.getCell(questionIdnum).getNumericCellValue());
                questionObj.setQuestion( row.getCell(questionnum).getStringCellValue());
                questionObj.setResponseType( row.getCell(responseTypenum).getStringCellValue());
                questionObj.setModule(new ArrayList<String>(Arrays.asList(row.getCell(modulenum).getStringCellValue().split(","))) );
                questionObj.setImpact(new ArrayList<String>(Arrays.asList(row.getCell(impactnum).getStringCellValue().split(","))) );
                questionObj.setImplicationOnArchitecture( row.getCell(implicationOnArchitecturenum).getStringCellValue());
                questionObj.setImplicationOnExecution( row.getCell(implicationOnExecutionnum).getStringCellValue());
                questionObj.setImplicationOnBusiness( row.getCell(implicationOnBusinessnum).getStringCellValue());
                questionObj.setIndustryRelevance(new ArrayList<String>(Arrays.asList(row.getCell(industryRelevancenum).getStringCellValue().split(","))) );
                questionObj.setRelevanceTo( row.getCell(relevanceTonum).getStringCellValue());
                questionObj.setRadioCheckOptions( row.getCell(radioCheckOptionsnum).getStringCellValue());
                questionObj.setIsDealSpecificQtn( row.getCell(isDealSpecificQtnum).getStringCellValue());
                questionService.addQuestion(questionObj);

                //sucessmsg=sucessmsg+"\n"+user.getUsername();
            }


        } catch (FileNotFoundException e) {
        	//sucessmsg="File Not Found";
            e.printStackTrace();
        } catch (IOException e) {
        	//sucessmsg=e.getLocalizedMessage();
            e.printStackTrace();
        }
		return "Question Uploaded";
	} */
/*	  @GetMapping("/users/getUserModuleProgress/{dealId}")
	    public Map<String,List<ModuleProgress>> getModuleProgress(@PathVariable int dealId) {
	    	//List<ModuleProgress>  md = questionService.getModuleProgress(module,dealId);
	    	return userService.getModuleProgress(dealId);
	        
	    }*/
}
