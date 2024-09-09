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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author e_d_d
 */
public class FXML_loginController implements Initializable {

    @FXML
    private Button btn_guardar;
    @FXML
    private Button btn_cerrar;
    @FXML
    private TextField txt_usr;
    @FXML
    private TextField txt_contra;

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
            if (fun_login()) {
                try {
                    String formulario = "/Vistas/FXML_Donante.fxml";
                    FXMLLoader loader = new FXMLLoader(getClass().getResource(formulario));
                    Parent root = loader.load();
                    //INDICAR CON QUE CONTROLADOR ESTÁ TRBAJANDO        
                    FXML_DonanteController controlador = loader.getController();

                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.setResizable(false);
                    // controlador.Focus_Inicial();
                    //  controlador.fun_decidirDireccion(1);
                    stage.show();

                    //cerrar el fomrulario
                    stage.setOnCloseRequest(eh -> controlador.cerrarFormulario());
                    Stage myStage = (Stage) this.btn_cerrar.getScene().getWindow();

                    myStage.close();

                } catch (Exception e) {
                }
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

    public boolean fun_login() {
        String usr = this.txt_usr.getText();
        String contra = this.txt_contra.getText();

        for (Camp camp : Modelos.ModGeneral.Lista_camp) {
            for (Empleados empleados : camp.getLista_emp()) {
                if (empleados.getUsuario().equals(usr) && empleados.getClave().equals(contra)) {
                    return true;
                }
            }
        }

        return false;
    }

}
