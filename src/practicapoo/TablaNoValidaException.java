/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicapoo;

import java.io.Serializable;

/**
 *
 * @author balalo
 */

public class TablaNoValidaException extends Exception  implements Serializable{
    public TablaNoValidaException(String mensaje){
        super (mensaje);
    }
    public TablaNoValidaException(){
        super();
    }
}
