package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class RoleService {
   @Autowired
    private RoleRepository roleRepository;
   public List<Role> getAllRoles(){
       return roleRepository.findAll();
   }
   public Role saveRole(Role role){
       return roleRepository.save(role);
   }

    public void deleteRole(Long roleID) {
       roleRepository.deleteAccountRole(roleID);
       roleRepository.deleteRoleFunction(roleID);
       roleRepository.deleteById(roleID);
    }

}
