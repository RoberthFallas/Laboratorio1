/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.laboratorio1.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import org.una.laboratorio1.utils.FlowController;

/**
 * FXML Controller class
 *
 * @author roberth
 */
public class MenuLateralController extends Controller implements Initializable {

    @FXML
    public VBox vbContenedorAreas;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @Override
    public void initialize() {
    }

    @FXML
    public void onActionCerrarSesion(ActionEvent event) {
    }

    @FXML
    public void onActionDepartamento(ActionEvent event) {
        FlowController.getInstance().goView("DepartamentoV");
    }

    @FXML
    public void onActionTiposTramites(ActionEvent event) {
        FlowController.getInstance().goView("TiposTramites");
    }

    @FXML
    public void onActionDisennoTramites(ActionEvent event) {
        FlowController.getInstance().goView("DisennoTramites");
    }

    @FXML
    public void onActionPermisos(ActionEvent event) {
    }

    @FXML
    public void onActionUsuarios(ActionEvent event) {
    }

    @FXML
    public void onActionParámetros(ActionEvent event) {
    }

}
