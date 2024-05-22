/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.Conexao;
import DAO.CotDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.Cotacao;
import view.FrameCriarCripto;

/**
 *
 * @author Sebastian
 */
public class CriarCriptoController {
    
    private FrameCriarCripto view;
    
    public CriarCriptoController(FrameCriarCripto view){
        this.view = view;
    }
    
    public void adicionarmoeda(){
        String id = view.getTxtid().getText();
        
        String nome = view.getTxtnome().getText();
        
        String abrv = view.getTxtabreviacao().getText();
        
        String cotacao = view.getTxtvalor().getText();
        
        Cotacao moeda = new Cotacao(id,nome,abrv,cotacao);
        Conexao conexao = new Conexao();        
        try{
            Connection conn = conexao.getConnection();
            CotDAO dao = new CotDAO(conn);
            dao.adicionarmoeda(moeda);
            dao.updateCriptos(moeda);
            
             JOptionPane.showMessageDialog(view, "Transação ocorreu com sucesso!");
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view,"Erro de conexão");
        }}
    
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
        
    return moedas;}
    
    
    
}
    

