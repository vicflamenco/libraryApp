package Vistas;

import DAL.AutoresRepositorio;
import DAL.EditorialesRepositorio;
import DAL.LibrosRepositorio;
import Modelos.Autor;
import Modelos.Editorial;
import Modelos.Libro;
import Util.Validador;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class LibrosFrm extends javax.swing.JFrame {

    private int[] _autores;
    private int[] _editoriales;
    private int _accion = -1; // 0-> agregar, 1-> editar
    
    public LibrosFrm() {
        initComponents();
        initData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblLibros = new javax.swing.JTable();
        tblLibros.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                cargarLibro(tblLibros.getValueAt(tblLibros.getSelectedRow(), 0).toString());
            }
        });
        pnlEditor = new javax.swing.JPanel();
        lblIdLibro = new javax.swing.JLabel();
        txtIdLibro = new javax.swing.JTextField();
        lblTitulo = new javax.swing.JLabel();
        lblAnio = new javax.swing.JLabel();
        lblEdicion = new javax.swing.JLabel();
        lblSinopsis = new javax.swing.JLabel();
        lblEditorial = new javax.swing.JLabel();
        lblAutor = new javax.swing.JLabel();
        txtAño = new javax.swing.JTextField();
        txtTitulo = new javax.swing.JTextField();
        txtEdicion = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaSinopsis = new javax.swing.JTextArea();
        cmbEditorial = new javax.swing.JComboBox<>();
        cmbAutor = new javax.swing.JComboBox<>();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ISBN", "Título", "Año", "Edición", "Editorial", "Autor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLibros.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblLibros);
        tblLibros.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tblLibros.getColumnModel().getColumnCount() > 0) {
            tblLibros.getColumnModel().getColumn(0).setResizable(false);
        }

        pnlEditor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Editor de registros de libros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        lblIdLibro.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIdLibro.setText("ISBN");

        txtIdLibro.setEditable(false);

        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitulo.setText("Título");

        lblAnio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAnio.setText("Año");

        lblEdicion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEdicion.setText("Edición");

        lblSinopsis.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSinopsis.setText("Sinopsis");

        lblEditorial.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEditorial.setText("Editorial");

        lblAutor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAutor.setText("Autor");

        txtAño.setEditable(false);

        txtTitulo.setEditable(false);

        txtEdicion.setEditable(false);

        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        txaSinopsis.setEditable(false);
        txaSinopsis.setColumns(20);
        txaSinopsis.setRows(5);
        jScrollPane2.setViewportView(txaSinopsis);

        cmbEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEditorialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlEditorLayout = new javax.swing.GroupLayout(pnlEditor);
        pnlEditor.setLayout(pnlEditorLayout);
        pnlEditorLayout.setHorizontalGroup(
            pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAnio)
                    .addComponent(lblIdLibro)
                    .addComponent(lblEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEditorLayout.createSequentialGroup()
                        .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtAño)
                            .addComponent(cmbEditorial, 0, 154, Short.MAX_VALUE)
                            .addComponent(txtIdLibro))
                        .addGap(12, 12, 12)
                        .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblEdicion, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlEditorLayout.createSequentialGroup()
                                    .addGap(17, 17, 17)
                                    .addComponent(lblTitulo))
                                .addComponent(lblSinopsis, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(cmbAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                    .addComponent(txtTitulo)
                    .addComponent(txtEdicion))
                .addContainerGap())
        );
        pnlEditorLayout.setVerticalGroup(
            pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdLibro)
                    .addComponent(txtIdLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitulo)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAnio)
                    .addComponent(lblEdicion)
                    .addComponent(txtAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEdicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEditorLayout.createSequentialGroup()
                        .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEditorial)
                            .addComponent(lblSinopsis)
                            .addComponent(cmbEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAutor)
                            .addComponent(cmbAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addGroup(pnlEditorLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
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
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void cargarLibro(String id){
        LibrosRepositorio repo = new LibrosRepositorio();
        Libro libro = repo.Leer(id);
        
        if (libro != null){
            
            this.txtTitulo.setText(libro.getTitulo());
            this.txtAño.setText(String.valueOf(libro.getAnio()));
            this.txtEdicion.setText(libro.getEdicion());
            this.txtIdLibro.setText(libro.getIdLibro());
            this.txaSinopsis.setText(libro.getSinopsis());
            
            for (int i = 0; i < this._editoriales.length; i++){
                if (this._editoriales[i] == libro.getIdEditorial()){
                    cmbEditorial.setSelectedIndex(i);
                    break;
                }
            }
            
            for (int i = 0; i < this._autores.length; i++){
                if (this._autores[i] == libro.getIdAutor()){
                    cmbAutor.setSelectedIndex(i);
                    break;
                }
            }
        }
    }
    
    private void initData(){
        LibrosRepositorio repositorio = new LibrosRepositorio();
        List<Libro> libros = repositorio.Leer();
        
        DefaultTableModel model = (DefaultTableModel) tblLibros.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        
        for (Libro libro : libros) {
            model.addRow(
                new Object[] { 
                    libro.getIdLibro(), 
                    libro.getTitulo(), 
                    libro.getAnio(), 
                    libro.getEdicion(), 
                    libro.getNombreEditorial(), 
                    libro.getNombreAutor()
                });
        }
        tblLibros.setModel(model);
        
        AutoresRepositorio repo = new AutoresRepositorio();
        List<Autor> autores = repo.Leer();
        
        int i = 0;
        this._autores = new int[autores.size()];
        while (cmbAutor.getItemCount() > 0){
            cmbAutor.removeItemAt(0);
        }
        for (Autor autor : autores){
            this._autores[i++] = autor.getIdAutor();
            cmbAutor.addItem(autor.getNombre());
        }
        
        EditorialesRepositorio repo2 = new EditorialesRepositorio();
        List<Editorial> editoriales = repo2.Leer();
        
        i = 0;
        this._editoriales = new int[editoriales.size()];
        while (cmbEditorial.getItemCount() > 0){
            cmbEditorial.removeItemAt(0);
        }
        for (Editorial editorial : editoriales){
            this._editoriales[i++] = editorial.getIdEditorial();
            cmbEditorial.addItem(editorial.getNombre());
        }
    }
    
    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        this.txtIdLibro.setText("");
        this.txtTitulo.setText("");
        this.txtAño.setText("");
        this.txtEdicion.setText("");
        this.txaSinopsis.setText("");
        this._accion = 0;
        
        this.txtIdLibro.setEditable(true);
        this.txtTitulo.setEditable(true);
        this.txtAño.setEditable(true);
        this.txtEdicion.setEditable(true);
        this.txaSinopsis.setEditable(true);
        
        this.txtIdLibro.requestFocus();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        String id = Validador.validarTexto(txtIdLibro);
        String titulo = Validador.validarTexto(txtTitulo);
        int año = Validador.validarEntero(txtAño);
        String edicion = Validador.validarTexto(txtEdicion);
        String sinopsis = Validador.validarTexto(txaSinopsis);
        int idEditorial = this._editoriales[cmbEditorial.getSelectedIndex()];
        int idAutor = this._autores[cmbAutor.getSelectedIndex()];
        
        if (titulo == null || edicion == null || sinopsis == null || año < 0){
            JOptionPane.showMessageDialog(null, "Por favor, complete cada uno de los datos del formulario en su formato válido");
        } else if (cmbEditorial.getItemCount() <= 0){
            JOptionPane.showMessageDialog(null, "Aún no existen editoriales existentes");
        } else if (cmbAutor.getItemCount() <= 0){
            JOptionPane.showMessageDialog(null, "Aún no existen autores existentes");
        } else {
            
            Libro libro = new Libro(id, titulo, año, edicion, idEditorial, idAutor, sinopsis, "", "");
            LibrosRepositorio repo = new LibrosRepositorio();
            if (this._accion == 0){
                repo.Insertar(libro);
                JOptionPane.showMessageDialog(null, "El registro se insertó satisfactoriamente");
            } else if (this._accion == 1){
                repo.Actualizar(libro);
                JOptionPane.showMessageDialog(null, "El registro se actualizó satisfactoriamente");
            }
            initData();
            this._accion = -1;

            this.txtIdLibro.setEditable(false);
            this.txtTitulo.setEditable(false);
            this.txtAño.setEditable(false);
            this.txtEdicion.setEditable(false);
            this.txaSinopsis.setEditable(false);
        }
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this._accion = -1;
        
        this.txtIdLibro.setText("");
        this.txtTitulo.setText("");
        this.txtAño.setText("");
        this.txtEdicion.setText("");
        this.txaSinopsis.setText("");
        
        this.txtIdLibro.setEditable(false);
        this.txtTitulo.setEditable(false);
        this.txtAño.setEditable(false);
        this.txtEdicion.setEditable(false);
        this.txaSinopsis.setEditable(false);
        
        this.txtIdLibro.requestFocus();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cmbEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEditorialActionPerformed
        
    }//GEN-LAST:event_cmbEditorialActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        this._accion = 1;
        
        this.txtIdLibro.setText("");
        this.txtTitulo.setText("");
        this.txtAño.setText("");
        this.txtEdicion.setText("");
        this.txaSinopsis.setText("");
        
        this.txtIdLibro.setEditable(true);
        this.txtTitulo.setEditable(true);
        this.txtAño.setEditable(true);
        this.txtEdicion.setEditable(true);
        this.txaSinopsis.setEditable(true);
        
        this.txtIdLibro.requestFocus();
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
            java.util.logging.Logger.getLogger(LibrosFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LibrosFrm frm = new LibrosFrm();
                frm.setVisible(true);
                frm.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cmbAutor;
    private javax.swing.JComboBox<String> cmbEditorial;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAnio;
    private javax.swing.JLabel lblAutor;
    private javax.swing.JLabel lblEdicion;
    private javax.swing.JLabel lblEditorial;
    private javax.swing.JLabel lblIdLibro;
    private javax.swing.JLabel lblSinopsis;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlEditor;
    private javax.swing.JTable tblLibros;
    private javax.swing.JTextArea txaSinopsis;
    private javax.swing.JTextField txtAño;
    private javax.swing.JTextField txtEdicion;
    private javax.swing.JTextField txtIdLibro;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
