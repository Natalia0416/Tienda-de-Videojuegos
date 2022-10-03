package proyecto;

import java.awt.Color;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Factura extends javax.swing.JFrame {
    Conexion con = new Conexion();
   Connection cn = (Connection) con.conexion();

    double precio = 0;
    int cantidad = 0;
    DefaultTableModel modelo = new DefaultTableModel();
    ArrayList<venta> listaVentas=new ArrayList<venta>();
            

    public Factura() {
        initComponents();
        this.setTitle("Factura");
        this.setLocationRelativeTo(null);
        jPanel1.setBackground(new Color(91, 173, 178));
//        DefaultComboBoxModel comboModel = new DefaultComboBoxModel(productos);
//        cboProducto.setModel(comboModel);
        modelo.addColumn("Descripcion");
        modelo.addColumn("Precio U.");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Modelo");
//        actualizarTabla();
//        calcularPrecio();
        nombresJuegos(); 
    }
    public void mostrarDatos(){
        String []datos = new String[4];
        try {
            Statement datosJuego = cn.createStatement();
            ResultSet result = datosJuego.executeQuery("SELECT * FROM juegos");
            while(result.next()){
                datos[0] = result.getString(1);
                datos[1] = result.getString(2);
                datos[2] = result.getString(3);
                datos[3] = result.getString(4);
                modelo.addRow(datos);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "Error en la consulta");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cboProducto = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        spnCantidad = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        lblModelo = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblproductos = new javax.swing.JTable();
        lblSubtotal = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        lblPorcentaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel1.setText("Producto");

        cboProducto.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        cboProducto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboProductoItemStateChanged(evt);
            }
        });
        cboProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboProductoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel3.setText("Precio");

        lblPrecio.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        lblPrecio.setText("0");

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel2.setText("Cantidad");

        spnCantidad.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        spnCantidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));
        spnCantidad.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnCantidadStateChanged(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel4.setText("Modelos");

        lblModelo.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        lblModelo.setText("0");

        btnAgregar.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        tblproductos.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        tblproductos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblproductos);

        lblSubtotal.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        lblSubtotal.setText("0");

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel7.setText("Subtotal");

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel8.setText("Porcentaje");

        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel9.setText("Total");

        lblTotal.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        lblTotal.setText("0");

        lblPorcentaje.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        lblPorcentaje.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(spnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(cboProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblPrecio)
                                .addGap(0, 66, Short.MAX_VALUE))
                            .addComponent(lblModelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(277, 277, 277)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTotal)
                            .addComponent(lblSubtotal)
                            .addComponent(lblPorcentaje))
                        .addGap(114, 114, 114)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(lblPrecio))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(spnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)
                                .addComponent(lblModelo))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(btnAgregar)))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblSubtotal))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblPorcentaje))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblTotal))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        venta vn= new venta();
        vn.setId(cboProducto.getSelectedIndex());
        vn.setDescripcion(cboProducto.getSelectedItem().toString());
        vn.setPrecio(precio);
        vn.setCantidad(cantidad);
        vn.setImporte(precio*cantidad);
        if(!buscarVenta(vn)){
//            listaVentas.add(vn);
        }
        
        actualizarTabla();
        borrarVenta();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void cboProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboProductoActionPerformed
        calcularPrecio();
    }//GEN-LAST:event_cboProductoActionPerformed

    private void spnCantidadStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnCantidadStateChanged
        calcularPrecio();
    }//GEN-LAST:event_spnCantidadStateChanged

    private void cboProductoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboProductoItemStateChanged
        String sql="select * from Juegos where nombre ='"+cboProducto.getSelectedItem()+"'";
        try {
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            if(rs.next()){
                precio=Double.parseDouble(rs.getString("Precio"));
                lblPrecio.setText(rs.getString("Precio"));
                lblModelo.setText(rs.getString("Modelos"));
            }
        } catch (SQLException e) {
            System.out.println("e = " + e);
        }        
    }//GEN-LAST:event_cboProductoItemStateChanged

    public boolean buscarVenta(venta nueva){
        for(venta v : listaVentas){
            if(v.getId()==nueva.getId()){
                int nuevaCantidad = (int) (v.getCantidad()+ nueva.getCantidad());
                v.setCantidad(nuevaCantidad);
                v.setImporte(v.getPrecio()*nuevaCantidad);
                return true;
            } else {
            }
        }
        return false;
    }
    public void borrarVenta(){
        precio=0;
        cantidad=1;
        cboProducto.setSelectedIndex(0);
        spnCantidad.setValue(1);
        calcularPrecio();
    }
    
    public void calcularPrecio() {
//        precio = precios[cboProducto.getSelectedIndex()];
        cantidad = Integer.parseInt(spnCantidad.getValue().toString());
        lblPrecio.setText(aMoneda(precio));
    }

    public String aMoneda(double precio) {
        return "$ " + Math.round(precio * 100.00) / 100.00 + "COP";
    }

    public void actualizarTabla(){
        while(modelo.getRowCount()>0){
            modelo.removeRow(0);            
        }
        double subtotal=0;
        
        for(venta v : listaVentas){
            Object x[]=new Object [4];
            x[0]=v.getDescripcion();
            x[1]=aMoneda(v.getPrecio());
            x[2]=v.getCantidad();
            x[3]=aMoneda(v.getImporte());
            subtotal+=v.getImporte();
            modelo.addRow(x);
        }
        double porcentaje=subtotal*0.15;
        double total=subtotal+porcentaje;
        lblSubtotal.setText(aMoneda(subtotal));
        lblPorcentaje.setText(aMoneda(porcentaje));
        lblTotal.setText(aMoneda(total));
        tblproductos.setModel(modelo);
    }
    public void nombresJuegos(){
        String sql="select * from Juegos";
        try {
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            while(rs.next()){
                cboProducto.addItem(rs.getString("Nombre"));
            }
        } catch (SQLException e) {
            System.out.println("e = " + e);
        }        
    }
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
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Factura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    public javax.swing.JComboBox cboProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblPorcentaje;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblSubtotal;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JSpinner spnCantidad;
    private javax.swing.JTable tblproductos;
    // End of variables declaration//GEN-END:variables
}
