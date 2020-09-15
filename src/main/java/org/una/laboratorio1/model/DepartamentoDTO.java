/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.laboratorio1.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author LordLalo
 */
@XmlRootElement(name = "DepartamentoDTO")
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class DepartamentoDTO implements Serializable {

    private Long id;
    @XmlTransient
    public SimpleStringProperty nombre;
    private boolean estado;
    @XmlTransient
    public SimpleObjectProperty<LocalDate> fechaRegistro;
    @XmlTransient
    public SimpleObjectProperty<LocalDate> fechaModificacion;

    public DepartamentoDTO() {

        fechaModificacion = new SimpleObjectProperty();
        fechaModificacion.set(LocalDate.now());
        fechaRegistro = new SimpleObjectProperty();
        fechaRegistro.set(LocalDate.now());
        nombre = new SimpleStringProperty();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public boolean isEstado() {
        //return "Activo".equals(this.estado);
        return estado;
    }

    public void setEstado(boolean estado) {
        // this.estado = (estado) ? "Activo" : "Inactivo";
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

    public String estadoActivoInactivo() {
        if (estado) {
            return "Activo";
        } else {
            return "Inactivo";
        }
    }
}
