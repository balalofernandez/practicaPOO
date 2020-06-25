/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicapoo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author balalo
 */
public class Login implements Serializable{
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
    
    public boolean autenticar(Usuario u) throws UsuarioNoEncontradoException{
        if (this.usuarios.contains(u)){
            Iterator i = this.usuarios.iterator();
            boolean encontrado = false;
            Usuario usu = new Usuario();
            while (i.hasNext() && !encontrado){
                usu = (Usuario) i.next();
                if(usu.equals(u))
                    encontrado = true;
            }
            return encontrado && usu.getPassword().equals(u.getPassword());
        }
        else
            throw new UsuarioNoEncontradoException();
    }
    
    public ArrayList<Usuario> getUsuarios(){
        return this.usuarios;
    }
            
            
}
