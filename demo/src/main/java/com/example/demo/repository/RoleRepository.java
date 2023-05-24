package com.example.demo.repository;

import com.example.demo.model.Function;
import com.example.demo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);
    List<Role> findAllById(Long id);
    List<Role> findByAccountId(Long accountId);



}
