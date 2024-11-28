/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlador;


import Modelos.Sitio;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
public class FXMLVistaSitiosController implements Initializable {

    @FXML
    private TableView<Sitio> tv_datos;
    @FXML
    private TableColumn<?, ?> sit_id;
    @FXML
    private TableColumn<?, ?> sit_nombre;
    @FXML
    private TableColumn<?, ?> sit_url;
    @FXML
    private Button btn_crear;
    @FXML
    private Button btn_eliminar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.sit_id.setCellValueFactory(new PropertyValueFactory("sitio_id"));
        this.sit_nombre.setCellValueFactory(new PropertyValueFactory("sitio_nombre"));
        this.sit_url.setCellValueFactory(new PropertyValueFactory("sitio_url"));
        this.fun_cargarSitio();
        // TODO
    }    

    @FXML
    private void eventoCliket(MouseEvent event) {
         try{
            if(event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount()==2){
               // System.out.println("DOBLE CLICK");
               Sitio objSeleccionado= this.tv_datos.getSelectionModel().getSelectedItem();
                if(objSeleccionado!= null){
                    this.fun_abrirModal(objSeleccionado);
                    
                }
            }
        }catch(Exception e){
            
        }
    }
    

    public void fun_abrirModal(Sitio obj){
        try{
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/Vistas/FXMLCrearSitio.fxml"));
            Parent root=loader.load();
            Scene scene=new Scene(root);
            FXMLCrearSitioController controlador=loader.getController();
           controlador.recuperarSitio(obj);
            
            Stage stage=new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.showAndWait();
            this.fun_cargarSitio();
            
            
            
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
            int ID = this.tv_datos.getSelectionModel().getSelectedItem().getSitio_id();
            Controlador_general.EliminarSitio(ID);
            
            
            
        } catch (Exception e) {
        }
    }
    
    public void fun_cargarSitio(){
        try {
            this.tv_datos.getItems().clear();
            this.tv_datos.getItems().addAll(Controlador.Controlador_general.ListaSitio());
        } catch (Exception e) {
        }
        
    }
}
