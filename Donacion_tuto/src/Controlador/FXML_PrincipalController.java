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
    private Button btn_camp;
    @FXML
    private Button btn_cerrar;
    @FXML
    private Button btn_donante;
    @FXML
    private Button btn_empleado;
    @FXML
    private Button btn_lista;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void acc_camp(ActionEvent event) {
          try {
            String formulario = "/Vistas/FXML_Camp.fxml";
            FXMLLoader loader = new FXMLLoader(getClass().getResource(formulario));
            Parent root = loader.load();
            //INDICAR CON QUE CONTROLADOR ESTÁ TRBAJANDO        
            FXML_CampController controlador = loader.getController();
            
            
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
    private void acc_donante(ActionEvent event) {
         try {
            String formulario = "/Vistas/FXML_login.fxml";
            FXMLLoader loader = new FXMLLoader(getClass().getResource(formulario));
            Parent root = loader.load();
            //INDICAR CON QUE CONTROLADOR ESTÁ TRBAJANDO        
            FXML_loginController controlador = loader.getController();
            
            
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
    private void acc_empleado(ActionEvent event) {
        try {
            String formulario = "/Vistas/FXML_Empleados.fxml";
            FXMLLoader loader = new FXMLLoader(getClass().getResource(formulario));
            Parent root = loader.load();
            //INDICAR CON QUE CONTROLADOR ESTÁ TRBAJANDO        
            FXML_EmpleadosController controlador = loader.getController();
            
            
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
    private void acc_lista(ActionEvent event) {
    }
    
}
