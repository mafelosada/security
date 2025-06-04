package com.modelo.seguridad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.modelo.seguridad.model.recovery_request;

public interface Irecovery_request extends JpaRepository<recovery_request, Integer> {
    @Query("SELECT r FROM recovery_request r WHERE r.email = ?1")
    List<recovery_request> findByEmail(String email);
}
