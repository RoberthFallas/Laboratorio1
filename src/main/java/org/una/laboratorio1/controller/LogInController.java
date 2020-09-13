/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.laboratorio1.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import org.una.laboratorio1.services.UsuarioService;
import org.una.laboratorio1.utils.FlowController;
import org.una.laboratorio1.utils.Mensaje;
import org.una.laboratorio1.utils.Respuesta;

/**
 * FXML Controller class
 *
 * @author roberth
 */
public class LogInController extends Controller implements Initializable {

    @FXML
    public JFXTextField txtCedula;
    @FXML
    public JFXPasswordField txtContrasenna;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @Override
    public void initialize() {

    }

    @FXML
    public void Ingresar(ActionEvent event) {
        Respuesta resp = new UsuarioService().logIn(txtCedula.getText(), txtContrasenna.getText());
        if (resp.getEstado()) {
            FlowController.getInstance().goMain();
            FlowController.getInstance().goView("HomeScreen");
            FlowController.getInstance().goView("MenuLateral", "Left", null);
            this.getStage().close();
        } else {
            new Mensaje().showModal(Alert.AlertType.WARNING, "Algo ha ocurrido", this.getStage(), "Parece que has introducido mal tus credenciales de acceso.");
        }

    }

}
