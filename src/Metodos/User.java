 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author emmanuelbarrera
 */
public final class User {

    public User(String email, User admin) {
        Querys Query = new Querys();
        ResultSet Select;
        
        if(admin.isAdmin()){
            Select = Query.Select(""
                    + "nombre,"
                    + "apellidos,"
                    + "rfc,"
                    + "localidadEstado,"
                    + "localidadCiudad,"
                    + "localidadColonia,"
                    + "domicilio,"
                    + "codigoPostal,"
                    + "telefono"
                    , "idUsuario = '"+ this.getIdUsuario(email) +"'"
                    , "propietariosInfo");
            
            try {
                if(Select.next()){
                    this.nombre = Select.getString("nombre");
                    this.apellidos = Select.getString("apellidos");
                    this.rfc = Select.getString("rfc");
                    this.localidadEstado = Select.getString("localidadEstado");
                    this.localidadCiudad = Select.getString("localidadCiudad");
                    this.localidadColonia = Select.getString("localidadColonia");
                    this.domicilio = Select.getString("domicilio");
                    this.codigoPostal = Select.getInt("codigoPostal");
                    this.telefono = Select.getInt("telefono");
                    this.email = email;
                }
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Select = Query.Select("userLevel", "email = '"+ this.email +"'", "usuarios");
            try {
                if(Select.next()){
                    this.userLevel = Select.getString("userLevel");
                }
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public User(String email, String password) {
        this.email = email;
        this.password = this.encryptpassword(password);
        Querys Query = new Querys();
        ResultSet Select;
        
        if(this.checkUser()){
            Select = Query.Select(""
                    + "nombre,"
                    + "apellidos,"
                    + "rfc,"
                    + "localidadEstado,"
                    + "localidadCiudad,"
                    + "localidadColonia,"
                    + "domicilio,"
                    + "codigoPostal,"
                    + "telefono"
                    , "idUsuario = '"+this.idUsuario+"'"
                    , "propietariosInfo");

            try {
                if(Select.next()){
                    
                    System.out.print("entro\n");
                    this.nombre = Select.getString("nombre");
                    this.apellidos = Select.getString("apellidos");
                    this.rfc = Select.getString("rfc");
                    this.localidadEstado = Select.getString("localidadEstado");
                    this.localidadCiudad = Select.getString("localidadCiudad");
                    this.localidadColonia = Select.getString("localidadColonia");
                    this.domicilio = Select.getString("domicilio");
                    this.codigoPostal = Select.getInt("codigoPostal");
                    this.telefono = Select.getInt("telefono");
                }
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            System.out.print("Salio\n");
        }
    }

    public User(String email, String password, String nombre, String apellidos){
        password = this.encryptpassword(password);
        if(!this.checkUser()) this.insertNewUser(email, password, nombre, apellidos);
    }
    
    public boolean Update(User UpdateUser){
        Querys Query = new Querys();
        boolean Updateable = false;
        Avisos Aviso;

        if (this.checkUser()) {
            if (!UpdateUser.checkUser() && confirmacionSeguridad(5)) {

                if (Validar.compararStrings(this.email, UpdateUser.getEmail())
                        && Validar.existeEnBD(
                                "email = '" + UpdateUser.getEmail() + "'", "usuario"))
                    Aviso = new Avisos("email", "repetido");
                else if (!Validar.compararStrings(this.email, UpdateUser.getEmail())
                        && !Validar.existeEnBD(
                                "email = '" + UpdateUser.getEmail() + "'", "usuario"))
                    this.setEmail(UpdateUser.getEmail());
                else if (!Validar.compararStrings(this.password,UpdateUser.getPassword()))
                    this.setPassword(UpdateUser.getPassword());
            }
        } 
        return Updateable;
    }
    public boolean confirmacionSeguridad(){
        boolean confirmacion = false;
        if(Validar.existeEnBD(
                "password = '" + encryptpassword(new Avisos().Preguntar("password", "seguridad")) + "' AND " +
                "idUsuario = '" + this.idUsuario + "'"
                ,"usuarios")){
            confirmacion = true;
            new Avisos("password", "correcta");
        } else
            new Avisos("password", "incorrecta");

        return confirmacion;
    }

    public boolean confirmacionSeguridad(int Intentos){
        Avisos Aviso;
        boolean confirmacion=false;
        while( !confirmacion && Intentos>0 ){
            confirmacion=confirmacionSeguridad();
            if(!confirmacion){
                Aviso = new Avisos("intentos", ""+ Intentos-- +"");
            }
        }
        if(Intentos<=1){
            Aviso = new Avisos("intento", "ultimoIntento");
            confirmacion=confirmacionSeguridad();
        }
        return confirmacion;
    }

    public String encryptpassword(String password) {
        String md5 = null;

        try {
            // Create MessageDigest object for MD5
            MessageDigest digest = MessageDigest.getInstance("MD5");

            // Update input string in message digest
            digest.update(password.getBytes(), 0, password.length());

            // Converts message digest value in base 16 (hex)
            md5 = new BigInteger(1, digest.digest()).toString(16);

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return md5;
    }
    
    
    public boolean insertNewUser(String email, String password, String nombre, String apellidos){
        Querys Query = new Querys();
        boolean insertable = false;
        Avisos Aviso;

        if( Validar.longitudString(64, email) &&
                Validar.longitudString(128, password) &&
                Validar.longitudString(64, nombre) &&
                Validar.longitudString(64, apellidos)
                ){
            if(-1 != (this.idUsuario = Query.Insert("'"+ email 
                        + "','" + password 
                        + "'"
                        , "usuarios( `email`, `password`)"
                        , "idUsuario"))){
                this.email = email;
                this.password = password;
                if(-1 != (this.idUsuario = Query.Insert("'"+ this.idUsuario
                    + "','"+ nombre 
                    + "','" + apellidos 
                    + "'"
                    , "propietariosInfo(`idUsuario`,`nombre`,`apellidos`)"
                    ,"idUsuario"))){
                    insertable = true;
                }
            }
            
            Aviso = new Avisos("registrar", "exitoRegistro");
            insertable = true;
        } else Aviso = new Avisos("registrar", "errorRegistro");
        return insertable;
    }
    // Getters & Setters
    public int getIdUsuario(String email){
        Querys Query = new Querys();
        ResultSet Select;
        
        Select = Query.Select("idUsuario, userLevel", "email = '"+ email +"'", "usuarios");
        try {
                while(Select.next()){
                    this.email = email;
                    this.userLevel = Select.getString("userLevel");
                    this.idUsuario = Select.getInt("idUsuario");
                }
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return this.idUsuario;
    }
    public int getIdUsuario(){
        return getIdUsuario(this.email);
    }
    public boolean checkUser(){
        Querys Query = new Querys();
        ResultSet Select;
        Select = Query.Select("userLevel, idUsuario", "email = '"+ this.email +"' && password = '"+ this.password + "'", "usuarios");
        boolean setExitoso = false;
        try {
            if(Select.next()){
                this.userLevel = Select.getString("userLevel");
                this.idUsuario = Select.getInt("idUsuario");
                setExitoso = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return setExitoso;
    }
    public String getEmail(){
      return this.email;
    }
    public boolean setEmail(String email){
      Querys Query = new Querys();
      boolean updateable = false;
      Avisos Aviso;

      if(Validar.longitudString(64, email)){
          if( Query.Update("usuarios",
                    "Email = '" + email + "'", "idUsuario = '" + this.idUsuario + "'")){
            this.email = email;
            Aviso = new Avisos("email", "exitoActualizar");
            updateable = true;
          } else Aviso = new Avisos("email", "errorActualizar");
      } else Aviso = new Avisos("email", "longitudIncorrecta");
      return updateable;
    }
    public String getPassword(){
      return this.password;
    }
    public boolean setPassword(String password){
      Querys Query = new Querys();
      boolean updateable = false;
      Avisos Aviso;

      if(Validar.longitudString(126, password)){
          if( Query.Update("usuarios",
                    "password = '" + password + "'", "idUsuario = '" + this.idUsuario + "'")){
            this.password = password;
            Aviso = new Avisos("password", "exitoActualizar");
            updateable = true;
          } else Aviso = new Avisos("password", "errorActualizar");
      } else Aviso = new Avisos("password", "longitudIncorrecta");
      return updateable;
    }
    public String getUserLevel(){
      return this.userLevel;
    }
    public boolean setUserLevel(String userLevel){
        Querys Query = new Querys();
        boolean updateable = false;
        Avisos Aviso;
        if( Query.Update("usuarios",
                "userLevel = '" + userLevel + "'", "idUsuario = '" + this.idUsuario + "'")){
            this.email = email;
            Aviso = new Avisos("Nivel de Usuario", "exitoActualizar");
            updateable = true;
        } else Aviso = new Avisos("Nivel de Usuario", "errorActualizar");
        return updateable;
    }
    
    public String getNombre(){
      return this.nombre;
    }
    public boolean setNombre(String nombre){
        Querys Query = new Querys();
        boolean updateable = false;
        Avisos Aviso;

        if(Validar.longitudString(64, nombre)){
            if(Query.Update("propietariosInfo",
                      "nombre = '" + nombre + "'",
                      "idUsuario = '" + this.idUsuario + "'")){
                this.nombre = nombre;
                Aviso = new Avisos("nombre", "exitoActualizar");
                updateable = true;
            } else Aviso = new Avisos("nombre", "errorActualizar");
        } else Aviso = new Avisos("nombre", "longitudIncorrecta");
        return updateable;
    }
    public String getApellidos(){
      return this.apellidos;
    }
    public boolean setApellidos(String apellidos){
      Querys Query = new Querys();
      boolean updateable = false;
      Avisos Aviso;

      if(Validar.longitudString(64, apellidos)){
          if( Query.Update("propietariosInfo",
                    "apellidos = '" + apellidos + "'", "idUsuario = '" + this.idUsuario + "'")){
            this.apellidos = apellidos;
            Aviso = new Avisos("apellidos", "exitoActualizar");
            updateable = true;
          } else Aviso = new Avisos("apellidos", "errorActualizar");
      } else Aviso = new Avisos("apellidos", "longitudIncorrecta");
      return updateable;
    }
    public String getRFC(){
      return this.rfc;
    }
    public boolean setRFC(String rfc){
      Querys Query = new Querys();
      boolean updateable = false;
      Avisos Aviso;

      if(Validar.longitudString(13, rfc)){
          if( Query.Update("propietariosInfo",
                    "rfc = '" + rfc + "'", "idUsuario = '" + this.idUsuario + "'")){
            this.rfc = rfc;
            Aviso = new Avisos("rfc", "exitoActualizar");
            updateable = true;
          } else Aviso = new Avisos("rfc", "errorActualizar");
      } else Aviso = new Avisos("rfc", "longitudIncorrecta");
      return updateable;
    }
    public String getLocalidadEstado(){
      return this.localidadEstado;
    }
    public boolean setLocalidadEstado(String localidadEstado){
      Querys Query = new Querys();
      boolean updateable = false;
      Avisos Aviso;

      if(Validar.longitudString(64, localidadEstado)){
          if( Query.Update("propietariosInfo",
                    "localidadEstado = '" + localidadEstado + "'", "idUsuario = '" + this.idUsuario + "'")){
            this.localidadEstado = localidadEstado;
            Aviso = new Avisos("localidadEstado", "exitoActualizar");
            updateable = true;
          } else Aviso = new Avisos("localidadEstado", "errorActualizar");
      } else Aviso = new Avisos("localidadEstado", "longitudIncorrecta");
      return updateable;
    }
    public String getLocalidadCiudad(){
      return this.localidadCiudad;
    }
    public boolean setLocalidadCiudad(String localidadCiudad){
      Querys Query = new Querys();
      boolean updateable = false;
      Avisos Aviso;

      if(Validar.longitudString(64, localidadCiudad)){
          if( Query.Update("propietariosInfo",
                    "localidadCiudad = '" + localidadCiudad + "'", "idUsuario = '" + this.idUsuario + "'")){
            this.localidadCiudad = localidadCiudad;
            Aviso = new Avisos("localidadCiudad", "exitoActualizar");
            updateable = true;
          } else Aviso = new Avisos("localidadCiudad", "errorActualizar");
      } else Aviso = new Avisos("localidadCiudad", "longitudIncorrecta");
      return updateable;
    }
    public String getLocalidadColonia(){
      return this.localidadColonia;
    }
    public boolean setLocalidadColonia(String localidadColonia){
      Querys Query = new Querys();
      boolean updateable = false;
      Avisos Aviso;

      if(Validar.longitudString(64, localidadColonia)){
          if( Query.Update("propietariosInfo",
                    "localidadColonia = '" + localidadColonia + "'", "idUsuario = '" + this.idUsuario + "'")){
            this.localidadColonia = localidadColonia;
            Aviso = new Avisos("localidadColonia", "exitoActualizar");
            updateable = true;
          } else Aviso = new Avisos("localidadColonia", "errorActualizar");
      } else Aviso = new Avisos("localidadColonia", "longitudIncorrecta");
      return updateable;
    }
    public String getDomicilio(){
      return this.domicilio;
    }
    public boolean setDomicilio(String domicilio){
      Querys Query = new Querys();
      boolean updateable = false;
      Avisos Aviso;

      if(Validar.longitudString(128, domicilio)){
          if( Query.Update("propietariosInfo",
                    "domicilio = '" + domicilio + "'", "idUsuario = '" + this.idUsuario + "'")){
            this.domicilio = domicilio;
            Aviso = new Avisos("domicilio", "exitoActualizar");
            updateable = true;
          } else Aviso = new Avisos("domicilio", "errorActualizar");
      } else Aviso = new Avisos("domicilio", "longitudIncorrecta");
      return updateable;
    }
    public int getTelefono(){
      return this.telefono;
    }
    public boolean setTelefono(int telefono){
      Querys Query = new Querys();
      boolean updateable = false;
      Avisos Aviso;

      if(Validar.longitudString(10, String.valueOf(telefono))){
          if( Query.Update("propietariosInfo",
                    "telefono = '" + telefono + "'", "idUsuario = '" + this.idUsuario + "'")){
            this.telefono = telefono;
            Aviso = new Avisos("telefono", "exitoActualizar");
            updateable = true;
          } else Aviso = new Avisos("telefono", "errorActualizar");
      } else Aviso = new Avisos("telefono", "longitudIncorrecta");
      return updateable;
    }
    public int getcodigoPostal(){
      return this.codigoPostal;
    }
    public boolean setcodigoPostal(int codigoPostal){
      Querys Query = new Querys();
      boolean updateable = false;
      Avisos Aviso;

      if(Validar.longitudString(5, String.valueOf(codigoPostal))){
          if( Query.Update("propietariosInfo",
                    "codigoPostal = '" + codigoPostal + "'", "idUsuario = '" + this.idUsuario + "'")){
            this.codigoPostal = codigoPostal;
            Aviso = new Avisos("codigoPostal", "exitoActualizar");
            updateable = true;
          } else Aviso = new Avisos("codigoPostal", "errorActualizar");
      } else Aviso = new Avisos("codigoPostal", "longitudIncorrecta");
      return updateable;
    }
    
    public boolean isAdmin(){
        return this.userLevel.equals("admin");
    }
    
    public boolean deleteUser(){
        Querys Query = new Querys();
        ResultSet vehiculosEliminar;
        boolean updateable = false;
        Avisos Aviso;
        int i=0;
        
        if( Query.Delete("usuarios","idUsuario = " + this.idUsuario ) && 
                Query.Delete("propietariosInfo"
                        ,"idUsuario = " + this.idUsuario)){
            vehiculosEliminar = Query.Select("idVehiculo", "idUsuario = '"+this.idUsuario+"'", "vehiculos");
            try {
                while(vehiculosEliminar.next()){
                    i++;
                    new Metodos.Vehiculo(vehiculosEliminar.getInt(i), this.idUsuario).deleteVehiculo();
                }
                updateable = true;
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return updateable;
    }

    private Validador Validar = new Validador();
    private int idUsuario;
    private String email;
    private String password;
    private String userLevel;
    private String nombre;
    private String apellidos;
    private String rfc = null;
    private String localidadEstado = null;
    private String localidadCiudad = null;
    private String localidadColonia = null;
    private String domicilio = null;
    private int codigoPostal;
    private int telefono;
}
