/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Piezas;

import static Piezas.Color.*;
import java.io.Serializable;

/**
 *
 * @author balalo
 */
public abstract class Pieza implements Serializable{
    private char letra;
    private Color color;
    
    public Pieza(char letra, Color color){
        this.letra = letra;
        this.color = color;
    }
    public Pieza(char letra){
        this.letra = letra;
    }
    
    @Override
    public String toString(){
        String aux = Character.toString(this.letra);
        if (this.color == BLANCA){
            return aux+"B";
        }
        if (this.color == NEGRA){
            return aux+"N";
        }
        return aux;
    }
    
    
}
