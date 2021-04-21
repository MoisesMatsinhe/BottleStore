/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JARs;
 
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Marondo
 */
public class Eventos {

    Validacoes val = new Validacoes();
    Componentes c = new Componentes();

    public final void focoInOut(JTextField tf, String txtPadrao) {
        tf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (tf.getText().equalsIgnoreCase(txtPadrao)) {
                    tf.setText("");
                    tf.setForeground(Color.BLACK);
                }
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                if (tf.getText().length() == 0) {
                    tf.setText(txtPadrao);
                    tf.setForeground(new Color(153, 153, 153));
                }
            }
        });
    }

    public final void focoInOut(JComboBox cbo, String txtPadrao) {
        cbo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (val.pegaTxt(cbo).equalsIgnoreCase(txtPadrao)) {
                    val.poeTxt(cbo, "");
                    cbo.setForeground(Color.BLACK);
                }
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                if (val.pegaTxt(cbo).length() == 0) {
                    val.poeTxt(cbo, txtPadrao);
                    cbo.setForeground(new Color(153, 153, 153));
                }
            }
        });
    }

    public void lblFoco(JComponent comp, JComponent l, boolean in, int f_in, int f_OutSomar, Color corIN, Color corOUT) {
        if (in) {
            l.setFont(new Font("Monospaced", 1, f_in));
            comp.setBackground(corIN);
        } else {
            l.setFont(new Font("Monospaced", 1, (f_in - f_OutSomar)));
            comp.setBackground(corOUT);
        }
    }

    public void licarPara(JComponent comp, String link) {
        try {
            Runtime.getRuntime().exec("cmd.exe /C start " + link);
        } catch (IOException ex) {
            val.msg(null,"Problemas ao aceder o link.\n" + ex.getMessage());
        }
    }

    public void mouseInOut(JComponent comp, boolean in, int f_in, int f_OutSomar, Color corIN, Color corOUT) {
        comp.addMouseListener(new java.awt.event.MouseAdapter() {
            //    public void mouseClicked(java.awt.event.MouseEvent evt) {
            //  }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblFoco(comp, comp, true, f_in, f_OutSomar, corIN, corOUT);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblFoco(comp, comp, false, f_in, f_OutSomar, corIN, corOUT);
            }
        });
    }

    public void lblEventos(JPanel pParent, JLabel lblDeTexto, JLabel lblImg, String imgPadrao) {
        pParent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
               // lblEventosManipulaEvt(pParent, lblDeTexto, lblImg, evt.getID(), imgPadrao);
                 lblEventosManipulaEvt(pParent, lblDeTexto, lblImg, 505, imgPadrao);
           }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblEventosManipulaEvt(pParent, lblDeTexto, lblImg, evt.getID(), imgPadrao);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblEventosManipulaEvt(pParent, lblDeTexto, lblImg, evt.getID(), imgPadrao);
            }
        });
    }

    private void lblEventosManipulaEvt(JPanel pParent, JLabel lblDeTexto, JLabel lblImg, int evt, String imgPadrao) {
        if (evt == 504) {//[Entered] ~ID: 504 
            if (pParent.getBackground()==Color.GREEN) {
                return;
            }
            pParent.setBackground(new Color(113, 159, 212));
            lblDeTexto = c.lbl(lblDeTexto.getText(), lblDeTexto.getFont().getSize() + 4);
            lblImg.setIcon(new ImageIcon(val.srcCaminhoAnyFile("/Icons/hover/cursor.png")));
        } else if (evt == 505) {//[Exited] ~ID: 505 
            if (pParent.getBackground()==Color.GREEN) {
                return;
            }
            pParent.setBackground(new Color(170, 193, 233));
            lblDeTexto = c.lbl(lblDeTexto.getText(), lblDeTexto.getFont().getSize() - 4);
            lblImg.setIcon(new ImageIcon(val.srcCaminhoAnyFile("/Icons/hover/" + imgPadrao)));
        } else if (evt == 500) {//[Click] ~ID: 500
            pParent.setBackground(Color.GREEN);
            lblDeTexto = c.lbl(lblDeTexto.getText(), lblDeTexto.getFont().getSize() + 4);
            lblImg.setIcon(new ImageIcon(val.srcCaminhoAnyFile("/Icons/hover/" + imgPadrao)));
        }
    }
}
