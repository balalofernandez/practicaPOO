/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicapoo;

import java.util.ArrayList;

/**
 *
 * @author balalo
 */
public class Problema {
    private int resuelto_por;
    private double porcentaje_exito;
    private ArrayList<String> jugada_ganadora;//Puede haber varias soluciones
    private boolean valido;
    private ArrayList<Usuario> usuarios;
    private Tablero tablero;//Cada problema tiene un único tablero
    
    public Problema(){
        this.resuelto_por = 0;
        this.porcentaje_exito = 0;
        this.usuarios = new ArrayList<>();
        this.tablero = new Tablero();
        this.jugada_ganadora = new ArrayList<>();
    }
    public Problema(Tablero tablero, ArrayList<String> jugada){
        this.resuelto_por = 0;
        this.porcentaje_exito = 0;
        this.usuarios = new ArrayList<>();
        this.tablero = tablero;
        this.jugada_ganadora = jugada;
    }
    
    public Tablero getTablero(){
        return this.tablero;
    }
}
