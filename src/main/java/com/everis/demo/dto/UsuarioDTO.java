package com.everis.demo.dto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioDTO implements Serializable {


	private static final long serialVersionUID = 1L;
	private String id;
    private String name;
    private String email;
    private String password;
    private List<PhoneDTO> phones;

}
