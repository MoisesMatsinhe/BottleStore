package Controles.iReport;

import Controles.ControlaProdutos;
import Controles.ControlaVenda;
import JARs.Componentes;
import JARs.Validacoes;
import Modelos.Produto;
import Modelos.Venda;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class Imprimir {

    Validacoes val = new Validacoes();
    Componentes c = new Componentes();
    ControlaProdutos conProd = new ControlaProdutos();
    ControlaVenda conVenda = new ControlaVenda();

    public Imprimir() {
    }

    public void imprimirProduto(ArrayList<Produto> lista, boolean geral) {
        String caminho = "/Reports/reportProdutos.jasper";
        if (geral) {
            caminho = "/Reports/reportProdutos.jasper";
        }
        InputStream relJasper = getClass().getResourceAsStream(caminho);
        JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(lista);

        Map parametros = new HashMap();
        JasperPrint impressao = null;
        try {
            impressao = JasperFillManager.fillReport(relJasper, parametros, ds);
            JasperViewer viewer = new JasperViewer(impressao, true);
            viewer.setTitle("Bottle Store - produtos");
            viewer.setDefaultCloseOperation(3);
            viewer.setVisible(true);
        } catch (Exception e) {
            System.out.println("Erro em imprimirProduto():\n" + e);
        }
    }

    public void imprimirVenda(ArrayList<Venda> lista, boolean geral) {
        String caminho = "/Reports/reportVenda_1.jasper";
        if (geral) {
            caminho = "/Reports/reportVendaGeral.jasper";
        }
        InputStream relJasper = getClass().getResourceAsStream(caminho);
        JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(lista);

        Map parametros = new HashMap();
        JasperPrint impressao = null;
        try {
            impressao = JasperFillManager.fillReport(relJasper, parametros, ds);
            JasperViewer viewer = new JasperViewer(impressao, true);
            viewer.setTitle("Bottle Store - Venda");
            viewer.setDefaultCloseOperation(3);
            viewer.setVisible(true);
        } catch (Exception e) {
            System.out.println("Erro em imprimirVenda():\n" + e);
        }
    }
}
