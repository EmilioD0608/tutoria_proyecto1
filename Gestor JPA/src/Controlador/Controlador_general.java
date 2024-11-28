/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Controlador.Persistencia.Controlador_persistencia;
import Modelos.Sesion;
import Modelos.Sitio;
import java.util.LinkedList;

/**
 *
 * @author e_d_d
 */
public class Controlador_general {

     static  Controlador_persistencia Control = new Controlador_persistencia();
    //---------- Sitio -----------------
    public static  void CrearSitio(String nombre, String URL, LinkedList<Sesion> sesionesList) {
        try {

            Sitio sitio = new Sitio(nombre, URL, sesionesList);

            Control.nuevoSitio(sitio);
        } catch (Exception e) {
        }

    }

    public static void ActSitio(Sitio newsitio) {
        try {

            Control.actSitio(newsitio);
        } catch (Exception e) {
        }
    }

    public static Sitio BuscSitio(int ID) {
        try {
           

            Sitio sitio = Control.findSitio(ID);
            return sitio;
        } catch (Exception e) {
        }
        return null;
    }
    
    public static LinkedList<Sitio> ListaSitio(){
        try {
             LinkedList<Sitio> lista = Control.listaSitios();
             return lista;
        } catch (Exception e) {
        }
         return null;
       
    }
    public static void EliminarSitio(int ID){
        try {
            Sitio st = Control.findSitio(ID);
            for (Sesion ses : st.getListaSesiones()) {
                
                Control.EliminarSesion(ses.getSes_id());
                
            }
            Control.eliminarSitio(ID);
            
            
        } catch (Exception e) {
        }
    }
    
    
    //------------ Sesiones ------------
    public static Sesion crearSesion( Sitio sito, String usr, String pass ){
        try {
             Sesion sesion = new Sesion(sito,usr,pass );
        Control.nuevaSesion(sesion);
        return sesion;
        } catch (Exception e) {
        }
         return null;
      
        
        
    }
    
    public static Sesion buscarSesion(int ID){
        try {
            Sesion ses = Control.findSesion(ID);
            return ses;
        } catch (Exception e) {
        }
         return null;
    }
  public static void ActSesion(Sesion newsesion) {
        try {

            Control.actSesion(newsesion);
        } catch (Exception e) {
        }
    }
  
   public static void EliminarSesion(int ID){
        try {
                Control.EliminarSesion(ID);
                

            
        } catch (Exception e) {
        }
    }
  
}
