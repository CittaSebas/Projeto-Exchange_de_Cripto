/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

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
    
    public String [] checkarmoedasusu() throws SQLException{
        String sql1 = "SELECT cpf, criptos FROM usuarios ";
        String [] moedaexistente;
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
                System.arraycopy(str_critpos, 0, combinedArray, 0, 12); // Copia todos os 12 elementos
                return combinedArray;
            }
        
    return moeda;}return moeda;
        }
    }
    
    public void adicionarmoeda(Cotacao moeda) throws SQLException {
        String[] moedas = checkarmoedas();   
        System.out.println(moedas.length);
        String[] totalmoedas = null ;
        String abr = moeda.getAbreviacao();
        String id = moeda.getIda();
        String nome = moeda.getNome();
        
        String cotacao = moeda.getCotacao();
        
        String[] novamoeda = {id,nome,cotacao,abr};
        if(moedas.length == 0){
            totalmoedas = new String[moedas.length + 4]; // Allocate space for 4 more elements
            System.arraycopy(moedas, 0, totalmoedas, 0, moedas.length); // Copy existing elements
            System.arraycopy(novamoeda, 0, totalmoedas, moedas.length, novamoeda.length); 
            totalmoedas[0] ="1";

        }
        if(moedas.length == 4){
            totalmoedas = new String[moedas.length + 4]; // Allocate space for 4 more elements
            System.arraycopy(moedas, 0, totalmoedas, 0, moedas.length); // Copy existing elements
            System.arraycopy(novamoeda, 0, totalmoedas, moedas.length, novamoeda.length); 
            totalmoedas[4] = "2";
            java.sql.Array arrayUSA = conn.createArrayOf("text", totalmoedas);
        
            }
        else if(moedas.length == 8){
            totalmoedas = new String[moedas.length + 4];
            System.arraycopy(moedas, 0, totalmoedas, 0, moedas.length); // Copy existing elements
            System.arraycopy(novamoeda, 0, totalmoedas, moedas.length, novamoeda.length); 
            totalmoedas[8] = "3";
            
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
        String [] moeda = new String[0];
        
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
            else if (str_critpos.length == 12) {
                String[] combinedArray = new String[12];
                System.arraycopy(str_critpos, 0, combinedArray, 0, 12); // Copia todos os 8 elementos
                System.out.println("Array with 12 elements: " + Arrays.toString(combinedArray));
                return combinedArray;
            }
        
    return moeda;}return moeda;
        }
    }
    public void updateCriptos(Cotacao moeda) throws SQLException {
        String abr = moeda.getAbreviacao();
        String id = moeda.getIda();
        String nome = moeda.getNome();
        String[] novamoeda = {id, nome, "0", abr};
        String [] totalmoedas;

        // Step 1: Retrieve all CPFs in descending order
        String sqlGetCpfs = "SELECT cpf FROM usuarios ORDER BY cpf DESC";
        try (PreparedStatement stmt = conn.prepareStatement(sqlGetCpfs);
             ResultSet rs = stmt.executeQuery()) {
            
            // Step 2: Iterate through each CPF
            while (rs.next()) {
                String cpf = rs.getString("cpf");

                // Retrieve the current criptos array for the user identified by CPF
                String sqlSelect = "SELECT criptos FROM usuarios WHERE cpf = ?";
                String[] moedas = new String[0];

                try (PreparedStatement selectStmt = conn.prepareStatement(sqlSelect)) {
                    selectStmt.setString(1, cpf);
                    try (ResultSet rsSelect = selectStmt.executeQuery()) {
                        if (rsSelect.next()) {
                            java.sql.Array sqlArray = rsSelect.getArray("criptos");
                            if (sqlArray != null) {
                                moedas = (String[]) sqlArray.getArray();
                            } else {
                                moedas = new String[0]; // If null, initialize as empty array
                            }
                        }
                    }
                }
                if(moedas.length == 0){
                totalmoedas = new String[moedas.length + 4]; // Allocate space for 4 more elements
                System.arraycopy(moedas, 0, totalmoedas, 0, moedas.length); // Copy existing elements
                System.arraycopy(novamoeda, 0, totalmoedas, moedas.length, novamoeda.length); 
                totalmoedas[0] ="1";
                java.sql.Array sqlUpdatedCriptos = conn.createArrayOf("text", totalmoedas);
                String sqlUpdate = "UPDATE usuarios SET criptos = ? WHERE cpf = ?";

                try (PreparedStatement updateStmt = conn.prepareStatement(sqlUpdate)) {
                    updateStmt.setArray(1, sqlUpdatedCriptos);
                    updateStmt.setString(2, cpf);
                    updateStmt.executeUpdate();
                }
            }
            if(moedas.length == 4){
                totalmoedas = new String[moedas.length + 4]; // Allocate space for 4 more elements
                System.arraycopy(moedas, 0, totalmoedas, 0, moedas.length); // Copy existing elements
                System.arraycopy(novamoeda, 0, totalmoedas, moedas.length, novamoeda.length); 
                totalmoedas[4] = "2";
                java.sql.Array sqlUpdatedCriptos = conn.createArrayOf("text", totalmoedas);
                String sqlUpdate = "UPDATE usuarios SET criptos = ? WHERE cpf = ?";

                try (PreparedStatement updateStmt = conn.prepareStatement(sqlUpdate)) {
                    updateStmt.setArray(1, sqlUpdatedCriptos);
                    updateStmt.setString(2, cpf);
                    updateStmt.executeUpdate();
                }
                }
            else if(moedas.length == 8){
                totalmoedas = new String[moedas.length + 4];
                System.arraycopy(moedas, 0, totalmoedas, 0, moedas.length); // Copy existing elements
                System.arraycopy(novamoeda, 0, totalmoedas, moedas.length, novamoeda.length); 
                totalmoedas[8] = "3";
                java.sql.Array sqlUpdatedCriptos = conn.createArrayOf("text", totalmoedas);
                String sqlUpdate = "UPDATE usuarios SET criptos = ? WHERE cpf = ?";

                try (PreparedStatement updateStmt = conn.prepareStatement(sqlUpdate)) {
                    updateStmt.setArray(1, sqlUpdatedCriptos);
                    updateStmt.setString(2, cpf);
                    updateStmt.executeUpdate();
                }
            }
               
                
            }
        }
    }
    
    public void apagarmoeda1() throws SQLException {
        String[] moedas = checkarmoedas();   
        System.out.println(moedas.length);
        String[] totalmoedas = null ;
        
        if(moedas.length == 12){
            totalmoedas = new String[moedas.length - 4]; // Allocate space for 4 more elements
            System.arraycopy(moedas, 4, totalmoedas, 0, 8); 
            totalmoedas[0] ="1";
            totalmoedas[4] ="2";
        }
        if(moedas.length == 8){
            totalmoedas = new String[moedas.length - 4]; // Allocate space for 4 more elements
            System.arraycopy(moedas, 4, totalmoedas, 0, 4); 
            totalmoedas[0] = "1";
            java.sql.Array arrayUSA = conn.createArrayOf("text", totalmoedas);
        
            }
        else if(moedas.length == 4){
            totalmoedas = new String[0];
            
        }
    java.sql.Array arrayUSA = conn.createArrayOf("text", totalmoedas);
        String sql = "UPDATE cotacao SET criptos = ? WHERE id = (SELECT MAX(id) FROM cotacao)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setArray(1,arrayUSA);
            stmt.executeUpdate();
        }
        
        
           
    }
    
    public void apagarmoeda2() throws SQLException {
        String[] moedas = checkarmoedas();   
        System.out.println(moedas.length);
        String[] totalmoedas = null ;
        
        if(moedas.length == 12){
            totalmoedas = new String[moedas.length - 4]; // Allocate space for 4 more elements
            System.arraycopy(moedas, 0, totalmoedas, 0, 4); 
            System.arraycopy(moedas, 8, totalmoedas, 4, 4); 
            totalmoedas[0] ="1";
            totalmoedas[4] ="2";
        }
        if(moedas.length == 8){
            totalmoedas = new String[moedas.length - 4]; // Allocate space for 4 more elements
            System.arraycopy(moedas, 0, totalmoedas, 0, 4); 
            totalmoedas[0] = "1";
            java.sql.Array arrayUSA = conn.createArrayOf("text", totalmoedas);
        
            }
        
    java.sql.Array arrayUSA = conn.createArrayOf("text", totalmoedas);
        String sql = "UPDATE cotacao SET criptos = ? WHERE id = (SELECT MAX(id) FROM cotacao)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setArray(1,arrayUSA);
            stmt.executeUpdate();
        }
        
        
           
    }
    
    public void apagarmoeda3() throws SQLException {
        String[] moedas = checkarmoedas();   
        System.out.println(moedas.length);
        String[] totalmoedas = null ;
        
        if(moedas.length == 12){
            totalmoedas = new String[moedas.length - 4]; // Allocate space for 4 more elements
            System.arraycopy(moedas, 0, totalmoedas, 0, 8); 
            totalmoedas[0] ="1";
            totalmoedas[4] ="2";
        }
        
        
    java.sql.Array arrayUSA = conn.createArrayOf("text", totalmoedas);
        String sql = "UPDATE cotacao SET criptos = ? WHERE id = (SELECT MAX(id) FROM cotacao)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setArray(1,arrayUSA);
            stmt.executeUpdate();
        }
        
        
           
    }
    
    public String [] checkarmoedasusuario() throws SQLException{
        String sql1 = "SELECT ID, criptos FROM cotacao ORDER BY data DESC LIMIT 1";
        String [] moeda = new String[0];
        
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
            else if (str_critpos.length == 12) {
                String[] combinedArray = new String[12];
                System.arraycopy(str_critpos, 0, combinedArray, 0, 12); // Copia todos os 8 elementos
                System.out.println("Array with 12 elements: " + Arrays.toString(combinedArray));
                return combinedArray;
                }
        
        return moeda;
            }
        return moeda;
        }
    }
    
    
    
    public void saldo1() throws SQLException {
        String cotm1;
        String[] cotacao = checkarmoedasusuario();
        String [] totalmoedas;

        cotm1 = cotacao[2];
        
        // Step 1: Retrieve all CPFs in descending order
        String sqlGetCpfs = "SELECT cpf,reais FROM usuarios ORDER BY cpf DESC";
        try (PreparedStatement stmt = conn.prepareStatement(sqlGetCpfs);
             ResultSet rs = stmt.executeQuery()) {
            
            // Step 2: Iterate through each CPF
            while (rs.next()) {
                String cpf = rs.getString("cpf");
                Float dineiro = rs.getFloat("reais");

                // Retrieve the current criptos array for the user identified by CPF
                String sqlSelect = "SELECT criptos FROM usuarios WHERE cpf = ?";
                String[] moedas = new String[0];

                try (PreparedStatement selectStmt = conn.prepareStatement(sqlSelect)) {
                    selectStmt.setString(1, cpf);
                    try (ResultSet rsSelect = selectStmt.executeQuery()) {
                        if (rsSelect.next()) {
                            java.sql.Array sqlArray = rsSelect.getArray("criptos");
                            if (sqlArray != null) {
                                moedas = (String[]) sqlArray.getArray();
                            } else {
                                moedas = new String[0]; // If null, initialize as empty array
                            }
                        }
                    }
                }
                if(moedas.length == 12){
                totalmoedas = new String[moedas.length - 4]; // Allocate space for 4 more elements
                System.arraycopy(moedas, 4, totalmoedas, 0, 8); 
                totalmoedas[0] ="1";
                totalmoedas[4] ="2";
                Float tm = Float.parseFloat(moedas[2]);
                Float cot = Float.parseFloat(cotm1);
                Float saldon = (cot*tm) + dineiro;
                java.sql.Array sqlUpdatedCriptos = conn.createArrayOf("text", totalmoedas);
                String sqlUpdate = "UPDATE usuarios SET criptos = ?, reais = ? WHERE cpf = ?";

                try (PreparedStatement updateStmt = conn.prepareStatement(sqlUpdate)) {
                    updateStmt.setArray(1, sqlUpdatedCriptos);
                    updateStmt.setFloat(2, saldon);
                    updateStmt.setString(3, cpf);
                    updateStmt.executeUpdate();
                }
            }
            if(moedas.length == 8){
                totalmoedas = new String[moedas.length - 4]; // Allocate space for 4 more elements
                System.arraycopy(moedas, 4, totalmoedas, 4, 4); 
                totalmoedas[0] ="1";
                Float tm = Float.parseFloat(moedas[2]);
                Float cot = Float.parseFloat(cotm1);
                Float saldon = (cot*tm) + dineiro;
                java.sql.Array sqlUpdatedCriptos = conn.createArrayOf("text", totalmoedas);
                String sqlUpdate = "UPDATE usuarios SET criptos = ?, reais = ? WHERE cpf = ?";

                try (PreparedStatement updateStmt = conn.prepareStatement(sqlUpdate)) {
                    updateStmt.setArray(1, sqlUpdatedCriptos);
                    updateStmt.setFloat(2, saldon);
                    updateStmt.setString(3, cpf);
                    updateStmt.executeUpdate();
                }
                }
            else if(moedas.length == 4){
                totalmoedas = new String[0]; // Allocate space for 4 more elements
                Float tm = Float.parseFloat(moedas[2]);
                Float cot = Float.parseFloat(cotm1);
                Float saldon = (cot*tm) + dineiro;
                java.sql.Array sqlUpdatedCriptos = conn.createArrayOf("text", totalmoedas);
                String sqlUpdate = "UPDATE usuarios SET criptos = ?, reais = ? WHERE cpf = ?";

                try (PreparedStatement updateStmt = conn.prepareStatement(sqlUpdate)) {
                    updateStmt.setArray(1, sqlUpdatedCriptos);
                    updateStmt.setFloat(2, saldon);
                    updateStmt.setString(3, cpf);
                    updateStmt.executeUpdate();
                }
            }
               
                
            }
        }
    }
    
    public void saldo2() throws SQLException {
        String cotm1;
        String[] cotacao = checkarmoedasusuario();
        String [] totalmoedas;

        cotm1 = cotacao[6];
        

        String sqlGetCpfs = "SELECT cpf,reais FROM usuarios ORDER BY cpf DESC";
        try (PreparedStatement stmt = conn.prepareStatement(sqlGetCpfs);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                String cpf = rs.getString("cpf");
                Float dineiro = rs.getFloat("reais");
                String sqlSelect = "SELECT criptos FROM usuarios WHERE cpf = ?";
                String[] moedas = new String[0];

                try (PreparedStatement selectStmt = conn.prepareStatement(sqlSelect)) {
                    selectStmt.setString(1, cpf);
                    try (ResultSet rsSelect = selectStmt.executeQuery()) {
                        if (rsSelect.next()) {
                            java.sql.Array sqlArray = rsSelect.getArray("criptos");
                            if (sqlArray != null) {
                                moedas = (String[]) sqlArray.getArray();
                            } else {
                                moedas = new String[0];
                            }
                        }
                    }
                }
                if(moedas.length == 12){
                totalmoedas = new String[moedas.length - 4];
                System.arraycopy(moedas, 0, totalmoedas, 0, 4); 
                System.arraycopy(moedas, 8, totalmoedas, 4, 4);
                totalmoedas[0] ="1";
                totalmoedas[4] ="2";
                Float tm = Float.parseFloat(moedas[2]);
                Float cot = Float.parseFloat(cotm1);
                Float saldon = (cot*tm) + dineiro;
                java.sql.Array sqlUpdatedCriptos = conn.createArrayOf("text", totalmoedas);
                String sqlUpdate = "UPDATE usuarios SET criptos = ?, reais = ? WHERE cpf = ?";

                try (PreparedStatement updateStmt = conn.prepareStatement(sqlUpdate)) {
                    updateStmt.setArray(1, sqlUpdatedCriptos);
                    updateStmt.setFloat(2, saldon);
                    updateStmt.setString(3, cpf);
                    updateStmt.executeUpdate();
                }
            }
            if(moedas.length == 8){
                totalmoedas = new String[moedas.length - 4];
                System.arraycopy(moedas, 0, totalmoedas, 0, 4); 
                totalmoedas[0] ="1";
                Float tm = Float.parseFloat(moedas[2]);
                Float cot = Float.parseFloat(cotm1);
                Float saldon = (cot*tm) + dineiro;
                java.sql.Array sqlUpdatedCriptos = conn.createArrayOf("text", totalmoedas);
                String sqlUpdate = "UPDATE usuarios SET criptos = ?, reais = ? WHERE cpf = ?";

                try (PreparedStatement updateStmt = conn.prepareStatement(sqlUpdate)) {
                    updateStmt.setArray(1, sqlUpdatedCriptos);
                    updateStmt.setFloat(2, saldon);
                    updateStmt.setString(3, cpf);
                    updateStmt.executeUpdate();
                    }
                }
            }
        }
    }
    
    public void saldo3() throws SQLException {
        String cotm1;
        String[] cotacao = checkarmoedasusuario();
        String [] totalmoedas;

        cotm1 = cotacao[10];
        
        String sqlGetCpfs = "SELECT cpf,reais FROM usuarios ORDER BY cpf DESC";
        try (PreparedStatement stmt = conn.prepareStatement(sqlGetCpfs);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                String cpf = rs.getString("cpf");
                Float dineiro = rs.getFloat("reais");
                String sqlSelect = "SELECT criptos FROM usuarios WHERE cpf = ?";
                String[] moedas = new String[0];

                try (PreparedStatement selectStmt = conn.prepareStatement(sqlSelect)) {
                    selectStmt.setString(1, cpf);
                    try (ResultSet rsSelect = selectStmt.executeQuery()) {
                        if (rsSelect.next()) {
                            java.sql.Array sqlArray = rsSelect.getArray("criptos");
                            if (sqlArray != null) {
                                moedas = (String[]) sqlArray.getArray();
                            } else {
                                moedas = new String[0];
                            }
                        }
                    }
                }
                if(moedas.length == 12){
                totalmoedas = new String[moedas.length - 4];
                System.arraycopy(moedas, 0, totalmoedas, 0, 8); 
                totalmoedas[0] ="1";
                totalmoedas[4] ="2";
                Float tm = Float.parseFloat(moedas[2]);
                Float cot = Float.parseFloat(cotm1);
                Float saldon = (cot*tm) + dineiro;
                java.sql.Array sqlUpdatedCriptos = conn.createArrayOf("text", totalmoedas);
                String sqlUpdate = "UPDATE usuarios SET criptos = ?, reais = ? WHERE cpf = ?";

                try (PreparedStatement updateStmt = conn.prepareStatement(sqlUpdate)) {
                    updateStmt.setArray(1, sqlUpdatedCriptos);
                    updateStmt.setFloat(2, saldon);
                    updateStmt.setString(3, cpf);
                    updateStmt.executeUpdate();
                    }
                }
            }
        }
    }
}