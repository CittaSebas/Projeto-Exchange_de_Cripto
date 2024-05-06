/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.Conexao;
import DAO.UsuarioDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Usuario;
import view.FrameDeposito;

/**
 *
 * @author citta
 */
public class DepositoController {
    
    private FrameDeposito view;
    private String cpflogado, txt;
    float valordeposito;
    public DepositoController(FrameDeposito view, String cpflogado) {
        this.view = view;
        this.cpflogado = cpflogado;
    }
    
    public void depositar(){
        txt = view.getTxtvalordeposito().getText();
        valordeposito = Float.parseFloat(txt);
        Usuario usuario = new Usuario(valordeposito, cpflogado);
                        
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            dao.atualizarSaldo(usuario);
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view,"Erro de conexão");
        }
    
    
    
}
}