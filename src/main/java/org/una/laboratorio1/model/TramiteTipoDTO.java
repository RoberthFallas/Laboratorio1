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
 * @author roberth
 */
@XmlRootElement(name = "TramiteTipoDTO")
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class TramiteTipoDTO {

    private Long id;
    @XmlTransient
    public SimpleStringProperty descripcion;
    @XmlTransient
    public LocalDateTime fechaRegistro;
    @XmlTransient
    public LocalDateTime fechaModificacion;
    @XmlTransient
    public String estado;
    private DepartamentoDTO departamento;
//    private List<VariacionDTO> variacionDTOs = new ArrayList<>();

    public TramiteTipoDTO() {
        descripcion = new SimpleStringProperty();
        fechaModificacion = LocalDateTime.now();
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

    // @JsonbDateFormat(value = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    public String getFechaRegistro() {
        Date date = java.sql.Timestamp.valueOf(fechaRegistro);
        if (date != null) {
            return DateConverter.convertToSpringBoot(date);
        } else {
            return null;
        }
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    // @JsonbDateFormat(value = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    public String getFechaModificacion() {
        Date date = java.sql.Timestamp.valueOf(fechaModificacion);
        if (date != null) {
            return DateConverter.convertToSpringBoot(date);
        } else {
            return null;
        }
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public boolean isEstado() {
        return "Activo".equals(estado);
    }

    public void setEstado(boolean estado) {
        this.estado = (estado) ? "Activo" : "Inactivo";
    }

    public DepartamentoDTO getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentoDTO departamento) {
        this.departamento = departamento;
    }

}
