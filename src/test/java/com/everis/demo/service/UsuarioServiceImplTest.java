
package com.everis.demo.service;

import com.everis.demo.auth.BusinessException;
import com.everis.demo.dto.PhoneDTO;
import com.everis.demo.dto.UsuarioDTO;
import com.everis.demo.entity.Usuario;
import com.everis.demo.repository.PhoneRepository;
import com.everis.demo.repository.UsuarioRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UsuarioServiceImplTest {

    @MockBean
    private UsuarioRepository usuarioRepository;

    @MockBean
    private PhoneRepository phoneRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }



    /**
     * Test of addUsuario method, of class UsuarioServiceImpl.
     */
    @Test
    public void testAddUsuario() throws Exception {
        UsuarioDTO usuariodto = UsuarioDTO.builder().build();
        usuariodto.setEmail("junit@gmail.com");
        usuariodto.setPassword("Fseguel22");
        PhoneDTO phone = new PhoneDTO();
        phone.setNumber("123456");
        List<PhoneDTO> listPhone = new ArrayList<>();
        listPhone.add(phone);

        usuariodto.setPhones(listPhone);
        Usuario result = usuarioService.addUsuario(usuariodto);
        assertNotNull(result);
        assertEquals(result.getEmail(), usuariodto.getEmail());
    }

    @Test
    public void testAddUsuario_exception_email() throws Exception {
        System.out.println("addUsuario");
        UsuarioDTO usuariodto = UsuarioDTO.builder().build();
        usuariodto.setEmail("pruebagmail.com");
        usuariodto.setPassword("Fseguel22");
        PhoneDTO phone = new PhoneDTO();
        phone.setNumber("123456");
        List<PhoneDTO> listPhone = new ArrayList<>();
        listPhone.add(phone);

        usuariodto.setPhones(listPhone);

        BusinessException assertThrows = assertThrows(BusinessException.class, () -> {
            usuarioService.addUsuario(usuariodto);
        });
        assertEquals("Email invalido : pruebagmail.com", assertThrows.getMensaje());

    }

    @Test
    public void testAddUsuario_exception_pass() throws Exception {
        System.out.println("addUsuario");
        UsuarioDTO usuariodto = UsuarioDTO.builder().build();
        usuariodto.setEmail("junit@gmail.com");
        usuariodto.setPassword("222");
        PhoneDTO phone = new PhoneDTO();
        phone.setNumber("123456");
        List<PhoneDTO> listPhone = new ArrayList<>();
        listPhone.add(phone);

        usuariodto.setPhones(listPhone);

        BusinessException assertThrows = assertThrows(BusinessException.class, () -> {
            usuarioService.addUsuario(usuariodto);
        });
        assertEquals("Password invalido", assertThrows.getMensaje());

    }


}
