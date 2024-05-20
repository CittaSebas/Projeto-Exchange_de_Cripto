package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Administrador;

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
        statement.setString(1,admin.getCpflogado());
        ResultSet resultado = statement.executeQuery();
        return resultado;
    }
    
    public void inserir(Administrador admin) throws SQLException {
    String sql = "INSERT INTO usuarios (cpf, senha, ripple, bitcoin, reais, ethereum, nome) VALUES (?, ?, ?, ?, ?, ?, ?)";
    PreparedStatement statement = conn.prepareStatement(sql);
    statement.setString(1, admin.getCpf());
    statement.setString(2, admin.getSenha());
    statement.setFloat(3, 0f);
    statement.setFloat(4, 0f);
    statement.setFloat(5, 0f);
    statement.setFloat(6, 0f);
    statement.setString(7, admin.getNome());
    statement.executeUpdate();
    statement.close(); 
}
    public void criaradmin(Administrador admin) throws SQLException {
    String sql = "INSERT INTO administradores (cpf, senha) VALUES (?, ?)";
    
    try ( // Supondo que você tenha um método getConnection()
        PreparedStatement statement = conn.prepareStatement(sql)) {
        System.out.println(admin.getCpf());
        System.out.println(admin.getSenha());
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
}
 
