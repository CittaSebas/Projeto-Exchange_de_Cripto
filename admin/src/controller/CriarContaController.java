/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.Conexao;
import DAO.AdminsDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Administrador;
import view.FrameCriarConta;

/**
 *
 * @author Sebastian
 */
public class CriarContaController {
    private FrameCriarConta view;

    public CriarContaController(FrameCriarConta view) {
        this.view = view;
    }
    
    public int cadastraradministrador(){
        
        String cpf = view.getTxtcpf().getText();
        String senha = view.getTxtsenha().getText();
        Administrador admin = new Administrador(cpf,senha);
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            AdminsDAO dao = new AdminsDAO(conn);
            ResultSet resultado = dao.loginadmin(admin);
            if(resultado.next()){
                return 0;
            }
            else{
                dao.criaradmin(admin);
                return 1;
            }

        }catch (SQLException e){
            e.printStackTrace();
            return 2;
            
        }
    }
}
