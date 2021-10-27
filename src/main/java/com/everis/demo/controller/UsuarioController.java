package com.everis.demo.controller;


import com.everis.demo.dto.ErrorDTO;
import com.everis.demo.entity.Usuario;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.everis.demo.auth.BusinessException;
import com.everis.demo.dto.UsuarioDTO;
import com.everis.demo.service.UsuarioService;


@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
public class UsuarioController {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/usuario")
    public ResponseEntity<?> addUsuario(@RequestBody UsuarioDTO user) {
        try {
            return new ResponseEntity<Usuario>(usuarioService.addUsuario(user),HttpStatus.CREATED);
        }catch (BusinessException e){
            return new ResponseEntity<ErrorDTO>(ErrorDTO.builder().mensaje(e.getMensaje()).build(),HttpStatus.BAD_REQUEST);
        }
    }

}
