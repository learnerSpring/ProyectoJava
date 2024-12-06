// Cambio: Esta pantalla es para modificar registros de bautizos ya ingresados
// Fecha: 06/09/2022
package com.iglesia.confirmaciones;

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
public class gui_Confirma_Modificacion extends javax.swing.JFrame {

    /**
     * Creates new form gui_modifica_bautizos
     */
    public gui_Confirma_Modificacion() {
        initComponents();
        this.setLocationRelativeTo(null);
        //this.setSize(500, 1000);
    }
    public boolean valida_datos(){    
      if ( tf_nombre_confirmado.getText().isEmpty() ||
           tf_lugar_naci.getText().isEmpty() || tf_fecha_naci.getText().isEmpty() || tf_lugar_bautizo.getText().isEmpty() ||
           tf_ministro.getText().isEmpty()  || tf_fecha_confirma.getText().isEmpty() 
              )
          return false;
      else 
          return true;
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
        txt_id_confirmado.setText("");
        tf_nombre_confirmado.setText("");
        tf_nombre_papa.setText("");
        tf_nombre_mama.setText("");
        tf_nombre_padrino.setText("");
        tf_nombre_madrina.setText("");
        tf_lugar_naci.setText("");
        tf_fecha_naci.setText("");
        tf_lugar_bautizo.setText("");
        tf_ministro.setText("");
        tf_fecha_confirma.setText("");
        
        tf_rp_libro.setText("");
        tf_rp_pagina.setText("");
        tf_rp_numero.setText("");
        
        tf_novedades.setText("");
    }
    
    public void consulta_datos(){
      
      String sql = "select * from confirmaciones where trim(nombre_confirmado) = ? ";
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
            txt_id_confirmado.setText( String.valueOf(rs.getInt("id_confirma")) );
            tf_nombre_confirmado.setText(rs.getString("nombre_confirmado"));
            tf_nombre_papa.setText( rs.getString("nombre_papa") );
            tf_nombre_mama.setText( rs.getString("nombre_mama") );
            tf_nombre_padrino.setText( rs.getString("nombre_padrino") );
            tf_nombre_madrina.setText( rs.getString("nombre_madrina") );
            tf_lugar_naci.setText(rs.getString("lugar_nacimiento"));
            // Fecha Nacimiento
            dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
            strDate = dateFormat.format(rs.getDate("fecha_nacimiento") ); 
            tf_fecha_naci.setText( strDate );
            
            tf_lugar_bautizo.setText( rs.getString("lugar_bautizo") );
            tf_ministro.setText( rs.getString("nombre_ministro") );
            
            
            strDate = dateFormat.format(rs.getDate("fecha_confirmacion") ); 
            tf_fecha_confirma.setText( strDate );
            
            // Datos de Registro Civil
            tf_rp_libro.setText( rs.getString("rp_libro") ); 
            tf_rp_pagina.setText( rs.getString("rp_pagina"));
            tf_rp_numero.setText( rs.getString("rp_numero") );
            tf_novedades.setText( rs.getString("novedades") );                
      
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
        jLabel12 = new javax.swing.JLabel();
        tf_nombre_confirmado = new javax.swing.JTextField();
        txt_id_confirmado = new javax.swing.JTextField();
        tf_nombre_papa = new javax.swing.JTextField();
        tf_nombre_mama = new javax.swing.JTextField();
        tf_nombre_padrino = new javax.swing.JTextField();
        tf_nombre_madrina = new javax.swing.JTextField();
        tf_lugar_naci = new javax.swing.JTextField();
        tf_fecha_naci = new javax.swing.JTextField();
        txt_nombre_cons = new javax.swing.JTextField();
        tf_lugar_bautizo = new javax.swing.JTextField();
        tf_ministro = new javax.swing.JTextField();
        tf_fecha_confirma = new javax.swing.JTextField();
        actualizar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        tf_rp_libro = new javax.swing.JTextField();
        tf_rp_pagina = new javax.swing.JTextField();
        tf_rp_numero = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tf_novedades = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Modificación de datos de Confirmado");
        setAlwaysOnTop(true);
        setPreferredSize(new java.awt.Dimension(670, 680));
        setSize(new java.awt.Dimension(670, 680));

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
        jLabel2.setText("Nombre Confirmado");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 204));
        jLabel3.setText("Nombre y Apellido Papa");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 204));
        jLabel4.setText("Nombre y Apellido Mama");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 204));
        jLabel5.setText("Nombre Padrino");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 204));
        jLabel6.setText("Nombre Madrina");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 204));
        jLabel7.setText("Lugar Natal");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 204));
        jLabel8.setText("Fecha Nacimiento");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 204));
        jLabel9.setText("Lugar e Iglesia Bautizo");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 204));
        jLabel10.setText("Ministro Confirmación");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 204));
        jLabel12.setText("Fecha Confirmación");

        tf_nombre_confirmado.setToolTipText("Ingrese el nombre del bautizado");
        tf_nombre_confirmado.setName(""); // NOI18N
        tf_nombre_confirmado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_nombre_confirmadoActionPerformed(evt);
            }
        });

        txt_id_confirmado.setEditable(false);
        txt_id_confirmado.setToolTipText("Ingrese el nombre del bautizado");
        txt_id_confirmado.setName(""); // NOI18N
        txt_id_confirmado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_confirmadoActionPerformed(evt);
            }
        });

        tf_nombre_papa.setToolTipText("Ingrese el nombre del bautizado");
        tf_nombre_papa.setName(""); // NOI18N
        tf_nombre_papa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_nombre_papaActionPerformed(evt);
            }
        });

        tf_nombre_mama.setToolTipText("Ingrese el nombre del bautizado");
        tf_nombre_mama.setName(""); // NOI18N
        tf_nombre_mama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_nombre_mamaActionPerformed(evt);
            }
        });
        tf_nombre_mama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_nombre_mamaKeyReleased(evt);
            }
        });

        tf_nombre_padrino.setToolTipText("Ingrese el nombre del bautizado");
        tf_nombre_padrino.setName(""); // NOI18N
        tf_nombre_padrino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_nombre_padrinoActionPerformed(evt);
            }
        });

        tf_nombre_madrina.setToolTipText("Ingrese el nombre del bautizado");
        tf_nombre_madrina.setName(""); // NOI18N
        tf_nombre_madrina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_nombre_madrinaActionPerformed(evt);
            }
        });

        tf_lugar_naci.setToolTipText("Ingrese el nombre del bautizado");
        tf_lugar_naci.setName(""); // NOI18N
        tf_lugar_naci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_lugar_naciActionPerformed(evt);
            }
        });

        tf_fecha_naci.setToolTipText("Ingrese el nombre del bautizado");
        tf_fecha_naci.setName(""); // NOI18N
        tf_fecha_naci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_fecha_naciActionPerformed(evt);
            }
        });
        tf_fecha_naci.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_fecha_naciKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_fecha_naciKeyReleased(evt);
            }
        });

        txt_nombre_cons.setToolTipText("Ingrese el nombre del bautizado");
        txt_nombre_cons.setName(""); // NOI18N
        txt_nombre_cons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombre_consActionPerformed(evt);
            }
        });

        tf_lugar_bautizo.setToolTipText("Ingrese el nombre del bautizado");
        tf_lugar_bautizo.setName(""); // NOI18N
        tf_lugar_bautizo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_lugar_bautizoActionPerformed(evt);
            }
        });
        tf_lugar_bautizo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_lugar_bautizoKeyReleased(evt);
            }
        });

        tf_ministro.setToolTipText("Ingrese el nombre del bautizado");
        tf_ministro.setName(""); // NOI18N
        tf_ministro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ministroActionPerformed(evt);
            }
        });

        tf_fecha_confirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_fecha_confirmaActionPerformed(evt);
            }
        });
        tf_fecha_confirma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_fecha_confirmaKeyReleased(evt);
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

        tf_rp_libro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_rp_libroActionPerformed(evt);
            }
        });

        tf_rp_pagina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_rp_paginaActionPerformed(evt);
            }
        });

        tf_rp_numero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_rp_numeroActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 204));
        jLabel23.setText("Novedades");

        tf_novedades.setColumns(20);
        tf_novedades.setRows(5);
        jScrollPane1.setViewportView(tf_novedades);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(actualizar)
                        .addGap(16, 16, 16)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tf_rp_libro, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_rp_pagina, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_rp_numero, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(93, 93, 93))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(473, 588, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_id_confirmado, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_nombre_madrina, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_lugar_naci, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_fecha_naci, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_ministro, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_nombre_padrino, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_nombre_confirmado, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_nombre_mama, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txt_nombre_cons, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton1))
                                    .addComponent(tf_nombre_papa, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_fecha_confirma, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(78, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tf_lugar_bautizo, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(txt_nombre_cons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(txt_id_confirmado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_nombre_confirmado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3))
                    .addComponent(tf_nombre_papa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tf_nombre_mama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tf_nombre_padrino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tf_nombre_madrina, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tf_lugar_naci, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tf_fecha_naci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tf_lugar_bautizo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tf_ministro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(tf_fecha_confirma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel22)
                    .addComponent(jLabel21)
                    .addComponent(tf_rp_pagina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_rp_numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_rp_libro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(actualizar)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(96, Short.MAX_VALUE))
        );

        actualizar.getAccessibleContext().setAccessibleName("actualizar");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_nombre_confirmadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_nombre_confirmadoActionPerformed
        tf_nombre_papa.requestFocusInWindow();
    }//GEN-LAST:event_tf_nombre_confirmadoActionPerformed

    private void tf_nombre_papaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_nombre_papaActionPerformed
        tf_nombre_mama.requestFocusInWindow();
    }//GEN-LAST:event_tf_nombre_papaActionPerformed

    private void tf_nombre_padrinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_nombre_padrinoActionPerformed
        tf_nombre_madrina.requestFocusInWindow();
    }//GEN-LAST:event_tf_nombre_padrinoActionPerformed

    private void tf_nombre_madrinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_nombre_madrinaActionPerformed
        tf_lugar_naci.requestFocusInWindow();
    }//GEN-LAST:event_tf_nombre_madrinaActionPerformed

    private void tf_lugar_naciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_lugar_naciActionPerformed
        tf_fecha_naci.requestFocusInWindow();
    }//GEN-LAST:event_tf_lugar_naciActionPerformed

    private void tf_fecha_naciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_fecha_naciActionPerformed
        tf_lugar_bautizo.requestFocusInWindow();
    }//GEN-LAST:event_tf_fecha_naciActionPerformed

    private void txt_nombre_consActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombre_consActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombre_consActionPerformed

    private void tf_lugar_bautizoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_lugar_bautizoActionPerformed
        tf_ministro.requestFocusInWindow();
    }//GEN-LAST:event_tf_lugar_bautizoActionPerformed

    private void txt_id_confirmadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_confirmadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_confirmadoActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:            
    }//GEN-LAST:event_jButton1MouseClicked

    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed
        // TODO add your handling code here:
     Connection ct = null;   
     PreparedStatement pst = null; 
     try
      { 
        // Validacion de datos
        boolean bo = valida_datos();
        if (!bo)  {
            JOptionPane.showMessageDialog(null, "Ustede debe llenar todos los datos Obligatorios ");
            return ; }  
          
          
        String sql = " update confirmaciones " + 
                     " set nombre_confirmado = ?, " + 
                         " nombre_papa = ?, " +
                         " nombre_mama = ?, " +
                         " nombre_padrino = ?, " +
                         " nombre_madrina = ?, " + 
                         " lugar_nacimiento = ?, " +
                         " fecha_nacimiento = ?, " + 
                         " lugar_bautizo = ?, " + 
                         " nombre_ministro = ?, " +
                         " fecha_confirmacion = ?, " +
                         " rp_libro = ?, rp_pagina = ?, rp_numero = ?, novedades = ? " + 
                         " where id_confirma = ? ";
        ct = obtiene_conexion();
        pst = ct.prepareStatement(sql);
        
        //String auto = tf_autoridad.getText();
        
        pst.setString(1, tf_nombre_confirmado.getText());
        pst.setString(2, tf_nombre_papa.getText());
        pst.setString(3, tf_nombre_mama.getText() );
        pst.setString(4, tf_nombre_padrino.getText() );
        pst.setString(5, tf_nombre_madrina.getText() );
        pst.setString(6, tf_lugar_naci.getText() );
        
        // campo fecha nacimiento
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date myDate = formatter.parse( tf_fecha_naci.getText() );
        java.sql.Date datoFechaNacimiento = new java.sql.Date(myDate.getTime());            
        pst.setDate(7, datoFechaNacimiento );
        
        pst.setString(8, tf_lugar_bautizo.getText() );
        pst.setString(9, tf_ministro.getText());
       
        // campo fecha confirmacion
        myDate = formatter.parse( tf_fecha_confirma.getText() );
        java.sql.Date datoFechaConfirma = new java.sql.Date(myDate.getTime());            
        pst.setDate(10, datoFechaConfirma );
        
        
        pst.setString(11, tf_rp_libro.getText() );
        pst.setString(12, tf_rp_pagina.getText() );
        pst.setString(13, tf_rp_numero.getText() );
        pst.setString( 14, tf_novedades.getText() );
        
        pst.setInt(15, Integer.parseInt( txt_id_confirmado.getText() ) );
        
        System.out.println("paso 4");
        System.out.println(sql);

        
        
        
        // Actualizacion en Base 
        int res = pst.executeUpdate();
        if (res>0){
          System.out.println("Actualizacion realizada con exito");
          JOptionPane.showMessageDialog(this, "Registro se actualizó con exito");  }
        else 
          JOptionPane.showMessageDialog(this, "No se actualizó el registro con los cambios");  
        
        
        limpiar_datos();
        // consulta_datos();
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

    private void tf_ministroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ministroActionPerformed
        tf_fecha_confirma.requestFocusInWindow();
    }//GEN-LAST:event_tf_ministroActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       consulta_datos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        limpiar_datos();
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tf_nombre_mamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_nombre_mamaActionPerformed
        tf_nombre_padrino.requestFocusInWindow();
    }//GEN-LAST:event_tf_nombre_mamaActionPerformed

    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
            
    }//GEN-LAST:event_jButton1MousePressed

    private void tf_nombre_mamaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_nombre_mamaKeyReleased
        
    }//GEN-LAST:event_tf_nombre_mamaKeyReleased

    private void tf_lugar_bautizoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_lugar_bautizoKeyReleased
        
    }//GEN-LAST:event_tf_lugar_bautizoKeyReleased

    private void tf_fecha_confirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_fecha_confirmaActionPerformed
       tf_rp_libro.requestFocusInWindow();        
    }//GEN-LAST:event_tf_fecha_confirmaActionPerformed

    private void tf_rp_paginaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_rp_paginaActionPerformed
        tf_rp_numero.requestFocusInWindow();
    }//GEN-LAST:event_tf_rp_paginaActionPerformed

    private void tf_rp_libroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_rp_libroActionPerformed
        tf_rp_pagina.requestFocusInWindow();
    }//GEN-LAST:event_tf_rp_libroActionPerformed

    private void tf_rp_numeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_rp_numeroActionPerformed
        tf_novedades.requestFocusInWindow();
    }//GEN-LAST:event_tf_rp_numeroActionPerformed

    private void tf_fecha_naciKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_fecha_naciKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_fecha_naciKeyPressed

    private void tf_fecha_naciKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_fecha_naciKeyReleased
        if (tf_fecha_naci.getText().length() > 10){
               tf_fecha_naci.setText("");               
        }
    }//GEN-LAST:event_tf_fecha_naciKeyReleased

    private void tf_fecha_confirmaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_fecha_confirmaKeyReleased
        if (tf_fecha_confirma.getText().length() > 10){
               tf_fecha_confirma.setText("");
               
        }
    }//GEN-LAST:event_tf_fecha_confirmaKeyReleased

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
            java.util.logging.Logger.getLogger(gui_Confirma_Modificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gui_Confirma_Modificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gui_Confirma_Modificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gui_Confirma_Modificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gui_Confirma_Modificacion().setVisible(true);
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
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JTextField tf_fecha_confirma;
    private javax.swing.JTextField tf_fecha_naci;
    private javax.swing.JTextField tf_lugar_bautizo;
    private javax.swing.JTextField tf_lugar_naci;
    private javax.swing.JTextField tf_ministro;
    private javax.swing.JTextField tf_nombre_confirmado;
    private javax.swing.JTextField tf_nombre_madrina;
    private javax.swing.JTextField tf_nombre_mama;
    private javax.swing.JTextField tf_nombre_padrino;
    private javax.swing.JTextField tf_nombre_papa;
    private javax.swing.JTextArea tf_novedades;
    private javax.swing.JTextField tf_rp_libro;
    private javax.swing.JTextField tf_rp_numero;
    private javax.swing.JTextField tf_rp_pagina;
    private javax.swing.JTextField txt_id_confirmado;
    private javax.swing.JTextField txt_nombre_cons;
    // End of variables declaration//GEN-END:variables
}
