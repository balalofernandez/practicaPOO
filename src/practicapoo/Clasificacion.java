/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicapoo;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author diego
 */
public class Clasificacion {
    
    ArrayList<Usuario> clasificacion;
    
    public Clasificacion(){
        this.clasificacion = new ArrayList<>();
    } 
    
    public void ordenadaPorcentaje(){
        Collections.sort(clasificacion);
    }
    
    public void ordenadaResueltos(){
        Collections.sort(clasificacion, )
    }
}
