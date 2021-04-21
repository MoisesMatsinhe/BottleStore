package Controles;

import Conexao.Utilitario;
import JARs.Validacoes;
import java.util.ArrayList;
import java.util.List; 
import javax.swing.DefaultListModel;
import javax.swing.JList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ControlaGenerico<G> {

    public final SessionFactory sf = Utilitario.getSessionFactory();
    Session sessao;
    Transaction ts;

    private ArrayList<G> listaGenerica;
    private final Object classeY;
    Validacoes val = new Validacoes();

    /**
     *
     * @param classeY
     */
    public ControlaGenerico(Object classeY) {
        listaGenerica = new ArrayList<>();
        this.classeY = classeY;
        listaGenerica = listaDeObjectoY();
    }

    public ArrayList<G> getListaGenerica() {
        return listaGenerica;
    }

    public void setListaGenerica(ArrayList<G> listaGenerica) {
        this.listaGenerica = listaGenerica;
    }

    public void habilitaSessao() {
        sessao = sf.openSession();
        ts = sessao.beginTransaction();
    }

    public void commit_AND_Close() {
        try {
            ts.commit();
            sessao.flush();
            sessao.close();
        } catch (Exception e) {
            val.msg(null, "Erro em:  commit_AND_Close(){}\n" + e);
        }
    }

    public void cadastrar(G ob) {
        try {
            habilitaSessao();
            sessao.save(ob);
        } catch (Exception ex) {
            val.msg(null, "Erro em cadastrar!\n" + ex);
        } finally {
            commit_AND_Close();
        }
    }

    public void actualizar(G ob) {
        try {
            habilitaSessao();
            sessao.update(ob);
        } catch (Exception ex) {
            val.msg(null, "Erro em actualizar!\n" + ex);
        } finally {
            commit_AND_Close();
        }
    }

    public void apagarFisico(G ob) {
        try {
            habilitaSessao();
            sessao.delete(ob);
        } catch (Exception ex) {
            val.msg(null, "Erro em apagarFisico!\n" + ex);
        } finally {
            commit_AND_Close();
        }
    }

    public void apagarLogico(G ob) {
        try {
            habilitaSessao();
            sessao.update(ob);
        } catch (Exception ex) {
            val.msg(null, "Erro em apagarLogico!\n" + ex);
        } finally {
            commit_AND_Close();
        }
    }

    public G pesquisar(int id) {
        G e = null;
        try {
            habilitaSessao();
            e = (G) sessao.get((Class) classeY, id);
        } catch (Exception ex) {
            val.msg(null, "Erro em Pesquisar!\n" + ex);
        } finally {
            commit_AND_Close();
        }
        return e;
    }

    public ArrayList<G> listaDeObjectoY() {
        ArrayList<G> lst = new ArrayList<>();
        try {
            habilitaSessao();
            for (G ob : (List<G>) sessao.createCriteria((Class) classeY).list()) {
                lst.add(ob);
            }
        } catch (HibernateException ex) {
            val.msg(null, "Erro em carregar lista de ObjectoY!\n" + ex);
        } finally {
            commit_AND_Close();
        }
        return lst;
    }
 public void addLinhaNa_jList(JList l, DefaultListModel dlm, String txt) {
        if (!"".equals(txt)) {
            dlm.addElement(txt);
            l.setModel(dlm);
        }
    }
}
