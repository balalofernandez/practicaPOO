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
<<<<<<< HEAD
            aux += "         ";
=======
<<<<<<< HEAD
            aux += "        ";
=======
            String a = "pepe";
            aux += "  -       ";
>>>>>>> 16f349990832f156f304f926f70ad1d0dd900d7f
>>>>>>> 952df348c1169b45d120c323d909613b3d0c7c7d
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
