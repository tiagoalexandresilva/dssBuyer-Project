package Negocio;

import Dados.NegociosDAO;
import Dados.ProdutosDAO;
import Dados.TrocasDAO;
import Dados.UtilizadoresDAO;
import Negocio.GestaoNegocios.Negocio;
import Negocio.GestaoNegocios.Troca;
import Negocio.GestaoProdutos.Produto;
import Negocio.GestaoUtilizadores.Utilizador;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;
import java.util.Observer;

public class dssBuyer extends Observable implements Observer {
    
    private UtilizadoresDAO utilizadores;
    private ProdutosDAO produtos;
    private NegociosDAO negocios;
    private TrocasDAO propostasTrocas;
    
    public dssBuyer() {
        this.utilizadores = new UtilizadoresDAO();
        this.produtos = new ProdutosDAO();
        this.negocios = new NegociosDAO();
        this.propostasTrocas = new TrocasDAO();
    }

    public boolean existeUtilizador(String email) {
	return this.utilizadores.containsKey(email);
    }

    public void addUtilizador(Utilizador u) throws BuyerException {
	String email = u.getIdUtilizador();
        boolean existe = this.utilizadores.containsKey(email);
        if (existe) {
            throw new BuyerException("Já existe um utilizador registado com o email inserido...");
        }
        this.utilizadores.put(email, u);
    }

    public void removeUtilizador(String email) {
	throw new UnsupportedOperationException();
    }

    public Utilizador login(String e, String p) throws BuyerException {
	Utilizador u = this.utilizadores.get(e);
        if (u == null) {
            throw new BuyerException("Utilizador inexistente...");
        }
        boolean valida = u.validaLogin(this.utilizadores.encriptaPassword(p));
        if (!valida) {
            throw new BuyerException("Password errada...");
        }
        boolean bloqueado = u.isBloqueado();
        if (bloqueado) {
            throw new BuyerException("A sua conta encontra-se bloqueada...");
        }
        return u;
    }
    
    public String encriptaPassword(String s) {
        return this.utilizadores.encriptaPassword(s);
    }
    
    public Collection<Produto> procuraProdutos(String criterio) throws BuyerException {
        ArrayList<Produto> resultados = new ArrayList<Produto>();
        for (Produto p: this.produtos.values()) {
            if (p.containsCriterio(criterio)) {
                resultados.add(p);
            }
        }
        if (resultados.isEmpty()) {
            throw new BuyerException("Não foi nenhum produto com esse critério de pesquisa...");
        }
        return resultados;
    }
    
    public void addProduto(Produto p) {
        this.produtos.put(p.getIdProduto(), p);
        this.setChanged();
        this.notifyObservers();
    }
    
    public Collection<Produto> getProdutos() {
        return this.produtos.values();
    }

    @Override
	public void update(Observable o, Object arg) {
        this.setChanged();
        this.notifyObservers();
    }

    public void actualizaProduto(Produto p) throws SQLException {
        this.produtos.putUpdate(p);
        this.setChanged();
        this.notifyObservers();
    }

    public void setNewPassword(String email, String pass) throws BuyerException {
        if (!this.existeUtilizador(email)) {
            throw new BuyerException("Não existe nenhum registo com esse email...");
        }
        this.utilizadores.setNewPassword(email, pass);
    }

    public void removeProduto(Produto p) {
        this.produtos.remove(p.getIdProduto());
        this.setChanged();
        this.notifyObservers();
    }

    public void addNegocio(Negocio negocio) {
        this.negocios.put("", negocio);
        this.setChanged();
        this.notifyObservers();
    }

    public void actualizaUtilizador(Utilizador u) {
        this.utilizadores.putUpdate(u);
        this.setChanged();
        this.notifyObservers();
    }
    
    public void atualizaNegocio(Negocio n) {
        this.negocios.putUpdate(n);
        this.setChanged();
        this.notifyObservers();
    } 

    public Collection<Utilizador> getUtilizadores() {
        return this.utilizadores.values();
    }
    
    public void bloqueiaUtilizador(Utilizador u) {
        u.setBloqueado(true);
        this.utilizadores.putUpdate(u);
        this.setChanged();
        this.notifyObservers();
    }
    
    public void desbloqueiaUtilizador(Utilizador u) {
        u.setBloqueado(false);
        this.utilizadores.putUpdate(u);
        this.setChanged();
        this.notifyObservers();
    }
    
    public Troca tentaTroca(Collection<Produto> pesquisa, Collection<Produto> user) {
       Troca troca = null;
       for (Produto pUser: user) {
           if (pUser.getStock() > 0) {
               for (Produto pPesquisa: pesquisa) {
                   if (pPesquisa.getStock() > 0 && pPesquisa.equivale(pUser)) {
                       troca = new Troca();
                       troca.setEmissor(pUser.getVendedor());
                       troca.setProdutoEmissor(pUser);
                       troca.setReceptor(pPesquisa.getVendedor());
                       troca.setProdutoReceptor(pPesquisa);
                   }
               }
           }
       }
       return troca;
    }

    public void addTroca(Troca t) {
        this.propostasTrocas.put("", t);
        this.setChanged();
        this.notifyObservers();
    }
    
    public void atualizaTroca(Troca t) {
        this.propostasTrocas.putUpdate(t);
        this.setChanged();
        this.notifyObservers();
    }

    public void addNegocioTroca(Negocio n1, Negocio n2) {
        this.negocios.put("", n1);
        this.negocios.put("", n2);
    }

}