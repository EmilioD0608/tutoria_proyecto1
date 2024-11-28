/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlador;

import Modelos.Sesion;
import Modelos.Sitio;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class FXMLCrearSitioController implements Initializable {

    @FXML
    private Button btn_guardar;
    @FXML
    private Button btn_cerrar;
    @FXML
    private TextField nomSit;
    @FXML
    private TextField id_Sit;
    @FXML
    private TextField url_Sit;

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
            
            //-- crear ---
            if(this.id_Sit.getText().equals("")){
                String nombre = this.nomSit.getText();
                String URL = this.url_Sit.getText();
                LinkedList<Sesion> sesionesList = new LinkedList<Sesion>();
                Controlador_general.CrearSitio(nombre, URL, sesionesList);
            }else{
                //--- editar ---
                Sitio sitio = Controlador_general.BuscSitio(Integer.parseInt(this.id_Sit.getText()));
                sitio.setSitio_nombre(this.nomSit.getText());
                sitio.setSitio_url(this.url_Sit.getText());
                       
                Controlador_general.ActSitio(sitio);
            }
            cerrar();
        } catch (Exception e) {
        }
    }

    @FXML
    private void acc_cerrar(ActionEvent event) {
        cerrar();
    }

    public void recuperarSitio(Sitio obj) {
        try {
            if (obj != null) {
                this.id_Sit.setText(Integer.toString(obj.getSitio_id()));
                this.nomSit.setText(obj.getSitio_nombre());
                this.url_Sit.setText(obj.getSitio_url());
            }

        } catch (Exception e) {
        }
    }
       public void cerrar(){
         try {
            //capturar escena y ventana a la que pertenece el boton y cerrarlo
            Stage stage =(Stage) this.btn_guardar.getScene().getWindow();
            stage.close();
        } catch (Exception e) {
        }
    }
}
