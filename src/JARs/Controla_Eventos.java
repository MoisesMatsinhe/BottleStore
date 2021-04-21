/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JARs;

import java.awt.Color;
import java.awt.Font; 
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Marondo
 */
public class Controla_Eventos {

    public void foco_JComponent(JComponent l, boolean in, int f_in, int f_OutSomar) {
        if (in) {
            l.setBackground(new Color(0, 153, 153));
            l.setFont(new Font("Times New Roman", 1, f_in));
        } else {
            l.setBackground(new Color(0, 102, 102));
            l.setFont(new Font("Times New Roman", 1, (f_in + f_OutSomar)));
        }
    }

    public void foco_JComponentB(JComponent l, boolean in, int f_in, int f_OutSomar) {
        if (in) {
            l.setFont(new Font("Times New Roman", 1, f_in));
        } else {
            l.setFont(new Font("Times New Roman", 1, (f_in + f_OutSomar)));
        }
    }

    public void lblFoco(JLabel l, boolean in, int f_in, int f_OutSomar) {
        if (in) {
            l.setBackground(new Color(0, 153, 153));
            l.setFont(new Font("Times New Roman", 1, f_in));
        } else {
            l.setBackground(new Color(0, 51, 70));
            l.setFont(new Font("Times New Roman", 1, (f_in - f_OutSomar)));
        }
    }

    public void controlaEnter(JComponent c, int i) {
        if (i == 10) {
            c.requestFocus();
        }
    }

    public JComponent comp_borders(JComponent c, Color cor, int f, int n_1s_2e_3o_4) {
        switch (n_1s_2e_3o_4) {
            case 1: {
                c.setBorder(BorderFactory.createMatteBorder(f, 0, 0, 0, cor));
            }
            break;
            case 2: {
                c.setBorder(BorderFactory.createMatteBorder(0, 0, f, 0, cor));
            }
            break;
            case 3: {
                c.setBorder(BorderFactory.createMatteBorder(0, 0, 0, f, cor));
            }
            break;
            case 4: {
                c.setBorder(BorderFactory.createMatteBorder(0, f, 0, 0, cor));
            }
            break;
            default: {
                c.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, cor));
            }
        }
        return c;
    }

    public void mouseClicked(JComponent comp, int corA, int corB, int corC) {
        do {
            try {
                comp.setBackground(new Color(51, 0, 0));
                Thread.sleep(100);
                //JOptionPane.showMessageDialog(null, 1212);
                comp.setBackground(new Color(corA, corB, corC));
                break;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro de No alterar imagens" + e);
            }
        } while (true);

    }

    public JComponent componente_Comp_Nome_Tamanho_Cor(JComponent c, String nomeFonte, int f, Color cor) {
        c.setFont(new Font(nomeFonte, Font.BOLD, f));
        c.setForeground(cor);
        return c;
    }

    public void mudaTema(JFrame c, int i) {
        try {
            switch (i) {
                case 1: {
                    UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");//BONITO
                    SwingUtilities.updateComponentTreeUI(c);
                }
                break;
                case 2: {
                    UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");//BONITO redondo  
                    SwingUtilities.updateComponentTreeUI(c);
                }
                break;
                case 3: {
                    UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");//BONITO redondo 2
                    SwingUtilities.updateComponentTreeUI(c);
                }
                break;
                case 4: {
                    UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
                    SwingUtilities.updateComponentTreeUI(c);
                }
                break;
                case 5: {
                    UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
                    SwingUtilities.updateComponentTreeUI(c);
                }
                break;
                case 6: {
                    UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
                    SwingUtilities.updateComponentTreeUI(c);
                }
                break;
                case 7: {
                    UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
                    SwingUtilities.updateComponentTreeUI(c);
                }
                break;
                case 8: {
                    UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
                    SwingUtilities.updateComponentTreeUI(c);
                }
                break;
                case 9: {
                    UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
                    SwingUtilities.updateComponentTreeUI(c);
                }
                break;
                case 10: {
                    UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
                    SwingUtilities.updateComponentTreeUI(c);
                }
                break;
                case 11: {
                    UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
                    SwingUtilities.updateComponentTreeUI(c);
                }
                break;
                default: {
                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            //    JOptionPane.showMessageDialog(c, "Erro na escolha do tema!");
        }
    }
}
