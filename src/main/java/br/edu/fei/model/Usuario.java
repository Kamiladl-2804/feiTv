/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.model;

/**
 *
 * @author kamil
 * 
 * Modelo que representa o usuario no programa que serve para cadastro e login
 */
public class Usuario {

    private int id; //ID de usuario
    private String nome; // nome do usuario
    
    private String email; // e-mail do usuario
    
    private String senha;// senha do usuario

    //construtor vazio
    public Usuario() {
    }

    //construtor de usuario completo com nome, e-mail e senha
    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;}

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }}
