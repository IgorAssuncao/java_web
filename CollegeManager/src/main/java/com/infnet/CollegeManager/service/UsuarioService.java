package com.infnet.CollegeManager.service;

import com.infnet.CollegeManager.model.UsuarioModel;
import com.infnet.CollegeManager.repository.UsuarioRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    private UsuarioRepository repoUsuario;
    
    public List<UsuarioModel> listAll() {
        return repoUsuario.findAll();
    }
    
    public void save(UsuarioModel usuario) {
        repoUsuario.save(usuario);
    }
    
    public UsuarioModel get(Long id) {
        return repoUsuario.findById(id).get();
    }
    
    public void delete(Long id) {
        repoUsuario.deleteById(id);
    }
    
    public void alterarUsuario(String nome, String email, Long id) {
        repoUsuario.update(nome, email, id);
    }
    
    public boolean login(String email, String senha) {
        UsuarioModel usuarioModel = repoUsuario.findOne(email);
        return usuarioModel.getSenha().equals(senha);
    }
}
