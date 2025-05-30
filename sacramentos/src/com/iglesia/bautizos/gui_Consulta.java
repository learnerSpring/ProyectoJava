/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.bautizos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import org.apache.commons.logging.LogFactory; 
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JRPrintElement;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperPrintManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;
//import org.apache.commons.javaflow.core.StackRecorder;

public class gui_Consulta extends javax.swing.JFrame {

    /**
     * Creates new form gui_Consulta
     */
    String p_parroco = "";
    String p_ministro = "";

    String p_autoridad = "";
    String p_nombre_autoridad = "";

    
    public gui_Consulta() {
        initComponents();
        llena_combo();
        this.setLocationRelativeTo(null);
    }
    public Connection obtiene_conexion(){
        Connection con= null;
        try {
            String url = "jdbc:MySQL://localhost:3306/sacramentos";         //db is the name of the database
            String user = "root";
            String password = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            //System.out.println("error tipo A ");
            con = (Connection) DriverManager.getConnection(url,user,password);
                
        }            
        catch(SQLException e) {
                System.out.println("error tipo SQLException " + e.getMessage() );
                JOptionPane.showMessageDialog(null, "Error SqlExeption en Obtiene Conexion " + e.getMessage());
            }
        catch(Exception e){
                System.out.println("error tipo Exception " + e.getMessage() );
                JOptionPane.showMessageDialog(null, "Error Exeption en Obtiene Conexion" + e.getMessage() );
            } 
        return con;
        }
    
    public void llena_combo(){
      Connection cnt = null;    
      try
        {    
            cnt = obtiene_conexion();
            Statement stm = cnt.createStatement();
            String sql = "select * from opciones_autoridades";
            ResultSet rs = stm.executeQuery(sql);
            while ( rs.next() ){
              String str = rs.getString("desc_opc_aut") + ": " + rs.getString("nom_opc_autoridad");
              lis_autoridad.removeAll();
              lis_autoridad.addItem(str);
            }
      
        }
        catch(SQLException e) {
                System.out.println("error tipo SQLException " + e.getMessage() );
                JOptionPane.showMessageDialog(null, "Error SQLException" + e.getMessage());
        }
        catch(Exception e){
                System.out.println("error tipo Exception " + e.getMessage() );
                JOptionPane.showMessageDialog(null, "Error Exception" + e.getMessage());
        } 
        finally{
                try {   if (cnt != null)   cnt.close();  }
                catch(SQLException sq){
                    System.out.println("En Finally cerrando conexion en funcion llena_combo" + sq.getMessage() );
                    JOptionPane.showMessageDialog(null, "En Finally cerrando conexion, en funcion llena_combo " + sq.getMessage() );
                }
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

        lab1 = new javax.swing.JLabel();
        tf_nombre = new javax.swing.JTextField();
        jb_Consulta = new javax.swing.JButton();
        jb_Salir = new javax.swing.JButton();
        lab2 = new javax.swing.JLabel();
        lis_autoridad = new javax.swing.JComboBox<>();

        setTitle("Consulta de Bautizo");

        lab1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lab1.setForeground(new java.awt.Color(0, 0, 204));
        lab1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lab1.setText("Nombre Bautizado");

        tf_nombre.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tf_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_nombreActionPerformed(evt);
            }
        });

        jb_Consulta.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jb_Consulta.setForeground(new java.awt.Color(0, 0, 255));
        jb_Consulta.setText("Consultar");
        jb_Consulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_ConsultaActionPerformed(evt);
            }
        });

        jb_Salir.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jb_Salir.setForeground(new java.awt.Color(0, 0, 255));
        jb_Salir.setText("Salir");
        jb_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_SalirActionPerformed(evt);
            }
        });

        lab2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lab2.setForeground(new java.awt.Color(0, 0, 204));
        lab2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lab2.setText("Autoridad que Firma");

        lis_autoridad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lis_autoridadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lab2)
                        .addGap(44, 44, 44))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lab1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jb_Consulta, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jb_Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lis_autoridad, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(lab1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lab2)
                    .addComponent(lis_autoridad, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_Consulta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(110, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jb_ConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_ConsultaActionPerformed
      
       String parametro = tf_nombre.getText();
       Connection conn = null; 
       // Conexion
       try 
         {
            
         conn = obtiene_conexion();
         Map<String, Object> map = new HashMap<String, Object>();
         map.put("P_Nombre", tf_nombre.getText()  );
//         map.put("P_Nombre_Papa", tf_nombre_papa.getText()  );
//         map.put("P_Nombre_Mama", tf_nombre_mama.getText()  );
         
         //lee_Propiedades();
         map.put("P_Autoridad", p_autoridad);
         map.put("P_Nombre_Autoridad", p_nombre_autoridad);         
         
         System.out.println("paso 1" );
         String sep = System.getProperty("file.separator");
         //String ruta = "c:"+sep+"Users"+sep+ "pnsde"+sep+ "JaspersoftWorkspace"+sep+"MyReports"+sep+"simple.jasper";
         String ruta = "c:\\Users\\pnsde\\JaspersoftWorkspace\\MyReports\\PRODUCCION\\reporte.jasper";
         //sruta = ruta.replace("\\", "/");
         
         JasperReport jr = null;
         jr = (JasperReport) JRLoader.loadObjectFromFile(ruta);
         JasperPrint jp = JasperFillManager.fillReport( jr, map, conn);
         //System.out.println("paso 3" );
         
         
         JasperViewer jv = new JasperViewer(jp);
         //System.out.println("paso 4" );
         jv.setVisible(true);
         //JasperPrintManager.printReport(jp, true);
       
        }       
        
        catch (JRException jrex) {
            System.out.println(jrex.toString());
            JOptionPane.showMessageDialog(null, "Error JRException en llamada al reporte " + jrex.getMessage());
        }
        catch(Exception e){ 
            System.out.println("error tipo Exception " + e.getMessage() );
            JOptionPane.showMessageDialog(null, "Error Exception en llamada al reporte > " + e.getMessage());
        }
        finally {
            try { if (conn != null) conn.close();   }
            catch(SQLException sq){
              System.out.println("Error en Finally cerrando conexion en llamada al reporte " + sq.getMessage() );
            }
        }
            
    }//GEN-LAST:event_jb_ConsultaActionPerformed

    private void jb_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_SalirActionPerformed
        //System.exit(0);
        this.setVisible(false);
    }//GEN-LAST:event_jb_SalirActionPerformed

    private void lis_autoridadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lis_autoridadActionPerformed

        String ini = lis_autoridad.getSelectedItem().toString();
        int pos = ini.indexOf(":");
        p_autoridad = ini.substring(0, pos);
        p_nombre_autoridad = ini.substring(pos+2);
        System.out.println(p_autoridad);
        System.out.println(p_nombre_autoridad);

    }//GEN-LAST:event_lis_autoridadActionPerformed

    private void tf_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_nombreActionPerformed
        
    }//GEN-LAST:event_tf_nombreActionPerformed

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
            java.util.logging.Logger.getLogger(gui_Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gui_Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gui_Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gui_Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gui_Consulta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jb_Consulta;
    private javax.swing.JButton jb_Salir;
    private javax.swing.JLabel lab1;
    private javax.swing.JLabel lab2;
    private javax.swing.JComboBox<String> lis_autoridad;
    private javax.swing.JTextField tf_nombre;
    // End of variables declaration//GEN-END:variables
}
