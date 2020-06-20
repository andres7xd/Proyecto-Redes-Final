/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor1 ;


import java.io.Serializable;

/**
 *
 * @author andre
 */
public class paraenviar implements Serializable{
     private static final long serialVersionUID = 6529685098267757694L;
    public String nombre;
    

    public paraenviar(String nombre) {
        this.nombre = nombre;
    }
    
    
}
