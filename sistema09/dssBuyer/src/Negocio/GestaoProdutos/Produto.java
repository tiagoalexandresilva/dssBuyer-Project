package Negocio.GestaoProdutos;

import Negocio.GestaoUtilizadores.Utilizador;

public abstract class Produto {

    private String idProduto;
    private String titulo;
    private String descricao;
    private int stock;
    private float preco;
    private boolean bloqueado;
    private Utilizador vendedor;
    
    public Produto(String t, String d, int s, float p, Utilizador u) {
        this.idProduto = "0";
        this.titulo = t;
        this.descricao = d;
        this.stock = s;
        this.preco = p;
        this.vendedor = u;
        this.bloqueado = false;
    }
    
    public Produto(String id, String t, String d, int s, float p, boolean b, Utilizador u) {
        this.idProduto = id;
        this.titulo = t;
        this.descricao = d;
        this.stock = s;
        this.preco = p;
        this.bloqueado = b;
        this.vendedor = u;
    }

    public String getIdProduto() {
	return this.idProduto;
    }

    public void setIdProduto(String idProduto) {
	throw new UnsupportedOperationException();
    }

    public String getTitulo() {
	return this.titulo;
    }

    public void setTitulo(String titulo) {
	this.titulo = titulo;
    }

    public String getDescricao() {
	return this.descricao;
    }

    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }

    public int getStock() {
	return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPreco() {
	return this.preco;
    }

    public void setPreco(float preco) {
	this.preco = preco;
    }

    public boolean isBloqueado() {
	return this.bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
	throw new UnsupportedOperationException();
    }

    public Utilizador getVendedor() {
	return this.vendedor;
    }

    public void setVendedor(Utilizador vendedor) {
	throw new UnsupportedOperationException();
    }
    
    public boolean containsCriterio(String criterio) {
        boolean contem = false;
        boolean validaT = this.titulo.toUpperCase().contains(criterio.toUpperCase());
        boolean validaD = this.descricao.toUpperCase().contains(criterio.toUpperCase());
        if (validaD || validaT) {
            contem = true;
        }
        return contem;
    }
    
    public boolean equivale(Produto p) {
        boolean equivale = false;
        if (p.getPreco() > (this.preco - this.preco * 0.05) && p.getPreco() < (this.preco + this.preco * 0.05)) {
            equivale = true;
        }
        return equivale;
    }

}