package com.modelo.seguridad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.modelo.seguridad.model.permission_role;

public interface Ipermission_role extends JpaRepository<permission_role, Integer> {
    @Query("SELECT pr FROM permission_role pr WHERE pr.role.id = ?1 AND pr.page.id = ?2")
    List<permission_role> findByRoleIdAndPageId(Integer roleId, Integer pageId);


}
