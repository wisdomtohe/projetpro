package com.ipnetinstitute.csc394.backend.security;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ipnetinstitute.csc394.backend.entity.Role;
import com.ipnetinstitute.csc394.backend.entity.User;
import com.ipnetinstitute.csc394.backend.dao.UserEntityRepository;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserEntityRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("User '" + username + "' not found.");
		}
		
		//**********************************
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

		try {
			// roles are lazy fetched
			Hibernate.initialize(user.getRole());
			if (user.getRole() != null) {
				for (Role role : user.getRole()) {
					grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
				}
			}
		} catch (Throwable t) {
			// ignore, probably there a re no roles
		}

		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				grantedAuthorities);
		//*********************************************
		
		
	}
	
	public UserLogin getUserByEmail(String email) {
		User user = userRepository.findByEmail(email);
		
		if(user != null) {
			Set<Role> roles = user.getRole();
			UserLogin userLogin = new UserLogin();
			
			userLogin.setUsername(user.getEmail());
			userLogin.setUserpwd(user.getPassword());
			
			Set<String> uroles = new HashSet<String>();
			for(Role role: roles)
			uroles.add(role.getName());
			
			userLogin.setRoles(uroles);
			
			return userLogin;
		}
		
		return null;
	}

}