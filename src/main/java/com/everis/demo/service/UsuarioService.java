package com.everis.demo.service;

import com.everis.demo.auth.BusinessException;
import com.everis.demo.dto.UserDTO;
import com.everis.demo.dto.UsuarioDTO;
import com.everis.demo.entity.Usuario;

public interface UsuarioService {


    public Usuario addUsuario(UsuarioDTO user) throws BusinessException;

    public UserDTO getUsuario(String name, String password) throws BusinessException;
}
