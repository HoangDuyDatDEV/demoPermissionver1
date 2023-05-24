package com.example.demo.service;

import com.example.demo.exception.NotFoundException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Function;
import com.example.demo.model.Role;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.FunctionRepository;
import com.example.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private FunctionRepository functionRepository;
//    public void saveRole(Long accountId, Role role) {
//        Role r= accountRepository.findById(accountId).map(account -> {role.setAccount(account);
//        return roleRepository.save(role);
//        }).orElseThrow(()->new ResourceNotFoundException("khong tim thay user"));
//
//
//    }

    public Role addFunctionToRole(Long roleId, Long functionId) {
        Set<Function> FunctionSet = null;
        Role role = roleRepository.findById(roleId).get();
        Function function = functionRepository.findById(functionId).get();
        FunctionSet =  role.getFunctions();
        FunctionSet.add(function);
        role.setFunctions(FunctionSet);
        return roleRepository.save(role);
    }
    public int findCodeFunctionByRole(String role_name, String function_name)
    {

            if( functionRepository.findFunctionCodeByRole(role_name,function_name)==null){
                throw  new NotFoundException("role không có quyền truy cập api");
            }
        return  functionRepository.findFunctionCodeByRole(role_name,function_name).getCode();
        }



}
