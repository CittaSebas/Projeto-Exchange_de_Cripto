/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.CriptosNovasController;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author citta
 */
public class FrameCriptosNovas extends javax.swing.JFrame {
    private String cpflogado;
    private float saldo;
    private CriptosNovasController controller;

    public JTextField getTxtsaldom1() {
        return txtsaldom1;
    }

    public JTextField getTxtsaldom2() {
        return txtsaldom2;
    }

    public JTextField getTxtsaldom3() {
        return txtsaldom3;
    }
    
   

    public JTextField getTxtabv1() {
        return txtabv1;
    }

    public JTextField getTxtabv2() {
        return txtabv2;
    }

    public JTextField getTxtabv3() {
        return txtabv3;
    }

    public JTextField getTxtid1() {
        return txtid1;
    }

    public JTextField getTxtid2() {
        return txtid2;
    }

    public JTextField getTxtid3() {
        return txtid3;
    }

    public JTextField getTxtnome1() {
        return txtnome1;
    }

    public JTextField getTxtnome2() {
        return txtnome2;
    }

    public JTextField getTxtnome3() {
        return txtnome3;
    }

    public JTextField getTxtvalor1() {
        return txtvalor1;
    }

    public JTextField getTxtvalor2() {
        return txtvalor2;
    }

    public JTextField getTxtvalor3() {
        return txtvalor3;
    }

    public JTextField getTxtvalorcompra1() {
        return txtvalorcompra1;
    }

    public JTextField getTxtvalorcompra2() {
        return txtvalorcompra2;
    }

    public JTextField getTxtvalorcompra3() {
        return txtvalorcompra3;
    }

    public JTextField getTxtsaldo() {
        return txtsaldo;
    }
    
    
    
    /**
     * Creates new form FrameCriptosNovas
     */
    public FrameCriptosNovas(String cpflogado) {
        initComponents();
        controller = new CriptosNovasController(this,cpflogado);
        this.cpflogado = cpflogado;
        saldo = controller.consultarsaldo();
        
        txtsaldo.setText(Float.toString(saldo));
        txtid1.setEditable(false);
        txtid2.setEditable(false);
        txtid3.setEditable(false);
        txtid1.setVisible(false);txtid2.setVisible(false);txtid3.setVisible(false);
        txtid3.setVisible(false);
        btncompra1.setVisible(false);btncompra2.setVisible(false);btncompra3.setVisible(false);
        lblm1.setVisible(false);
        lblm2.setVisible(false);
        lblm3.setVisible(false);
        txtnome1.setVisible(false);
        txtnome2.setVisible(false);
        txtnome3.setVisible(false);
        txtnome1.setEditable(false);txtnome2.setEditable(false);txtnome3.setEditable(false);
        txtvalor1.setVisible(false);
        txtvalor2.setVisible(false);
        txtvalor3.setVisible(false);
        txtvalor1.setEditable(false);txtvalor2.setEditable(false);txtvalor3.setEditable(false);
        txtabv1.setVisible(false);
        txtabv2.setVisible(false);
        txtabv3.setVisible(false);
        txtabv1.setEditable(false);txtabv2.setEditable(false);txtabv3.setEditable(false);
        txtsaldom1.setVisible(false);
        txtsaldom2.setVisible(false);
        txtsaldom3.setVisible(false);
        txtsaldom1.setEditable(false);txtsaldom2.setEditable(false);txtsaldom3.setEditable(false);
        txtvalorcompra1.setVisible(false);
        txtvalorcompra2.setVisible(false);
        txtvalorcompra3.setVisible(false);
        String[] moedas = new String[0];
        moedas = controller.checkarmoedas();
        
        
        if(moedas.length >= 4){
            String saldom1 = controller.saldom1();
            txtsaldom1.setVisible(true);
            txtsaldom1.setText(saldom1);
            lblm1.setVisible(true);
            txtid1.setVisible(true);
            txtnome1.setVisible(true);
            txtvalor1.setVisible(true);
            txtabv1.setVisible(true);
            txtid1.setText(moedas[0]);
            txtnome1.setText(moedas[1]);
            txtvalor1.setText(moedas[2]);
            txtabv1.setText(moedas[3]);
            lblm1.setText(moedas[1]);
            txtvalorcompra1.setVisible(true);
            btncompra1.setVisible(true);
        }
         if(moedas.length>=8){
            String saldom2 = controller.saldom2();
            txtsaldom2.setVisible(true);
            txtsaldom2.setText(saldom2);
            lblm2.setVisible(true);
            txtid2.setVisible(true);
            txtnome2.setVisible(true);
            txtvalor2.setVisible(true);
            txtabv2.setVisible(true);
            txtid2.setText(moedas[4]);
            txtnome2.setText(moedas[5]);
            txtvalor2.setText(moedas[6]);
            txtabv2.setText(moedas[7]);
            lblm2.setText(moedas[5]);
            txtvalorcompra2.setVisible(true);
            btncompra2.setVisible(true);
        }
         if(moedas.length>=12){
            String saldom3 = controller.saldom3();
            txtsaldom3.setVisible(true);
            txtsaldom3.setText(saldom3);
            lblm1.setVisible(true);
            txtid3.setVisible(true);
            txtnome3.setVisible(true);
            txtvalor3.setVisible(true);
            txtabv3.setVisible(true);
            txtid3.setText(moedas[8]);
            txtnome3.setText(moedas[9]);
            txtvalor3.setText(moedas[10]);
            txtabv3.setText(moedas[11]);
            lblm3.setText(moedas[9]);
            txtvalorcompra3.setVisible(true);
            btncompra3.setVisible(true);
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

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        txtnome2 = new javax.swing.JTextField();
        txtnome3 = new javax.swing.JTextField();
        txtvalor1 = new javax.swing.JTextField();
        txtvalor2 = new javax.swing.JTextField();
        txtvalor3 = new javax.swing.JTextField();
        txtabv1 = new javax.swing.JTextField();
        txtabv2 = new javax.swing.JTextField();
        txtid1 = new javax.swing.JTextField();
        txtabv3 = new javax.swing.JTextField();
        txtid2 = new javax.swing.JTextField();
        lblm1 = new javax.swing.JLabel();
        txtid3 = new javax.swing.JTextField();
        lblm2 = new javax.swing.JLabel();
        txtnome1 = new javax.swing.JTextField();
        lblm3 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtsaldo = new javax.swing.JTextField();
        txtvalorcompra1 = new javax.swing.JTextField();
        txtvalorcompra2 = new javax.swing.JTextField();
        txtvalorcompra3 = new javax.swing.JTextField();
        btncompra1 = new javax.swing.JButton();
        btncompra2 = new javax.swing.JButton();
        btncompra3 = new javax.swing.JButton();
        txtsaldom1 = new javax.swing.JTextField();
        txtsaldom2 = new javax.swing.JTextField();
        txtsaldom3 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        txtid1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtid1ActionPerformed(evt);
            }
        });

        txtabv3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtabv3ActionPerformed(evt);
            }
        });

        txtid2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtid2ActionPerformed(evt);
            }
        });

        lblm1.setText("Moeda 1");

        txtid3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtid3ActionPerformed(evt);
            }
        });

        lblm2.setText("Moeda 2");

        txtnome1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnome1ActionPerformed(evt);
            }
        });

        lblm3.setText("Moeda 3");

        jLabel3.setText("Saldo disponível: ");

        btncompra1.setText("Comprar");
        btncompra1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncompra1ActionPerformed(evt);
            }
        });

        btncompra2.setText("Comprar");
        btncompra2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncompra2ActionPerformed(evt);
            }
        });

        btncompra3.setText("Comprar");
        btncompra3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncompra3ActionPerformed(evt);
            }
        });

        jLabel1.setText("Abreviação");

        jLabel2.setText("Valor");

        jLabel4.setText("Nome");

        jLabel5.setText("Saldo em Moeda:");

        jLabel6.setText("Digite o valor de Compra:");

        jLabel7.setText("ID");

        jMenu3.setText("Menu");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar2.add(jMenu3);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btncompra3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtsaldom1, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtid1)
                                            .addComponent(txtnome1)
                                            .addComponent(txtvalor1)
                                            .addComponent(txtabv1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGap(16, 16, 16)
                                                .addComponent(lblm1)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblm2)
                                                .addGap(49, 49, 49))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtid2)
                                                    .addComponent(txtnome2)
                                                    .addComponent(txtvalor2)
                                                    .addComponent(txtabv2)
                                                    .addComponent(txtsaldom2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(29, 29, 29)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtabv3)
                                            .addComponent(txtvalor3)
                                            .addComponent(txtnome3)
                                            .addComponent(txtid3)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(17, 17, 17)
                                                .addComponent(lblm3))
                                            .addComponent(txtsaldom3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btncompra1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btncompra2))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtvalorcompra1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(30, 30, 30)
                                                .addComponent(txtvalorcompra2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(29, 29, 29)
                                        .addComponent(txtvalorcompra3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtsaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtsaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblm1)
                    .addComponent(lblm2)
                    .addComponent(lblm3))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtid1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtid2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtid3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtnome3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnome1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnome2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtvalor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtvalor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtvalor3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtabv1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtabv2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtabv3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsaldom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtsaldom2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtsaldom3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtvalorcompra1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtvalorcompra2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtvalorcompra3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btncompra1)
                    .addComponent(btncompra2)
                    .addComponent(btncompra3))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void txtid1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtid1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtid1ActionPerformed

    private void txtabv3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtabv3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtabv3ActionPerformed

    private void txtid2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtid2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtid2ActionPerformed

    private void txtid3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtid3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtid3ActionPerformed

    private void txtnome1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnome1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnome1ActionPerformed

    private void btncompra1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncompra1ActionPerformed
        // TODO add your handling code here:
        String[] moedas = new String[0];
        moedas = controller.checkarmoedas();
        String [] moeda1 = new String[4];
        System.arraycopy(moedas, 0, moeda1, 0, 4);
        moeda1[2] = controller.saldom1();
        controller.comprarmoeda1(moeda1);
        FrameUsuario fu = new FrameUsuario(cpflogado);
        fu.setVisible(true);
        dispose();
    }//GEN-LAST:event_btncompra1ActionPerformed

    private void btncompra2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncompra2ActionPerformed
        // TODO add your handling code here:
        String[] moedas = new String[0];
        moedas = controller.checkarmoedas();
        String [] moeda2 = new String[4];
        System.arraycopy(moedas, 4, moeda2, 0, 4);
        moeda2[2] = controller.saldom2();
        controller.comprarmoeda2(moeda2);
        FrameUsuario fu = new FrameUsuario(cpflogado);
        fu.setVisible(true);
        dispose();
    }//GEN-LAST:event_btncompra2ActionPerformed

    private void btncompra3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncompra3ActionPerformed
        // TODO add your handling code here:
        String[] moedas = new String[0];
        moedas = controller.checkarmoedas();
        String [] moeda1 = new String[4];
        System.arraycopy(moedas, 8, moeda1, 0, 4);
        moeda1[2] = controller.saldom3();
        controller.comprarmoeda3(moeda1);
        FrameUsuario fu = new FrameUsuario(cpflogado);
        fu.setVisible(true);
        dispose();
    }//GEN-LAST:event_btncompra3ActionPerformed

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
       
        FrameUsuario fu = new FrameUsuario(cpflogado);
        fu.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_jMenu3MouseClicked

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
            java.util.logging.Logger.getLogger(FrameCriptosNovas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameCriptosNovas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameCriptosNovas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameCriptosNovas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncompra1;
    private javax.swing.JButton btncompra2;
    private javax.swing.JButton btncompra3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JLabel lblm1;
    private javax.swing.JLabel lblm2;
    private javax.swing.JLabel lblm3;
    private javax.swing.JTextField txtabv1;
    private javax.swing.JTextField txtabv2;
    private javax.swing.JTextField txtabv3;
    private javax.swing.JTextField txtid1;
    private javax.swing.JTextField txtid2;
    private javax.swing.JTextField txtid3;
    private javax.swing.JTextField txtnome1;
    private javax.swing.JTextField txtnome2;
    private javax.swing.JTextField txtnome3;
    private javax.swing.JTextField txtsaldo;
    private javax.swing.JTextField txtsaldom1;
    private javax.swing.JTextField txtsaldom2;
    private javax.swing.JTextField txtsaldom3;
    private javax.swing.JTextField txtvalor1;
    private javax.swing.JTextField txtvalor2;
    private javax.swing.JTextField txtvalor3;
    private javax.swing.JTextField txtvalorcompra1;
    private javax.swing.JTextField txtvalorcompra2;
    private javax.swing.JTextField txtvalorcompra3;
    // End of variables declaration//GEN-END:variables
}
