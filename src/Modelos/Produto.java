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
public class Produto implements Serializable{
    @Id
    @GeneratedValue
    
    private int id;
    private boolean activo;
    private String nome;
    private String tipoDeProduto;
    private String tipoDeEmbalagem;
    private String dataEntrada;
    private String dataFabrico;
    private String dataValidade;
    private String fornecedor;
    
    private int quantidade;
    private double precoCompra;
    private int lucro;
    private double precoVenda;

    public Produto() {
    }

    public Produto(int id, boolean activo, String nome, String tipoDeProduto, String tipoDeEmbalagem, String dataEntrada, String dataFabrico, String dataValidade, String fornecedor, int quantidade, double precoCompra, int lucro, double precoVenda) {
        this.id = id;
        this.activo = activo;
        this.nome = nome;
        this.tipoDeProduto = tipoDeProduto;
        this.tipoDeEmbalagem = tipoDeEmbalagem;
        this.dataEntrada = dataEntrada;
        this.dataFabrico = dataFabrico;
        this.dataValidade = dataValidade;
        this.fornecedor = fornecedor;
        this.quantidade = quantidade;
        this.precoCompra = precoCompra;
        this.lucro = lucro;
        this.precoVenda = precoVenda;
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

    public String getTipoDeProduto() {
        return tipoDeProduto;
    }

    public void setTipoDeProduto(String tipoDeProduto) {
        this.tipoDeProduto = tipoDeProduto;
    }

    public String getTipoDeEmbalagem() {
        return tipoDeEmbalagem;
    }

    public void setTipoDeEmbalagem(String tipoDeEmbalagem) {
        this.tipoDeEmbalagem = tipoDeEmbalagem;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getDataFabrico() {
        return dataFabrico;
    }

    public void setDataFabrico(String dataFabrico) {
        this.dataFabrico = dataFabrico;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public int getLucro() {
        return lucro;
    }

    public void setLucro(int lucro) {
        this.lucro = lucro;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

}
