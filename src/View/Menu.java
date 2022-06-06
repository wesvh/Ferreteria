package View;


import javax.swing.JButton;
import javax.swing.JTextPane;
import Ferreteria.Metodos;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class Menu extends javax.swing.JFrame {
 Metodos run = new Metodos();  
    public Menu() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        opcion1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        PanelResultados = new javax.swing.JTextPane();
        BotonOpcion2 = new javax.swing.JButton();
        BotonOpcion3 = new javax.swing.JButton();
        BotonOpcion5 = new javax.swing.JButton();
        BotonOpcion4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        opcion1.setText("Listar Elementos");
        opcion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcion1ActionPerformed(evt);
            }
        });

        PanelResultados.setEditable(false);
        jScrollPane1.setViewportView(PanelResultados);

        BotonOpcion2.setText("Insertar Elementos");
        BotonOpcion2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonOpcion2ActionPerformed(evt);
            }
        });

        BotonOpcion3.setText("Modificar");
        BotonOpcion3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonOpcion3ActionPerformed(evt);
            }
        });

        BotonOpcion5.setText("Eliminar elementos");
        BotonOpcion5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonOpcion5ActionPerformed(evt);
            }
        });

        BotonOpcion4.setText("Buscar");
        BotonOpcion4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonOpcion4ActionPerformed(evt);
            }
        });

        jLabel2.setText("SALIDA DE DATOS");

        jLabel1.setText("FERRECOL S.A.S");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(opcion1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotonOpcion2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotonOpcion3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotonOpcion5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotonOpcion4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(298, 298, 298)
                        .addComponent(jLabel2)))
                .addContainerGap(111, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(385, 385, 385)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel2)
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(opcion1)
                        .addGap(18, 18, 18)
                        .addComponent(BotonOpcion2)
                        .addGap(18, 18, 18)
                        .addComponent(BotonOpcion3)
                        .addGap(18, 18, 18)
                        .addComponent(BotonOpcion4)
                        .addGap(223, 223, 223)
                        .addComponent(BotonOpcion5)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void opcion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion1ActionPerformed
     
        try {
         getPanelresultados().setText(run.listarProductos());
                  
     } catch (SQLException ex) {
         Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
     }
     
    }//GEN-LAST:event_opcion1ActionPerformed

    private void BotonOpcion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonOpcion2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonOpcion2ActionPerformed

    private void BotonOpcion3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonOpcion3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonOpcion3ActionPerformed

    private void BotonOpcion4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonOpcion4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonOpcion4ActionPerformed

    private void BotonOpcion5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonOpcion5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonOpcion5ActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonOpcion2;
    private javax.swing.JButton BotonOpcion3;
    private javax.swing.JButton BotonOpcion4;
    private javax.swing.JButton BotonOpcion5;
    private javax.swing.JTextPane PanelResultados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton opcion1;
    // End of variables declaration//GEN-END:variables

    public JTextPane getPanelresultados() {
		return PanelResultados;
	}
 
}
