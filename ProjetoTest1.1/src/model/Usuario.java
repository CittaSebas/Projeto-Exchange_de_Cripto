/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author citta
 */
public class Usuario {
    
    
    private String cpf, senha,cpflogado;
    private float ripple, ethereum, bitcoin, reais, ValorDeposito;
    

    public Usuario() {
    }

    public Usuario( String cpf, String senha, float ripple, float ethereum,
            float bitcoin, float reais) {
        this.cpf = cpf;
        this.senha = senha;
        this.ripple = ripple;
        this.ethereum = ethereum;
        this.bitcoin = bitcoin;
        this.reais = reais;
    }

    public Usuario(String cpf, String senha) {
        this.cpf = cpf;
        this.senha = senha;
       
    }
    public Usuario(float ValorDeposito, String cpflogado){
        this.ValorDeposito = ValorDeposito;
        this.cpflogado = cpflogado;
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

    public void setValorDeposito(float ValorDeposito) {
        this.ValorDeposito = ValorDeposito;
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

    @Override
    public String toString() {
        return "Usuario{" + "CPF =" + cpf + ", senha=" + senha + '}';
    }
    
}
