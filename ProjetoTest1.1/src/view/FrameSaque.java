/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.DepositoController;
import javax.swing.JTextField;

/**
 *
 * @author citta
 */
public class FrameSaque extends javax.swing.JFrame {
    private String cpflogado;
    private DepositoController controller;

    public JTextField getTxtvalorsaque() {
        return txtvalorsaque;
    }
    
    public FrameSaque(String cpflogado) {
        initComponents();
        this.cpflogado = cpflogado;
        txtsaldo.setEditable(false);
        controller = new DepositoController(this,cpflogado);
        float saldo = controller.saldo();
        System.out.println(saldo);
        txtsaldo.setText(Float.toString(saldo));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblfuncaosaque = new javax.swing.JLabel();
        lblvalorsaque = new javax.swing.JLabel();
        txtvalorsaque = new javax.swing.JTextField();
        lblinfo = new javax.swing.JLabel();
        btnsacar = new javax.swing.JButton();
        txtsaldo = new javax.swing.JTextField();
        lblsaldo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblfuncaosaque.setText("Saque");

        lblvalorsaque.setText("Valor a ser sacado: ");

        txtvalorsaque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtvalorsaqueActionPerformed(evt);
            }
        });

        lblinfo.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lblinfo.setText("Valor sacado será em R$");

        btnsacar.setText("Sacar");
        btnsacar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsacarActionPerformed(evt);
            }
        });

        lblsaldo.setText("Saldo disponivel:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblvalorsaque)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnsacar)
                    .addComponent(txtvalorsaque, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(lblfuncaosaque))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(lblinfo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(lblsaldo)
                        .addGap(18, 18, 18)
                        .addComponent(txtsaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblfuncaosaque)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblsaldo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblvalorsaque)
                    .addComponent(txtvalorsaque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(btnsacar)
                .addGap(29, 29, 29)
                .addComponent(lblinfo)
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtvalorsaqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtvalorsaqueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtvalorsaqueActionPerformed

    private void btnsacarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsacarActionPerformed
        // TODO add your handling code here:
        controller.sacar();
        FrameUsuario fu = new FrameUsuario(cpflogado);
        fu.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnsacarActionPerformed

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
            java.util.logging.Logger.getLogger(FrameSaque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameSaque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameSaque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameSaque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsacar;
    private javax.swing.JLabel lblfuncaosaque;
    private javax.swing.JLabel lblinfo;
    private javax.swing.JLabel lblsaldo;
    private javax.swing.JLabel lblvalorsaque;
    private javax.swing.JTextField txtsaldo;
    private javax.swing.JTextField txtvalorsaque;
    // End of variables declaration//GEN-END:variables
}
