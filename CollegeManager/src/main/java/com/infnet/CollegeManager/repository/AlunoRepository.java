package com.infnet.CollegeManager.repository;

import com.infnet.CollegeManager.model.AlunoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<AlunoModel, Long> {
    
}
