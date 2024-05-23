/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
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
        return null;
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
    
    public String [] checkarmoedas() throws SQLException{
        String sql1 = "SELECT ID, criptos FROM cotacao ORDER BY data DESC LIMIT 1";
        String [] moeda = new String[0];
        
    try (
        PreparedStatement stmt = conn.prepareStatement(sql1);
        ResultSet rs = stmt.executeQuery()) {
        
        while (rs.next()) {
            java.sql.Array criptos = rs.getArray("criptos"); // Obtendo o array SQL
            String[] str_critpos = (String[]) criptos.getArray(); // Convertendo para array de String

            if (str_critpos.length == 4) {
                return str_critpos; // Retorna o array diretamente se tiver 4 elementos
            } else if (str_critpos.length == 8) {
                String[] combinedArray = new String[8];
                System.arraycopy(str_critpos, 0, combinedArray, 0, 8); // Copia todos os 8 elementos
                return combinedArray;
            }
            else if (str_critpos.length == 12) {
                String[] combinedArray = new String[12];
                System.arraycopy(str_critpos, 0, combinedArray, 0, 11); // Copia todos os 8 elementos
                return combinedArray;
                }return moeda;
            }return moeda;
        }
    }
}