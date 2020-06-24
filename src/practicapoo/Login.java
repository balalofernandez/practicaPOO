/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicapoo;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author balalo
 */
public class Login {
    private ArrayList<Usuario> usuarios;
    
    public Login(){
        this.usuarios = new ArrayList<>();
    }
    
    public boolean registrar(Usuario u){
        if (!this.usuarios.contains(u)){
            this.usuarios.add(u);
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean autenticar(Usuario u){
        if (this.usuarios.contains(u)){
            Iterator i = this.usuarios.iterator();
            boolean encontrado = false;
            while (i.hasNext() && !encontrado){
                Usuario usu = (Usuario) i.next();
                if(usu.equals(u))
                    encontrado = true;
            }
            Usuario usu = (Usuario) i;
            return encontrado && usu.getPassword().equals(u.getPassword());
        }
        else
            return false;
    }
    
    public ArrayList<Usuario> getUsuarios(){
        return this.usuarios;
    }
            
            
}
