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
        ComparadorResueltos comparador= new ComparadorResueltos();
        Collections.sort(clasificacion, comparador);
    }
    
    @Override
    public String toString (){
        String texto="";
        Integer i = 0;
        for (Usuario u: clasificacion){
           texto += i.toString()+") ";
            texto += u.toString()+"\n";
            texto += "Las estadisticas del usuarios son"+ "\n";
            texto += u.mostrarEstadistica();
            texto += "\n";
            i++; 
        }
    }
}
