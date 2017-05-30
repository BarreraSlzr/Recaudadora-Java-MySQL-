/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import javax.swing.JOptionPane;

/**
 *
 * @author emmanuelbarrera
 */
public class Avisos {

    public Avisos(String tema, String tipo){
        String titulo = "Aviso por ";
        String mensaje = "";
        int i = 0;

        switch (tema) {
            case "intentos": tema = "Intento fallido";
                break;
            case "registrar": tema = "Nuevo usuario";
                break;
            case "login": tema = "Inicio de sesion";
                break;
            case "email": tema = "Correo electronico";
                break;
            case "password": tema = "Contraseña";
                break;
            case "nombre": tema = "Nombre";
                break;
            case "apellidos": tema = "Apellidos";
                break;
            case "rfc": tema = "RFC";
                break;
            case "localidadEstado": tema = "Estado";
                break;
            case "localidadCiudad": tema = "Ciudad";
                break;
            case "localidadColonia": tema = "Colonia";
                break;
            case "domicilio": tema = "Domicilio";
                break;
            case "codigoPostal": tema = "Codigo Postal";
                break;
            case "telefono": tema = "Telefono";
                break;
            case "userLevel": tema = "Nivel de Usuario";
                break;
            default:
                break;
        }

        titulo += tema.toLowerCase();


        switch (tipo) {
            case "repetido":
                mensaje = "<html><b>Ingrese un " + tema.toLowerCase() +" diferente.</b><br>"
                        + "El " + tema.toLowerCase() + " ingresado ya ha sido usado en otra cuenta</html>";
                break;
            case "errorActualizar":
                mensaje = "<html><b>Intentelo de nuevo.</b><br>"
                        + "No se logro actualizar su "+ tema.toLowerCase() + "</html>";
                break;
            case "exitoActualizar":
                mensaje = "Se ha actualizado su "+ tema.toLowerCase();
                break;
            case "incorrecta":
                mensaje = "<html><b>Intentelo de nuevo.</b><br>"
                        + tema + " "+ tipo.toLowerCase() + "</html>";
                break;
            case "incorrecto":
                mensaje = "<html><b>Intentelo de nuevo.</b><br>"
                        + tema + " "+ tipo.toLowerCase() + "</html>";
                break;
            case "correcta":
                mensaje = tema + " "+ tipo.toLowerCase();
                break;
            case "correcto":
                mensaje = tema + " "+ tipo.toLowerCase();
                break;
            case "exitoRegistro":
                mensaje = "Se ha registrado su "+ tema.toLowerCase();
                break;
            case "errorRegistro":
                mensaje = "<html><b>Intentelo de nuevo.</b><br>"
                        + "No se logro registrar su "+ tema.toLowerCase() + "</html>";
                break;
            case "exitoLogin":
                mensaje = "Haz iniciado sesion exitosamente";
                break;
            case "errorLogin":
                mensaje = "<html><b>Intentelo de nuevo.</b><br>"
                        + "El correo electronico o la contraseña no son correctos </html>";
                break;
            case "datosFaltantes":
                mensaje = "<html><b>Introduce los datos faltantes marcados con rojo.</b><br>"
                        + "Datos incorrectos";
                break;
            case "noCoinciden":
                mensaje = "Las "+ tema.toLowerCase() +"s no coinciden";
                break;
            case "longitudIncorrecta":
                mensaje = "<html><b>Intentelo de nuevo.</b><br>"
                        + "Su " + tema.toLowerCase() + " tiene mas caracteres de lo normal</html>";
                break;
            case "marcadosRojo":
                mensaje = "<html><b>Intentelo de nuevo.</b><br>"
                        + "Ingrese correctamente los datos marcados en rojo</html>";
                break;
            case "ultimoIntento":
                mensaje = "Es tu ultimo intento.\n"
                        + "Muchos intentos fallidos podrian causar el bloqueo de la contraseña.";
                break;
            case "ingresaDatos":
                mensaje = "Ingresa los datos de "+ tema.toLowerCase();
                break;
            case "eliminado":
                mensaje = "Se ha eliminado el "+ tema.toLowerCase() +" satisfactoriamente";
                break;
            case "noEliminado":
                mensaje = "No se ha logrado eliminar el "+ tema.toLowerCase() +" satisfactoriamente";
                break;
            default:
                if(tema.equals("Intento fallido")){
                    i=Integer.parseInt(tipo);

                    if(i>1) mensaje = "Error.\nTienes "+ tipo + " intentos";
                    else if (i==1) mensaje = "Error.\nTienes "+ tipo +" intento";
                    else mensaje = "Error.\nTienes un ultimo intento";
                } else {
                    mensaje = tipo;
                }
                break;
        }

        JOptionPane.showMessageDialog(null, mensaje+".", titulo+".", 0);
    }
    
    public Avisos(){}

    public String Preguntar(String tema, String tipo){
        String titulo = "Introduzca ";
        String mensaje = "";

        if (tema.equals("email")) {
            tema = "Correo Electronico";
        }else if (tema.equals("password")) {
            tema = "Contraseña";
        }

        titulo += tema;

        switch  (tipo){
            case "seguridad":
                mensaje = "Introduzca su "+ tema.toLowerCase() +" para continuar.";
                titulo = "Confirmacion de Seguridad";
                break;
            case "nueva":
                mensaje = "Intruduzca su nueva "+ tema.toLowerCase();
                break;
            case "confirmar":
                mensaje = "Confirma tu "+ tema.toLowerCase() +" nueva";
                break;
            default:
                break;
        }

        String respuesta = JOptionPane.showInputDialog(null, mensaje, titulo, 0);
        return respuesta;
    }
    
    public int Pregunta(String tema, String tipo){
        String titulo = "Confirmar";
        String mensaje="";
        
        switch (tema){
            case "seguro":
                switch(tipo){
                    case "continuar":
                        mensaje = "¿Seguro que deseas continuar?";
                        break;
                    default:
                }
                break;
            default:
        }
        return JOptionPane.showConfirmDialog(null, mensaje, titulo, JOptionPane.YES_NO_OPTION);
    }
}
    
