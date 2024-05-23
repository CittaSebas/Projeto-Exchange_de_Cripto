package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import model.Administrador;
import model.Cotacao;
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
    public String [] checkarmoedascpf(String cpf) throws SQLException{
        String sql1 = "SELECT criptos FROM usuarios WHERE cpf = ?";
        String [] moeda = new String[0];
        PreparedStatement statement = conn.prepareStatement(sql1);
        statement.setString(1,cpf);
        ResultSet rs = statement.executeQuery();
        
        
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
    
    public String [] checkarmoedascod() throws SQLException{
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
        
    return moeda;}return moeda;
        }
    }
    
    public void inserir(Usuario usuario) throws SQLException {
    String[] moedas;
    moedas = checkarmoedascod();
    if (moedas.length >= 4){
        moedas[2] = "0";
    } if (moedas.length >= 8 ){
         moedas[6] = "0";
    } else if (moedas.length == 12){
        moedas[10] = "0";
    }
    java.sql.Array criptos = conn.createArrayOf("text", moedas);
    String sql = "INSERT INTO usuarios (cpf, senha, ripple, bitcoin, reais, ethereum, nome, criptos) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    PreparedStatement statement = conn.prepareStatement(sql);
    statement.setString(1, usuario.getCpf());
    statement.setString(2, usuario.getSenha());
    statement.setFloat(3, 0f);
    statement.setFloat(4, 0f);
    statement.setFloat(5, 0f);
    statement.setFloat(6, 0f);
    statement.setString(7, usuario.getNome());
    statement.setArray(8, criptos);
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
    
    public int criaradmin(Administrador admin) throws SQLException {
    String sqlCheck = "SELECT cpf FROM administradores WHERE cpf = ?";
    try (PreparedStatement statementCheck = conn.prepareStatement(sqlCheck)) {
        statementCheck.setString(1, admin.getCpf());
        ResultSet resCheck = statementCheck.executeQuery();
        if (resCheck.next()) {
            return 1;
        } else {
            String sqlInsert = "INSERT INTO administradores (cpf, senha) VALUES (?, ?)";
            try (PreparedStatement statementInsert = conn.prepareStatement(sqlInsert)) {
                statementInsert.setString(1, admin.getCpf());
                statementInsert.setString(2, admin.getSenha());
                statementInsert.executeUpdate();
                return 0;
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
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
                    .append("ETH: ").append(ethereum+" ").append("XRP: ").append(ripple+" ");
            String [] moedas;
            
            
            moedas = checkarmoedascpf(cpf);
            if(moedas.length >=4){
                String saldom1 = moedas[2];
                String abv1 = moedas[3];
                extratoString.append(saldom1 + " "+ abv1 + " ");
                
            }
            if(moedas.length >=8){
                String saldom2 = moedas[6];
                String abv2 = moedas[7];
                extratoString.append(saldom2 + " "+ abv2+ " ");
            }
            if(moedas.length >=12){
                String saldom3 = moedas[10];
                String abv3 = moedas[11];
                extratoString.append(saldom3 + " "+ abv3);
            }
            
            
    }
        return extratoString.toString();
    }
    
    
    
    
    
    
}


