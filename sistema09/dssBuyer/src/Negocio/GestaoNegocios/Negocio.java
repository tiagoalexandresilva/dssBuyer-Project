package Negocio.GestaoNegocios;

import Negocio.GestaoProdutos.Produto;
import Negocio.GestaoUtilizadores.Utilizador;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Negocio {

    private Produto produto;
    private String idNegocio;
    private String data;
    private int quantidade;
    private float montantePago;
    private String feedVendedor;
    private String feedComprador;
    private Utilizador vendedor;
    private Utilizador comprador;
    
    public Negocio() {
        this.produto = null;
        this.idNegocio = null;
        GregorianCalendar now = new GregorianCalendar();
        this.data = now.get(Calendar.DAY_OF_MONTH) + "-" + (now.get(Calendar.MONTH)+1) + "-" + now.get(Calendar.YEAR);
        this.quantidade = 0;
        this.montantePago = 0;
        this.feedComprador = null;
        this.feedVendedor = null;
        this.vendedor = null;
        this.comprador = null;
    }
    
    public Negocio(Produto p, String id, String d, int q, float m, String fv, String fc, Utilizador v, Utilizador c) {
        this.produto = p;
        this.idNegocio = id;
        this.data = d;
        this.quantidade = q;
        this.montantePago = m;
        this.feedVendedor = fv;
        this.feedComprador = fc;
        this.vendedor = v;
        this.comprador = c;
    } 
    

    public Produto getProduto() {
	return this.produto;
    }

    public void setProduto(Produto produto) {
	this.produto = produto;
    }

    public String getIdNegocio() {
	return this.idNegocio;
    }

    public void setIdNegocio(String idNegocio) {
	throw new UnsupportedOperationException();
    }

    public String getData() {
	return this.data;
    }

    public void setData(String data) {
	throw new UnsupportedOperationException();
    }

    public int getQuantidade() {
	return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
	this.quantidade = quantidade;
    }

    public float getMontantePago() {
	return this.montantePago;
    }

    public void setMontantePago(float montantePago) {
	this.montantePago = montantePago;
    }

    public String getFeedVendedor() {
	return this.feedVendedor;
    }

    public void setFeedVendedor(String feedVendedor) {
	this.feedVendedor = feedVendedor;
    }

    public String getFeedComprador() {
	return this.feedComprador;
    }

    public void setFeedComprador(String feedComprador) {
	this.feedComprador = feedComprador;
    }

    public Utilizador getVendedor() {
	return this.vendedor;
    }

    public void setVendedor(Utilizador vendedor) {
	this.vendedor = vendedor;
    }

    public Utilizador getComprador() {
	return this.comprador;
    }

    public void setComprador(Utilizador comprador) {
	this.comprador = comprador;
    }

}