/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.laboratorio1.controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import org.una.laboratorio1.model.DepartamentoDTO;
import org.una.laboratorio1.services.DepartamentoService;
import org.una.laboratorio1.utils.AppContext;
import org.una.laboratorio1.utils.FlowController;
import org.una.laboratorio1.utils.Mensaje;
import org.una.laboratorio1.utils.Respuesta;

/**
 * FXML Controller class
 *
 * @author LordLalo
 */
public class DepartamentoVController extends Controller implements Initializable {

    @FXML
    public Label labelDepartamento;
    @FXML
    public TextField txtBusqueda;
    @FXML
    public JFXButton btnBuscar;
    @FXML
    public TableView<DepartamentoDTO> tblDepartamentos;
    @FXML
    public TableColumn<DepartamentoDTO, String> columnId;
    @FXML
    public TableColumn<DepartamentoDTO, String> columnNombre;
    @FXML
    public TableColumn<DepartamentoDTO, String> columnEstado;
    @FXML
    public TableColumn<DepartamentoDTO, String> columnOperaciones;           //Aún por implementar
    public ObservableList<DepartamentoDTO> departamentosEnTabla;
    @FXML
    public Button btnAgregar;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        columnId.setCellValueFactory(x -> new SimpleStringProperty(x.getValue().getId().toString()));
        columnNombre.setCellValueFactory(x -> new SimpleStringProperty(x.getValue().getNombre()));
        columnEstado.setCellValueFactory(x -> new SimpleStringProperty(x.getValue().estadoActivoInactivo()));
    }

    @Override
    public void initialize() {

    }

    @FXML
    public void OnActionBuscar(ActionEvent event) {

        if ("activo".equals(txtBusqueda.getText().toLowerCase()) || "inactivo".equals(txtBusqueda.getText().toLowerCase())) {
            Respuesta resp;
            if ("activo".equals(txtBusqueda.getText().toLowerCase())) {
                resp = new DepartamentoService().buscarDepartamentoEstado(true);
            } else {
                resp = new DepartamentoService().buscarDepartamentoEstado(false);
            }

            if (resp.getEstado()) {
                departamentosEnTabla = FXCollections.observableArrayList((List) resp.getResultado("data"));
                tblDepartamentos.setItems(departamentosEnTabla);
            } else {
                new Mensaje().showModal(Alert.AlertType.WARNING, "Algo ha ocurrido", this.getStage(), resp.getMensaje());
            }

        } else {
            if (Character.isDigit(txtBusqueda.getText().charAt(0))) {
                Respuesta resp = new DepartamentoService().buscarDepartamentoid(txtBusqueda.getText());
                if (resp.getEstado()) {
                    AppContext.getInstance().set("Departamento",(DepartamentoDTO)(resp.getResultado("data")));
                    departamentosEnTabla = FXCollections.observableArrayList((List) resp.getResultado("data"));
                    tblDepartamentos.setItems(departamentosEnTabla);
                } else {
                    new Mensaje().showModal(Alert.AlertType.WARNING, "Algo ha ocurrido", this.getStage(), resp.getMensaje());
                }
            } else {
                Respuesta resp = new DepartamentoService().buscarDepartamentoNombre(txtBusqueda.getText());
                if (resp.getEstado()) {
                    departamentosEnTabla = FXCollections.observableArrayList((List) resp.getResultado("data"));
                    tblDepartamentos.setItems(departamentosEnTabla);
                } else {
                    new Mensaje().showModal(Alert.AlertType.WARNING, "Algo ha ocurrido", this.getStage(), resp.getMensaje());
                }
            }
        }
    }

    @FXML
    public void OnActionAgregar(ActionEvent event) {

        FlowController.getInstance().goViewInWindowModal("DepartamentoOpciones", this.getStage(), true);

    }
}
