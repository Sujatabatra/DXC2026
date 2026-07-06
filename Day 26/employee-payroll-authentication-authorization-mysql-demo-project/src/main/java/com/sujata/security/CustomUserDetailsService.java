package com.sujata.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sujata.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final UserRepository repository;

	public CustomUserDetailsService(@Autowired UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		com.sujata.entity.User appUser = repository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found : " + username));

		return new CustomUserDetails(appUser);
	}

}