package com.infnet.CollegeManager.repository;

import com.infnet.CollegeManager.model.ProfessorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<ProfessorModel, Long> {
    
}
