/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.laboratorio1.model;

import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author roberth
 */
@XmlRootElement(name = "UsuarioDTO")
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class UsuarioDTO {

    private Long id;
    @XmlTransient
    public SimpleStringProperty nombreCompleto;
    private String passwordEncriptado;
    @XmlTransient
    public SimpleStringProperty cedula;
    private boolean estado;
    @XmlTransient
    public SimpleObjectProperty<LocalDate> fechaRegistro;
    @XmlTransient
    public SimpleObjectProperty<LocalDate> fechaModificacion;
    @XmlTransient
    public SimpleBooleanProperty esJefe;

    //private DepartamentoDTO departamento;
//    public void asociarDepartamento(DepartamentoDTO depart) {
//        this.departamento = depart;
//    }
    public UsuarioDTO() {

        this.cedula = new SimpleStringProperty("");
        esJefe = new SimpleBooleanProperty();
        fechaModificacion = new SimpleObjectProperty();
        fechaModificacion.set(LocalDate.now());
        fechaRegistro = new SimpleObjectProperty();
        fechaRegistro.set(LocalDate.now());
        nombreCompleto = new SimpleStringProperty();
        id = 0L;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto.get();
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto.set(nombreCompleto);
    }

    public String getCedula() {
        return cedula.get();
    }

    public void setCedula(String cedula) {
        this.cedula.set(cedula);
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Date getFechaRegistro() {
        Date date = Date.from(fechaRegistro.get().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        return date;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro.set(fechaRegistro.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
    }

    public Date getFechaModificacion() {
        Date date = Date.from(fechaModificacion.get().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        return date;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion.set(fechaModificacion.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
    }

    public String getPasswordEncriptado() {
        return passwordEncriptado;
    }

    public void setPasswordEncriptado(String passwordEncriptado) {
        this.passwordEncriptado = passwordEncriptado;
    }

    public Boolean getEsJefe() {
        return esJefe.get();
    }

    public void setEsJefe(Boolean esJefe) {
        this.esJefe.set(esJefe);
    }

}
