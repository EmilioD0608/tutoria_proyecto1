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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author e_d_d
 */
public class FXML_PrincipalController implements Initializable {

    @FXML
    private TextField txt_nombre;
    @FXML
    private TextField txt_apellido;
    @FXML
    private TextField txt_altura;
    @FXML
    private Button btn_guardar;

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
    private void acc_guardar(ActionEvent event) {
        
        String nombre = this.txt_nombre.getText();
        String apellido = this.txt_apellido.getText();
        int altura = Integer.parseInt(this.txt_altura.getText());
        
        Persona per = new Persona(nombre,apellido,altura);
        
        System.out.println(per.getNombre());
        System.out.println(per.getApellido());
        System.out.println(per.getAltura());
    }
    
}
