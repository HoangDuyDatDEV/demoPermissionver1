package com.example.demo.repository;

import com.example.demo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);
    Role findById(long id);
    List<Role> findAllById(Long id);
//    @Query(value = "select * from role where role.id =:roleID ",nativeQuery = true)
    Role getRoleById(Long roleID);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM role_function WHERE role_id =:role_id ;", nativeQuery = true)
    void deleteRoleFunction(Long role_id);
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Account WHERE roleID =:role_id ;", nativeQuery = true)
    void deleteAccountRole(Long role_id);



}
