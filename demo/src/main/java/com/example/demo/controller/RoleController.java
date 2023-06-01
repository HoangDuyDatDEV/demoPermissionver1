package com.example.demo.controller;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Role;
import com.example.demo.repository.FunctionRepository;
import com.example.demo.service.AccountDetailService;
import com.example.demo.service.FunctionService;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/v1/role")

public class RoleController {
    @Autowired
    private FunctionService functionService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private AccountDetailService accountDetailService;


    @GetMapping("/getAllRoles")
    public List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }
    @PostMapping("/saveRole")
    public ResponseEntity createRole(@RequestBody  Role role){
        roleService.saveRole(role);
        return new  ResponseEntity(HttpStatus.OK);
    }
    @DeleteMapping("/deleteRole/{roleId}")
    public ResponseEntity removeFunction(@PathVariable Long roleId) {
        roleService.deleteRole(roleId);
        return new ResponseEntity(HttpStatus.OK);
    }


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
