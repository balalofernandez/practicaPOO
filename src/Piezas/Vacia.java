/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Piezas;

import java.io.Serializable;

/**
 *
 * @author balalo
 */
public class Vacia extends Pieza implements Serializable{
    private static final char SIMBOLO ='V';
    
    public Vacia(){
        super(SIMBOLO);
    }
    
}
