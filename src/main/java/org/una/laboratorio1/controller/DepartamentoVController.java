/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.laboratorio1.controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.una.laboratorio1.services.DepartamentoService;
import org.una.laboratorio1.utils.Respuesta;

/**
 * FXML Controller class
 *
 * @author LordLalo
 */
public class DepartamentoVController extends Controller implements Initializable  {

    @FXML
    public Label labelDepartamento;
    @FXML
    public TextField txtBusqueda;
    @FXML
    public JFXButton btnBuscar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void initialize() {
       
    }

    @FXML
    public void OnActionBuscar(ActionEvent event) {
        Respuesta resp = new DepartamentoService().buscarDepartamentoid(txtBusqueda.getText());
        
    }
    
}
