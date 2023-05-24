package com.example.demo.repository;

import com.example.demo.model.Function;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FunctionRepository extends JpaRepository<Function,Long> {
   List<Function> findAllById(Long id);
   @Query(value = "select f.id as id, f.name as name,f.code as code,f.url as url from function f,role_function rf,role r where r.name=:role_name and r.id=rf.role_ID and rf.function_ID =f.id and f.name=:function_name ;",nativeQuery = true)
   Function findFunctionCodeByRole(String role_name,String function_name);
   @Query(value = "select f.* from function f,role_function rf,role r where r.name=:role_name and r.id=rf.role_id and rf.function_id =f.id" ,nativeQuery = true)
   List<Function> findFunctionByRoleName(String role_name);
}
