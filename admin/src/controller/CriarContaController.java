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
    
    public void cadastraradministrador(){
        
        String senha = view.getTxtsenha().getText();
        String cpf = view.getTxtcpf().getText();
        Administrador admin = new Administrador(cpf,senha);
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            AdminsDAO dao = new AdminsDAO(conn);
            int cod = dao.criaradmin(admin);
            if(cod == 0){
                JOptionPane.showMessageDialog(view, "Cadastrado!");
            } else if (cod == 1){
                JOptionPane.showMessageDialog(view, "CPF já cadastrado!");
            }else{
            JOptionPane.showMessageDialog(view, "Erro de conexão!");
        }

        }catch (SQLException e){
            e.printStackTrace();
            
        }
    }
}
