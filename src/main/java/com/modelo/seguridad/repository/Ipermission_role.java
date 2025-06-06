package com.modelo.seguridad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.modelo.seguridad.model.Permission_roles;

public interface Ipermission_role extends JpaRepository<Permission_roles, Integer> {
    @Query("SELECT pr FROM permission_role pr WHERE pr.role.id = ?1 AND pr.page.id = ?2")
    List<Permission_roles> findByRoleIdAndPageId(Integer roleId, Integer pageId);


}
