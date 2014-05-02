/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import Negocio.GestaoUtilizadores.Administrador;
import Negocio.GestaoUtilizadores.Utilizador;
import Negocio.GestaoUtilizadores.UtilizadorNormal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author helder
 */
public class UtilizadoresDAO implements Map<String, Utilizador> {
    
    public UtilizadoresDAO() {}
    
    public String encriptaPassword(String s) {
        try {
            Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@192.168.123.129:1158:BD","trabalho", "trabalho");
            CallableStatement call = conn.prepareCall("{? = call md5 (?)}");
            call.registerOutParameter(1, Types.VARCHAR);
            call.setString(2, s);
            call.executeUpdate();
            String pass = call.getString(1);
            call.close();
            conn.close();
            return pass;
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }

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
        try {
            Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@192.168.123.129:1158:BD","trabalho", "trabalho");
            Statement stm = conn.createStatement();
            String sql = "SELECT id_utilizador FROM utilizadores WHERE id_utilizador='"+(String)key+"'";
            ResultSet rs = stm.executeQuery(sql);
            boolean res = rs.next();
            rs.close();
            stm.close();
            conn.close();
            return res;
        } 
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }

    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Utilizador get(Object key) {
        try {
            Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@192.168.123.129:1158:BD","trabalho", "trabalho");
            Utilizador u = null;
            Statement stm = conn.createStatement();
            String sql = "SELECT id_utilizador,nome,morada,co.cod_postal,co.localidade,to_char(data_nasc,'dd-mm-yyyy'),to_char(data_reg,'dd-mm-yyyy'),password,bloqueado,admin_prev,feed FROM utilizadores ut,cod_postal co WHERE id_utilizador='"+(String)key+"' AND co.cod_postal=ut.cod_postal";
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {
                boolean bloqueado = (rs.getInt(9) == 1) ? true : false;
                if (rs.getInt(10) == 1) {
                    u = new Administrador(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(11), bloqueado);
                }
                else {
                    u = new UtilizadorNormal(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(11), bloqueado);
                }
            }
            rs.close();
            stm.close();
            conn.close();
            return u;
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
        
    }

    @Override
    public Utilizador put(String key, Utilizador value) {
        try {
            Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@192.168.123.129:1158:BD","trabalho", "trabalho");
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM cod_postal WHERE cod_postal = '"+value.getCodPostal()+"'");
            if (!rs.next()) {
                stm.executeUpdate("INSERT INTO COD_POSTAL VALUES ('"+value.getCodPostal()+"','"+value.getLocalidade()+"')");
            }
            int bloqueado = (value.isBloqueado()) ? 1 : 0;
            int admin_prev = (value instanceof Administrador) ? 1 : 0;
            String sql = "INSERT INTO utilizadores VALUES ('"+value.getIdUtilizador()+"',";
            sql += "'"+value.getNome()+"',";
            sql += "'"+value.getMorada()+"',";
            sql += "'"+value.getCodPostal()+"',";
            sql += "to_date('"+value.getDataNasc()+"', 'dd-mm-yyyy'),";
            sql += "to_date('"+value.getDataReg()+"', 'dd-mm-yyyy'),";
            sql += "md5('"+value.getPassword()+"'),";
            sql += "'"+bloqueado+"',";
            sql += "'"+admin_prev+"',";
            sql += "'"+value.getFeed()+"')";     
            stm.executeUpdate(sql);
            rs.close();
            stm.close();
            conn.close();
            return value;
        } catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }

    @Override
    public Utilizador remove(Object key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void putAll(Map<? extends String, ? extends Utilizador> m) {
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
    public Collection<Utilizador> values() {
        try {
            ArrayList<Utilizador> resultados = new ArrayList<Utilizador>();
            Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@192.168.123.129:1158:BD","trabalho", "trabalho");
            Statement stm = conn.createStatement();
            String sql = "SELECT id_utilizador,nome,morada,co.cod_postal,co.localidade,to_char(data_nasc,'dd-mm-yyyy'),to_char(data_reg,'dd-mm-yyyy'),password,bloqueado,admin_prev,feed FROM utilizadores ut,cod_postal co WHERE co.cod_postal=ut.cod_postal";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Utilizador u = null;
                boolean bloqueado = (rs.getInt(9) == 1) ? true : false;
                if (rs.getInt(10) == 1) {
                    u = new Administrador(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(11), bloqueado);
                }
                else {
                    u = new UtilizadorNormal(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(11), bloqueado);
                }
                resultados.add(u);
            }
            rs.close();
            stm.close();
            conn.close();
            return resultados;
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }

    @Override
    public Set<Entry<String, Utilizador>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setNewPassword(String email, String pass) {
        try {
            Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@192.168.123.129:1158:BD","trabalho", "trabalho");
            PreparedStatement pstm = conn.prepareStatement("UPDATE utilizadores SET password=md5(?) WHERE id_utilizador=?");
            pstm.setString(1, pass);
            pstm.setString(2, email);
            pstm.executeUpdate();
            pstm.close();
            conn.close();
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }
    
    public void putUpdate(Utilizador u) {
        try {
            Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@192.168.123.129:1158:BD","trabalho", "trabalho");
            String sql = "SELECT * FROM cod_postal WHERE cod_postal=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, u.getCodPostal());
            ResultSet rs = pstm.executeQuery();
            if (!rs.next()) {
                pstm.close();
                pstm = conn.prepareStatement("INSERT INTO cod_postal VALUES (?,?)");
                pstm.setString(1, u.getCodPostal());
                pstm.setString(2, u.getLocalidade());
                pstm.executeUpdate();
            }
            rs.close();
            pstm.close();
            sql = "UPDATE utilizadores SET nome=?, morada=?, cod_postal=?, data_nasc=to_date(?,'dd-mm-yyyy'), data_reg=to_date(?,'dd-mm-yyyy'), feed=?, bloqueado=? WHERE id_utilizador=?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, u.getNome());
            pstm.setString(2, u.getMorada());
            pstm.setString(3, u.getCodPostal());
            pstm.setString(4, u.getDataNasc());
            pstm.setString(5, u.getDataReg());
            pstm.setInt(6, u.getFeed());
            int bloqueado = (u.isBloqueado()) ? 1 : 0;
            pstm.setInt(7, bloqueado);
            pstm.setString(8, u.getIdUtilizador());
            pstm.executeUpdate();
            pstm.close();
            conn.close();
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }
    
}
