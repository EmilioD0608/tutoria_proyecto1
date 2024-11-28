/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Persistencia;

import Modelos.Sesion;
import Modelos.Sitio;
import java.util.LinkedList;
import java.util.List;



/**
 *
 * @author e_d_d
 */
public class Controlador_persistencia {
   
      

        

      SesionJpaController ses_jpac = new SesionJpaController();
    
    SitioJpaController Sti_jpac = new SitioJpaController();
    
    /*  public SitioJpaController(){
        emf = Persistence.createEntityManagerFactory("JPAU_Prueba");
    }*/
    
    //------- Funciones Sitios --------
    public void nuevoSitio(Sitio sitio) {
        try {
              Sti_jpac.create(sitio);
        } catch (Exception e) {
        }
  
    }
    
    public void actSitio(Sitio sitio){
        try {
            Sti_jpac.edit(sitio);
        } catch (Exception e) {
        }  
    }
    
       public Sitio findSitio(int ID){
        try {
            Sitio findSitio = Sti_jpac.findSitio(ID);
            return findSitio;
        } catch (Exception e) {
        }  
          return null;
    }
    
    public LinkedList<Sitio> listaSitios(){
        try {
            List<Sitio> listaaux  = Sti_jpac.findSitioEntities();
          LinkedList<Sitio> listaSitios = new LinkedList<Sitio>(listaaux);
        return listaSitios;
        } catch (Exception e) {
        }
          return null;
          
    }
    
    public void eliminarSitio(int ID){
        try {
            Sti_jpac.destroy(ID);
        } catch (Exception e) {
        }
    }
    
    
    
    //------ Funciones Sesiones ------------
    public void nuevaSesion(Sesion sesion){
        try {
            ses_jpac.create(sesion);
        } catch (Exception e) {
        }
    }
    
    public void actSesion(Sesion sesion){
        try {
            ses_jpac.edit(sesion);
        } catch (Exception e) {
        }  
    }
    
     public Sesion findSesion(int ID){
        try {
            Sesion findSesion = ses_jpac.findSesion(ID);
            return findSesion;
        } catch (Exception e) {
        }  
          return null;
    }
     public void EliminarSesion(int ID){
         try {
             ses_jpac.destroy(ID);
         } catch (Exception e) {
         }
     }
    
}
