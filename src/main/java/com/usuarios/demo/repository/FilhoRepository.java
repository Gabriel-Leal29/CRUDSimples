package com.usuarios.demo.repository;

import com.usuarios.demo.model.Filho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilhoRepository extends JpaRepository<Filho, Long> {

    @Query("SELECT f FROM Filho f WHERE f.pai.id = :idPai")
    List<Filho> buscarFilhosPorPai(@Param("idPai") Long idPai);
}
