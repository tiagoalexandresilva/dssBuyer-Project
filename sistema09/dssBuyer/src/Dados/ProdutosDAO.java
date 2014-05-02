/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import Negocio.GestaoProdutos.Outros;
import Negocio.GestaoProdutos.Produto;
import Negocio.GestaoProdutos.Tecnologia;
import Negocio.GestaoProdutos.Vestuario;
import Negocio.GestaoUtilizadores.Utilizador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author helder
 */
public class ProdutosDAO implements Map<String, Produto> {
    
    public ProdutosDAO() {}
    
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
    public Produto get(Object key) {
        try {
            Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@192.168.123.129:1158:BD","trabalho", "trabalho");
            UtilizadoresDAO users = new UtilizadoresDAO();
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM produtos WHERE id_produto=?");
            stm.setInt(1, Integer.parseInt((String)key));
            ResultSet rs = stm.executeQuery();
            Produto p = null;
            if (rs.next()) {
                Utilizador u = users.get(rs.getNString(6));
                switch (rs.getString(6)) {
                    case "Negocio.GestaoProdutos.Tecnologia":
                        p = new Tecnologia(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getFloat(5), rs.getBoolean(8), u);
                        break;
                    case "Negocio.GestaoProdutos.Vestuario":
                        p = new Vestuario(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getFloat(5), rs.getBoolean(8), u);
                        break;
                    default:
                        p = new Outros(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getFloat(5), rs.getBoolean(8), u);
                        break;
                        
                }
            }
            rs.close();
            stm.close();
            conn.close();
            return p;
        }
        catch (Exception e) {throw new NullPointerException (e.getMessage());}
    }

    @Override
    public Produto put(String key, Produto value) {
        try {
            Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@192.168.123.129:1158:BD","trabalho", "trabalho");
            String categoria = value.getClass().getName();
            int bloqueado = (value.isBloqueado()) ? 1 : 0;
            Statement stm = conn.createStatement();
            String sql = "INSERT INTO produtos VALUES (id_produto.nextval,'"+value.getTitulo()+"',";
            sql += "'"+value.getDescricao()+"',"+value.getStock()+","+value.getPreco()+",";
            sql += "'"+value.getVendedor().getIdUtilizador()+"','"+categoria+"',"+bloqueado+")";
            stm.executeUpdate(sql);
            stm.close();
            conn.close();
            return value;
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }

    @Override
    public Produto remove(Object key) {
        try {
            Produto p = null;
            Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@192.168.123.129:1158:BD","trabalho", "trabalho");
            PreparedStatement pstm = conn.prepareStatement("UPDATE produtos SET bloqueado=? WHERE id_produto=?");
            pstm.setInt(1, 1);
            pstm.setInt(2, Integer.parseInt((String)key));
            pstm.executeUpdate();
            pstm.close();
            conn.close();
            return p;
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }

    @Override
    public void putAll(Map<? extends String, ? extends Produto> m) {
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
    public Collection<Produto> values() {
        try {
            Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@192.168.123.129:1158:BD","trabalho", "trabalho");
            ArrayList<Produto> resultados = new ArrayList<Produto>();
            UtilizadoresDAO users = new UtilizadoresDAO();
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM produtos";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Utilizador u = users.get(rs.getNString(6));
                Produto p = null;
                switch (rs.getString(7)) {
                    case "Negocio.GestaoProdutos.Tecnologia":
                        p = new Tecnologia(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getFloat(5), rs.getBoolean(8), u);
                        break;
                    case "Negocio.GestaoProdutos.Vestuario":
                        p = new Vestuario(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getFloat(5), rs.getBoolean(8), u);
                        break;
                    default:
                        p = new Outros(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getFloat(5), rs.getBoolean(8), u);
                        break;
                }
                resultados.add(p);
            }
            rs.close();
            stm.close();
            conn.close();
            return resultados;
        }
        catch (Exception e) {throw new NullPointerException (e.getMessage());}
    }
    

    public Collection<Produto> values(Utilizador u) {
        try {
            Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@192.168.123.129:1158:BD","trabalho", "trabalho");
            ArrayList<Produto> resultados = new ArrayList<Produto>();
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM produtos WHERE id_vendedor='"+u.getIdUtilizador()+"'";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Produto p = null;
                switch (rs.getString(7)) {
                    case "Negocio.Tecnologia":
                        p = new Tecnologia(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getFloat(5), rs.getBoolean(8), u);
                        break;
                    case "Negocio.Vestuario":
                        p = new Vestuario(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getFloat(5), rs.getBoolean(8), u);
                    default:
                        p = new Outros(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getFloat(5), rs.getBoolean(8), u);
                        break;
                        
                }
                resultados.add(p);
            }
            rs.close();
            stm.close();
            conn.close();
            return resultados;
        }
        catch (Exception e) {throw new NullPointerException (e.getMessage());}
    }

    @Override
    public Set<Entry<String, Produto>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void putUpdate(Produto value) throws SQLException {
        Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@192.168.123.129:1158:BD","trabalho", "trabalho");
        PreparedStatement stm = conn.prepareStatement("update produtos set titulo = ?, descricao = ?, stock = ?, preco = ? where id_produto = ?");
        stm.setString(1, value.getTitulo());
        stm.setString(2, value.getDescricao());
        stm.setInt(3, value.getStock());
        stm.setFloat(4, value.getPreco());
        stm.setInt(5, Integer.parseInt(value.getIdProduto()));
        stm.executeUpdate();
        stm.close();
        conn.close();
    }
    
}
