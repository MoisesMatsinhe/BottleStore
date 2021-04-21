
package Controles;

import Modelos.Cliente; 
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marondo
 */
public final class ControlaCliente extends ControlaGenerico<Object>{

     public ArrayList<Cliente> lstClientes;

    public ControlaCliente() {
        super(new Cliente().getClass());
        lstClientes = new ArrayList<>();
        lstClientes = lstClientes();
        if (lstClientes.size() == 0) {
            cad();
            lstClientes = lstClientes();
        }
    }
 

    public final ArrayList<Cliente> lstClientes() {
        lstClientes.clear();
         listaDeObjectoY().stream().map((ob) -> (Cliente) ob).forEachOrdered((f) -> {
            lstClientes.add((Cliente) f);
        });
        return lstClientes;
    }
 

    void cad() {
        int id = 1;
        boolean activo = true;
        String nome = "Desconhecido";
        String contacto = "Desconhecido";
        String morada = "Desconhecido"; 
        Cliente u = new Cliente(id, activo, nome, morada, contacto);
        cadastrar(u);
    }
    
    public void listarNaTabela(JTable tbl) {
        ((DefaultTableModel) tbl.getModel()).setNumRows(0);
        lstClientes = lstClientes();
        for (Cliente o : lstClientes) {
            if (o.isActivo()) {
                registo(tbl, o);
            }
        }
    }
    public void listarNaTabela(JTable tbl,ArrayList<Cliente> l) {
        ((DefaultTableModel) tbl.getModel()).setNumRows(0); 
        for (Cliente o : l) {
            if (o.isActivo()) {
                registo(tbl, o);
            }
        }
    }

    private Object registo(JTable tbl, Cliente c) {
        Object[] registo = {c.getId(), c.getNome(),  c.getMorada(),c.getContacto(),};
        DefaultTableModel modelo = (DefaultTableModel) tbl.getModel();
        modelo.addRow(registo);
        return registo;
    }
}
