/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Usuario;
import model.Cotacao;

/**
 *
 * @author citta
 */
public class CotDAO {
    
    private Connection conn;

    public CotDAO(Connection conn) {
        this.conn = conn;
    }
    
    public ResultSet consultar() {
    try {
        String sql = "SELECT * FROM cotacao WHERE id = (SELECT MAX(id) FROM cotacao)";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet resultado = statement.executeQuery();
        return resultado;
    } catch (SQLException e) {
        e.printStackTrace();
        return null; // or handle the error in a different way
        }
    }
    public void atualizar(String moeda, float novaCotacao) throws SQLException {
        System.out.println(moeda);
        String sql = "UPDATE cotacao SET " + moeda + " = ? WHERE id = (SELECT MAX(id) FROM cotacao)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setFloat(1, novaCotacao);
            stmt.executeUpdate();
        }
    }

    

    
    
}
