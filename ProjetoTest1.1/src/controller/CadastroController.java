/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.Conexao;
import DAO.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Usuario;
import view.FrameCadastro;

/**
 *
 * @author citta
 */
public class CadastroController {
    private FrameCadastro view;

    public CadastroController(FrameCadastro view) {
        this.view = view;
    }
    
    public void cadastrarusuario(){
        String cpf = view.getTxtcpf().getText();
        String senha = view.getTxtsenha().getText();
        String nome = view.getTxtnome().getText();
        float ripple = 0f;
        float ethereum= 0f;
        float bitcoin = 0f;
        float reais = 0f;
        Usuario usuario = new Usuario(cpf,senha,nome,ripple,ethereum,bitcoin,reais);
        Conexao conexao = new Conexao();
        try {
        Connection conn = conexao.getConnection();
        UsuarioDAO dao = new UsuarioDAO(conn);

        // Verificar se o CPF já está cadastrado
        if (dao.existeCpf(cpf)) {
            JOptionPane.showMessageDialog(view, "CPF já cadastrado!");
        } else {
            dao.inserir(usuario);
            JOptionPane.showMessageDialog(view, "Usuário Cadastrado com sucesso");
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(view, "Erro ao cadastrar usuário: " + e.getMessage());
    }
    }
    
}
