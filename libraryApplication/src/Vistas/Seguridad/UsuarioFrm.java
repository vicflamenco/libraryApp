/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Seguridad;

import DAL.UsuariosRepositorio;
import Modelos.*;
import Util.Validador;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;

/**
 *
 * @author Kevin
 */
public class UsuarioFrm extends javax.swing.JFrame {
    BeanTableModel<Usuario> model;
    UsuariosRepositorio usuariosRepo;

    int estado = -1;

    
    /**
     * Creates new form UsuarioFrm
     */
    public UsuarioFrm() {
        initComponents();
        super.setLocationRelativeTo(null);
        model = new BeanTableModel<Usuario>(Usuario.class);
        usuariosRepo = new UsuariosRepositorio();
        
        tblData.setModel(model);
        tblData.removeColumn(tblData.getColumn("Clave"));
        tblData.removeColumn(tblData.getColumn("Admin"));
        tblData.removeColumn(tblData.getColumn("Operator"));
        tblData.removeColumn(tblData.getColumn("User"));
        RXTable.reorderColumns(tblData, "Id Usuario","Nombres","Correo", "Activo");
        
        DeshabilitarControles();
        resetBotones(-1);
        
        tblData.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            LoadDetail();
        });
        
        LoadData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtIdUsuario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        tgInactivo = new javax.swing.JToggleButton();
        tgActivo = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnModificar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtClave = new javax.swing.JPasswordField();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnPrestatarioRol = new javax.swing.JToggleButton();
        btnOperarioRol = new javax.swing.JToggleButton();
        btnAdministradorRol = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setSize(new java.awt.Dimension(300, 250));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Mantenimiento de usuarios");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jLabel1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jSeparator1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Registros");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jLabel2, gridBagConstraints);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(452, 300));

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblData);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        jLabel4.setText("ID Usuario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 3, 5);
        getContentPane().add(jLabel4, gridBagConstraints);

        jLabel5.setText("Nombres");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 3, 5);
        getContentPane().add(jLabel5, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 3, 5);
        getContentPane().add(txtIdUsuario, gridBagConstraints);

        jLabel6.setText("Contraseña");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 3, 5);
        getContentPane().add(jLabel6, gridBagConstraints);

        jLabel7.setText("Correo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 3, 5);
        getContentPane().add(jLabel7, gridBagConstraints);

        jLabel8.setText("Estado");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 3, 5);
        getContentPane().add(jLabel8, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 3, 5);
        getContentPane().add(txtNombres, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 3, 5);
        getContentPane().add(txtCorreo, gridBagConstraints);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        buttonGroup1.add(tgInactivo);
        tgInactivo.setText("Inactivo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanel1.add(tgInactivo, gridBagConstraints);

        buttonGroup1.add(tgActivo);
        tgActivo.setText("Activo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanel1.add(tgActivo, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 3, 5);
        getContentPane().add(jPanel1, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        jPanel2.add(btnCerrar, gridBagConstraints);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel2.add(btnGuardar, gridBagConstraints);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        jPanel2.add(btnCancelar, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 5);
        getContentPane().add(jPanel2, gridBagConstraints);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel3.add(btnModificar, gridBagConstraints);

        btnNuevo.setText("Nuevo");
        btnNuevo.setEnabled(this.estado == 0);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel3.add(btnNuevo, gridBagConstraints);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel3.add(btnEliminar, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        getContentPane().add(jPanel3, gridBagConstraints);

        txtClave.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 3, 5);
        getContentPane().add(txtClave, gridBagConstraints);

        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Datos del registro");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel4.add(jLabel3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanel4.add(jSeparator2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 2.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jPanel4, gridBagConstraints);

        jLabel9.setText("Roles");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jLabel9, gridBagConstraints);

        jPanel5.setLayout(new java.awt.GridBagLayout());

        btnPrestatarioRol.setText("Prestatario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanel5.add(btnPrestatarioRol, gridBagConstraints);

        btnOperarioRol.setText("Operario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanel5.add(btnOperarioRol, gridBagConstraints);

        btnAdministradorRol.setText("Administrador");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanel5.add(btnAdministradorRol, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jPanel5, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        ResetInput();
        HabilitarControles();
        
        resetBotones(1);

    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        HabilitarControles();
        txtIdUsuario.setEditable(false);
        
        resetBotones(2);

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (ValidarCampos())
        {
            switch (estado) {
                case 1:
                    //Agregar
                    if (usuariosRepo.Insertar(new Usuario(txtIdUsuario.getText(), txtNombres.getText(), Arrays.toString(txtClave.getPassword()), txtCorreo.getText(), tgActivo.isSelected(),btnAdministradorRol.isSelected(), btnOperarioRol.isSelected(), btnPrestatarioRol.isSelected()))>0)
                    {
                        JOptionPane.showMessageDialog(null, "Acción realizada satisfactoriamente");
                        LoadData();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Ocurrio un error");
                    }
                        break;
                case 2:
                    //Modificar
                    if (usuariosRepo.Actualizar(new Usuario(txtIdUsuario.getText(), txtNombres.getText(), new String(txtClave.getPassword()), txtCorreo.getText(), tgActivo.isSelected(),btnAdministradorRol.isSelected(), btnOperarioRol.isSelected(), btnPrestatarioRol.isSelected()))>0)
                    {
                        JOptionPane.showMessageDialog(null, "Acción realizada satisfactoriamente");
                        LoadData();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Ocurrio un error");
                    }

                    break;
                default:

            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try 
        {
            int fila = tblData.getSelectedRow();
            if (fila  >= 0) {
                if (JOptionPane.showConfirmDialog(this, "¿Desea eliminar el registro seleccionado?", "Eliminar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                    
                    if (usuariosRepo.Eliminar(txtIdUsuario.getText()) > 0)
                    {
                        JOptionPane.showMessageDialog(this, "Usuario eliminado satisfactoriamente");
                        LoadData();
                    }
                    else
                        JOptionPane.showMessageDialog(this, "Ha ocurrido un error, por favor verifique los datos");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún registro");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed



    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        LoadDetail();
    }//GEN-LAST:event_btnCancelarActionPerformed


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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UsuarioFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsuarioFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsuarioFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsuarioFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UsuarioFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnAdministradorRol;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JToggleButton btnOperarioRol;
    private javax.swing.JToggleButton btnPrestatarioRol;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tblData;
    private javax.swing.JToggleButton tgActivo;
    private javax.swing.JToggleButton tgInactivo;
    private javax.swing.JPasswordField txtClave;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtIdUsuario;
    private javax.swing.JTextField txtNombres;
    // End of variables declaration//GEN-END:variables

    private void LoadData() {
        model.removeAllRows();

        List<Usuario> data = usuariosRepo.Leer();
        if(data != null) model.addRows(data);
        else
            JOptionPane.showMessageDialog(null, "El servidor de base datos no se encuentra disponible");
        
        ResetInput();
        DeshabilitarControles();
        resetBotones(-1);
    }
    
    private void LoadDetail(){
         try {
                Usuario usuario = model.getRow(tblData.getSelectedRow());
                
                txtIdUsuario.setText(usuario.getIdUsuario());
                txtClave.setText("");
                txtNombres.setText(usuario.getNombres());
                txtCorreo.setText(usuario.getCorreo());
                tgActivo.setSelected(usuario.isActivo());
                tgInactivo.setSelected(!usuario.isActivo());
                
                btnAdministradorRol.setSelected(usuario.isAdmin());
                btnOperarioRol.setSelected(usuario.isOperator());
                btnPrestatarioRol.setSelected(usuario.isUser());
                
                resetBotones(0);
            } catch (Exception e) {
                resetBotones(-1);
                ResetInput();
            } finally{
                DeshabilitarControles();
            }

    }
    
    private void HabilitarControles(){
        txtIdUsuario.setEditable(true);
        txtNombres.setEditable(true);
        txtCorreo.setEditable(true);
        txtClave.setEditable(true);
        tgActivo.setEnabled(true);
        tgInactivo.setEnabled(true);
        
        btnAdministradorRol.setEnabled(true);
        btnOperarioRol.setEnabled(true);
        btnPrestatarioRol.setEnabled(true);
    }
    
    private void DeshabilitarControles(){
        txtIdUsuario.setEditable(false);
        txtNombres.setEditable(false);
        txtCorreo.setEditable(false);
        txtClave.setEditable(false);
        tgActivo.setEnabled(false);
        tgInactivo.setEnabled(false);
        
        btnAdministradorRol.setEnabled(false);
        btnOperarioRol.setEnabled(false);
        btnPrestatarioRol.setEnabled(false);
    }
    
    private void resetBotones(int estado){
        this.estado = estado;
        
        btnNuevo.setEnabled(estado <= 0);
        btnModificar.setEnabled(estado == 0);
        btnEliminar.setEnabled(estado == 0);
        
        btnGuardar.setEnabled(estado == 1 || estado == 2);
        btnCancelar.setEnabled(btnGuardar.isEnabled());
        btnCerrar.setEnabled(estado <= 0);
        
        tblData.setEnabled(estado <= 0);
    }

    private void ResetInput() {
        txtIdUsuario.setText("");
        txtNombres.setText("");
        txtCorreo.setText("");
        txtClave.setText("");
        tgActivo.setSelected(true);
        
        btnAdministradorRol.setSelected(false);
        btnOperarioRol.setSelected(false);
        btnPrestatarioRol.setSelected(false);
    }
    
    private boolean ValidarCampos()
    { 
        if (Validador.validarTexto(txtIdUsuario) == null)
        {
            JOptionPane.showMessageDialog(null, "El ID de usuario no es válido");
            return false;
        }
        else if (Validador.validarTexto(txtNombres) == null)
        {
            JOptionPane.showMessageDialog(null, "El nombre de usuario no es válido");
            return false;
        }
        else if (Validador.validarCorreo(txtCorreo) == null)
        {
            JOptionPane.showMessageDialog(null, "El correo electrónico no es válido");
            return false;
        }
        else if ((txtClave.getPassword().length < 6 && estado == 1) || (txtClave.getPassword().length != 0 && txtClave.getPassword().length < 6 && estado == 2)) 
        {
            JOptionPane.showMessageDialog(null, "La contraseña no es válida");
            return false;
        }
        else if (!(btnAdministradorRol.isSelected() || btnOperarioRol.isSelected() || btnPrestatarioRol.isSelected()))
        {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado un rol");
            return false;
        }
        
        return true;
    }
}
