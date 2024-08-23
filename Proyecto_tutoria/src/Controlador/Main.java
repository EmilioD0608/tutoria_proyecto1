/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Controlador;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author e_d_d
 */
public class Main extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        try {
              FXMLLoader loader =new FXMLLoader(); //guarda el archivo FXML para ejecutarlo
               loader.setLocation(Main.class.getResource("/Vistas/FXML_Principal.fxml")); // le da la url del fxml al loarder
              Pane ventana=(Pane)loader.load();// carga la vista principal en una nueva ventana
               Scene scene=new Scene(ventana);
               
               stage.setScene(scene);
           stage.setResizable(false); //desactivar los tamaños de pantalla
           stage.show();
              
        } catch (Exception e) {
            
        }
        
    }
    
}
