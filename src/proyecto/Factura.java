package proyecto;

import java.awt.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Factura extends javax.swing.JFrame {

    Conexion con = new Conexion();
    Connection cn = (Connection) con.conexion();
    private static JTable receptor = null;
    double porcentaje = 0, total = 0,precio = 0;
    int cantidad = 0;
    public static String usuario = "1";
    DefaultTableModel modelo = new DefaultTableModel();
    ArrayList<ClaseDetalle> listaVentas = new ArrayList<>();

    public Factura() {
        initComponents();
        this.setTitle("Factura");
        this.setLocationRelativeTo(null);
        Image icono = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/logo.png"));
        this.setIconImage(icono);
        jPanel1.setBackground(new Color(182, 182, 189));
//        DefaultComboBoxModel comboModel = new DefaultComboBoxModel(productos);
//        cboProducto.setModel(comboModel);
        modelo.addColumn("Nombre");
        modelo.addColumn("Categoria");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Subtotal");
        tblproductos.setModel(modelo);

        actualizarTabla();
        calcularPrecio();
        nombresJuegos();
        borrarVenta();
    }

    public void mostrarDatos() {
        String[] datos = new String[4];
        try {
            Statement datosJuego = cn.createStatement();
            ResultSet result = datosJuego.executeQuery("SELECT * FROM juegos");
            while (result.next()) {
                datos[0] = result.getString(1);
                datos[1] = result.getString(2);
                datos[2] = result.getString(3);
                datos[3] = result.getString(4);
                //modelo.addRow(datos);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "Error en la consulta");
        }
    }

    //Asigna al objeto los datos del Videojuego seleccionado
    public ClaseJuegos setDatosVideojuego(String nombreVideojuego) {
        //Nuevo Juego que se va Agregar
        ClaseJuegos nJuego = new ClaseJuegos();
        String sql = "select * from Juegos where nombre ='" + nombreVideojuego + "'";
        try {
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            if (rs.next()) {
                //Trae la Infomación del videojuego
                nJuego.setId(String.valueOf(rs.getString("idJuego")));
                nJuego.setNombre(String.valueOf(rs.getString("Nombre")));
                nJuego.setPrecio((int) Double.parseDouble(String.valueOf(rs.getString("Precio"))));
                nJuego.setCantidad(Integer.parseInt(String.valueOf(rs.getString("Cantidad"))));
                nJuego.setCapacidad(String.valueOf(rs.getString("Capacidad")));
                nJuego.setCategoria(String.valueOf(rs.getString("Categoria")));
                nJuego.setModelos(String.valueOf(rs.getString("Modelos")));
                //vn.setSubtotal(Integer.parseInt(String.valueOf(spnCantidad.getValue())));
            }
        } catch (SQLException e) {
            System.out.println("e = " + e);
        }
        return nJuego;
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
        btnEliminar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnPagar = new javax.swing.JButton();

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
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblproductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblproductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblproductos);

        lblSubtotal.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        lblSubtotal.setText("0");

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel7.setText("Subtotal");

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel8.setText("Descuento");

        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel9.setText("Total");

        lblTotal.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        lblTotal.setText("0");

        lblPorcentaje.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        lblPorcentaje.setText("0");

        btnEliminar.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        jLabel5.setText("Facturacion");

        btnPagar.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnPagar.setText("Pagar");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(spnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cboProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(lblModelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAgregar)
                            .addComponent(btnPagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSubtotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(211, 211, 211))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(lblPrecio))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(spnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(lblModelo)))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        //setDatosVideojuego();
        //Nuevo detalle de Venta
        ClaseDetalle nDetalle = new ClaseDetalle();
        nDetalle.setIdJuego(setDatosVideojuego((String) cboProducto.getSelectedItem()).getId());
        nDetalle.setNombreJuego((String) cboProducto.getSelectedItem());
        nDetalle.setCantidad((int) spnCantidad.getValue());
        nDetalle.setSubtotal(nDetalle.getCantidad() * ((int) Double.parseDouble(lblPrecio.getText())));

        if (!buscarVenta(nDetalle)) {
            listaVentas.add(nDetalle);
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
        String sql = "select * from Juegos where nombre ='" + cboProducto.getSelectedItem() + "'";
        try {
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            if (rs.next()) {
                precio = Double.parseDouble(rs.getString("Precio"));
                lblPrecio.setText(rs.getString("Precio"));
                lblModelo.setText(rs.getString("Modelos"));
            }
        } catch (SQLException e) {
            System.out.println("e = " + e);
        }
    }//GEN-LAST:event_cboProductoItemStateChanged

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            //Verifica que tenga un registro seleccionado
            if (receptor == null) {
                JOptionPane.showMessageDialog(null, "Seleccione el articulo que desea eliminar");
            } else {
                modelo.removeRow(receptor.getSelectedRow());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccione el articulo que desea eliminar");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tblproductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblproductosMouseClicked
        receptor = (JTable) evt.getSource();
    }//GEN-LAST:event_tblproductosMouseClicked

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        realizarCompra();
    }//GEN-LAST:event_btnPagarActionPerformed

    public void realizarCompra() {
        LocalDate fecha = LocalDate.now();
        String fec = String.valueOf(fecha);
        int idV = 10, idD=0;
        try {
            String sInsertVenta = "INSERT INTO ventas (idVenta,idCliente,Fecha,Descuento,Total) VALUES(?,?,?,?,?)";
            String sInsertDetalle = "INSERT INTO detalle_ventas (ID,Venta,Juego,Cantidad,Subtotal) VALUES(?,?,?,?,?)";

            PreparedStatement pst = (PreparedStatement) cn.prepareStatement(sInsertVenta);
            idV++;
            pst.setString(1, String.valueOf(idV));
            pst.setString(2, usuario);//asignar usuario con el login
            pst.setString(3, fec);
            pst.setString(4, String.valueOf(porcentaje));
            pst.setString(5, String.valueOf(total));
            pst.execute();

            for (ClaseDetalle v : listaVentas) {
                idD = 1;
                idD++;
                System.out.println("Id: "+idD);
                /*PreparedStatement pstD = (PreparedStatement) cn.prepareStatement(sInsertDetalle);
                pstD.setString(1, String.valueOf(idV)+String.valueOf(idD));
                pstD.setString(2, String.valueOf(idV));
                pstD.setString(3, v.getIdJuego());
                pstD.setString(4, String.valueOf(porcentaje));
                pstD.setString(5, String.valueOf(total));
                pstD.execute();*/
                
            }

            JOptionPane.showMessageDialog(null, "Compra realizada con Exito");

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    public boolean buscarVenta(ClaseDetalle nueva) {

        for (ClaseDetalle v : listaVentas) {
            if (v.getNombreJuego().equals(nueva.getNombreJuego())) {
                System.out.println("Entra en el IF buscar venta");
                int nuevaCantidad = (int) (v.getCantidad() + nueva.getCantidad());
                v.setCantidad(nuevaCantidad);
                v.setSubtotal(setDatosVideojuego((String) cboProducto.getSelectedItem()).getPrecio() * nuevaCantidad);
                return true;
            }
        }
        return false;
    }

    public void borrarVenta() {
        precio = 0;
        cantidad = 1;
        cboProducto.setSelectedIndex(0);
        spnCantidad.setValue(1);
        calcularPrecio();
    }

    public void calcularPrecio() {
//        precio = precios[cboProducto.getSelectedIndex()];
        cantidad = Integer.parseInt(spnCantidad.getValue().toString());
        //lblPrecio.setText(aMoneda(precio));
    }

    public String aMoneda(double precio) {
        return "$ " + Math.round(precio * 100.00) / 100.00 + " COP";
    }

    public void actualizarTabla() {
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        double subtotal = 0;

        for (ClaseDetalle v : listaVentas) {
            Object x[] = new Object[4];
            x[0] = v.getNombreJuego();
            x[1] = setDatosVideojuego(v.getNombreJuego()).getCategoria();
            x[2] = v.getCantidad();
            x[3] = v.getSubtotal();
            modelo.addRow(x);
            subtotal = subtotal + v.getSubtotal();
        }

        porcentaje = subtotal * 0.15;
        total = subtotal + porcentaje;
        lblSubtotal.setText(aMoneda(subtotal));
        lblPorcentaje.setText(aMoneda(porcentaje));
        lblTotal.setText(aMoneda(total));
        tblproductos.setModel(modelo);
    }

    public void nombresJuegos() {
        String sql = "select * from Juegos";
        try {
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            while (rs.next()) {
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
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnPagar;
    public javax.swing.JComboBox cboProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
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
