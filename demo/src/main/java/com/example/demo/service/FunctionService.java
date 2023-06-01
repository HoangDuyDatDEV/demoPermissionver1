package com.example.demo.service;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Function;
import com.example.demo.model.Role;
import com.example.demo.repository.FunctionRepository;
import com.example.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class FunctionService {
   @Autowired
    private FunctionRepository functionRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private AccountDetailService accountDetailService;
    public Function saveFunction(@RequestParam Long roleId, Function function) {
        Set<Role> roles = new HashSet<>();
        Role role =roleRepository.findById(roleId).orElse(null);
        System.out.println(role);
        roles.add(role);
        function.setRoles(roles);
        return functionRepository.save(function);
    }


    public List<Function> getFunctionDetails(Long FunctionId) {
        if (null != FunctionId) {
            return functionRepository.findAllById(FunctionId);
        } else {
            return functionRepository.findAll();
        }
    }

    public void deleteFunction(Long FunctionId) {
        this.functionRepository.deleteFunctionRole(FunctionId);

        functionRepository.deleteById(FunctionId);
    }

    public int findCodeFunctionByRole(String role_name, String function_name)
    {

        if( functionRepository.findFunctionCodeByRole(role_name,function_name)==null){
            throw  new NotFoundException("role không có quyền truy cập api");
        }
        return  functionRepository.findFunctionCodeByRole(role_name,function_name).getCode();
    }

    public List<Function> findFunctionByRoleID(Long roleID){
        return functionRepository.findFunctionByRoleID(roleID);
    }
}
