package Vistas.Mantenimientos;

import DAL.AutoresRepositorio;
import DAL.EditorialesRepositorio;
import Modelos.Editorial;
import Util.Validador;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class EditorialesFrm extends javax.swing.JFrame {
    
    private int _accion = -1; // 0-> agregar, 1-> editar
    
    public EditorialesFrm() {
        initComponents();
        setLocationRelativeTo(null);
        initData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblEditoriales = new javax.swing.JTable();
        tblEditoriales.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                int selectedRow = tblEditoriales.getSelectedRow();
                if(selectedRow >= 0) {
                    cargarEditorial(tblEditoriales.getValueAt(tblEditoriales.getSelectedRow(), 0).toString());
                }            
            }
        });
        pnlEditor = new javax.swing.JPanel();
        lblIdEditorial = new javax.swing.JLabel();
        txtIdEditorial = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblEditoriales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "IdEditorial", "Nombre"
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
        tblEditoriales.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblEditoriales);
        tblEditoriales.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tblEditoriales.getColumnModel().getColumnCount() > 0) {
            tblEditoriales.getColumnModel().getColumn(0).setResizable(false);
            tblEditoriales.getColumnModel().getColumn(1).setResizable(false);
        }

        pnlEditor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Editor de registros de libros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        lblIdEditorial.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIdEditorial.setText("Id");

        txtIdEditorial.setEditable(false);

        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNombre.setText("Nombre");

        txtNombre.setEditable(false);

        javax.swing.GroupLayout pnlEditorLayout = new javax.swing.GroupLayout(pnlEditor);
        pnlEditor.setLayout(pnlEditorLayout);
        pnlEditorLayout.setHorizontalGroup(
            pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIdEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtIdEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlEditorLayout.setVerticalGroup(
            pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdEditorial)
                    .addComponent(txtIdEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlEditor.getAccessibleContext().setAccessibleName("Editor de registros de editoriales");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void cargarEditorial(String id){

        if (id != null && !id.isEmpty()){
            
            EditorialesRepositorio repo = new EditorialesRepositorio();
            Editorial editorial = repo.Leer(id);

            if (editorial != null){

                this.txtNombre.setText(editorial.getNombre());
                this.txtIdEditorial.setText(String.valueOf(editorial.getIdEditorial()));

                this.btnEditar.setEnabled(true);
                this.btnEliminar.setEnabled(true);
            } else {
                this.btnEditar.setEnabled(false);
                this.btnEliminar.setEnabled(false);
            }
        }
    }
    
    private void initData(){
        
        EditorialesRepositorio repositorio = new EditorialesRepositorio();
        List<Editorial> editoriales = repositorio.Leer();
        
        DefaultTableModel model = (DefaultTableModel) tblEditoriales.getModel();
        model.setRowCount(0);
        tblEditoriales.revalidate();
        
        for (Editorial editorial : editoriales) {
            model.addRow(
                new Object[] { 
                    editorial.getIdEditorial(), 
                    editorial.getNombre()
                });
        }
        tblEditoriales.setModel(model);

        this.btnEditar.setEnabled(false);
        this.btnGuardar.setEnabled(false);
        this.btnCancelar.setEnabled(false);
        this.btnEliminar.setEnabled(false);
        
    }
    
    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        this.txtIdEditorial.setText("");
        this.txtNombre.setText("");
        this._accion = 0;
        
        this.txtNombre.setEditable(true);
        
        this.btnGuardar.setEnabled(true);
        this.btnCancelar.setEnabled(true);
        this.btnNuevo.setEnabled(false);
        this.btnEditar.setEnabled(false);
        this.btnEliminar.setEnabled(false);
        
        this.txtNombre.requestFocus();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void success(){
        
        initData();
        this._accion = -1;
        
        this.txtIdEditorial.setEditable(false);
        this.txtNombre.setEditable(false);

        this.btnGuardar.setEnabled(false);
        this.btnCancelar.setEnabled(false);
        this.btnNuevo.setEnabled(true);
        this.btnEditar.setEnabled(false);
        this.btnEliminar.setEnabled(false);
        
        this.txtIdEditorial.setText("");
        this.txtNombre.setText("");
    }
    
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        String id = txtIdEditorial.getText();
        String nombre = Validador.validarTexto(txtNombre);
        
        if (nombre == null){
            JOptionPane.showMessageDialog(null, "Por favor, complete cada uno de los datos del formulario en su formato válido");
        } else {
            
            Editorial editorial = new Editorial(id.isEmpty() ? 0 : Integer.parseInt(id), nombre);
            EditorialesRepositorio repo = new EditorialesRepositorio();
            
            if (this._accion == 0){
                if (repo.Insertar(editorial) > 0){
                    JOptionPane.showMessageDialog(null, "El registro se insertó satisfactoriamente");
                    success();
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrió un error al intentar insertar el registro");
                }
            } else if (this._accion == 1){
                if (repo.Actualizar(editorial) > 0){
                    JOptionPane.showMessageDialog(null, "El registro se actualizó satisfactoriamente");
                    success();
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrió un error al actualizar insertar el registro");
                }
            }
        }
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        String id = this.txtIdEditorial.getText();
        
        if (id.isEmpty()){
            JOptionPane.showMessageDialog(this, "Seleccione un registro en la cuadrícula");
        } else {
            
            int confirmacion = JOptionPane.showConfirmDialog(this, 
                    "¿Desea eliminar el registro seleccionado?",
                    "Confirmación", JOptionPane.YES_NO_OPTION);
            
            if (confirmacion == JOptionPane.YES_OPTION){
                EditorialesRepositorio repo = new EditorialesRepositorio();
                if (repo.Eliminar(id) > 0){
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
        
        this.txtIdEditorial.setText("");
        this.txtNombre.setText("");
        
        this.txtNombre.setEditable(false);
        
        this.btnNuevo.setEnabled(true);
        this.btnGuardar.setEnabled(false);
        this.btnCancelar.setEnabled(false);
        
        this.txtIdEditorial.requestFocus();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        this._accion = 1;

        this.txtNombre.setEditable(true);
        
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
            java.util.logging.Logger.getLogger(EditorialesFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(() -> {
            EditorialesFrm frm = new EditorialesFrm();
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
    private javax.swing.JLabel lblIdEditorial;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JPanel pnlEditor;
    private javax.swing.JTable tblEditoriales;
    private javax.swing.JTextField txtIdEditorial;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
