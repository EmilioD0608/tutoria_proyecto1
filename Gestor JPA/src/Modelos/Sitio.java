/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import javafx.collections.FXCollections;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javafx.collections.ObservableList;
import javax.persistence.OneToMany;

@Entity

public class Sitio implements Serializable   {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sitio_id;

    @Basic
    private String sitio_nombre;
    private String sitio_url;
    
    @OneToMany (mappedBy="sitio_id")
    private LinkedList<Sesion> listaSesiones;// = FXCollections.observableArrayList();

    public Sitio() {
    }

    public Sitio( String sitio_nombre, String sitio_url, LinkedList<Sesion> listaSesiones) {
        this.sitio_nombre = sitio_nombre;
        this.sitio_url = sitio_url;
        this.listaSesiones = listaSesiones;
    }

    public LinkedList<Sesion> getListaSesiones() {
        return listaSesiones;
    }

    public void setListaSesiones(LinkedList<Sesion> listaSesiones) {
        this.listaSesiones = listaSesiones;
    }
    
    public void setSesion(Sesion sesion){
        this.listaSesiones.add(sesion);
    }

  
    public int getSitio_id() {
        return sitio_id;
    }

    public void setSitio_id(int sitio_id) {
        this.sitio_id = sitio_id;
    }

    public String getSitio_nombre() {
        return sitio_nombre;
    }

    public void setSitio_nombre(String sitio_nombre) {
        this.sitio_nombre = sitio_nombre;
    }

    public String getSitio_url() {
        return sitio_url;
    }

    public void setSitio_url(String sitio_url) {
        this.sitio_url = sitio_url;
    }

    @Override
    public String toString() {
        return  sitio_nombre ;
    }

}
