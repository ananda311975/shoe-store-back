package com.it.rmu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.rmu.entity.UserDetailEntity;
import com.it.rmu.entity.UserEntity;
import com.it.rmu.model.ManageUserResponseModel;
import com.it.rmu.repository.UserDetailRepository;
import com.it.rmu.repository.UserRepository;

@Service
public class ManageUserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserDetailRepository userDetailRepository;

	public List<ManageUserResponseModel> getAllUser(){

	List<ManageUserResponseModel> response = null;

	List<UserEntity> userEntityList = userRepository.findAllUser();

	if(null != userEntityList) {

	response = new ArrayList<>();

	for(UserEntity user : userEntityList) {

	ManageUserResponseModel responseObject = new ManageUserResponseModel();

	responseObject.setUserId(user.getId());
	responseObject.setUserName(user.getUserName());
	responseObject.setPassword(user.getPassword());
	responseObject.setRoleId(user.getRoleId());
	responseObject.setStatus(user.getStatus());



	UserDetailEntity userDetail = userDetailRepository.findByUserId(user.getId());

	if(null != userDetail) {
	responseObject.setFristName(userDetail.getFristName());
	responseObject.setLastName(userDetail.getLastName());
	responseObject.setPhone(userDetail.getPhone());
	responseObject.setAge(userDetail.getAge());
	}


	response.add(responseObject);
	}
	}


	return response;
	}

}
