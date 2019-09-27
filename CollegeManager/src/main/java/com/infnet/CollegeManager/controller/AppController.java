package com.infnet.CollegeManager.controller;

import com.infnet.CollegeManager.model.AlunoModel;
import com.infnet.CollegeManager.model.ProfessorModel;
import com.infnet.CollegeManager.model.UsuarioModel;
import com.infnet.CollegeManager.service.AlunoService;
import com.infnet.CollegeManager.service.ProfessorService;
import com.infnet.CollegeManager.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AppController {
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private AlunoService alunoService;
    
    @Autowired
    private ProfessorService professorService;
    
    @GetMapping("/")
    public ModelAndView index(Model model) {
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }
    
    @PostMapping("/login")
    public ModelAndView login(Model model, @ModelAttribute("usuario") UsuarioModel usuario) {
        Boolean erroLogin = false;
        ModelAndView mav = new ModelAndView("redirect:/usuarios");
        if (!usuarioService.login(usuario.getEmail(), usuario.getSenha())) {
            erroLogin = true;
            mav = new ModelAndView("redirect:/");
            mav.addObject("erroLogin", erroLogin);
        }
        return mav;
    }
    
    @GetMapping("/usuarios")
    public ModelAndView viewUsuario(Model model) {
        ModelAndView mav = new ModelAndView("usuarios");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<UsuarioModel>> response = restTemplate.exchange("http://localhost:8080/api/usuarios",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<UsuarioModel>>(){});
        model.addAttribute("listaUsuarios", response.getBody());
        return mav;
    }
    
    @GetMapping("/api/usuarios")
    public List<UsuarioModel> viewUsuarioApi() {
        return usuarioService.listAll();
    }
    
    @GetMapping("/usuarios/newUsuario")
    public ModelAndView newUsuarioView(Model model) {
        model.addAttribute(new UsuarioModel());
        return new ModelAndView("new_usuario");
    }
    
    @PostMapping("/usuarios/newUsuarioPost")
    public ModelAndView newUsuario(@ModelAttribute("usuarioModel") UsuarioModel usuario) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            restTemplate.postForObject("http://localhost:8080/api/usuarios/newUsuario",
                    usuario,
                    ResponseEntity.class);
        } catch (Exception e) {}
        return new ModelAndView("redirect:/usuarios");
    }
    
    @PostMapping("/api/usuarios/newUsuario")
    public UsuarioModel newUsuarioApi(@RequestBody UsuarioModel usuario) {
        try {
            usuarioService.save(usuario);
            return usuario;
        } catch (Exception e) {
            usuario.setMatricula(0);
            usuario.setEmail("ERROR");
            usuario.setNome("ERROR");
            return usuario;
        }
    }
    
    @PostMapping("/usuarios/salvar")
    public ModelAndView salvarUsuario(@ModelAttribute("usuarioModel") UsuarioModel usuario) {
        ModelAndView mav = new ModelAndView("redirect:/usuarios");
        usuarioService.save(usuario);
        return mav;
    }
    
    @GetMapping("/usuarios/editUsuario/{id}")
    public ModelAndView editUsuario(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_usuario");
        UsuarioModel usuarioModel = usuarioService.get(id);
        mav.addObject("usuarioModel", usuarioModel);
        return mav;
    }
    
    @GetMapping("/usuarios/deleteUsuario/{id}")
    public ModelAndView deleteUsuario(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("redirect:/usuarios");
        try {
            usuarioService.delete(id);
        } catch (Exception e) {
            mav = new ModelAndView("redirect:/error_delete");
        }
        return mav;
    }
    
    @GetMapping("/alunos")
    public ModelAndView viewAlunos(Model model) {
        ModelAndView mav = new ModelAndView("alunos");
        model.addAttribute("listaAlunos", alunoService.listAll());
        return mav;
    }
    
    @GetMapping("/alunos/newAluno")
    public ModelAndView newAluno(Model model) {
        ModelAndView mav = new ModelAndView("new_aluno");
        AlunoModel alunoModel = new AlunoModel();
        mav.addObject("alunoModel", alunoModel);
        mav.addObject("listaUsuarios", usuarioService.listAll());
        return mav;
    }
    
    @PostMapping("/alunos/salvar")
    public ModelAndView salvarAluno(@ModelAttribute("alunoModel") AlunoModel aluno) {
        ModelAndView mav = new ModelAndView("redirect:/alunos");
        alunoService.save(aluno);
        return mav;
    }
    
    @GetMapping("/professores")
    public ModelAndView viewProfessores(Model model) {
        ModelAndView mav = new ModelAndView("professores");
        model.addAttribute("listaProfessores", professorService.listAll());
        return mav;
    }
    
    @GetMapping("/professores/newProfessor")
    public ModelAndView newProfessor(Model model) {
        ModelAndView mav = new ModelAndView("new_professor");
        ProfessorModel professorModel = new ProfessorModel();
        mav.addObject("professorModel", professorModel);
        mav.addObject("listaUsuarios", usuarioService.listAll());
        return mav;
    }
    
    @PostMapping("/professores/salvar")
    public ModelAndView salvarProfessor(@ModelAttribute("professorModel") ProfessorModel professor) {
        ModelAndView mav = new ModelAndView("redirect:/professores");
        professorService.save(professor);
        return mav;
    }
}
