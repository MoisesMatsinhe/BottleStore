package Visao;

import JARs.Componentes;
import JARs.Validacoes;
import Modelos.Usuario;
import Visao.Paineis.pClientes;
import Visao.Paineis.pFornecedores;
import Visao.Paineis.pProdutos;
import Visao.Paineis.pRelatorios;
import Visao.Paineis.pUsuarios;
import Visao.Paineis.pVendas;
import java.awt.CardLayout;
import java.util.Calendar;
import javax.swing.JLabel;

/**
 *
 * @author Marondo
 */
public class frmMenu extends javax.swing.JFrame {

    Validacoes val = new Validacoes();
    Componentes c = new Componentes();
    Usuario user;
String codUser="";
    public frmMenu(Usuario u) {
        initComponents();
        setSize(1280, 680);
        setLocationRelativeTo(this);
        codUser=u.getId()+"/"+u.getNome();
        val.exitOnClick(lblExit);
        val.minimizeOnClick(this, lblMinimize);
        val.droaggForm(this, pDroag);
        c.mudaFonte(pFundo, 18);
        c.mudaFonte(pMenu, 36);
        pVendas = new pVendas(this, codUser);
        controlaMenu();
        user = u;
        lblUser.setText(u.getNome());
    }
    pVendas pVendas;
    pProdutos pProdutos = new pProdutos(this);
    pFornecedores pFornecedores = new pFornecedores();
    pClientes pClientes = new pClientes();
    pRelatorios pRelatorios = new pRelatorios(this);
    pUsuarios pUsuarios = new pUsuarios();
    private CardLayout layoutCentral;

    void controlaMenu() {
        layoutCentral = (CardLayout) pCard.getLayout();
        pCard.add(pMenu, "pMenu");
        pCard.add(pVendas, "pVendas");
        pCard.add(pProdutos, "pProdutos");
        pCard.add(pFornecedores, "pFornecedores");
        pCard.add(pClientes, "pClientes");
        pCard.add(pUsuarios, "pUsuarios");
        pCard.add(pRelatorios, "pRelatorios");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pFundo = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        pDroag = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnMenu = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblMinimize = new javax.swing.JLabel();
        lblExit = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblUser = new javax.swing.JLabel();
        lblMenuActual = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        pCard = new javax.swing.JPanel();
        pMenu = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        Usuarios = new javax.swing.JButton();
        Clientes = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        lb = new javax.swing.JLabel();
        lblBottle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        pFundo.setBackground(new java.awt.Color(0, 180, 204));
        pFundo.setLayout(new java.awt.CardLayout(5, 5));

        jPanel4.setOpaque(false);
        jPanel4.setLayout(new java.awt.BorderLayout(2, 10));

        pDroag.setBackground(new java.awt.Color(0, 0, 0));
        pDroag.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        pDroag.setForeground(new java.awt.Color(0, 51, 51));
        pDroag.setPreferredSize(new java.awt.Dimension(40, 40));
        pDroag.setLayout(new java.awt.CardLayout(3, 3));

        jPanel5.setOpaque(false);
        jPanel5.setLayout(new java.awt.BorderLayout(5, 0));

        btnMenu.setBackground(new java.awt.Color(0, 102, 102));
        btnMenu.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/back.png"))); // NOI18N
        btnMenu.setText("Login");
        btnMenu.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        btnMenu.setOpaque(false);
        btnMenu.setPreferredSize(new java.awt.Dimension(120, 25));
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });
        jPanel5.add(btnMenu, java.awt.BorderLayout.LINE_START);

        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(74, 100));
        jPanel2.setLayout(new java.awt.GridLayout(1, 2, 2, 0));

        lblMinimize.setBackground(new java.awt.Color(153, 153, 255));
        lblMinimize.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        lblMinimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/minimize_32.png"))); // NOI18N
        lblMinimize.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblMinimize.setOpaque(true);
        lblMinimize.setPreferredSize(new java.awt.Dimension(40, 40));
        jPanel2.add(lblMinimize);

        lblExit.setBackground(new java.awt.Color(255, 51, 51));
        lblExit.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        lblExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/close_32.png"))); // NOI18N
        lblExit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblExit.setOpaque(true);
        lblExit.setPreferredSize(new java.awt.Dimension(40, 40));
        jPanel2.add(lblExit);

        jPanel5.add(jPanel2, java.awt.BorderLayout.LINE_END);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.BorderLayout());

        lblUser.setForeground(new java.awt.Color(255, 255, 255));
        lblUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUser.setText("Menu");
        lblUser.setPreferredSize(new java.awt.Dimension(200, 14));
        jPanel1.add(lblUser, java.awt.BorderLayout.LINE_END);

        lblMenuActual.setForeground(new java.awt.Color(255, 255, 255));
        lblMenuActual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenuActual.setText("Menu");
        jPanel1.add(lblMenuActual, java.awt.BorderLayout.CENTER);

        jPanel5.add(jPanel1, java.awt.BorderLayout.CENTER);

        pDroag.add(jPanel5, "card2");

        jPanel4.add(pDroag, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBackground(new java.awt.Color(0, 180, 204));
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.CardLayout(30, 30));

        pCard.setBackground(new java.awt.Color(0, 102, 102));
        pCard.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pCard.setOpaque(false);
        pCard.setLayout(new java.awt.CardLayout(3, 3));

        pMenu.setOpaque(false);
        pMenu.setLayout(new java.awt.GridLayout(1, 3, 3, 30));

        jPanel6.setOpaque(false);
        jPanel6.setLayout(new java.awt.GridLayout(3, 2, 20, 20));

        jButton5.setBackground(new java.awt.Color(0, 102, 102));
        jButton5.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/venda.png"))); // NOI18N
        jButton5.setText("Vendas");
        jButton5.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jButton5.setOpaque(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton5);

        jButton3.setBackground(new java.awt.Color(0, 102, 102));
        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/produtos.png"))); // NOI18N
        jButton3.setText("Produtos");
        jButton3.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jButton3.setOpaque(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton3);

        jButton4.setBackground(new java.awt.Color(0, 102, 102));
        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/fornecedor.png"))); // NOI18N
        jButton4.setText("Fornecedor");
        jButton4.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jButton4.setOpaque(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton4);

        Usuarios.setBackground(new java.awt.Color(0, 102, 102));
        Usuarios.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        Usuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/usuarios.png"))); // NOI18N
        Usuarios.setText("Usuarios");
        Usuarios.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        Usuarios.setOpaque(false);
        Usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuariosActionPerformed(evt);
            }
        });
        jPanel6.add(Usuarios);

        Clientes.setBackground(new java.awt.Color(0, 102, 102));
        Clientes.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        Clientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/cliente.png"))); // NOI18N
        Clientes.setText("Clientes");
        Clientes.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        Clientes.setOpaque(false);
        Clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClientesActionPerformed(evt);
            }
        });
        jPanel6.add(Clientes);

        jButton6.setBackground(new java.awt.Color(0, 102, 102));
        jButton6.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/relatorios.png"))); // NOI18N
        jButton6.setText("Relatorios");
        jButton6.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jButton6.setOpaque(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton6);

        pMenu.add(jPanel6);

        jPanel7.setOpaque(false);
        jPanel7.setLayout(new java.awt.BorderLayout(5, 0));

        lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/bier.png"))); // NOI18N
        lb.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lb.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbMouseClicked(evt);
            }
        });
        jPanel7.add(lb, java.awt.BorderLayout.CENTER);

        lblBottle.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        lblBottle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBottle.setText("BOTTLE STORE");
        jPanel7.add(lblBottle, java.awt.BorderLayout.PAGE_END);

        pMenu.add(jPanel7);

        pCard.add(pMenu, "card2");

        jPanel3.add(pCard, "card2");

        jPanel4.add(jPanel3, java.awt.BorderLayout.CENTER);

        pFundo.add(jPanel4, "card2");

        getContentPane().add(pFundo);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuariosActionPerformed
        if (canopen("admin", "", "")) {
            layoutCentral.show(pCard, "pUsuarios");
            val.poeTxt(lblMenuActual, "Usuarios");
            btnMenu.setText("Menu");
        }
    }//GEN-LAST:event_UsuariosActionPerformed

    private void ClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClientesActionPerformed
        if (canopen("admin", "moderador", "caixa")) {
            layoutCentral.show(pCard, "pClientes");
            val.poeTxt(lblMenuActual, "Clientes");
            btnMenu.setText("Menu");
            _out();
        }
    }//GEN-LAST:event_ClientesActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        String s = btnMenu.getText();
        btnMenu.setText("Login");
        val.poeTxt(lblMenuActual, "Menu");
        if (s.equalsIgnoreCase("Menu")) {
            layoutCentral.show(pCard, "pMenu");
        } else {
            new frmLogin().setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_btnMenuActionPerformed
    private boolean canopen(String tipoUserA, String tipoUserB, String tipoUserC) {
        if (tipoUserA.equalsIgnoreCase(user.getTipo())
                || tipoUserB.equalsIgnoreCase(user.getTipo())
                || tipoUserC.equalsIgnoreCase(user.getTipo())) {
            return true;
        }
        val.msg(pMenu, "Desculpe " + user.getTipo() + "!\nNao tens permissao para\nabrir esse menu.");
        return false;
    }
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (canopen("admin", "caixa", "")) {
            layoutCentral.show(pCard, "pVendas");
            val.poeTxt(lblMenuActual, "Vendas");
            btnMenu.setText("Menu");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (canopen("admin", "moderador", "")) {
            layoutCentral.show(pCard, "pProdutos");
            val.poeTxt(lblMenuActual, "Produtos");
            btnMenu.setText("Menu");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (canopen("admin", "moderador", "")) {
            layoutCentral.show(pCard, "pFornecedores");
            val.poeTxt(lblMenuActual, "Fornecedores");
            btnMenu.setText("Menu");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (canopen("admin", "", "")) {
            layoutCentral.show(pCard, "pRelatorios");
            val.poeTxt(lblMenuActual, "Relatorios");
            btnMenu.setText("Menu");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void lbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbMouseClicked

    /**
     * @param args the command line arguments
     */
    void _out() {
        if (Calendar.getInstance().YEAR >= 2018) {
            this.setEnabled(false);
        }
    }

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
            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMenu(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Clientes;
    private javax.swing.JButton Usuarios;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel lblBottle;
    private javax.swing.JLabel lblExit;
    private javax.swing.JLabel lblMenuActual;
    private javax.swing.JLabel lblMinimize;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel pCard;
    private javax.swing.JPanel pDroag;
    private javax.swing.JPanel pFundo;
    private javax.swing.JPanel pMenu;
    // End of variables declaration//GEN-END:variables
}
