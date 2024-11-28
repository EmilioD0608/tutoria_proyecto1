/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class FXMLPrincipalController implements Initializable {

    @FXML
    private MenuItem panta_CrearSitio;
    @FXML
    private MenuItem panta_Sitio;
    @FXML
    private MenuItem panta_CrearSesion;
    @FXML
    private MenuItem panta_Sesion;
    @FXML
    private VBox dataPane1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void acc_panta_CrearSitio(ActionEvent event) {
         try {
          
            String pantalla="/Vistas/FXMLCrearSitio.fxml";
             setDataPane(fadeAnimate ( pantalla));
             
        } catch (Exception e) {
        }
    }

     public VBox fadeAnimate (String url)  throws IOException{
        VBox v=FXMLLoader.load(getClass().getResource(url));
        FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(v);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
        
        return v;
    }
     
       public void setDataPane(Node node){
        dataPane1.getChildren().setAll(node);
             dataPane1.setVgrow(dataPane1.getChildren().getFirst(), Priority.ALWAYS);
        dataPane1.setPadding(new Insets(0,0,0,0));
    }
       
     
    @FXML
    private void acc_panta_Sitio(ActionEvent event) {
         try {
            String pantalla="/Vistas/FXMLVistaSitios.fxml";
             setDataPane(fadeAnimate ( pantalla));
            
        } catch (Exception e) {
        }
    }

    @FXML
    private void acc_panta_CrearSesion(ActionEvent event) {
         try {
            String pantalla="/Vistas/FXMLCrearSesion.fxml";
             setDataPane(fadeAnimate ( pantalla));
            
        } catch (Exception e) {
        }
    }

    @FXML
    private void acc_panta_Sesion(ActionEvent event) {
         try {
            String pantalla="/Vistas/FXMLVistaSesion.fxml";
             setDataPane(fadeAnimate ( pantalla));
            
        } catch (Exception e) {
        }
    }
    
}
