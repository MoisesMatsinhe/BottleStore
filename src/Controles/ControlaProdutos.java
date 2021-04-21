package Controles;

import JARs.Validacoes;
import Modelos.Fornecedor;
import Modelos.Produto;
import Modelos.Venda;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static jdk.nashorn.internal.objects.NativeString.toUpperCase;

public class ControlaProdutos extends ControlaGenerico<Produto> {

    public ArrayList<Produto> lst = new ArrayList<>();

    public ControlaProdutos() {
        super(new Produto().getClass());
        lst = lstProduto();
    }

    public ArrayList<Produto> lstProduto() {
        lst.clear();
        listaDeObjectoY().stream().map((ob) -> (Produto) ob).forEachOrdered((f) -> {
            Produto p = ((Produto) f);
            if (val.e_dataInferiorQueHoje(p.getDataValidade())) {
                p.setActivo(false);
                actualizar(p);
            } else {
                lst.add(p);
            }
        });
        return lst;
    }

    public void listarNaTabela(JTable tbl) {
        ((DefaultTableModel) tbl.getModel()).setNumRows(0);
        lst = lstProduto();
        for (Produto o : lst) {
            if (o.isActivo() && o.getQuantidade() > 0) {
                registo(tbl, o);
            }
        }
    }

    public void listarNaTabela(JTable tbl, ArrayList<Produto> l) {
        ((DefaultTableModel) tbl.getModel()).setNumRows(0);
        for (Produto o : l) {
            if (o.isActivo() && o.getQuantidade() > 0) {
                registo(tbl, o);
            }
        }
    }

    private Object registo(JTable tbl, Produto c) {
        Object[] registo = {
            c.getId(), descricao(c),
            c.getQuantidade(), c.getPrecoCompra(),
            c.getLucro(), c.getPrecoVenda(),
            c.getFornecedor(),};
        DefaultTableModel modelo = (DefaultTableModel) tbl.getModel();
        modelo.addRow(registo);
        return registo;
    }

    private String descricao(Produto p) {
        String s = p.getNome() + " - " + p.getTipoDeProduto() + " - " + p.getTipoDeEmbalagem()
                + " [" + p.getDataValidade() + "]";
        return s;
    }

    public void fillCboForn(JComboBox cbo) {
        cbo.removeAllItems();
        ArrayList<Fornecedor> l = new ControlaFornecedor().lstFornecedor();
        for (Fornecedor f : l) {
            if (f.isActivo()) {
                String s = f.getId() + "/" + f.getNome();
                cbo.addItem(s);
            }
        }
    }

    public void fillCboProd(JComboBox cbo) {
        cbo.removeAllItems();
        lst = lstProduto();
        for (Produto f : lst) {
            if (f.isActivo()) {
                String s = f.getNome();
                cbo.addItem(s);
            }
        }
    }

    public void fillCbo_Forn_Emb_Tipo(JComboBox cboForn, JComboBox cboEmb, JComboBox cboTipo) {
        cboForn.removeAllItems();
        cboEmb.removeAllItems();
        cboTipo.removeAllItems();
        String s = "Todos";
        cboForn.addItem(s);
        cboEmb.addItem(s);
        cboTipo.addItem(s);
        ArrayList lsF = new ArrayList();
        ArrayList lsE = new ArrayList();
        ArrayList lsT = new ArrayList();

        for (Produto o : lstProduto()) {
            if (o.isActivo()) {
                String f = o.getFornecedor();
                String e = o.getTipoDeEmbalagem();
                String t = o.getTipoDeProduto();
                if (!lsF.contains(f)) {
                    lsF.add(f);
                    cboForn.addItem(f);
                }
                if (!lsE.contains(e)) {
                    lsE.add(e);
                    cboEmb.addItem(e);
                }
                if (!lsT.contains(t)) {
                    lsT.add(t);
                    cboTipo.addItem(t);
                }
            }
        }
    }

    public void listarNaTabelaCarregar(JTable tab, String forn, String emb, String tip, String search) {
        ((DefaultTableModel) tab.getModel()).setNumRows(0);

        ArrayList<Produto> lsF = new ArrayList();
        ArrayList<Produto> lsE = new ArrayList();
        ArrayList<Produto> lsT = new ArrayList();
        ArrayList<Produto> lsAll = new ArrayList();
        for (Produto o : lstProduto()) {
            if (o.isActivo() && o.getQuantidade() > 0) {
                String f = o.getFornecedor();
                String e = o.getTipoDeEmbalagem();
                String t = o.getTipoDeProduto();

                if (forn.equalsIgnoreCase("Todos")) {
                    lsF.add(o);
                } else {
                    if (f.equalsIgnoreCase(forn)) {
                        lsF.add(o);
                    }
                }
                if (emb.equalsIgnoreCase("Todos")) {
                    lsE.add(o);
                } else {
                    if (e.equalsIgnoreCase(emb)) {
                        lsE.add(o);
                    }
                }
                if (tip.equalsIgnoreCase("Todos")) {
                    lsT.add(o);
                } else {
                    if (t.equalsIgnoreCase(tip)) {
                        lsT.add(o);
                    }
                }
                if (lsF.contains(o) && lsE.contains(o) && lsT.contains(o)) {
                    lsAll.add(o);
                }
            }
        }
        for (Produto o : lsAll) {
            String n = toUpperCase(o.getNome());
            String v = toUpperCase(o.getDataValidade());
            if (n.contains(toUpperCase(search))
                    || v.contains(toUpperCase(search))) {
                registoCarregar(tab, o);
            }
        }
    }

    private Object registoCarregar(JTable tbl, Produto c) {
        Object[] registo = {
            c.getId(), (descricao(c) + " - " + c.getFornecedor()),
            c.getQuantidade(), c.getPrecoVenda()};
        DefaultTableModel modelo = (DefaultTableModel) tbl.getModel();
        modelo.addRow(registo);
        return registo;
    }

    Validacoes val = new Validacoes();
//    +++++++++++++++++++++++++++++

    public void gerarPDF_Tbl(JTable tab) {
        MessageFormat h = new MessageFormat("Relatorio de ...");
        MessageFormat f = new MessageFormat("Page{0,number,integer}");
        try {
            tab.print(JTable.PrintMode.NORMAL, h, f);
        } catch (Exception e) {
            val.msg(null, "Erro ao imprimir tabela." + e);
        }
    }

    public void criarPDF() {
        try {
            Document doc = new Document();
            FileOutputStream fich = new FileOutputStream("Relatorio de Produtos.pdf");
            PdfWriter.getInstance(doc, fich);
            doc.open();
            Paragraph titulo = new Paragraph("Lista de Produtos");
            doc.add(titulo);

            PdfPTable tab = new PdfPTable(7);
            tab.addCell("ID");
            tab.addCell("NOME");
            tab.addCell("TIPO DE PRODUTO");
            tab.addCell("TIPO DE EMBALAGEM");
            tab.addCell("DATA DE FRABRICO");
            tab.addCell("DATA DE VENCIMENTO");
            tab.addCell("FORNECEDOR");
            for (Produto p : lstProduto()) {
                tab.addCell("" + p.getId());
                tab.addCell("" + p.getNome());
                tab.addCell("" + p.getTipoDeProduto());
                tab.addCell("" + p.getTipoDeEmbalagem());
                tab.addCell("" + p.getDataFabrico());
                tab.addCell("" + p.getDataValidade());
                tab.addCell("FORNECEDOR");
            }
            doc.add(tab);
        } catch (Exception e) {
        }
    }

    private boolean isTodos(String s) {
        if (s.length() == 0) {
            s = "Todos";
        }
        return s.equalsIgnoreCase("Todos");
    }

    void logs(int id, String msg) {
        System.out.println(id + "# " + msg);
    }

    public ArrayList<Produto> listarNaTabelaRelatorio(JTable tab,
            String fornecedor,
            String embalagem,
            String tipo,
            String dataInProd,
            String dataFimProd,
            String searcProd) {
        ((DefaultTableModel) tab.getModel()).setNumRows(0);
        String msg = "";
        ArrayList<Produto> lsAll = new ArrayList();
        for (Produto o : lstProduto()) {
            msg = "";
            if (o.isActivo() && o.getQuantidade() > 0) {
                int id = o.getId();
                String f = o.getFornecedor();
                String e = o.getTipoDeEmbalagem();
                String t = o.getTipoDeProduto();
                String d = o.getDataValidade();
                String s = o.getNome();
                boolean forn = false, emb = false, tip = false, dti = false, dtf = false, src = false;
                forn = isTodos(fornecedor);
                emb = isTodos(embalagem);
                tip = isTodos(tipo);
                dti = isTodos(dataInProd);
                dtf = isTodos(dataFimProd);
                src = isTodos(searcProd);
                if (fornecedor.equals(f)) {
                    forn = true;
                }
                if (embalagem.equals(e)) {
                    emb = true;
                }
                if (tipo.equals(t)) {
                    tip = true;
                }
                if (!dti) {
                    boolean in = val.e_DataA_InferiorQ_DataB(dataInProd, d);
                    if (in) {
                        dti = true;
                    }
                }
                if (!dtf) {
                    boolean fm = val.e_DataA_InferiorQ_DataB(d, dataFimProd);
                    if (fm) {
                        dtf = true;
                    }
                }
                if (!src) {
                    if (toUpperCase(s).contains(toUpperCase(searcProd))) {
                        src = true;
                    }
                }

                msg = "" + forn + " - " + emb + " - " + tip + " - " + dti + " - " + dtf + " - " + src;
//                logs(-id, msg);
                msg = "" + fornecedor + " - " + embalagem + " - " + tipo + " - " + dataInProd + " - " + dataFimProd + " - " + searcProd;
//                logs(-id, msg);
                if (forn && emb && tip && dti && dtf && src) {
                    lsAll.add(o);
                    registo(tab, o);
                }
//                logs(-id, "");
            }
        }
        // val.msg(null, msg);
        return lsAll;
    }
}
