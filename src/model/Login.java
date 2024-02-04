/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Vinícius  Pires de Morais
 */
public class Login {
    private String nome, email,CPF,usuario,senha,cargo;

    public Login(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }
    public void Cadastrar (String nome,String CPF, String email,String cargo,String usuario, String senha){
        this.nome =  nome;
        this.CPF =  CPF;
        this.email = email;
        this.cargo = cargo;
        this.usuario = usuario;
        this.senha = senha;
       
   }
    

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
    
}