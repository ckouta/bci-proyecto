package com.everis.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.transaction.Transactional;

import com.everis.demo.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.demo.auth.BusinessException;
import com.everis.demo.dto.PhoneDTO;
import com.everis.demo.dto.UserDTO;
import com.everis.demo.dto.UsuarioDTO;
import com.everis.demo.entity.Phone;
import com.everis.demo.entity.Usuario;
import com.everis.demo.repository.PhoneRepository;
import com.everis.demo.repository.UsuarioRepository;




@Service
public class UsuarioServiceImpl implements UsuarioService {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioServiceImpl.class);

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PhoneRepository phoneRepository;


    @Override
    public Usuario addUsuario(UsuarioDTO user) throws BusinessException {

        if (!Utils.validarEmail(user.getEmail())) {
            logger.info("Email invalido : " + user.getEmail());
            throw new BusinessException("Email invalido : " + user.getEmail());
        }

        if (!Utils.validarPassword(user.getPassword())) {
            logger.info("Password invalido");
            throw new BusinessException("Password invalido");
        }
        List<Usuario> usuarios = usuarioRepository.findAll();
        if (usuarios.stream().anyMatch(usuario -> usuario.getEmail().equalsIgnoreCase(user.getEmail()))) {
            logger.info("El correo ya registrado");
            throw new BusinessException("El correo ya registrado");
        }

        Usuario usuario = new Usuario();

        usuario.setUuid(Utils.generarUUID());
        Date created = new Date();
        usuario.setCreated(created);
        usuario.setModified(created);
        usuario.setLastLogin(created);
        usuario.setIsactive(true);
        usuario.setUserPassword(user.getPassword());
        usuario.setUserName(user.getName());
        usuario.setEmail(user.getEmail());

        usuarioRepository.save(usuario);
        List<Phone> listaPhone = new ArrayList();
        for (PhoneDTO phoneDto : user.getPhones()) {
            Phone phone = new Phone();
            phone.setPhoneNumber(phoneDto.getNumber());
            phone.setCitycode(phoneDto.getCitycode());
            phone.setContrycode(phoneDto.getContrycode());
            phone.setUserUuid(usuario.getUuid());
            listaPhone.add(phone);
        }
        addPhones(listaPhone);
        String token = Utils.getJWTToken(user.getName());
        usuario.setToken(token);
        return usuario;
    }

    @Override
    public UserDTO getUsuario(String name, String password) throws BusinessException {
        Usuario usuario = null;
        usuario = usuarioRepository.findNamePassword(name, password);
        
        if (usuario == null) {
            throw new BusinessException(" Usuario no existe con name " + name);
        }

        if (!usuario.isIsactive()) {
            throw new BusinessException(" Su Usuario se encuentra desactivado ");
        }
        
        UserDTO user = UserDTO.builder()
                .created(usuario.getCreated())
                .isactive(usuario.isIsactive() )
                .lastLogin(usuario.getLastLogin())
                .modified(usuario.getModified())
                .token(usuario.getToken())
                .userName(usuario.getUserName())
                .uuId(usuario.getUuid()).build();

       String token = Utils.getJWTToken(name);
       user.setToken(token);
        
        return user;
    }

    private List<Phone> addPhones(List<Phone> phones) {
        return phoneRepository.saveAll(phones);
    }

    @Transactional
    private Phone addPhone(Phone phone) {
        return phoneRepository.save(phone);
    }




}
