/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mundo;
import dto.hotel;
import controller.controlador;

/**
 *
 * @author edinson
 */
public class facade {

    
    public facade(){};
    
    public String agregar(hotel p){
        controlador pr = new controlador();
        return pr.agregarProducto(p);
    }
    
    public String consultar(hotel p){
        controlador pr = new controlador();
        return pr.consultarProducto(p);
    }
    
}
