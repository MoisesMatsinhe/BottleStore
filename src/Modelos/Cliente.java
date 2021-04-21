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
public class Cliente implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private boolean activo;
    private String nome;
    private String morada;
    private String contacto;

    public Cliente() {
    }

    public Cliente(int id, boolean activo, String nome, String morada, String contacto) {
        this.id = id;
        this.activo = activo;
        this.nome = nome;
        this.morada = morada;
        this.contacto = contacto;
    }

    public int getId()     {
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

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

}
