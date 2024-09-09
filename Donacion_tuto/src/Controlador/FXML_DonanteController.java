/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlador;

import Modelos.Camp;
import Modelos.Donantes;
import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author e_d_d
 */
public class FXML_DonanteController implements Initializable {

    @FXML
    private Button btn_guardar;
    @FXML
    private Button btn_cerrar;
    @FXML
    private ComboBox<Camp> cbx_camp;
    @FXML
    private DatePicker dtp_registro;
    @FXML
    private CheckBox chx_tatuaje;
    @FXML
    private DatePicker dtp_tatuaje;
    @FXML
    private TextField txt_cedula;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.cbx_camp.getItems().addAll(Modelos.ModGeneral.Lista_camp);
        verf_check();
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

    @FXML
    private void acc_guardar(ActionEvent event) {
        try {
            if (fun_buscarDonante() != null) {
                if (fun_validarRegistro()) {
                    fun_actualizar();

                } else {
                    System.out.println("No han pasado 3 meses");
                }
            } else {
                fun_guardar();

            }

        } catch (Exception e) {
            System.out.println("nononon");
        }
    }

    @FXML
    private void acc_cerrar(ActionEvent event) {
        cerrarFormulario();
    }

    @FXML
    private void acc_tautaje(ActionEvent event) {
        try {

            verf_check();

        } catch (Exception e) {
        }

    }
    public void fun_actualizar(){
         Donantes donante = fun_buscarDonante();
         donante.setFecha_registro(this.dtp_registro.getValue());
         System.out.println(donante.getCedula());
    }

    public void fun_guardar() {
        String cedula = this.txt_cedula.getText();
        LocalDate registro = this.dtp_registro.getValue();
        LocalDate fecha_tatuaje;
        if (this.chx_tatuaje.isSelected()) {
            fecha_tatuaje = this.dtp_tatuaje.getValue();
        } else {
            fecha_tatuaje = null;
        }

        Donantes donante = new Donantes(cedula, registro, fecha_tatuaje);

        this.cbx_camp.getSelectionModel().getSelectedItem().setLista_donante(donante);

        for (Donantes donantes : this.cbx_camp.getSelectionModel().getSelectedItem().getLista_donante()) {
            System.out.println(donantes.getCedula());

        }

    }

    public void verf_check() {
        if (this.chx_tatuaje.isSelected()) {
            this.chx_tatuaje.setText("Si tiene tatuaje");
            this.dtp_tatuaje.setVisible(true);

        } else {
            this.chx_tatuaje.setText("No tiene tatuaje");
            this.dtp_tatuaje.setVisible(false);
            this.dtp_tatuaje.setValue(null);
            this.dtp_tatuaje.getEditor().clear();
        }
    }

    public Donantes fun_buscarDonante() {
        String cedula = this.txt_cedula.getText();

        for (Donantes don : this.cbx_camp.getSelectionModel().getSelectedItem().getLista_donante()) {
            if (don.getCedula().equals(cedula)) {
                return don;
            }
        }
        return null;

    }

    public boolean fun_validarRegistro() {

        LocalDate act_registro = this.dtp_registro.getValue();
        Donantes donante = fun_buscarDonante();
        LocalDate ult_registro = donante.getFecha_registro();

        long diferencia = ChronoUnit.MONTHS.between(ult_registro, act_registro);

        if (diferencia >= 3) {
            return true;
        }
        return false;

    }

}
