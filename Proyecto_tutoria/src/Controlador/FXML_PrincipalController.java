/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlador;

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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author e_d_d
 */
public class FXML_PrincipalController implements Initializable {

    @FXML
    private Button btn_usr;
    @FXML
    private Button btn_cerrar;
    @FXML
    private Button btn_NuevoDeporte;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        /*
        String nombre ="Pepe";
        Persona per = new Persona(nombre,"Salinas",8);
        System.out.println(per.getNombre());
        System.out.println("Pepe no se quiere llamar pepe, se cambia el nombre");
        per.setNombre("Patricio");
        System.out.println("ahora se llama:" + per.getNombre());*/
        
    }    

    @FXML
    private void acc_nuevoUsuario(ActionEvent event) {
        try {
            String path = "/Vistas/FXML_Persona.fxml";
               FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
                Parent root = loader.load();
                FXML_PersonaController controlador = loader.getController();
                
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            
            controlador.fun_imprimir();
           // controlador.Focus_Inicial();

            stage.show();
            stage.setOnCloseRequest(eh->controlador.cerrarFormulario());
            Stage myStage = (Stage)this.btn_cerrar.getScene().getWindow();
                    
            myStage.close();
               
        } catch (Exception e) {
        }
    }

    @FXML
    private void acc_cerrar(ActionEvent event) {
    }

    @FXML
    private void acc_NuevoDeporte(ActionEvent event) {
        try {
            String path = "/Vistas/FXML_Deporte.fxml";
               FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
                Parent root = loader.load();
                
                FXML_DeporteController controlador = loader.getController();
                Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
             stage.show();
             
              stage.setOnCloseRequest(eh->controlador.cerrarFormulario());
               Stage myStage = (Stage)this.btn_cerrar.getScene().getWindow();
                myStage.close();
                
        } catch (Exception e) {
        }
    }

   
    
}
