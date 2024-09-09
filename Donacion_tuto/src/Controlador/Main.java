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
public class Main extends Application{

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
           //cuando todo está bien
           FXMLLoader loader =new FXMLLoader(); //para cargar la pantalla
           loader.setLocation(Main.class.getResource("/Vistas/FXML_Principal.fxml"));
           Pane ventana=(Pane)loader.load();
           //presentar la pantalla
           Scene scene=new Scene(ventana);
           stage.setScene(scene);
           stage.setResizable(false);
           stage.show();
           
        } catch (Exception e) {
            //cuando falla
        }
    }
    
}
