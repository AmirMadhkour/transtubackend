/*
 * package com.transtu.spring.datajpa.security;
 * 
 * import com.transtu.spring.datajpa.model.UserGeneral; import
 * com.transtu.spring.datajpa.repository.UserGeneralRepository; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.core.userdetails.UsernameNotFoundException;
 * import org.springframework.stereotype.Service;
 * 
 * @Service public class CustomUserDetailsService implements UserDetailsService
 * {
 * 
 * private final UserGeneralRepository userGeneralRepository;
 * 
 * public CustomUserDetailsService(UserGeneralRepository userGeneralRepository)
 * { this.userGeneralRepository = userGeneralRepository; }
 * 
 * @Override public UserDetails loadUserByUsername(String login) throws
 * UsernameNotFoundException { UserGeneral user =
 * userGeneralRepository.findByLogin(login) .orElseThrow(() -> new
 * UsernameNotFoundException("User not found")); return new
 * CustomUserDetails(user); } }
 */