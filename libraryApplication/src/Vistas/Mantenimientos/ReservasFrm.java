package Vistas.Mantenimientos;

import DAL.ReservasRepositorio;
import Modelos.Reserva;
import java.util.List;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;
import javax.swing.table.DefaultTableModel;

public class ReservasFrm extends javax.swing.JFrame {

    public ReservasFrm() {
        initComponents();
        super.setLocationRelativeTo(null);
        initData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblReservas = new javax.swing.JTable();
        btnEfectuarPrestamo = new javax.swing.JButton();
        btnCancelarReserva = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Administración de reservas");

        tblReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "IdReserva", "Libro", "Autor", "Editorial", "Reservado", "Expira", "IdLibro_Interno", "IdLibro", "Usuario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblReservas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblReservas);
        tblReservas.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tblReservas.getColumnModel().getColumnCount() > 0) {
            tblReservas.getColumnModel().getColumn(0).setResizable(false);
        }

        btnEfectuarPrestamo.setText("Efectuar préstamo");
        btnEfectuarPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEfectuarPrestamoActionPerformed(evt);
            }
        });

        btnCancelarReserva.setText("Cancelar reserva");
        btnCancelarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarReservaActionPerformed(evt);
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
                        .addComponent(btnEfectuarPrestamo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelarReserva)
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
                    .addComponent(btnEfectuarPrestamo)
                    .addComponent(btnCancelarReserva))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEfectuarPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEfectuarPrestamoActionPerformed
        
        int indiceFila = tblReservas.getSelectedRow();
        if (indiceFila >= 0) {
        
            int confirm = JOptionPane.showConfirmDialog(this, 
                    "¿Desea efectuar el préstamo seleccionado?", "Confirmación", YES_NO_OPTION);
            
            if (confirm == YES_OPTION){
                int idReserva = (int)tblReservas.getValueAt(indiceFila, 0);
                int idLibroInterno = (int)tblReservas.getValueAt(indiceFila, 6);
                String idLibro = (String)tblReservas.getValueAt(indiceFila, 7);

                ReservasRepositorio repositorio = new ReservasRepositorio();
                Reserva reserva = new Reserva(idReserva, null, null, 
                        idLibroInterno, idLibro, "vicflamenco", "", "", "");

                if (repositorio.EfectuarPrestamo(reserva)){
                    JOptionPane.showMessageDialog(this, "Préstamo efectuado con éxito. El préstamo es válido por 24 horas.");
                    initData();
                } else {
                    JOptionPane.showMessageDialog(this, "Ocurrió un error al intentar efectuar el préstamo");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un registro en el listado");
        }
    }//GEN-LAST:event_btnEfectuarPrestamoActionPerformed

    private void btnCancelarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarReservaActionPerformed
        
        int indiceFila = tblReservas.getSelectedRow();
        if (indiceFila >= 0) {
        
            int confirm = JOptionPane.showConfirmDialog(this, 
                    "¿Desea cancelar la reserva seleccionada?", "Confirmación", YES_NO_OPTION);
            
            if (confirm == YES_OPTION){
                int idReserva = (int)tblReservas.getValueAt(indiceFila, 0);
                int idLibro_interno = (int)tblReservas.getValueAt(indiceFila, 6);

                ReservasRepositorio repositorio = new ReservasRepositorio();

                if (repositorio.Cancelar(idReserva, idLibro_interno)){

                    JOptionPane.showMessageDialog(this, "Reserva cancelada con éxito.");
                    initData();
                } else {
                    JOptionPane.showMessageDialog(this, "Ocurrió un error al intentar cancelar la reserva.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un registro en el listado");
        }
        
    }//GEN-LAST:event_btnCancelarReservaActionPerformed
    
    private void initData(){
        
        ReservasRepositorio repositorio = new ReservasRepositorio();
        List<Reserva> reservas = repositorio.Leer();
        
        DefaultTableModel model = (DefaultTableModel) tblReservas.getModel();
        model.setRowCount(0);
        
        tblReservas.getColumnModel().getColumn(0).setMinWidth(0);
        tblReservas.getColumnModel().getColumn(0).setMaxWidth(0);
        
        tblReservas.getColumnModel().getColumn(6).setMinWidth(0);
        tblReservas.getColumnModel().getColumn(6).setMaxWidth(0);
        
        tblReservas.getColumnModel().getColumn(7).setMinWidth(0);
        tblReservas.getColumnModel().getColumn(7).setMaxWidth(0);
        
        
        tblReservas.revalidate();
        
        for (Reserva reserva : reservas) {
            model.addRow(
                new Object[] { 
                    reserva.getIdReserva(),
                    reserva.getTituloLibro(),
                    reserva.getNombreAutor(),
                    reserva.getNombreEditorial(),
                    reserva.getFecha_reserva(),
                    reserva.getFecha_expiracion(),
                    reserva.getIdLibro_interno(),
                    reserva.getIdLibro(),
                    reserva.getIdUsuario()
                });
        }
        tblReservas.setModel(model);  
    }
    
    private void success(){
        
        initData();
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
            java.util.logging.Logger.getLogger(ReservasFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(() -> {
            LibrosFrm frm = new LibrosFrm();
            frm.setVisible(true);
            frm.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarReserva;
    private javax.swing.JButton btnEfectuarPrestamo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblReservas;
    // End of variables declaration//GEN-END:variables
}
