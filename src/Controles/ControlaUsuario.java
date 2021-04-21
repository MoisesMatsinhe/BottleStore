package Controles;

import Modelos.Usuario;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marondo
 */
public final class ControlaUsuario extends ControlaGenerico<Object> {

    public ArrayList<Usuario> lstUsuarios;

    public ControlaUsuario() {
        super(new Usuario().getClass());
        lstUsuarios = new ArrayList<>();
        lstUsuarios = lstUsuarios();
        if (lstUsuarios.size() == 0) {
            cad();
            lstUsuarios = lstUsuarios();
        }
    }

    public final ArrayList<Usuario> lstUsuarios() {
        lstUsuarios.clear();
        listaDeObjectoY().stream().map((ob) -> (Usuario) ob).forEachOrdered((f) -> {
            lstUsuarios.add((Usuario) f);
        });
        return lstUsuarios;
    }

    public Usuario possoLogar(String user, String pass) {
        for (Usuario u : lstUsuarios()) {
            if (u.getUser().equalsIgnoreCase(user) && u.getPass().equalsIgnoreCase(pass)) {
                return u;
            }
        }
        return null;
    }

    void cad() {
        int id = 1;
        boolean activo = true;
        String nome = "admin";
        String user = "admin";
        String pass = "admin";
        String tipo = "admin";
        Usuario u = new Usuario(id, activo, nome, user, pass, tipo);
        cadastrar(u);
    }

    public void listarNaTabela(JTable tbl) {
        ((DefaultTableModel) tbl.getModel()).setNumRows(0);
        lstUsuarios = lstUsuarios();
        for (Usuario o : lstUsuarios) {
            if (o.isActivo()) {
                registo(tbl, o);
            }
        }
    }

    public void listarNaTabela(JTable tbl, ArrayList<Usuario> l) {
        ((DefaultTableModel) tbl.getModel()).setNumRows(0);
        for (Usuario o : l) {
            if (o.isActivo()) {
                registo(tbl, o);
            }
        }
    }

    private Object registo(JTable tbl, Usuario c) {
        Object[] registo = {c.getId(), c.getNome(), c.getUser(), c.getTipo()};
        DefaultTableModel modelo = (DefaultTableModel) tbl.getModel();
        modelo.addRow(registo);
        return registo;
    }

    public Usuario logar(String user, String pass) {
        for (Usuario o : lstUsuarios()) {
            if (o.getUser().equalsIgnoreCase(user)
                    && o.getPass().equalsIgnoreCase(pass)) {
                return o;
            }
        }
        return null;
    }
}
