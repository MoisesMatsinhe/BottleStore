package JARs;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author Marondo
 */
public class frmCalender extends javax.swing.JFrame {

    Componentes c = new Componentes();
    Validacoes val = new Validacoes();
    DateTime dh = new DateTime();
    JTextField txtPesquisa = new JTextField();
    JFrame frm = new JFrame();
    JTextField txtField = new JTextField();
    int dia = dh.getDia(), mes = dh.getMes(), ano = dh.getAno();

    public frmCalender() {
        initComponents();
        setSize(330, 200);
        setLocationRelativeTo(this);
        c.mudaFonte(pFundoGeral, 20);
        carregarCBOs();
        getBtns();
    }

    public frmCalender(JFrame frm, JTextField txtField) {
        initComponents();
        setSize(330, 200);
        setLocationRelativeTo(this);
        c.mudaFonte(pFundoGeral, 20);
        carregarCBOs();
        getBtns();
        this.frm = frm;
        this.txtField = txtField;
        txtField.setEditable(false);
        thisOpen(txtField);
    }
    int xm = 0, ym = 0, x = 0, y = 0;

    private void thisOpen(javax.swing.JTextField txtIn) {
        txtIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                xm = evt.getX();
                ym = evt.getY();
                x = evt.getXOnScreen() - xm - txtIn.getHeight() + 20;
                y = evt.getYOnScreen() - ym + txtIn.getHeight();
                openFrm(true, x, y);
            }
        });
    }

    public void openFrm(boolean open, int x, int y) {
        if (open) {
            setLocation(x, y);
            frm.setEnabled(false);
            setVisible(true);
        } else {
            frm.setEnabled(true);
            dispose();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pFundoGeral = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        cboA = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        spinnerM = new javax.swing.JSpinner();
        cboM = new javax.swing.JComboBox<>();
        lb = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pBtns = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new java.awt.BorderLayout(1, 1));

        pFundoGeral.setLayout(new java.awt.BorderLayout(1, 1));

        jPanel2.setPreferredSize(new java.awt.Dimension(354, 50));
        jPanel2.setLayout(new java.awt.GridLayout(2, 0, 0, 2));

        jPanel4.setLayout(new java.awt.BorderLayout(2, 0));

        jPanel6.setPreferredSize(new java.awt.Dimension(70, 29));
        jPanel6.setLayout(new java.awt.BorderLayout());

        cboA.setEditable(true);
        cboA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboAActionPerformed(evt);
            }
        });
        jPanel6.add(cboA, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel6, java.awt.BorderLayout.LINE_END);

        jPanel7.setLayout(new java.awt.BorderLayout(2, 0));

        jPanel8.setPreferredSize(new java.awt.Dimension(90, 29));
        jPanel8.setLayout(new java.awt.BorderLayout());

        spinnerM.setPreferredSize(new java.awt.Dimension(20, 20));
        jPanel8.add(spinnerM, java.awt.BorderLayout.LINE_END);

        jPanel8.add(cboM, java.awt.BorderLayout.CENTER);

        jPanel7.add(jPanel8, java.awt.BorderLayout.LINE_END);

        lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb.setText("dd/mm/aaa");
        jPanel7.add(lb, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel7, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel4);

        jPanel5.setLayout(new java.awt.GridLayout(1, 7, 2, 2));

        jLabel7.setBackground(new java.awt.Color(153, 153, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Dom");
        jLabel7.setOpaque(true);
        jPanel5.add(jLabel7);

        jLabel1.setBackground(new java.awt.Color(153, 153, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Seg");
        jLabel1.setOpaque(true);
        jPanel5.add(jLabel1);

        jLabel2.setBackground(new java.awt.Color(153, 153, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Ter");
        jLabel2.setOpaque(true);
        jPanel5.add(jLabel2);

        jLabel3.setBackground(new java.awt.Color(153, 153, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Qua");
        jLabel3.setOpaque(true);
        jPanel5.add(jLabel3);

        jLabel4.setBackground(new java.awt.Color(153, 153, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Qui");
        jLabel4.setOpaque(true);
        jPanel5.add(jLabel4);

        jLabel5.setBackground(new java.awt.Color(153, 153, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Sex");
        jLabel5.setOpaque(true);
        jPanel5.add(jLabel5);

        jLabel6.setBackground(new java.awt.Color(153, 153, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Sab");
        jLabel6.setOpaque(true);
        jPanel5.add(jLabel6);

        jPanel2.add(jPanel5);

        pFundoGeral.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        pBtns.setLayout(new java.awt.GridLayout(6, 7, 2, 2));
        pFundoGeral.add(pBtns, java.awt.BorderLayout.CENTER);

        getContentPane().add(pFundoGeral, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboAActionPerformed

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
            java.util.logging.Logger.getLogger(frmCalender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCalender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCalender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCalender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCalender().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboA;
    private javax.swing.JComboBox<String> cboM;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lb;
    private javax.swing.JPanel pBtns;
    private javax.swing.JPanel pFundoGeral;
    private javax.swing.JSpinner spinnerM;
    // End of variables declaration//GEN-END:variables

    void carregarCBOs() {
        for (int i = 1; i <= 12; i++) {
            cboM.addItem(dh.mesPorExtenco(i));
        }
        val.addNumerosNaCbo(cboA, 1980, dh.getAno() + 40);
        val.poeTxt(cboA, "" + ano);
        val.poeTxt(cboM, dh.mesPorExtenco(mes));
        criaBtns();
        evts();
    }

    void msg(String msg) {
        val.msg(null, msg);
    }

    ArrayList<JButton> btns = new ArrayList<>();

    void getBtns() {
//        String a = "";
//        for (Object o :  pBtns.getComponents() ) {  
//            btns.add((JButton)o);
//            a+=" - "+((JButton)o).getName();
//        }
//        msg(a);
    }

    private void criaBtns() {
        mes = dh.mesPorNumero(val.pegaTxt(cboM));
        poe(mes - 1);
        poe(mes);
    }

    void poe(int mes) {
        pBtns.removeAll();
        ano = val.e_int(val.pegaTxt(cboA));
        if (ano == 0) {
            ano = dh.getAno();
            val.poeTxt(cboA, "" + ano);
        }
        pBtns.setLayout(new GridLayout(6, 7, 2, 2));
        int qd = dh.quantDiasDoMes(mes, ano);
        int inicio = dh.getDiaStr(dia, mes, ano);
        String data = mes_01(dia) + "/" + mes_01(mes) + "/" + ano;
        pBtns.removeAll();
        inicio = dh.getDiaStr(dia, mes - 1, ano);
        int k = 0;
        for (int i = 0; i < inicio - 1; i++) {
            pBtns.add(new javax.swing.JLabel());
            k++;
        }
        k += 1;
        for (int i = 1; k < 42; i++) {
            if (i > 0 && i <= qd) {
                JButton btn = on_click_dia(new javax.swing.JButton(), i);
                if (k == 1 || k == 8 || k == 15 || k == 22 || k == 29 || k == 36) {
                    btn.setOpaque(true);
                    btn.setBackground(new Color(255, 132, 90));
                }
                pBtns.add(btn);
            } else {
                pBtns.add(new javax.swing.JLabel(""));
            }
            k++;
        }
        lb.setText("" + data);
    }

    String mes_01(int m) {
        if (m < 10) {
            return "0" + m;
        }
        return "" + m;
    }

    private JButton on_click_dia(JButton btn, int i) {
        // = new javax.swing.JButton();
        String d = "" + i;
        if (i < 10) {
            d = "0" + i;
        }
        btn.setName("btn_" + d);
        btn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btn.setText("" + d);
        btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dia = val.e_int(btn.getText());
                mes = dh.mesPorNumero(val.pegaTxt(cboM));
                ano = val.e_int(val.pegaTxt(cboA));
                if (ano == 0) {
                    ano = dh.getAno();
                    val.poeTxt(cboA, "" + ano);
                }
//                msg("" + dh.getDiaStr(dia, mes - 1, ano));
                String data = mes_01(dia) + "/" + mes_01(mes) + "/" + ano;
                val.poeTxt(lb, data);
                val.poeTxt(txtField, data);
                frm.setEnabled(true);
                dispose();
            }
        });
        return btn;
    }

    void evts() {
        cboA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                criaBtns();
            }
        });
        cboM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                criaBtns();
            }
        });
        spinnerM.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                Spinner(true);
            }
        });
        spinnerM.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Spinner(false);
            }
        });
    }

    void Spinner(boolean isWhill) {
        int swm = (int) spinnerM.getValue();
        if (isWhill) {
            swm++;
        }
        if (swm < 1) {
            swm = 12;
        }
        if (swm > 12) {
            swm = 1;
        }
        cboM.setSelectedIndex(swm - 1);
        spinnerM.setValue(swm);

    }
}
