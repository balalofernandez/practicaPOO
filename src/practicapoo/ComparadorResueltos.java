/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicapoo;

import java.util.Comparator;

/**
 *
 * @author balalo
 */
public class ComparadorResueltos implements Comparator{
    @Override 
    public int compare(Object o1, Object o2){
        Usuario u1 = (Usuario) o1;
        Usuario u2 = (Usuario) o2;
        if (u1.getNumProblemasResueltos() > u2.getNumProblemasResueltos())
            return 1;
        if (u1.getNumProblemasResueltos() < u2.getNumProblemasResueltos())
            return -1;
        else 
            return 0;
    }
}
