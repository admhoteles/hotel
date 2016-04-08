/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
import org.postgresql.Driver;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Manuel
 */
public class Conexion {
    //jdbc:mysql://sandbox2.ufps.edu.co:3306/ufps_93
    private String direccion="jdbc:postgresql://localhost/Hotel";
    
    private String user="postgres";
    private String password="123456789";
    private java.sql.Connection con;
    
    public Conexion(){}
    
    public void conectar(){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        try {
            this.con=DriverManager.getConnection(direccion, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void desconectar(){
        try {
            this.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public java.sql.Connection getConexion(){
        return con;
    }
    

    
}