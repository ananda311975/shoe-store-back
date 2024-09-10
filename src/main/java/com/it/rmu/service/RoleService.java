package com.it.rmu.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.rmu.entity.RoleEntity;
import com.it.rmu.model.RoleRequestModel;
import com.it.rmu.model.RoleResponeModel;
import com.it.rmu.repository.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
    private RoleRepository roleRepository;
	
	public RoleResponeModel getById(Integer id) {
		//ดึงบข้อมูล
		Optional<RoleEntity> roleEntity =  roleRepository.findById(id);
		
		RoleResponeModel response = new RoleResponeModel();
		
		if (roleEntity.isPresent()) {
			response = new RoleResponeModel();
			RoleEntity entity = roleEntity.get();
			
			response.setId(entity.getId());
            response.setRoleName(entity.getRoleName());
            response.setRoleDescription(entity.getRoleDescription());
            response.setStatus(entity.getStatus());

		}else {
			
		}
		//Model
		return response;
	}
	public List<RoleResponeModel> getAll(){

        List<RoleEntity> roleEntityList = roleRepository.findAll();
        List<RoleResponeModel> responseList = null;
        if(null != roleEntityList) {
            responseList = new ArrayList<>();

            for(RoleEntity roleEntity : roleEntityList) {
                RoleResponeModel roleObj = new RoleResponeModel();
                roleObj.setId(roleEntity.getId());
                roleObj.setRoleName(roleEntity.getRoleName());
                roleObj.setRoleDescription(roleEntity.getRoleDescription());
                roleObj.setStatus(roleEntity.getStatus());
                responseList.add(roleObj);
            }
        }

        return responseList;
    }
	public void save(RoleResponeModel request) {
		
		if(null != request ) {
			
			RoleEntity entity= new RoleEntity();
			
			entity.setRoleName(request.getRoleName());
            entity.setRoleDescription(request.getRoleDescription());
            entity.setStatus(request.getStatus());
            entity.setCreateBy("JOEY");
            entity.setCreateDate(new Date());
            entity.setUpdateBy("JOEY");
            entity.setUpdateDate(new Date());

            roleRepository.save(entity);
			
		}
		}
	public void update(RoleRequestModel request) {

        if(null != request) {
            if(null != request.getId()) {

                Optional<RoleEntity> roleEntity =  roleRepository.findById(request.getId());

                if(roleEntity.isPresent()) {
                    RoleEntity entity = roleEntity.get();
                    entity.setRoleName(request.getRoleName());
                    entity.setRoleDescription(request.getRoleDescription());
                    entity.setStatus(request.getStatus());
                    roleRepository.save(entity);
                }
            }
        }
    }
	
	   public void delete(Integer id) {

	        roleRepository.deleteById(id);

	    }
	
	
}

