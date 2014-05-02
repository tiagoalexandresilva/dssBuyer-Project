package Negocio.GestaoNegocios;

import Negocio.GestaoProdutos.Produto;
import Negocio.GestaoUtilizadores.Utilizador;

public class Troca {

    private String idTroca;
    private String estado;
    private Utilizador emissor;
    private Utilizador receptor;
    private Produto produtoEmissor;
    private Produto produtoReceptor;

    public String getIdTroca() {
	return this.idTroca;
    }

    public void setIdTroca(String idTroca) {
	this.idTroca = idTroca;
    }

    public Utilizador getEmissor() {
	return this.emissor;
    }

    public void setEmissor(Utilizador emissor) {
	this.emissor = emissor;
    }

    public Utilizador getReceptor() {
	return this.receptor;
    }

    public void setReceptor(Utilizador receptor) {
	this.receptor = receptor;
    }

    public Produto getProdutoEmissor() {
	return this.produtoEmissor;
    }

    public void setProdutoEmissor(Produto produtoEmissor) {
	this.produtoEmissor = produtoEmissor;
    }

    public Produto getProdutoReceptor() {
	return this.produtoReceptor;
    }

    public void setProdutoReceptor(Produto produtoReceptor) {
	this.produtoReceptor = produtoReceptor;
    }
    
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }

}