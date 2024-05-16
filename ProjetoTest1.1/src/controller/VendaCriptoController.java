/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.Conexao;
import DAO.CotDAO;
import DAO.UsuarioDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Usuario;
import view.FrameVendaCripto;

/**
 *
 * @author citta
 */
public class VendaCriptoController {
    
    private  FrameVendaCripto view;
    private String cpflogado;

    public VendaCriptoController(FrameVendaCripto view, String cpflogado) {
        this.view = view;
        this.cpflogado = cpflogado;
    }
    
    public ResultSet consultarsc() {
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
    public float cotacaobtc(){
        
    Conexao conexao = new Conexao();
    
    try {
        
        Connection conn = conexao.getConnection();
        CotDAO dao = new CotDAO(conn);
        ResultSet res = dao.consultar();
        if(res.next()){
        float cotbtc = res.getFloat("bitcoin");
        return cotbtc;}
        
        } catch (SQLException e) {
        JOptionPane.showMessageDialog(view, "Erro de conexão");
        e.printStackTrace(); 
        return 0.0f; 
    }
        
        
    JOptionPane.showMessageDialog(view, "Erro ao buscar dados.");
    return 0.0f;}

    
    public float cotacaoxrp(){
        Conexao conexao = new Conexao();
    
    try {
        
        Connection conn = conexao.getConnection();
        CotDAO dao = new CotDAO(conn);
        ResultSet res = dao.consultar();
        if(res.next()){
        float cotxrp = res.getFloat("ripple");
        return cotxrp;}
        
        } catch (SQLException e) {
        JOptionPane.showMessageDialog(view, "Erro de conexão");
        e.printStackTrace(); 
        return 0.0f; 
    }
        
        
    JOptionPane.showMessageDialog(view, "Erro ao buscar dados.");
    return 0.0f;}
    
    
    public float cotacaoeth(){
    Conexao conexao = new Conexao();
    
    try {
        
        Connection conn = conexao.getConnection();
        CotDAO dao = new CotDAO(conn);
        ResultSet res = dao.consultar();
        if(res.next()){
        float coteth = res.getFloat("ethereum");
        return coteth;}
        
        } catch (SQLException e) {
        JOptionPane.showMessageDialog(view, "Erro de conexão");
        e.printStackTrace(); 
        return 0.0f; }
    JOptionPane.showMessageDialog(view, "Erro ao buscar dados.");
    return 0.0f;}
    
    public void venda(){
        String txt;
        txt = view.getTxtvendabtc().getText();
        float valordeposito = Float.parseFloat(txt);
        Usuario usuario = new Usuario(valordeposito, cpflogado);
                        
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            dao.atualizarSaldo(usuario);
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view,"Erro de conexão");
        }
}}




    
    
    

