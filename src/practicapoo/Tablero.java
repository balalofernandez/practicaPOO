/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicapoo;

/**
 *
 * @author balalo
 */
public class Tablero {
    private Casilla[][] casillas;
    private final int max = 8;
    
    public Tablero(){
        this.casillas = new Casilla[max][max];
    };
    
    public Tablero(Casilla[][] casillas){
        this.casillas = casillas;
    }
    
    public String pintarTablero(){
        String aux="";
        for(int i=0; i<max; i++){
            for(int j=0; j<max;j++){
                aux=aux + casillas[j][i].getStringPieza() + ",";
            }
            aux=aux+"\n";
        }
     return aux;
            
    }
}
