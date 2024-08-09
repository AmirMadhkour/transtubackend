package com.transtu.spring.datajpa.service;

import java.util.List;
import java.util.Optional;

import com.transtu.spring.datajpa.model.UserGeneral;
import com.transtu.spring.datajpa.dtos.UserGeneralUpdatedDTO;

public interface UserGeneralService {

	List <UserGeneral> getAllUsers(String login);
	Optional<UserGeneral> getUserById(Long id);
	UserGeneral createUser(UserGeneral user);
	Optional<UserGeneral> updateUser(Long id , UserGeneralUpdatedDTO userUpdatedDTO);
	void deleteUser(Long id);
	void deleteAllUsers();
	
}
