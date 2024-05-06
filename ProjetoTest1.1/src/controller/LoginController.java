package controller;

import DAO.Conexao;
import DAO.UsuarioDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Usuario;
import view.FrameLogin;
import view.FrameUsuario;

public class LoginController {
    private FrameLogin view;
    

    public LoginController(FrameLogin view) {
        this.view = view;
    }
    
    public void loginUsuario(){
        
        Usuario usuario = new Usuario(view.getTxtcpf().getText(),
                        view.getTxtsenha().getText());
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            ResultSet res = dao.consultar(usuario);
            if(res.next()){
                JOptionPane.showMessageDialog(view,"Login feito!");
                String cpf = res.getString("cpf");
                String senha = res.getString("senha");
                
                
                
                
           
                
            }else{
                JOptionPane.showMessageDialog(view,"Login nao foi efetuado!"); 
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view,"Erro de conexão");
        }
    }
    
    
}
