package Vistas.Mantenimientos;

import DAL.AutoresRepositorio;
import Modelos.Autor;
import Util.Validador;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class AutoresFrm extends javax.swing.JFrame {
    
    private int _accion = -1; // 0-> agregar, 1-> editar
    
    public AutoresFrm() {
        initComponents();
        initData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblAutores = new javax.swing.JTable();
        tblAutores.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                int selectedRow = tblAutores.getSelectedRow();
                if(selectedRow >= 0) {
                    cargarAutor(tblAutores.getValueAt(tblAutores.getSelectedRow(), 0).toString());
                }            
            }
        });
        pnlEditor = new javax.swing.JPanel();
        lblIdAutor = new javax.swing.JLabel();
        txtIdAutor = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        lblAcercaDe = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaAcercaDe = new javax.swing.JTextArea();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblAutores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "IdAutor", "Nombre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAutores.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblAutores);
        tblAutores.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tblAutores.getColumnModel().getColumnCount() > 0) {
            tblAutores.getColumnModel().getColumn(0).setResizable(false);
            tblAutores.getColumnModel().getColumn(1).setResizable(false);
        }

        pnlEditor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Editor de registros de libros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        lblIdAutor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIdAutor.setText("Id");

        txtIdAutor.setEditable(false);

        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNombre.setText("Nombre");

        lblAcercaDe.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAcercaDe.setText("Acerca de");

        txtNombre.setEditable(false);

        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        txaAcercaDe.setEditable(false);
        txaAcercaDe.setColumns(20);
        txaAcercaDe.setRows(5);
        jScrollPane2.setViewportView(txaAcercaDe);

        javax.swing.GroupLayout pnlEditorLayout = new javax.swing.GroupLayout(pnlEditor);
        pnlEditor.setLayout(pnlEditorLayout);
        pnlEditorLayout.setHorizontalGroup(
            pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEditorLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblAcercaDe, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE))
                    .addGroup(pnlEditorLayout.createSequentialGroup()
                        .addComponent(lblIdAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtIdAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombre)))
                .addContainerGap())
        );
        pnlEditorLayout.setVerticalGroup(
            pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdAutor)
                    .addComponent(txtIdAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEditorLayout.createSequentialGroup()
                        .addComponent(lblAcercaDe)
                        .addContainerGap(45, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlEditor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlEditor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar)
                    .addComponent(btnCancelar)
                    .addComponent(btnEditar))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void cargarAutor(String id){

        if (id != null && !id.isEmpty()){
            
            AutoresRepositorio repo = new AutoresRepositorio();
            Autor autor = repo.Leer(id);

            if (autor != null){

                this.txtNombre.setText(autor.getNombre());
                this.txtIdAutor.setText(String.valueOf(autor.getIdAutor()));
                this.txaAcercaDe.setText(autor.getAcerca_de());


                this.btnEditar.setEnabled(true);
                this.btnEliminar.setEnabled(true);
            } else {
                this.btnEditar.setEnabled(false);
                this.btnEliminar.setEnabled(false);
            }
        }
    }
    
    private void initData(){
        
        AutoresRepositorio repositorio = new AutoresRepositorio();
        List<Autor> autores = repositorio.Leer();
        
        DefaultTableModel model = (DefaultTableModel) tblAutores.getModel();
        model.setRowCount(0);
        tblAutores.revalidate();
        
        for (Autor autor : autores) {
            model.addRow(
                new Object[] { 
                    autor.getIdAutor(), 
                    autor.getNombre()
                });
        }
        tblAutores.setModel(model);

        this.btnEditar.setEnabled(false);
        this.btnGuardar.setEnabled(false);
        this.btnCancelar.setEnabled(false);
        this.btnEliminar.setEnabled(false);
        
    }
    
    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        this.txtIdAutor.setText("");
        this.txtNombre.setText("");
        this.txaAcercaDe.setText("");
        this._accion = 0;
        
        this.txtNombre.setEditable(true);
        this.txaAcercaDe.setEditable(true);
        
        this.btnGuardar.setEnabled(true);
        this.btnCancelar.setEnabled(true);
        this.btnNuevo.setEnabled(false);
        this.btnEditar.setEnabled(false);
        this.btnEliminar.setEnabled(false);
        
        this.txtIdAutor.requestFocus();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void success(){
        
        initData();
        this._accion = -1;
        
        this.txtIdAutor.setEditable(false);
        this.txtNombre.setEditable(false);
        this.txaAcercaDe.setEditable(false);

        this.btnGuardar.setEnabled(false);
        this.btnCancelar.setEnabled(false);
        this.btnNuevo.setEnabled(true);
        this.btnEditar.setEnabled(false);
        this.btnEliminar.setEnabled(false);
        
        this.txtIdAutor.setText("");
        this.txtNombre.setText("");
        this.txaAcercaDe.setText("");
    }
    
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        String id = txtIdAutor.getText();
        String nombre = Validador.validarTexto(txtNombre);
        String acercaDe = Validador.validarTexto(txaAcercaDe);
        
        if (nombre == null || acercaDe == null){
            JOptionPane.showMessageDialog(null, "Por favor, complete cada uno de los datos del formulario en su formato válido");
        } else {
            
            Autor autor = new Autor(id.isEmpty() ? 0 : Integer.parseInt(id), nombre, acercaDe);
            AutoresRepositorio repo = new AutoresRepositorio();
            
            if (this._accion == 0){
                if (repo.Insertar(autor) > 0){
                    JOptionPane.showMessageDialog(null, "El registro se insertó satisfactoriamente");
                    success();
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrió un error al intentar insertar el registro");
                }
            } else if (this._accion == 1){
                if (repo.Actualizar(autor) > 0){
                    JOptionPane.showMessageDialog(null, "El registro se actualizó satisfactoriamente");
                    success();
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrió un error al actualizar insertar el registro");
                }
            }
        }
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        String idAutor = this.txtIdAutor.getText();
        
        if (idAutor.isEmpty()){
            JOptionPane.showMessageDialog(this, "Seleccione un registro en la cuadrícula");
        } else {
            
            int confirmacion = JOptionPane.showConfirmDialog(this, 
                    "¿Desea eliminar el registro seleccionado?",
                    "Confirmación", JOptionPane.YES_NO_OPTION);
            
            if (confirmacion == JOptionPane.YES_OPTION){
                AutoresRepositorio repo = new AutoresRepositorio();
                if (repo.Eliminar(idAutor) > 0){
                    JOptionPane.showMessageDialog(this, "Registro eliminado con éxito");
                    success();
                    this.btnEliminar.setEnabled(false);
                    this.btnEditar.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Ocurrió un error al eliminar el registro");
                }
            }
            
        }
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this._accion = -1;
        
        this.txtIdAutor.setText("");
        this.txtNombre.setText("");
        this.txaAcercaDe.setText("");
        
        this.txtNombre.setEditable(false);
        this.txaAcercaDe.setEditable(false);
        
        this.btnNuevo.setEnabled(true);
        this.btnGuardar.setEnabled(false);
        this.btnCancelar.setEnabled(false);
        
        this.txtIdAutor.requestFocus();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        this._accion = 1;

        this.txtNombre.setEditable(true);
        this.txaAcercaDe.setEditable(true);
        
        this.btnGuardar.setEnabled(true);
        this.btnCancelar.setEnabled(true);
        this.btnNuevo.setEnabled(false);
        this.btnEditar.setEnabled(false);
        this.btnEliminar.setEnabled(false);
        
        this.txtNombre.requestFocus();
    }//GEN-LAST:event_btnEditarActionPerformed

    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AutoresFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(() -> {
            AutoresFrm frm = new AutoresFrm();
            frm.setVisible(true);
            frm.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAcercaDe;
    private javax.swing.JLabel lblIdAutor;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JPanel pnlEditor;
    private javax.swing.JTable tblAutores;
    private javax.swing.JTextArea txaAcercaDe;
    private javax.swing.JTextField txtIdAutor;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
