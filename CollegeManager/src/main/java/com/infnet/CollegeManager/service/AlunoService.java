package com.infnet.CollegeManager.service;

import com.infnet.CollegeManager.model.AlunoModel;
import com.infnet.CollegeManager.repository.AlunoRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AlunoService {
    @Autowired
    private AlunoRepository repoAluno;
    
    public List<AlunoModel> listAll() {
        return repoAluno.findAll();
    }
    
    public void save(AlunoModel aluno) {
        repoAluno.save(aluno);
    }
}
