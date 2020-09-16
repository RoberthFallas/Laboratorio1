/* 
 * To change this license header, choose License Headers in Project Properties. 
 * To change this template file, choose Tools | Templates 
 * and open the template in the editor. 
 */
package org.una.laboratorio1.services;

import java.util.HashMap;
import java.util.List;
import javax.ws.rs.core.GenericType;
import org.una.laboratorio1.model.TramiteTipoDTO;
import org.una.laboratorio1.utils.Request;
import org.una.laboratorio1.utils.Respuesta;

/**
 *
 * @author roberth
 */
public class TipoTramiteService {

    public Respuesta guardar(TramiteTipoDTO tipTram) {
        try {
            Request request = new Request("/tipo_tramite/create");
            request.post(tipTram);
            if (request.isError()) {
                return new Respuesta(false, "Parece que algo ha salido mal. Si el problema persiste solicita ayuda del encargado del sistema.", request.getError());
            }
            return new Respuesta(true, "", "", "data", request.readEntity(TramiteTipoDTO.class));
        } catch (Exception ex) {
            return new Respuesta(false, "Ha ocurrido un error al establecer comunicación con el servidor.", ex.getMessage());
        }
    }

    public Respuesta getByParameter(String parameter) {
        try {
            HashMap<String, Object> hashM = new HashMap();
            Request request;
            if (parameter.trim().toUpperCase().startsWith("ACTIV")) {
                hashM.put("estado", true);
                request = new Request("/tipo_tramite/findByEstado", "/{estado}", hashM);
            } else if (parameter.trim().toUpperCase().startsWith("INACT")) {
                hashM.put("estado", false);
                request = new Request("/tipo_tramite/findByEstado", "/{estado}", hashM);
            } else {
                hashM.put("descripcion", parameter);
                request = new Request("/tipo_tramite/findByDescripcion", "/{descripcion}", hashM);
            }
            request.get();
            if (request.isError()) {
                return new Respuesta(false, "Parece que algo ha salido mal. Si el problema persiste solicita ayuda del encargado del sistema.", request.getError());
            }
            List<TramiteTipoDTO> tramites = (List<TramiteTipoDTO>) request.readEntity(new GenericType<List<TramiteTipoDTO>>() {
            });
            return new Respuesta(true, "", "", "data", tramites);
        } catch (Exception ex) {
            return new Respuesta(false, "Ha ocurrido un error al establecer comunicación con el servidor.", ex.getMessage());
        }
    }

    public Respuesta getAll() {
        try {
            Request request;
            request = new Request("/tipo_tramite/getAll");
            request.get();
            if (request.isError()) {
                return new Respuesta(false, "Parece que algo ha salido mal. Si el problema persiste solicita ayuda del encargado del sistema.", request.getError());
            }
            List<TramiteTipoDTO> tramites = (List<TramiteTipoDTO>) request.readEntity(new GenericType<List<TramiteTipoDTO>>() {
            });
            return new Respuesta(true, "", "", "data", tramites);
        } catch (Exception ex) {
            return new Respuesta(false, "Ha ocurrido un error al establecer comunicación con el servidor.", ex.getMessage());
        }
    }

}
