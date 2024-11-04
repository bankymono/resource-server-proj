package com.bankymono.resourcer_server_proj.repository;

import com.bankymono.resourcer_server_proj.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkoutRepository extends JpaRepository<Workout, Integer> {

    @Query("SELECT w from Workout w where w.user = ?#{authentication.name}")
    List<Workout> findAllByUser();
}
