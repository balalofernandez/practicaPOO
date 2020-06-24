/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicapoo;

import Piezas.Pieza;

/**
 *
 * @author balalo
 */
public class Casilla {
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
    
    public String getStringPieza(){
        return Character.toString(this.pieza.getLetra());
    }
}
