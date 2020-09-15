/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.laboratorio1.model;

import java.time.LocalDate;
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
    public LocalDate fechaRegistro;
    @XmlTransient
    public LocalDate fechaModificacion;
    @XmlTransient
    public String estado;
    private DepartamentoDTO departamento;
//    private List<VariacionDTO> variacionDTOs = new ArrayList<>();

    public TramiteTipoDTO() {
        descripcion = new SimpleStringProperty();
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

    public String getFechaRegistro() {
        Date date = Date.from(fechaModificacion.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        return DateConverter.convertToSpringBoot(date);
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getFechaModificacion() {
        Date date = Date.from(fechaRegistro.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        return DateConverter.convertToSpringBoot(date);
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
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
