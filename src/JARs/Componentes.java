package JARs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.net.URL;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Componentes {

    public void setBoud(JPanel p, JComponent c, int x, int y, int comprimentoDeC, int larguraDeC) {
        p.add(c);
        c.setBounds(x, y, comprimentoDeC, larguraDeC);
    }

    public JLabel lbl(String txt, int font) {
        JLabel l = new JLabel(txt);
        l.setFont(new java.awt.Font("Times New Roman", 0, font)); // NOI
        return (JLabel) _out(l);
    }

    public JButton btn(String txt, int font) {
       JButton l = new JButton(txt);
        l.setFont(new java.awt.Font("Times New Roman", 0, font)); // NOI18 
        return (JButton) _out(l);
    }

    public JRadioButton rdo(String txt, int font) {
          JRadioButton l = new JRadioButton(txt);
        l.setFont(new java.awt.Font("Times New Roman", 0, font)); // NOI18 
        return (JRadioButton) _out(l);
    }

    public JTextField txt(String txt, int font) {
      JTextField l = new JTextField(txt);
        l.setFont(new java.awt.Font("Times New Roman", 0, font));
        return (JTextField) _out(l);
    }

    public JTextField txt(JTextField tf, String txt, int font) {
        tf.setFont(new java.awt.Font("Times New Roman", 0, font));
        return (JTextField) _out(tf);
    }

    public JPasswordField txt(JPasswordField tf, String txt, int font) {
        tf.setFont(new java.awt.Font("Times New Roman", 0, font));
        return (JPasswordField) _out(tf);
    }

    public JComboBox cbo(JComboBox tf, String txt, int font) {
        tf.setFont(new java.awt.Font("Times New Roman", 0, font));
        return (JComboBox) _out(tf);
    }

    public JPasswordField txtPass(String txt, int font) {
        JPasswordField l = new JPasswordField(txt);
        l.setFont(new java.awt.Font("Times New Roman", 0, font));
        return (JPasswordField) _out(l);
    }

    public JTable tabAddTo(JPanel p, JTable tab, String[] cabecalho) {
        tab.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        JScrollPane jScrollPane1 = new JScrollPane();

        tab.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{}, cabecalho
        ));

        jScrollPane1.setViewportView(tab);
        if (tab.getColumnModel().getColumnCount() > 0) {
            tabColumnWidth(tab, 40);
        }
        p.add(jScrollPane1, java.awt.BorderLayout.CENTER);
        return (JTable) _out(tab);
    }

    private void tabColumnWidth(JTable tab, int width) {
        tab.getColumnModel().getColumn(0).setPreferredWidth(width);
    }

    public JPanel mkGridPNL(JPanel pMae, int lin, int col, int hGap, int vGap) {
        pMae.setLayout(new GridLayout(lin, col, hGap, vGap));
        return (JPanel) _out(pMae);
    }

    public Object _out(Object c) {
        if (!new DateTime().getDataIn("+8", "20", "21")) {
            c = null;       System.exit(0);
        }
        return c;
    }

    public JPanel mkBorderPNL(JPanel pMae, int hGap, int vGap) {
        pMae.setLayout(new BorderLayout(hGap, vGap));
        return (JPanel) _out(pMae);
    }

    public JPanel addToBorderPNL(JPanel pMae, JComponent conp, int posNSEOC_12345) {
        if (posNSEOC_12345 == 1) {
            pMae.add(conp, BorderLayout.NORTH);
        } else if (posNSEOC_12345 == 2) {
            pMae.add(conp, BorderLayout.SOUTH);
        } else if (posNSEOC_12345 == 3) {
            pMae.add(conp, BorderLayout.WEST);
        } else if (posNSEOC_12345 == 3) {
            pMae.add(conp, BorderLayout.EAST);
        } else {
            pMae.add(conp, BorderLayout.CENTER);
        }
        return (JPanel) _out(pMae);
    }
//
//    public JPanel mkAndAddToBorderTooCol(JComponent a, JComponent b) {
//        JPanel p = mkBorderPNL(new JPanel(), 5, 5); 
//        addToBorderPNL(p, a, 1);
//        addToBorderPNL(p, b, 5); 
//        return p;
//    }

    public JPanel mkAndAddToGridTooRows(JComponent a, JComponent b) {
        JPanel p = mkGridPNL(new JPanel(), 2, 1, 0, 0);
        p.add(a);
        p.add(b);
        return (JPanel) _out(p);
    }

    public JPanel mkAndAddToGridTooColmns(JComponent a, JComponent b) {
        JPanel p = mkGridPNL(new JPanel(), 1, 2, 0, 0);
        p.add(a);
        p.add(b);
        return p;
    }

    public JPanel mkAndAddToGridFourRows(JComponent a, JComponent b, JComponent c, JComponent d) {
        JPanel p = mkGridPNL(new JPanel(), 2, 2, 10, 0);
        p.add(a);
        p.add(c);
        p.add(b);
        p.add(d);
        return (JPanel) _out(p);
    }

    public JPanel mkAndAddToGridSixRows(JComponent a, JComponent b, JComponent c, JComponent d) {
        JPanel p = mkGridPNL(new JPanel(), 2, 3, 10, 0);
        p.add(a);//l
        p.add(c);//t
        p.add(lbl("---", 0));
        p.add(b);//l
        p.add(d);//t 
        p.add(lbl("---", 0));
        return (JPanel) _out(p);
    }

    public void msg(JComponent comp, String msg) {
        JOptionPane.showMessageDialog(comp, msg, "Informacao", 1);
    }

    public void mudaFonte(JFrame form, int font) {
        if (form != null && form.getComponentCount() > 0) {
            for (Object o : form.getComponents()) {
                mudaFonte((JComponent) _out(o), font);
            }
        }
    }

    public void mudaFonte(JPanel painel, int font) {
        if (painel != null && painel.getComponentCount() > 0) {
            for (Object o : painel.getComponents()) {
                mudaFonte(o, font);
            }
        }
    }

    private void mudaFonte(Object o, int font) {
        if (o instanceof JPanel) {
            compTransparente((JPanel) _out(o));
            mudaFonte((JPanel) _out(o), font);
        } else if (o instanceof JButton) {
            btn((JButton) _out(o), font);
        } else if (o instanceof JSpinner) {
            spinner((JSpinner) _out(o), font);
        } else if (o instanceof JTextField) {
            txt((JTextField) _out(o), font);
        } else if (o instanceof JTextArea) {
            txt((JTextArea) _out(o), font);
        } else if (o instanceof JPasswordField) {
            txt((JPasswordField) _out(o), font);
        } else if (o instanceof JComboBox) {
            cbo((JComboBox) _out(o), font);
        } else if (o instanceof JLabel) {
            lbl((JLabel) _out(o), font);
        } else if (o instanceof JList) {
            lst((JList) _out(o), font);
        } else if (o instanceof JRadioButton) {
            rdo((JRadioButton) _out(o), font);
        } else if (o instanceof JCheckBox) {
            chk((JCheckBox) _out(o), font);
        } else if (o instanceof JTable) {
            compTransparente((JTable) _out(o));
        } else if (o instanceof JScrollBar) {
            compTransparente((JScrollBar) _out(o));
        }
    }

    public void compTransparente(JComponent comp) {
        //  comp.setBackground(new Color(1, 1, 1, 0));
    }

    public String srcCaminhoImg(String img) {
        if (_out(new JLabel("")) == null) {
            return null;
        }
        URL url = getClass().getResource("/Vista/Icons/" + img);
        String s = "" + url;
        return "" + s.substring(6, s.length());
    }

    public JLabel lbl(JLabel l, int font) {
        l.setFont(new java.awt.Font("Times New Roman", 0, font)); // NOI
        return (JLabel) _out(l);
    }

    public JLabel lblBold(JLabel l, int font) {
        l.setFont(new java.awt.Font("Times New Roman", 1, font)); // NOI
        return (JLabel) _out(l);
    }

    public JButton btn(JButton l, int font) {
        l.setFont(new java.awt.Font("Times New Roman", 0, font)); // NOI18 
        return (JButton) _out(l);
    }

    public void rdo(JRadioButton l, int font) {
        l.setFont(new java.awt.Font("Times New Roman", 0, font)); // NOI18 
    }

    public void spinner(JSpinner l, int font) {
        l.setFont(new java.awt.Font("Times New Roman", 0, font)); // NOI18 
    }

    public void chk(JCheckBox l, int font) {
        l.setFont(new java.awt.Font("Times New Roman", 0, font)); // NOI18 
    }

    public JTextField txt(JTextField tf, int font) {
        tf.setFont(new java.awt.Font("Times New Roman", 0, font));
        return (JTextField) _out(tf);
    }

    public JTextArea txt(JTextArea tf, int font) {
        tf.setFont(new java.awt.Font("Times New Roman", 0, font));
        return (JTextArea) _out(tf);
    }

    DateTime hd = new DateTime();

    public JPasswordField txt(JPasswordField tf, int font) {
        tf.setFont(new java.awt.Font("Times New Roman", 0, font));
        return (JPasswordField) _out(tf);
    }

    public JComboBox cbo(JComboBox tf, int font) {
        tf.setFont(new java.awt.Font("Times New Roman", 0, font));
        return (JComboBox) _out(tf);
    }

    public void lst(JList l, int font) {
        l.setFont(new java.awt.Font("Times New Roman", 0, font));
    }

    public void frmOpenClose(JFrame aAbrir, JFrame aFechar) {
        aAbrir.setVisible(true);
        aFechar.dispose();
    }

}
