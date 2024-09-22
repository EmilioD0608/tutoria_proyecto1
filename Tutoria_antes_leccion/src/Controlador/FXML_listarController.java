/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlador;

import Modelo.Fecha;
import Modelo.Tiendas;
import Modelo.productos;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author e_d_d
 */
public class FXML_listarController implements Initializable {

    @FXML
    private Button btn_cerrar;
    @FXML
    private ComboBox<Tiendas> cbx_tiendas;
    @FXML
    private ComboBox<productos> cbx_productos;
    @FXML
    private TableView<Fecha> tv_fecha;
    @FXML
    private TableColumn<?, ?> col_fecha;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         this.cbx_tiendas.getItems().addAll(Modelo.ModGeneral.listaTienda);
        
        this.col_fecha.setCellValueFactory(new PropertyValueFactory("fecha"));
        // TODO
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

    @FXML
    private void acc_productos(ActionEvent event) {
          try {
            Object evento = event.getSource();
            if (evento.equals(this.cbx_productos)) { //si hico clic en el combo box
               this.tv_fecha.getItems().clear();
                 this.tv_fecha.getItems().addAll(this.cbx_productos.getSelectionModel().getSelectedItem().getListaFecha());
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
