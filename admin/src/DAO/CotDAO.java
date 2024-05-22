/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.awt.List;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    // Em seguida, inserimos uma nova linha com o novo ID e a nova cotação
    public void atualizar(String moeda, float novaCotacao) throws SQLException {
        System.out.println(moeda);
        String sql = "UPDATE cotacao SET " + moeda + " = ? WHERE id = (SELECT MAX(id) FROM cotacao)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setFloat(1, novaCotacao);
            stmt.executeUpdate();
        }
    }
    
    
    public void adicionarmoeda(Cotacao moeda) throws SQLException {
        String[] moedas = checkarmoedas();   
        String[] totalmoedas = null;
        String abr = moeda.getAbreviacao();
        System.out.println(moedas.length);
        String id = moeda.getIda();
        
        String nome = moeda.getNome();
        
        String cotacao = moeda.getCotacao();
        String a = moedas[0];
        
        String[] novamoeda = {id,nome,cotacao,abr};
        if(moedas.length == 4){
            totalmoedas = new String[moedas.length + 4]; // Allocate space for 4 more elements
            System.arraycopy(moedas, 0, totalmoedas, 0, moedas.length); // Copy existing elements
            System.arraycopy(novamoeda, 0, totalmoedas, moedas.length, novamoeda.length); 
            }
        else if(moedas.length == 8){
            totalmoedas = new String[moedas.length + 4];
            System.arraycopy(moedas, 0, totalmoedas, 0, moedas.length); // Copy existing elements
            System.arraycopy(novamoeda, 0, totalmoedas, moedas.length, novamoeda.length); 
        }
        
        java.sql.Array arrayUSA = conn.createArrayOf("text", totalmoedas);
        String sql = "UPDATE cotacao SET criptos = ? WHERE id = (SELECT MAX(id) FROM cotacao)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setArray(1,arrayUSA);
            stmt.executeUpdate();
        }
        
        
    }
    public String [] checkarmoedas() throws SQLException{
        String sql1 = "SELECT ID, criptos FROM cotacao ORDER BY data DESC LIMIT 1";
        String [] moedaexistente;
    try (
        PreparedStatement stmt = conn.prepareStatement(sql1);
        ResultSet rs = stmt.executeQuery()) {
        
        while (rs.next()) {
            java.sql.Array criptos = rs.getArray("criptos"); // Obtendo o array SQL
            String[] str_critpos = (String[]) criptos.getArray(); // Convertendo para array de String

            if (str_critpos.length == 4) {
                System.out.println("Array with 4 elements: " + Arrays.toString(str_critpos));
                return str_critpos; // Retorna o array diretamente se tiver 4 elementos
            } else if (str_critpos.length == 8) {
                String[] combinedArray = new String[8];
                System.arraycopy(str_critpos, 0, combinedArray, 0, 8); // Copia todos os 8 elementos
                System.out.println("Array with 8 elements: " + Arrays.toString(combinedArray));
                return combinedArray;
            }
        
    return null;}return null;
    
}}}