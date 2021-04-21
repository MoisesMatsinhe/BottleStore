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
public class Venda  implements Serializable {
    @Id
    @GeneratedValue

    private int id;  
    private boolean activo; 
    private String codigoProd; // sera: id/nome
    private String codigoCliente; 
    
    private int quantidade;
    private double valorUnitProd; 
    private double valorDesconto; 
    private double totalProd; 
    private double totalVenda; 
    private double totalPago;
    private double totalTroco; 
    private String dataVenda; 
    private String estado;  
    private String usuario; 

    public Venda() {
    }

    public Venda(boolean activo, String codigoProd, String codigoCliente, int quantidade, double valorUnitProd, double valorDesconto, double totalVenda, double totalPago, double totalTroco, String dataVenda, String estado,double totalProd,String usuario) {
        this.activo = activo;
        this.codigoProd = codigoProd;
        this.codigoCliente = codigoCliente;
        this.quantidade = quantidade;
        this.valorUnitProd = valorUnitProd;
        this.valorDesconto = valorDesconto;
        this.totalVenda = totalVenda;
        this.totalPago = totalPago;
        this.totalTroco = totalTroco;
        this.dataVenda = dataVenda;
        this.estado=estado;
        this.totalProd=totalProd;
        this.usuario=usuario;
    }

    public double getTotalProd() {
        return totalProd;
    }

    public void setTotalProd(double totalProd) {
        this.totalProd = totalProd;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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

    public String getCodigoProd() {
        return codigoProd;
    }

    public void setCodigoProd(String codigoProd) {
        this.codigoProd = codigoProd;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorUnitProd() {
        return valorUnitProd;
    }

    public void setValorUnitProd(double valorUnitProd) {
        this.valorUnitProd = valorUnitProd;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public double getTotalVenda() {
        return totalVenda;
    }

    public void setTotalVenda(double totalVenda) {
        this.totalVenda = totalVenda;
    }

    public double getTotalPago() {
        return totalPago;
    }

    public void setTotalPago(double totalPago) {
        this.totalPago = totalPago;
    }

    public double getTotalTroco() {
        return totalTroco;
    }

    public void setTotalTroco(double totalTroco) {
        this.totalTroco = totalTroco;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
 
}
