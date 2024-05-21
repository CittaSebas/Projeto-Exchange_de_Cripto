/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.AdminsDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Administrador;
import model.Usuario;
import view.FrameClientes;

/**
 *
 * @author Sebastian
 */
public class ClientesController {
    
    private FrameClientes view;
    private String cpfusuario;
    
    public ClientesController(FrameClientes view) {
        this.view = view;
    }
    
    public void CadastrarUsuario(){
       
        String cpf = view.getTxtcpfusuario().getText();
        String senha = view.getTxtsenha().getText();
        String nome = view.getTxtnome().getText();
        float ripple = 0f;
        float ethereum= 0f;
        float bitcoin = 0f;
        float reais = 0f;
        Usuario usuario = new Usuario(cpf,senha,nome,ripple,ethereum,bitcoin,reais);
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            AdminsDAO dao = new AdminsDAO(conn);
            dao.inserir(usuario);
            JOptionPane.showMessageDialog(view,"Usuario Cadastrado");
        }catch (SQLException e){
            JOptionPane.showMessageDialog(view,"Usuario nao Cadastrado");
        }
    }
    
    public void DeletarUsuario(){
        String cpf = view.getTxtcpfusuario().getText();
        Conexao conexao = new Conexao();

        try {
            Connection conn = conexao.getConnection();
            AdminsDAO dao = new AdminsDAO(conn);
            dao.deletar(cpf);
            JOptionPane.showMessageDialog(view, "Usuário deletado com sucesso.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro ao deletar usuário: " + e.getMessage());
        } 
    }  
}