// Camnbio: Se agrego Lista de Autoridades para el campo Sacerdote
//          Se agrego el campo Novedades
//          El campo numero de Registro Parroquial mostrara la secuencia que le toca
// Fecha: 06/09/2022

package com.iglesia.bautizos;

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author pnsde
 */
public class gui_Frame extends javax.swing.JFrame {

    /**
     * Creates new form guiFrame
     */
    public gui_Frame() {
        initComponents();
        llena_combo();
        obtiene_ultimo_rpNumero();

        //Campos con valores por default
        tflugarNacimiento.setText("Guayaquil");
        tfnombreSacerdote.setText("P. DIEGO AUGUSTO VARGAS GARCIA, CJM");
        setea_Fecha_actual(tffechaBautizo);
        setea_Fecha_actual(tffechaNacimiento);
        setea_Fecha_actual(tf_rc_fecha);
        //lis_autoridad = new javax.swing.JComboBox<>();
        this.setLocationRelativeTo(null);
    }
    public void setea_Fecha_actual(JTextField campo){ 
         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
         campo.setText( dtf.format(LocalDateTime.now()) );
    }
    public void llena_combo(){
      Connection cnt = null;    
      Statement stm = null;
      ResultSet rs = null;
      try
        {    
            cnt = obtiene_conexion();
            stm = cnt.createStatement();
            String sql = "select * from opciones_autoridades";
            rs = stm.executeQuery(sql);
            while ( rs.next() ){
              String str =  rs.getString("nom_opc_autoridad");
              lis_autoridad.removeAll();
              lis_autoridad.addItem(str);
            }
      
        }
        catch(SQLException e) {
                //System.out.println("error tipo SQLException " + e.getMessage() );
                JOptionPane.showMessageDialog(null, "Error SQLException en funcion llena_combo " + e.getMessage());
        }
        catch(Exception e){
                //System.out.println("error tipo Exception " + e.getMessage() );
                JOptionPane.showMessageDialog(null, "Error Exception en funcion llena_combo " + e.getMessage());
        } 
        finally{
                try {   if (cnt != null)   cnt.close();  
                        if (stm != null)   stm.close();
                        if (rs != null)    rs.close(); }
                catch(SQLException sq){
                    //System.out.println("En Finally cerrando conexion en funcion llena_combo" + sq.getMessage() );
                    JOptionPane.showMessageDialog(null, "En Finally, en funcion llena_combo " + sq.getMessage() );
                }
        }
    }
    public void obtiene_ultimo_rpNumero(){
      Connection cnt = null;    
      Statement stm = null;
      ResultSet rs = null;
      try
        {    
            cnt = obtiene_conexion();
            stm = cnt.createStatement();
            // CAST(rp_numero AS UNSIGNED
            String sql = " select ( max( CAST(rp_numero AS UNSIGNED) ) + 1 ) as valor from bautizos where rp_libro = 'II' ";
            rs = stm.executeQuery(sql);
            while ( rs.next() ){
              //int num =  Integer.parseInt( rs.getString("rp_numero") );
              int num =  rs.getInt("valor");              
              //JOptionPane.showMessageDialog(null, "Numero = " + num);
              tf_rp_numero.setText( Integer.toString(num) );
            }
      
        }
        catch(SQLException e) {
                //System.out.println("error tipo SQLException " + e.getMessage() );
                JOptionPane.showMessageDialog(null, "Error SQLException en funcion obtiene_ultimo_rpNumero " + e.getMessage());
        }
        catch(Exception e){
                //System.out.println("error tipo Exception " + e.getMessage() );
                JOptionPane.showMessageDialog(null, "Error Exception en funcion obtiene_ultimo_rpNumero " + e.getMessage());
        } 
        finally{
                try {   if (cnt != null)   cnt.close();  
                        if (stm != null)   stm.close();
                        if (rs != null)    rs.close(); }
                catch(SQLException sq){
                    //System.out.println("En Finally cerrando conexion en funcion llena_combo" + sq.getMessage() );
                    JOptionPane.showMessageDialog(null, "En Finally, en obtiene_ultimo_rpNumero " + sq.getMessage() );
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

        jButton1 = new javax.swing.JButton();
        lab1 = new javax.swing.JLabel();
        tfnombreBautizado = new javax.swing.JTextField();
        lab3 = new javax.swing.JLabel();
        tffechaBautizo = new javax.swing.JTextField();
        lab4 = new javax.swing.JLabel();
        tfnombreSacerdote = new javax.swing.JTextField();
        lab5 = new javax.swing.JLabel();
        tflugarNacimiento = new javax.swing.JTextField();
        lab6 = new javax.swing.JLabel();
        tffechaNacimiento = new javax.swing.JTextField();
        lab7 = new javax.swing.JLabel();
        tfnombrePapa = new javax.swing.JTextField();
        lab8 = new javax.swing.JLabel();
        tfnombreMama = new javax.swing.JTextField();
        lab9 = new javax.swing.JLabel();
        tfnombrePadrino = new javax.swing.JTextField();
        lab10 = new javax.swing.JLabel();
        tfnombreMadrina = new javax.swing.JTextField();
        lab_rc = new javax.swing.JLabel();
        lab_rc1 = new javax.swing.JLabel();
        tf_rc_anio = new javax.swing.JTextField();
        lab_rc2 = new javax.swing.JLabel();
        tf_rc_tomo = new javax.swing.JTextField();
        lab_rc3 = new javax.swing.JLabel();
        tf_rc_folio = new javax.swing.JTextField();
        lab_rc4 = new javax.swing.JLabel();
        tf_rc_acta = new javax.swing.JTextField();
        lab_rc5 = new javax.swing.JLabel();
        tf_rc_fecha = new javax.swing.JTextField();
        lab_rc6 = new javax.swing.JLabel();
        tf_rc_numIns = new javax.swing.JTextField();
        lab_rc7 = new javax.swing.JLabel();
        lab_rp1 = new javax.swing.JLabel();
        lab_rp2 = new javax.swing.JLabel();
        lab_rp10 = new javax.swing.JLabel();
        tf_rp_libro = new javax.swing.JTextField();
        tf_rp_pagina = new javax.swing.JTextField();
        tf_rp_numero = new javax.swing.JTextField();
        lis_autoridad = new javax.swing.JComboBox<>();
        lab_rp11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tfnovedades = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setTitle("Ingreso de Datos de Bautizo");
        setPreferredSize(new java.awt.Dimension(650, 760));
        setSize(new java.awt.Dimension(650, 760));

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 255));
        jButton1.setText("Salir");
        jButton1.setPreferredSize(new java.awt.Dimension(85, 25));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lab1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lab1.setForeground(new java.awt.Color(0, 0, 204));
        lab1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lab1.setText("Nombre Bautizado");

        tfnombreBautizado.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tfnombreBautizado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfnombreBautizadoActionPerformed(evt);
            }
        });

        lab3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lab3.setForeground(new java.awt.Color(0, 0, 204));
        lab3.setText("Fecha Bautizo");

        tffechaBautizo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tffechaBautizo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tffechaBautizoActionPerformed(evt);
            }
        });
        tffechaBautizo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tffechaBautizoKeyReleased(evt);
            }
        });

        lab4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lab4.setForeground(new java.awt.Color(0, 0, 204));
        lab4.setText("Nombre Sacerdote");

        tfnombreSacerdote.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tfnombreSacerdote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfnombreSacerdoteActionPerformed(evt);
            }
        });

        lab5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lab5.setForeground(new java.awt.Color(0, 0, 204));
        lab5.setText("Lugar Nacimiento");

        tflugarNacimiento.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tflugarNacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tflugarNacimientoActionPerformed(evt);
            }
        });

        lab6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lab6.setForeground(new java.awt.Color(0, 0, 204));
        lab6.setText("Fecha Nacimiento");

        tffechaNacimiento.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tffechaNacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tffechaNacimientoActionPerformed(evt);
            }
        });
        tffechaNacimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tffechaNacimientoKeyReleased(evt);
            }
        });

        lab7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lab7.setForeground(new java.awt.Color(0, 0, 204));
        lab7.setText("Nombre Papa");

        tfnombrePapa.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tfnombrePapa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfnombrePapaActionPerformed(evt);
            }
        });

        lab8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lab8.setForeground(new java.awt.Color(0, 0, 204));
        lab8.setText("Nombre Mama");

        tfnombreMama.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tfnombreMama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfnombreMamaActionPerformed(evt);
            }
        });

        lab9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lab9.setForeground(new java.awt.Color(0, 0, 204));
        lab9.setText("Nombre Padrino");

        tfnombrePadrino.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tfnombrePadrino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfnombrePadrinoActionPerformed(evt);
            }
        });

        lab10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lab10.setForeground(new java.awt.Color(0, 0, 204));
        lab10.setText("Nombre Madrina");

        tfnombreMadrina.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tfnombreMadrina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfnombreMadrinaActionPerformed(evt);
            }
        });

        lab_rc.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lab_rc.setForeground(new java.awt.Color(0, 0, 204));
        lab_rc.setText("Registro Civil");

        lab_rc1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lab_rc1.setForeground(new java.awt.Color(0, 0, 204));
        lab_rc1.setText("Año");

        tf_rc_anio.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tf_rc_anio.setPreferredSize(new java.awt.Dimension(4, 23));
        tf_rc_anio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_rc_anioActionPerformed(evt);
            }
        });
        tf_rc_anio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_rc_anioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_rc_anioKeyReleased(evt);
            }
        });

        lab_rc2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lab_rc2.setForeground(new java.awt.Color(0, 0, 204));
        lab_rc2.setText("Tomo");

        tf_rc_tomo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tf_rc_tomo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_rc_tomoActionPerformed(evt);
            }
        });

        lab_rc3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lab_rc3.setForeground(new java.awt.Color(0, 0, 204));
        lab_rc3.setText("Folio");

        tf_rc_folio.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tf_rc_folio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_rc_folioActionPerformed(evt);
            }
        });

        lab_rc4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lab_rc4.setForeground(new java.awt.Color(0, 0, 204));
        lab_rc4.setText("Acta");

        tf_rc_acta.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tf_rc_acta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_rc_actaActionPerformed(evt);
            }
        });

        lab_rc5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lab_rc5.setForeground(new java.awt.Color(0, 0, 204));
        lab_rc5.setText("Fecha");

        tf_rc_fecha.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tf_rc_fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_rc_fechaActionPerformed(evt);
            }
        });
        tf_rc_fecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_rc_fechaKeyReleased(evt);
            }
        });

        lab_rc6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lab_rc6.setForeground(new java.awt.Color(0, 0, 204));
        lab_rc6.setText("# Inscripcion");

        tf_rc_numIns.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tf_rc_numIns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_rc_numInsActionPerformed(evt);
            }
        });

        lab_rc7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lab_rc7.setForeground(new java.awt.Color(0, 0, 204));
        lab_rc7.setText("Registro Parroquial");

        lab_rp1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lab_rp1.setForeground(new java.awt.Color(0, 0, 204));
        lab_rp1.setText("Libro");

        lab_rp2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lab_rp2.setForeground(new java.awt.Color(0, 0, 204));
        lab_rp2.setText("Pagina");

        lab_rp10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lab_rp10.setForeground(new java.awt.Color(0, 0, 204));
        lab_rp10.setText("Numero");

        tf_rp_libro.setText("||");
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

        lis_autoridad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lis_autoridadActionPerformed(evt);
            }
        });

        lab_rp11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lab_rp11.setForeground(new java.awt.Color(0, 0, 204));
        lab_rp11.setText("Novedades");

        tfnovedades.setColumns(20);
        tfnovedades.setRows(5);
        tfnovedades.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfnovedadesFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(tfnovedades);

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 255));
        jButton2.setText("Ingresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lab_rp11, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 808, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lab_rc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lab9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tfnombreMadrina, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(135, 135, 135))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lab_rc7, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lab_rp10, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(341, 341, 341)
                                .addComponent(tf_rp_pagina, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lab_rp1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(tf_rp_libro, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                            .addComponent(tf_rp_numero))
                                        .addGap(58, 58, 58)
                                        .addComponent(lab_rp2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lab7, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lab10, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(tfnombrePadrino, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lab8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(tfnombreMama))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(lab6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfnombrePapa)
                                            .addComponent(tffechaNacimiento)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(lab4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lab5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(tfnombreSacerdote, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lis_autoridad, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(tflugarNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(lab3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lab1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tffechaBautizo)
                                            .addComponent(tfnombreBautizado, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lab_rc3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(tf_rc_folio, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(58, 58, 58)
                                                .addComponent(lab_rc4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lab_rc1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lab_rc5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(31, 31, 31)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(tf_rc_fecha, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                                    .addComponent(tf_rc_anio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(58, 58, 58)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(lab_rc2, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                                                    .addComponent(lab_rc6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(tf_rc_tomo)
                                            .addComponent(tf_rc_acta)
                                            .addComponent(tf_rc_numIns, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(100, 100, 100)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(192, 192, 192)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfnombreBautizado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lab1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lab3)
                    .addComponent(tffechaBautizo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfnombreSacerdote, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lab4)
                    .addComponent(lis_autoridad, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lab5)
                    .addComponent(tflugarNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lab6)
                    .addComponent(tffechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfnombrePapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lab7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lab8)
                    .addComponent(tfnombreMama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lab9)
                    .addComponent(tfnombrePadrino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lab10)
                    .addComponent(tfnombreMadrina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lab_rc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lab_rc1)
                    .addComponent(tf_rc_anio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lab_rc2)
                    .addComponent(tf_rc_tomo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lab_rc3)
                    .addComponent(tf_rc_folio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lab_rc4)
                    .addComponent(tf_rc_acta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lab_rc6)
                    .addComponent(tf_rc_numIns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lab_rc5)
                    .addComponent(tf_rc_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lab_rc7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lab_rp1)
                    .addComponent(lab_rp2)
                    .addComponent(tf_rp_libro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_rp_pagina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lab_rp10)
                    .addComponent(tf_rp_numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lab_rp11)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addContainerGap(169, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //System.exit(0);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed
    public boolean valida_datos(){    
      if (tfnombreBautizado.getText().isEmpty() ||  
          tffechaBautizo.getText().isEmpty()    || tfnombreSacerdote.getText().isEmpty() ||
          tflugarNacimiento.getText().isEmpty() ||  tffechaNacimiento.getText().isEmpty()  )
          return false;
      else 
          return true;
    }
    public void limpiar_datos(){
      tfnombreBautizado.setText("");  tffechaBautizo.setText("");
      tfnombreSacerdote.setText(""); tflugarNacimiento.setText(""); tffechaNacimiento.setText("");
      tfnombrePapa.setText(""); tfnombreMama.setText(""); tfnombrePadrino.setText("");
      tfnombreMadrina.setText(""); tf_rc_anio.setText(""); tf_rc_tomo.setText("");
      tf_rc_folio.setText(""); tf_rc_acta.setText(""); tf_rc_fecha.setText("");
      tf_rc_numIns.setText(""); tf_rp_libro.setText(""); tf_rp_pagina.setText("");
      tf_rp_numero.setText("");
      tfnovedades.setText("");
      // mejora el 17/06/2022
      tflugarNacimiento.setText("Guayaquil");
      tfnombreSacerdote.setText("P. DIEGO AUGUSTO VARGAS GARCIA, CJM");
      setea_Fecha_actual(tffechaBautizo);
      setea_Fecha_actual(tffechaNacimiento);
      setea_Fecha_actual(tf_rc_fecha);
      obtiene_ultimo_rpNumero();

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
                System.out.println("error SQLException " + e.getMessage() );
                JOptionPane.showMessageDialog(null, "Error SqlException en Obtiene Conexion " + e.getMessage());
            }
        catch(Exception e){
                System.out.println("error Exception " + e.getMessage() );
                JOptionPane.showMessageDialog(null, "Error Exception en Obtiene Conexion" + e.getMessage() );
            } 
        return con;
        }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Boton Ingreso
        String arst[] = new String[19];
        arst[0] = tfnombreBautizado.getText(); arst[1] = tffechaBautizo.getText(); 
        arst[2] = tfnombreSacerdote.getText();  arst[3] = tflugarNacimiento.getText(); arst[4] = tffechaNacimiento.getText();
        arst[5] = tfnombrePapa.getText();  arst[6] = tfnombreMama.getText(); arst[7] = tfnombrePadrino.getText();
        arst[8] = tfnombreMadrina.getText(); arst[9] = tf_rc_anio.getText(); arst[10] = tf_rc_tomo.getText();
        arst[11] = tf_rc_folio.getText(); arst[12] = tf_rc_acta.getText(); arst[13] = tf_rc_fecha.getText();
        arst[14] = tf_rc_numIns.getText(); arst[15] = tf_rp_libro.getText(); arst[16] = tf_rp_pagina.getText();
        arst[17] = tf_rp_numero.getText();
        arst[18] = tfnovedades.getText();
        
        Connection conn= null;
        PreparedStatement pstmt = null;
        
        boolean bo = valida_datos(); 
        if (!bo)  { 
            JOptionPane.showMessageDialog(null, "Ustede debe llenar todos los datos Obligatorios ");
            return ; } 
        
        try 
        {               
            conn = obtiene_conexion();
            
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date myDate = formatter.parse(arst[1]);
            java.sql.Date datoFechaBautizo = new java.sql.Date(myDate.getTime());            
            
            myDate = formatter.parse(arst[4]);
            java.sql.Date datoFechaNacimiento = new java.sql.Date(myDate.getTime());
            
            String sql = " insert into bautizos "
                    +    " (nombre_bautizado, fecha_bautizo, nombre_sacerdote, lugar_nacimiento,"
                    +    " fecha_nacimiento, nombre_papa, nombre_mama, nombre_padrino, nombre_madrina,"
                    +    " rc_año, rc_tomo, rc_folio, rc_acta, rc_fecha, rc_num_inscripcion, "
                    +    " rp_libro, rp_pagina, rp_numero, novedades)" 
                    +    " values ( '" + arst[0] +  "', '" + datoFechaBautizo + "', '" + arst[2] + "', '" + arst[3] + "', '"  
                    +                   datoFechaNacimiento + "', '" + arst[5] + "', '" + arst[6] + "', '" + arst[7] + "', '" + arst[8] + "', '"
                    +                   arst[9] + "', '" + arst[10] + "', '" + arst[11] + "', '" + arst[12] + "' , ? , '" 
                    +                   arst[14] + "', '" + arst[15] + "', '" + arst[16] + "', '" + arst[17] + "', '" + arst[18] + "') ";  
            System.out.println("sql " + sql);        
            
            pstmt = conn.prepareStatement(sql);
            java.sql.Date dato_rc_fecha = null;
            if ( ! arst[13].isEmpty() ) {
              myDate = formatter.parse(arst[13]);
              dato_rc_fecha = new java.sql.Date(myDate.getTime());  
              pstmt.setDate(1, dato_rc_fecha);
            }
            else 
              pstmt.setNull(1, java.sql.Types.DATE);
            pstmt.executeUpdate();
            
            System.out.println("Insert completo.");
            JOptionPane.showMessageDialog(null, "Se realizo la insercion de datos correctamente");
            limpiar_datos();
            
        }
        catch(SQLException e) {                         
            System.out.println("error SQLException " + e.getMessage() );
            JOptionPane.showMessageDialog(null, "Error SQLException al insertar datos " + e.getMessage());
        }
        catch(Exception e){ 
            System.out.println("error Exception " + e.getMessage() );
            JOptionPane.showMessageDialog(null, "Error Exception al insertar datos " + e.getMessage() );
        }
        finally {
            try {
                 if (conn != null) conn.close();
                 if (pstmt != null) pstmt.close();
            }
            catch(SQLException sq){
              System.out.println("En Finally error SQLException " + sq.getMessage() );
              JOptionPane.showMessageDialog(null, "En Finally error SQLException, al cerrar la conexion " + sq.getMessage());
            }       
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tfnombreBautizadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfnombreBautizadoActionPerformed
        tffechaBautizo.requestFocusInWindow();
    }//GEN-LAST:event_tfnombreBautizadoActionPerformed

    private void tffechaBautizoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tffechaBautizoActionPerformed
        tfnombreSacerdote.requestFocusInWindow();
    }//GEN-LAST:event_tffechaBautizoActionPerformed

    private void tfnombreSacerdoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfnombreSacerdoteActionPerformed
        tflugarNacimiento.requestFocusInWindow();
    }//GEN-LAST:event_tfnombreSacerdoteActionPerformed

    private void tflugarNacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tflugarNacimientoActionPerformed
        tffechaNacimiento.requestFocusInWindow();
    }//GEN-LAST:event_tflugarNacimientoActionPerformed

    private void tffechaNacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tffechaNacimientoActionPerformed
        tfnombrePapa.requestFocusInWindow();
    }//GEN-LAST:event_tffechaNacimientoActionPerformed

    private void tfnombrePapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfnombrePapaActionPerformed
        tfnombreMama.requestFocusInWindow();
    }//GEN-LAST:event_tfnombrePapaActionPerformed

    private void tfnombreMamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfnombreMamaActionPerformed
        tfnombrePadrino.requestFocusInWindow();
    }//GEN-LAST:event_tfnombreMamaActionPerformed

    private void tfnombrePadrinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfnombrePadrinoActionPerformed
        tfnombreMadrina.requestFocusInWindow();
    }//GEN-LAST:event_tfnombrePadrinoActionPerformed

    private void tfnombreMadrinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfnombreMadrinaActionPerformed
         tf_rc_anio.requestFocusInWindow();
    }//GEN-LAST:event_tfnombreMadrinaActionPerformed

    private void tf_rc_anioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_rc_anioActionPerformed
        
        tf_rc_tomo.requestFocusInWindow();
    }//GEN-LAST:event_tf_rc_anioActionPerformed

    private void tf_rc_folioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_rc_folioActionPerformed
        tf_rc_acta.requestFocusInWindow();
    }//GEN-LAST:event_tf_rc_folioActionPerformed

    private void tf_rc_tomoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_rc_tomoActionPerformed
       tf_rc_folio.requestFocusInWindow();        
    }//GEN-LAST:event_tf_rc_tomoActionPerformed

    private void tf_rc_fechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_rc_fechaActionPerformed
        tf_rc_numIns.requestFocusInWindow();
    }//GEN-LAST:event_tf_rc_fechaActionPerformed

    private void tf_rc_actaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_rc_actaActionPerformed
        tf_rc_fecha.requestFocusInWindow();
    }//GEN-LAST:event_tf_rc_actaActionPerformed

    private void tf_rp_numeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_rp_numeroActionPerformed
        tfnovedades.requestFocusInWindow();
    }//GEN-LAST:event_tf_rp_numeroActionPerformed

    private void tf_rc_numInsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_rc_numInsActionPerformed
        tf_rp_libro.requestFocusInWindow();
    }//GEN-LAST:event_tf_rc_numInsActionPerformed

    private void tf_rp_libroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_rp_libroActionPerformed
        tf_rp_pagina.requestFocusInWindow();
    }//GEN-LAST:event_tf_rp_libroActionPerformed

    private void tf_rp_paginaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_rp_paginaActionPerformed
        tf_rp_numero.requestFocusInWindow();
    }//GEN-LAST:event_tf_rp_paginaActionPerformed

    private void tf_rc_anioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_rc_anioKeyPressed
       
    }//GEN-LAST:event_tf_rc_anioKeyPressed

    private void tf_rc_anioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_rc_anioKeyReleased
        if (tf_rc_anio.getText().length() > 4) 
               tf_rc_anio.setText("");
    }//GEN-LAST:event_tf_rc_anioKeyReleased

    private void tffechaBautizoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tffechaBautizoKeyReleased
        if (tffechaBautizo.getText().length() > 10) {
               tffechaBautizo.setText("");
               setea_Fecha_actual(tffechaBautizo);
        }          
    }//GEN-LAST:event_tffechaBautizoKeyReleased

    private void tffechaNacimientoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tffechaNacimientoKeyReleased
        if (tffechaNacimiento.getText().length() > 10){
               tffechaNacimiento.setText("");
               setea_Fecha_actual(tffechaNacimiento);
        }          
    }//GEN-LAST:event_tffechaNacimientoKeyReleased

    private void tf_rc_fechaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_rc_fechaKeyReleased
        if (tf_rc_fecha.getText().length() > 10) {
               tf_rc_fecha.setText("");
               setea_Fecha_actual(tf_rc_fecha);
        }          
    }//GEN-LAST:event_tf_rc_fechaKeyReleased

    private void lis_autoridadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lis_autoridadActionPerformed

        String ini = lis_autoridad.getSelectedItem().toString();
        tfnombreSacerdote.setText(ini);
    }//GEN-LAST:event_lis_autoridadActionPerformed

    private void tfnovedadesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfnovedadesFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_tfnovedadesFocusLost

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        limpiar_datos();

    }//GEN-LAST:event_jButton3ActionPerformed

    
    
    
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
            java.util.logging.Logger.getLogger(gui_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gui_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gui_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gui_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gui_Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lab1;
    private javax.swing.JLabel lab10;
    private javax.swing.JLabel lab3;
    private javax.swing.JLabel lab4;
    private javax.swing.JLabel lab5;
    private javax.swing.JLabel lab6;
    private javax.swing.JLabel lab7;
    private javax.swing.JLabel lab8;
    private javax.swing.JLabel lab9;
    private javax.swing.JLabel lab_rc;
    private javax.swing.JLabel lab_rc1;
    private javax.swing.JLabel lab_rc2;
    private javax.swing.JLabel lab_rc3;
    private javax.swing.JLabel lab_rc4;
    private javax.swing.JLabel lab_rc5;
    private javax.swing.JLabel lab_rc6;
    private javax.swing.JLabel lab_rc7;
    private javax.swing.JLabel lab_rp1;
    private javax.swing.JLabel lab_rp10;
    private javax.swing.JLabel lab_rp11;
    private javax.swing.JLabel lab_rp2;
    private javax.swing.JComboBox<String> lis_autoridad;
    private javax.swing.JTextField tf_rc_acta;
    private javax.swing.JTextField tf_rc_anio;
    private javax.swing.JTextField tf_rc_fecha;
    private javax.swing.JTextField tf_rc_folio;
    private javax.swing.JTextField tf_rc_numIns;
    private javax.swing.JTextField tf_rc_tomo;
    private javax.swing.JTextField tf_rp_libro;
    private javax.swing.JTextField tf_rp_numero;
    private javax.swing.JTextField tf_rp_pagina;
    private javax.swing.JTextField tffechaBautizo;
    private javax.swing.JTextField tffechaNacimiento;
    private javax.swing.JTextField tflugarNacimiento;
    private javax.swing.JTextField tfnombreBautizado;
    private javax.swing.JTextField tfnombreMadrina;
    private javax.swing.JTextField tfnombreMama;
    private javax.swing.JTextField tfnombrePadrino;
    private javax.swing.JTextField tfnombrePapa;
    private javax.swing.JTextField tfnombreSacerdote;
    private javax.swing.JTextArea tfnovedades;
    // End of variables declaration//GEN-END:variables
}
