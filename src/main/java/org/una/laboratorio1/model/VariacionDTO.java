/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.laboratorio1.model;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import javafx.beans.property.SimpleStringProperty;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.una.laboratorio1.utils.DateConverter;

/**
 *
 * @author Roberth :)
 */
@XmlRootElement(name = "VariacionDTO")
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class VariacionDTO {

    private Long id;
    @XmlTransient
    public SimpleStringProperty descripcion;
    @XmlTransient
    public int grupo;
    @XmlTransient
    public LocalDateTime fechaRegistro;
    @XmlTransient
    public String estado;
    @XmlTransient
    public TramiteTipoDTO tramite_tipo;

    public VariacionDTO() {
        descripcion = new SimpleStringProperty();
        fechaRegistro = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion.get();
    }

    public void setDescripcion(String descripcion) {
        this.descripcion.set(descripcion);
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public String getFechaRegistro() {
        Date date = java.sql.Timestamp.valueOf(fechaRegistro);
        return DateConverter.convertToSpringBoot(date);
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public boolean isEstado() {
        return "Activo".equals(estado);
    }

    public void setEstado(boolean estado) {
        this.estado = (estado) ? "Activo" : "Inactivo";
    }

    public TramiteTipoDTO getTramite_tipo() {
        return tramite_tipo;
    }

    public void setTramite_tipo(TramiteTipoDTO tramite_tipo) {
        this.tramite_tipo = tramite_tipo;
    }

}
