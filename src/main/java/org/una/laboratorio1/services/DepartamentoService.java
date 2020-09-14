/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.laboratorio1.services;

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
        parametros.put("idDepartamento", (idDepartamento != null) ? idDepartamento : " ");
        Request request = new Request("/departamentos", "/{idDepartamento}", parametros);
        request.get();
        if (request.isError()) {
            return new Respuesta(false, request.getError(), "");
        }
        List<DepartamentoDTO> resultList = (List<DepartamentoDTO>) request.readEntity(new GenericType<List<DepartamentoDTO>>() {
        });
        return new Respuesta(true, "", "", "data", resultList);
    }

}
