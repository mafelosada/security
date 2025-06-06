package com.modelo.seguridad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.modelo.seguridad.model.Recovery_requests;

public interface Irecovery_request extends JpaRepository<Recovery_requests, Integer> {
    @Query("SELECT r FROM recovery_request r WHERE r.email = ?1")
    List<Recovery_requests> findByEmail(String email);
}
