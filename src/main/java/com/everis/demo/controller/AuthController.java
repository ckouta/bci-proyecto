
package com.everis.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.everis.demo.auth.BusinessException;
import com.everis.demo.dto.UserDTO;
import com.everis.demo.service.UsuarioService;


@RestController
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public UserDTO login(@RequestParam("user") String username, @RequestParam("password") String password) throws BusinessException{
        return usuarioService.getUsuario(username, password);
    }

}
