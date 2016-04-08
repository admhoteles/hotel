/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import Dao.ConfigHotel;
import dto.hotel;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Conexion;


/**
 *
 * @author edinson
 */
public class controlador {
 private Conexion c;
    private Connection co;
    
    public controlador(){}
    
    /**
     * Metodo que establece la conexion con la base de datos
     */
    private void conectar() {
        this.c = new Conexion();
        this.c.conectar();
        this.co = this.c.getConexion();

    }

    /**
     * Metodo que finaliza la conexion con la base de datos
     */
    private void desconectar() {
        try {
            this.co.close();
            this.co = null;
            this.c.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(AdministrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String agregarProducto(hotel produc) {
        String mensaje="";
        this.conectar();
        try {
            this.co.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(AdministrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConfigHotel ud = new ConfigHotel(this.co);
        mensaje = ud.agregarProducto(produc);
        if(mensaje.equals("error")){
            try {
                    co.rollback();
                    mensaje = "Ha ocurrido un error a la hora de registrar el usuario, Verifique los datos registrados";
                } catch (SQLException ex) {
                    Logger.getLogger(AdministrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
        }else {
            try {
                    co.commit();
                } catch (SQLException ex) {
                    Logger.getLogger(AdministrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        this.desconectar();

        return mensaje;
    }
    
    
    public String consultarProducto(hotel produc) {
        String mensaje="";
        this.conectar();
        try {
            this.co.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(AdministrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConfigHotel ud = new ConfigHotel(this.co);
        mensaje = ud.consultarProducto(produc);
        if(mensaje.equals("error")){
            try {
                    co.rollback();
                    mensaje = "Ha ocurrido un error a la hora de registrar el usuario, Verifique los datos registrados";
                } catch (SQLException ex) {
                    Logger.getLogger(AdministrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
        }else {
            try {
                    co.commit();
                } catch (SQLException ex) {
                    Logger.getLogger(AdministrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        this.desconectar();

        return mensaje;
    }
}

