import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.UUID;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */

/**

 * @author as
 */
public class pacientes extends javax.swing.JInternalFrame {

    
    Connection coneccionsql;
    Statement sentenciasql;
    DefaultTableModel modelo_tabla;  
    Integer idPaciente;
    /**
     * Creates new form NewJInternalFrame
     */
    public pacientes() {
        initComponents();
        botonEditar.setVisible(false);
        BotonGuardar.setVisible(true);
        botonBorrar.setVisible(false);
        coneccionsql = conectar.getConnection();
        llenarTablar();
    }

 private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

    public void llenarTablar() {
        try {
            //encabezados de la tabla
            String[] titulos = {"ID", "Cedula", "Nombre", "Nacimieto"};
            String stsql = "SELECT * FROM pacientes;";

            modelo_tabla = new DefaultTableModel(null, titulos);
            sentenciasql = coneccionsql.createStatement();
            ResultSet rs = sentenciasql.executeQuery(stsql);

            //arreglo fila, para almacenar registros
            String[] fila = new String[4];
            //while para insertar registros en la tabla
            while (rs.next()) {
                fila[0] = rs.getString("id");
                fila[1] = rs.getString("cedula");
                fila[2] = rs.getString("nombre");
                fila[3] = rs.getString("fecha_nacimiento");
                modelo_tabla.addRow(fila);
            }

            //agrego el default model
            TablaCliente.setModel(modelo_tabla);

            //definir el ancho de las columnas
            int[] anchos = {10, 100, 100, 100};
            for (int i = 0; i < TablaCliente.getColumnCount(); i++) {
                TablaCliente.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        campo_cedula = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        campo_nombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        BotonGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaCliente = new javax.swing.JTable();
        botonEditar = new javax.swing.JButton();
        botonBorrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        campoFecha = new com.toedter.calendar.JDateChooser();

        setClosable(true);

        jLabel1.setText("Cedula:");

        jLabel2.setText("Nombre:");

        jLabel4.setText("Pacientes");

        BotonGuardar.setText("GUARDAR");
        BotonGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonGuardarMouseClicked(evt);
            }
        });

        TablaCliente.setModel(new javax.swing.table.DefaultTableModel(
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
        TablaCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaCliente);

        botonEditar.setText("EDITAR");
        botonEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonEditarMouseClicked(evt);
            }
        });

        botonBorrar.setText("BORRAR");
        botonBorrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonBorrarMouseClicked(evt);
            }
        });

        jLabel3.setText("Fecha de nacimiento");

        jLabel6.setText("Registro de pacientes");

        campoFecha.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(213, 213, 213))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BotonGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(botonEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonBorrar)
                        .addGap(561, 561, 561))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campo_nombre)
                            .addComponent(campoFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                            .addComponent(campo_cedula))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(campo_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campo_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(campoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BotonGuardar)
                            .addComponent(botonEditar)
                            .addComponent(botonBorrar)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonGuardarMouseClicked
    try{
        String cedula = campo_cedula.getText();
        String nombre = campo_nombre.getText();
        java.util.Date fecha_nacimiento = campoFecha.getDate();
        
        String sqlguardar = "INSERT INTO pacientes (cedula, nombre, fecha_nacimiento) VALUES (?, ?, ?)";
        
        PreparedStatement ps = coneccionsql.prepareStatement(sqlguardar);
        ps.setString(1, cedula);
        ps.setString(2, nombre);
        ps.setDate(3, convertUtilToSql(fecha_nacimiento));
        
        System.out.println(sqlguardar);
        
        int n = ps.executeUpdate();
            if (n > 0) {
                campo_cedula.setText("");
                campo_nombre.setText("");
                
                llenarTablar();
                JOptionPane.showMessageDialog(this, "Se guardó correctamente");
            } else {
                JOptionPane.showMessageDialog(this, "Error al guardar");
            }
            ps.close();
        }catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(rootPane, "Error: No se podo registrar al paciente!");
    }//GEN-LAST:event_BotonGuardarMouseClicked
    }
    private void botonEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEditarMouseClicked
        try {
            String cedula = campo_cedula.getText();
            String nombre = campo_nombre.getText();
        java.util.Date fecha_nacimiento = campoFecha.getDate();

            //Guardar en la base de datos
            String stactualizar = "UPDATE pacientes SET cedula=?, nombre=?, fecha_nacimiento=? WHERE id=?";
            PreparedStatement ps = coneccionsql.prepareStatement(stactualizar);
            ps.setString(1, cedula);
            ps.setString(2, nombre);
        ps.setDate(3, convertUtilToSql(fecha_nacimiento));
            ps.setInt(4, idPaciente);
            
            int n = ps.executeUpdate();
            if (n > 0) {
                //limpiar formulario
                campo_cedula.setText("");
                campo_nombre.setText("");
                
                //reiniciar el estado de los botones
                BotonGuardar.setVisible(false);
                botonEditar.setVisible(true);

                llenarTablar();
                JOptionPane.showMessageDialog(this, "Se actualizo correctamente");
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar");
            }
            ps.close();

        } catch (Exception e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(rootPane, "Error: No se podo Editar al cliente!");
        }
    }//GEN-LAST:event_botonEditarMouseClicked

    private void botonBorrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonBorrarMouseClicked
        try {

            //Borrar registro en la base de datos
            String stborrar = "DELETE FROM pacientes WHERE id =" + idPaciente;
            PreparedStatement ps = coneccionsql.prepareStatement(stborrar);
            int n = ps.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(this, "Se borro correctamente");
            } else {
                JOptionPane.showMessageDialog(this, "Error al borrar");
            }
            ps.close();

            llenarTablar();
            //limpiar formulario
            campo_cedula.setText("");
            campo_nombre.setText("");
            
            //Reiniciar el estado de los botones
            BotonGuardar.setVisible(true);
            botonEditar.setVisible(false);
            botonBorrar.setVisible(false);

        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_botonBorrarMouseClicked

    private void TablaClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaClienteMouseClicked
        if (evt.getButton() == 1) {
            int fila = TablaCliente.getSelectedRow();
            try {
                String stsql = "SELECT * FROM pacientes WHERE id = " + TablaCliente.getValueAt(fila, 0);
                sentenciasql = coneccionsql.createStatement();
                ResultSet rs = sentenciasql.executeQuery(stsql);
                rs.next();

                idPaciente = rs.getInt("id");
                campo_cedula.setText(rs.getString("cedula"));
                campo_nombre.setText(rs.getString("nombre"));
                campoFecha.setDate(rs.getDate("fecha_nacimiento"));

                botonEditar.setVisible(true);
                BotonGuardar.setVisible(false);
                botonBorrar.setVisible(true);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_TablaClienteMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonGuardar;
    private javax.swing.JTable TablaCliente;
    private javax.swing.JButton botonBorrar;
    private javax.swing.JButton botonEditar;
    private com.toedter.calendar.JDateChooser campoFecha;
    private javax.swing.JTextField campo_cedula;
    private javax.swing.JTextField campo_nombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}