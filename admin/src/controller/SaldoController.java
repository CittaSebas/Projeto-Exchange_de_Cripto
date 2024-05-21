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
import javax.swing.JOptionPane;
import model.Administrador;
import model.Extrato;
import model.Usuario;
import view.FrameSaldo;

/**
 *
 * @author citta
 */
public class SaldoController {
    
    private FrameSaldo view;
    private String cpfusuario;
    
        public SaldoController(FrameSaldo view, String cpfusuario) {
        this.view = view;
        this.cpfusuario = cpfusuario;
    }
        public ResultSet consultarsaldo() {
        Conexao conexao = new Conexao();
        ResultSet resultSet = null; 
        
        try {
            Connection conn = conexao.getConnection();
            AdminsDAO dao = new AdminsDAO(conn);
            resultSet = dao.consultarsaldo(new Administrador(cpfusuario)); 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro de conexão");
            e.printStackTrace();
        }
        
        return resultSet;
    }  
        public String imprimirextrato(){
        
        Extrato extrato = new Extrato(cpfusuario);
        
        
                        
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            AdminsDAO dao = new AdminsDAO(conn);
            return dao.imprimirextrato(extrato);
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view,"Erro de conexão");
            return null;
        }}}

