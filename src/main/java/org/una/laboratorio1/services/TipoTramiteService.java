/* 
 * To change this license header, choose License Headers in Project Properties. 
 * To change this template file, choose Tools | Templates 
 * and open the template in the editor. 
 */ 
package org.una.laboratorio1.services; 
 
import org.una.laboratorio1.model.TramiteTipoDTO; 
import org.una.laboratorio1.utils.Request; 
import org.una.laboratorio1.utils.Respuesta; 
 
/** 
 * 
 * @author roberth 
 */ 
public class TipoTramiteService { 
 
    public Respuesta guardar(TramiteTipoDTO tipTram) { 
        Request request = new Request("/tipo_tramite/create"); 
        request.post(tipTram); 
        if (request.isError()) { 
            return new Respuesta(false, "Parece que algo ha salido mal. Si el problema persiste solicita ayuda del encargado del sistema.", request.getError()); 
        } 
        return new Respuesta(true, "", "", "data", request.readEntity(TramiteTipoDTO.class)); 
    } 
} 