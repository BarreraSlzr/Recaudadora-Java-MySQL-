/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import Interface.Login;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author emmanuelbarrera
 */
public class Validador {

    private static final String patternEmail = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public boolean emailPattner(String email) {

        // Compiles the given regular expression into a pattern.
        Pattern pattern = Pattern.compile(patternEmail);

        // Match the given input against this pattern
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean existeEnBD(String dato, String lugar){
        Querys Query = new Querys();
        boolean existeEnBD = false;

        try {
            existeEnBD = Query.Select(dato, lugar).next();

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        return existeEnBD;
    }
    public boolean compararStrings(String primero, String segundo){
        return primero == null ? segundo != null : primero.equals(segundo);
    }

    public boolean longitudString(int maxlongitud, String dato){
        return dato.length()>=0 && dato != null && dato.length() <= maxlongitud;
    }
    public boolean longitudString(int maxLongitud, int minLongitud, String dato){
        return dato.length()>=minLongitud && dato != null && dato.length() <= maxLongitud;
    }
}
