/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.CriarCriptoController;
import javax.swing.JTextField;
import model.Cotacao;

/**
 *
 * @author Sebastian
 */
public class FrameCriarCripto extends javax.swing.JFrame {
    private CriarCriptoController controller;
    private String id1,id2,id3,valor1,valor2,valor3,nome1,nome2,nome3,abr1,abr2,abr3;
    public JTextField getTxtabreviacao() {
        return txtabreviacao;
    }

    public JTextField getTxtid() {
        return txtid;
    }

    public JTextField getTxtnome() {
        return txtnome;
    }

    public JTextField getTxtvalor() {
        return txtvalor;
    }

    public void setTxtabv1(JTextField txtabv1) {
        this.txtabv1 = txtabv1;
    }

    public void setTxtabv2(JTextField txtabv2) {
        this.txtabv2 = txtabv2;
    }

    public void setTxtabv3(JTextField txtabv3) {
        this.txtabv3 = txtabv3;
    }

    public void setTxtid(JTextField txtid) {
        this.txtid = txtid;
    }

    public void setTxtid1(JTextField txtid1) {
        this.txtid1 = txtid1;
    }

    public void setTxtid2(JTextField txtid2) {
        this.txtid2 = txtid2;
    }

    public void setTxtid3(JTextField txtid3) {
        this.txtid3 = txtid3;
    }

    public void setTxtnome1(JTextField txtnome1) {
        this.txtnome1 = txtnome1;
    }

    public void setTxtnome2(JTextField txtnome2) {
        this.txtnome2 = txtnome2;
    }

    public void setTxtnome3(JTextField txtnome3) {
        this.txtnome3 = txtnome3;
    }

    public void setTxtvalor1(JTextField txtvalor1) {
        this.txtvalor1 = txtvalor1;
    }

    public void setTxtvalor2(JTextField txtvalor2) {
        this.txtvalor2 = txtvalor2;
    }

    public void setTxtvalor3(JTextField txtvalor3) {
        this.txtvalor3 = txtvalor3;
    }
    
    
    
    

    /**
     * Creates new form criacripto
     */
    public FrameCriarCripto() {
        initComponents();
        txtid1.setVisible(false);
        txtid2.setVisible(false);
        txtid3.setVisible(false);
        lblm1.setVisible(false);
        lblm2.setVisible(false);
        lblm3.setVisible(false);
        txtnome1.setVisible(false);
        txtnome2.setVisible(false);
        txtnome3.setVisible(false);
        txtvalor1.setVisible(false);
        txtvalor2.setVisible(false);
        txtvalor3.setVisible(false);
        txtabv1.setVisible(false);
        txtabv2.setVisible(false);
        txtabv3.setVisible(false);
        controller = new CriarCriptoController(this);
        String[] moedas = new String[0];
        moedas = controller.checkarmoedas();
        if(moedas.length == 0){
            System.out.println("List vazia");
        }
         if(moedas.length >= 4){
            lblm1.setVisible(true);
            txtid1.setVisible(true);
            txtnome1.setVisible(true);
            txtvalor1.setVisible(true);
            txtabv1.setVisible(true);
            txtid1.setText(moedas[0]);
            txtnome1.setText(moedas[1]);
            txtvalor1.setText(moedas[2]);
            txtabv1.setText(moedas[3]);
        }
         if(moedas.length>=8){
            lblm2.setVisible(true);
            txtid2.setVisible(true);
            txtnome2.setVisible(true);
            txtvalor2.setVisible(true);
            txtabv2.setVisible(true);
            txtid2.setText(moedas[4]);
            txtnome2.setText(moedas[5]);
            txtvalor2.setText(moedas[6]);
            txtabv2.setText(moedas[7]);
        }
         if(moedas.length>=12){
            lblm1.setVisible(true);
            txtid3.setVisible(true);
            txtnome3.setVisible(true);
            txtvalor3.setVisible(true);
            txtabv3.setVisible(true);
            txtid3.setText(moedas[8]);
            txtnome3.setText(moedas[9]);
            txtvalor3.setText(moedas[10]);
            txtabv3.setText(moedas[11]);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtnome = new javax.swing.JTextField();
        btncriar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtvalor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtabreviacao = new javax.swing.JTextField();
        txtid1 = new javax.swing.JTextField();
        txtid2 = new javax.swing.JTextField();
        txtid3 = new javax.swing.JTextField();
        txtnome1 = new javax.swing.JTextField();
        txtnome2 = new javax.swing.JTextField();
        txtnome3 = new javax.swing.JTextField();
        txtvalor1 = new javax.swing.JTextField();
        txtvalor2 = new javax.swing.JTextField();
        txtvalor3 = new javax.swing.JTextField();
        txtabv1 = new javax.swing.JTextField();
        txtabv2 = new javax.swing.JTextField();
        txtabv3 = new javax.swing.JTextField();
        lblm1 = new javax.swing.JLabel();
        lblm2 = new javax.swing.JLabel();
        lblm3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Criar Criptomoeda");

        jLabel2.setText("Nome da Moeda:");

        jLabel3.setText("Valor da Moeda:");

        btncriar.setText("Criar");
        btncriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncriarActionPerformed(evt);
            }
        });

        jLabel4.setText("ID da Moeda:");

        jLabel5.setText("Abreviacao da Moeda");

        txtid1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtid1ActionPerformed(evt);
            }
        });

        txtid2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtid2ActionPerformed(evt);
            }
        });

        txtid3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtid3ActionPerformed(evt);
            }
        });

        txtnome1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnome1ActionPerformed(evt);
            }
        });

        txtnome2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnome2ActionPerformed(evt);
            }
        });

        txtnome3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnome3ActionPerformed(evt);
            }
        });

        txtvalor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtvalor1ActionPerformed(evt);
            }
        });

        txtvalor2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtvalor2ActionPerformed(evt);
            }
        });

        txtvalor3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtvalor3ActionPerformed(evt);
            }
        });

        txtabv1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtabv1ActionPerformed(evt);
            }
        });

        txtabv2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtabv2ActionPerformed(evt);
            }
        });

        txtabv3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtabv3ActionPerformed(evt);
            }
        });

        lblm1.setText("Moeda 1");

        lblm2.setText("Moeda 2");

        lblm3.setText("Moeda 3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(btncriar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtvalor, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtabreviacao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblm1)
                                .addGap(9, 9, 9))
                            .addComponent(txtid1, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                            .addComponent(txtnome1)
                            .addComponent(txtvalor1)
                            .addComponent(txtabv1))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtid2, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                                    .addComponent(txtnome2)
                                    .addComponent(txtvalor2)
                                    .addComponent(txtabv2))
                                .addGap(29, 29, 29))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblm2)
                                .addGap(56, 56, 56)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(lblm3))
                            .addComponent(txtabv3, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                            .addComponent(txtvalor3)
                            .addComponent(txtnome3)
                            .addComponent(txtid3))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblm1)
                    .addComponent(lblm2)
                    .addComponent(lblm3))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtid1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtid2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtid3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtnome1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnome2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnome3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtvalor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtvalor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtvalor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtvalor3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtabreviacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtabv1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtabv2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtabv3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(btncriar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncriarActionPerformed
        // TODO add your handling code here:
        controller.adicionarmoeda();
    }//GEN-LAST:event_btncriarActionPerformed

    private void txtid1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtid1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtid1ActionPerformed

    private void txtid2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtid2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtid2ActionPerformed

    private void txtid3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtid3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtid3ActionPerformed

    private void txtnome1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnome1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnome1ActionPerformed

    private void txtnome2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnome2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnome2ActionPerformed

    private void txtnome3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnome3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnome3ActionPerformed

    private void txtvalor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtvalor1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtvalor1ActionPerformed

    private void txtvalor2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtvalor2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtvalor2ActionPerformed

    private void txtvalor3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtvalor3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtvalor3ActionPerformed

    private void txtabv1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtabv1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtabv1ActionPerformed

    private void txtabv2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtabv2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtabv2ActionPerformed

    private void txtabv3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtabv3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtabv3ActionPerformed

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
            java.util.logging.Logger.getLogger(FrameCriarCripto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameCriarCripto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameCriarCripto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameCriarCripto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameCriarCripto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncriar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblm1;
    private javax.swing.JLabel lblm2;
    private javax.swing.JLabel lblm3;
    private javax.swing.JTextField txtabreviacao;
    private javax.swing.JTextField txtabv1;
    private javax.swing.JTextField txtabv2;
    private javax.swing.JTextField txtabv3;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtid1;
    private javax.swing.JTextField txtid2;
    private javax.swing.JTextField txtid3;
    private javax.swing.JTextField txtnome;
    private javax.swing.JTextField txtnome1;
    private javax.swing.JTextField txtnome2;
    private javax.swing.JTextField txtnome3;
    private javax.swing.JTextField txtvalor;
    private javax.swing.JTextField txtvalor1;
    private javax.swing.JTextField txtvalor2;
    private javax.swing.JTextField txtvalor3;
    // End of variables declaration//GEN-END:variables
}
