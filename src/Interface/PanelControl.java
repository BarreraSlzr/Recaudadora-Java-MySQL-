/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author emmanuelbarrera
 */
public class PanelControl extends javax.swing.JFrame {

    public static Metodos.User perfilAdmin;
    /**
     * Creates new form PanelControl
     */
    public PanelControl() throws SQLException{
        String[] cmbEncontrados = {"Realice una busqueda"};
        String[] opcionesBusqueda = {
            "ID","Correo","Nombre","Apellidos",
            "RFC","Estado","Ciudad", "Colonia","Domicilio","Telefono","C.P."
        };

        initComponents();
        actualizarTabla();
        
        this.jTable1.setAutoResizeMode(this.jTable1.AUTO_RESIZE_OFF);
        jLabel1.setText("ADMIN: "+ perfilAdmin.getNombre() +" "+ perfilAdmin.getApellidos());
        
        this.cmbxBusquedaElegida.setModel(new DefaultComboBoxModel(opcionesBusqueda));
        this.cmbEncontrados.setModel(new DefaultComboBoxModel(cmbEncontrados));
        this.cmbEncontrados.setEnabled(false); 
        this.btnEliminarPropietario.setEnabled(false);
        this.btnModificarPropietario.setEnabled(false); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable(){
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component component = super.prepareRenderer(renderer, row, column);
                int rendererWidth = component.getPreferredSize().width+10;
                TableColumn tableColumn = getColumnModel().getColumn(column);
                tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
                return component;
            }
        };
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        queryBusqueda = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        cmbxBusquedaElegida = new javax.swing.JComboBox<>();
        cmbEncontrados = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        btnModificarPropietario = new javax.swing.JButton();
        btnEliminarPropietario = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel14.setFont(new java.awt.Font("Lucida Grande", 1, 17)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Administrador");

        jLabel1.setText("Nombre de Administrador");

        jButton1.setText("Ver perfil");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Propietarios");

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setEnabled(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setAutoscrolls(false);
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(jTable1);

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 15)); // NOI18N
        jLabel3.setText("Modificar Propietarios");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Buscar propietario");

        queryBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                queryBusquedaKeyReleased(evt);
            }
        });

        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        cmbxBusquedaElegida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbEncontrados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Propietarios encontrados");

        btnModificarPropietario.setText("Modificar");
        btnModificarPropietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarPropietarioActionPerformed(evt);
            }
        });

        btnEliminarPropietario.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.select"));
        btnEliminarPropietario.setText("Eliminar");
        btnEliminarPropietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPropietarioActionPerformed(evt);
            }
        });

        jButton3.setText("Agregar Propietario");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Actualizar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(cmbxBusquedaElegida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(queryBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)))
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnEliminarPropietario)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnModificarPropietario))
                                    .addComponent(cmbEncontrados, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 1010, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
                                            .addGap(325, 325, 325))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton4)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addComponent(jButton3))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton1))))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(queryBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(cmbxBusquedaElegida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbEncontrados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificarPropietario)
                    .addComponent(btnEliminarPropietario))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Interface.Propietario.main(perfilAdmin, perfilAdmin);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Metodos.Avisos aviso = new Metodos.Avisos();
        ArrayList<String> listResultados = new ArrayList<String>();
        String[] arrayEncontrados;
        String[] busquedaDefault = {"Realice una busqueda"};
        int row;
        
        if(!this.queryBusqueda.getText().isEmpty()){
            for(row = 0; row<jTable1.getRowCount(); row++){
                if(this.queryBusqueda.getText().contains(
                        (CharSequence) (""+jTable1.getModel()
                                .getValueAt(row,
                                        this.cmbxBusquedaElegida
                                                .getSelectedIndex())))){
                    listResultados.add(""+jTable1.getModel()
                            .getValueAt(row, 2).toString()
                            + " " + jTable1.getModel()
                            .getValueAt(row, 3).toString()
                            + ", " + jTable1.getModel()
                            .getValueAt(row, 1).toString()
                    );
                }
            }
            if(listResultados.isEmpty()){
                listResultados.add("No se han encontrado coincidencias");
                this.cmbEncontrados.setEnabled(false);
                this.btnEliminarPropietario.setEnabled(false);
                this.btnModificarPropietario.setEnabled(false);
            } else {
                this.btnEliminarPropietario.setEnabled(true);
                this.btnModificarPropietario.setEnabled(true);
                this.cmbEncontrados.setEnabled(true);
            }
            arrayEncontrados = (String[]) listResultados.toArray(new String[listResultados.size()]);
            this.cmbEncontrados.setModel(new DefaultComboBoxModel(arrayEncontrados));

        } else {
                aviso = new Metodos.Avisos("Busqueda", "ingresaDatos");
                this.cmbEncontrados.setModel(new DefaultComboBoxModel(busquedaDefault));
                this.cmbEncontrados.setEnabled(false);
                this.btnEliminarPropietario.setEnabled(false);
                this.btnModificarPropietario.setEnabled(false);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnEliminarPropietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPropietarioActionPerformed
        Metodos.User userEliminar = getUsercmbEncontrados();
        Metodos.Avisos aviso = new Metodos.Avisos();
        
        if(aviso.Pregunta("seguro", "continuar")==JOptionPane.YES_OPTION){
            if(perfilAdmin.confirmacionSeguridad(5)){
                this.cmbEncontrados.setEnabled(false);
                this.btnEliminarPropietario.setEnabled(false);
                this.btnModificarPropietario.setEnabled(false);
            if(userEliminar.deleteUser()){
                    this.cmbEncontrados.setModel(new DefaultComboBoxModel(new String[]{"Realice una busqueda"}));
                    aviso = new Metodos.Avisos("Usuario", "eliminado");
                } else
                    aviso = new Metodos.Avisos("Usuario", "noEliminado");
            }
        }
        actualizarTabla();
    }//GEN-LAST:event_btnEliminarPropietarioActionPerformed

    private void btnModificarPropietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarPropietarioActionPerformed
        Metodos.User userModificar = getUsercmbEncontrados();
        Metodos.Avisos aviso = new Metodos.Avisos();
        
        if(userModificar!=null){
            this.cmbEncontrados.setEnabled(false);
            this.btnEliminarPropietario.setEnabled(false);
            this.btnModificarPropietario.setEnabled(false);
            Interface.Propietario.main(userModificar, perfilAdmin);
        }else{
            aviso = new Metodos.Avisos("Usuario","incorrecto");
        }
        actualizarTabla();
    }//GEN-LAST:event_btnModificarPropietarioActionPerformed
    private Metodos.User getUsercmbEncontrados(){
        String seleccionado = this.cmbEncontrados.getSelectedItem().toString();
        String emailSeleccionado = seleccionado.substring(seleccionado.lastIndexOf(",")+2);
        return new Metodos.User(emailSeleccionado, perfilAdmin);
    }
    private void queryBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_queryBusquedaKeyReleased
        ArrayList<String> listResultados = new ArrayList<String>();
        String[] arrayEncontrados;
        String[] busquedaDefault = {"Realice una busqueda"};
        int row;

        if(!this.queryBusqueda.getText().isEmpty()){
            for(row = 0; row<jTable1.getRowCount(); row++){
                if(this.queryBusqueda.getText().contains(
                        (CharSequence) (""+jTable1.getModel()
                                .getValueAt(row,
                                        this.cmbxBusquedaElegida
                                                .getSelectedIndex())))){
                    listResultados.add(""+jTable1.getModel()
                            .getValueAt(row, 2).toString()
                            + " " + jTable1.getModel()
                            .getValueAt(row, 3).toString()
                            + ", " + jTable1.getModel()
                            .getValueAt(row, 1).toString()
                    );
                }
            }
            if(listResultados.isEmpty()){
                listResultados.add("No se han encontrado coincidencias");
                this.cmbEncontrados.setEnabled(false);
                this.btnEliminarPropietario.setEnabled(false);
                this.btnModificarPropietario.setEnabled(false);
            } else {
                this.btnEliminarPropietario.setEnabled(true);
                this.btnModificarPropietario.setEnabled(true);
                this.cmbEncontrados.setEnabled(true);
            }
            arrayEncontrados = (String[]) listResultados.toArray(new String[listResultados.size()]);
            this.cmbEncontrados.setModel(new DefaultComboBoxModel(arrayEncontrados));

        } else {
            this.cmbEncontrados.setModel(new DefaultComboBoxModel(busquedaDefault));
            this.cmbEncontrados.setEnabled(false);
            this.btnEliminarPropietario.setEnabled(false);
            this.btnModificarPropietario.setEnabled(false);
        }
    }//GEN-LAST:event_queryBusquedaKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        RegistroUsuario FormularioRegistroUsuario;
        FormularioRegistroUsuario = new RegistroUsuario(this, true);
        FormularioRegistroUsuario.setVisible(true);
        actualizarTabla();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_jButton4ActionPerformed

    private boolean actualizarTabla(){
        boolean tablaActualizada = true;
        Metodos.Querys query = new Metodos.Querys();
        ResultSet resultSetUsuarios = query.Select("idUsuario , Email, userLevel"
                , "idUsuario > 0"
                , "usuarios");
        ResultSet resultSetUsuariosInfo = query.Select("Nombre, Apellidos, RFC, "
                + "LocalidadEstado, LocalidadCiudad, localidadColonia, "
                + "Domicilio, Telefono, CodigoPostal"
                , "idUsuario > 0"
                , "propietariosInfo");
        int i;
        String[] opcionesBusqueda = {"ID","Correo","Nombre","Apellidos","RFC","Estado","Ciudad", "Colonia","Domicilio","Telefono","C.P.", "Usuario"};
        
        DefaultTableModel model = new DefaultTableModel();
        
        for(i=0; i<opcionesBusqueda.length;i++){
            model.addColumn(opcionesBusqueda[i]);
        }
        
        try {
            while (resultSetUsuariosInfo.next() && resultSetUsuarios.next()){
                int cols = resultSetUsuariosInfo.getMetaData().getColumnCount() +
                        resultSetUsuarios.getMetaData().getColumnCount();
                i=0;
                // Se crea un array que será una de las filas de la tabla.
                Object [] fila = new Object[cols]; // Se ingresa el numero total de columnas necesitadas
                //Se agregan los primeros datos
                fila[i] = resultSetUsuarios.getObject(++i);
                fila[i] = resultSetUsuarios.getObject(++i);
                // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
                for ( i=2 ; i<cols-1;i++)
                    fila[i] = resultSetUsuariosInfo.getObject(i-1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.
                // Se añade al modelo la fila completa.
                fila[--cols] = resultSetUsuarios.getObject(3);
                model.addRow(fila);
                tablaActualizada = true;
            }
            this.jTable1.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(PanelControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tablaActualizada;
    }
    /**
     * @param perfilAdminx
     */
    public static void main(Metodos.User perfilAdminx) {
        PanelControl.perfilAdmin = perfilAdminx;
        if(perfilAdmin.isAdmin()){
            /* Set the Nimbus look and feel */
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
             * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
             */
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Mac".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(PanelControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(PanelControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(PanelControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(PanelControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>
            
            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        new PanelControl().setVisible(true);
                    } catch (SQLException ex) {
                        Logger.getLogger(PanelControl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        }else{
            JOptionPane.showMessageDialog(null, "Usted no es administrador", "Problemas de autorizacion", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminarPropietario;
    private javax.swing.JButton btnModificarPropietario;
    private javax.swing.JComboBox<String> cmbEncontrados;
    private javax.swing.JComboBox<String> cmbxBusquedaElegida;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField queryBusqueda;
    // End of variables declaration//GEN-END:variables
}
