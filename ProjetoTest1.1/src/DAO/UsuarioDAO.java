/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import model.Extrato;
import model.Usuario;

/**
 *
 * @author citta
 */
public class UsuarioDAO {
    
    private Connection conn;

    public UsuarioDAO(Connection conn) {
        this.conn = conn;
    }
    public String formatarTimestamp(Timestamp timestamp) {
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    return formato.format(timestamp);
}
    
    public ResultSet consultar(Usuario usuario) throws SQLException{
        
        String sql = "select * from usuarios where cpf = ? and senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,usuario.getCpf());
        statement.setString(2,usuario.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    
    public void inserir(Usuario usuario) throws SQLException {
    String sql = "INSERT INTO usuarios (cpf, senha, ripple, bitcoin, reais, ethereum, nome) VALUES (?, ?, ?, ?, ?, ?, ?)";
    PreparedStatement statement = conn.prepareStatement(sql);
    statement.setString(1, usuario.getCpf());
    statement.setString(2, usuario.getSenha());
    statement.setFloat(3, 0f);
    statement.setFloat(4, 0f);
    statement.setFloat(5, 0f);
    statement.setFloat(6, 0f);
    statement.setString(7, usuario.getNome());
    statement.executeUpdate();
    statement.close(); 
}

    
    public void excluir(Usuario usuario) throws SQLException{
        String sql = "delete from usuarios where cpf = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,usuario.getCpf());
        statement.execute();
        conn.close();
    }
    
    public void atualizar(Usuario usuario) throws SQLException{
        String sql = "update usuarios set senha = ? where cpf = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,usuario.getSenha());
        statement.setString(2,usuario.getCpf());
        statement.execute();
        conn.close();
    }
    public void atualizarSaldo(Usuario usuario) throws SQLException {
        
        try{
    // Consultar o saldo atual do usuario
    String consultaSaldoSQL = "SELECT reais FROM usuarios WHERE cpf = ?";
    PreparedStatement consultaSaldoStatement = conn.prepareStatement(consultaSaldoSQL);
    consultaSaldoStatement.setString(1, usuario.getCpflogado());
    ResultSet resultado = consultaSaldoStatement.executeQuery();
    
    // Verificar se o usuario foi encontrado
    if (resultado.next()) {
        // Obter o saldo atual do usuario
        float saldoAtual = resultado.getFloat("reais");
        
        java.sql.Timestamp data = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
        data.setNanos(0);
        
        
        // Calcular o novo saldo (saldo atual + valor do depósito)
        float novoSaldo = saldoAtual + usuario.getValorDeposito();
        
        // Atualizar o saldo no banco de dados
        String atualizarSaldoSQL = "UPDATE usuarios SET reais = ? WHERE cpf = ?";
        PreparedStatement atualizarSaldoStatement = conn.prepareStatement(atualizarSaldoSQL);
        atualizarSaldoStatement.setFloat(1, novoSaldo);
        atualizarSaldoStatement.setString(2, usuario.getCpflogado());
        atualizarSaldoStatement.executeUpdate();
        atualizarSaldoStatement.close();
        
        String extratodepositoSQL = "INSERT INTO extrato (data, cpf, ripple, bitcoin, reais, ethereum, taxa, cotacao, transacao)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement extratostatement = conn.prepareStatement(extratodepositoSQL, PreparedStatement.RETURN_GENERATED_KEYS);
        extratostatement.setTimestamp(1, data);
        extratostatement.setString(2, usuario.getCpflogado());
        extratostatement.setFloat(3, usuario.getRipple());
        extratostatement.setFloat(4, usuario.getBitcoin());
        extratostatement.setFloat(5, novoSaldo);
        extratostatement.setFloat(6, usuario.getEthereum());
        extratostatement.setFloat(7, 0f);
        extratostatement.setFloat(8, 0f);
        extratostatement.setString(9, "+"+ usuario.getValorDeposito() + " REAL");
        extratostatement.executeUpdate();
        extratostatement.close(); 
        
        
        consultaSaldoStatement.close();
        
    } else {
        
    }}
        catch(SQLException e){
            System.err.println("Ocorreu um erro ao atualizar o saldo do usuário: " + e.getMessage());
        }
}

    
     public String imprimirextrato(Extrato extrato) throws SQLException{
        StringBuilder extratoString = new StringBuilder();
        
        // Consulta para obter o nome do cliente
    String sqlnome = "select nome from usuarios where cpf = ?";
    PreparedStatement stat = conn.prepareStatement(sqlnome);
    stat.setString(1, extrato.getCpflogado());
    ResultSet res = stat.executeQuery(); 
    String nome = "";
    if (res.next()) {
        nome = res.getString("nome");
    }
         
        
        String sql = "select * from extrato where cpf = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,extrato.getCpflogado());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        
        while (resultado.next()) {
        // Extrair os valores das colunas
        String cpf = resultado.getString("cpf");
        java.sql.Timestamp timestamp = resultado.getTimestamp("data");
        String transacao = resultado.getString("transacao");
        Float cotacao = resultado.getFloat("cotacao");
        Float taxa = resultado.getFloat("taxa");
        Float reais = resultado.getFloat("reais");
        Float bitcoin = resultado.getFloat("bitcoin");
        Float ethereum = resultado.getFloat("ethereum");
        Float ripple = resultado.getFloat("ripple");
        
        
        // Imprimir os valores
        extratoString.append(cpf).append("\n").append("Nome: ").append(nome).append("\n").
                append(timestamp).append(" ").append(transacao).append(" ")
                .append("CT: ").append(cotacao).append(" ")
                .append("TX: ").append(taxa+ " ").append("REAL: ").append(reais+ " ")
                .append("BTC: ").append(bitcoin + " ").append("BTC: ").append(bitcoin+" ")
                .append("ETH: ").append(ethereum+" ").append("XRP: ").append(ripple+" ").append("\n");
    }
        System.out.println(extratoString.toString());
        return extratoString.toString();
    }
}
