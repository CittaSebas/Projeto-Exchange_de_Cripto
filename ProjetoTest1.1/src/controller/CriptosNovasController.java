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
import java.util.Arrays;
import javax.swing.JOptionPane;
import model.Usuario;
import view.FrameCriptosNovas;
import view.FrameVenderNovas;

/**
 *
 * @author citta
 */
public class CriptosNovasController {
    private String cpflogado;
    private FrameCriptosNovas view;
    private FrameVenderNovas view2;

    public CriptosNovasController( FrameCriptosNovas view,String cpflogado) {
        this.cpflogado = cpflogado;
        this.view = view;
    }

    public CriptosNovasController(FrameVenderNovas view2,String cpflogado) {
        this.cpflogado = cpflogado;
        this.view2 = view2;
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
        
    return moedas;}
    
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
    public float consultarsaldo() {
    Conexao conexao = new Conexao();
    
    try {
        Connection conn = conexao.getConnection();
        UsuarioDAO dao = new UsuarioDAO(conn);
        ResultSet res = dao.consultarsaldo(new Usuario(cpflogado)); 
        while(res.next()){
            float saldo = res.getFloat("reais");
            return saldo;
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(view, "Erro de conexão");
        e.printStackTrace();
    }
    
    return 0f; 
}
    public String saldom1(){
        Conexao conexao = new Conexao();
    
    try {
        Connection conn = conexao.getConnection();
        UsuarioDAO dao = new UsuarioDAO(conn);
        ResultSet res = dao.consultarsaldo(new Usuario(cpflogado)); 
        while(res.next()){
            java.sql.Array criptos = res.getArray("criptos"); // Obtendo o array SQL
            String[] str_critpos = (String[]) criptos.getArray();
            return str_critpos[2];
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(view, "Erro de conexão");
        e.printStackTrace();
    }
    
    return ""; 
    }
    public String saldom2(){
        Conexao conexao = new Conexao();
    
    try {
        Connection conn = conexao.getConnection();
        UsuarioDAO dao = new UsuarioDAO(conn);
        ResultSet res = dao.consultarsaldo(new Usuario(cpflogado)); 
        while(res.next()){
            java.sql.Array criptos = res.getArray("criptos"); // Obtendo o array SQL
            String[] str_critpos = (String[]) criptos.getArray();
            // Imprimindo o array
            System.out.println(Arrays.toString(str_critpos));
            return str_critpos[6];
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(view, "Erro de conexão");
        e.printStackTrace();
    }
    
    return ""; 
    }
    public String saldom3(){
        Conexao conexao = new Conexao();
    
    try {
        Connection conn = conexao.getConnection();
        UsuarioDAO dao = new UsuarioDAO(conn);
        ResultSet res = dao.consultarsaldo(new Usuario(cpflogado)); 
        while(res.next()){
            java.sql.Array criptos = res.getArray("criptos"); // Obtendo o array SQL
            String[] str_critpos = (String[]) criptos.getArray();
            return str_critpos[10];
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(view, "Erro de conexão");
        e.printStackTrace();
    }
    
    return ""; 
    }
    public void comprarmoeda1(String [] moeda){
        String txt,txt2,txt3,txt4;
        txt = view.getTxtvalorcompra1().getText();
        float valorcompra = Float.parseFloat(txt);
        
        txt2 = view.getTxtvalor1().getText();
        float cotacao = Float.parseFloat(txt2);
        
        txt3 = view.getTxtsaldo().getText();
        float saldo = Float.parseFloat(txt3);
        
        txt4 = view.getTxtsaldom1().getText();
        float saldocripto = Float.parseFloat(txt4);
        
        Usuario usuario = new Usuario(cpflogado,valorcompra,cotacao, saldo,saldocripto);
                        
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            dao.compramoeda1(usuario,moeda);
             JOptionPane.showMessageDialog(view, "Transação ocorreu com sucesso!");
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view,"Erro de conexão");
        }
        
    }
    public void comprarmoeda2(String [] moeda){
        String txt,txt2,txt3,txt4;
        txt = view.getTxtvalorcompra2().getText();
        float valorcompra = Float.parseFloat(txt);
        
        txt2 = view.getTxtvalor2().getText();
        float cotacao = Float.parseFloat(txt2);
        
        txt3 = view.getTxtsaldo().getText();
        float saldo = Float.parseFloat(txt3);
        
        txt4 = view.getTxtsaldom2().getText();
        float saldocripto = Float.parseFloat(txt4);
        
        Usuario usuario = new Usuario(cpflogado,valorcompra,cotacao, saldo,saldocripto);
                        
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            dao.compramoeda2(usuario,moeda);
             JOptionPane.showMessageDialog(view, "Transação ocorreu com sucesso!");
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view,"Erro de conexão");
        }
        
    }
    public void comprarmoeda3(String [] moeda){
        String txt,txt2,txt3,txt4;
        txt = view.getTxtvalorcompra3().getText();
        float valorcompra = Float.parseFloat(txt);
        
        txt2 = view.getTxtvalor3().getText();
        float cotacao = Float.parseFloat(txt2);
        
        txt3 = view.getTxtsaldo().getText();
        float saldo = Float.parseFloat(txt3);
        
        txt4 = view.getTxtsaldom3().getText();
        float saldocripto = Float.parseFloat(txt4);
        
        Usuario usuario = new Usuario(cpflogado,valorcompra,cotacao, saldo,saldocripto);
                        
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            dao.compramoeda3(usuario,moeda);
             JOptionPane.showMessageDialog(view, "Transação ocorreu com sucesso!");
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view,"Erro de conexão");
        }
        
    }
    
    public void vendermoeda1(String [] moeda){
        String txt,txt2,txt3,txt4;
        txt = view2.getTxtvalorcompra1().getText();
        float valorcompra = Float.parseFloat(txt);
        
        txt2 = view2.getTxtvalor1().getText();
        float cotacao = Float.parseFloat(txt2);
        
        txt3 = view2.getTxtsaldo().getText();
        float saldo = Float.parseFloat(txt3);
        
        txt4 = view2.getTxtsaldom1().getText();
        float saldocripto = Float.parseFloat(txt4);
        
        Usuario usuario = new Usuario(cpflogado,valorcompra,cotacao, saldo,saldocripto);
                        
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            dao.vendermoeda1(usuario,moeda);
             JOptionPane.showMessageDialog(view2, "Transação ocorreu com sucesso!");
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view2,"Erro de conexão");
        }
        
    }
    public void vendermoeda2(String [] moeda){
        String txt,txt2,txt3,txt4;
        txt = view2.getTxtvalorcompra1().getText();
        float valorcompra = Float.parseFloat(txt);
        
        txt2 = view2.getTxtvalor1().getText();
        float cotacao = Float.parseFloat(txt2);
        
        txt3 = view2.getTxtsaldo().getText();
        float saldo = Float.parseFloat(txt3);
        
        txt4 = view2.getTxtsaldom1().getText();
        float saldocripto = Float.parseFloat(txt4);
        
        Usuario usuario = new Usuario(cpflogado,valorcompra,cotacao, saldo,saldocripto);
                        
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            dao.vendermoeda2(usuario,moeda);
             JOptionPane.showMessageDialog(view2, "Transação ocorreu com sucesso!");
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view2,"Erro de conexão");
        }
        
    }
    public void vendermoeda3(String [] moeda){
        String txt,txt2,txt3,txt4;
        txt = view2.getTxtvalorcompra1().getText();
        float valorcompra = Float.parseFloat(txt);
        
        txt2 = view2.getTxtvalor1().getText();
        float cotacao = Float.parseFloat(txt2);
        
        txt3 = view2.getTxtsaldo().getText();
        float saldo = Float.parseFloat(txt3);
        
        txt4 = view2.getTxtsaldom1().getText();
        float saldocripto = Float.parseFloat(txt4);
        
        Usuario usuario = new Usuario(cpflogado,valorcompra,cotacao, saldo,saldocripto);
                        
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            dao.vendermoeda3(usuario,moeda);
             JOptionPane.showMessageDialog(view2, "Transação ocorreu com sucesso!");
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view2,"Erro de conexão");
        }
        
    }
}
