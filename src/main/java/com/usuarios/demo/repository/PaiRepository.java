package com.usuarios.demo.repository;

import com.usuarios.demo.model.Pai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaiRepository extends JpaRepository <Pai, Long> {
}
