/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlador;

import Modelo.Fecha;
import Modelo.Tiendas;
import Modelo.productos;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author e_d_d
 */
public class FXML_fechaController implements Initializable {

    @FXML
    private Button btn_guardar;
    @FXML
    private Button btn_cerrar;
    @FXML
    private ComboBox<Tiendas> cbx_tiendas;
    @FXML
    private ComboBox<productos> cbx_productos;
    @FXML
    private DatePicker dp_fecha;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.cbx_tiendas.getItems().addAll(Modelo.ModGeneral.listaTienda);
    }    

    @FXML
    private void acc_guardar(ActionEvent event) {
        LocalDate fecha = this.dp_fecha.getValue();
        Fecha fechaa = new Fecha(fecha);
        this.cbx_productos.getSelectionModel().getSelectedItem().setListaFecha(fechaa);
        
    }

    @FXML
    private void acc_cerrar(ActionEvent event) {
    }

    @FXML
    private void acc_tiendas(ActionEvent event) {
         try {
            Object evento = event.getSource();
            if (evento.equals(this.cbx_tiendas)) { //si hico clic en el combo box
             this.cbx_productos.getItems().clear();
             this.cbx_productos.getItems().addAll(this.cbx_tiendas.getSelectionModel().getSelectedItem().getListaPrpd());

            }
        } catch (Exception e) {
        }
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
    
}
