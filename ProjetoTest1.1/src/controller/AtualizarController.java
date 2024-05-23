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
import view.FrameAtualizar;
import java.sql.ResultSet;
import model.Cotacao;
import java.util.Random;

/**
 *
 * @author Sebastian
 */
public class AtualizarController {
    
    private FrameAtualizar view;
    private float saldo;
    int id;
    
    private Random random = new Random();
    
    private float gerarVariacao() {
        return (random.nextFloat() * 0.1f) - 0.05f;
    }
    
    
    // Função de Atualizar
    private void atualizarCotacao(String moeda, float novaCotacao) {
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            CotDAO dao = new CotDAO(conn);
            dao.atualizar(moeda, novaCotacao);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro ao atualizar cotação no banco de dados");
            e.printStackTrace();
        }
    }
    
    
     // Função para pegar Cotação de BTC
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

    
    // Função para pegar Cotação de XRP
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
    
    
    // Função para pegar Cotação de ETH
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
    
    
    
    
    
    // Função para 
    public void atualizarCotas() {
        float cotacaoAtualBtc = cotacaobtc();
        float cotacaoAtualXrp = cotacaoxrp();
        float cotacaoAtualEth = cotacaoeth();

        float novaCotacaoBtc = cotacaoAtualBtc + (cotacaoAtualBtc * gerarVariacao());
        float novaCotacaoXrp = cotacaoAtualXrp + (cotacaoAtualXrp * gerarVariacao());
        float novaCotacaoEth = cotacaoAtualEth + (cotacaoAtualEth * gerarVariacao());

        atualizarCotacao("bitcoin", novaCotacaoBtc);
        atualizarCotacao("ripple", novaCotacaoXrp);
        atualizarCotacao("ethereum", novaCotacaoEth);

        JOptionPane.showMessageDialog(view, "Cotações atualizadas com sucesso");
    }
    
    public String[] checkarmoedas(){
        String[] moedas = new String[0];
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            CotDAO dao = new CotDAO(conn);
            moedas = dao.checkarmoedas();
            return moedas;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view,"Erro de conexão");
        }
        
        return moedas;
    }
    
}
