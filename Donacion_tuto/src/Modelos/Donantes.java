/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.time.LocalDate;

/**
 *
 * @author e_d_d
 */
public class Donantes {
    private String cedula;
    private LocalDate fecha_registro, fecha_tatuaje;

    public Donantes(String cedula, LocalDate fecha_registro, LocalDate fecha_tatuaje) {
        this.cedula = cedula;
        this.fecha_registro = fecha_registro;
        this.fecha_tatuaje = fecha_tatuaje;
    }

    
    
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public LocalDate getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDate fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public LocalDate getFecha_tatuaje() {
        return fecha_tatuaje;
    }

    public void setFecha_tatuaje(LocalDate fecha_tatuaje) {
        this.fecha_tatuaje = fecha_tatuaje;
    }
    
    
    
    
    
}
