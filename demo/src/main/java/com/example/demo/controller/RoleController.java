package com.example.demo.controller;

import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.FunctionRepository;
import com.example.demo.service.AccountDetailService;
import com.example.demo.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("api/v1/role")
public class RoleController {
    @Autowired
    private FunctionService functionService;
    @Autowired
    private AccountDetailService accountDetailService;
    @Autowired
    private FunctionRepository functionRepository;


    // test phân quyền API

    /**
     * Login : username:keuadmin, password:123456
     *role :admin
     */
    @GetMapping("/random")
    public String randomStuff(){

        String role_name =accountDetailService.getCurrentUserRole().getName();
        String function_name="get random by admin";
        int code=functionService.findCodeFunctionByRole(role_name,function_name);
        if(code==2) {
            return "API for admin";
        }
        else{
            throw  new NotFoundException("role không có quyền truy cập api");
    }
    }
    /**
     * Login : username:keuuser, password:123456
     *role :user
     */
    @GetMapping("/random2")
    public String randomStuff1(){

        String role_name =accountDetailService.getCurrentUserRole().getName();
        String function_name="get random by user";
        int code=functionService.findCodeFunctionByRole(role_name,function_name);
        if(code==3) {
            return "API for user";
        }
        else{
            throw  new NotFoundException("role không có quyền truy cập api");
        }
    }

}
