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
public class Persona {
    private String nombre;
    private String apellido;
    private int altura;
    
    private ArrayList<Deporte> dep = new ArrayList<Deporte>();

    public Persona(String nombre, String apellido, int altura) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.altura = altura;
    }

    public ArrayList<Deporte> getDep() {
        return dep;
    }

    public void setDep(Deporte deporte) {
        this.dep.add(deporte);
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "nombre=" + nombre + ", apellido=" + apellido + '}';
    }
    
    
}
