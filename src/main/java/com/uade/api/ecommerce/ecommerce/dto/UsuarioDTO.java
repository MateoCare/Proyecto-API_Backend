package com.uade.api.ecommerce.ecommerce.dto;

import com.uade.api.ecommerce.ecommerce.models.Usuario;

import java.util.Date;

public class UsuarioDTO {
    private long id;
    private String usuario;
    private String password;
    private String email;
    private Date fecha_nacimiento;
    private String nombre;
    private String apellido;
    private int edad;

    public Usuario toUsuario() {
        // TODO
        return new Usuario();
    }
}