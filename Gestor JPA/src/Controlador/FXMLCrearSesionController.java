/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlador;

import Modelos.Sesion;
import Modelos.Sitio;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class FXMLCrearSesionController implements Initializable {
    
    @FXML
    private Button btn_guardar;
    @FXML
    private Button btn_cerrar;
    @FXML
    private TextField id_Se;
    @FXML
    private TextField id_Sit;
    @FXML
    private TextField usu_C;
    @FXML
    private ComboBox<Sitio> cbx_Se;
    @FXML
    private TextField contra_C;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.cargarSitios();
    }    
    
    @FXML
    private void acc_guardar(ActionEvent event) {
        try {

            //-- crear ---
            if (this.id_Se.getText().equals("")) {
                String usuario = this.usu_C.getText();
                String pass = this.contra_C.getText();
                Sitio sitio = this.cbx_Se.getSelectionModel().getSelectedItem();
                Controlador_general.crearSesion(sitio, usuario, pass);
            } else {
                //--- editar ---
                Sesion ses = Controlador_general.buscarSesion(Integer.parseInt(this.id_Se.getText()));
              //  Controlador_general.EliminarSesion(ses.getSes_id());
              
              
                ses.setSes_user(this.usu_C.getText());
                ses.setSes_passw(this.contra_C.getText());
                ses.setSitio_id(this.cbx_Se.getSelectionModel().getSelectedItem());
            //    ses.setSes_id(Integer.parseInt(this.id_Se.getText()));
                
              // Sitio sitio1 = this.cbx_Se.getSelectionModel().getSelectedItem();
               Sitio sitioAnt = Controlador_general.BuscSitio(Integer.parseInt(this.id_Sit.getText()));
               
             //  Controlador_general.ActSitio(sitio1);
               Controlador_general.ActSitio(sitioAnt);
                
                Controlador_general.ActSesion(ses);
            }
            this.cerrar();
        } catch (Exception e) {
        }
    }
    
    @FXML
    private void acc_cerrar(ActionEvent event) {
        this.cerrar();
    }
    
    @FXML
    private void acc_cbxSe(ActionEvent event) {
    }
    
    public void cargarSitios() {
        try {
            this.cbx_Se.getItems().addAll(Controlador.Controlador_general.ListaSitio());
        } catch (Exception e) {
        }
    }
    
    public void fun_recuperarSesion(Sesion sesion) {
        try {
            if (sesion != null) {
                this.usu_C.setText(sesion.getSes_user());
                this.contra_C.setText(sesion.getSes_passw());
                this.id_Se.setText(Integer.toString(sesion.getSes_id()));
                
                Sitio sitio = sesion.getSitio_id();
                this.id_Sit.setText(Integer.toString(sitio.getSitio_id()));
                this.cbx_Se.getSelectionModel().select(sitio);
                this.cbx_Se.getEditor().setText(sitio.getSitio_nombre());
            }
        } catch (Exception e) {
        }
    }
    
    public void cerrar(){
         try {
            //capturar escena y ventana a la que pertenece el boton y cerrarlo
            Stage stage =(Stage) this.btn_guardar.getScene().getWindow();
            stage.close();
        } catch (Exception e) {
        }
    }
}
