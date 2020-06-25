/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicapoo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author balalo
 */
public class Problema implements Serializable{
    private int resuelto_por;
    private double porcentaje_exito;
    private ArrayList<String> jugada_ganadora;//Puede haber varias soluciones
    private boolean valido;
    private ArrayList<Usuario> usuarios;
    private Tablero tablero;//Cada problema tiene un único tablero
    private int numIntentos;
    
    public Problema(){
        this.resuelto_por = 0;
        this.porcentaje_exito = 0;
        this.usuarios = new ArrayList<>();
        this.tablero = new Tablero();
        this.jugada_ganadora = new ArrayList<>();
        this.numIntentos = 0;
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
    
    public boolean solucionValida(String sol){
        return this.jugada_ganadora.contains(sol);
    }
    
    public int numeroUsuarioResuelto(){
        return resuelto_por;
    }
    public double porcentajeExito(){
        return this.porcentaje_exito;
    }
    public void setPorcentajeExito(){
        if (this.numIntentos != 0){
            this.porcentaje_exito = (this.resuelto_por *100)/ this.numIntentos;
        }
    }
    
    public void incrementarIntento(){
        this.numIntentos++;
    }
    
    public void addResuelto(Usuario usu){
        this.resuelto_por ++;
        this.usuarios.add(usu);
    }
    
    public ArrayList<Usuario> getUsuariosResuelto(){
        return this.usuarios;
    }
    
    @Override
    public boolean equals(Object o){
        if (o==this)
            return true;
        if (o==null)
            return false;
        if (this.getClass()!=o.getClass())
            return false;
        Problema problema = (Problema) o;
        return (problema.getTablero().equals(this.getTablero()));  
    }
    
}
