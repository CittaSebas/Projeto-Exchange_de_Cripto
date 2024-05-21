/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Timestamp;

/**
 *
 * @author citta
 */
public class Extrato {
    
    private String cpf, senha,cpfusuario, nome;
    private float ripple, ethereum, bitcoin, reais, transacao, taxa, cotacao;
    private java.sql.Timestamp data;

    public Extrato(String cpf,String nome, String cpfusuario, float ripple, float ethereum, 
            float bitcoin, float reais, float transacao, float taxa, float cotacao, Timestamp data) {
        this.cpf = cpf;
        this.nome = nome;
        this.cpfusuario = cpfusuario;
        this.ripple = ripple;
        this.ethereum = ethereum;
        this.bitcoin = bitcoin;
        this.reais = reais;
        this.transacao = transacao;
        this.taxa = taxa;
        this.cotacao = cotacao;
        this.data = data;
    }

    public Extrato(String cpfusuario) {
        this.cpfusuario = cpfusuario;
    }
    
    
    
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpfusuario() {
        return cpfusuario;
    }

    public void setCpfusuario(String cpfusuario) {
        this.cpfusuario = cpfusuario;
    }

    public float getRipple() {
        return ripple;
    }

    public void setRipple(float ripple) {
        this.ripple = ripple;
    }

    public float getEthereum() {
        return ethereum;
    }

    public void setEthereum(float ethereum) {
        this.ethereum = ethereum;
    }

    public float getBitcoin() {
        return bitcoin;
    }

    public void setBitcoin(float bitcoin) {
        this.bitcoin = bitcoin;
    }

    public float getReais() {
        return reais;
    }

    public void setReais(float reais) {
        this.reais = reais;
    }

    public float getTransacao() {
        return transacao;
    }

    public void setTransacao(float transacao) {
        this.transacao = transacao;
    }

    public float getTaxa() {
        return taxa;
    }

    public void setTaxa(float taxa) {
        this.taxa = taxa;
    }

    public float getCotacao() {
        return cotacao;
    }

    public void setCotacao(float cotacao) {
        this.cotacao = cotacao;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }
    

    
    
}
