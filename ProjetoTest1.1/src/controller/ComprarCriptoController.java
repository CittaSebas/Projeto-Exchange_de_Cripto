/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.Conexao;
import DAO.CotDAO;
import DAO.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Usuario;
import view.FrameComprarCripto;
import java.sql.ResultSet;
import model.Cotacao;

/**
 *
 * @author citta
 */
public class ComprarCriptoController {
    
    private FrameComprarCripto view;
    private String cpflogado;
    private float saldo;
    int id;

    public ComprarCriptoController(FrameComprarCripto view, String cpflogado) {
        this.view = view;
        this.cpflogado = cpflogado;
    }
    public void comprarbtc(){
        String txt,txt2,txt3;
        txt = view.getTxtcomprabtc().getText();
        float valorcompra = Float.parseFloat(txt);
        
        txt2 = view.getTxtcotbtc().getText();
        float cotacao = Float.parseFloat(txt2);
        
        txt3 = view.getTxtsaldo().getText();
        float saldo = Float.parseFloat(txt3);
        
        
        
        Usuario usuario = new Usuario(cpflogado,valorcompra,cotacao, saldo);
                        
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            dao.comprabtc(usuario);
             JOptionPane.showMessageDialog(view, "Transação ocorreu com sucesso!");
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view,"Erro de conexão");
        }
        
    }
    public void comprareth(){
        String txt,txt2,txt3;
        txt = view.getTxtcomrpaeth().getText();
        float valorcompra = Float.parseFloat(txt);
        
        txt2 = view.getTxtcoteth().getText();
        float cotacao = Float.parseFloat(txt2);
        
        txt3 = view.getTxtsaldo().getText();
        float saldo = Float.parseFloat(txt3);
        
        
        
        Usuario usuario = new Usuario(cpflogado,valorcompra,cotacao, saldo);
                        
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            dao.compraeth(usuario);
             JOptionPane.showMessageDialog(view, "Transação ocorreu com sucesso!");
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view,"Erro de conexão");
        }
        
    }
    public void comprarxrp(){
        String txt,txt2,txt3;
        txt = view.getTxtcompraxrp().getText();
        float valorcompra = Float.parseFloat(txt);
        
        txt2 = view.getTxtcoteth().getText();
        float cotacao = Float.parseFloat(txt2);
        
        txt3 = view.getTxtsaldo().getText();
        float saldo = Float.parseFloat(txt3);
        
        
        
        Usuario usuario = new Usuario(cpflogado,valorcompra,cotacao, saldo);
                        
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            dao.compraxrp(usuario);
             JOptionPane.showMessageDialog(view, "Transação ocorreu com sucesso!");
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view,"Erro de conexão");
        }
        
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
}
    

