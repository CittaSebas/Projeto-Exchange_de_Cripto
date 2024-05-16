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
import model.Extrato;
import model.Usuario;
import view.FrameSaldo;

/**
 *
 * @author citta
 */
public class SaldoController {
    
    private FrameSaldo view;
    private String cpflogado, saldo;
    
        public SaldoController(FrameSaldo view, String cpflogado) {
        this.view = view;
        this.cpflogado = cpflogado;
    }
        
   public ResultSet consultarsaldo() {
        Conexao conexao = new Conexao();
        ResultSet resultSet = null; 
        
        try {
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            resultSet = dao.consultarsaldo(new Usuario(cpflogado)); 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro de conexão");
            e.printStackTrace();
        }
        
        return resultSet;
    }    
    public String imprimirextrato(){
        
        Extrato extrato = new Extrato(cpflogado);
        
        
                        
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            return dao.imprimirextrato(extrato);
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view,"Erro de conexão");
            return null;
        }}}

