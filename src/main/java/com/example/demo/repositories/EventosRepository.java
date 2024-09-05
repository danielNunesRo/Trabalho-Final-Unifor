package com.example.demo.repositories;

import com.example.demo.domain.Eventos;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventosRepository extends JpaRepository<Eventos, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Eventos e SET e.status = true WHERE e.id = :id")
    void updateStatusToTrueById(@Param("id") Long id);

    List<Eventos> findByStatusTrue();

}
