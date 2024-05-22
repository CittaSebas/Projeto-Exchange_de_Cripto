package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Administrador;
import model.Extrato;
import model.Usuario;

/**
 *
 * @author Sebastian
 */
public class AdminsDAO {
    private Connection conn;

    public AdminsDAO(Connection conn) {
        this.conn = conn;
    }
    
    public ResultSet consultar(Administrador admin) throws SQLException{
        
        
        String sql = "select * from usuarios where cpf = ? ";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,admin.getCpf());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    
    public ResultSet loginadmin(Administrador admin) throws SQLException{
        
        
        String sql = "select * from administradores where cpf = ? and senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,admin.getCpf());
        statement.setString(2, admin.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    
    public ResultSet consultarsaldo(Administrador admin) throws SQLException{
        
        String sql = "select * from usuarios where cpf = ? ";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,admin.getCpfusuario());
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
    public void deletar(String cpf) throws SQLException {
    String sql = "DELETE FROM usuarios WHERE cpf = ?";
    PreparedStatement statement = conn.prepareStatement(sql);
    statement.setString(1, cpf);
    statement.executeUpdate();
    statement.close();
}
    
    public void criaradmin(Administrador admin) throws SQLException {
    String sql = "INSERT INTO administradores (cpf, senha) VALUES (?, ?)";
    
    try ( // Supondo que você tenha um método getConnection()
        PreparedStatement statement = conn.prepareStatement(sql)) {
        statement.setString(1, admin.getCpf());
        statement.setString(2, admin.getSenha());
        statement.executeUpdate();
        
        
    } catch (SQLException e) {
        // Aqui você pode registrar a exceção e/ou lançar uma nova exceção específica da sua aplicação
        e.printStackTrace();
        // Logger.log(e); // Supondo que você tenha um sistema de logging
        throw new RuntimeException("Erro ao criar administrador", e);
    }
}

    public void excluir(Administrador admin) throws SQLException{
        String sql = "delete from usuarios where cpf = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,admin.getCpf());
        statement.execute();
        conn.close();
    }
    
    public void atualizar(Administrador admin) throws SQLException{
        String sql = "update usuarios set senha = ? where cpf = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,admin.getSenha());
        statement.setString(2,admin.getCpf());
        statement.execute();
        conn.close();
    }


    public String imprimirextrato(Extrato extrato) throws SQLException{
            StringBuilder extratoString = new StringBuilder();

            // Consulta para obter o nome do cliente
        String sqlnome = "select nome from usuarios where cpf = ?";
        PreparedStatement stat = conn.prepareStatement(sqlnome);
        stat.setString(1, extrato.getCpfusuario());
        ResultSet res = stat.executeQuery(); 
        String nome = "";
        if (res.next()) {
            nome = res.getString("nome");
        }


            String sql = "select * from extrato where cpf = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,extrato.getCpfusuario());
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
    
    
    
}


