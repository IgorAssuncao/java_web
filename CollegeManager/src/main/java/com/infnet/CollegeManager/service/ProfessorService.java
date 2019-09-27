package com.infnet.CollegeManager.service;

import com.infnet.CollegeManager.model.ProfessorModel;
import com.infnet.CollegeManager.repository.ProfessorRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProfessorService {
    @Autowired
    private ProfessorRepository repoProfessor;
    
    public List<ProfessorModel> listAll() {
        return repoProfessor.findAll();
    }
    
    public void save(ProfessorModel professor) {
        repoProfessor.save(professor);
    }
}
