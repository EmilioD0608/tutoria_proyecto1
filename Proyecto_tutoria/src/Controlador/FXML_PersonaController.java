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
public class FXML_PersonaController implements Initializable {

    @FXML
    private TextField txt_nombre;
    @FXML
    private TextField txt_apellido;
    @FXML
    private TextField txt_altura;
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
         String nombre = this.txt_nombre.getText();
        String apellido = this.txt_apellido.getText();
        int altura = Integer.parseInt(this.txt_altura.getText());
        
        Persona per = new Persona(nombre,apellido,altura);
        
        System.out.println(per.getNombre());
        System.out.println(per.getApellido());
        System.out.println(per.getAltura());
    }
    
    public void fun_imprimir(){
        System.out.println("qqqqqqqqqqqqqqqqqqqqqq");
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
    private void acc_cerrar(ActionEvent event) {
        cerrarFormulario();
    }
}
