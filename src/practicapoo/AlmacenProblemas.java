/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicapoo;

import Piezas.Alfil;
import Piezas.Caballo;
import Piezas.Color;
import Piezas.Dama;
import Piezas.Peon;
import Piezas.Pieza;
import Piezas.Rey;
import Piezas.Torre;
import Piezas.Vacia;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author balalo
 */
public class AlmacenProblemas {
    private ArrayList<Problema> problemas;
    private final int max = 8;
    
    public AlmacenProblemas(){
        problemas = new ArrayList<>();
    }
    
    public ArrayList<Problema> getProblemas(){
        return this.problemas;
    }
    
    public void subirProblema(String fichero)throws java.io.FileNotFoundException, TablaNoValidaException{// En vez de pasar un problema, pasamos directamente la ruta 
        try {
            FileReader fr= new FileReader(fichero);
            BufferedReader entrada = new BufferedReader(fr);
            String lectura;
            String texto= "";
            while((lectura = entrada.readLine()) != null){
                texto += lectura;
                texto += ",";//SEPARO EL TABLERO POR COMAS  
            }
            entrada.close();
            texto= texto.toUpperCase();//POR SEGURIDAD CAMBIO LAS LETRAS A MAYUSCULAS
            String[] captura = texto.split(",");//DIVIDO EL TEXTO ENTERO DONDE PONE TODAS LAS PIEZAS EN UN ARRAY CON LAS 64 CASILLAS Y LA PIEZA
            ArrayList<String> soluciones = new ArrayList<>();
                for (int i=64; i<captura.length; i++){
                    soluciones.add(captura[i]);
            }
                
            String[][] subcaptura= new String[max][max];
            
            for(int i=0; i<64; i++){//CON ESTO LO QUE CONSIGO ES UN ARRAY BIDIMENSIONAL CON LAS PIEZAS
                subcaptura[i/max][i%max]= captura[i];              
            }
            
            Casilla[][] tablero = new Casilla[max][max];

            if(this.validarProblema(subcaptura)){
                for(int i= 0; i<max; i++){
                    char fila = (char) ('a'+i);
                    for(int j=0; j<max; j++){
                        switch (subcaptura[i][j]){
                            case "V": //YA ESTAN EN MAYUSCULAS!! SOLO PONGO LAS MAYUSC.
                                Pieza x = new Vacia();
                                Casilla cv = new Casilla(i,fila,x);
                                tablero[i][j] = cv;
                                break;
                            case "PN":
                                Pieza pn = new Peon(Color.NEGRA);
                                Casilla cpn = new Casilla(i,fila,pn);
                                tablero[i][j] = cpn;
                                break;
                            case "PB":
                                Pieza pb = new Peon(Color.BLANCA);
                                Casilla cpb = new Casilla(i,fila,pb);
                                tablero[i][j] = cpb;
                                break;
                            case "CN":
                                Pieza cn = new Caballo(Color.NEGRA);
                                Casilla ccn = new Casilla(i,fila,cn);
                                tablero[i][j] = ccn;
                                break;
                            case "CB":
                                Pieza cb = new Caballo(Color.BLANCA);
                                Casilla ccb = new Casilla(i,fila,cb);
                                tablero[i][j] = ccb;
                                break;
                            case "AN":
                                Pieza an = new Alfil(Color.NEGRA);
                                Casilla can = new Casilla(i,fila,an);
                                tablero[i][j] = can;
                                break;
                            case "AB":
                                Pieza ab = new Alfil(Color.BLANCA);
                                Casilla cab = new Casilla(i,fila,ab);
                                tablero[i][j] = cab;
                                break;
                            case "TN":
                                Pieza tn = new Torre(Color.NEGRA);
                                Casilla ctn = new Casilla(i,fila,tn);
                                tablero[i][j] = ctn;
                                break;
                            case "TB":
                                Pieza tb = new Torre(Color.BLANCA);
                                Casilla ctb = new Casilla(i,fila,tb);
                                tablero[i][j] = ctb;
                                break;
                            case "RN":
                                Pieza rn = new Rey(Color.NEGRA);
                                Casilla crn = new Casilla(i,fila,rn);
                                tablero[i][j] = crn;
                                break;
                            case "RB":
                                Pieza rb = new Rey(Color.BLANCA);
                                Casilla crb = new Casilla(i,fila,rb);
                                tablero[i][j] = crb;
                                break;
                            case "DN":
                                Pieza dn = new Dama(Color.NEGRA);
                                Casilla cdn = new Casilla(i,fila,dn);
                                tablero[i][j] = cdn;
                                break;
                            case "DB":
                                Pieza db = new Dama(Color.BLANCA);
                                Casilla cdb = new Casilla(i,fila,db);
                                tablero[i][j] = cdb;
                                break;
                        }
                    }
                }
            Tablero t = new Tablero(tablero);
            Problema problema = new Problema(t, soluciones);
            this.problemas.add(problema);
            }
            else{
                throw new TablaNoValidaException(); 
                    }
            
            }
            catch(java.io.FileNotFoundException fnfex) {
                throw fnfex;
            }
            catch(java.io.IOException ioex) {
                System.out.println("Excepción de E/S:" + ioex);
            }
    }
    
    public boolean validarProblema(String[][] tabla){
        //Vamos a comprobar que hay un rey por cada bando y solo uno
        //Tambien se comprueba que haya el numero máximo de piezas posibles
        int numRN= 0;
        int numRB = 0;
        int numPN = 0;
        int numPB = 0;
        int numTN = 0;
        int numTB = 0;
        int numAB = 0;
        int numAN = 0;
        int numCB = 0;
        int numCN = 0;
        int numDB = 0;
        int numDN = 0;
        for(int i=0; i<max; i++){
            for(int j=0; j<max; j++){
                switch(tabla[i][j]){
                        case "PN":
                            numPN++;
                            break;
                        case "CN":
                            numCN++;
                            break;
                        case "AN":
                            numAN++;
                            break;
                        case "TN":
                            numTN++;
                            break;
                        case "DN":
                            numDN++;
                            break;
                        case "CB":
                            numCB++;
                            break;
                        case "PB":
                            numPB++;
                            break;
                        case "AB":
                            numAB++;
                            break;
                        case "TB":
                            numTB++;
                            break;
                        case "DB":
                            numDB++;
                            break; 
                        case "RN":
                            numRN++;
                            break;
                        case "RB":
                            numRB++;
                            break;
                }
            }
        }
        
        if(numRB != 1){
            return false;
        }
        else if(numRN != 1){
            return false;
        }
        else if((numPN < 9)&&(numPB < 9)){
            if((numDN+numPN <10)&&(numCN+numPN <11)&&(numAN+numPN <11)&&(numTN+numPN <11)&&(numDB+numPB <10)&&(numCB+numPB <11)&&(numAB+numPB <11)&&(numTB+numPB <11))
                        return (numCN+numTN+numPN-8<4)&&(numTN+numAN+numPN-8<4)&&(numCN+numDN+numPN-8<3)
                                &&(numAN+numDN+numPN-8<3)&&(numTN+numDN+numPN-8<3)&&(numCN+numAN+numPN-8<4)
                                &&(numCB+numTB+numPB-8<4)&&(numTB+numAB+numPB-8<4)&&(numCB+numDB+numPB-8<3)
                                &&(numAB+numDB+numPB-8<3)&&(numTB+numDB+numPB-8<3)&&(numCB+numAB+numPB-8<4);
                
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
    
}
