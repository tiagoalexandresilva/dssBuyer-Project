package Negocio.GestaoUtilizadores;

import Dados.NegociosDAO;
import Dados.ProdutosDAO;
import Dados.TrocasDAO;
import Negocio.GestaoNegocios.Negocio;
import Negocio.GestaoNegocios.Troca;
import Negocio.GestaoProdutos.Produto;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;

public abstract class Utilizador extends Observable {

    private ProdutosDAO produtosInseridos;
    private TrocasDAO propostasTroca;
    private NegociosDAO negociosEfetuados;
    private String idUtilizador;
    private String nome;
    private String morada;
    private String codPostal;
    private String localidade;
    private String dataNasc;
    private String dataReg;
    private String password;
    private boolean bloqueado;
    private int feed;
    
    public Utilizador(String id, String n, String m, String c, String l, String dn, String dr, String p, int f, boolean b) {
        this.produtosInseridos = new ProdutosDAO();
        this.propostasTroca = new TrocasDAO();
        this.negociosEfetuados = new NegociosDAO();
        this.feed = f;
        this.bloqueado = b;
        this.idUtilizador = id;
        this.nome = n;
        this.morada = m;
        this.codPostal = c;
        this.localidade = l;
        this.dataNasc = dn;
        this.dataReg = dr;
        this.password = p;
    }

    public Collection<Produto> getProdutosInseridos() {
	return this.produtosInseridos.values(this);
    }

    public void setProdutosInseridos(Produto produtosInseridos) {
	throw new UnsupportedOperationException();
    }

    public Collection<Troca> getPropostasTroca() {
	return this.propostasTroca.values(this);
    }

    public void setPropostasTroca(Troca propostasTroca) {
	throw new UnsupportedOperationException();
    }

    public Collection<Negocio> getNegociosEfetuados() {
	return this.negociosEfetuados.values(this);
    }

    public void setNegociosEfetuados(Negocio negociosEfetuados) {
	throw new UnsupportedOperationException();
    }

    public String getIdUtilizador() {
	return this.idUtilizador;
    }

    public void setIdUtilizador(String idUtilizador) {
	throw new UnsupportedOperationException();
    }

    public String getNome() {
	return this.nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getMorada() {
	return this.morada;
    }

    public void setMorada(String morada) {
	this.morada = morada;
    }

    public String getCodPostal() {
	return this.codPostal;
    }

    public void setCodPostal(String codPostal) {
	this.codPostal = codPostal;
    }

    public String getLocalidade() {
	return this.localidade;
    }

    public void setLocalidade(String localidade) {
	this.localidade = localidade;
    }

    public String getDataNasc() {
	return this.dataNasc;
    }

    public void setDataNasc(String dataNasc) {
	throw new UnsupportedOperationException();
    }

    public String getDataReg() {
	return this.dataReg;
    }

    public void setDataReg(String dataReg) {
	throw new UnsupportedOperationException();
    }

    public String getPassword() {
	return this.password;
    }

    public void setPassword(String password) {
	throw new UnsupportedOperationException();
    }

    public boolean isBloqueado() {
	return this.bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
	this.bloqueado = bloqueado;
    }

    public int getFeed() {
	return this.feed;
    }

    public void setFeed(int feed) {
	throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param p
     */
    public boolean validaLogin(String p) {
	boolean valida = false;
        if (p.equals(this.password)) {
            valida = true;
        }
        return valida;
    }
    
    @Override
    public String toString() {
        return this.idUtilizador + "(" + this.feed + ")";
    }
    
    public Collection<Negocio> getCompras() {
        ArrayList<Negocio> resultados = new ArrayList<Negocio>();
        for (Negocio n: this.getNegociosEfetuados()) {
            if (n.getComprador().getIdUtilizador().equals(this.idUtilizador)) {
                resultados.add(n);
            }
        }
        return resultados;
    }
    
    public Collection<Negocio> getVendas() {
        ArrayList<Negocio> resultados = new ArrayList<Negocio>();
        for (Negocio n: this.getNegociosEfetuados()) {
            if (n.getVendedor().getIdUtilizador().equals(this.idUtilizador)) {
                resultados.add(n);
            }
        }
        return resultados;
    }
    
    public void incrementaFeed() {
        this.feed++;
    }
    
    public void decrementaFeed() {
        this.feed--;
    }

}