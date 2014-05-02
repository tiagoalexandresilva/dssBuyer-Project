/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import Negocio.GestaoNegocios.Troca;
import Negocio.GestaoUtilizadores.Utilizador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author helder
 */
public class TrocasDAO implements Map<String, Troca>{

    public TrocasDAO() {}

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean containsKey(Object key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Troca get(Object key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Troca put(String key, Troca value) {
        try {
            Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@192.168.123.129:1158:BD","trabalho", "trabalho");
            PreparedStatement pstm = conn.prepareStatement("INSERT INTO trocas VALUES (id_troca.nextval, 0, ?, ?, ?, ?)");
            pstm.setString(1, value.getEmissor().getIdUtilizador());
            pstm.setString(2, value.getReceptor().getIdUtilizador());
            pstm.setInt(3, Integer.parseInt(value.getProdutoEmissor().getIdProduto()));
            pstm.setInt(4, Integer.parseInt(value.getProdutoReceptor().getIdProduto()));
            pstm.executeUpdate();
            pstm.close();
            conn.close();
            return value;
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }

    @Override
    public Troca remove(Object key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void putAll(Map<? extends String, ? extends Troca> m) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Set<String> keySet() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<Troca> values() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Set<Entry<String, Troca>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void putUpdate(Troca t) {
        try {
            Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@192.168.123.129:1158:BD","trabalho", "trabalho");
            PreparedStatement pstm = conn.prepareStatement("UPDATE trocas SET estado=? WHERE id_troca=?");
            pstm.setInt(2, Integer.parseInt(t.getIdTroca()));
            int estado = (t.getEstado().equals("aceite")) ? 1 : 2;
            pstm.setInt(1, estado);
            pstm.executeUpdate();
            pstm.close();
            conn.close();
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }
    
    public Collection<Troca> values(Utilizador u) {
        try {
            ArrayList<Troca> resultados = new ArrayList<Troca>(); 
            Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@192.168.123.129:1158:BD","trabalho", "trabalho");
            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM trocas WHERE id_emissor=? OR id_receptor=?");
            pstm.setString(1, u.getIdUtilizador());
            pstm.setString(2, u.getIdUtilizador());
            ResultSet rs = pstm.executeQuery();
            UtilizadoresDAO users = new UtilizadoresDAO();
            ProdutosDAO prods = new ProdutosDAO();
            while (rs.next()) {
                Troca t = new Troca();
                t.setIdTroca(rs.getString(1));
                if (rs.getInt(2) == 0) {
                    t.setEstado("em analise");
                }
                else if (rs.getInt(2) == 1) {
                    t.setEstado("aceite");
                }
                else {
                    t.setEstado("rejeitada");
                }
                t.setEmissor(users.get(rs.getString(3)));
                t.setReceptor(users.get(rs.getString(4)));
                t.setProdutoEmissor(prods.get(rs.getString(5)));
                t.setProdutoReceptor(prods.get(rs.getString(6)));
                resultados.add(t);
            }
            rs.close();
            pstm.close();
            conn.close();
            return resultados;
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }
    
}
