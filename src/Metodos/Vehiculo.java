/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * /* open the template in the/*.
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
public class Vehiculo {

    public Vehiculo(int idUsuario){
        this.Modelo = "";
        this.Marca = "";
        this.Placas = "";
        this.Color = "";
        this.Serie = "";
        this.Motor = "";
        this.TarjCirculacion = 0;
        this.Ano = 0;
        this.idVehiculo = 0;
        this.idUsuario = idUsuario;
        this.existeEnBD = false;
    }
    public Vehiculo(int idVehiculo, int idUsuario){
        try {
            this.existeEnBD = getVehiculo(idVehiculo);
        } catch (SQLException ex) {
            Logger.getLogger(Vehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public final boolean getVehiculo(int idVehiculo) throws SQLException{
        Metodos.Querys query = new Metodos.Querys();
        ResultSet resultQuery;
        boolean selected = false;

        resultQuery = query.Select("idVehiculo = " + idVehiculo, "vehiculos");
        if(resultQuery.next()){
            this.Modelo = resultQuery.getString("Modelo");
            this.Marca = resultQuery.getString("Marca");
            this.Placas = resultQuery.getString("Placas");
            this.Color = resultQuery.getString("Color");
            this.Serie = resultQuery.getString("Serie");
            this.Motor = resultQuery.getString("Motor");
            this.TarjCirculacion = resultQuery.getInt("TarjCirculacion");
            this.Ano = resultQuery.getInt("Ano");
            this.idVehiculo = idVehiculo;
            selected = true;
        }
        return selected;
    }
    public boolean checkVehiculo(){
        Metodos.Avisos aviso;
        if( this.Modelo != "" && this.Marca != "" && this.Placas != "" && this.Color != ""
                && this.Serie != "" && this.Motor != "" && this.TarjCirculacion != 0
                && this.Ano != 0 && !existeEnBD ){
            if(setVehiculo(this.idUsuario)){
                aviso = new Avisos("Registro vehicular", "exitoRegistro");
            }
        }
        return this.existeEnBD;
    }
    public boolean setVehiculo(int idUsuario){
        Metodos.Querys query = new Metodos.Querys();
        existeEnBD = false;

        if(this.Modelo != "" && this.Marca != "" && this.Placas != "" && this.Color != "" &&
            this.Serie != "" && this.Motor != "" && this.TarjCirculacion != 0 &&
            this.Ano != 0){
            if(-1 != (this.idVehiculo = query.Insert("'" +this.idUsuario + "', '" +Marca + "', '" + Modelo + "', '" + Placas + "', '" + Ano + "', '" + Color + "', '" + Serie + "', '"
                    + Motor + "', '" + TarjCirculacion + "'"
                    , "vehiculos( `idUsuario`,`Marca`, `Modelo`, `Placas`, `Ano`,`Color`, `Serie`, `Motor`, `TarjCirculacion`)"
                    , "idVehiculo"))){
                existeEnBD = true;
            }
        }
        return existeEnBD;
    }
    public boolean deleteVehiculo(){
        Querys Query = new Querys();
        boolean updateable = false;
        Avisos Aviso;

        if( Query.Delete("vehiculos","idVehiculo = " + this.idVehiculo )){
          updateable = true;
        }

        return updateable;
    }
    public String getModelo(){
      return this.Modelo;
    }
    public boolean setModelo(String Modelo){
      Metodos.Querys query = new Metodos.Querys();
      boolean pushed;
      pushed = false;
      if( existeEnBD && query.Update("vehiculos","Modelo = '" + Modelo +"'", "idUsuario = '" + this.idUsuario+"'")){
        pushed = true;
      } else this.Modelo = Modelo;
      return pushed;
    }
    public String getMarca(){
      return this.Marca;
    }
    public boolean setMarca(String Marca){
      Metodos.Querys query = new Metodos.Querys();
      boolean pushed;
      pushed = false;
      if( existeEnBD && query.Update("vehiculos","Marca = '" + Marca +"'", "idUsuario = '" + this.idUsuario+"'")){
        pushed = true;
      } else this.Marca = Marca;
      return pushed;
    }
    public String getPlacas(){
      return this.Placas;
    }
    public boolean setPlacas(String Placas){
      Metodos.Querys query = new Metodos.Querys();
      boolean pushed;
      pushed = false;
      if( existeEnBD && query.Update("vehiculos","Placas = '" + Placas +"'", "idUsuario = '" + this.idUsuario+"'")){
        pushed = true;
      } else this.Placas = Placas;
      return pushed;
    }
    public String getColor(){
      return this.Color;
    }
    public boolean setColor(String Color){
      Metodos.Querys query = new Metodos.Querys();
      boolean pushed;
      pushed = false;
      if( existeEnBD && query.Update("vehiculos","Color = '" + Color +"'", "idUsuario = '" + this.idUsuario+"'")){
        pushed = true;
      } else this.Color = Color;
      return pushed;
    }
    public String getSerie(){
      return this.Serie;
    }
    public boolean setSerie(String Serie){
      Metodos.Querys query = new Metodos.Querys();
      boolean pushed;
      pushed = false;
      if( existeEnBD && query.Update("vehiculos","Serie = '" + Serie +"'", "idUsuario = '" + this.idUsuario+"'")){
        pushed = true;
      } else this.Serie = Serie;
      return pushed;
    }
    public String getMotor(){
      return this.Motor;
    }
    public boolean setMotor(String Motor){
      Metodos.Querys query = new Metodos.Querys();
      boolean pushed;
      pushed = false;
      if( existeEnBD && query.Update("vehiculos","Motor = '" + Motor +"'", "idUsuario = '" + this.idUsuario+"'")){
        pushed = true;
      } else this.Motor = Motor;
      return pushed;
    }
    public int getTarjCirculacion(){
      return this.TarjCirculacion;
    }
    public boolean setTarjCirculacion(int TarjCirculacion){
      Metodos.Querys query = new Metodos.Querys();
      boolean pushed;
      pushed = false;
      if( existeEnBD && query.Update("vehiculos","TarjCirculacion = '" + TarjCirculacion +"'", "idUsuario = '" + this.idUsuario+"'")){
        pushed = true;
      } else this.TarjCirculacion = TarjCirculacion;
      return pushed;
    }
    public int getAno(){
      return this.Ano;
    }
    public boolean setAno(int Ano){
      Metodos.Querys query = new Metodos.Querys();
      boolean pushed;
      pushed = false;
      if( existeEnBD && query.Update("vehiculos","Ano = '" + Ano +"'", "idUsuario = '" + this.idUsuario+"'")){
        pushed = true;
      } else this.Ano = Ano;
      return pushed;
    }
    private String Modelo;
    private String Marca;
    private String Placas;
    private String Color;
    private String Serie;
    private String Motor;
    private int TarjCirculacion;
    private int Ano;
    private int idVehiculo;
    private int idUsuario;
    public boolean existeEnBD;

}
