/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author e_d_d
 */
@Entity
public class Sesion implements Serializable   {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ses_id;
    
    @ManyToOne
    private Sitio sitio_id;
    
    @Basic
    private String ses_user;
    private String ses_passw;

    public Sesion() {
    }

    public Sesion( Sitio sitio_id, String ses_user, String ses_passw) {
        this.sitio_id = sitio_id;
        this.ses_user = ses_user;
        this.ses_passw = ses_passw;
    }



    public Sitio getSitio_id() {
        return sitio_id;
    }

    public void setSitio_id(Sitio sitio_id) {
        this.sitio_id = sitio_id;
    }

   
    public int getSes_id() {
        return ses_id;
    }

    public void setSes_id(int ses_id) {
        this.ses_id = ses_id;
    }

  

    public String getSes_user() {
        return ses_user;
    }

    public void setSes_user(String ses_user) {
        this.ses_user = ses_user;
    }

    public String getSes_passw() {
        return ses_passw;
    }

    public void setSes_passw(String ses_passw) {
        this.ses_passw = ses_passw;
    }
    
    
          
    
}
