/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import Negocio.GestaoNegocios.Negocio;
import Negocio.GestaoProdutos.Produto;
import Negocio.GestaoUtilizadores.Utilizador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author helder
 */
public class NegociosDAO implements Map<String, Negocio> {
    
    public NegociosDAO() {}

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
    public Negocio get(Object key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Negocio put(String key, Negocio value) {
        try {
            Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@192.168.123.129:1158:BD","trabalho", "trabalho");
            String sql = "INSERT INTO negocios VALUES (id_negocio.nextval,?,?,?,to_date(?,'dd-mm-yyyy'),?,?,?,?)";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, value.getVendedor().getIdUtilizador());
            pstm.setString(2, value.getComprador().getIdUtilizador());
            pstm.setInt(3, Integer.parseInt(value.getProduto().getIdProduto()));
            pstm.setString(4, value.getData());
            pstm.setInt(5, value.getQuantidade());
            pstm.setFloat(6, value.getMontantePago());
            pstm.setNull(7, Types.VARCHAR);
            pstm.setNull(8, Types.VARCHAR);
            pstm.executeUpdate();
            pstm.close();
            conn.close();
            return value;
        }
        catch (Exception e) {throw new NullPointerException (e.getMessage());}
    }

    @Override
    public Negocio remove(Object key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void putAll(Map<? extends String, ? extends Negocio> m) {
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
    public Collection<Negocio> values() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Set<Entry<String, Negocio>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Collection<Negocio> values(Utilizador u) {
        try {
            ArrayList<Negocio> resultados = new ArrayList<Negocio>();
            Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@192.168.123.129:1158:BD","trabalho", "trabalho");
            PreparedStatement pstm = conn.prepareStatement("SELECT id_negocio, id_vendedor, id_comprador, id_produto, data_compra, quantidade, montante_pago, feed_vendedor, feed_comprador, to_char(data_compra,'dd-mm-yyyy') FROM negocios WHERE id_vendedor=? OR id_comprador=?");
            pstm.setString(1, u.getIdUtilizador());
            pstm.setString(2, u.getIdUtilizador());
            ResultSet rs = pstm.executeQuery();
            UtilizadoresDAO utilizadores = new UtilizadoresDAO();
            ProdutosDAO produtos = new ProdutosDAO();
            while (rs.next()) {
                Utilizador vendedor = (rs.getString(2).equals(u.getIdUtilizador())) ? u : utilizadores.get(rs.getString(2));
                Utilizador comprador = (rs.getString(3).equals(u.getIdUtilizador())) ? u : utilizadores.get(rs.getString(3));
                Produto p = produtos.get(rs.getString(4));
                Negocio n = new Negocio(p, rs.getString(1), rs.getString(10), rs.getInt(6), rs.getFloat(7), rs.getString(8), rs.getString(9), vendedor, comprador);
                resultados.add(n);
            }
            rs.close();
            pstm.close();
            conn.close();
            return resultados;
        }
        catch (Exception e) { throw new NullPointerException(e.getMessage()); }
    }
    
    public void putUpdate(Negocio n) {
        try {
            Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@192.168.123.129:1158:BD","trabalho", "trabalho");
            String sql = "UPDATE negocios SET feed_vendedor=?, feed_comprador=? WHERE id_negocio=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            if (n.getFeedComprador() != null) {
                pstm.setString(2, n.getFeedComprador());
            }
            else {
                pstm.setNull(2, Types.VARCHAR);
            }
            if (n.getFeedVendedor() != null) {
                pstm.setString(1, n.getFeedVendedor());
            }
            else {
                pstm.setNull(1, Types.VARCHAR);
            }
            pstm.setInt(3, Integer.parseInt(n.getIdNegocio()));
            pstm.executeUpdate();
            pstm.close();
            conn.close();
        }
        catch (Exception e) { throw new NullPointerException(e.getMessage()); }
    }
    
}
