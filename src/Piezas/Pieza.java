/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Piezas;

/**
 *
 * @author balalo
 */
public abstract class Pieza {
    private char letra;
    private Color color;
    
    public Pieza(char letra, Color color){
        this.letra = letra;
        this.color = color;
    }
    public Pieza(char letra){
        this.letra = letra;
    }
    
    
}
