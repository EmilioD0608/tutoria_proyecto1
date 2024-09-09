/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlador;

import Modelos.Camp;
import Modelos.Empleados;
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
public class FXML_EmpleadosController implements Initializable {

    @FXML
    private Button btn_guardar;
    @FXML
    private Button btn_cerrar;
    @FXML
    private TextField txt_usuario;
    @FXML
    private TextField txt_contra;
    @FXML
    private ComboBox<Camp> cbx_camp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.cbx_camp.getItems().addAll(Modelos.ModGeneral.Lista_camp);
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

    @FXML
    private void acc_guardar(ActionEvent event) {
        try {
            String usr = this.txt_usuario.getText();
            String contra = this.txt_contra.getText();
            
            
            Empleados emp = new Empleados(usr,contra);
            
            this.cbx_camp.getSelectionModel().getSelectedItem().setLista_emp(emp);
            
            for (Empleados empleados : this.cbx_camp.getSelectionModel().getSelectedItem().getLista_emp()) {
                System.out.println(empleados.getUsuario());
            }
            
        } catch (Exception e) {
        }
    }

    @FXML
    private void acc_cerrar(ActionEvent event) {
        cerrarFormulario();
    }
    
}
