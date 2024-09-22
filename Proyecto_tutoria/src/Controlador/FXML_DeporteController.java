/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlador;

import Modelos.Deporte;
import Modelos.Persona;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author e_d_d
 */
public class FXML_DeporteController implements Initializable {

    @FXML
    private Button btn_cerrar;
    @FXML
    private TextField txt_deporte;
    @FXML
    private Button btn_guardar;
    @FXML
    private ComboBox<Persona> cbx_personas;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            rellenar_combobox();
        } catch (Exception e) {
        }
    }    
    
     public void cerrarFormulario() {
        try {
            String path = "/Vistas/FXML_Principal.fxml";
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            Parent root = loader.load();
          

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);

            stage.show();

           
            Stage myStage = (Stage) this.btn_cerrar.getScene().getWindow();

            myStage.close();

        } catch (Exception e) {
        }
        //    
    }

    @FXML
    private void acc_cerrar(ActionEvent event) {
        try {
            cerrarFormulario();
        } catch (Exception e) {
        }
    }

    @FXML
    private void acc_guardar(ActionEvent event) {
            try{
                this.guardar();
        
             }catch(Exception e){
    
}
    
}
    public void guardar(){
        String deporte = this.txt_deporte.getText();
        
        Deporte dep = new Deporte(deporte);
        
        Persona persona = this.cbx_personas.getSelectionModel().getSelectedItem();
        
        persona.setDep(dep);
        
    }
    
    public void rellenar_combobox(){
        this.cbx_personas.getItems().addAll(Modelos.ModGeneral.personas);
    }
}
