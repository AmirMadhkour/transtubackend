package com.transtu.spring.datajpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transtu.spring.datajpa.dtos.UserGeneralUpdatedDTO;
import com.transtu.spring.datajpa.model.UserGeneral;
import com.transtu.spring.datajpa.repository.UserGeneralRepository;
import com.transtu.spring.datajpa.service.UserGeneralService;

import java.util.List;
import java.util.Optional;


@Service
public class UserGeneralServiceImpl implements UserGeneralService {

	@Autowired 
	private final UserGeneralRepository userGeneralRepository;
	
	public UserGeneralServiceImpl(UserGeneralRepository userGeneralRepository) {
		this.userGeneralRepository=userGeneralRepository;
	}
	
	@Override
	public List<UserGeneral> getAllUsers(String login) {
		
		if(login == null) {
			return userGeneralRepository.findAll();
		} else {
			return userGeneralRepository.findByLoginContaining(login);
		}
	}
	

	@Override
	public Optional<UserGeneral> getUserById(Long id) {
		return userGeneralRepository.findById(id);
	}

	
	@Override
	public UserGeneral createUser(UserGeneral user) {
		return userGeneralRepository.save(new UserGeneral(
				user.getLogin(),
				user.getFullName(),
	            user.getMail(),
	            user.getRole(),
	            user.getPassword(),
	            user.getTel(),
	            user.getLabel(),
	            user.getDistrict()
				));
	}

	
	@Override
	public Optional<UserGeneral> updateUser(Long id, UserGeneralUpdatedDTO userUpdatedDTO) {
	    Optional<UserGeneral> userData = userGeneralRepository.findById(id);
	    if (userData.isPresent()) {
	        UserGeneral _user = userData.get();
	        userUpdatedDTO.getLogin().ifPresent(_user::setLogin);
	        userUpdatedDTO.getFullName().ifPresent(_user::setFullName);
	        userUpdatedDTO.getMail().ifPresent(_user::setMail);
	        userUpdatedDTO.getRole().ifPresent(_user::setRole);
	        userUpdatedDTO.getPassword().ifPresent(_user::setPassword);
	        userUpdatedDTO.getTel().ifPresent(_user::setTel);
	        userUpdatedDTO.getLabel().ifPresent(_user::setLabel);
	        userUpdatedDTO.getDistrict().ifPresent(_user::setDistrict);
	        return Optional.of(userGeneralRepository.save(_user));
	    } else {
	        return Optional.empty();
	    }
	}


	
	
	@Override
    public void deleteUser(Long id) {
        userGeneralRepository.deleteById(id);
    }

    @Override
    public void deleteAllUsers() {
        userGeneralRepository.deleteAll();
    }
	
}
