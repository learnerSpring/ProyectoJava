/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.bautizos;

import com.iglesia.autoridades.Autoridad;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author SONY
 */
public class gui_Modifica_bautizo extends javax.swing.JFrame {

    /**
     * Creates new form gui_modifica_bautizos
     */
    public gui_Modifica_bautizo() {
        initComponents();
        this.setLocationRelativeTo(null);
        //this.setSize(500, 1000);
    }

    public Connection obtiene_conexion(){
        Connection con= null;
        try {
            String url = "jdbc:MySQL://localhost:3306/sacramentos";         //db is the name of the database
            String user = "root";
            String password = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            //System.out.println("error tipo A ");
            con = (Connection) DriverManager.getConnection(url, user, password);
            
        }            
        catch(SQLException e) {
                System.out.println("error SQLException " + e.getMessage() );
                JOptionPane.showMessageDialog(null, "Error SqlExeption en Obtiene Conexion " + e.getMessage());
            }
        catch(Exception e){
                System.out.println("error Exception " + e.getMessage() );
                JOptionPane.showMessageDialog(null, "Error Exception en Obtiene Conexion" + e.getMessage() );
            } 
        return con;
    }
    public void limpiar_datos(){
        txt_nombre_cons.setText("");
        txt_id_bautizo.setText("");
        txt_nombre.setText("");
        txt_lugar_naci.setText("");
        txt_fecha_naci.setText("");
        txt_nombre_papa.setText("");
        txt_nombre_mama.setText("");
        txt_nombre_padrino.setText("");
        txt_nombre_madrina.setText("");
        txt_fecha_bautizo.setText("");
        txt_nombre_sacerdote.setText("");
        txt_rc_anio.setText("");
        txt_rc_tomo.setText("");
        txt_rc_folio.setText("");
        txt_rc_acta.setText("");
        txt_rc_fecha.setText("");
        txt_num_ins.setText("");
        txt_rp_libro.setText("");
        txt_rp_pagina.setText("");
        txt_rp_numero.setText("");
        txt_novedades.setText("");
    }
    
    public void consulta_datos(){
      
      String sql = "select * from bautizos where trim(nombre_bautizado) = ? ";
      Connection ct = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      DateFormat dateFormat = null;
      String strDate = null;
      
      try {
        ct = obtiene_conexion();
        pstmt = ct.prepareStatement(sql);
        pstmt.setString(1, txt_nombre_cons.getText().trim() );
        rs = pstmt.executeQuery();
        
        //System.out.println("paso 1");
        
        while ( rs.next() ){
            txt_id_bautizo.setText( String.valueOf(rs.getInt("id_bautizo")) );
            txt_nombre.setText(rs.getString("nombre_bautizado"));
            txt_lugar_naci.setText(rs.getString("lugar_nacimiento"));
            // Fecha Nacimiento
            dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
            strDate = dateFormat.format(rs.getDate("fecha_nacimiento") ); 
            txt_fecha_naci.setText( strDate );
            
            txt_nombre_papa.setText( rs.getString("nombre_papa") );
            txt_nombre_mama.setText( rs.getString("nombre_mama") );
            txt_nombre_padrino.setText( rs.getString("nombre_padrino") );    
            txt_nombre_madrina.setText(  rs.getString("nombre_madrina") );
            // Fecha bautizo 
            strDate = dateFormat.format(rs.getDate("fecha_bautizo") ); 
            txt_fecha_bautizo.setText( strDate );
            
            txt_nombre_sacerdote.setText( rs.getString("nombre_sacerdote") );
            // Datos de Registro Civil
            txt_rc_anio.setText( rs.getString("rc_año") ); 
            txt_rc_tomo.setText( rs.getString("rc_tomo") );
            txt_rc_folio.setText( rs.getString("rc_folio") ); 
            txt_rc_acta.setText( rs.getString("rc_acta") );
            // Registro Civil: Fecha
            if ( rs.getDate("rc_fecha") != null){
              strDate = dateFormat.format(rs.getDate("rc_fecha") ); 
              txt_rc_fecha.setText( strDate );
            }
            
            
            
            txt_num_ins.setText( rs.getString("rc_num_inscripcion") );
            // Registro Parroquial
            txt_rp_libro.setText( rs.getString("rp_libro"));
            txt_rp_pagina.setText( rs.getString("rp_pagina"));
            txt_rp_numero.setText( rs.getString("rp_numero") );
            txt_novedades.setText( rs.getString("novedades") );                
        }
      }
      catch(Exception e){
          JOptionPane.showMessageDialog(null, "Error Exception en Funcion consulta_datos " + e.getMessage());
      }
      finally{
                try {   if (ct != null) ct.close(); if (pstmt != null) pstmt.close(); if (rs != null)   rs.close();  }
                catch(SQLException sq){
                    System.out.println("En Finally cerrando conexion en funcion obtiene_lista" + sq.getMessage() );
                    JOptionPane.showMessageDialog(null, "En Finally cerrando conexion, en funcion consulta_datos " + sq.getMessage() );
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

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_id_bautizo = new javax.swing.JTextField();
        txt_lugar_naci = new javax.swing.JTextField();
        txt_fecha_naci = new javax.swing.JTextField();
        txt_nombre_papa = new javax.swing.JTextField();
        txt_nombre_mama = new javax.swing.JTextField();
        txt_nombre_padrino = new javax.swing.JTextField();
        txt_nombre_madrina = new javax.swing.JTextField();
        txt_nombre_cons = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        txt_fecha_bautizo = new javax.swing.JTextField();
        txt_nombre_sacerdote = new javax.swing.JTextField();
        txt_nombre_cons10 = new javax.swing.JTextField();
        txt_rc_anio = new javax.swing.JTextField();
        txt_rc_tomo = new javax.swing.JTextField();
        txt_rc_folio = new javax.swing.JTextField();
        txt_rc_acta = new javax.swing.JTextField();
        txt_rc_fecha = new javax.swing.JTextField();
        txt_num_ins = new javax.swing.JTextField();
        actualizar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txt_rp_libro = new javax.swing.JTextField();
        txt_rp_pagina = new javax.swing.JTextField();
        txt_rp_numero = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_novedades = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Modificación de datos de bautizo");
        setAlwaysOnTop(true);
        setPreferredSize(new java.awt.Dimension(620, 680));
        setSize(new java.awt.Dimension(620, 680));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("Ingrese Nombre");

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 250));
        jButton1.setText("Consultar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 204));
        jLabel2.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 204));
        jLabel3.setText("Lugar Nacimiento");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 204));
        jLabel4.setText("Fecha Nacimiento");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 204));
        jLabel5.setText("Nombre Papa");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 204));
        jLabel6.setText("Nombre Mama");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 204));
        jLabel7.setText("Nombre Padrino");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 204));
        jLabel8.setText("Nombre Madrina");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 204));
        jLabel9.setText("Fecha Bautizo");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 204));
        jLabel10.setText("Nombre Sacerdote");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 204));
        jLabel11.setText("Datos de Registro Civil");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 204));
        jLabel12.setText("Año");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 204));
        jLabel13.setText("Tomo");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 204));
        jLabel14.setText("Folio");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 204));
        jLabel15.setText("Acta");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 204));
        jLabel16.setText("Fecha");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 204));
        jLabel17.setText("# Inscripcion");

        txt_nombre.setToolTipText("Ingrese el nombre del bautizado");
        txt_nombre.setName(""); // NOI18N
        txt_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreActionPerformed(evt);
            }
        });

        txt_id_bautizo.setEditable(false);
        txt_id_bautizo.setToolTipText("Ingrese el nombre del bautizado");
        txt_id_bautizo.setName(""); // NOI18N
        txt_id_bautizo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_bautizoActionPerformed(evt);
            }
        });

        txt_lugar_naci.setToolTipText("Ingrese el nombre del bautizado");
        txt_lugar_naci.setName(""); // NOI18N
        txt_lugar_naci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_lugar_naciActionPerformed(evt);
            }
        });

        txt_fecha_naci.setToolTipText("Ingrese el nombre del bautizado");
        txt_fecha_naci.setName(""); // NOI18N
        txt_fecha_naci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_fecha_naciActionPerformed(evt);
            }
        });
        txt_fecha_naci.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_fecha_naciKeyReleased(evt);
            }
        });

        txt_nombre_papa.setToolTipText("Ingrese el nombre del bautizado");
        txt_nombre_papa.setName(""); // NOI18N
        txt_nombre_papa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombre_papaActionPerformed(evt);
            }
        });

        txt_nombre_mama.setToolTipText("Ingrese el nombre del bautizado");
        txt_nombre_mama.setName(""); // NOI18N
        txt_nombre_mama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombre_mamaActionPerformed(evt);
            }
        });

        txt_nombre_padrino.setToolTipText("Ingrese el nombre del bautizado");
        txt_nombre_padrino.setName(""); // NOI18N
        txt_nombre_padrino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombre_padrinoActionPerformed(evt);
            }
        });

        txt_nombre_madrina.setToolTipText("Ingrese el nombre del bautizado");
        txt_nombre_madrina.setName(""); // NOI18N
        txt_nombre_madrina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombre_madrinaActionPerformed(evt);
            }
        });

        txt_nombre_cons.setToolTipText("Ingrese el nombre del bautizado");
        txt_nombre_cons.setName(""); // NOI18N
        txt_nombre_cons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombre_consActionPerformed(evt);
            }
        });

        jTextField1.setText("jTextField1");

        txt_fecha_bautizo.setToolTipText("Ingrese el nombre del bautizado");
        txt_fecha_bautizo.setName(""); // NOI18N
        txt_fecha_bautizo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_fecha_bautizoActionPerformed(evt);
            }
        });
        txt_fecha_bautizo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_fecha_bautizoKeyReleased(evt);
            }
        });

        txt_nombre_sacerdote.setToolTipText("Ingrese el nombre del bautizado");
        txt_nombre_sacerdote.setName(""); // NOI18N
        txt_nombre_sacerdote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombre_sacerdoteActionPerformed(evt);
            }
        });

        txt_nombre_cons10.setToolTipText("Ingrese el nombre del bautizado");
        txt_nombre_cons10.setName(""); // NOI18N
        txt_nombre_cons10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombre_cons10ActionPerformed(evt);
            }
        });

        txt_rc_anio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rc_anioActionPerformed(evt);
            }
        });

        txt_rc_tomo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rc_tomoActionPerformed(evt);
            }
        });

        txt_rc_folio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rc_folioActionPerformed(evt);
            }
        });

        txt_rc_acta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rc_actaActionPerformed(evt);
            }
        });

        txt_rc_fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rc_fechaActionPerformed(evt);
            }
        });
        txt_rc_fecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_rc_fechaKeyReleased(evt);
            }
        });

        txt_num_ins.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_num_insActionPerformed(evt);
            }
        });

        actualizar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        actualizar.setForeground(new java.awt.Color(0, 0, 250));
        actualizar.setText("Actualizar");
        actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 250));
        jButton3.setText("Limpiar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 204));
        jLabel18.setText("Id");

        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 0, 250));
        jButton4.setText("Salir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 204));
        jLabel19.setText("Registro Parroquial");

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 204));
        jLabel20.setText("Pagina");

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 204));
        jLabel21.setText("Libro");

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 204));
        jLabel22.setText("Numero");

        txt_rp_libro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rp_libroActionPerformed(evt);
            }
        });

        txt_rp_pagina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rp_paginaActionPerformed(evt);
            }
        });

        txt_rp_numero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rp_numeroActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 204));
        jLabel23.setText("Novedades");

        txt_novedades.setColumns(20);
        txt_novedades.setRows(5);
        jScrollPane1.setViewportView(txt_novedades);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_lugar_naci, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_fecha_naci, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_nombre_papa, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_nombre_mama, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_nombre_padrino, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_nombre_madrina, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_nombre_cons, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_nombre_cons10, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_fecha_bautizo, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_id_bautizo, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_nombre_sacerdote, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_rp_libro, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_rp_pagina, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(txt_rp_numero, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(actualizar)
                        .addGap(16, 16, 16)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_rc_anio, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_rc_acta, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_rc_tomo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_rc_folio, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_rc_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_num_ins, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel19))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nombre_cons10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_nombre_cons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txt_id_bautizo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3))
                    .addComponent(txt_lugar_naci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_fecha_naci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_nombre_papa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_nombre_mama, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_nombre_padrino, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_nombre_madrina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(txt_fecha_bautizo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_nombre_sacerdote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel14)
                    .addComponent(txt_rc_anio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txt_rc_tomo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_rc_folio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txt_rc_acta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(txt_rc_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(txt_num_ins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel22)
                    .addComponent(jLabel21)
                    .addComponent(txt_rp_libro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_rp_numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_rp_pagina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(actualizar)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(94, Short.MAX_VALUE))
        );

        actualizar.getAccessibleContext().setAccessibleName("actualizar");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreActionPerformed
        txt_lugar_naci.requestFocusInWindow();
    }//GEN-LAST:event_txt_nombreActionPerformed

    private void txt_lugar_naciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_lugar_naciActionPerformed
        txt_fecha_naci.requestFocusInWindow();
    }//GEN-LAST:event_txt_lugar_naciActionPerformed

    private void txt_nombre_papaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombre_papaActionPerformed
        txt_nombre_mama.requestFocusInWindow();
    }//GEN-LAST:event_txt_nombre_papaActionPerformed

    private void txt_nombre_mamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombre_mamaActionPerformed
        txt_nombre_padrino.requestFocusInWindow();
    }//GEN-LAST:event_txt_nombre_mamaActionPerformed

    private void txt_nombre_padrinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombre_padrinoActionPerformed
        txt_nombre_madrina.requestFocusInWindow();
    }//GEN-LAST:event_txt_nombre_padrinoActionPerformed

    private void txt_nombre_madrinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombre_madrinaActionPerformed
        txt_fecha_bautizo.requestFocusInWindow();
    }//GEN-LAST:event_txt_nombre_madrinaActionPerformed

    private void txt_nombre_consActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombre_consActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombre_consActionPerformed

    private void txt_nombre_cons10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombre_cons10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombre_cons10ActionPerformed

    private void txt_fecha_bautizoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_fecha_bautizoActionPerformed
        txt_nombre_sacerdote.requestFocusInWindow();
    }//GEN-LAST:event_txt_fecha_bautizoActionPerformed

    private void txt_id_bautizoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_bautizoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_bautizoActionPerformed

    private void txt_rc_tomoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rc_tomoActionPerformed
        txt_rc_folio.requestFocusInWindow();
    }//GEN-LAST:event_txt_rc_tomoActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:            
    }//GEN-LAST:event_jButton1MouseClicked

    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed
        // TODO add your handling code here:
     Connection ct = null;   
     PreparedStatement pst = null;
     try
      { 
        String sql = " update bautizos" + 
                     " set nombre_bautizado = ?, " + 
                         " lugar_nacimiento = ?, " +
                         " fecha_nacimiento = ?, " +
                         " nombre_papa = ?, " +
                         " nombre_mama = ?, " +
                         " nombre_padrino = ?, " + 
                         " nombre_madrina = ?, " +
                         " fecha_bautizo = ?, " + 
                         " nombre_sacerdote = ?, " + 
                         " rc_año = ?, rc_tomo = ?, rc_folio = ?, " + 
                         " rc_acta = ?, rc_fecha = ?, rc_num_inscripcion = ? ," + 
                         " rp_libro = ?, rp_pagina = ?, rp_numero = ?, novedades = ? " +
                         " where id_bautizo = ? ";
        ct = obtiene_conexion();
        pst = ct.prepareStatement(sql);
        
        //String auto = tf_autoridad.getText();
        
        pst.setString(1, txt_nombre.getText());
        pst.setString(2, txt_lugar_naci.getText());
        // campo fecha nacimiento
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date myDate = formatter.parse( txt_fecha_naci.getText() );
        java.sql.Date datoFechaNacimiento = new java.sql.Date(myDate.getTime());            
        pst.setDate(3, datoFechaNacimiento );
        
        pst.setString(4, txt_nombre_papa.getText() );
        pst.setString(5, txt_nombre_mama.getText() );   
        pst.setString(6, txt_nombre_padrino.getText() );
        pst.setString(7, txt_nombre_madrina.getText() );
        // campo fecha bautizo
        myDate = formatter.parse( txt_fecha_bautizo.getText() );
        java.sql.Date datoFechaBautizo = new java.sql.Date(myDate.getTime());            
        pst.setDate(8, datoFechaBautizo );
        pst.setString(9, txt_nombre_sacerdote.getText());
        pst.setString(10, txt_rc_anio.getText());
        pst.setString(11, txt_rc_tomo.getText());
        pst.setString(12, txt_rc_folio.getText());
        pst.setString(13, txt_rc_acta.getText()   );
        // campo en Registro Civil, fecha
        if ( ! txt_rc_fecha.getText().isEmpty() ) { 
          myDate = formatter.parse( txt_rc_fecha.getText() );
          java.sql.Date dat_rc_fecha = new java.sql.Date(myDate.getTime());            
          pst.setDate(14, dat_rc_fecha );
        }
        else
            pst.setNull(14, java.sql.Types.DATE);
        
        
        pst.setString(15, txt_num_ins.getText()   );
        pst.setString(16, txt_rp_libro.getText() );
        pst.setString(17, txt_rp_pagina.getText() );
        pst.setString(18, txt_rp_numero.getText() );
        pst.setString( 19, txt_novedades.getText() );
        
        pst.setInt(20, Integer.parseInt( txt_id_bautizo.getText() ) );
        
        System.out.println("paso 4");
        
        System.out.println(sql);
        int res = pst.executeUpdate();
        if (res>0){
          System.out.println("Actualizacion realizada con exito");
          JOptionPane.showMessageDialog(this, "Registro se actualizó con exito");  }
        else 
          JOptionPane.showMessageDialog(this, "No se actualizó el registro con los cambios");  
        
        
        limpiar_datos();
        consulta_datos();
        
        //actualizar.setEnabled(false);
      }
      catch(Exception e){
          JOptionPane.showMessageDialog(null, "Error Exception en Boton Actualizar " + e.getMessage());
      }
      finally{
                try {   if (ct != null) ct.close(); if (pst != null) pst.close(); }
                catch(SQLException sq){
                    System.out.println("En Finally en boton Actualizar" + sq.getMessage() );
                    JOptionPane.showMessageDialog(null, "En Finally en boton Actualizar" + sq.getMessage() );
                }
      }
        
    }//GEN-LAST:event_actualizarActionPerformed

    private void txt_nombre_sacerdoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombre_sacerdoteActionPerformed
        txt_rc_anio.requestFocusInWindow();
    }//GEN-LAST:event_txt_nombre_sacerdoteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       consulta_datos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        limpiar_datos();
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txt_fecha_naciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_fecha_naciActionPerformed
        txt_nombre_papa.requestFocusInWindow();
    }//GEN-LAST:event_txt_fecha_naciActionPerformed

    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed

                
    }//GEN-LAST:event_jButton1MousePressed

    private void txt_fecha_naciKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_fecha_naciKeyReleased
        if (txt_fecha_naci.getText().length() > 10){
               txt_fecha_naci.setText("");
               //setea_Fecha_actual(txt_fecga_naci);
        }
    }//GEN-LAST:event_txt_fecha_naciKeyReleased

    private void txt_fecha_bautizoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_fecha_bautizoKeyReleased
        if (txt_fecha_bautizo.getText().length() > 10){
               txt_fecha_bautizo.setText("");
               //setea_Fecha_actual(txt_fecga_naci);
        }
    }//GEN-LAST:event_txt_fecha_bautizoKeyReleased

    private void txt_rc_fechaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_rc_fechaKeyReleased
        if (txt_rc_fecha.getText().length() > 10){
               txt_rc_fecha.setText("");
               //setea_Fecha_actual(txt_fecga_naci);
        }
    }//GEN-LAST:event_txt_rc_fechaKeyReleased

    private void txt_rc_anioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rc_anioActionPerformed
        txt_rc_tomo.requestFocusInWindow();
    }//GEN-LAST:event_txt_rc_anioActionPerformed

    private void txt_rc_folioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rc_folioActionPerformed
        txt_rc_acta.requestFocusInWindow();
    }//GEN-LAST:event_txt_rc_folioActionPerformed

    private void txt_rc_actaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rc_actaActionPerformed
        txt_rc_fecha.requestFocusInWindow();
    }//GEN-LAST:event_txt_rc_actaActionPerformed

    private void txt_rc_fechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rc_fechaActionPerformed
        txt_num_ins.requestFocusInWindow();
    }//GEN-LAST:event_txt_rc_fechaActionPerformed

    private void txt_num_insActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_num_insActionPerformed
        txt_rp_libro.requestFocusInWindow();
    }//GEN-LAST:event_txt_num_insActionPerformed

    private void txt_rp_paginaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rp_paginaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_rp_paginaActionPerformed

    private void txt_rp_libroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rp_libroActionPerformed
        txt_rp_pagina.requestFocusInWindow();
    }//GEN-LAST:event_txt_rp_libroActionPerformed

    private void txt_rp_numeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rp_numeroActionPerformed
        txt_nombre.requestFocusInWindow();
    }//GEN-LAST:event_txt_rp_numeroActionPerformed

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
            java.util.logging.Logger.getLogger(gui_Modifica_bautizo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gui_Modifica_bautizo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gui_Modifica_bautizo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gui_Modifica_bautizo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gui_Modifica_bautizo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txt_fecha_bautizo;
    private javax.swing.JTextField txt_fecha_naci;
    private javax.swing.JTextField txt_id_bautizo;
    private javax.swing.JTextField txt_lugar_naci;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_nombre_cons;
    private javax.swing.JTextField txt_nombre_cons10;
    private javax.swing.JTextField txt_nombre_madrina;
    private javax.swing.JTextField txt_nombre_mama;
    private javax.swing.JTextField txt_nombre_padrino;
    private javax.swing.JTextField txt_nombre_papa;
    private javax.swing.JTextField txt_nombre_sacerdote;
    private javax.swing.JTextArea txt_novedades;
    private javax.swing.JTextField txt_num_ins;
    private javax.swing.JTextField txt_rc_acta;
    private javax.swing.JTextField txt_rc_anio;
    private javax.swing.JTextField txt_rc_fecha;
    private javax.swing.JTextField txt_rc_folio;
    private javax.swing.JTextField txt_rc_tomo;
    private javax.swing.JTextField txt_rp_libro;
    private javax.swing.JTextField txt_rp_numero;
    private javax.swing.JTextField txt_rp_pagina;
    // End of variables declaration//GEN-END:variables
}
