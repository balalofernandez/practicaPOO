/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicapoo;

import Piezas.Pieza;
import java.io.Serializable;

/**
 *
 * @author balalo
 */
public class Casilla implements Serializable{
    private int coordenadaX;
    private char coordenadaY;
    private boolean libre;
    private Pieza pieza;
    
    public Casilla(int coordenadaX, char coordenadaY){
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }
    
    public Casilla(int coordenadaX, char coordenadaY, Pieza p){
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.pieza = p;
    }
    
    @Override
    public String toString(){
        return this.pieza.toString();
    }
}
