/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import JARs.Componentes;
import JARs.Validacoes;
import javax.swing.JLabel;

/**
 *
 * @author Marondo
 */
public class NewClass {
    public static void main(String[] args) {
        String v="98765431100",s="",u;
        int l=v.length(),l1=0;
        s=v.substring(l-9,l);
        v=v.substring(0,l-9);
        Validacoes val = new Validacoes();
        String di = "13/10/2019",db="13/Out/2019";
        boolean res =val.e_DataA_InferiorQ_DataB(di, db);
        System.out.println(""+res);
    }
}
