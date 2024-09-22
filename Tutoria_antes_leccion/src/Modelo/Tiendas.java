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
public class Tiendas {
    private String nombre;
    private ArrayList<productos> listaPrpd = new ArrayList<productos>();

    public Tiendas(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<productos> getListaPrpd() {
        return listaPrpd;
    }

    public void setListaPrpd(productos prod) {
        this.listaPrpd.add(prod) ;
    }

    
    @Override
    public String toString() {
        return nombre ;
    }
    
    
    
}
