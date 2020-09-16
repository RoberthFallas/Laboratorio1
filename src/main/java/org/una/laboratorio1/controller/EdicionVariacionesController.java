/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.laboratorio1.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import org.una.laboratorio1.model.TramiteTipoDTO;
import org.una.laboratorio1.model.VariacionDTO;
import org.una.laboratorio1.services.TipoTramiteService;
import org.una.laboratorio1.services.VariacionService;
import org.una.laboratorio1.utils.Mensaje;
import org.una.laboratorio1.utils.Respuesta;

/**
 * FXML Controller class
 *
 * @author Roberth :)
 */
public class EdicionVariacionesController extends Controller implements Initializable {

    @FXML
    public JFXTextArea txtDescripcion;
    @FXML
    public JFXComboBox<TramiteTipoDTO> cbTipoTramite;
    @FXML
    public JFXComboBox<Integer> cbGrupo;
    @FXML
    public JFXComboBox<String> cbEstado;
    public VariacionDTO variacion;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbEstado.getItems().addAll("Activo", "Inactivo");
        cbGrupo.getItems().addAll(1, 2, 3);
    }

    @Override
    public void initialize() {
        cbTipoTramite.getItems().clear();
        cbTipoTramite.setPromptText("Cargando...");
        cargarTiposTramites();
        bind(true);
    }

    @FXML
    public void OnActionGuardar(ActionEvent event) {
        if (isDatoValido()) {
            saveAndClose();
        } else {
            new Mensaje().show(Alert.AlertType.INFORMATION, "Mira de nuevo", "Parece que te faló uno o más campos.");
        }
    }

    public void cargarTiposTramites() {
        Thread hilo = new Thread(() -> {
            Respuesta resp = new TipoTramiteService().getAll();
            Platform.runLater(() -> {
                if (resp.getEstado()) {
                    cbTipoTramite.getItems().addAll((List<TramiteTipoDTO>) resp.getResultado("data"));
                    cbTipoTramite.setPromptText("Tipos de Trámites");
                } else {
                    new Mensaje().showModal(Alert.AlertType.ERROR, "Oooops", this.getStage(), resp.getMensaje() + " .Es "
                            + "posible que algunos elementos visuales no presenten información alguna");
                    cbTipoTramite.setPromptText("Error al cargar datos");
                }
            });
        });
        hilo.start();
    }

    public void bind(boolean nuevo) {
        if (nuevo) {
            variacion = new VariacionDTO();
        }
        txtDescripcion.textProperty().bindBidirectional(variacion.descripcion);
        if (variacion.getId() != null) {
            cbEstado.setValue(variacion.estado);
            cbTipoTramite.setValue(variacion.getTramite_tipo());
            cbGrupo.setValue(variacion.grupo);
        }
    }

    public void unbind() {
        txtDescripcion.textProperty().unbindBidirectional(variacion.descripcion);
        if (variacion.getId() != null) {
            cbEstado.setValue(null);
            cbTipoTramite.setValue(null);
            cbGrupo.setValue(null);
            variacion = null;
        }
    }

    public boolean isDatoValido() {
        if (txtDescripcion.getText() != null && !txtDescripcion.getText().isBlank()) {
            if (cbEstado.getValue() != null && cbGrupo.getValue() != null && cbTipoTramite.getValue() != null) {
                return true;
            }
        }
        return false;
    }

    public void saveAndClose() {
        Respuesta resp = new VariacionService().save(variacion);
        if (resp.getEstado()) {
            new Mensaje().showModal(Alert.AlertType.INFORMATION, "Genial", this.getStage(), "Variación se ha guardado.");
            unbind();
            this.getStage().close();
        } else {
            new Mensaje().showModal(Alert.AlertType.INFORMATION, "Algo ocurrió", this.getStage(), resp.getMensaje());
        }
    }

}
