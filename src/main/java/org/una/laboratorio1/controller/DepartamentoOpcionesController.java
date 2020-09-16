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
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import org.una.laboratorio1.model.DepartamentoDTO;
import org.una.laboratorio1.services.DepartamentoService;
import org.una.laboratorio1.utils.AppContext;
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
    public JFXComboBox<String> comboBoxEstado;
    @FXML
    public Label labelFechaRegistro;
    @FXML
    public Label labelFechaModificacion;
    @FXML
    public JFXButton btnCancelar;
    @FXML
    public JFXButton btnGuardar;
    @FXML
    public JFXComboBox<String> comboBoxAccion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.comboBoxEstado.getItems().addAll("Activo", "Inactivo");
        this.comboBoxAccion.getItems().addAll("Crear", "Modificar", "ver");

    }

    @FXML
    public void onActionCancelar(ActionEvent event) {

    }

    @FXML
    public void onActionGuardar(ActionEvent event) {

        if (comboBoxAccion.getValue().equals("Crear")) {
            DepartamentoDTO departamento = new DepartamentoDTO();

            departamento.setFechaModificacion(new Date());
            if (comboBoxEstado.getValue().equals("Activo")) {
                departamento.setEstado(true);
            } else {
                departamento.setEstado(false);
            }
            departamento.setFechaRegistro(new Date());
            //departamento.setId(Long.parseLong(txtId.getText()));
            departamento.setNombre(txtNombre.getText());
            Respuesta resp = new DepartamentoService().guardarDepartamento(departamento);
            if (!resp.getEstado()) {
                new Mensaje().showModal(Alert.AlertType.WARNING, "Algo ha ocurrido", this.getStage(), resp.getMensaje());
            }
        } else {
            if (comboBoxAccion.getValue().equals("Modificar")) {
                DepartamentoDTO departamento = new DepartamentoDTO();
                if (comboBoxEstado.getValue().equals("Activo")) {
                    departamento.setEstado(true);
                } else {
                    if (comboBoxEstado.getValue().equals("Inactivo")) {
                        departamento.setEstado(false);
                    }
                }

                departamento.setFechaModificacion(new Date());
                // departamento.setFechaRegistro(new Date());
                departamento.setId(Long.parseLong(txtId.getText()));
                if (txtNombre.getText() != " ") {
                    departamento.setNombre(txtNombre.getText());
                }
                Respuesta resp = new DepartamentoService().moficiarDepartamento(departamento);
                if (!resp.getEstado()) {
                    new Mensaje().showModal(Alert.AlertType.WARNING, "Algo ha ocurrido", this.getStage(), resp.getMensaje());
                }
            }
//            if (comboBoxAccion.getValue().equals("ver")) {
//                Respuesta resp = new DepartamentoService().buscarDepartamentoid("2");
//                if (resp.getEstado()) {
////                    resp.getResultado("data");
//                    DepartamentoDTO depa = (((DepartamentoDTO) resp.getResultado("data")));
//                    txtNombre.setText(depa.getNombre());
//                }
////
//            }
        }

    }

    @Override
    public void initialize() {

    }

    @FXML
    public void onActionAcciones(ActionEvent event) {
        if (comboBoxAccion.getValue().equals("Crear")) {
            txtNombre.setDisable(false);
            txtId.setDisable(true);
            comboBoxEstado.setDisable(false);
        } else {
            if (comboBoxAccion.getValue().equals("ver")) {
                txtNombre.setDisable(true);
                txtId.setDisable(false);
                comboBoxEstado.setDisable(true);
            } else {
                if (comboBoxAccion.getValue().equals("Modificar")) {
                    txtNombre.setDisable(false);
                }
                txtId.setDisable(false);
                comboBoxEstado.setDisable(false);
            }

        }

    }

}
