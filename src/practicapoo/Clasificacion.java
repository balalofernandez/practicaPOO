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
    
    public Clasificacion(Login login){
        this.clasificacion = login.getUsuarios();
    } 
    
    public void ordenadaPorcentaje(){
        Collections.sort(clasificacion);
    }
    
    public void ordenadaResueltos(){
        ComparadorResueltos comparador= new ComparadorResueltos();
        Collections.sort(clasificacion, comparador);
    }
    
    public ArrayList<Usuario> getUsuarios(){
        return this.clasificacion;
    }
    
    @Override
    public String toString (){
        String texto="";
        Integer i = 1;
        for (Usuario u: clasificacion){
            texto += i.toString()+") ";
            texto += u.toString()+"\n";
            texto += "Las estadisticas del usuario son"+ "\n";
            texto += u.mostrarEstadistica();
            texto += "\n";
            i++; 
        }
        return texto;
    }
}
