package com.infnet.CollegeManager.repository;

import com.infnet.CollegeManager.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    @Modifying
    @Query(value="Update usuarios SET nome=:nome, email=:email where id=:id", nativeQuery = true)
    public void update(@Param("nome") String nome, @Param("email") String email, @Param("id") Long id);

    @Query(value="select * from usuarios where email=:email", nativeQuery = true)
    public UsuarioModel findOne(@Param("email") String email);
    
}
