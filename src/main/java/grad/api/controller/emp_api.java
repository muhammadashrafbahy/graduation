package grad.api.controller;

import grad.api.CRUD.*;
import grad.api.Entities.*;

import java.util.ArrayList;
import java.util.List;


import java.security.Principal;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping(value="/emp")
public class emp_api {
	
	

	@RequestMapping(value="/all_tasks/{id}", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public  List<task> get_alltasks(@PathVariable("id") int id   ){
	employee_crud cr = new employee_crud();
	
		
	return cr.get_ALlTasks(id);	
	}
	
	@RequestMapping(value="/show_profile/{id}", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public  employee show_profile(@PathVariable("id") int id){
	employee_crud cr = new employee_crud();
	
		
	return cr.get_empl(id);	
	}
	
	@RequestMapping(value="/update_profile/{id}", method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	public  employee update_profile(@PathVariable("id") int id, @RequestBody employee emp){
	employee_crud cr = new employee_crud();
	
		
	
			cr.update_empl(id, emp);	
	return emp;
	}
	
	@RequestMapping(value="/update_task/{id}", method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	public  task update_task(@PathVariable("id") int id , @RequestBody task task){
	task_crud cr = new task_crud();
	cr.update_task(id, task);
		
	return task;	
	}
	
	@RequestMapping(value="/search_task/{id}", method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public  List<task> search_task(@PathVariable("id") int id , @RequestBody task task){
		employee_crud cr = new employee_crud();
		
		
	return cr.public_search_forEmp(task, id);	
	}
	
		
}
