package com.example.demo.controller;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Account;
import com.example.demo.model.Role;
import com.example.demo.repository.FunctionRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.service.AccountDetailService;
import com.example.demo.service.FunctionService;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;



@RestController
@RequestMapping("api/v1/role")
public class RoleController {
    @Autowired
    private FunctionService functionService;
    @Autowired
    private AccountDetailService accountDetailService;
    @Autowired
    private FunctionRepository functionRepository;

    @GetMapping("/random2")
    public String randomStuff(){

        String role_name =accountDetailService.getCurrentUserRole().getName();
        String function_name="get random2";
        int code=functionService.findCodeFunctionByRole(role_name,function_name);
        if(code==3) {
            return "hello";
        }
        else{
            throw  new NotFoundException("role không có quyền truy cập api");
    }
    }
}
