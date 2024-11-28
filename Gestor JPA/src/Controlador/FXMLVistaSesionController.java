/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlador;

import Modelos.Sesion;
import Modelos.Sitio;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class FXMLVistaSesionController implements Initializable {

    @FXML
    private TableView<Sesion> tv_sesion;
    @FXML
    private TableColumn<?, ?> ses_id;
    @FXML
    private TableColumn<?, ?> ses_usu;
    @FXML
    private TableColumn<?, ?> ses_pass;
    @FXML
    private Button btn_crear;
    @FXML
    private Button btn_eliminar;
    @FXML
    private ComboBox<Sitio> cbx_S;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.ses_id.setCellValueFactory(new PropertyValueFactory("ses_id"));
        this.ses_usu.setCellValueFactory(new PropertyValueFactory("ses_user"));
        this.ses_pass.setCellValueFactory(new PropertyValueFactory("ses_passw"));
        this.cargarSitios();
    }    

    @FXML
    private void eventoCliket(MouseEvent event) {
         try{
            if(event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount()==2){
               // System.out.println("DOBLE CLICK");
               Sesion objSeleccionado= this.tv_sesion.getSelectionModel().getSelectedItem();
                if(objSeleccionado!= null){
                    this.fun_abrirModal(objSeleccionado);
                    
                }
            }
        }catch(Exception e){
            
        }
    }

     public void fun_abrirModal(Sesion sesion){
        try{
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/Vistas/FXMLCrearSesion.fxml"));
            Parent root=loader.load();
            Scene scene=new Scene(root);
            FXMLCrearSesionController controlador=loader.getController();
            controlador.fun_recuperarSesion(sesion);
            
           
            
            Stage stage=new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.showAndWait();
            this.cargarSitios();
          //  this.fun_cargarSesiones(this.cbx_S.getSelectionModel().getSelectedItem().getListaSesiones());
            
            
        }catch(Exception e){
            
        }
    }
    
    @FXML
    private void acc_crear(ActionEvent event) {
         try{
            
            this.fun_abrirModal(null);
            
            
        }catch(Exception e){
            
        }
    }

    @FXML
    private void acc_eliminar(ActionEvent event) {
       try {
            int ID = this.tv_sesion.getSelectionModel().getSelectedItem().getSes_id();
            Controlador_general.EliminarSesion(ID);
            this.cargarSitios();
            
          
            
            
        } catch (Exception e) {
        }
    }

    @FXML
    private void acc_cbxS(ActionEvent event) {
        try {
            Object evento = event.getSource();
            if(evento.equals(this.cbx_S)){ //si hico clic en el combo box
                this.fun_cargarSesiones(this.cbx_S.getSelectionModel().getSelectedItem().getListaSesiones());
                
            }
        } catch (Exception e) {
        }
    }
    
       public void fun_cargarSesiones(LinkedList<Sesion> detallesesion){
        try {
            //limpiar
            this.tv_sesion.getItems().clear();
            //cargar el tableview con el arraylist
            this.tv_sesion.getItems().addAll(detallesesion);
        } catch (Exception e) {
        }
    }
    
    public void cargarSitios(){
        try {
            this.cbx_S.getItems().clear();
             this.tv_sesion.getItems().clear();
            this.cbx_S.getItems().addAll(Controlador.Controlador_general.ListaSitio());
        } catch (Exception e) {
        }
    }
    
}
