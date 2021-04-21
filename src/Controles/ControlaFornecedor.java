package Controles; 
import Modelos.Fornecedor;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
 
public class ControlaFornecedor extends ControlaGenerico<Object>{

    public ArrayList<Fornecedor> lst= new ArrayList<>();

    public ControlaFornecedor() {
        super(new Fornecedor().getClass());
         lst = lstFornecedor();
        if (lst.size() == 0) {
            cad();
            lst = lstFornecedor();
        }
    }

   

    void cad() {
        int id = 1;
        boolean activo = true;
        String nome = "Desconhecido";
        String localizacao = "Desconhecido";
        String contacto = "Desconhecido";
        String tipoDeProdutos = "Desconhecido";
        Fornecedor u = new Fornecedor(id, activo, nome, localizacao, contacto, tipoDeProdutos);
       cadastrar(u);
    }       


    public ArrayList<Fornecedor> lstFornecedor() {
        lst.clear();
       listaDeObjectoY().stream().map((ob) -> (Fornecedor) ob).forEachOrdered((f) -> {
            lst.add((Fornecedor) f);
        });
        return lst;
    }

    public ArrayList<Fornecedor> lstFornecedor(boolean activo) {
        lst.clear();  
        for (Fornecedor f :lstFornecedor()) {
            if (f.isActivo()==activo) {
                lst.add(f);
            } 
        }
        return lst;
    }

    public void listarNaTabela(JTable tbl) {
        ((DefaultTableModel) tbl.getModel()).setNumRows(0);
        lst = lstFornecedor();
        for (Fornecedor o : lst) {
            if (o.isActivo()) {
                registo(tbl, o);
            }
        }
    }
    public void listarNaTabela(JTable tbl,ArrayList<Fornecedor> l) {
        ((DefaultTableModel) tbl.getModel()).setNumRows(0); 
        for (Fornecedor o : l) {
            if (o.isActivo()) {
                registo(tbl, o);
            }
        }
    }

    private Object registo(JTable tbl, Fornecedor c) {
        Object[] registo = {c.getId(), c.getNome(), c.getContacto(),
            c.getTipoDeProdutos(),c.getLocalizacao()
        };
        DefaultTableModel modelo = (DefaultTableModel) tbl.getModel();
        modelo.addRow(registo);
        return registo;
    }
      public void preeche_JList(JList jList, ArrayList<Fornecedor> lstForn) {
        jList.removeAll();
        if (lstForn == null) {
            lstForn  = lstFornecedor();        }

        DefaultListModel dlm = new DefaultListModel();
        for (Fornecedor c : lstForn) {
            if (c.isActivo()) {
                String txt = c.getId() + "/" + c.getNome();
             addLinhaNa_jList(jList, dlm, txt);
            }
        }
    }
}
