/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlador;

import Modelos.Camp;
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
public class FXML_CampController implements Initializable {

    @FXML
    private TextField txt_camp;
    @FXML
    private Button btn_guardar;
    @FXML
    private Button btn_cerrar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void acc_guardar(ActionEvent event) {
        try {
            String nombre = this.txt_camp.getText();
            Camp camp = new Camp(nombre);
            Modelos.ModGeneral.Lista_camp.add(camp);
            
            for (Camp camp1 :  Modelos.ModGeneral.Lista_camp) {
                System.out.println(camp1.getNombre());
                
            }
            
            
        } catch (Exception e) {
        }
    }

    @FXML
    private void acc_cerrar(ActionEvent event) {
        cerrarFormulario();
    }
    
      public void cerrarFormulario() {
        try {
            String formulario = "/Vistas/FXML_Principal.fxml";
            FXMLLoader loader = new FXMLLoader(getClass().getResource(formulario));
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

    
}
