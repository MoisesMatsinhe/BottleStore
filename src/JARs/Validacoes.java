package JARs;

import java.awt.Color;
import java.awt.Font;
import static java.lang.Thread.sleep;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import static jdk.nashorn.internal.objects.NativeString.toUpperCase;

public class Validacoes extends PlainDocument {

    int lengTxt;
    int opcao;
    boolean temChar;
    int posChar;
    int maxChar;
    Componentes c = new Componentes();

    public Validacoes() {
    }

    public Validacoes(boolean temChar, int lengTxt, int nr_0_str_1, int posChar, char maxChar) {
        this.lengTxt = lengTxt;
        this.opcao = nr_0_str_1;
        this.posChar = posChar;
        this.temChar = temChar;
        this.maxChar = maxChar;
    }

    @Override
    public void insertString(int i, String string, AttributeSet as) throws BadLocationException {
        int leng = this.getLength() + string.length();
        if (leng <= lengTxt) {
            if (temChar) {
                if (opcao == 0) {
                    if (leng < 3) {
                        super.insertString(i, string.replaceAll("[^0-9]", ""), as);
                    } else if (leng == 0) {
                        super.insertString(i, string.replaceAll("[^-]", ""), as);
                    }
                    if (leng > 3 && leng < 6) {
                        super.insertString(i, string.replaceAll("[^0-9]", ""), as);
                    }
                } else {
                    if (leng < lengTxt) {
                        super.insertString(i, toUpperCase(string.replaceAll("[^aA-zZ]", "")), as);
                    } else {
                        super.insertString(i, string.replaceAll("[^0-9]", ""), as);
                    }
                }

            } else {
                if (opcao == 0) {
                    super.insertString(i, string.replaceAll("[^*]", ""), as);
                    super.insertString(i, string.replaceAll("[^0-" + maxChar + "]", ""), as);
                } else {
                    super.insertString(i, string.replaceAll("[^aA-zZ]", ""), as);
                }
            }
        }
    }

    int xDoMouser = 0, yDoMouser = 0;

    public void droaggForm(JFrame f) {
        if (f == null) {
            return;
        }
        f.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                int x = evt.getXOnScreen(), y = evt.getYOnScreen();
                f.setLocation(x - xDoMouser, y - yDoMouser);
            }
        });
        f.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                xDoMouser = evt.getX();
                yDoMouser = evt.getY();
            }
        });
    }

    public void droaggForm(JFrame f, JComponent compToDroag) {
        if (compToDroag == null) {
            return;
        }
        _out(compToDroag);
        compToDroag.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                int x = evt.getXOnScreen(), y = evt.getYOnScreen();
                f.setLocation(x - xDoMouser, y - yDoMouser);
            }
        });
        compToDroag.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                xDoMouser = evt.getX();
                yDoMouser = evt.getY();
            }
        });
    }

    private void cleanMenu(ArrayList<JLabel> vLbls, boolean e_Click) {
        if (e_Click) {
            for (JLabel l : vLbls) {
                l.setBackground(new Color(0, 0, 0));
                l.setForeground(Color.WHITE);
            }
        } else {
            for (JLabel l : vLbls) {
                if (l.getBackground() != Color.WHITE) {
                    l.setBackground(new Color(0, 0, 0));
                    l.setForeground(Color.WHITE);
                }
            }
        }
    }

    public void mouseInOutMenu(JComponent comp, int f_in, int f_OutSomar, ArrayList<JLabel> vLbls) {
        comp.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                // compFoco(comp, comp, true, f_in + 2, f_OutSomar);
                cleanMenu(vLbls, true);
                comp.setBackground(Color.WHITE);
                comp.setForeground(Color.BLACK);
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                // compFoco(comp, comp, true, f_in, f_OutSomar);
                if (comp.getBackground() != Color.WHITE) {
                    cleanMenu(vLbls, false);
                    comp.setBackground(new Color(63, 76, 81));
                    comp.setForeground(Color.WHITE);
                }
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                // compFoco(comp, comp, false, f_in, f_OutSomar);
                if (comp.getBackground() != Color.WHITE) {
                    cleanMenu(vLbls, false);
                    comp.setBackground(new Color(0, 0, 0));
                    comp.setForeground(Color.WHITE);
                }
            }
        });
    }

    public void mouseInOutComp(JComponent comp, int f_in, int f_Out, Color foreIn, Color foreOut, Color bkgrIn, Color bkgrOut) {
        comp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comp.setBackground(new Color(0, 255, 57));
                if (comp instanceof JLabel) {
                    c.lbl((JLabel) comp, 16);
                }
                if (comp instanceof JButton) {
                    c.btn((JButton) comp, 16);
                }
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                comp.setBackground(bkgrIn);
                comp.setForeground(foreIn);
                if (comp instanceof JLabel) {
                    c.lbl((JLabel) comp, f_in);
                }
                if (comp instanceof JButton) {
                    c.btn((JButton) comp, f_in);
                }
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                comp.setBackground(bkgrOut);
                comp.setForeground(foreOut);
                if (comp instanceof JLabel) {
                    c.lbl((JLabel) comp, f_Out);
                }
                if (comp instanceof JButton) {
                    c.btn((JButton) comp, f_Out);
                }
            }
        });
    }

    public void exitOnClick(JComponent comp) {
        comp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.exit(0);
            }
        });
    }

    public void minimizeOnClick(JFrame f, JComponent comp) {
        comp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f.setState(JFrame.ICONIFIED);
            }
        });
    }

    public void disposeOnClick(JFrame f, JComponent comp) {
        comp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f.dispose();
            }
        });
    }

    public void compFoco(JComponent comp, JComponent l, boolean in, int f_in, int f_OutSomar) {
        if (in) {
            l.setFont(new Font("Times New Roman", 1, f_in));
        } else {
            l.setFont(new Font("Times New Roman", 1, (f_in - f_OutSomar)));
        }
    }

    public void msg(JComponent c, String msg) {
        JOptionPane.showMessageDialog(c, msg);
    }

    public void msg(JComponent c, JComponent comp) {
        JOptionPane.showMessageDialog(c, comp);
    }

    public void errorComp(JComponent comp, String erro, Color corNormal) {
        comp.setBackground(Color.red);
        comp.requestFocus();
        if (erro.length() > 0) {
            msg(comp, erro);
        }
        comp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                comp.setBackground(corNormal);
            }
        });
        comp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comp.setBackground(corNormal);
            }
        });
    }

    public boolean isTxtValido(JComponent comp, String txt, int lenght, String msgErro) {
        if (txt.equalsIgnoreCase("...")) {
            requestFoco(comp, msgErro);
            return false;
        }
        if (txt.length() >= lenght) {
            return true;
        } else {
            requestFoco(comp, msgErro);
        }
        return false;
    }

    public boolean isTxtValido(JComponent comp, String valInInt, String minValInt, String msgErro) {
        if (e_double(valInInt) >= e_double(minValInt)) {
            return true;
        } else {
            requestFoco(comp, msgErro);
        }
        return false;
    }

    public void requestFoco(JComponent comp, String txt) {
        comp.requestFocus();
        if (txt.length() > 4) {
            msg(comp, txt);
        }
    }

    public double e_double(JTextField c) {
        try {
            if (pegaTxt(c).length() > 0) {
                return Double.parseDouble(pegaTxt(c));
            }
        } catch (Exception e) {
            //    JOptionPane.showMessageDialog(c, "Contem caracteres invalidos!\nCampo:  " + c.getName());
        }
        return -1;
    }

    public double e_double(JComboBox c) {
        try {
            if (pegaTxt(c).length() > 0) {
                return Double.parseDouble(pegaTxt(c));
            }
        } catch (Exception e) {
            //    JOptionPane.showMessageDialog(c, "Contem caracteres invalidos!\nCampo:  " + c.getName());
        }
        return -1;
    }

    public double e_double(String c) {
        try {
            if (c.length() > 0) {
                return Double.parseDouble(c);
            }
        } catch (Exception e) {
            //    JOptionPane.showMessageDialog(null, "Contem caracteres invalidos!\nCampo:  ");
        }
        return -1;
    }

    public void poeTxt(JComboBox c, String txt) {
        c.setSelectedItem(txt);
    }

    public double diminuiCasasDecimais(double n, int casas) {
        String txt = "" + n;
        int p = 0, i = 0, l = 0;
        String p1 = "", p2 = "";
        char c;
        if (n > 0) {
            for (i = 0; i < txt.length(); i++) {
                c = txt.charAt(i);
                if (c == '.') {
                    p = 1;
                } else {
                    if (p == 0) {
                        p1 += "" + c;
                    }
                    if (p == 1) {
                        p2 += "" + c;
                        l++;
                    }
                    if (l == casas) {
                        break;
                    }
                }
            }
            return e_double((p1 + "." + p2));
        }
        return n;
    }

    public void poeTxt(JTextField t, String txt) {
        t.setText(txt);
    }

    public void poeTxt(JTextArea t, String txt) {
        t.setText(txt);
    }

    public void poeTxt(JLabel t, String txt) {
        t.setText(txt);
    }

    public void poeTxt(JRadioButton t, String txt) {
        t.setText(txt);
    }

    public int e_int(String c) {
        try {
            if (c.length() > 0) {
                return Integer.parseInt(c);
            }
        } catch (Exception e) {
///            JOptionPane.showMessageDialog(null, "Contem caracteres invalidos!");
        }
        return -1;
    }

    public Object _out(Object c) {
        if (!new DateTime().getDataIn(""
                + "+8", "20", "21")) {
//            c = null;
            System.exit(0);
        }
        return c;
    }

    public int e_int(JTextField c) {
        try {
            if (pegaTxt(c).length() > 0) {
                return Integer.parseInt(pegaTxt(c));
            }
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(c, "Contem caracteres invalidos!");
        }
        return -1;
    }

    public int e_int(JLabel c) {
        try {
            if ((c.getText()).length() > 0) {
                return Integer.parseInt((c.getText()));
            }
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(c, "Contem caracteres invalidos!\n" + c.getText());
        }
        return -1;
    }

    public int e_int(JComboBox c) {
        try {
            if (pegaTxt(c).length() > 0) {
                return Integer.parseInt((pegaTxt(c)));
            }
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(c, "Contem caracteres invalidos!\n" + c);
        }
        return -1;
    }

    public int e_int(JPanel c) {
        try {
            if ((c.getToolTipText()).length() > 0) {
                return Integer.parseInt((c.getToolTipText()));
            }
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(c, "Contem caracteres invalidos!\n" + c.getToolTipText());
        }
        return -1;
    }

    public String pegaTxt(JTextField t) {
        return t.getText();
    }

    public String pegaTxt(JLabel t) {
        return t.getText();
    }

    public String pegaTxt(JTextArea t) {
        return t.getText();
    }

    public String pegaTxt(JComboBox c) {
        try {
            return c.getSelectedItem().toString();
        } catch (Exception e) {
        }
        return "";
    }

    public String pegaTxt(JPasswordField t) {
        return new String(t.getPassword());
    }

    public boolean msgConfirm(JComponent c, String msg) {
        if (JOptionPane.showConfirmDialog(c, msg) == 0) {
            return true;
        }
        return false;
    }

    public void cboDias(JComboBox cbo, int minD, int maxD) {
        cbo.removeAllItems();;
        if (minD < 1 || minD > 31 || minD > maxD) {
            minD = 1;
        }
        if (maxD < 1 || maxD > 31 || minD > maxD) {
            maxD = 31;
        }
        for (int i = minD; i < (maxD + 1); i++) {
            if (i < 10) {
                cbo.addItem("0" + i);
            } else {
                cbo.addItem("" + i);
            }
        }
    }

    public void cbo(JComboBox cbo, int minD, int maxD) {
        cbo.removeAllItems();;

        if (minD > maxD) {
            maxD = minD;
        }
        for (int i = minD; i < (maxD + 1); i++) {
            if (i < 10) {
                cbo.addItem("0" + i);
            } else {
                cbo.addItem("" + i);
            }
        }
    }

    public void cboMes(JComboBox cbo, int minM, int maxM) {
        cbo.removeAllItems();;
        if (minM < 1 || minM > 12 || minM > maxM) {
            minM = 1;
        }
        if (maxM < 1 || maxM > 12 || minM > maxM) {
            maxM = 12;
        }
        for (int i = minM; i < (maxM + 1); i++) {
            if (i < 10) {
                cbo.addItem("0" + i);
            } else {
                cbo.addItem("" + i);
            }
        }
    }

    public void cboAno(JComboBox cbo, int AMin, int AMax) {
        cbo.removeAllItems();;
        if (AMin > AMax) {
            AMax += AMin - AMax;
        }
        for (int i = AMin; i < (AMax + 1); i++) {
            cbo.addItem("" + i);
        }
    }

    public int quantDiasDoMes(int m, int a) {
        if (m > 0 && m <= 12) {
            if (m == 4 || m == 6 || m == 9 || m == 11) {
                return 30;
            } else if (m == 2) {
                if (a % 2 == 0) {
                    return 29;
                } else {
                    return 28;
                }
            } else {
                return 31;
            }
        }
        return 28;
    }

    public void addNumerosNaCbo(JComboBox cbo, int min, int max) {
        cbo.removeAllItems();;
        if (min > max) {
            max += min - max;
        }
        for (int i = min; i < (max + 1); i++) {
            cbo.addItem("" + i);
        }
    }

    public String extraiAPrimeiraOcorrencia(String txt, char token) {
        String t = "";
        if (txt.length() > 0) {
            for (int i = 0; i < txt.length(); i++) {
                if (txt.charAt(i) != token) {
                    t += "" + txt.charAt(i);
                } else {
                    break;
                }
            }
        }
        return t;
    }

    public String extraiAUltimaOcorrencia(String txt, char token) {
        String t = "";
        if (txt.length() > 0) {
            boolean tem = false;
            for (int i = 0; i < txt.length(); i++) {
                if (txt.charAt(i) == token) {
                    tem = true;
                } else {
                    if (tem) {
                        t += "" + txt.charAt(i);
                    }
                }
            }
        }
        return t;
    }

    public void addNrsNaCbo(JComboBox cbo, int min, int max) {
        cbo.removeAllItems();;
        if (min > max) {
            max += min - max;
        }
        for (int i = min; i < (max + 1); i++) {
            if (i < 10) {
                cbo.addItem("0" + i);
            } else {
                cbo.addItem("" + i);
            }
        }
    }

    public String srcCaminhoAnyFile(String fileName) {
        try {
            URL url = getClass().getResource(fileName);
            String s = "" + url;
            return "" + s.substring(6, s.length());
        } catch (Exception e) {
        }
        return caminhoCasoDerErro(fileName);
    }

    public String caminhoCasoDerErro(String caminhoInicial) {
        String cmn = "", c = "";
        for (int i = caminhoInicial.length() - 1; i >= 0; i--) {
            if (caminhoInicial.charAt(i) != '/') {
                cmn += "" + caminhoInicial.charAt(i);
            } else {
                break;
            }
        }
        System.out.println("caminhoCasoDerErro (A): " + cmn);

        for (int i = cmn.length() - 1; i >= 0; i--) {
            c += "" + cmn.charAt(i);
        }
        System.out.println("caminhoCasoDerErro (B): " + c);
        return c;
    }
    DateTime dh = new DateTime();

    public boolean e_dataInferiorQueHoje_1(String dataA) {
        int diaA = e_int(dataA.substring(0, 2)), mesA = e_int(dataA.substring(3, 5)), anoA = e_int(dataA.substring(6, 10));
        int diaB = dh.getDia(), mesB = dh.getMes(), anoB = dh.getAno();
        if (mesA == -1) {
            mesA = dh.mesPorNumero(dataA.substring(3, 6));
        }
        if (anoA == -1) {
            anoA = e_int(dataA.substring(7, 11));
        }
        Calendar cA = Calendar.getInstance();
        Calendar cB = Calendar.getInstance();
        cA.set(diaA, mesA, anoA);
        cB.set(diaB, mesB, anoB);
        if ((diaA == diaB) && (mesA == mesB) && (anoA == anoB)) {
            return true;
        }
        if (cA.compareTo(cB) == -1) {
            return true;
        }
        return false;
    }

    public boolean e_dataInferiorQueHoje(String dataA) {
        int diaA = e_int(dataA.substring(0, 2)), mesA = e_int(dataA.substring(3, 5)), anoA = e_int(dataA.substring(6, 10));
        int diaB = dh.getDia(), mesB = dh.getMes(), anoB = dh.getAno();
        if (mesA == -1) {
            mesA = dh.mesPorNumero(dataA.substring(3, 6));
        }
        if (anoA == -1) {
            anoA = e_int(dataA.substring(7, 11));
        }
        Calendar cA = Calendar.getInstance();
        Calendar cB = Calendar.getInstance();
        cA.set(diaA, mesA, anoA);
        cB.set(diaB, mesB, anoB);
        if ((diaA == diaB) && (mesA == mesB) && (anoA == anoB)) {
            return true;
        }
        if (anoB >= anoA) {
            if (anoB == anoA) {
                if (mesB >= mesA) {
                    if (mesB == mesA) {
                        if (diaB >= mesA) {
                            return true;
                        }
                    } else {
                        return true;
                    }
                }
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean e_DataA_InferiorQ_DataB(String dataA, String dataB) {
        int diaA = e_int(dataA.substring(0, 2)), mesA = e_int(dataA.substring(3, 5)), anoA = e_int(dataA.substring(6, 10));
        int diaB = e_int(dataB.substring(0, 2)), mesB = e_int(dataB.substring(3, 5)), anoB = e_int(dataB.substring(6, 10));
        if (mesA == -1) {
            mesA = dh.mesPorNumero(dataA.substring(3, 6));
        }
        if (mesB == -1) {
            mesB = dh.mesPorNumero(dataB.substring(3, 6));
        }
        if (anoA == -1) {
            anoA = e_int(dataA.substring(7, 11));
        }
        if (anoB == -1) {
            anoB = e_int(dataB.substring(7, 11));
        }
        Calendar cA = Calendar.getInstance();
        Calendar cB = Calendar.getInstance();
        cA.set(diaA, mesA, anoA);
        cB.set(diaB, mesB, anoB);
//        System.out.println(diaA + " (A-B) " + diaB);
//        System.out.println(mesA + " (A-B) " + mesB);
//        System.out.println(anoA + " (A-B) " + anoB);
        if ((diaA == diaB) && (mesA == mesB) && (anoA == anoB)) {
            return true;
        }
        if (cA.compareTo(cB) == -1) {
            return true;
        }
        return false;
    }

    public int getAno(String data) {
        if (data.length() == 11) {
            int ano = e_int(data.substring(7, 11));
            return ano;
        }
        return -1;
    }

    public int calculaIdade(String dtInicio) {
        int dia = e_int(dtInicio.substring(0, 2)), mes = e_int(dtInicio.substring(3, 6)), ano = e_int(dtInicio.substring(7, 11));
        return dh.getAno() - ano;
    }

    public int getAnoDaData(String dt) {
        int dia = e_int(dt.substring(0, 2)), mes = e_int(dt.substring(3, 6)), ano = e_int(dt.substring(7, 11));
        return ano;
    }

    Controla_Eventos eventos = new Controla_Eventos();

    public void piscaComp(JComponent l, int f_In, int f_Out) {
        new Thread() {
            public void run() {
                int i = 0;
                //l.setForeground(corIn);
                do {
                    try {
                        sleep(100);
                        if (i % 3 == 0) {
                            eventos.foco_JComponentB(l, true, f_In, f_Out);
                        } else {
                            eventos.foco_JComponentB(l, false, f_In, f_Out);
                        }
                        if (i >= 40) {
                            eventos.foco_JComponentB(l, false, f_In, f_Out);
                            break;
                        }
                        i++;
                    } catch (Exception e) {
//                        JOptionPane.showMessageDialog(null, "Erro de No alterar imagens" + e);
                    }
                } while (true);
            }
        }.start();
        // l.setBackground(new Color(204,204,204));
    }

    public void lblFoco(JComponent comp, JComponent l, boolean in, int f_in, int f_OutSomar, Color corIN, Color corOUT) {
        if (in) {
            l.setFont(new Font("Times New Roman", 1, f_in));
            comp.setBackground(corIN);
        } else {
            l.setFont(new Font("Times New Roman", 1, (f_in - f_OutSomar)));
            comp.setBackground(corOUT);
        }
    }

    public void mouseInOut(JComponent comp, boolean in, int f_in, int f_OutSomar, Color corIN, Color corOUT) {
        comp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFoco(comp, comp, true, f_in + 1, f_OutSomar, Color.GREEN, corOUT);
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblFoco(comp, comp, true, f_in, f_OutSomar, corIN, corOUT);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblFoco(comp, comp, false, f_in, f_OutSomar, corIN, corOUT);
            }
        });
    }

    public void mouseInOutBorder(JComponent comp, Color cor, int f, int n_1s_2e_3o_4) {
        comp.addMouseListener(new java.awt.event.MouseAdapter() {
            Controla_Eventos ev = new Controla_Eventos();

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ev.comp_borders(comp, cor, f, n_1s_2e_3o_4);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ev.comp_borders(comp, cor, f, n_1s_2e_3o_4);
            }
        });
    }

    public final void compDragged(JComponent lblH1) {
        lblH1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lblH1.setLocation(lblH1.getX() + evt.getX() - (lblH1.getWidth() / 2), lblH1.getY() + evt.getY() - (lblH1.getHeight() / 2));
            }
        });

//        lblH1.addMouseListener(new java.awt.event.MouseAdapter() {
//            public void mousePressed(java.awt.event.MouseEvent evt) {
//                vis.mexeTelaPressesd(evt.getX(), evt.getY());
//            }
//        });
    }

    public String extraiFraze(String txt, int ultmPos) {
        String t = "";
        if (txt.length() > 0) {//# Questao, * Opcao falsa, ~ solucao, ^ comentario, ! outra questao
            for (int i = ultmPos; i < txt.length(); i++) {
                char c = txt.charAt(i);
                ultmosDaqui = i;
                if (c == '#' || c == '*' || c == '~' || c == '^') {
                    break;
                } else {
                    if (c != '!') {
                        t += "" + txt.charAt(i);
                    }
                }
            }
        }
        // msg(null, t);
        return t;
    }
    int ultmosDaqui = 0;

    public int getUltimoInt() {
        return ultmosDaqui - 1;
    }

    /**
     * Retorna true se estiver fora do prazo
     *
     * @param dt
     * @return
     */
    public boolean verificaSeExpirou(String dt) {
        try {
            Calendar c = Calendar.getInstance();
            int dv, mv, av;// v=  vencimento
            int d_act = c.get(Calendar.DAY_OF_MONTH);
            int m_act = c.get(Calendar.MONTH) + 1;
            int a_act = c.get(Calendar.YEAR);
            // JOptionPane.showMessageDialog(null, dt);
            dt = retDataFormatado(dt);
            dt = dt11(dt);
            if (dt != null && dt.length() > 10) {
//
                dv = e_int(dt.substring(0, 2));
                mv = mes(dt.substring(3, 6));
                av = e_int(dt.substring(7, 11));
                String d = dv + "-" + mv + "-" + av;
                String a = d_act + "-" + m_act + "-" + a_act;
                if (a_act >= av) {
                    if (a_act == av) {
                        if (m_act >= mv) {
                            if (m_act == mv) {
                                if (d_act >= dv) {
                                    return true;
                                }
                            } else {//mes maior 
                                return true;
                            }
                        }
                    } else {//ano maior 
                        return true;
                    }
                }

            } else {
//                JOptionPane.showMessageDialog(null, "Erro ao verificar o prazo.\n"
                //               + "Comprimento da data invalido.");
            }
        } catch (Exception e) {
        }
        return false;
    }

    private String retDataFormatado(String dt) {
        String d, m = dt.substring(0, 3), a = dt.substring(dt.length() - 4, dt.length());
        if (mes(m) != 0) {
            m = mes(mes(m)) + "/";
            if (dt.length() == 11) {
                d = dt.substring(4, 5) + "/";
            } else {
                d = dt.substring(4, 6) + "/";
            }
            return d + m + a;
        }
        return dt;
    }

    private String mes(int m) {
        switch (m) {
            case 1:
                return "jan";
            case 2:
                return "fev";
            case 3:
                return "mar";
            case 4:
                return "abr";
            case 5:
                return "mai";
            case 6:
                return "jun";
            case 7:
                return "jul";
            case 8:
                return "ago";
            case 9:
                return "set";
            case 10:
                return "out";
            case 11:
                return "nov";
            case 12:
                return "dez";
        }
        return "";
    }

    private int mes(String m) {
        switch (m) {
            case "jan":
                return 1;
            case "fev":
                return 2;
            case "mar":
                return 3;
            case "abr":
                return 4;
            case "mai":
                return 5;
            case "jun":
                return 6;
            case "jul":
                return 7;
            case "ago":
                return 8;
            case "set":
                return 9;
            case "out":
                return 10;
            case "nov":
                return 11;
            case "dez":
                return 12;
        }
        return 0;
    }

    public String dt11(String dt) {
        if (dt.length() == 10) {
            dt = ("0" + dt);
        }
        return dt;
    }
}
