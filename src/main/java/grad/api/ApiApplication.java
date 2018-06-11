package grad.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import grad.api.CRUD.employee_crud;
import grad.api.CRUD.mng_CRUD;


@SpringBootApplication
//@EnableAutoConfiguration
//@ComponentScan({"grad.api","grad.api.CRUD","grad.api.authorization"})
//
//@EnableJpaRepositories("grad.api.CRUD")
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Autowired
public void authenticationManager(AuthenticationManagerBuilder builder , mng_CRUD repo ) throws Exception {
	builder.userDetailsService(s -> new customUserDetails(repo.check_mngr(s)));
	
	
} 	
	
	
	@Autowired
public void authenticationManager_emp(AuthenticationManagerBuilder builder , employee_crud repo ) throws Exception {
	builder.userDetailsService(s -> new CustomEmployeeDetails(repo.check_employee(s)) );
	
	
} 	
}