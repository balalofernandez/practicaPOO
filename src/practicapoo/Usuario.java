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
public class Usuario implements Comparable{
    private String login;
    private String password;
    private int problemas_intentados;
    private int errores;
    private double porcentaje_exito;
    private ArrayList<Problema> problemasResueltos;
    
    public Usuario(String nombre, String pwd){
        this.login = nombre;
        this.password = pwd;
        this.problemas_intentados = 0;
        this.errores = 0;
        this.porcentaje_exito = 0;        
        this.problemasResueltos = new ArrayList<>();
    }
    public Usuario(){
        this.login = "";
        this.password = "";
    }
    
    public String getNombre(){
        return this.login;
    }
    public String getPassword(){
        return this.password;
    }
    
    @Override
    public boolean equals(Object o){
        if(o == this){
            return true;
        }
        if(o == null)
            return false;
        if(this.getClass() != o.getClass())
            return false;
        Usuario usuario = (Usuario) o;
        return (usuario.getNombre().equals(this.getNombre()));                 
            
    }
    
    @Override
    public String toString(){
        return this.login;
    }
    
    public int getProblemasIntentados (){
        return this.problemas_intentados;
    }
    
    public int getErrores (){
        return this.errores;
    }
    
    public double getPorcentageExito(){
        return this.porcentaje_exito;
    }
    
    public ArrayList<Problema> getProblemasResueltos(){
        return this.problemasResueltos;
    }
    
    public int getNumProblemasResueltos(){
        return this.problemasResueltos.size();
    }
    
    public void añadirIntentado(){
        this.problemas_intentados++;
    }
    
    public void añadirError(){
        this.errores++;
    }
    
    public void calculaPorcentajeExito(){
        if (this.problemas_intentados!=0){
            this.porcentaje_exito=(problemasResueltos.size()/problemas_intentados)*100;
        }
    }
    
    public void añadirProblemaResuelto (Problema problema){
        this.problemasResueltos.add(problema);
    }
    
    @Override
    public int compareTo(Object o){
        Usuario usu = (Usuario) o;
        Double x = this.getPorcentageExito();
        Double y = usu.getPorcentageExito();
        return x.compareTo(y);
    }
    
    public boolean verSiResuelto(Problema p){
        return this.problemasResueltos.contains(p);
    }
            
}   
