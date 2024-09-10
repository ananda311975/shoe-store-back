package com.it.rmu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.it.rmu.model.ResponseModel;
import com.it.rmu.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
    LoginService loginService;


    @GetMapping("/authen")
    public ResponseModel authen(@RequestParam(name = "userName") String username, @RequestParam(name = "password") String password) {
        ResponseModel response = new ResponseModel();

        try {
            // service
            response.setData(loginService.authen(username, password));
            response.setStatus("SUCCESS");
        } catch (Exception e) {
            // TODO: handle exception
            response.setStatus("ERROR");
            response.setMessage(e.getMessage());
        }

        return response;
    }
	}
