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
import view.FrameVenderNovas;

/**
 *
 * @author citta
 */
public class VendaCriptoController {
    
    private FrameVendaCripto view;
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
    
    public void vendabtc(){
        String txt,txt2,txt3,txt4;
        txt = view.getTxtvendabtc().getText();
        float valorvenda = Float.parseFloat(txt);
        
        txt2 = view.getTxtcotbtc().getText();
        float cotacao = Float.parseFloat(txt2);
        
        txt3 = view.getTxtsaldo().getText();
        float saldo = Float.parseFloat(txt3);
        
        txt4 = view.getTxtbtc().getText();
        float saldocripto = Float.parseFloat(txt4);
        
        
        
        Usuario usuario = new Usuario(cpflogado,valorvenda,cotacao, saldo, saldocripto);
                        
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            dao.vendabtc(usuario);
             JOptionPane.showMessageDialog(view, "Transação ocorreu com sucesso!");
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view,"Erro de conexão");
        }
        
    }
    public void vendaeth(){
        String txt,txt2,txt3,txt4;
        txt = view.getTxtvendaeth().getText();
        float valorvenda = Float.parseFloat(txt);
        
        txt2 = view.getTxtcoteth().getText();
        float cotacao = Float.parseFloat(txt2);
        
        txt3 = view.getTxtsaldo().getText();
        float saldo = Float.parseFloat(txt3);
        
        txt4 = view.getTxteth().getText();
        float saldocripto = Float.parseFloat(txt4);
   
        
        Usuario usuario = new Usuario(cpflogado,valorvenda,cotacao, saldo,saldocripto);
                        
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            dao.vendaeth(usuario);
             JOptionPane.showMessageDialog(view, "Transação ocorreu com sucesso!");
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view,"Erro de conexão");
        }
        
    }
    public void vendaxrp(){
        String txt,txt2,txt3,txt4;
        txt = view.getTxtvendaxrp().getText();
        float valorvenda = Float.parseFloat(txt);
        
        txt2 = view.getTxtcotripple().getText();
        float cotacao = Float.parseFloat(txt2);
        
        txt3 = view.getTxtsaldo().getText();
        float saldo = Float.parseFloat(txt3);
        
        txt4 = view.getTxtxrp().getText();
        float saldocripto = Float.parseFloat(txt4);
        
        Usuario usuario = new Usuario(cpflogado,valorvenda,cotacao, saldo,saldocripto);
                        
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            dao.vendaxrp(usuario);
             JOptionPane.showMessageDialog(view, "Transação ocorreu com sucesso!");
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view,"Erro de conexão");
        }
        
    }
    
}




    
    
    

