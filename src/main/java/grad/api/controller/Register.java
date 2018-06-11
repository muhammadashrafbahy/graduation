package grad.api.controller;

import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import grad.api.CRUD.mng_CRUD;
import grad.api.Entities.manager;

@CrossOrigin 
@RestController
public class Register {

    mng_CRUD mcr = new mng_CRUD();
  
 
    
    
    @RequestMapping (value = "/register" ,method = RequestMethod.POST)
    public  ResponseEntity<manager> register (@Valid @RequestBody manager mng){
           
  
           mcr.add_mng(mng);
           
           HttpHeaders http = new HttpHeaders();
           http.add("token", "bahy");
           
    return new ResponseEntity<manager>(mng,http,HttpStatus.ACCEPTED);
    
    
    }  
    
}