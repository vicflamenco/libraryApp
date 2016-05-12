/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import DAL.UsuariosRepositorio;
import Modelos.Usuario;
import Vistas.Mantenimientos.*;
import Vistas.Seguridad.UsuarioFrm;

/**
 *
 * @author Kevin
 */
public class MainForm extends javax.swing.JFrame {

    /**
     * Creates new form MainForm
     * @param usuarioId
     */
    public MainForm(String usuarioId) {
        initComponents();
        super.setLocationRelativeTo(null);
        UsuariosRepositorio usuarioRepo = new UsuariosRepositorio();
        
        Usuario usuario = usuarioRepo.Leer(usuarioId);
        
        btnSeguridad.setEnabled(usuario.isAdmin());
        btnAutores.setEnabled(usuario.isOperator());
        btnEditoriales.setEnabled(usuario.isOperator());
        btnLibros.setEnabled(usuario.isOperator());
        btnReservas.setEnabled(usuario.isOperator());
        btnPrestamos.setEnabled(usuario.isOperator());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLibros = new javax.swing.JButton();
        btnAutores = new javax.swing.JButton();
        btnSeguridad = new javax.swing.JButton();
        btnEditoriales = new javax.swing.JButton();
        btnReservas = new javax.swing.JButton();
        btnPrestamos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        btnLibros.setText("Libros");
        btnLibros.setPreferredSize(new java.awt.Dimension(90, 50));
        btnLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLibrosActionPerformed(evt);
            }
        });

        btnAutores.setText("Autores");
        btnAutores.setPreferredSize(new java.awt.Dimension(90, 50));
        btnAutores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAutoresActionPerformed(evt);
            }
        });

        btnSeguridad.setText("Seguridad");
        btnSeguridad.setPreferredSize(new java.awt.Dimension(90, 50));
        btnSeguridad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeguridadActionPerformed(evt);
            }
        });

        btnEditoriales.setText("Editoriales");
        btnEditoriales.setPreferredSize(new java.awt.Dimension(90, 50));
        btnEditoriales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditorialesActionPerformed(evt);
            }
        });

        btnReservas.setText("Reservas");
        btnReservas.setPreferredSize(new java.awt.Dimension(90, 50));
        btnReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservasActionPerformed(evt);
            }
        });

        btnPrestamos.setText("Préstamos");
        btnPrestamos.setPreferredSize(new java.awt.Dimension(90, 50));
        btnPrestamos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrestamosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPrestamos, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(btnAutores, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnSeguridad, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnEditoriales, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(22, 22, 22)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSeguridad, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(btnEditoriales, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAutores, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPrestamos, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeguridadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeguridadActionPerformed
        new UsuarioFrm().setVisible(true);
    }//GEN-LAST:event_btnSeguridadActionPerformed

    private void btnEditorialesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditorialesActionPerformed
        new EditorialesFrm().setVisible(true);
    }//GEN-LAST:event_btnEditorialesActionPerformed

    private void btnLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLibrosActionPerformed
        new LibrosFrm().setVisible(true);
    }//GEN-LAST:event_btnLibrosActionPerformed

    private void btnAutoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAutoresActionPerformed
        new AutoresFrm().setVisible(true);
    }//GEN-LAST:event_btnAutoresActionPerformed

    private void btnReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservasActionPerformed
        new ReservasFrm().setVisible(true);
    }//GEN-LAST:event_btnReservasActionPerformed

    private void btnPrestamosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrestamosActionPerformed
        
    }//GEN-LAST:event_btnPrestamosActionPerformed

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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAutores;
    private javax.swing.JButton btnEditoriales;
    private javax.swing.JButton btnLibros;
    private javax.swing.JButton btnPrestamos;
    private javax.swing.JButton btnReservas;
    private javax.swing.JButton btnSeguridad;
    // End of variables declaration//GEN-END:variables
}
