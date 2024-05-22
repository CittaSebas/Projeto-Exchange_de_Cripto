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
    
    public int loginUsuario(){
        
        Usuario usuario = new Usuario(view.getTxtcpf().getText(),
                        view.getTxtsenha().getText());
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            ResultSet res = dao.loginusuario(usuario);
            if(res.next()){
                String cpf = res.getString("cpf");
                String senha = res.getString("senha");
                return 1;
  
            }else{
                return 0;
            }
            
        }catch(SQLException e){
            return 2;
        }
    }
    
    
}
