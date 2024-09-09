/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.util.ArrayList;

/**
 *
 * @author e_d_d
 */
public class Camp {
    private String nombre;
    private ArrayList<Empleados> lista_emp = new ArrayList<Empleados>();
    private ArrayList<Donantes> lista_donante = new ArrayList<Donantes>();

    public Camp(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Empleados> getLista_emp() {
        return lista_emp;
    }

    public void setLista_emp(Empleados lista_emp) {
        this.lista_emp.add(lista_emp);
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Donantes> getLista_donante() {
        return lista_donante;
    }

    public void setLista_donante(Donantes lista_donante) {
        this.lista_donante.add(lista_donante);
    }
    
    

    @Override
    public String toString() {
        return  nombre ;
    }
    
    
    
}
