/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author e_d_d
 */
public class productos {
    private String nombre;
    private ArrayList<Fecha> listaFecha = new ArrayList<Fecha>();

    public productos(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Fecha> getListaFecha() {
        return listaFecha;
    }

    public void setListaFecha(Fecha listaFecha) {
        this.listaFecha.add(listaFecha);
    }
    
    

    @Override
    public String toString() {
        return  nombre;
    }
    
    
    
}
