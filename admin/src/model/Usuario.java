/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Sebastian
 */
public class Usuario {
    
    
    private String cpf, senha,cpflogado, nome;
    private float ripple, ethereum, bitcoin, reais, ValorDeposito, compra, cotacao,saldo,saldocripto;
    private double saldonovobrl,saldonovocripto;
    
    

    public Usuario() {
    }

    public Usuario( String cpf, String senha,String nome, float ripple, float ethereum,
            float bitcoin, float reais) {
        this.cpf = cpf;
        this.senha = senha;
        this.nome = nome;
        this.ripple = ripple;
        this.ethereum = ethereum;
        this.bitcoin = bitcoin;
        this.reais = reais;
    }

    public Usuario(String cpflogado) {
        this.cpflogado = cpflogado;
    }
    

    public Usuario(String cpf, String senha) {
        this.cpf = cpf;
        this.senha = senha;
       
    }
    public Usuario(float ValorDeposito, String cpflogado){
        this.ValorDeposito = ValorDeposito;
        this.cpflogado = cpflogado;
    }

    public Usuario(String cpflogado, float compra, float cotacao, float reais,float saldocripto) {
        this.cpflogado = cpflogado;
        this.compra = compra;
        this.cotacao = cotacao;
        this.reais = reais;
        this.saldocripto = saldocripto;
    }

    

    public double getSaldonovobrl() {
        return saldonovobrl;
    }

    public double getSaldonovocripto() {
        return saldonovocripto;
    }
    
    
    
    

    public String getCpflogado() {
        return cpflogado;
    }

    public void setCpflogado(String cpflogado) {
        this.cpflogado = cpflogado;
    }

    public float getValorDeposito() {
        return ValorDeposito;
    }

    public float getSaldo() {
        return saldo;
    }

    public float getSaldocripto() {
        return saldocripto;
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

    public String getNome() {
        return nome;
    }

    public float getCompra() {
        return compra;
    }

    public float getCotacao() {
        return cotacao;
    }
    

    @Override
    public String toString() {
        return "Usuario{"  + ", senha=" + senha + '}';
                
    }
    
}