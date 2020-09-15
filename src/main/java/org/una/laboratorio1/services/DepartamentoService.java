/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.laboratorio1.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import org.una.laboratorio1.model.DepartamentoDTO;
import org.una.laboratorio1.utils.Request;
import org.una.laboratorio1.utils.Respuesta;

/**
 *
 * @author LordLalo
 */
public class DepartamentoService {

    public Respuesta buscarDepartamentoid(String idDepartamento) {
        Map<String, Object> parametros = new HashMap();
        try {
            parametros.put("idDepartamento", idDepartamento);
            Request request = new Request("/departamentos", "/{idDepartamento}", parametros);
            request.get();
            if (request.isError()) {
                if (request.getStatus() == 204) {
                    return new Respuesta(false, "Sin resultados :(", request.getError());
                }
                return new Respuesta(false, "Parece que algo ha salido mal. Si el problema persiste solicita ayuda del encargado del sistema.", request.getError());
            }
            DepartamentoDTO departamento = (DepartamentoDTO) request.readEntity(DepartamentoDTO.class);
            return new Respuesta(true, "", "", "data", new ArrayList(Arrays.asList(departamento)));
            //##########Por el momento así porque solo se recibe un resultado, la idea es recibilo por listas, aunque
            //solo traigan un elemento############
        } catch (Exception ex) {
            return new Respuesta(false, "Ha ocurrido un error al establecer comunicación con el servidor.", ex.getMessage());
        }
    }

    public Respuesta buscarDepartamentoNombre(String nombre) {
        Map<String, Object> parametros = new HashMap();
        try {
            parametros.put("nombre", nombre);
            Request request = new Request("/departamentos/buscar", "/{nombre}", parametros);
            request.get();
            if (request.isError()) {
                if (request.getStatus() == 204) {
                    return new Respuesta(false, "Sin resultados :(", request.getError());
                }
                return new Respuesta(false, "Parece que algo ha salido mal. Si el problema persiste solicita ayuda del encargado del sistema.", request.getError());
            }
            DepartamentoDTO departamento = (DepartamentoDTO) request.readEntity(DepartamentoDTO.class);
            return new Respuesta(true, "", "", "data", new ArrayList(Arrays.asList(departamento)));
            //##########Por el momento así porque solo se recibe un resultado, la idea es recibilo por listas, aunque
            //solo traigan un elemento############
        } catch (Exception ex) {
            return new Respuesta(false, "Ha ocurrido un error al establecer comunicación con el servidor.", ex.getMessage());
        }
    }

    public Respuesta buscarDepartamentoEstado(Boolean estado) {
        Map<String, Object> parametros = new HashMap();
        try {
            parametros.put("estado", estado);
            Request request = new Request("/departamentos/findByEstado", "/{estado}", parametros);
            request.get();
            if (request.isError()) {
                if (request.getStatus() == 204) {
                    return new Respuesta(false, "Sin resultados :(", request.getError());
                }
                return new Respuesta(false, "Parece que algo ha salido mal. Si el problema persiste solicita ayuda del encargado del sistema.", request.getError());
            }
            List<DepartamentoDTO> departamento = (List<DepartamentoDTO>) request.readEntity(new GenericType<List<DepartamentoDTO>>() {
            });
            return new Respuesta(true, "", "", "data", departamento);

        } catch (Exception ex) {
            return new Respuesta(false, "Ha ocurrido un error al establecer comunicación con el servidor.", ex.getMessage());
        }
    }

    public Respuesta guardarDepartamento(DepartamentoDTO departamento) {
        try {
            Request request = new Request("/departamentos/create");
            request.post(departamento);
        if (request.isError()) {
                return new Respuesta(false, request.getError(), "");
            }
            return new Respuesta(true, "msj_accionExitosa", "", "data", request.readEntity(DepartamentoDTO.class));
           // return new Respuesta(true, "", "", "data", request.readEntity(DepartamentoDTO.class));
        } catch (Exception ex) {
            return new Respuesta(false, "Error", ex.getMessage());
        }
    }
}
