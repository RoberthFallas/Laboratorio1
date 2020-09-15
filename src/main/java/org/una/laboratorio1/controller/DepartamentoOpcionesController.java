/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.laboratorio1.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import org.una.laboratorio1.model.DepartamentoDTO;
import org.una.laboratorio1.services.DepartamentoService;
import org.una.laboratorio1.utils.Mensaje;
import org.una.laboratorio1.utils.Respuesta;

/**
 * FXML Controller class
 *
 * @author LordLalo
 */
public class DepartamentoOpcionesController extends Controller implements Initializable {

    @FXML
    public JFXTextField txtId;
    @FXML
    public JFXTextField txtNombre;
    @FXML
    public JFXComboBox<?> comboBoxEstado;
    @FXML
    public Label labelFechaRegistro;
    @FXML
    public Label labelFechaModificacion;
    @FXML
    public JFXButton btnCancelar;
    @FXML
    public JFXButton btnGuardar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void onActionCancelar(ActionEvent event) {
    }

    @FXML
    public void onActionGuardar(ActionEvent event) {
          DepartamentoDTO departamento=new DepartamentoDTO();
          departamento.setEstado(false);
          departamento.setFechaModificacion(new Date());
          departamento.setFechaRegistro(new Date());
          departamento.setNombre(txtNombre.getText());
          Respuesta resp= new DepartamentoService().guardarDepartamento(departamento);
          if (!resp.getEstado()) {
            new Mensaje().showModal(Alert.AlertType.WARNING, "Algo ha ocurrido", this.getStage(), resp.getMensaje());
          }
    }

    @Override
    public void initialize() {
      
    }

}
