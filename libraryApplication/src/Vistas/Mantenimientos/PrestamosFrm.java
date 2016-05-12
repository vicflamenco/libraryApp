package Vistas.Mantenimientos;

import DAL.PrestamosRepositorio;
import DAL.ReservasRepositorio;
import Modelos.Prestamo;
import Modelos.Reserva;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;
import javax.swing.table.DefaultTableModel;

public class PrestamosFrm extends javax.swing.JFrame {

    public PrestamosFrm() {
        initComponents();
        super.setLocationRelativeTo(null);
        initData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPrestamos = new javax.swing.JTable();
        btnDevolución = new javax.swing.JButton();
        btnEfectuarPago = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblPrestamos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "IdPrestamo", "IdLibro_Interno", "IdLibro", "Usuario", "Libro", "Autor", "Prestado", "Expira", "Devuelto", "Multa", "Pagada"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPrestamos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblPrestamos);
        tblPrestamos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tblPrestamos.getColumnModel().getColumnCount() > 0) {
            tblPrestamos.getColumnModel().getColumn(0).setResizable(false);
        }

        btnDevolución.setText("Devolución");
        btnDevolución.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDevoluciónActionPerformed(evt);
            }
        });

        btnEfectuarPago.setText("Efectuar pago");
        btnEfectuarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEfectuarPagoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDevolución, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEfectuarPago, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDevolución)
                    .addComponent(btnEfectuarPago))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDevoluciónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevoluciónActionPerformed
        
        int indiceFila = tblPrestamos.getSelectedRow();
        if (indiceFila >= 0) {
            
            Date fecha_devolucion = (Date)tblPrestamos.getValueAt(indiceFila, 8);
            
            if (fecha_devolucion != null){
                JOptionPane.showMessageDialog(this, "El libro seleccionado ya fue devuelto.");
            } else {
                
                int confirm = JOptionPane.showConfirmDialog(this, 
                    "¿Desea efectuar la devolución del libro seleccionado?", "Confirmación", YES_NO_OPTION);
            
                if (confirm == YES_OPTION){
                    int idPrestamo = (int)tblPrestamos.getValueAt(indiceFila, 0);
                    int idLibroInterno = (int)tblPrestamos.getValueAt(indiceFila, 1);

                    PrestamosRepositorio repositorio = new PrestamosRepositorio();

                    if (repositorio.Devolucion(idPrestamo, idLibroInterno)){
                        JOptionPane.showMessageDialog(this, "Devolución efectuada con éxito.");
                        initData();
                    } else {
                        JOptionPane.showMessageDialog(this, "Ocurrió un error al intentar efectuar la devolución");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un registro en el listado");
        }
    }//GEN-LAST:event_btnDevoluciónActionPerformed

    private void btnEfectuarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEfectuarPagoActionPerformed
        
        int indiceFila = tblPrestamos.getSelectedRow();
        if (indiceFila >= 0) {
            
            String pagado = (String)tblPrestamos.getValueAt(indiceFila, 10);
            
            if (pagado.equals("Si")){
                JOptionPane.showMessageDialog(this, "La multa del préstamo seleccionado ya fue pagada.");
            } else {
                
                int confirm = JOptionPane.showConfirmDialog(this, 
                    "¿Desea efectuar el pago de la multa del préstamo seleccionado?", "Confirmación", YES_NO_OPTION);
            
                if (confirm == YES_OPTION){
                    int idPrestamo = (int)tblPrestamos.getValueAt(indiceFila, 0);

                    PrestamosRepositorio repositorio = new PrestamosRepositorio();

                    if (repositorio.Pago(idPrestamo)){
                        JOptionPane.showMessageDialog(this, "Pago de multa efectuado con éxito.");
                        initData();
                    } else {
                        JOptionPane.showMessageDialog(this, "Ocurrió un error al intentar efectuar el pago de multa");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un registro en el listado");
        }
        
    }//GEN-LAST:event_btnEfectuarPagoActionPerformed
    
    private void initData(){
        
        PrestamosRepositorio repositorio = new PrestamosRepositorio();
        List<Prestamo> prestamos = repositorio.Leer();
        
        DefaultTableModel model = (DefaultTableModel) tblPrestamos.getModel();
        model.setRowCount(0);
        
        tblPrestamos.getColumnModel().getColumn(0).setMinWidth(0);
        tblPrestamos.getColumnModel().getColumn(0).setMaxWidth(0);
        
        tblPrestamos.getColumnModel().getColumn(1).setMinWidth(0);
        tblPrestamos.getColumnModel().getColumn(1).setMaxWidth(0);
        
        tblPrestamos.getColumnModel().getColumn(2).setMinWidth(0);
        tblPrestamos.getColumnModel().getColumn(2).setMaxWidth(0);
        
        tblPrestamos.revalidate();
        
        for (Prestamo prestamo : prestamos) {
            model.addRow(
                new Object[] { 
                    prestamo.getIdPrestamo(),
                    prestamo.getIdLibro_interno(),
                    prestamo.getIdLibro(),
                    prestamo.getIdUsuario(),
                    prestamo.getTitulo(),
                    prestamo.getAutor(),
                    prestamo.getFecha_prestamo(),
                    prestamo.getFecha_expiracion(),
                    prestamo.getFecha_devolucion(),
                    prestamo.getMulta_calculada(),
                    (prestamo.isMulta_pagada()) ? "Si" : "No"
                });
        }
        tblPrestamos.setModel(model);  
    }
    
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrestamosFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PrestamosFrm frm = new PrestamosFrm();
                frm.setVisible(true);
                frm.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDevolución;
    private javax.swing.JButton btnEfectuarPago;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPrestamos;
    // End of variables declaration//GEN-END:variables
}
