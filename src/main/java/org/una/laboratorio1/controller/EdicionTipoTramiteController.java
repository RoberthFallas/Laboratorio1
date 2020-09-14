/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.laboratorio1.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import org.una.laboratorio1.model.DepartamentoDTO;
import org.una.laboratorio1.model.TramiteTipoDTO;
import org.una.laboratorio1.services.DepartamentoService;
import org.una.laboratorio1.utils.Mensaje;
import org.una.laboratorio1.utils.Respuesta;

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
    public JFXComboBox<DepartamentoDTO> cbDepartamento;
    @FXML
    public JFXComboBox<String> cbEstado;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.cbEstado.getItems().addAll("Activo", "Inactivo");
    }

    @Override
    public void initialize() {
        cbDepartamento.getItems().clear();
        cbDepartamento.setPromptText("Cargando...");
        cargarDepartamentos();
    }

    @FXML
    public void OnActionGuardar(ActionEvent event) {

    }

    public void cargarDepartamentos() {
        Thread hilo = new Thread(() -> {
            Respuesta resp = new DepartamentoService().getAll();
            Platform.runLater(() -> {
                if (resp.getEstado()) {
                    cbDepartamento.getItems().addAll((List<DepartamentoDTO>) resp.getResultado("data"));
                    cbDepartamento.setPromptText("Departamentos");
                } else {
                    new Mensaje().showModal(Alert.AlertType.ERROR, "Oooops", this.getStage(), resp.getMensaje() + " .Es "
                            + "posible que algunos elementos visuales no presenten información alguna");
                    cbDepartamento.setPromptText("Error al cargar datos");
                }
            });
        });
        hilo.start();
    }

}
