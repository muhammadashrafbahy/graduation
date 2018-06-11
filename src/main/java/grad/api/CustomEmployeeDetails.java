package grad.api;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import grad.api.Entities.employee;

public class CustomEmployeeDetails implements UserDetails {
	  
	
		private String passwd;
		private String email;
		private int id;
		Collection<? extends GrantedAuthority> auth;
		
		
		
		
		public CustomEmployeeDetails ( employee emp) {

			
			this.email=emp.getEmp_email();
		    this.passwd=emp.getEmp_passwd();
		    this.id = emp.getEmp_id();
		
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			// TODO Auto-generated method stub
			return auth;
		}

		@Override
		public String getPassword() {
			// TODO Auto-generated method stub
			return passwd;
		}

		@Override
		public String getUsername() {
			// TODO Auto-generated method stub
			return id+"";
		}

		@Override
		public boolean isAccountNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean isEnabled() {
			// TODO Auto-generated method stub
			return true;
		}


}
