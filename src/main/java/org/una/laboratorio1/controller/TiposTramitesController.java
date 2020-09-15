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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.una.laboratorio1.utils.FlowController;

/**
 * FXML Controller class
 *
 * @author Roberth
 */
public class TiposTramitesController extends Controller implements Initializable {

    @FXML
    public JFXTextField txtParamBusqueda;
    @FXML
    public TableView<?> tblTipoTramite;
    @FXML
    public TableColumn<?, ?> columnTTEstado;
    @FXML
    public TableColumn<?, ?> columnTTModificacion;
    @FXML
    public TableColumn<?, ?> columnTTDescripcion;
    @FXML
    public TableColumn<?, ?> columnTTAciones;

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

    @FXML
    public void onClickCancelar(ActionEvent event) {
    }

    @FXML
    public void onClickGuardar(ActionEvent event) {
    }

    @FXML
    public void onClickBuscar(ActionEvent event) {
    }

    @FXML
    public void OnClickAgregarTipoTramite(ActionEvent event) {
        FlowController.getInstance().goViewInWindowModal("EdicionTipoTramite", this.getStage(), true);
    }

    @Override
    public void initialize() {
    }

}
