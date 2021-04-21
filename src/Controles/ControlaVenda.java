package Controles;

import Modelos.Cliente;
import Modelos.Venda;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import jdk.nashorn.internal.objects.NativeString;
import static jdk.nashorn.internal.objects.NativeString.toUpperCase;

public class ControlaVenda extends ControlaGenerico<Object> {

    public ArrayList<Venda> lst = new ArrayList<>();

    public ControlaVenda() {
        super(new Venda().getClass());
        lst = lstVenda();
    }

    public ArrayList<Venda> lstVenda() {
        lst.clear();
        listaDeObjectoY().stream().map((ob) -> (Venda) ob).forEachOrdered((f) -> {
            lst.add((Venda) f);
        });
        return lst;
    }

    public void fillCboClient(JComboBox cbo) {
        cbo.removeAllItems();
        for (Cliente f : new ControlaCliente().lstClientes) {
            if (f.isActivo()) {
                String s = f.getId() + "/" + f.getNome();
                cbo.addItem(s);
            }
        }
    }

    public String on_cchangeCboClient(JTextField txtContactoCli, String txtInCboCli) {
        String a = val.extraiAPrimeiraOcorrencia(txtInCboCli, '/');
        int idCli = val.e_int(a);
        for (Cliente f : new ControlaCliente().lstClientes) {
            if (f.isActivo() && f.getId() == idCli) {
                val.poeTxt(txtContactoCli, f.getContacto());
                return f.getContacto();
            }
        }
        return "";
    }

    public void listarNaTabela(JTable tbl) {
        ((DefaultTableModel) tbl.getModel()).setNumRows(0);
        lst = lstVenda();
        for (Venda o : lst) {
            if (o.isActivo()) {
                registo(tbl, o);
            }
        }
    }

    public void listarNaTabelaCarregar(JTable tbl, ArrayList<Venda> lstCarregar) {
        ((DefaultTableModel) tbl.getModel()).setNumRows(0);
        int i = 1;
        for (Venda o : lstCarregar) {
            o.setId(i);
            registoCarregar(tbl, o);
            i++;
        }
    }

    public void listarNaTabela(JTable tbl, ArrayList<Venda> l) {
        ((DefaultTableModel) tbl.getModel()).setNumRows(0);
        for (Venda o : l) {
            if (o.isActivo()) {
                registo(tbl, o);
            }
        }
    }

    private Object registo(JTable tbl, Venda c) {
        Object[] registo = {
            c.getId(),
            c.getCodigoProd(),
            c.getQuantidade(),
            c.getValorUnitProd(),
            c.getTotalVenda(),};
        DefaultTableModel modelo = (DefaultTableModel) tbl.getModel();
        modelo.addRow(registo);
        return registo;
    }

    private Object registoRelatorio(JTable tbl, Venda c) {
        Object[] registo = {
            //             private int id;  
            //    private boolean activo; 
            //    private String codigoProd; // sera: id/nome
            //    private String codigoCliente; 
            //    
            //    private int quantidade;
            //    private double valorUnitProd; 
            //    private double valorDesconto; 
            //    private double totalProd; 
            //    private double totalVenda; 
            //    private double totalPago;
            //    private double totalTroco; 
            //    private String dataVenda; 
            //    private String estado; 
            c.getId(),
            c.getCodigoProd(),
            c.getCodigoCliente(),
            c.getQuantidade(),
            c.getValorUnitProd(),
            c.getTotalProd(),
            c.getDataVenda(),
            c.getEstado(),
            c.getUsuario(),
        };
        DefaultTableModel modelo = (DefaultTableModel) tbl.getModel();
        modelo.addRow(registo);
        return registo;
    }

    private Object registoCarregar(JTable tbl, Venda c) {
        Object[] registo = {
            c.getId(),
            c.getCodigoProd(),
            c.getQuantidade(),
            c.getValorUnitProd(),
            c.getTotalVenda(),};
        DefaultTableModel modelo = (DefaultTableModel) tbl.getModel();
        modelo.addRow(registo);
        return registo;
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

    public ArrayList<Venda> listarNaTabelaRelatorio(JTable tab,
            String cliente,
            String estado,
            String dataInicio,
            String dataFim,
            String search) {
        ((DefaultTableModel) tab.getModel()).setNumRows(0);
        String msg = "";
        ArrayList<Venda> lsAll = new ArrayList();
        for (Venda o : lstVenda()) {msg = "";
            if (o.isActivo() && o.getQuantidade() > 0) {
                int id = o.getId();
                String c = o.getCodigoCliente();
                String e = o.getEstado();
                String d = o.getDataVenda();
                String s = o.getCodigoProd();
                boolean cli = false, est = false, dti = false, dtf = false, src = false;
                cli = isTodos(cliente);
                est = isTodos(estado);
                dti = isTodos(dataInicio);
                dtf = isTodos(dataFim);
                src = isTodos(search);
                if (cliente.equals(c)) {
                    cli = true;
                }
                if (estado.equals(e)) {
                    est = true;
                }
                if (!dti) {
                    String a = val.extraiAPrimeiraOcorrencia(d, ' ');
                    boolean in = val.e_DataA_InferiorQ_DataB(dataInicio,a);
                    msg = "dti: dataInicio[" + dataInicio + "] < dtVenda[" + a + "] = " + in;
                    if (in) {
                        dti = true;
                    }
//                    logs(id, msg);
                }
                if (!dtf) {
                    String a = val.extraiAPrimeiraOcorrencia(d, ' ');
                    boolean fm = val.e_DataA_InferiorQ_DataB(a, dataFim);
                     msg = "dtf: dtVenda[" + a + "] < dataFim[" + dataFim + "] = " + fm;
                    if (fm) {
                        dtf = true;
                    }
//                    logs(id, msg);
                }
               
                if (!src) {
                    if (toUpperCase(s).contains(toUpperCase(search))) {
                        src = true;
                    }
                }

                if (cli && est && dti && dtf && src) {
                    lsAll.add(o);
                    registoRelatorio(tab, o);
                }
//                    logs(-id, "");
            }
        }
       // val.msg(null, msg);
        return lsAll;
    }

    public void fillCbo_Cli_Est(JComboBox cboCli, JComboBox cboEst) {
        cboCli.removeAllItems();
        cboEst.removeAllItems();
        String s = "Todos";
        cboCli.addItem(s);
        cboEst.addItem(s);
        ArrayList lsC = new ArrayList();
        ArrayList lsE = new ArrayList();

        for (Venda o : lstVenda()) {
            if (o.isActivo()) {
                String c = o.getCodigoCliente();
                String e = o.getEstado();
                if (!lsC.contains(c)) {
                    lsC.add(c);
                    cboCli.addItem(c);
                }
                if (!lsE.contains(e)) {
                    lsE.add(e);
                    cboEst.addItem(e);
                }
            }
        }
    }
}
