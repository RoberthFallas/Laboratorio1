/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.laboratorio1.controller;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.una.laboratorio1.utils.FlowController;

/**
 * FXML Controller class
 *
 * @author roberth
 */
public class LogInController extends Controller implements Initializable {

    @FXML
    public JFXTextField txtCedula;
    @FXML
    public JFXTextField txtContrasenna;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @Override
    public void initialize() {

    }

    @FXML
    public void Ingresar(ActionEvent event) {
        FlowController.getInstance().goMain();
        FlowController.getInstance().goView("HomeScreen");
        FlowController.getInstance().goView("MenuLateral","Left", null);
        this.getStage().close();
    }

}
