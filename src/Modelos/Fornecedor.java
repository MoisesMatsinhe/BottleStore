 
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
public class Fornecedor implements Serializable{
    @Id
    @GeneratedValue
    
    private int id;
    private boolean activo;
    private String nome;
    private String localizacao;
    private String contacto;
    private String tipoDeProdutos;

    public Fornecedor() {
    }

    public Fornecedor(int id, boolean activo, String nome, String localizacao, String contacto, String tipoDeProdutos) {
        this.id = id;
        this.activo = activo;
        this.nome = nome;
        this.localizacao = localizacao;
        this.contacto = contacto;
        this.tipoDeProdutos = tipoDeProdutos;
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

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getTipoDeProdutos() {
        return tipoDeProdutos;
    }

    public void setTipoDeProdutos(String tipoDeProdutos) {
        this.tipoDeProdutos = tipoDeProdutos;
    }
    
    
}
