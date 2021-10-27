package com.everis.demo.repository;

import com.everis.demo.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {


    @Query(value = "select u from Usuario u where u.userName = :userName and userPassword = :userPassword ")
    public Usuario findNamePassword(@Param("userName") String userName, @Param("userPassword") String userPassword);

}
