package com.it.rmu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.rmu.entity.UserDetailEntity;
import com.it.rmu.entity.UserEntity;
import com.it.rmu.model.LoginResponseModel;
import com.it.rmu.repository.UserDetailRepository;
import com.it.rmu.repository.UserRepository;

@Service
public class LoginService {
	
	@Autowired
	UserRepository userRepository ;
	
	@Autowired
	UserDetailRepository userDetailRepository ;
	
	 public LoginResponseModel authen(String userName, String password) {

	        LoginResponseModel response = null;

	        UserEntity userEntity = userRepository.findByUserNameAndPassword(userName, password);

	        if(null != userEntity) {
	            response = new LoginResponseModel();

	            response.setUserId(userEntity.getId());
	            response.setUserName(userEntity.getUserName());
	            response.setPassword(userEntity.getPassword());
	            response.setRoleId(userEntity.getRoleId());
	            response.setStatus(userEntity.getStatus());

	            UserDetailEntity userDetailEntity = userDetailRepository.findByUserId(userEntity.getId());
	            if(null != userDetailEntity) {
	                response.setFristName(userDetailEntity.getFristName());
	                response.setLastName(userDetailEntity.getLastName());
	                response.setPhone(userDetailEntity.getPhone());
	                response.setAge(userDetailEntity.getAge());
	            }

	        }


	        return response;
	    }

}
