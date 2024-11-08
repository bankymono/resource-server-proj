package com.bankymono.resourcer_server_proj.service;


import com.bankymono.resourcer_server_proj.model.Workout;
import com.bankymono.resourcer_server_proj.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutService {
    @Autowired
    private WorkoutRepository workoutRepository;

//    @PreAuthorize("#workout.user == authentication.name")
    @PreAuthorize("#workout.user == authentication.name and#oauth2.hasScope('fitnessapp')")
    public void saveWorkout(Workout workout) {
        workoutRepository.save(workout);
    }

    public List<Workout> findWorkouts() {
        return workoutRepository.findAllByUser();
    }

    public void deleteWorkout(Integer id) {
        workoutRepository.deleteById(id);
    }

}
