/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Metodos.*;
import java.awt.Color;

/**
 *
 * @author emmanuelbarrera
 */
public class RegistroUsuario extends javax.swing.JDialog {

    /**
     * Creates new form RegistroUsuario
     * @param parent
     * @param modal
     */
    public RegistroUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public RegistroUsuario(java.awt.Frame parent, boolean modal, String email) {
        super(parent, modal);
        initComponents();
        this.campoEmail.setText(email);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        textNombre = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        textApellidos = new javax.swing.JLabel();
        campoApellidos = new javax.swing.JTextField();
        textEmail = new javax.swing.JLabel();
        campoEmail = new javax.swing.JTextField();
        textPassword = new javax.swing.JLabel();
        textPassword2 = new javax.swing.JLabel();
        campoPassword = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        campoPassword2 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo Usuario");
        setMaximumSize(new java.awt.Dimension(2147483647, 385));
        setMinimumSize(new java.awt.Dimension(356, 385));
        setResizable(false);
        setSize(new java.awt.Dimension(356, 385));

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Registro de nuevo usuario");

        textNombre.setText("Nombre");

        campoNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textTypedToMayusculas(evt);
            }
        });

        textApellidos.setText("Apellidos");

        campoApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textTypedToMayusculas(evt);
            }
        });

        textEmail.setText("Correo Electronico");

        textPassword.setText("Contraseña");

        textPassword2.setText("Repetir Contraseña");

        jButton1.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.select"));
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setForeground(new java.awt.Color(0, 204, 102));
        jButton2.setText("Crear nuevo usuario");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(textPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campoEmail)
                        .addComponent(campoApellidos)
                        .addComponent(textApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campoNombre)
                        .addComponent(textNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campoPassword)
                        .addComponent(textPassword2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campoPassword2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(textNombre)
                .addGap(0, 0, 0)
                .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textApellidos)
                .addGap(0, 0, 0)
                .addComponent(campoApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(textEmail)
                .addGap(0, 0, 0)
                .addComponent(campoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textPassword)
                .addGap(0, 0, 0)
                .addComponent(campoPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(textPassword2)
                .addGap(0, 0, 0)
                .addComponent(campoPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(20, 20, 20))
        );

        getAccessibleContext().setAccessibleDescription("Formulario para el registro de nuevo usuario");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Metodos.User newUser;
        String nombre = campoNombre.getText();
        String apellidos = campoApellidos.getText();
        String email = campoEmail.getText();
        String password = String.valueOf(campoPassword.getPassword());
        String password2 = String.valueOf(campoPassword2.getPassword());
        boolean error = false;
        Validador Validar = new Validador();

        if (nombre.isEmpty()){
            error = true;
            this.textNombre.setForeground(Color.red);
        } else this.textNombre.setForeground(Color.black);
        
        
        if (apellidos.isEmpty()){
            error = true;
            this.textApellidos.setForeground(Color.red);
        } else 
            this.textApellidos.setForeground(Color.black);
        
        
        this.textEmail.setForeground(Color.red);
        this.textPassword.setForeground(Color.red);
        this.textPassword2.setForeground(Color.red);
        
        if (email.isEmpty()) error = true;
        else if(!Validar.emailPattner(email)){
            new Avisos("email", "incorrecto");
            error = true;
        } else if (Validar.existeEnBD("email ='" + email +"'", "usuarios")){
            new Avisos("email", "repetido");
            error = true;
        } else {
            
            this.textEmail.setForeground(Color.BLACK);
            if (!Validar.compararStrings(password, password2)){
                error = true;
                new Avisos("password", "noCoinciden");
            } else if (!Validar.longitudString(32, 5, password)){
                error = true;
                new Avisos("password", "<html><b>Intentelo de nuevo la longitud de su contraseña es incorrecta.<b>\n"
                        + "La contraseña debe contener de 5 caracteres a 32 caracteres");
            } else {
                this.textPassword.setForeground(Color.black);
                this.textPassword2.setForeground(Color.black);
            }
        }
        
        if (error) {
            new Avisos("datos", "marcadosRojo");
            this.campoPassword2.setText("");
        } else {
            newUser = new Metodos.User(email, password, nombre, apellidos);
            if (newUser.checkUser()) this.dispose();
            else new Avisos("registrar", "errorRegistro");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void textTypedToMayusculas(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textTypedToMayusculas
        campoNombre.setText(campoNombre.getText().toUpperCase());
        campoApellidos.setText(campoApellidos.getText().toUpperCase());
        // TODO add your handling code here:
    }//GEN-LAST:event_textTypedToMayusculas

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            RegistroUsuario dialog = new RegistroUsuario(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campoApellidos;
    private javax.swing.JTextField campoEmail;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JPasswordField campoPassword;
    private javax.swing.JPasswordField campoPassword2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel textApellidos;
    private javax.swing.JLabel textEmail;
    private javax.swing.JLabel textNombre;
    private javax.swing.JLabel textPassword;
    private javax.swing.JLabel textPassword2;
    // End of variables declaration//GEN-END:variables
}
