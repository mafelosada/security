package com.modelo.seguridad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.modelo.seguridad.model.page;

public interface Ipage extends JpaRepository<page, Integer> {
    @Query("SELECT p FROM page p WHERE p.name = ?1")
    List<page> findByName(String name);

}
