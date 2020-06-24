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
        int columna = 9;
        for(int i=0; i<max; i++){
            columna --;
            aux += columna;
            aux += "       ";
            String a = "pepe";
            for(int j=0; j<max;j++){
                
                aux+= casillas[i][j].toString() + "       ";
                if (casillas[i][j].toString().length()==1){
                    aux=aux + "   ";
                }
            }
            aux=aux+ "\n" + "\n";
        }
     return aux;
            
    }
}
