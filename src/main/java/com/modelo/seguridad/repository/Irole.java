package com.modelo.seguridad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.modelo.seguridad.model.role;

public interface Irole extends JpaRepository<role, Integer> {

}
