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
import javax.swing.JOptionPane;
import model.Extrato;
import model.Usuario;

/**
 *
 * @author citta
 */
public class UsuarioDAO {
    java.sql.Timestamp data = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
    
    
    private Connection conn;

    public UsuarioDAO(Connection conn) {
        this.conn = conn;
    }
    
    public ResultSet consultar(Usuario usuario) throws SQLException{
        
        String sql = "select * from usuarios where cpf = ? ";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,usuario.getCpf());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    public ResultSet consultarsaldo(Usuario usuario) throws SQLException{
        
        String sql = "select * from usuarios where cpf = ? ";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,usuario.getCpflogado());
        ResultSet resultado = statement.executeQuery();
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
                .append("BTC: ").append(bitcoin + " ")
                .append("ETH: ").append(ethereum+" ").append("XRP: ").append(ripple+" ").append("\n");
    }
        return extratoString.toString();
    }
     
    public void comprabtc(Usuario usuario){
         
    float saldo = usuario.getReais();
    float saldobtc = usuario.getSaldocripto();
    float comprabtc = usuario.getCompra();
    float cotbtc = usuario.getCotacao();
    double totalCompra = (float) (comprabtc * cotbtc) * 1.02;
    double taxaTransacao = totalCompra - (comprabtc * cotbtc);
    java.sql.Timestamp data = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
    data.setNanos(0);
    
     
    if(saldo-totalCompra <0){
        System.out.println("Impossible");
    } else { 
        double novosaldobrl =  (saldo - totalCompra);
        double novosaldobtc = saldobtc + comprabtc;
        
        try {
            String atualizarSaldoSQL = "UPDATE usuarios SET reais = ?, bitcoin = ? WHERE cpf = ?";
            PreparedStatement atualizarSaldoStatement = conn.prepareStatement(atualizarSaldoSQL);
            atualizarSaldoStatement.setDouble(1, novosaldobrl);
            atualizarSaldoStatement.setDouble(2, novosaldobtc);
            atualizarSaldoStatement.setString(3, usuario.getCpflogado());
            atualizarSaldoStatement.executeUpdate();
            
            ResultSet res = consultarsaldo(usuario);
            if (res.next()) { 
                System.out.println(res.getFloat("bitcoin"));

                String extratodepositoSQL = "INSERT INTO extrato (data, cpf, ripple, bitcoin, reais, ethereum, taxa, cotacao, transacao)"
                        + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement extratostatement = conn.prepareStatement(extratodepositoSQL, PreparedStatement.RETURN_GENERATED_KEYS);
                extratostatement.setTimestamp(1, data);
                extratostatement.setString(2, usuario.getCpflogado());
                extratostatement.setFloat(3, res.getFloat("ripple"));
                extratostatement.setDouble(4, novosaldobtc);
                extratostatement.setDouble(5, novosaldobrl);
                extratostatement.setFloat(6, res.getFloat("ethereum"));
                extratostatement.setDouble(7, taxaTransacao);
                extratostatement.setFloat(8, cotbtc);
                extratostatement.setString(9, "+"+ comprabtc + " BTC");
                extratostatement.executeUpdate();
                extratostatement.close(); 
                atualizarSaldoStatement.close();
            } else {
                // Caso erro
            }
        } catch(SQLException e) 
            {
            System.err.println("Erro ao executar a função comprabtc: " + e.getMessage());
            e.printStackTrace();
            }
        }
    }

     
    public void compraeth(Usuario usuario){
         
    float saldo = usuario.getReais();
    float saldoeth = usuario.getSaldocripto();
   
    float compraeth = usuario.getCompra();
    float coteth = usuario.getCotacao();
    double totalCompra = (float) (compraeth * coteth) * 1.01;
    double taxaTransacao = totalCompra - (compraeth * coteth);
    java.sql.Timestamp data = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
    data.setNanos(0);
    
     
    if(saldo-totalCompra <0){
        System.out.println("Impossible");
    } else { 
        double novosaldobrl =  (saldo - totalCompra);
        double novosaldoeth = saldoeth + compraeth;
        
        try {
            String atualizarSaldoSQL = "UPDATE usuarios SET reais = ?, ethereum = ? WHERE cpf = ?";
            PreparedStatement atualizarSaldoStatement = conn.prepareStatement(atualizarSaldoSQL);
            atualizarSaldoStatement.setDouble(1, novosaldobrl);
            atualizarSaldoStatement.setDouble(2, novosaldoeth);
            atualizarSaldoStatement.setString(3, usuario.getCpflogado());
            atualizarSaldoStatement.executeUpdate();
            
            ResultSet res = consultarsaldo(usuario);
            if (res.next()) { 
                System.out.println(res.getFloat("bitcoin"));

                String extratodepositoSQL = "INSERT INTO extrato (data, cpf, ripple, bitcoin, reais, ethereum, taxa, cotacao, transacao)"
                        + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement extratostatement = conn.prepareStatement(extratodepositoSQL, PreparedStatement.RETURN_GENERATED_KEYS);
                extratostatement.setTimestamp(1, data);
                extratostatement.setString(2, usuario.getCpflogado());
                extratostatement.setFloat(3, res.getFloat("ripple"));
                extratostatement.setFloat(4, res.getFloat("bitcoin"));
                extratostatement.setDouble(5, novosaldobrl);
                extratostatement.setDouble(6, novosaldoeth);
                extratostatement.setDouble(7, taxaTransacao);
                extratostatement.setFloat(8, coteth);
                extratostatement.setString(9, "+"+ compraeth + " ETH");
                extratostatement.executeUpdate();
                extratostatement.close(); 
                atualizarSaldoStatement.close();
            } else {
                // Caso erro
            }
        } catch(SQLException e) 
            {
            System.err.println("Erro ao executar a função comprabtc: " + e.getMessage());
            e.printStackTrace();
            }
        }
    }

public void compraxrp(Usuario usuario){
         
    float saldo = usuario.getReais();
    float saldoxrp = usuario.getSaldocripto();
   
    float compraxrp = usuario.getCompra();
    float cotxrp = usuario.getCotacao();
    double totalCompra = (float) (compraxrp * cotxrp) * 1.01;
    double taxaTransacao = totalCompra - (compraxrp * cotxrp);
    java.sql.Timestamp data = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
    data.setNanos(0);
    
     
    if(saldo-totalCompra <0){
        System.out.println("Impossible");
    } else { 
        double novosaldobrl =  (saldo - totalCompra);
        double novosaldoxrp = saldoxrp + compraxrp;
        
        try {
            String atualizarSaldoSQL = "UPDATE usuarios SET reais = ?, ripple = ? WHERE cpf = ?";
            PreparedStatement atualizarSaldoStatement = conn.prepareStatement(atualizarSaldoSQL);
            atualizarSaldoStatement.setDouble(1, novosaldobrl);
            atualizarSaldoStatement.setDouble(2, novosaldoxrp);
            atualizarSaldoStatement.setString(3, usuario.getCpflogado());
            atualizarSaldoStatement.executeUpdate();
            
            ResultSet res = consultarsaldo(usuario);
            if (res.next()) { 
                System.out.println(res.getFloat("bitcoin"));

                String extratodepositoSQL = "INSERT INTO extrato (data, cpf, ripple, bitcoin, reais, ethereum, taxa, cotacao, transacao)"
                        + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement extratostatement = conn.prepareStatement(extratodepositoSQL, PreparedStatement.RETURN_GENERATED_KEYS);
                extratostatement.setTimestamp(1, data);
                extratostatement.setString(2, usuario.getCpflogado());
                extratostatement.setDouble(3, novosaldoxrp);
                extratostatement.setFloat(4, res.getFloat("bitcoin"));
                extratostatement.setDouble(5, novosaldobrl);
                extratostatement.setDouble(6, res.getDouble("ethereum"));
                extratostatement.setDouble(7, taxaTransacao);
                extratostatement.setFloat(8, cotxrp);
                extratostatement.setString(9, "+"+ compraxrp + " XRP");
                extratostatement.executeUpdate();
                extratostatement.close(); 
                atualizarSaldoStatement.close();
            } else {
                // Caso erro
            }
        } catch(SQLException e) 
            {
            System.err.println("Erro ao executar a função comprabtc: " + e.getMessage());
            e.printStackTrace();
            }
        }
    }

    public void vendabtc(Usuario usuario) {
    float saldo = usuario.getReais();
    float saldobtc = usuario.getSaldocripto();
    float vendabtc = usuario.getCompra(); 
    float cotbtc = usuario.getCotacao();
    double totalVenda = (float) (vendabtc * cotbtc) * 0.97;
    double taxaTransacao = (vendabtc*cotbtc) - totalVenda;
    java.sql.Timestamp data = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
    data.setNanos(0);

    if (saldobtc - vendabtc < 0) { 
        System.out.println("Impossible");
    } else {
        double novosaldobrl = saldo + totalVenda; 
        double novosaldobtc = saldobtc - vendabtc; 

        try {
            String atualizarSaldoSQL = "UPDATE usuarios SET reais = ?, bitcoin = ? WHERE cpf = ?";
            PreparedStatement atualizarSaldoStatement = conn.prepareStatement(atualizarSaldoSQL);
            atualizarSaldoStatement.setDouble(1, novosaldobrl);
            atualizarSaldoStatement.setDouble(2, novosaldobtc);
            atualizarSaldoStatement.setString(3, usuario.getCpflogado());
            atualizarSaldoStatement.executeUpdate();
            atualizarSaldoStatement.close();

            ResultSet res = consultarsaldo(usuario);
            if (res.next()) { 
                System.out.println(res.getFloat("bitcoin"));

                String extratodepositoSQL = "INSERT INTO extrato (data, cpf, ripple, bitcoin, reais, ethereum, taxa, cotacao, transacao)"
                        + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement extratostatement = conn.prepareStatement(extratodepositoSQL, PreparedStatement.RETURN_GENERATED_KEYS);
                extratostatement.setTimestamp(1, data);
                extratostatement.setString(2, usuario.getCpflogado());
                extratostatement.setFloat(3, res.getFloat("ripple")); 
                extratostatement.setDouble(4, novosaldobtc);
                extratostatement.setDouble(5, novosaldobrl);
                extratostatement.setFloat(6, res.getFloat("ethereum")); 
                extratostatement.setDouble(7, taxaTransacao);
                extratostatement.setFloat(8, cotbtc);
                extratostatement.setString(9, "-" + vendabtc + " BTC"); 
                extratostatement.executeUpdate();
                extratostatement.close();
            } else {
                
            }
        } catch (SQLException e) {
            System.err.println("Erro ao executar a função vendabtc: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

    public void vendaeth(Usuario usuario) {
    float saldo = usuario.getReais();
    float saldoeth = usuario.getSaldocripto();
    float vendaeth = usuario.getCompra(); 
    float coteth = usuario.getCotacao();
    double totalVenda = (float) (vendaeth * coteth) * 0.97; 
    double taxaTransacao = (vendaeth*coteth)-totalVenda;
    java.sql.Timestamp data = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
    data.setNanos(0);

    if (saldoeth - vendaeth < 0) { 
        System.out.println("Impossible");
    } else {
        double novosaldobrl = saldo + totalVenda; 
        double novosaldoeth = saldoeth - vendaeth; 

        try {
            String atualizarSaldoSQL = "UPDATE usuarios SET reais = ?, bitcoin = ? WHERE cpf = ?";
            PreparedStatement atualizarSaldoStatement = conn.prepareStatement(atualizarSaldoSQL);
            atualizarSaldoStatement.setDouble(1, novosaldobrl);
            atualizarSaldoStatement.setDouble(2, novosaldoeth);
            atualizarSaldoStatement.setString(3, usuario.getCpflogado());
            atualizarSaldoStatement.executeUpdate();
            atualizarSaldoStatement.close();

            ResultSet res = consultarsaldo(usuario);
            if (res.next()) { 

                String extratodepositoSQL = "INSERT INTO extrato (data, cpf, ripple, bitcoin, reais, ethereum, taxa, cotacao, transacao)"
                        + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement extratostatement = conn.prepareStatement(extratodepositoSQL, PreparedStatement.RETURN_GENERATED_KEYS);
                extratostatement.setTimestamp(1, data);
                extratostatement.setString(2, usuario.getCpflogado());
                extratostatement.setFloat(3, res.getFloat("ripple")); 
                extratostatement.setFloat(4, res.getFloat("bitcoin"));
                extratostatement.setDouble(5, novosaldobrl);
                extratostatement.setDouble(6, novosaldoeth); 
                extratostatement.setDouble(7, taxaTransacao);
                extratostatement.setFloat(8, coteth);
                extratostatement.setString(9, "-" + vendaeth + " ETH"); 
                extratostatement.executeUpdate();
                extratostatement.close();
            } else {
                
            }
        } catch (SQLException e) {
            System.err.println("Erro ao executar a função vendabtc: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
    public void vendaxrp(Usuario usuario) {
    float saldo = usuario.getReais();
    float saldoxrp = usuario.getSaldocripto();
    float vendaxrp = usuario.getCompra(); 
    float cotxrp = usuario.getCotacao();
    double totalVenda = (float) (vendaxrp * cotxrp) * 0.97; 
    double taxaTransacao =  (vendaxrp*cotxrp) - totalVenda;
    java.sql.Timestamp data = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
    data.setNanos(0);

    if (saldoxrp - vendaxrp < 0) { 
        System.out.println("Impossible");
    } else {
        double novosaldobrl = saldo + totalVenda; 
        double novosaldoxrp = saldoxrp - vendaxrp; 

        try {
            String atualizarSaldoSQL = "UPDATE usuarios SET reais = ?, bitcoin = ? WHERE cpf = ?";
            PreparedStatement atualizarSaldoStatement = conn.prepareStatement(atualizarSaldoSQL);
            atualizarSaldoStatement.setDouble(1, novosaldobrl);
            atualizarSaldoStatement.setDouble(2, novosaldoxrp);
            atualizarSaldoStatement.setString(3, usuario.getCpflogado());
            atualizarSaldoStatement.executeUpdate();
            atualizarSaldoStatement.close();

            ResultSet res = consultarsaldo(usuario);
            if (res.next()) { 

                String extratodepositoSQL = "INSERT INTO extrato (data, cpf, ripple, bitcoin, reais, ethereum, taxa, cotacao, transacao)"
                        + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement extratostatement = conn.prepareStatement(extratodepositoSQL, PreparedStatement.RETURN_GENERATED_KEYS);
                extratostatement.setTimestamp(1, data);
                extratostatement.setString(2, usuario.getCpflogado());
                extratostatement.setDouble(3, novosaldoxrp); 
                extratostatement.setFloat(4, res.getFloat("bitcoin"));
                extratostatement.setDouble(5, novosaldobrl);
                extratostatement.setDouble(6, res.getFloat("ethereum")); 
                extratostatement.setDouble(7, taxaTransacao);
                extratostatement.setFloat(8, cotxrp);
                extratostatement.setString(9, "-" + vendaxrp + " XRP"); 
                extratostatement.executeUpdate();
                extratostatement.close();
            } else {
                
            }
        } catch (SQLException e) {
            System.err.println("Erro ao executar a função vendabtc: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
    
    
}
