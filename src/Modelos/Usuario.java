package Modelos;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Marondo
 */
@Entity
public class Usuario implements Serializable{
@Id
@GeneratedValue
    private int id;
    private boolean activo;
    private String nome;
    private String user;
    private String pass;
    private String tipo;

    public Usuario() {
    }

    public Usuario(int id, boolean activo, String nome, String user, String pass, String tipo) {
        this.id = id;
        this.activo = activo;
        this.nome = nome;
        this.user = user;
        this.pass = pass;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
