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

/**
 *
 * @author citta
 */
public class UsuarioDAO {
    
    private Connection conn;

    public UsuarioDAO(Connection conn) {
        this.conn = conn;
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
    String sql = "INSERT INTO usuarios (cpf, senha, ripple, bitcoin, reais, ethereum) VALUES (?, ?, ?, ?, ?, ?)";
    PreparedStatement statement = conn.prepareStatement(sql);
    statement.setString(1, usuario.getCpf());
    statement.setString(2, usuario.getSenha());
    statement.setFloat(3, 0f);
    statement.setFloat(4, 0f);
    statement.setFloat(5, 0f);
    statement.setFloat(6, 0f);
    statement.executeUpdate();
    statement.close(); // Feche o PreparedStatement após o uso
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
    // Consultar o saldo atual do usuário
    String consultaSaldoSQL = "SELECT reais FROM usuarios WHERE cpf = ?";
    PreparedStatement consultaSaldoStatement = conn.prepareStatement(consultaSaldoSQL);
    consultaSaldoStatement.setString(1, usuario.getCpflogado());
    ResultSet resultado = consultaSaldoStatement.executeQuery();
    
    // Verificar se o usuário foi encontrado
    if (resultado.next()) {
        // Obter o saldo atual do usuário
        float saldoAtual = resultado.getFloat("reais");
        
        // Calcular o novo saldo (saldo atual + valor do depósito)
        float novoSaldo = saldoAtual + usuario.getValorDeposito();
        
        // Atualizar o saldo no banco de dados
        String atualizarSaldoSQL = "UPDATE usuarios SET reais = ? WHERE cpf = ?";
        PreparedStatement atualizarSaldoStatement = conn.prepareStatement(atualizarSaldoSQL);
        atualizarSaldoStatement.setFloat(1, novoSaldo);
        atualizarSaldoStatement.setString(2, usuario.getCpflogado());
        atualizarSaldoStatement.executeUpdate();
        
        // Fechar os recursos
        consultaSaldoStatement.close();
        atualizarSaldoStatement.close();
    } else {
        // Usuário não encontrado, faça algo (lançar exceção, exibir mensagem, etc.)
    }
}

    
    
}
