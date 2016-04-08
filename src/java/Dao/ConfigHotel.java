/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import util.Conexion;
import dto.hotel;
/**
 *
 * @author edinson
 */
public class ConfigHotel {

    
    private Connection co;
    private ResultSet rs;
    private PreparedStatement ps;
    
    public ConfigHotel(Connection c){
        co = c;
    }
    
    //Metodos SQL
    public String agregarProducto(hotel p){
        String msg = "exito";
        try{
            this.ps = this.co.prepareStatement("INSERT INTO datos (slogan, nombre) VALUES (?,?);");
            this.ps.setString(1, p.getNombre());
            this.ps.setString(2, p.getslogan());
          
            
            this.ps.execute();
            
        }catch(Exception e){
            msg = e.getMessage();
        }finally{
            try {
                this.ps.close();
                this.ps = null;
            } catch (SQLException ex) {
                Logger.getLogger(ConfigHotel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return msg;
    }

    public String consultarProducto(hotel produc) {
        String resultado="";
        
        try{
            this.ps = this.co.prepareStatement("SELECT Nombre, slogan FROM datos WHERE id = 1;");
            
            
            this.rs = this.ps.executeQuery();
            
            if(rs!=null){
                while(rs.next()){
                    resultado += this.rs.getString("Nombre");
                    resultado += ";";
                    resultado += this.rs.getString("slogan");
                    resultado += ";";
                    
                }
            }
            if(resultado.isEmpty())
            {
                resultado="error";
            }
            
        }catch(Exception e){
        resultado = "error";
        }finally{
            try {
                this.ps.close();
                this.ps = null;
                this.rs = null;
            } catch (SQLException ex) {
                Logger.getLogger(ConfigHotel.class.getName()).log(Level.SEVERE, null, ex);
            }
}
        return resultado;
    } 
}
