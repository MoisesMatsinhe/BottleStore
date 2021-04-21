package JARs;

import java.util.ArrayList; 
public final class Constantes {

    public final String NOME_INSTITUICAO = "SISCOM";
    Validacoes val = new Validacoes();

    public ArrayList<String> nrs = new ArrayList<>();
    public ArrayList<String> n0_9 = new ArrayList<>();
    String n10 = "dez";
    public ArrayList<String> n11_15 = new ArrayList<>();
    public ArrayList<String> n21_99 = new ArrayList<>();
    public ArrayList<String> n100_999 = new ArrayList<>();

    String n100 = "cem";
    String nCento = "cento";
    String n1000_ = "mil";

    private void zero_9() {
        n0_9.add("zero");
        n0_9.add("um");
        n0_9.add("dois");
        n0_9.add("tres");
        n0_9.add("quatro");
        n0_9.add("cinco");
        n0_9.add("seis");
        n0_9.add("sete");
        n0_9.add("oito");
        n0_9.add("nove");
    }

    private void n11_15() {
        n11_15.add("-");
        n11_15.add("onze");
        n11_15.add("doze");
        n11_15.add("treze");
        n11_15.add("catorze");
        n11_15.add("quinze");
    }

    private void n21_99() {
        n21_99.add("-");
        n21_99.add("-");
        n21_99.add("vinte");
        n21_99.add("trinta");
        n21_99.add("quarenta");
        n21_99.add("cinquenta");
        n21_99.add("sessenta");
        n21_99.add("setenta");
        n21_99.add("oitenta");
        n21_99.add("noventa");
    }

    private void n100_999() {
        n100_999.add("cem");
        n100_999.add("cento");
        n100_999.add("duzentos");
        n100_999.add("trezentos");
        n100_999.add("quatrocentos");
        n100_999.add("quinhentos");
        n100_999.add("seiscentos");
        n100_999.add("setecentos");
        n100_999.add("oitocentos");
        n100_999.add("novecentos");

    }

    private void n1000_() {
        n100_999.add("mil");

    }

    public Constantes() {
        zero_9();
        n11_15();
        n21_99();
        n100_999();
        n1000_();

    }

    private int sub_1Traz(String t) {
        return Integer.parseInt(t.substring(t.length() - 1));
    }

    private int sub_1Frent(String t) {
        return Integer.parseInt(t.substring(0, 1));
    }

    private int sub_2Frent(String t) {
        return Integer.parseInt(t.substring(1, 2));
    }

    private int sub_1_2Frent(String t) {
        return Integer.parseInt(t.substring(0, 2));
    }

    private int sub_1_3Frent(String t) {
        return Integer.parseInt(t.substring(0, 3));
    }

    private String sub_2TrazStr(String t) {
        return t.substring(t.length() - 2, t.length());
    }

    private int sub_2TrazInt(String t) {
        return Integer.parseInt(sub_2TrazStr(t));
    }

    private String sub_3TrazStr(String t) {
        return t.substring(t.length() - 3, t.length());
    }

    private String sub_4TrazStr(String t) {
        return t.substring(t.length() - 4, t.length());
    }

    private int sub_3TrazInt(String t) {
        return Integer.parseInt(sub_3TrazStr(t));
    }

    private int sub_Meio(String t) {
        return Integer.parseInt(t.substring(t.length() - 2, t.length() - 1));
    }

    //           JOptionPane.showMessageDialog(null, i);
    public String porExtenso(int i) {
        String t = "";
        if (i < 100) {
            return de_0_99(i);
        } else if (i > 99 && i < 1000) {
            return de_100_999(i);
        } else if (i > 999 && i < 10000) {
            return de_1000_9999(i);
        } else if (i > 9999 && i < 100000) {
            return de_10000_99999(i);
        } else if (i > 99999 && i < 1000000) {
            return de_100Mil_999Mil(i);
        }
        return "LIMITE = 100MIL - POR EXTENSO";
    }

    private String de_0_9(int i) {
        return n0_9.get(i);
    }

    private String de_10_19(int i) {
        if (i == 10) {
            return n10;
        } else if (i > 10 && i < 16) {
            return n11_15.get(sub_1Traz("" + i));
        } else if (i > 15 && i < 20) {
            return n10 + "a" + n0_9.get(sub_1Traz("" + i));
        }
        return "";
    }

    private String de_0_99(int i) {
        if (i < 10) {
            return de_0_9(i);
        } else if (i >= 10 && i < 20) {
            return de_10_19(i);
        } else if (i > 19 && i < 100) {
            if (sub_1Traz("" + i) == 0) {
                return n21_99.get(sub_1Frent("" + i));
            } else {
                return n21_99.get(sub_1Frent("" + i)) + " e " + n0_9.get(sub_1Traz("" + i));
            }
        }
        return "0.0";
    }

    private String de_100_999(int i) {
        if (i < 100) {
            return de_0_99(i);
        } else if (sub_2TrazStr("" + i).equals("00")) {
            return n100_999.get(sub_1Frent("" + i));
        } else if (sub_Meio("" + i) == 0) {
            return (n100_999.get(sub_1Frent("" + i)) + " e " + n0_9.get(sub_1Traz("" + i)));
        } else {
            //Caso seja numeros entre CENTO e 10-19
            if (sub_2TrazInt("" + i) == 10) {
                return (n100_999.get(sub_1Frent("" + i)) + " e " + n10);
            } else if (sub_2TrazInt("" + i) > 10 && sub_2TrazInt("" + i) < 16) {
                return (n100_999.get(sub_1Frent("" + i)) + " e " + n11_15.get(sub_1Traz("" + i)));
            } else if (sub_2TrazInt("" + i) > 15 && sub_2TrazInt("" + i) < 20) {
                return (n100_999.get(sub_1Frent("" + i)) + " e " + n10 + "a" + n0_9.get(sub_1Traz("" + i)));
            } //Caso CENTO ++
            else if (sub_2TrazInt("" + i) > 19 && sub_2TrazInt("" + i) < 100) {
                if (sub_1Traz("" + i) == 0) {
                    return (n100_999.get(sub_1Frent("" + i)) + " e " + n21_99.get(sub_Meio("" + i)));
                } else {
                    return (n100_999.get(sub_1Frent("" + i)) + " e " + n21_99.get(sub_Meio("" + i)) + " e " + n0_9.get(sub_1Traz("" + i)));
                }
            }
        }
        return "0.0";
    }

    private String de_1000_9999(int i) {
        if (i == 1000) {
            return n1000_;
        } else if (sub_3TrazStr("" + i).equals("000")) {
            return n0_9.get(sub_1Frent("" + i)) + " " + n1000_;
        } else if (i < 2000) {
            i = val.e_int(("" + i).substring(1));
            if (i < 100) {
                return n1000_ + " e " + de_0_99(i);
            } else {
                return n1000_ + " e " + de_100_999(i);
            }
        } else {
            int j = val.e_int(("" + i).substring(1));
            if (j < 100) {
                return n0_9.get(sub_1Frent("" + i)) + " " + n1000_ + " e " + de_0_99(j);
            } else {
                return n0_9.get(sub_1Frent("" + i)) + " " + n1000_ + " e " + de_100_999(j);
            }
        }
    }

    private String de_10000_99999(int i) {
        if (i == 10000) {
            return n10 + " " + n1000_;
        } else if (sub_4TrazStr("" + i).equals("0000")) {
            return n21_99.get(sub_1Frent("" + i)) + " " + n1000_;
        } else if (i < 20000) {
            int f = sub_1_2Frent("" + i);
            //JOptionPane.showMessageDialog(null, f);
            int j = val.e_int(("" + i).substring(2));
            if (j < 100) {
                return de_10_19(f) + " " + n1000_ + " e " + de_0_99(j);
            } else if (j < 1000) {
                return de_10_19(f) + " " + n1000_ + " e " + de_100_999(j);
            }
        } else {
            int f = sub_1_2Frent("" + i);
            int j = val.e_int(("" + i).substring(2));

            if (j < 100) {
                if (j > 0) {
                    return de_0_99(f) + " " + n1000_ + " e " + de_0_99(j);
                } else {
                    return de_0_99(f) + " " + n1000_;
                }
            } else if (j < 1000) {
                return de_0_99(f) + " " + n1000_ + " e " + de_100_999(j);
            } else {
                return de_0_99(f) + " " + n1000_ + " e " + de_1000_9999(j);
            }
        }
        return "0.0";
    }

    private String de_100Mil_999Mil(int i) {
        int f = sub_1_3Frent("" + i);
        int z = val.e_int(sub_3TrazStr("" + i));
        int j = val.e_int(("" + i).substring(3));
        if (z == 0) {
            return de_100_999(f) + " " + n1000_;
        } else {
            return de_100_999(f) + " " + n1000_ + " e " + de_100_999(j);
        }
        //  return "0.0";
    }

}
