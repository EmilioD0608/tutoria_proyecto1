/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author e_d_d
 */
public class FXML_PrincipalController implements Initializable {

    @FXML
    private Button btn_registro1;
    @FXML
    private Button btn_cerrar;
    @FXML
    private Button btn_registro2;
    @FXML
    private Button btn_registro3;
    @FXML
    private Button btn_listar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void acc_registro1(ActionEvent event) {
           try {
            String formulario = "/Vistas/FXML_tienda.fxml";
            FXMLLoader loader = new FXMLLoader(getClass().getResource(formulario));
            Parent root = loader.load();
            //INDICAR CON QUE CONTROLADOR ESTÁ TRBAJANDO        
            FXML_tiendaController controlador = loader.getController();
            
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
           // controlador.Focus_Inicial();
         //  controlador.fun_decidirDireccion(1);
            stage.show();
            
            //cerrar el fomrulario
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
    private void acc_registro2(ActionEvent event) {
           try {
            String formulario = "/Vistas/FXML_producto.fxml";
            FXMLLoader loader = new FXMLLoader(getClass().getResource(formulario));
            Parent root = loader.load();
            //INDICAR CON QUE CONTROLADOR ESTÁ TRBAJANDO        
            FXML_productoController controlador = loader.getController();
            
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
           // controlador.Focus_Inicial();
         //  controlador.fun_decidirDireccion(1);
            stage.show();
            
            //cerrar el fomrulario
           stage.setOnCloseRequest(eh->controlador.cerrarFormulario());
             Stage myStage = (Stage)this.btn_cerrar.getScene().getWindow();
                    
            myStage.close();
        
                    
                    
        } catch (Exception e) {
        }
    }

    @FXML
    private void acc_registro3(ActionEvent event) {
          try {
            String formulario = "/Vistas/FXML_fecha.fxml";
            FXMLLoader loader = new FXMLLoader(getClass().getResource(formulario));
            Parent root = loader.load();
            //INDICAR CON QUE CONTROLADOR ESTÁ TRBAJANDO        
            FXML_fechaController controlador = loader.getController();
            
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
           // controlador.Focus_Inicial();
         //  controlador.fun_decidirDireccion(1);
            stage.show();
            
            //cerrar el fomrulario
           stage.setOnCloseRequest(eh->controlador.cerrarFormulario());
             Stage myStage = (Stage)this.btn_cerrar.getScene().getWindow();
                    
            myStage.close();
        
                    
                    
        } catch (Exception e) {
        }
    }

    @FXML
    private void acc_listar(ActionEvent event) {
         try {
            String formulario = "/Vistas/FXML_listar.fxml";
            FXMLLoader loader = new FXMLLoader(getClass().getResource(formulario));
            Parent root = loader.load();
            //INDICAR CON QUE CONTROLADOR ESTÁ TRBAJANDO        
            FXML_listarController controlador = loader.getController();
            
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
           // controlador.Focus_Inicial();
         //  controlador.fun_decidirDireccion(1);
            stage.show();
            
            //cerrar el fomrulario
           stage.setOnCloseRequest(eh->controlador.cerrarFormulario());
             Stage myStage = (Stage)this.btn_cerrar.getScene().getWindow();
                    
            myStage.close();
        
                    
                    
        } catch (Exception e) {
        }
    }
    
}
