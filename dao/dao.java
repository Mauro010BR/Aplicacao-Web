/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexao.conexao;
import model.pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mauro
 */
public class dao {

    public pedido consultarById(pedido pe) throws ClassNotFoundException, SQLException {
        Connection con = conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("select * from pedidos where id = ?");
        comando.setInt(1, pe.getId());
        ResultSet rs = comando.executeQuery();
        pedido p = new pedido();
        if (rs.next()) {
            p.setId(rs.getInt("id"));
            p.setNome(rs.getString("nome"));
            p.setProcessador(rs.getString("processador"));
            p.setPlacavideo(rs.getString("placavideo"));
            p.setPlacamae(rs.getString("placamae"));
            p.setRam(rs.getString("ram"));
            p.setCooler(rs.getString("cooler"));
            p.setHd(rs.getString("hd"));
            p.setSsd(rs.getString("ssd"));
            p.setGabinete(rs.getString("gabinete"));
            p.setEstado(rs.getString("estado"));
        }
        con.close();
        return p;
    }

    public ArrayList<pedido> consultarTodos() throws ClassNotFoundException, SQLException {
        Connection con = conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("select * from pedidos");
        ResultSet rs = comando.executeQuery();

        ArrayList<pedido> lprod = new ArrayList<pedido>();
        while (rs.next()) {
            pedido prod = new pedido();
            prod.setId(rs.getInt("id"));
            prod.setNome(rs.getString("nome"));
            prod.setProcessador(rs.getString("processador"));
            prod.setPlacavideo(rs.getString("placavideo"));
            prod.setPlacamae(rs.getString("placamae"));
            prod.setRam(rs.getString("ram"));
            prod.setCooler(rs.getString("cooler"));
            prod.setHd(rs.getString("hd"));
            prod.setSsd(rs.getString("ssd"));
            prod.setGabinete(rs.getString("gabinete"));
            prod.setEstado(rs.getString("estado"));

            lprod.add(prod);
        }
        return lprod;
    }

    public void cadastrar(pedido prod) throws SQLException, ClassNotFoundException {
        try (Connection con = conexao.getConexao(); PreparedStatement comando = con.prepareStatement("insert into pedidos (nome,processador,placavideo,placamae,ram,cooler,hd,ssd,gabinete,estado) VALUES (?,?,?,?,?,?,?,?,?,?)")) {
            comando.setString(1, prod.getNome());
            comando.setString(2, prod.getProcessador());
            comando.setString(3, prod.getPlacavideo());
            comando.setString(4, prod.getPlacamae());
            comando.setString(5, prod.getRam());
            comando.setString(6, prod.getCooler());
            comando.setString(7, prod.getHd());
            comando.setString(8, prod.getSsd());
            comando.setString(9, prod.getGabinete());
            comando.setString(10, prod.getEstado());
            comando.execute();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro ClassNotFound: " + ex.getMessage());
        }
    }

    public void deletar(pedido prod) throws ClassNotFoundException, SQLException {
        try (Connection con = conexao.getConexao()) {
            PreparedStatement comando = con.prepareStatement("DELETE FROM pedidos WHERE id = ?");
            comando.setInt(1, prod.getId());
            comando.execute();
            comando.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro ClassNotFound: " + ex.getMessage());
        }
    }

    public void editar(pedido prod) {
        try {
            Connection con = conexao.getConexao();
            PreparedStatement comando = con.prepareStatement("update pedidos\n"
                    + "set nome = ?, processador = ?, placavideo = ?, placamae = ?, ram = ?, cooler = ?, hd = ?, ssd = ?, gabinete = ?, estado = ?\n"
                    + "where id = ?; ");
            comando.setString(1, prod.getNome());
            comando.setString(2, prod.getProcessador());
            comando.setString(3, prod.getPlacavideo());
            comando.setString(4, prod.getPlacamae());
            comando.setString(5, prod.getRam());
            comando.setString(6, prod.getCooler());
            comando.setString(7, prod.getHd());
            comando.setString(8, prod.getSsd());
            comando.setString(9, prod.getGabinete());
            comando.setString(10, prod.getEstado());
            comando.setInt(11, prod.getId());
            comando.execute();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro ClassNotFound: " + ex.getMessage());
        }
    }
}
