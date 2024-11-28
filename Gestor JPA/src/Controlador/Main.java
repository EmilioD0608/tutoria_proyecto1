/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Controlador;

import Modelos.Sesion;
import Modelos.Sitio;
import java.util.LinkedList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author e_d_d
 */
public class Main extends Application{

    /**
     * @param args the command line arguments
     *//*
    public static void main(String[] args) {
        // TODO code application logic here
       Controlador_general Control = new Controlador_general();
      
       
       //Control.CrearSitio(sitio);
       
       
    }*/
    
        public static void main(String[] args) {
        // TODO code application logic here
      //  Controlador_general Control = new Controlador_general();
   //    LinkedList<Sesion> sesionesList = new LinkedList<Sesion>();
     //  Controlador_general.CrearSitio("Facebook", "uasnduansd", sesionesList);
 /*    Sitio st = Controlador_general.BuscSitio(1);
    Sesion ses = Controlador_general.crearSesion(st,"Pepepe", "11234");
     st.setSesion(ses);*/
      Controlador_general Control = new Controlador_general();
            launch(args);
    }

    public void start(Stage primerstage) throws Exception {
         Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("!!");
        alert.setContentText("Desea cerrar la aplicacion?");
        Button closeButton= new Button("Cerrar la aplicacion");
        Button addStage=new Button("Abrir la aplicacion");
        
         VBox mainPanel=(VBox) FXMLLoader.load(getClass().getResource("/Vistas/FXMLPrincipal.fxml"));
        Scene scene=new Scene(mainPanel);
        primerstage.setTitle("MI APLICACION");
        primerstage.setScene(scene);
        primerstage.setMaximized(true);
        //agregar boton de confirmacion para cerrar
        
        primerstage.setOnCloseRequest(new EventHandler<WindowEvent>(){
           @Override
           public void handle(WindowEvent t) {
                t.consume();
                alert.showAndWait();
                if(alert.getResult().equals(ButtonType.OK)){
                    primerstage.close();
                    Platform.exit();   
        }
               
        }
        
   });
        //fin conf
        primerstage.show();
        
        //fin presentar formulario
    }
    
         
    
}