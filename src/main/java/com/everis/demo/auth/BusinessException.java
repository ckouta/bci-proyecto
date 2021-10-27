package com.everis.demo.auth;

public class BusinessException extends Exception {

    private String mensaje;


    public BusinessException(String message) {
        super(message);
        this.mensaje = message;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

}
