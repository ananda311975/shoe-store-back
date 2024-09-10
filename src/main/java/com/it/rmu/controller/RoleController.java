package com.it.rmu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.it.rmu.model.RoleRequestModel;
import com.it.rmu.model.RoleResponeModel;

import com.it.rmu.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
    private RoleService roleService;

    @GetMapping("/getById")
    public RoleResponeModel getById(@RequestParam Integer id) {

        return roleService.getById(id);
    }
    
    @GetMapping("/getAll")
    public  List<RoleResponeModel> getAll(){
    	
    	return roleService.getAll();
    }
    
    @PostMapping("/save")
    public void save(@RequestBody RoleResponeModel request) {
    	 roleService.save(request);
    }
    
    @PutMapping("/update")
    public void update(@RequestBody RoleRequestModel request) {
        roleService.update(request);
    } 
    
    @DeleteMapping("/delete")
    public void delete(@RequestParam(name = "id") Integer id) {
    	roleService.delete(id);
    }

   
	
}
