/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.laboratorio1.services;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.una.laboratorio1.model.AuthenticationRequest;
import org.una.laboratorio1.model.AuthenticationResponse;
import org.una.laboratorio1.utils.Request;
import org.una.laboratorio1.utils.Respuesta;

/**
 *
 * @author roberth
 */
public class VariacionService {
    
    public Respuesta getByTramiteDecription(String descripcion){
     
        try {
            //Request request = new Request(""); No existe ni el controller en el service
            //request.post(autRiq);
//            if (request.isError()) {
//                if (request.getStatus() == 500) {
//                    return new Respuesta(false, "Parece que has introducido mal tus credenciales de acceso.", request.getError());
//                }
//                return new Respuesta(false, "Parece que algo ha salido mal. Si el problema persiste solicita ayuda del encargado del sistema.", request.getError());
//            }
//            return new Respuesta(true, "", "", "data", request.readEntity(AuthenticationResponse.class));
        } catch (Exception ex) {
//            Logger.getLogger(UsuarioService.class.getName()).log(Level.SEVERE, " logIn() ->", ex);
//            return new Respuesta(false, "Ha ocurrido un error al establecer comunicación con el servidor.", ex.getMessage());
        }
        return null;
    }
    
}
