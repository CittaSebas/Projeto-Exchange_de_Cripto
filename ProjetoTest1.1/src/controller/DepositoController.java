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
import view.FrameSaque;

/**
 *
 * @author citta
 */
public class DepositoController {
    
    private FrameDeposito view;
    private FrameSaque view2;
    private String cpflogado, txt;
    float valordeposito,valorsaque;
    public DepositoController(FrameDeposito view, String cpflogado) {
        this.view = view;
        this.cpflogado = cpflogado;
    }

    public DepositoController(FrameSaque view2, String cpflogado) {
        this.view2 = view2;
        this.cpflogado = cpflogado;
    }
    public float saldo(){ 
        Usuario usuario = new Usuario(cpflogado);
        Conexao conexao = new Conexao();
    try (Connection conn = conexao.getConnection()) {
        UsuarioDAO dao = new UsuarioDAO(conn);
        ResultSet res = dao.consultarsaldo(usuario);
        if(res.next()){
        float saldo = res.getFloat("reais");
            return saldo;
        }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, e.getMessage(), "Erro de Busca de Dados", JOptionPane.ERROR_MESSAGE);
            return 0f;
        }
    return 0f;}
    
    public void depositar() {
    String txt = view.getTxtvalordeposito().getText();
    float valordeposito = Float.parseFloat(txt);
    Usuario usuario = new Usuario(valordeposito, cpflogado);

    Conexao conexao = new Conexao();
    try (Connection conn = conexao.getConnection()) {
        UsuarioDAO dao = new UsuarioDAO(conn);
        dao.atualizarSaldo(usuario, 1);
        JOptionPane.showMessageDialog(view, "Depósito realizado com sucesso!");
        } catch (SQLException e) {
        JOptionPane.showMessageDialog(view, e.getMessage(), "Erro de Transação", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
        JOptionPane.showMessageDialog(view, e.getMessage(), "Erro de Transação", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void sacar() {
    String txt = view2.getTxtvalorsaque().getText();
    float valorsaque = Float.parseFloat(txt);
    Usuario usuario = new Usuario(valorsaque, cpflogado);

    Conexao conexao = new Conexao();
    try (Connection conn = conexao.getConnection()) {
        UsuarioDAO dao = new UsuarioDAO(conn);
        dao.atualizarSaldo(usuario, 0);
        JOptionPane.showMessageDialog(view, "Saque realizado com sucesso!");
        } catch (SQLException e) {
            // Mostrar mensagem de erro detalhada
            JOptionPane.showMessageDialog(view, e.getMessage(), "Erro de Transação", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            // Capturar exceção de argumento ilegal para código de operação inválido
            JOptionPane.showMessageDialog(view, e.getMessage(), "Erro de Transação", JOptionPane.ERROR_MESSAGE);
        }
    }
}
