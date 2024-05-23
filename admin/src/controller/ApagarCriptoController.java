/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.AdminsDAO;
import DAO.Conexao;
import DAO.CotDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import view.FrameApagarCripto;

/**
 *
 * @author Sebastian
 */
public class ApagarCriptoController {
    
    private FrameApagarCripto view;

    public ApagarCriptoController(FrameApagarCripto view) {
        this.view = view;
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
    
    public void apagarmoeda1(){
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            CotDAO dao = new CotDAO(conn);
            dao.saldo1();
            dao.apagarmoeda1();
            JOptionPane.showMessageDialog(view,"Apagado com Sucesso");
            }catch(SQLException e){
        }
    }
    
    public void apagarmoeda2(){
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            CotDAO dao = new CotDAO(conn);
            dao.saldo2();
            dao.apagarmoeda2();
            JOptionPane.showMessageDialog(view,"Apagado com Sucesso");
            }catch(SQLException e){
        }
    }
    
    public void apagarmoeda3(){
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            CotDAO dao = new CotDAO(conn);
            dao.saldo3();
            dao.apagarmoeda3();
            JOptionPane.showMessageDialog(view,"Apagado com Sucesso");
            }catch(SQLException e){
        }
    }
}
