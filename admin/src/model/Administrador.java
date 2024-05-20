/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Sebastian
 */
public class Administrador {
    private String cpf, senha,cpflogado, nome,cpfusuario;
    
    

    public Administrador() {
    }

    public Administrador( String cpf, String senha,String nome) {
        this.cpf = cpf;
        this.senha = senha;
        this.nome = nome;
        
        
    }
    
    public Administrador(String cpfusuario) {
        this.cpfusuario = cpfusuario;
    }

    
    

    public Administrador(String cpf, String senha) {
        this.cpf = cpf;
        this.senha = senha;
       
    }

    public String getCpflogado() {
        return cpflogado;
    }

    public void setCpflogado(String cpflogado) {
        this.cpflogado = cpflogado;
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

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Usuario{"  + ", senha=" + senha + '}';
                
    }
    
}


