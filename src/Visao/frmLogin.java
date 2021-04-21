package Visao;

import Controles.ControlaUsuario;
import JARs.Componentes;
import JARs.Validacoes;
import Modelos.Usuario;
import java.awt.Color;

public class frmLogin extends javax.swing.JFrame {

    Validacoes val = new Validacoes();
    ControlaUsuario con = new ControlaUsuario();
    Componentes c = new Componentes();

    /**
     * Creates new form Login
     */
    public frmLogin() {
        initComponents();
        setSize(317, 392);
        setLocationRelativeTo(null);
        val.droaggForm(this, pNort);
        c.mudaFonte(this, 18);
        val.mouseInOutComp(lblEntrar, 20, 18, Color.black, Color.black, new Color(0, 102, 102), new Color(0, 210, 204));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pFundo = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        pNort = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        jPanel10 = new javax.swing.JPanel();
        lblEntrar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new java.awt.BorderLayout(2, 2));

        pFundo.setBackground(new java.awt.Color(51, 0, 51));
        pFundo.setLayout(new java.awt.CardLayout(2, 2));

        jPanel1.setLayout(new java.awt.BorderLayout(2, 2));

        pNort.setBackground(new java.awt.Color(0, 102, 102));
        pNort.setPreferredSize(new java.awt.Dimension(313, 180));
        pNort.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pNortMouseDragged(evt);
            }
        });
        pNort.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pNortMousePressed(evt);
            }
        });
        pNort.setLayout(new java.awt.BorderLayout());

        jPanel9.setBackground(new java.awt.Color(0, 0, 0));
        jPanel9.setOpaque(false);
        jPanel9.setPreferredSize(new java.awt.Dimension(60, 160));

        jLabel1.setBackground(new java.awt.Color(255, 102, 51));
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/close_32.png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 0, 51)));
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.setOpaque(true);
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 24, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 148, Short.MAX_VALUE))
        );

        pNort.add(jPanel9, java.awt.BorderLayout.LINE_END);

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));
        jPanel5.setOpaque(false);
        jPanel5.setLayout(new java.awt.BorderLayout(2, 2));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/keys1.png"))); // NOI18N
        jPanel5.add(jLabel7, java.awt.BorderLayout.CENTER);

        jPanel11.setBackground(new java.awt.Color(0, 0, 0));
        jPanel11.setMinimumSize(new java.awt.Dimension(0, 30));
        jPanel11.setOpaque(false);
        jPanel11.setPreferredSize(new java.awt.Dimension(253, 26));
        jPanel11.setLayout(new java.awt.GridLayout(1, 3, 3, 0));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("         Bottle Strore");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel2.setPreferredSize(new java.awt.Dimension(128, 43));
        jPanel11.add(jLabel2);

        jPanel5.add(jPanel11, java.awt.BorderLayout.PAGE_START);

        pNort.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel1.add(pNort, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(0, 180, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 153)));
        jPanel2.setLayout(new java.awt.CardLayout(30, 3));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setOpaque(false);
        jPanel6.setLayout(new java.awt.GridLayout(3, 0, 0, 10));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 204, 153)));
        jPanel7.setOpaque(false);
        jPanel7.setLayout(new java.awt.GridLayout(2, 0, 0, 2));

        jLabel4.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jLabel4.setText("Nome  de usuário");
        jPanel7.add(jLabel4);

        txtUser.setBackground(new java.awt.Color(255, 245, 255));
        txtUser.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        txtUser.setBorder(null);
        jPanel7.add(txtUser);

        jPanel6.add(jPanel7);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 204, 153)));
        jPanel8.setOpaque(false);
        jPanel8.setLayout(new java.awt.GridLayout(2, 0, 0, 2));

        jLabel5.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jLabel5.setText("Senha de usuário");
        jPanel8.add(jLabel5);

        txtPass.setBackground(new java.awt.Color(255, 245, 255));
        txtPass.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        txtPass.setBorder(null);
        jPanel8.add(txtPass);

        jPanel6.add(jPanel8);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setOpaque(false);
        jPanel10.setLayout(new java.awt.CardLayout(50, 10));

        lblEntrar.setBackground(new java.awt.Color(0, 210, 204));
        lblEntrar.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        lblEntrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEntrar.setText("ENTRAR");
        lblEntrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 153)));
        lblEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblEntrar.setOpaque(true);
        lblEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEntrarMouseClicked(evt);
            }
        });
        jPanel10.add(lblEntrar, "card2");

        jPanel6.add(jPanel10);

        jPanel2.add(jPanel6, "card2");

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        pFundo.add(jPanel1, "card2");

        getContentPane().add(pFundo, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pNortMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pNortMousePressed

    }//GEN-LAST:event_pNortMousePressed

    private void pNortMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pNortMouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_pNortMouseDragged

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void lblEntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEntrarMouseClicked
        Usuario u = con.logar(txtUser.getText(), new String(txtPass.getPassword()));
        if (u != null) {
            new frmMenu(u).setVisible(true);
            dispose();
        } else {
            val.msg(null, "User ou senha incorrecto");
        }
    }//GEN-LAST:event_lblEntrarMouseClicked

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
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new frmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lblEntrar;
    private javax.swing.JPanel pFundo;
    private javax.swing.JPanel pNort;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
