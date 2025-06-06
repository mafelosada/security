package com.modelo.seguridad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.modelo.seguridad.model.Pages;

public interface Ipage extends JpaRepository<Pages, Integer> {
    @Query("SELECT p FROM page p WHERE p.name = ?1")
    List<Pages> findByName(String name);

}
