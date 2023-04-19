package com.a2m.demoJwtToken.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.a2m.demoJwtToken.dao.UserDAO;
import com.a2m.demoJwtToken.dao.roles_userDAO;
import org.springframework.security.core.userdetails.User;
import com.a2m.demoJwtToken.entity.roles_user;
import com.a2m.demoJwtToken.entity.user;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserDAO userdao;
	
	@Autowired
	roles_userDAO rolesuserdao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		user userr = userdao.SelectUserByUsername(username);
		
		if(userr == null) {
			System.out.println("account not found! " + username);
			throw new UsernameNotFoundException("Account " + username + " was not found in the database");
		}
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		
		List<String> roles = rolesuserdao.SelectUserRolesByID(userr.getId());
		
		if (roles != null) {
			for (String role : roles) {
				GrantedAuthority authority = new SimpleGrantedAuthority(role);
				grantedAuthorities.add(authority);
			}
		}
		UserDetails userDetails = (UserDetails) new User(userr.getEmail(), userr.getPassword(),grantedAuthorities);
		return userDetails;
	}

}
