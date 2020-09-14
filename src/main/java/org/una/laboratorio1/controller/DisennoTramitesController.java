/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.laboratorio1.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author roberth
 */
public class DisennoTramitesController extends Controller implements Initializable {

    @FXML
    public JFXTextField txtParamBusqueda;
    @FXML
    public Tab tabTTramites;
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
    @FXML
    public JFXButton OnClickAgregarTipoTramite;
    @FXML
    public Tab tabVariaciones;
    @FXML
    public TableColumn<?, ?> columnVarId;
    @FXML
    public TableColumn<?, ?> columnVarEstado;
    @FXML
    public TableColumn<?, ?> columnVarGrupo;
    @FXML
    public TableColumn<?, ?> columnVarAccionnes;
    @FXML
    public Tab tabRequisitos;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @Override
    public void initialize() {
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

    public void onClickAgregar(ActionEvent event) {
    }

    @FXML
    public void onClickAgregarVariacion(ActionEvent event) {
    }
    
}
