package com.modelo.seguridad.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.modelo.seguridad.model.user;

public interface Iuser extends JpaRepository<user, Integer> {
    Optional<user> findByUsername(String username);

    Optional<user> findByEmail(String email);

    List<user> findAllByEnabled(boolean enabled);

}
