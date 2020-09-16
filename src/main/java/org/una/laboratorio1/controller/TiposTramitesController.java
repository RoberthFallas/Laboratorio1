/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.laboratorio1.controller;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.una.laboratorio1.model.TramiteTipoDTO;
import org.una.laboratorio1.services.TipoTramiteService;
import org.una.laboratorio1.utils.FlowController;
import org.una.laboratorio1.utils.Mensaje;
import org.una.laboratorio1.utils.Respuesta;

/**
 * FXML Controller class
 *
 * @author Roberth
 */
public class TiposTramitesController extends Controller implements Initializable {

    @FXML
    public JFXTextField txtParamBusqueda;
    @FXML
    public TableView<TramiteTipoDTO> tblTipoTramite;
    @FXML
    public TableColumn<TramiteTipoDTO, String> columnTTEstado;
    @FXML
    public TableColumn<TramiteTipoDTO, String> columnTTModificacion;
    @FXML
    public TableColumn<TramiteTipoDTO, String> columnTTDescripcion;
    @FXML
    public TableColumn<?, ?> columnTTAciones;
    private TramiteTipoDTO tramiteTipoSelected;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        columnTTDescripcion.setCellValueFactory(x -> new SimpleStringProperty(x.getValue().getDescripcion()));
        columnTTModificacion.setCellValueFactory(x -> new SimpleStringProperty(x.getValue().fechaModificacion.toLocalDate().toString()));
        columnTTEstado.setCellValueFactory(x -> new SimpleStringProperty(x.getValue().estado));

    }

    @FXML
    public void onClickCancelar(ActionEvent event) {
    }

    @FXML
    public void onClickGuardar(ActionEvent event) {
    }

    @FXML
    public void onClickBuscar(ActionEvent event) {
        if (txtParamBusqueda.getText() != null && !txtParamBusqueda.getText().isBlank()) {
            Respuesta resp = new TipoTramiteService().getByParameter(txtParamBusqueda.getText());
            if (resp.getEstado()) {
                tblTipoTramite.getItems().clear();
                if (!((List<TramiteTipoDTO>) resp.getResultado("data")).isEmpty()) {
                    tblTipoTramite.getItems().addAll((List<TramiteTipoDTO>) resp.getResultado("data"));
                } else {
                    new Mensaje().show(Alert.AlertType.INFORMATION, "Inteta de nuevo", "No hubieron resultados.");
                }
            } else {
                new Mensaje().show(Alert.AlertType.WARNING, "Algo ocurrió", resp.getMensaje());
            }
        } else {
            new Mensaje().show(Alert.AlertType.INFORMATION, "Sugerencia", "Procura escribir algo en la barra de búsqueda.");
        }
    }

    @FXML
    public void OnClickAgregarTipoTramite(ActionEvent event) {
        FlowController.getInstance().goViewInWindowModal("EdicionTipoTramite", this.getStage(), true);
    }

    @Override
    public void initialize() {
    }

}
