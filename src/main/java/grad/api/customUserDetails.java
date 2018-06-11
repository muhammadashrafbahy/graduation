package grad.api;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import grad.api.Entities.manager;

public class customUserDetails implements UserDetails {
  
	
	private String passwd;
	private String username;
	private int id;
	Collection<? extends GrantedAuthority> auth;
	
	
	
	
	public customUserDetails( manager mng) {

		
		this.username=mng.getComp_email();
	    this.passwd=mng.getComp_passwd();
	    this.id = mng.getId();
	
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
