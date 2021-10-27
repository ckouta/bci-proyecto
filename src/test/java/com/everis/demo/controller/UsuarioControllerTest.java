
package com.everis.demo.controller;


import com.everis.demo.controller.UsuarioController;
import com.everis.demo.dto.PhoneDTO;
import com.everis.demo.dto.UsuarioDTO;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UsuarioControllerTest {

    @Autowired
    UsuarioController usuarioController;
    
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }


    /**
     * Test of addUsuario method, of class UsuarioController.
     */
    @Test
    public void testAddUsuario() throws Exception {
        System.out.println("addUsuario");
        UsuarioDTO user = UsuarioDTO.builder().id("123").name("alvaro").email("prueba@gmail.com").password("Prueba123").phones(new ArrayList<PhoneDTO>()).build();
        ResponseEntity<?> dto = usuarioController.addUsuario(user);
        assertNotNull(dto);
    }



}
