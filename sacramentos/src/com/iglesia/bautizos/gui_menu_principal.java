/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.bautizos;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon; 
import com.iglesia.matrimonios.*;
import com.iglesia.autoridades.*;
import com.iglesia.confirmaciones.*;
import java.awt.Image;

public class gui_menu_principal extends javax.swing.JFrame {

    /**
     * Creates new form gui_menu_principal
     */
    private JMenuBar gui_barra_menu;
    private JMenu gui_menu_bautizo, gui_menu_matri, gui_menu_confirma, gui_menu_autoridad;
    private JMenuItem gui_submenu_bautizo_con, gui_submenu_bautizo_ing, gui_submenu_bautizo_mod,  
                      gui_submenu_bautizo_Visualiza_Datos, 
                      gui_submenu_matri_con, gui_submenu_matri_ing, gui_submenu_matri_modi, gui_submenu_matri_Visualiza_Datos, 
                      gui_submenu_confirma_con, gui_submenu_confirma_ing, gui_submenu_confirma_modi,  gui_submenu_confirma_Visualiza_Datos, 
                      gui_submenu_inserta_autoridad, gui_submenu_modifica_autoridad; 
    
    public void gui_menu(){

        // Barra de menus
        gui_barra_menu = new JMenuBar();

        // Menu Bautizos
        gui_menu_bautizo = new JMenu("Bautizos");

        gui_submenu_bautizo_con = new JMenuItem("Consulta de Datos");
        gui_submenu_bautizo_con.addActionListener( new ActionListener() 
                                    { public void actionPerformed(ActionEvent e) { 
                                        JFrame jc = new gui_Consulta();
                                        jc.setVisible(true);
                                    }
                                });

        gui_submenu_bautizo_ing = new JMenuItem("Ingreso de Datos");
        gui_submenu_bautizo_ing.addActionListener( new ActionListener() 
                                    { public void actionPerformed(ActionEvent e) { 
                                        JFrame jf = new gui_Frame();
                                        jf.setVisible(true);
                                    }
                                });
        // Se agrega menu Modificacion de Bautizos
        // Fecha 30/08/2022
        gui_submenu_bautizo_mod = new JMenuItem("Modificación de Datos");
	gui_submenu_bautizo_mod.addActionListener( new ActionListener() 
										{ public void actionPerformed(ActionEvent e) { 
											JFrame jc = new gui_Modifica_bautizo();
											jc.setVisible(true);
										}
									});
        // Fecha cambio: 1/12/2022
        // Nueva opcion en menu Bautizos: Visualizacion Repositorio
        gui_submenu_bautizo_Visualiza_Datos = new JMenuItem("Visualizar Repositorio");
        gui_submenu_bautizo_Visualiza_Datos.addActionListener(new ActionListener() 
                                { public void actionPerformed(ActionEvent e) {
                                        JFrame jc = new gui_Visualiza_Datos();
                                        jc.setVisible(true);
                                }
                                });
        
        //gui_submenu_bautizo_sal = new JMenuItem("Salir");
        //gui_submenu_bautizo_sal.addActionListener(new ActionListener() 
        //                       { public void actionPerformed(ActionEvent e) { System.exit(1); }
        //                        });
        
        gui_menu_bautizo.add(gui_submenu_bautizo_con);
        gui_menu_bautizo.add(gui_submenu_bautizo_ing);
        gui_menu_bautizo.add(gui_submenu_bautizo_mod);
        gui_menu_bautizo.add(gui_submenu_bautizo_Visualiza_Datos);
                 
        // Menu Matrimonios
        gui_submenu_matri_con = new JMenuItem("Consulta de Datos");
        gui_submenu_matri_con.addActionListener( new ActionListener() 
                                    { public void actionPerformed(ActionEvent e) { 
                                        JFrame jf = new gui_Matri_Consulta();
                                        jf.setVisible(true); 
                                    }
                                });
        
        gui_menu_matri = new JMenu("Matrimonios");
        gui_submenu_matri_ing = new JMenuItem("Ingreso de Datos");
        gui_submenu_matri_ing.addActionListener( new ActionListener() 
                                    { public void actionPerformed(ActionEvent e) { 
                                        JFrame jf = new gui_Matri_Frame();
                                        jf.setVisible(true);
                                    }
                                });
        
        gui_submenu_matri_modi = new JMenuItem("Modificación de Datos");
        gui_submenu_matri_modi.addActionListener( new ActionListener() 
                                    { public void actionPerformed(ActionEvent e) { 
                                        JFrame jf = new gui_Matri_Modificacion();
                                        jf.setVisible(true); 
                                    }
                                });
        
        gui_submenu_matri_Visualiza_Datos = new JMenuItem("Visualizar Repositorio");
        gui_submenu_matri_Visualiza_Datos.addActionListener(new ActionListener() 
                                { public void actionPerformed(ActionEvent e) {
                                        JFrame jc = new gui_Matrimonio_Visualiza_Datos();
                                        jc.setVisible(true);
                                }
                                });
        
        gui_menu_matri.add(gui_submenu_matri_con);                                   
        gui_menu_matri.add(gui_submenu_matri_ing);
        gui_menu_matri.add(gui_submenu_matri_modi);
        gui_menu_matri.add(gui_submenu_matri_Visualiza_Datos);        
        
        
        // Menu Confirmacion
        gui_submenu_confirma_con = new JMenuItem("Consulta de Datos");
        gui_submenu_confirma_con.addActionListener( new ActionListener() 
                                    { public void actionPerformed(ActionEvent e) { 
                                        JFrame jc = new gui_Confirma_Consulta();
                                        jc.setVisible(true);
                                    }
                                });
                
        gui_menu_confirma = new JMenu("Confirmaciones");
        gui_submenu_confirma_ing = new JMenuItem("Ingreso de Datos");
        gui_submenu_confirma_ing.addActionListener( new ActionListener() 
                                    { public void actionPerformed(ActionEvent e) { 
                                        JFrame jc = new gui_Confirma_Frame();
                                        jc.setVisible(true);
                                    }
                                });
        
        gui_submenu_confirma_modi = new JMenuItem("Modificación de Datos");
        gui_submenu_confirma_modi.addActionListener( new ActionListener() 
                                    { public void actionPerformed(ActionEvent e) { 
                                        JFrame jc = new gui_Confirma_Modificacion();
                                        jc.setVisible(true);
                                    }
                                });
        
        gui_submenu_confirma_Visualiza_Datos = new JMenuItem("Visualizar Repositorio");
        gui_submenu_confirma_Visualiza_Datos.addActionListener(new ActionListener() 
                                { public void actionPerformed(ActionEvent e) {
                                        JFrame jc = new gui_Confirma_Visualiza_Datos();
                                        jc.setVisible(true);
                                }
                                });
        
        gui_menu_confirma.add(gui_submenu_confirma_con);
        gui_menu_confirma.add(gui_submenu_confirma_ing);
        gui_menu_confirma.add(gui_submenu_confirma_modi);
        gui_menu_confirma.add(gui_submenu_confirma_Visualiza_Datos);
        
        
        // Menu de Autoridades
        gui_menu_autoridad = new JMenu("Autoridades");
        // Inserta autoridades
        gui_submenu_inserta_autoridad = new JMenuItem("inserta Autoridades");
        gui_submenu_inserta_autoridad.addActionListener( new ActionListener() 
                                    { public void actionPerformed(ActionEvent e) { 
                                        JFrame jc = new gui_Ingresa_Autoridad();
                                        jc.setVisible(true);
                                    }
                                });        
        gui_menu_autoridad.add(gui_submenu_inserta_autoridad);
        // Modificacion de autoridades
        gui_submenu_modifica_autoridad = new JMenuItem("modifica Autoridades");
        gui_submenu_modifica_autoridad.addActionListener( new ActionListener() 
                                    { public void actionPerformed(ActionEvent e) { 
                                        JFrame jc = new gui_Modifica_Autoridad();
                                        jc.setVisible(true);
                                    }
                                });        
        gui_menu_autoridad.add(gui_submenu_modifica_autoridad);
        
        gui_barra_menu.add(gui_menu_bautizo);
        gui_barra_menu.add(gui_menu_matri);
        gui_barra_menu.add(gui_menu_confirma);
        gui_barra_menu.add(gui_menu_autoridad);
    
        
        this.setJMenuBar(gui_barra_menu);
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        //this.setIconImage( Toolkit.getDefaultToolkit().getImage( getClass().getResource("images\\church.png")   )  );
        
  }

    public gui_menu_principal() {
        initComponents();
        gui_menu();
        //setIconImage( new ImageIcon( getClass().getResource("..\\images\\logo_png.png") ).getImage() );
        setIconImage( Toolkit.getDefaultToolkit().getImage( getClass().getResource("..\\images\\logo_png.png")   )  );
        // ruta \\
    }
    /*
    @Override
    public Image getIconImage() {
           Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("..images\\\\logo.ico"));
           return retValue;
    }
    */
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(gui_menu_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gui_menu_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gui_menu_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gui_menu_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gui_menu_principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
