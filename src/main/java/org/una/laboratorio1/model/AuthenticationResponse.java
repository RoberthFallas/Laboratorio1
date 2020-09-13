/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.laboratorio1.model;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author roberth
 */

@XmlRootElement(name = "AuthenticationResponse")
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class AuthenticationResponse {

    private String jwt;
    private UsuarioDTO usuario;
    private List<PermisoOtorgadoDTO> permisos;

    
    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public List<PermisoOtorgadoDTO> getPermisos() {
        return permisos;
    }

    public void setPermisos(List<PermisoOtorgadoDTO> permisos) {
        this.permisos = permisos;
    }

}
