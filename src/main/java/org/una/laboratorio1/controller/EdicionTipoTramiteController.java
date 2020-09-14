/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.laboratorio1.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.una.laboratorio1.model.TramiteTipoDTO;

/**
 * FXML Controller class
 *
 * @author rober
 */
public class EdicionTipoTramiteController extends Controller implements Initializable {

    public TramiteTipoDTO tipoTramite;
    @FXML
    public JFXTextArea txtDescripcion;
    @FXML
    public JFXComboBox<?> cbDepartamento;
    @FXML
    public JFXComboBox<?> cbEstado;

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
    public void OnActionGuardar(ActionEvent event) {
    }

    @Override
    public void initialize() {
    }

}
