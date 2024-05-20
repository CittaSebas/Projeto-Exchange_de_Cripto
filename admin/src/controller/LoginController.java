package controller;

import DAO.Conexao;
import DAO.AdminsDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Administrador;
import view.FrameLogin;
import view.FrameMenu;
/**
 *
 * @author Sebastian
 */
public class LoginController {
    private FrameLogin view;
    

    public LoginController(FrameLogin view) {
        this.view = view;
    }
    
    public int loginUsuario(){
        
        Administrador admin = new Administrador(view.getTxtcpf().getText(),
                        view.getTxtsenha().getText());
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            AdminsDAO dao = new AdminsDAO(conn);
            ResultSet res = dao.loginadmin(admin);
            if(res.next()){
                JOptionPane.showMessageDialog(view,"Login feito!");
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
