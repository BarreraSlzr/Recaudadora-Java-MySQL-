/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author emmanuelbarrera
 */
public class Querys {
    ResultSet resultado = null;

    public ResultSet Select(String Donde, String Tabla){
        try {
            Conexion db = new Conexion();
            db.Obtener();

            String Query = "SELECT * FROM " + Tabla + " WHERE " + Donde;
            
            db.comando = db.conexion.createStatement();
            db.registro = db.comando.executeQuery(Query);
            resultado = db.registro;
        } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    public ResultSet Select(String Seleccion, String Donde, String Tabla){
        try {
            Conexion db = new Conexion();
            db.Obtener();

            String Query = "SELECT " + Seleccion + " FROM " + Tabla + " WHERE " + Donde;
            
            db.comando = db.conexion.createStatement();
            db.registro = db.comando.executeQuery(Query);
            resultado = db.registro;
        } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    public int Insert(String Valores, String Lugar, String Select){
        boolean Updateable = false;
        int idInsert = -1;

        try {
            Conexion db = new Conexion();
            db.Obtener();

            String Query = "INSERT INTO " + Lugar + " VALUES (" + Valores + ")";

            db.comando = db.conexion.createStatement();
            db.comando.executeUpdate(Query);
            
            Lugar = Lugar.substring(0, Lugar.indexOf("("));
            Query = "SELECT MAX(" + Select +") FROM " + Lugar;
            db.comando = db.conexion.createStatement();
            db.registro = db.comando.executeQuery(Query);
            if(db.registro.next()){
                idInsert = db.registro.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idInsert;
    }
    public boolean Update(String Tabla, String Valores, String Donde){
        boolean Updatable = false;
        if(!Valores.equals("") && !Donde.equals("")){
            try {
                Conexion db = new Conexion();
                db.Obtener();

                String Query = "UPDATE " + Tabla + " SET " + Valores + " WHERE " + Donde;

                db.comando = db.conexion.createStatement();
                db.comando.executeUpdate(Query);
                Updatable = true;
            } catch (SQLException ex) {
                Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return Updatable;
    }
    public boolean Delete(String Tabla, String Donde){
        boolean Updatable = false;
        if(!Donde.equals("")){
            try {
                Conexion db = new Conexion();
                db.Obtener();

                String Query = "DELETE FROM " + Tabla + " WHERE " + Donde;

                db.comando = db.conexion.createStatement();
                db.comando.executeUpdate(Query);
                Updatable = true;
            } catch (SQLException ex) {
                Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return Updatable;
    }
}
