/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.matrimonios;

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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JTextField;

/**
 *
 * @author SONY
 */
public class gui_Matri_Modificacion extends javax.swing.JFrame {

    /**
     * Creates new form gui_modifica_bautizos
     */
    public gui_Matri_Modificacion() {
        initComponents();
        this.setLocationRelativeTo(null);
        //this.setSize(500, 1000);
    }
    public void setea_Fecha_actual(JTextField campo){ 
         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
         campo.setText( dtf.format(LocalDateTime.now()) );
    }
    public boolean valida_datos(){    
      if (tf_fecha_matri.getText().isEmpty() || 
          tf_sacerdote.getText().isEmpty() || tf_novio.getText().isEmpty() || tf_novia.getText().isEmpty() ||
          tf_testigos.getText().isEmpty()  
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
        txt_nombre_consulta.setText("");
        tf_id_matri.setText("");
        tf_fecha_matri.setText("");
        tf_sacerdote.setText("");
        tf_proclamas.setText("");
        tf_novio.setText("");
        tf_papa_novio.setText("");
        tf_mama_novio.setText("");
        tf_novia.setText("");
        tf_papa_novia.setText("");
        tf_mama_novia.setText("");
        tf_testigos.setText("");
        tf_rc_lugar.setText("");
        tf_rc_año.setText("");
        tf_rc_tomo.setText("");
        tf_rc_acta.setText("");
   
        tf_rp_folio.setText("");
        tf_rp_numero.setText("");
        tf_rp_libro.setText("");
        tf_nota.setText("");
        tf_hijos.setText("");
        tf_novedades.setText("");
    }
    
    public void consulta_datos(){
      
      String sql = "select * from matrimonios where trim(nombre_novio) = ? ";
      Connection ct = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      DateFormat dateFormat = null;
      String strDate = null;
      
      try {
        ct = obtiene_conexion();
        pstmt = ct.prepareStatement(sql);
        pstmt.setString(1, txt_nombre_consulta.getText().trim() );
        rs = pstmt.executeQuery();
        
        //System.out.println("paso 1");
        
        while ( rs.next() ){
            
            tf_id_matri.setText( String.valueOf(rs.getInt("id_matri")) );
            // Fecha Matrimonio
            dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
            strDate = dateFormat.format(rs.getDate("fecha_matri") ); 
            tf_fecha_matri.setText( strDate );
            
            tf_sacerdote.setText( rs.getString("nombre_sacerdote") );
            
            tf_proclamas.setText( rs.getString("proclamas") );
            tf_novio.setText( rs.getString("nombre_novio") );    
            tf_papa_novio.setText(  rs.getString("nombre_papa_novio") );
            tf_mama_novio.setText(  rs.getString("nombre_mama_novio") );
            
            tf_novia.setText( rs.getString("nombre_novia") );    
            tf_papa_novia.setText(  rs.getString("nombre_papa_novia") );
            tf_mama_novia.setText(  rs.getString("nombre_mama_novia") );
            tf_testigos.setText(  rs.getString("nombre_testigos") );
            
            // Datos de Registro Civil
            tf_rc_lugar.setText( rs.getString("rc_lugar") ); 
            tf_rc_año.setText( rs.getString("rc_año") );
            tf_rc_tomo.setText( rs.getString("rc_tomo") ); 
            tf_rc_acta.setText( rs.getString("rc_acta") );
            // Datos de Registro Parroquial 
            tf_rp_folio.setText( rs.getString("rp_folio") );
            tf_rp_numero.setText( rs.getString("rp_numero") );
            tf_rp_libro.setText( rs.getString("rp_libro") );
            
            tf_nota.setText( rs.getString("nota_marginal"));
            tf_hijos.setText( rs.getString("legitimacion_de_hijos") );
            tf_novedades.setText( rs.getString("novedades") );
            // Fecha matrionio
            /*
            if ( rs.getDate("fecha_matri") != null){
              strDate = dateFormat.format(rs.getDate("fecha_matri") ); 
              tf_fecha_matri.setText( strDate );
            }
            */
                            
        }
      }
      catch(Exception e){
          JOptionPane.showMessageDialog(null, "Error Exception en Funcion consulta_datos " + e.getMessage());
      }
      finally{
                try {   if (ct != null) ct.close(); if (pstmt != null) pstmt.close(); if (rs != null)   rs.close();  }
                catch(SQLException sq){
                    //System.out.println("En Finally cerrando conexion en funcion obtiene_lista" + sq.getMessage() );
                    JOptionPane.showMessageDialog(null, "En Finally, en funcion consulta_datos " + sq.getMessage() );
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
        tf_fecha_matri = new javax.swing.JTextField();
        tf_id_matri = new javax.swing.JTextField();
        txt_nombre_consulta = new javax.swing.JTextField();
        actualizar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tf_novedades = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        lab20 = new javax.swing.JLabel();
        tf_rp_folio = new javax.swing.JTextField();
        lab21 = new javax.swing.JLabel();
        tf_rp_numero = new javax.swing.JTextField();
        lab22 = new javax.swing.JLabel();
        tf_rp_libro = new javax.swing.JTextField();
        lab13 = new javax.swing.JLabel();
        lab14 = new javax.swing.JLabel();
        tf_rc_lugar = new javax.swing.JTextField();
        lab15 = new javax.swing.JLabel();
        tf_rc_año = new javax.swing.JTextField();
        lab16 = new javax.swing.JLabel();
        tf_rc_tomo = new javax.swing.JTextField();
        lab17 = new javax.swing.JLabel();
        tf_rc_acta = new javax.swing.JTextField();
        lab18 = new javax.swing.JLabel();
        tf_nota = new javax.swing.JTextField();
        tf_hijos = new javax.swing.JTextField();
        lab19 = new javax.swing.JLabel();
        tf_sacerdote = new javax.swing.JTextField();
        tf_proclamas = new javax.swing.JTextField();
        tf_novio = new javax.swing.JTextField();
        tf_papa_novio = new javax.swing.JTextField();
        tf_mama_novio = new javax.swing.JTextField();
        tf_novia = new javax.swing.JTextField();
        tf_papa_novia = new javax.swing.JTextField();
        tf_mama_novia = new javax.swing.JTextField();
        tf_testigos = new javax.swing.JTextField();
        lab23 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Modificación de datos de Matrimonio");
        setAlwaysOnTop(true);
        setPreferredSize(new java.awt.Dimension(720, 720));
        setSize(new java.awt.Dimension(720, 720));

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
        jLabel2.setText("Fecha");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 204));
        jLabel3.setText("Nombre Sacerdote");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 204));
        jLabel4.setText("Proclamas");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 204));
        jLabel5.setText("Nombre Novio");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 204));
        jLabel6.setText("Nombre Papa Novio");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 204));
        jLabel7.setText("Nombre Mama Novio");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 204));
        jLabel8.setText("Nombre Novia");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 204));
        jLabel9.setText("Nombre Papa Novia");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 204));
        jLabel10.setText("Nombre Mama Novia");

        tf_fecha_matri.setToolTipText("Ingrese el nombre del bautizado");
        tf_fecha_matri.setName(""); // NOI18N
        tf_fecha_matri.setPreferredSize(new java.awt.Dimension(6, 23));
        tf_fecha_matri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_fecha_matriActionPerformed(evt);
            }
        });

        tf_id_matri.setEditable(false);
        tf_id_matri.setToolTipText("Ingrese el nombre del bautizado");
        tf_id_matri.setName(""); // NOI18N
        tf_id_matri.setPreferredSize(new java.awt.Dimension(6, 23));
        tf_id_matri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_id_matriActionPerformed(evt);
            }
        });

        txt_nombre_consulta.setToolTipText("Ingrese el nombre del bautizado");
        txt_nombre_consulta.setName(""); // NOI18N
        txt_nombre_consulta.setPreferredSize(new java.awt.Dimension(6, 23));
        txt_nombre_consulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombre_consultaActionPerformed(evt);
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

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 204));
        jLabel23.setText("Novedades");

        tf_novedades.setColumns(20);
        tf_novedades.setRows(5);
        jScrollPane1.setViewportView(tf_novedades);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 204));
        jLabel13.setText("NombreTestigos");

        lab20.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lab20.setForeground(new java.awt.Color(0, 0, 204));
        lab20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lab20.setText("Numero");

        tf_rp_folio.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tf_rp_folio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_rp_folioActionPerformed(evt);
            }
        });

        lab21.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lab21.setForeground(new java.awt.Color(0, 0, 204));
        lab21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lab21.setText("Folio/Pagina");

        tf_rp_numero.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tf_rp_numero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_rp_numeroActionPerformed(evt);
            }
        });

        lab22.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lab22.setForeground(new java.awt.Color(0, 0, 204));
        lab22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lab22.setText("Libro");

        tf_rp_libro.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tf_rp_libro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_rp_libroActionPerformed(evt);
            }
        });

        lab13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lab13.setForeground(new java.awt.Color(0, 0, 204));
        lab13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lab13.setText("Registro Civil");

        lab14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lab14.setForeground(new java.awt.Color(0, 0, 204));
        lab14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lab14.setText("Lugar");

        tf_rc_lugar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tf_rc_lugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_rc_lugarActionPerformed(evt);
            }
        });

        lab15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lab15.setForeground(new java.awt.Color(0, 0, 204));
        lab15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lab15.setText("Año");

        tf_rc_año.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tf_rc_año.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_rc_añoActionPerformed(evt);
            }
        });
        tf_rc_año.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_rc_añoKeyReleased(evt);
            }
        });

        lab16.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lab16.setForeground(new java.awt.Color(0, 0, 204));
        lab16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lab16.setText("Tomo");

        tf_rc_tomo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tf_rc_tomo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_rc_tomoActionPerformed(evt);
            }
        });

        lab17.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lab17.setForeground(new java.awt.Color(0, 0, 204));
        lab17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lab17.setText("Acta");

        tf_rc_acta.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tf_rc_acta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_rc_actaActionPerformed(evt);
            }
        });

        lab18.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lab18.setForeground(new java.awt.Color(0, 0, 204));
        lab18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lab18.setText("Nota Marginal");

        tf_nota.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tf_nota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_notaActionPerformed(evt);
            }
        });

        tf_hijos.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tf_hijos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_hijosActionPerformed(evt);
            }
        });

        lab19.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lab19.setForeground(new java.awt.Color(0, 0, 204));
        lab19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lab19.setText("Legitimacion de Hijos");

        tf_sacerdote.setToolTipText("Ingrese el nombre del bautizado");
        tf_sacerdote.setName(""); // NOI18N
        tf_sacerdote.setPreferredSize(new java.awt.Dimension(6, 23));
        tf_sacerdote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_sacerdoteActionPerformed(evt);
            }
        });

        tf_proclamas.setToolTipText("Ingrese el nombre del bautizado");
        tf_proclamas.setName(""); // NOI18N
        tf_proclamas.setPreferredSize(new java.awt.Dimension(6, 23));
        tf_proclamas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_proclamasActionPerformed(evt);
            }
        });

        tf_novio.setToolTipText("Ingrese el nombre del bautizado");
        tf_novio.setName(""); // NOI18N
        tf_novio.setPreferredSize(new java.awt.Dimension(6, 23));
        tf_novio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_novioActionPerformed(evt);
            }
        });

        tf_papa_novio.setToolTipText("Ingrese el nombre del bautizado");
        tf_papa_novio.setName(""); // NOI18N
        tf_papa_novio.setPreferredSize(new java.awt.Dimension(6, 23));
        tf_papa_novio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_papa_novioActionPerformed(evt);
            }
        });

        tf_mama_novio.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tf_mama_novio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_mama_novioActionPerformed(evt);
            }
        });

        tf_novia.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tf_novia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_noviaActionPerformed(evt);
            }
        });

        tf_papa_novia.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tf_papa_novia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_papa_noviaActionPerformed(evt);
            }
        });

        tf_mama_novia.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tf_mama_novia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_mama_noviaActionPerformed(evt);
            }
        });

        tf_testigos.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tf_testigos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_testigosActionPerformed(evt);
            }
        });

        lab23.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lab23.setForeground(new java.awt.Color(0, 0, 204));
        lab23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lab23.setText("Registro Parroquial");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_fecha_matri, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_sacerdote, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tf_proclamas, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tf_novio, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tf_id_matri, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(tf_papa_novio, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tf_papa_novia)
                                        .addComponent(tf_novia))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_mama_novio, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(tf_testigos, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tf_mama_novia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE))))
                            .addComponent(lab23, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lab18, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lab19, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel23))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(actualizar)
                                        .addGap(16, 16, 16)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tf_hijos)
                                    .addComponent(tf_nota, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(170, 170, 170)
                                .addComponent(lab21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tf_rp_folio, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lab20, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_rp_numero, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lab22, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tf_rp_libro, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_nombre_consulta, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lab13, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lab14, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(39, 39, 39)
                                        .addComponent(tf_rc_lugar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lab15, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(9, 9, 9)
                                .addComponent(tf_rc_año, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lab16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tf_rc_tomo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lab17, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addComponent(tf_rc_acta, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(248, 248, 248))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1)
                    .addComponent(txt_nombre_consulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(tf_id_matri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_fecha_matri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tf_sacerdote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tf_proclamas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tf_novio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tf_papa_novio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tf_mama_novio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tf_novia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tf_papa_novia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tf_mama_novia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(tf_testigos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lab13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lab14)
                    .addComponent(tf_rc_lugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lab15)
                    .addComponent(tf_rc_año, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lab16)
                    .addComponent(tf_rc_tomo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lab17)
                    .addComponent(tf_rc_acta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(lab23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lab20)
                    .addComponent(lab22)
                    .addComponent(tf_rp_libro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_rp_numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lab21)
                    .addComponent(tf_rp_folio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lab18)
                    .addComponent(tf_nota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lab19)
                    .addComponent(tf_hijos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(actualizar)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(65, 65, 65))
        );

        actualizar.getAccessibleContext().setAccessibleName("actualizar");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_fecha_matriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_fecha_matriActionPerformed
        tf_sacerdote.requestFocusInWindow();
    }//GEN-LAST:event_tf_fecha_matriActionPerformed

    private void txt_nombre_consultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombre_consultaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombre_consultaActionPerformed

    private void tf_id_matriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_id_matriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_id_matriActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:            
    }//GEN-LAST:event_jButton1MouseClicked

    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed
        // TODO add your handling code here:
     Connection ct = null;   
     PreparedStatement pst = null;
     
     // Validacion de datos Obligatorios, antes de intentar Actualizar 
     boolean bo = valida_datos(); 
        if (!bo)  { 
            JOptionPane.showMessageDialog(null, "Usted debe llenar todos los datos Obligatorios ");
            return ; }
     
     
     try
      { 
        String sql = " update matrimonios " + 
                     " set fecha_matri = ?, " +         // 1
                         " nombre_sacerdote = ?, " +    // 2
                         " proclamas = ?, " +           // 3 
                         " nombre_novio = ?, " +        // 4 
                         " nombre_papa_novio = ?, " +   // 5 
                         " nombre_mama_novio = ?, " +   // 6
                         " nombre_novia = ?, " +        // 7
                         " nombre_papa_novia = ?, " +   // 8
                         " nombre_mama_novia = ?, " +   // 9
                         " nombre_testigos = ?, " +     // 10             
                         " rc_lugar = ?, rc_año = ?, rc_tomo = ?, rc_acta = ?, " +  // 11, 12, 13, 14  
                         " nota_marginal = ?, legitimacion_de_hijos = ?, " +       // 15, 16 
                         " rp_folio = ?, rp_numero = ?, rp_libro = ?, novedades = ? " + // 17, 18, 19, 20  
                         " where id_matri = ? "; // 21
        ct = obtiene_conexion();
        pst = ct.prepareStatement(sql);
        
        // campo Fecha Matrimonio
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date myDate = formatter.parse( tf_fecha_matri.getText() );  // 1
        java.sql.Date datoFechaMatrimonio = new java.sql.Date(myDate.getTime());            
        pst.setDate(1, datoFechaMatrimonio );        
        pst.setString(2, tf_sacerdote.getText());       // 2
        pst.setString(3, tf_proclamas.getText());       // 3 
        pst.setString(4, tf_novio.getText() );          // 4  
        pst.setString(5, tf_papa_novio.getText() );     // 5 
        pst.setString(6, tf_mama_novio.getText() );     // 6
        pst.setString(7, tf_novia.getText() );          // 7     
        pst.setString(8, tf_papa_novia.getText());      // 8
        pst.setString(9, tf_mama_novia.getText());      // 9
        pst.setString(10, tf_testigos.getText());       // 10 
        pst.setString(11, tf_rc_lugar.getText());       // 11
        pst.setString(12, tf_rc_año.getText());         // 12
        pst.setString(13, tf_rc_tomo.getText());        // 13
        pst.setString(14, tf_rc_acta.getText());        // 14
        pst.setString(15, tf_nota.getText());           // 15
        pst.setString(16, tf_hijos.getText());          // 16 
        pst.setString(17, tf_rp_folio.getText());       // 17
        pst.setString(18, tf_rp_numero.getText() );     // 18
        pst.setString(19, tf_rp_libro.getText() );      // 19
        pst.setString(20, tf_novedades.getText() );     // 20
        // campo fecha
        /*
        if ( ! tf_fecha_matri.getText().isEmpty() ) { 
          myDate = formatter.parse( tf_fecha_matri.getText() );
          java.sql.Date datoFechaMatrimonio = new java.sql.Date(myDate.getTime());            
          pst.setDate(1, datoFechaMatrimonio );
        }
        else
            pst.setNull(1, java.sql.Types.DATE);
        */ 
        pst.setInt(21, Integer.parseInt( tf_id_matri.getText() ) ); // 21
        
        System.out.println("paso 4");
        
        System.out.println(sql);
        int res = pst.executeUpdate();
        if (res>0){
          System.out.println("Actualización realizada con exito");
          JOptionPane.showMessageDialog(this, "Registro se actualizó con exito");  }
        else 
          JOptionPane.showMessageDialog(this, "No se actualizó el registro con los cambios");  
        
        
        limpiar_datos();
        
      }
      catch(Exception e){
          JOptionPane.showMessageDialog(null, "Error Exception en Boton Actualizar " + e.getMessage());
      }
      finally{
                try { 
                    if (ct != null) ct.close(); if (pst != null) pst.close();
                }
                catch(SQLException sq){
                    System.out.println("En Finally en boton Actualizar" + sq.getMessage() );
                    JOptionPane.showMessageDialog(null, "En Finally en boton Actualizar" + sq.getMessage() );
                }
      }
        
    }//GEN-LAST:event_actualizarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       consulta_datos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        limpiar_datos();
        
    }//GEN-LAST:event_jButton3ActionPerformed

    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed

                
    }//GEN-LAST:event_jButton1MousePressed

    private void tf_rp_folioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_rp_folioActionPerformed
        tf_rp_numero.requestFocusInWindow();
    }//GEN-LAST:event_tf_rp_folioActionPerformed

    private void tf_rp_numeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_rp_numeroActionPerformed
        tf_rp_libro.requestFocusInWindow();
    }//GEN-LAST:event_tf_rp_numeroActionPerformed

    private void tf_rp_libroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_rp_libroActionPerformed
        tf_nota.requestFocusInWindow();
    }//GEN-LAST:event_tf_rp_libroActionPerformed

    private void tf_rc_lugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_rc_lugarActionPerformed
        tf_rc_año.requestFocusInWindow();
    }//GEN-LAST:event_tf_rc_lugarActionPerformed

    private void tf_rc_añoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_rc_añoActionPerformed
        tf_rc_tomo.requestFocusInWindow();
    }//GEN-LAST:event_tf_rc_añoActionPerformed

    private void tf_rc_añoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_rc_añoKeyReleased
        if (tf_rc_año.getText().length() > 4) {
            tf_rc_año.setText("");

        }
    }//GEN-LAST:event_tf_rc_añoKeyReleased

    private void tf_rc_tomoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_rc_tomoActionPerformed
        tf_rc_acta.requestFocusInWindow();
    }//GEN-LAST:event_tf_rc_tomoActionPerformed

    private void tf_rc_actaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_rc_actaActionPerformed
        tf_rp_folio.requestFocusInWindow();
    }//GEN-LAST:event_tf_rc_actaActionPerformed

    private void tf_notaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_notaActionPerformed
        tf_hijos.requestFocusInWindow();
    }//GEN-LAST:event_tf_notaActionPerformed

    private void tf_hijosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_hijosActionPerformed
        tf_novedades.requestFocusInWindow();
    }//GEN-LAST:event_tf_hijosActionPerformed

    private void tf_sacerdoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_sacerdoteActionPerformed
        tf_proclamas.requestFocusInWindow();
    }//GEN-LAST:event_tf_sacerdoteActionPerformed

    private void tf_proclamasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_proclamasActionPerformed
        tf_novio.requestFocusInWindow();
    }//GEN-LAST:event_tf_proclamasActionPerformed

    private void tf_novioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_novioActionPerformed
        tf_papa_novio.requestFocusInWindow();
    }//GEN-LAST:event_tf_novioActionPerformed

    private void tf_papa_novioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_papa_novioActionPerformed
        tf_mama_novio.requestFocusInWindow();
    }//GEN-LAST:event_tf_papa_novioActionPerformed

    private void tf_mama_novioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_mama_novioActionPerformed
        tf_novia.requestFocusInWindow();
    }//GEN-LAST:event_tf_mama_novioActionPerformed

    private void tf_noviaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_noviaActionPerformed
        tf_papa_novia.requestFocusInWindow();
    }//GEN-LAST:event_tf_noviaActionPerformed

    private void tf_papa_noviaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_papa_noviaActionPerformed
        tf_mama_novia.requestFocusInWindow();
    }//GEN-LAST:event_tf_papa_noviaActionPerformed

    private void tf_mama_noviaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_mama_noviaActionPerformed
        tf_testigos.requestFocusInWindow();
    }//GEN-LAST:event_tf_mama_noviaActionPerformed

    private void tf_testigosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_testigosActionPerformed
        tf_rc_lugar.requestFocusInWindow();
    }//GEN-LAST:event_tf_testigosActionPerformed

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
            java.util.logging.Logger.getLogger(gui_Matri_Modificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gui_Matri_Modificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gui_Matri_Modificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gui_Matri_Modificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gui_Matri_Modificacion().setVisible(true);
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
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lab13;
    private javax.swing.JLabel lab14;
    private javax.swing.JLabel lab15;
    private javax.swing.JLabel lab16;
    private javax.swing.JLabel lab17;
    private javax.swing.JLabel lab18;
    private javax.swing.JLabel lab19;
    private javax.swing.JLabel lab20;
    private javax.swing.JLabel lab21;
    private javax.swing.JLabel lab22;
    private javax.swing.JLabel lab23;
    private javax.swing.JTextField tf_fecha_matri;
    private javax.swing.JTextField tf_hijos;
    private javax.swing.JTextField tf_id_matri;
    private javax.swing.JTextField tf_mama_novia;
    private javax.swing.JTextField tf_mama_novio;
    private javax.swing.JTextField tf_nota;
    private javax.swing.JTextArea tf_novedades;
    private javax.swing.JTextField tf_novia;
    private javax.swing.JTextField tf_novio;
    private javax.swing.JTextField tf_papa_novia;
    private javax.swing.JTextField tf_papa_novio;
    private javax.swing.JTextField tf_proclamas;
    private javax.swing.JTextField tf_rc_acta;
    private javax.swing.JTextField tf_rc_año;
    private javax.swing.JTextField tf_rc_lugar;
    private javax.swing.JTextField tf_rc_tomo;
    private javax.swing.JTextField tf_rp_folio;
    private javax.swing.JTextField tf_rp_libro;
    private javax.swing.JTextField tf_rp_numero;
    private javax.swing.JTextField tf_sacerdote;
    private javax.swing.JTextField tf_testigos;
    private javax.swing.JTextField txt_nombre_consulta;
    // End of variables declaration//GEN-END:variables
}
