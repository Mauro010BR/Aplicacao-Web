/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mauro
 */
public class conexao {

    public static Connection getConexao() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        String URL = "jdbc:mysql://localhost:3306/trabalho";
        String USER = "root";
        String PASSWORD = "";
        // Estabelecendo a conexão
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
