/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.AdminsDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Administrador;
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
        Administrador admin = new Administrador(cpf,senha,nome);
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            AdminsDAO dao = new AdminsDAO(conn);
            dao.inserir(admin);
            JOptionPane.showMessageDialog(view,"Cliente Cadastrado");
        }catch (SQLException e){
            JOptionPane.showMessageDialog(view,"Cliente nao Cadastrado");
        }
    }
    
}
