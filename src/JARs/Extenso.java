package JARs;

public class Extenso {

    Validacoes val = new Validacoes();

    public Extenso() {
    }

    private String gVal(int nr, int x1, int x2) {
        String v = "" + nr;
        try {
            return v.substring(x1, x2);
        } catch (Exception e) {
            val.msg(null, "gVal 1\n" + e);
        }
        return " gVal 1";
    }

    private String gVal(String valor, int x1, int x2) {
        String v = valor;
        try {
            return v.substring(x1, x2);
        } catch (Exception e) {
            val.msg(null, "gVal 2\n" + e);
        }
        return " gVal 2";
    }

    private int gValInt(int nr, int x1, int x2) {
        String v = "" + nr;
        try {
            return toInt(v.substring(x1, x2));
        } catch (Exception e) {
            val.msg(null, "gVal 3\n" + e);
        }
        return -1;
    }

    private int gValInt(String valor, int x1, int x2) {
        String v = valor;
        try {
            return toInt(v.substring(x1, x2));
        } catch (Exception e) {
            val.msg(null, "gVal 4\n" + e);
        }
        return -1;
    }

    private int toInt(String nr) {
        return val.e_int(nr);
    }

    private String toStr(int nr) {
        return "" + nr;
    }

    private String gChar_i(int nr, int i) {
        try {
            String s = "" + nr;
            s = "" + s.charAt(i);
            return s;
        } catch (Exception e) {
            val.msg(null, "gChar_i 1\n" + e);
        }
        return " gChar_i 1 ";
    }

    private String gChar_i(String nr, int i) {
        try {
            String s = "" + nr;
            s = "" + s.charAt(i);
            return s;
        } catch (Exception e) {
            val.msg(null, "gChar_i 2\n" + e);
        }
        return " gChar_i 2 ";
    }

    private int gChar_I(int nr, int i) {
        try {
            String s = "" + nr;
            s = "" + s.charAt(i);
            return toInt(s);
        } catch (Exception e) {
            val.msg(null, "gChar_I 1\n" + e);
        }
        return -1;
    }

    private int gChar_I(String nr, int i) {
        try {
            String s = "" + nr;
            s = "" + s.charAt(i);
            return toInt(s);
        } catch (Exception e) {
            val.msg(null, "gChar_I 2\n" + e);
        }
        return -1;
    }

    void msg(String s) {
        val.msg(null, s);
    }

    public String getExtenso(String valor) {
        if (valor.length() == 0) {
            return "Valor vazio.";
        }
        int nr = 0;
        if (valor.length() < 10) {
            nr = toInt(valor);
            if (valor.length() == 1) {// 0 - 9
                return in_0_9(nr);
            } else if (valor.length() == 2) {// 10 - 99
                return in_0_99(nr);
            } else if (valor.length() == 3) {// 100 - 999
                return in_0_999(nr);
            } else if (valor.length() == 4) {// 1.000 - 9.999
                return in_0_9999(nr);
            } else if (valor.length() == 5) {// 10.000 - 99.999
                return in_0_99999(nr);
            } else if (valor.length() == 6) {// 100.000 - 999.999
                return in_0_999999(nr);
            } else if (valor.length() == 7) {// 1.000.000 - 9.999.999
                return in_0_9999999(nr);
            } else if (valor.length() == 8) {// 10.000.000 - 99.999.999
                return in_0_99999999(nr);
            } else if (valor.length() == 9) {// 100.000.000 - 999.999.999
                return in_0_999999999(nr);
            }
        } else {
            String a, b, c;
            nr = valor.length();
            a = gVal(valor, 0, nr - 9);;
            b = gVal(valor, nr - 9, nr);
            b = in_0_999999999(toInt(b));
            if (a.length() < 4) {
                return in_bilhoes(a, b);
            }
            //-------- a<7
            if (a.length() < 7) {
                c = b;
                return in_trihloes(a, "", c);
            }
        }
        return "ERRO";
    }

    private String in_bilhoes(String a, String b) {
        if (gValInt(a, 0, 1) == 1) {
            a = in_0_999(toInt(a)) + " bilhão";
        } else {
            a = in_0_999(toInt(a)) + " bilhões";
        }
        if (b != "zero") {
            return a + " e " + b;
        } else {
            return a;
        }
    }

    private String in_trihloes(String a, String b, String c) {
        int nr = a.length();
        b = gVal(a, nr - 3, nr);
        a = gVal(a, 0, nr - 3);
        if (gValInt(a, 0, 1) == 1) {
            a = in_0_999(toInt(a)) + " trilhão";
        } else {
            a = in_0_999(toInt(a)) + " trilhões";
        }
        if (toInt(b) > 0) {
            if (gValInt(b, 0, 1) == 1) {
                b = " e "+in_0_999(toInt(b)) + " bilhão";
            } else {
                b = " e "+in_0_999(toInt(b)) + " bilhões";
            }
        } else {
            b="";
        }
        if (c != "zero") {
            return a + b + " e " + c;
        } else {
            return a+ b;
        }
    }

    /**
     * ___________________________________________
     *
     * @param nr
     * @return
     */
    private String in_0_9(int nr) {
        switch (nr) {
            case 0:
                return "zero";
            case 1:
                return "um";
            case 2:
                return "dois";
            case 3:
                return "três";
            case 4:
                return "quatro";
            case 5:
                return "cinco";
            case 6:
                return "seis";
            case 7:
                return "sete";
            case 8:
                return "oito";
            case 9:
                return "nove";
        }
        return " in_0_9 [" + nr + "]";
    }

    private String in_0_19(int nr) {
        if (nr < 10) {
            return in_0_9(nr);
        }
        switch (nr) {
            case 10:
                return "dez";
            case 11:
                return "onze";
            case 12:
                return "doze";
            case 13:
                return "trêze";
            case 14:
                return "catorze";
            case 15:
                return "quinze";
            case 16:
                return "dezaseis";
            case 17:
                return "dezasete";
            case 18:
                return "dezaoito";
            case 19:
                return "dezanove";
        }
        if (nr < 10) {
            return in_0_9(nr);
        }
        return " in_0_19 [" + nr + "]";
    }

    private String in_20_90(int nr) {
        if (nr < 20) {
            return in_0_19(nr);
        }
        if (gChar_I(nr, 1) == 0) {
            switch (gChar_I(nr, 0)) {
                case 2:
                    return "vite";
                case 3:
                    return "trinta";
                case 4:
                    return "quarenta";
                case 5:
                    return "cinquenta";
                case 6:
                    return "sessenta";
                case 7:
                    return "setenta";
                case 8:
                    return "oitenta";
                case 9:
                    return "noventa";
            }
        }
        return " in_20_90 [" + nr + "]";
    }

    private String in_0_99(int nr) {
        if (nr < 20) {
            return in_0_19(nr);
        }
        if (gChar_I(nr, 1) == 0) {
            return in_20_90(nr);
        } else {
            String a = "" + gChar_I(nr, 0) + "0";
            String b = "" + gChar_I(nr, 1);
            a = in_20_90(toInt(a));
            b = in_0_9(toInt(b));
            return a + " e " + b;
        }
    }

    private String in_100_900(int nr) {
        if (nr < 100) {
            return in_0_99(nr);
        }
        switch (nr) {
            case 100:
                return "cem";
            case 200:
                return "duzentos";
            case 300:
                return "trezentos";
            case 400:
                return "quatrocentos";
            case 500:
                return "quinhentos";
            case 600:
                return "sescentos";
            case 700:
                return "setesentos";
            case 800:
                return "oitocentos";
            case 900:
                return "novecentos";
        }
        return " in_0_99 [" + nr + "]";
    }

    private String in_0_999(int nr) {
        if (nr < 100) {
            return in_0_99(nr);
        }
        String a = gVal(nr, 1, 3);//1-00
        if (toInt(a) == 0) {
            return in_100_900(nr);
        }
        a = "" + gChar_I(nr, 0);
        String b = gVal(nr, 1, 3);
        if (a.equals("1")) {
            a = "cento";
        } else {
            a = in_100_900(toInt(a + "00"));
        }
        b = in_0_99(toInt(b));
        return a + " e " + b;
    }

    private String in_1000_9000(int nr) {
        if (nr < 1000) {
            return in_0_999(nr);
        }
        String a = gVal(nr, 1, 4);//1-00
        if (toInt(a) == 0) {
            a = "" + gChar_I(nr, 0);
            if (toInt(a) == 1) {
                return "mil";
            }
            return in_0_9(toInt(a)) + " " + "mil";
        }
        return " in_1000_9000 [" + nr + "]";
    }

    private String in_0_9999(int nr) {
        if (nr < 1000) {
            return in_0_999(nr);
        }
        String a = gVal(nr, 1, 4);
        if (toInt(a) == 0) {
            return in_1000_9000(nr);
        }
        a = "" + gChar_I(nr, 0) + "000";
        a = in_1000_9000(toInt(a));
        String b = gVal(nr, 1, 4);
        b = in_0_999(toInt(b));
        return a + " e " + b;
    }

    private String in_10000_90000(int nr) {
        if (nr < 10000) {
            return in_0_9999(nr);
        }
        String a = gVal(nr, 0, 2);
        return in_0_99(toInt(a)) + " mil";
    }

    private String in_0_99999(int nr) {
        if (nr < 10000) {
            return in_0_9999(nr);
        }
        String a = gVal(nr, 1, 5);
        if (toInt(a) == 0) {
            return in_10000_90000(nr);
        }
        if (gValInt(nr, 2, 5) == 0) {
            return in_0_99(gValInt(nr, 0, 2)) + " mil";
        }
        a = gVal(nr, 0, 2) + "000";
        a = in_10000_90000(toInt(a));
        String b = gVal(nr, 2, 5);
        b = in_0_999(toInt(b));
        return a + " e " + b;
    }

    private String in_100000_900000(int nr) {
        if (nr < 100000) {
            return in_0_99999(nr);
        }
        String a = gVal(nr, 0, 3);
        return in_0_999(toInt(a)) + " mil";
    }

    private String in_0_999999(int nr) {
        if (nr < 100000) {
            return in_0_99999(nr);
        }
        String a = gVal(nr, 1, 6);
        if (toInt(a) == 0) {
            return in_100000_900000(nr);
        }
        if (gValInt(nr, 3, 6) == 0) {
            return in_0_999(gValInt(nr, 0, 3)) + " mil";
        }
        a = gVal(nr, 0, 3) + "000";
        a = in_100000_900000(toInt(a));
        String b = gVal(nr, 3, 6);
        b = in_0_999(toInt(b));
        return a + " e " + b;
    }

    private String in_1000000_9000000(int nr) {
        if (nr < 1000000) {
            return in_0_999999(nr);
        }
        int a = gValInt(nr, 0, 1);
        if (a == 1) {
            return in_0_9(a) + " milhão";
        } else {
            return in_0_9(a) + " milhões";
        }
    }

    private String in_0_9999999(int nr) {
        if (nr < 1000000) {
            return in_0_999999(nr);
        }
        String a = gVal(nr, 1, 7);
        if (toInt(a) == 0) {
            return in_1000000_9000000(nr);
        }
        a = gVal(nr, 0, 1);
        if (toInt(a) == 1) {
            a = in_0_9(toInt(a)) + " milhão";
        } else {
            a = in_0_9(toInt(a)) + " milhões";
        }
        String b = gVal(nr, 1, 7);
        b = in_0_999999(toInt(b));
        return a + " e " + b;
    }

    private String in_10000000_90000000(int nr) {//10.000.000
        if (nr < 10000000) {
            return in_0_9999999(nr);
        }
        int a = gValInt(nr, 0, 2);
        return in_0_99(a) + " milhões";
    }

    private String in_0_99999999(int nr) {
        if (nr < 10000000) {
            return in_0_9999999(nr);
        }
        String a = gVal(nr, 2, 8);
        if (toInt(a) == 0) {
            return in_10000000_90000000(nr);
        }
        a = gVal(nr, 0, 2);
        a = in_0_99(toInt(a)) + " milhões";
        String b = gVal(nr, 2, 8);
        b = in_0_9999999(toInt(b));
        return a + " e " + b;
    }

    private String in_100000000_900000000(int nr) {//100.000.000
        if (nr < 100000000) {
            return in_0_99999999(nr);
        }
        int a = gValInt(nr, 0, 3);
        return in_0_999(a) + " milhões";
    }

    private String in_0_999999999(int nr) {
        if (nr < 100000000) {
            return in_0_99999999(nr);
        }
        String a = gVal(nr, 3, 9);
        if (toInt(a) == 0) {
            return in_100000000_900000000(nr);
        }
        a = gVal(nr, 0, 3);
        a = in_0_999(toInt(a)) + " milhões";
        String b = gVal(nr, 3, 9);
        b = in_0_99999999(toInt(b));
        return a + " e " + b;
    }

    /**
     * \\\\\\\\\\\\//////////\\\\\\\\\\\\\\\////////////
     *
     * @param nr
     * @return
     */
    private String in_1000000000_9000000000(int nr) {//1.000.000.000
        if (nr < 1000000000) {
            return in_0_999999999(nr);
        }
        int a = gValInt(nr, 0, 1);
        if (a == 1) {
            return in_0_9(a) + " bilhão";
        } else {
            return in_0_9(a) + " bilhões";
        }
    }

    private String in_0_9999999999(int nr) {//9 billhoe
        if (nr < 1000000000) {
            return in_0_999999999(nr);
        }
        String a = gVal(nr, 1, 10);

        if (toInt(a) == 0) {
            return in_1000000000_9000000000(nr);
        }
        a = gVal(nr, 0, 1);
        if (toInt(a) == 1) {
            a = in_0_9(toInt(a)) + " bilhão";
        } else {
            a = in_0_9(toInt(a)) + " bilhões";
        }
        String b = gVal(nr, 1, 10);
        b = in_0_999999999(toInt(b));
        return a + " e " + b;
    }
}
